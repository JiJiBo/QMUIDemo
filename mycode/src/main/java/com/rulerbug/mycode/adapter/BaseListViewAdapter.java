package com.rulerbug.mycode.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rulerbug.mycode.manager.ThreadManager;

import java.util.ArrayList;

public abstract class BaseListViewAdapter<T> extends BaseAdapter {
    protected static final int STATE_NOR = 0;
    protected static final int STATE_LAST = 1;

    private final ArrayList<T> data;
    protected final Context mc;
    private TextView mRootView;

    public BaseListViewAdapter(ArrayList<T> data, Context mc) {
        this.data = data;
        this.mc = mc;
    }


    @Override
    public int getCount() {
        return data.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < data.size()) {
            return STATE_NOR;
        } else {
            return getInnerType();
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder holder;
        if (convertView == null) {

            if (getItemViewType(position) == STATE_NOR) {
                holder = getHolder(convertView);
            } else {
                holder = new MoreHolder(mc);
            }
        } else {
            holder = (BaseViewHolder) convertView.getTag();
        }

        if (getItemViewType(position) == STATE_NOR) {
            T data = getItem(position);
            holder.setData(data);
        } else {
//            LogUtils.e("加载更多");
            mRootView = (TextView) holder.getRootView();
            if (getCount() == 0) {
                loadMore(position);
            } else {
                loadMore(position - 1);
            }
        }
        return holder.getRootView();
    }

    protected void loadMore(final int id) {
        ThreadManager.getInstance().execute(new Runnable() {
                                                @Override
                                                public void run() {
                                                    ArrayList list = LoadMoreData(id);
                                                    if (list == null) {
                                                        mHandler.sendEmptyMessage(0);
                                                    } else {
                                                        mHandler.sendEmptyMessage(1);
                                                        data.addAll(list);
                                                    }
                                                }
                                            }
        );
    }

    protected abstract ArrayList LoadMoreData(int id);

    public abstract BaseViewHolder getHolder(View convertView);

    public int getInnerType() {
        return STATE_LAST;
    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mRootView.setText(getNullText());
                    break;
                case 1:
                    mRootView.setText("加载更多.......");
                    notifyDataSetChanged();
                    break;
            }
        }


    };

    protected String getNullText() {
        return "没有更多";
    }
}
