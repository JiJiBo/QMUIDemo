package com.rulerbug.mycode.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeUtil {
    public static String getTimeString() {
        String timeStr = null;
        String reg = "yyyy年MM月dd日";
        long time = System.currentTimeMillis();
        Date date = new Date();
        date.setTime(time);
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        timeStr = sdf.format(date);
        return timeStr;
    }

    public static String TimeToString(long time) {
        String hs, ms, sss;
        long ss = time % 60;

        long mm = (time - ss) / 60 % 60;
        long hh = (time - ss - mm * 60) / 3600;
        sss = ss + "";
        ms = mm + "";
        hs = hh + "";
        if (hh / 10 == 0)
            hs = "0" + hs;
        if (mm / 10 == 0)
            ms = "0" + ms;
        if (ss / 10 == 0)
            sss = "0" + ss;
        String str = hs + ":" + ms + ":" + sss;
        return str;
    }

    public static String TimeToStringByDay(long time) {
        String ds = get_day(time) + "";
        String hs = get_shi(time) + "";
        String ms = get_fen(time) + "";
        String sss = get_miao(time) + "";
        String str = ds + "天" + hs + ":" + ms + ":" + sss;
        return str;
    }

    private static int get_day(long time) {

        return (int) (time / (3600 * 24));
    }

    public static int get_fen(long time) {
        return (int) (time % (3600) / 60);
    }

    public static int get_shi(long time) {
        return (int) (time % (3600 * 60) / 3600 % 24);
    }

    public static int get_miao(long time) {
        return (int) (time % 60);
    }
}
