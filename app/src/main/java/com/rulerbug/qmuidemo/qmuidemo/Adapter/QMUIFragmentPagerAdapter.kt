package com.rulerbug.qmuidemo.qmuidemo.Adapter

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.view.ViewGroup
import com.qmuiteam.qmui.widget.QMUIPagerAdapter


abstract class QMUIFragmentPagerAdapter(private val mFragmentManager: FragmentManager) : QMUIPagerAdapter() {
    private var mCurrentTransaction: FragmentTransaction? = null
    private var mCurrentPrimaryItem: Fragment? = null

    abstract fun createFragment(position: Int): Fragment

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === (`object` as Fragment).view
    }

    @SuppressLint("CommitTransaction")
    override fun hydrate(container: ViewGroup, position: Int): Any {
        val name = makeFragmentName(container.id, position.toLong())
        if (mCurrentTransaction == null) {
            mCurrentTransaction = mFragmentManager.beginTransaction()
        }
        val fragment = mFragmentManager.findFragmentByTag(name)
        return fragment ?: createFragment(position)
    }

    @SuppressLint("CommitTransaction")
    override fun populate(container: ViewGroup, item: Any, position: Int) {
        val name = makeFragmentName(container.id, position.toLong())
        if (mCurrentTransaction == null) {
            mCurrentTransaction = mFragmentManager.beginTransaction()
        }
        var fragment = mFragmentManager.findFragmentByTag(name)
        if (fragment != null) {
            mCurrentTransaction!!.attach(fragment)
            if (fragment.view != null && fragment.view!!.width == 0) {
                fragment.view!!.requestLayout()
            }
        } else {
            fragment = item as Fragment
            mCurrentTransaction!!.add(container.id, fragment, name)
        }
        if (fragment !== mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false)
            fragment.userVisibleHint = false
        }
    }

    @SuppressLint("CommitTransaction")
    override fun destroy(container: ViewGroup, position: Int, `object`: Any) {
        if (mCurrentTransaction == null) {
            mCurrentTransaction = mFragmentManager.beginTransaction()
        }
        mCurrentTransaction!!.detach(`object` as Fragment)
    }

    override fun startUpdate(container: ViewGroup) {
        if (container.id == View.NO_ID) {
            throw IllegalStateException("ViewPager with adapter " + this
                    + " requires a view id")
        }
    }

    override fun finishUpdate(container: ViewGroup) {
        if (mCurrentTransaction != null) {
            mCurrentTransaction!!.commitNowAllowingStateLoss()
            mCurrentTransaction = null
        }
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        val fragment = `object` as Fragment
        if (fragment !== mCurrentPrimaryItem) {
            if (mCurrentPrimaryItem != null) {
                mCurrentPrimaryItem!!.setMenuVisibility(false)
                mCurrentPrimaryItem!!.userVisibleHint = false
            }
            fragment.setMenuVisibility(true)
            fragment.userVisibleHint = true
            mCurrentPrimaryItem = fragment
        }
    }

    private fun makeFragmentName(viewId: Int, id: Long): String {
        return "QMUIFragmentPagerAdapter:$viewId:$id"
    }
}