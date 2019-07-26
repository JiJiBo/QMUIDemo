package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.design.widget.BottomSheetDialog
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.example.indicator.indicator.Fragment.ItemFragment
import com.qmuiteam.qmui.widget.QMUIProgressBar
import com.qmuiteam.qmui.widget.QMUITabSegment
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
import com.rulerbug.qmuidemo.qmuidemo.Adapter.QMUIFragmentPagerAdapter
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R

class ProgressBarFragment : BaseFragment() {
    var pb = 0
    override fun init() {
        pbRect!!.setQMUIProgressBarTextGenerator(QMUIProgressBar.QMUIProgressBarTextGenerator { progressBar, value, maxValue -> value.toString() + "/" + maxValue })
        pbCircle!!.setQMUIProgressBarTextGenerator(QMUIProgressBar.QMUIProgressBarTextGenerator { progressBar, value, maxValue -> value.toString() + "/" + maxValue })
        mHandler.sendEmptyMessage(0)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_progressbar
    }

    var pbRect: QMUIProgressBar? = null
    var pbCircle: QMUIProgressBar? = null

    override fun initViews(rootView: View) {
        pbRect = rootView.findViewById(R.id.pb_rect);
        pbCircle = rootView.findViewById(R.id.pb_circle);
    }

    var mHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg!!.what) {
                0 -> {
                    if (pb > 100) {
                        removeMessages(0)
                        return
                    }
                    pbRect!!.progress = pb
                    pbCircle!!.progress = pb
                    pb+=4
                    sendEmptyMessageDelayed(0, 70)
                }
            }
        }
    }
}