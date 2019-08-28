package com.rulerbug.mycode.view.SlideDelete;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class SlideDelete extends FrameLayout {

    private ViewDragHelper mViewDragHelper;
    private View mContentView;
    private View mDeleteView;
    private int mScreenWidth;
    private int mScreenHeight;
    private int mDeleteWidth;
    private int mMidRange;
    private final static int CLOSE = 0;
    private final static int OPEN = 1;
    private int state = CLOSE;
    private float downX;
    private float downY;

    public SlideDelete(@NonNull Context context) {
        super(context);
        init();
    }

    public SlideDelete(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public SlideDelete(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SlideDelete(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, callback);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mContentView = getChildAt(0);
        mDeleteView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mScreenWidth = getMeasuredWidth();
        mScreenHeight = getMeasuredHeight();
        mDeleteWidth = mDeleteView.getMeasuredWidth();
        mMidRange = mScreenWidth - mDeleteWidth / 2;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mContentView.layout(left, top, left + mScreenWidth, top + mScreenHeight);
        mDeleteView.layout(mContentView.getRight(), top, mContentView.getRight() + mDeleteWidth, top + mScreenHeight);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean result = mViewDragHelper.shouldInterceptTouchEvent(ev);
        if (!SlideDeleteManager.getInstence().hadOpen(SlideDelete.this)) {
            SlideDeleteManager.getInstence().closeCurrentSlideDelete();
            result = true;
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!SlideDeleteManager.getInstence().hadOpen(this)) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //1.获取x和y方向移动的距离
                float moveX = event.getX();
                float moveY = event.getY();
                float delatX = moveX - downX;//x方向移动的距离
                float delatY = moveY - downY;//y方向移动的距离
                if (Math.abs(delatX) > Math.abs(delatY)) {
                    //表示移动是偏向于水平方向，那么应该SwipeLayout应该处理，请求listview不要拦截
                    requestDisallowInterceptTouchEvent(true);
                }
                //更新downX，downY
                downX = moveX;
                downY = moveY;
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(@NonNull View view, int i) {
            return view == mDeleteView || view == mContentView;
        }

        public int getViewHorizontalDragRange(View child) {
            return (int) mScreenWidth;
        }

        ;

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (child == mContentView) {
                if (left < -mDeleteWidth) {
                    left = -mDeleteWidth;
                }
                if (left > 0) {
                    left = 0;
                }
            }
            if (child == mDeleteView) {
                if (left < mScreenWidth - mDeleteWidth) {
                    left = mScreenWidth - mDeleteWidth;
                }
                if (left > mScreenWidth) {
                    left = mScreenWidth;
                }
            }
            return left;
        }

        @Override
        public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
            if (changedView == mContentView) {
                mContentView.layout(left, top, mScreenWidth + left, top + mScreenHeight);
                int newLeft = left + mScreenWidth;
                mDeleteView.layout(newLeft, top, newLeft + mDeleteWidth, top + mScreenHeight);
            }
            if (changedView == mDeleteView) {
                mDeleteView.layout(left, top, mScreenWidth + left, top + mScreenHeight);
                int newLeft = left - mScreenWidth;
                mContentView.layout(newLeft, top, newLeft + mScreenWidth, top + mScreenHeight);
            }
            if (mContentView.getLeft() == -mDeleteWidth && state == CLOSE) {
                state = OPEN;
                SlideDeleteManager.getInstence().regist_a_open(SlideDelete.this);
            }
            if (mContentView.getLeft() == 0 && state == OPEN) {
                state = CLOSE;
                SlideDeleteManager.getInstence().remove_a_open();
            }
            super.onViewPositionChanged(changedView, left, top, dx, dy);
        }

        @Override
        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if (state == CLOSE) {
                close();
            } else {
                open();
            }
            if (xvel > 200 && Math.abs(xvel) > Math.abs(yvel)) {
                open();
            }
            if (xvel < -200 && Math.abs(xvel) > Math.abs(yvel)) {
                close();
            }
        }
    };

    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(SlideDelete.this);
        }
        super.computeScroll();
    }

    public void close() {
        mViewDragHelper.smoothSlideViewTo(mContentView, 0, mContentView.getTop());
        ViewCompat.postInvalidateOnAnimation(SlideDelete.this);

    }

    public void open() {
        mViewDragHelper.smoothSlideViewTo(mContentView, (int) -mDeleteWidth,
                mContentView.getTop());
        ViewCompat.postInvalidateOnAnimation(SlideDelete.this);
    }

}
