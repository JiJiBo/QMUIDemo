package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.content.DialogInterface
import android.graphics.Color
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.QMUIFloatLayout
import com.qmuiteam.qmui.widget.QMUITopBarLayout
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R


class FloatLayoutFragment : BaseFragment(), View.OnClickListener {


    override fun getLayoutId(): Int {
        return R.layout.fragment_floatlayout
    }

    var btAdd: QMUIRoundButton? = null
    var btLeft: QMUIRoundButton? = null
    var btMid: QMUIRoundButton? = null
    var btRight: QMUIRoundButton? = null
    var btReduce: QMUIRoundButton? = null
    var btMaxline: QMUIRoundButton? = null
    var btMaxnumber: QMUIRoundButton? = null
    var btFree: QMUIRoundButton? = null
    var mFloatLayout: QMUIFloatLayout? = null
    override fun initViews(rootView: View) {
        mFloatLayout = rootView.findViewById(R.id.qmuidemo_floatlayout)
        btAdd = rootView.findViewById(R.id.bt_add)
        btLeft = rootView.findViewById(R.id.bt_left)
        btMid = rootView.findViewById(R.id.bt_mid)
        btRight = rootView.findViewById(R.id.bt_right)
        btReduce = rootView.findViewById(R.id.bt_reduce)
        btMaxline = rootView.findViewById(R.id.bt_maxline)
        btMaxnumber = rootView.findViewById(R.id.bt_maxnumber)
        btFree = rootView.findViewById(R.id.bt_free)
    }

    override fun init() {
        btAdd!!.setOnClickListener(this)
        btLeft!!.setOnClickListener(this)
        btMid!!.setOnClickListener(this)
        btRight!!.setOnClickListener(this)
        btReduce!!.setOnClickListener(this)
        btMaxline!!.setOnClickListener(this)
        btMaxnumber!!.setOnClickListener(this)
        btFree!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_add -> addItemToFloatLayout()
            R.id.bt_left -> mFloatLayout!!.gravity = Gravity.LEFT
            R.id.bt_mid -> mFloatLayout!!.gravity = Gravity.CENTER_HORIZONTAL
            R.id.bt_right -> mFloatLayout!!.gravity = Gravity.RIGHT
            R.id.bt_reduce -> removeItemFromFloatLayout()
            R.id.bt_maxline -> mFloatLayout!!.maxLines = 1;
            R.id.bt_maxnumber -> mFloatLayout!!.maxNumber = 4
            R.id.bt_free -> mFloatLayout!!.maxLines = Int.MAX_VALUE
        }
    }

    fun addItemToFloatLayout() {
        val currentChildCount = mFloatLayout!!.childCount
        val textView = TextView(context)
        textView.gravity = Gravity.CENTER
        val textViewPadding = QMUIDisplayHelper.dpToPx(4)
        textView.setPadding(textViewPadding, textViewPadding, textViewPadding, textViewPadding)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        textView.setBackgroundColor(0xffddffcc.toInt())
        val textSize = QMUIDisplayHelper.dpToPx(60)
        textView.setTextColor(Color.BLACK)
        textView.text = currentChildCount.toString() + ""
        val lp = ViewGroup.LayoutParams(textSize, textSize)
        mFloatLayout!!.addView(textView, lp)
    }

    fun removeItemFromFloatLayout() {
        if (mFloatLayout!!.childCount == 0) {
            return
        }
        mFloatLayout!!.removeView(mFloatLayout!!.getChildAt(mFloatLayout!!.childCount - 1))
    }
}