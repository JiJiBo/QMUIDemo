package com.rulerbug.mycode.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CacheUtils {
    public static String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "aaa";

    public static void saveStringCache(String str, String name) {
        saveStringCache(str, name, 1000 * 60 * 60 * 24 * 10);
    }

    public static void saveStringCache(String str, String name, long time) {
        saveStringCache(str, name, time, absolutePath);
    }

    public static void saveStringCache(String str, String name, long time, String dirpath) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
//        LogUtils.e("保存缓存");
        String path = dirpath + File.separator + name;
        File file = new File(path);
        try {
            if (!file.exists() || !file.isFile()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //写入有效时间
            bw.write(System.currentTimeMillis() + time + "");
            bw.newLine();
            bw.flush();
            //写入数据
            bw.write(str);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringCache(String name) {

        return getStringCache(name, absolutePath);
    }

    public static String getStringCache(String name, String dirpath) {
        String path = dirpath + File.separator + name;
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            long time = Long.parseLong(br.readLine());
            long now = System.currentTimeMillis();
//            LogUtils.e("距离有效期结束还有"+(time-now)+"毫秒");
            if (now > time) {
                file.delete();
                return null;
            }
            StringBuffer sb = new StringBuffer();
            int len = 0;
            char[] buf = new char[1024];
            while ((len = br.read(buf)) != -1) {
                sb.append(buf, 0, len);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
