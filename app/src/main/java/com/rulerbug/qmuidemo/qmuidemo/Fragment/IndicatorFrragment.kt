package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.example.indicator.indicator.Fragment.ItemFragment
import com.qmuiteam.qmui.widget.QMUITabSegment
import com.rulerbug.qmuidemo.qmuidemo.Adapter.QMUIFragmentPagerAdapter
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R

class IndicatorFrragment : BaseFragment() {
    override fun init() {
        initData()
        initAdapter()
    }

    var vp: ViewPager? = null
    var tabs: QMUITabSegment? = null
    var titles: List<String>? = null
    var fragments: List<Fragment>? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_indicator
    }

    override fun initViews(rootView: View) {
        vp = rootView.findViewById<ViewPager>(R.id.vp)
        tabs = rootView.findViewById<QMUITabSegment>(R.id.tabs)
        tabs!!.setMode(QMUITabSegment.MODE_SCROLLABLE);
    }

    private fun initData() {
        titles = ArrayList()
        for (i in 1..10) {
            (titles as ArrayList<String>).add("Item-" + i)
        }
        fragments = ArrayList()
        for (title in titles as ArrayList<String>) {
            (fragments as ArrayList<Fragment>).add(ItemFragment.getInstence(title))
        }
    }

    private fun initAdapter() {
        val pagerAdapter = object : QMUIFragmentPagerAdapter(childFragmentManager) {
            override fun createFragment(position: Int): Fragment {
                return fragments!!.get(position)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return titles!![position]
            }

            override fun getCount(): Int {
                return titles!!.size
            }

        }
        vp!!.setAdapter(pagerAdapter)
        tabs!!.setupWithViewPager(vp)
    }

}