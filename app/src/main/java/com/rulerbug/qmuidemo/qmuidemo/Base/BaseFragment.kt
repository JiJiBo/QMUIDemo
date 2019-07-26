package com.rulerbug.qmuidemo.qmuidemo.Base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open abstract class BaseFragment : Fragment() {
    var parent: ViewGroup? = null
    var mView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            mView = inflater.inflate(getLayoutId(), null);
        }
        parent = mView!!.parent as ViewGroup?
        if (parent != null) {
            parent!!.removeView(mView);
        }
        return mView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(mView!!)
        init()
    }

    open abstract fun init()

    open abstract fun getLayoutId(): Int
    open abstract fun initViews(rootView: View)
}