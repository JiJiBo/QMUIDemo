package com.rulerbug.qmuidemo.qmuidemo.Application

import android.app.Application
import com.baidu.mapapi.SDKInitializer

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SDKInitializer.initialize(this)
    }

}