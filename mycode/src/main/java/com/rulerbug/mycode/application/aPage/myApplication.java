package com.rulerbug.mycode.application.aPage;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class myApplication extends Application {
	private static Handler mHandler;
	private static int myTid;
	private static Context mc;

	@Override
	public void onCreate() {
		super.onCreate();
		mHandler = new Handler();
		myTid = android.os.Process.myTid();
		mc = getApplicationContext();
	}

	public static Handler getmHandler() {
		return mHandler;
	}

	public static int getMyTid() {
		return myTid;
	}

	public static Context getMc() {
		return mc;
	}

}
