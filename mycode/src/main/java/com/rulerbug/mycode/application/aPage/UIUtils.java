package com.rulerbug.mycode.application.aPage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;


public class UIUtils {
	// 3个基本操作
	public static Context getContext() {
		return myApplication.getMc();
	}

	public static int getTheardId() {
		return myApplication.getMyTid();
	}

	public static Handler getHandler() {
		return myApplication.getmHandler();
	}

	// 其他操作
	public static String[] getStringArray(int id) {
		return getContext().getResources().getStringArray(id);
	}

	public static String getString(int id) {
		return getContext().getResources().getString(id);
	}

	public static Drawable getDrawable(int id) {
		return getContext().getResources().getDrawable(id);
	}

	public static int getColor(int id) {
		return getContext().getResources().getColor(id);
	}

	public static int getDimension(int id) {
		return getContext().getResources().getDimensionPixelSize(id);
	}

	public static ColorStateList getColorStateList(int id) {
		return getContext().getResources().getColorStateList(id);
	}

	// 像素转换
	public static float px2dip(int px) {
		float density = getContext().getResources().getDisplayMetrics().density;
		return px / density;
	}

	public static int dip2px(int dp) {
		float density = getContext().getResources().getDisplayMetrics().density;
		return (int) (dp * density + 0.5f);
	}

	// 加载布局
	public static View inflate(int id) {
		return View.inflate(getContext(), id, null);
	}

	public static boolean isRunOnUIThread() {
		int mTid = android.os.Process.myTid();
		if (mTid == getTheardId()) {
			return true;
		}
		return false;
	}

	public static void RunOnUIThread(Runnable r) {
		if (isRunOnUIThread()) {
			r.run();
		} else {
			getHandler().post(r);
		}
	}
}
