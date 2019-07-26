package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.DefaultItemAnimator
import android.util.Log
import android.widget.LinearLayout
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout
import kotlin.math.log


class RefreshViewFragment : BaseFragment() {
    override fun init() {

        initData()
        initAdapter()



        refresh!!.setOnPullListener(object : QMUIPullRefreshLayout.OnPullListener {
            override fun onMoveRefreshView(offset: Int) {
            }

            override fun onRefresh() {
                refresh!!.postDelayed(object : Runnable {
                    override fun run() {
                        addData()
                        adapter.notifyDataSetChanged()
                        refresh!!.finishRefresh()
                    }

                }, 1000)

            }

            override fun onMoveTarget(offset: Int) {
            }

        })
    }

    var adapter = MyAdapter()
    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        rv!!.setLayoutManager(layoutManager)
        rv!!.adapter = adapter
        rv!!.setItemAnimator(DefaultItemAnimator())
    }


    val datas = ArrayList<String>()
    fun initData() {
        for (i in 1..100) {
            datas.add("data_item--" + i)
        }
    }

    fun addData() {
        for (i in 100..106) {
            datas.add(0, "data_item--" + i)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_refreshview
    }

    var rv: RecyclerView? = null
    var refresh: QMUIPullRefreshLayout? = null
    override fun initViews(rootView: View) {
        rv = rootView.findViewById(R.id.rv)
        refresh = rootView.findViewById(R.id.refresh)
    }

    inner class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
            val layout = LinearLayout(context)
            return MyViewHolder(layout)

        }

        override fun getItemCount(): Int {
            return datas.size
        }

        override fun onBindViewHolder(vh: MyViewHolder, p1: Int) {
            vh.tv!!.setText(datas.get(p1))
        }

        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var tv: TextView? = null

            init {
                tv = TextView(context)
                tv!!.setTextSize(18f)
                tv!!.setTextColor(Color.BLACK)
                (view as LinearLayout).addView(tv)
            }
        }
    }
}