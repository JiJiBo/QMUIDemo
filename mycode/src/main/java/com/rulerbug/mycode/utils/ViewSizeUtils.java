package com.rulerbug.mycode.utils;

import android.animation.ObjectAnimator;
import android.view.View;


public class ViewSizeUtils {
    public static void changeSize(View v, float percent) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(v, "scaleX", percent);
        scaleX.setDuration(200);//时间
        scaleX.start();
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(v, "scaleY", percent);
        scaleY.setDuration(200);//时间
        scaleY.start();
    }


}
