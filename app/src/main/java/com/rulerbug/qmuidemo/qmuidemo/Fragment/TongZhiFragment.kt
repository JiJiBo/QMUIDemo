package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v4.app.NotificationCompat
import android.view.View
import com.rulerbug.qmuidemo.qmuidemo.Activity.MainActivity
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R
import java.util.*
import kotlin.collections.RandomAccess

class TongZhiFragment : BaseFragment() {
    override fun init() {
        //得到通知管理器
        val nm: NotificationManager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //点击时执行的intent
        val intent = Intent(context, MainActivity::class.java)
        //给通知用的延迟intent(可以这么看)，包含上面的intent，实际执行的是上面的intent，第二个和第四个参数一般为0
        val pending = PendingIntent.getActivity(context!!, 0, intent, 0)
        //创建一个通知
        val builder = NotificationCompat.Builder(context!!)
        //设置信息
        builder.setContentTitle("标题")
        builder.setContentText("短文本")
        builder.setWhen(System.currentTimeMillis())
        builder.setContentIntent(pending)
        builder.setSmallIcon(R.drawable.ic_small)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_large))
        //点击后自动消失
        builder.setAutoCancel(true)
        builder.setStyle(NotificationCompat.BigTextStyle().bigText("这里是设置长文本，字数很多，设置复杂，"))
        //设置效果
        builder.setDefaults(NotificationCompat.DEFAULT_ALL)
        //得到实力
        val build = builder.build()
        //显示通知
        nm.notify(Random().nextInt(), build)
//        //删除通知
//        nm.cancel(10086)

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_item
    }

    override fun initViews(rootView: View) {
    }

}