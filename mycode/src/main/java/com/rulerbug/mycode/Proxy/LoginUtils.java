package com.rulerbug.mycode.Proxy;

import android.content.Intent;

import com.suyuan.print.Activity.LoginActivity;
import com.suyuan.print.Activity.MainActivity;
import com.suyuan.print.Application.App;
import com.suyuan.print.Interface.LoginInterface;

public class LoginUtils implements LoginInterface {
    public void openProductList(long uid) {
        Intent intent = new Intent(App.getContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(UID_KEY, uid);
        App.getContext().startActivity(intent);
    }

    public final static String UID_KEY = "UIDKEY";
    public final static long UID_ADMIN = 100000;
    public final static long UID_USER = -1;

    public static void logint() {
        Intent intent = new Intent(App.getContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.getContext().startActivity(intent);
    }
}
