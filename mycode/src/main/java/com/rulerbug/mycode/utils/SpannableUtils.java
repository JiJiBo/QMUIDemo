package com.rulerbug.mycode.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

public class SpannableUtils {
    //设置文本部分文本颜色
    public static SpannableStringBuilder setColor(String text, int start, int end, int color) {
        SpannableStringBuilder ssb = new SpannableStringBuilder(text);
        ssb.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}
