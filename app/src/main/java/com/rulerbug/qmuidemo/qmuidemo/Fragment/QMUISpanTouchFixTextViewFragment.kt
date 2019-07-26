package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.qmuiteam.qmui.span.QMUITouchableSpan
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R
import com.rulerbug.qmuidemo.qmuidemo.Utils.ToastUtils

class QMUISpanTouchFixTextViewFragment : BaseFragment() {
    override fun init() {
        mFtv!!.setMovementMethodDefault()
        mFtv!!.setNeedForceEventToParent(true)
        mFtv!!.setText(getSpan("DSASADDSA@ruler" + "sdaFSADFASD" + "#bug#DSASDASDA321423421142343243"))
        mRl!!.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                ToastUtils.show(context,"father")
            }

        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_fix_textview
    }

    var mRl: RelativeLayout? = null
    var mFtv: QMUISpanTouchFixTextView? = null
    override fun initViews(rootView: View) {
        mRl = rootView.findViewById(R.id.rl);
        mFtv = rootView.findViewById(R.id.ftv);
    }

    fun getSpan(str: String): SpannableString {
        val heightText = "@ruler"
        val heightText2 = "#bug#"
        val sps = SpannableString(str)
        var start = 0
        var end: Int=0
        var index: Int = 0
        while ({ index = str.indexOf(heightText, start);index }() > -1) {
            end = index + heightText.length
            sps.setSpan(object : QMUITouchableSpan(Color.BLUE, Color.RED, Color.RED, Color.BLUE) {
                override fun onSpanClick(widget: View?) {
                    ToastUtils.show(context, heightText)
                }

            }, index, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            start = end
        }
        start = 0
        while ({ index = str.indexOf(heightText2, start);index }() > -1) {
            end = index + heightText2.length
            sps.setSpan(object : QMUITouchableSpan(Color.BLUE, Color.RED, Color.RED, Color.BLUE) {
                override fun onSpanClick(widget: View?) {
                    ToastUtils.show(context, heightText2)
                }

            }, index, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            start = end
        }
        return sps
    }
}