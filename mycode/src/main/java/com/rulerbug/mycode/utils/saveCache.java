package com.rulerbug.mycode.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class saveCache {

	private static String SPFILENAME = "cacheSp.xml";

	/**
	 * @param mc
	 *            上下文
	 * @param key
	 *            根据此节点找值
	 * @param def
	 *            默认值
	 * @return 返回储存的值
	 */
	public static String getCache(Context mc, String key) {
		SharedPreferences sp = mc.getSharedPreferences(SPFILENAME,
				mc.MODE_PRIVATE);
		return sp.getString(key, "");
	}

	/**
	 * @param mc
	 *            上下文
	 * @param key
	 *            数据所在节点名
	 * @param value
	 *            保存的值
	 */
	public static void putCache(Context mc, String key, String value) {
		Log.d("缓存", "存入");
		SharedPreferences sp = mc.getSharedPreferences(SPFILENAME,
				mc.MODE_PRIVATE);
		sp.edit().putString(key, value).commit();
	}

}
