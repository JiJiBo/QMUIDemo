package com.rulerbug.mycode.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class BootBroadcastReceiver extends BroadcastReceiver {

    private static final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_BOOT)) { //开机启动完成后，要做的事情
            //doing something
        }
    }
}
//<receiver android:name=".Receiver.BootBroadcastReceiver">
//    <intent-filter>
//       <action android:name="android.intent.action.BOOT_COMPLETED" />
//
//       <category android:name="android.intent.category.HOME" />
//   </intent-filter>
//  </receiver>