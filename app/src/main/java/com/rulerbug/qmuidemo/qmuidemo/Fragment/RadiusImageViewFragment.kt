package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.util.Log
import android.view.View
import com.qmuiteam.qmui.widget.QMUIRadiusImageView
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R

class RadiusImageViewFragment : BaseFragment() {
    override fun init() {
        mIv!!.isTouchSelectModeEnabled = false
        mIv!!.selectedMaskColor = 0xffff0000.toInt()
        mIv!!.isSelected = false
        mIv!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                mIv!!.isSelected = if (mIv!!.isSelected) false else true
            }

        })

        mIv2!!.isTouchSelectModeEnabled = true
        mIv2!!.selectedMaskColor = 0xffff0000.toInt()

        mIv3!!.isTouchSelectModeEnabled = false
        mIv3!!.selectedMaskColor = 0xffff0000.toInt()
        mIv3!!.isSelected = true
        mIv3!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                mIv3!!.isSelected = true
            }

        })

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_redius_imageview
    }

    var mIv: QMUIRadiusImageView? = null
    var mIv2: QMUIRadiusImageView? = null
    var mIv3: QMUIRadiusImageView? = null
    override fun initViews(rootView: View) {


        mIv2 = rootView.findViewById(R.id.iv2);
        mIv3 = rootView.findViewById(R.id.iv3);

        mIv = rootView.findViewById(R.id.iv);

    }

}