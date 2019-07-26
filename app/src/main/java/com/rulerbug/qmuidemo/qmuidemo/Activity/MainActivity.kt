package com.rulerbug.qmuidemo.qmuidemo.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.rulerbug.qmuidemo.qmuidemo.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
        initAdapter()
        initClick()
    }

    private fun initClick() {
        lv!!.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var flag: Int = DetailActivity.BUTTON_FLAG


                when (position) {
                    0 -> {
                        flag = DetailActivity.BUTTON_FLAG
                    }
                    1 -> {
                        flag = DetailActivity.INDICATOR_FLAG
                    }
                    2 -> {
                        flag = DetailActivity.EDITTEXT_DIALOG_FLAG
                    }
                    3 -> {
                        flag = DetailActivity.DIALOG_FLAG
                    }
                    4 -> {
                        flag = DetailActivity.TONG_ZHI_FLAG
                    }
                    5 -> {
                        flag = DetailActivity.DI_TU_FLAG
                    }
                    6 -> {
                        flag = DetailActivity.FLOAT_LAYOUT_FRAGMENT_FLAG
                    }
                    7 -> {
                        flag = DetailActivity.PROGRESS_BAR_FLAG
                    }
                    8 -> {
                        flag = DetailActivity.SHEET_FLAG
                    }
                    9 -> {
                        flag = DetailActivity.GROUP_LISTVIEW_FLAG
                    }
                    10 -> {
                        flag = DetailActivity.ALERT_TIP_FLAG
                    }
                    11 -> {
                        flag = DetailActivity.EMPTYVIEW_FLAG
                    }
                    12 -> {
                        flag = DetailActivity.RADIUS_IMMAGEVIEW_FLAG
                    }
                    13-> {
                        flag = DetailActivity.TEXTVIEW_FLAG
                    }
                    14-> {
                        flag = DetailActivity.REFRESH_FLAG
                    }
                }
                DetailActivity.actionStart(this@MainActivity, flag)
            }

        }
    }

    var arrayAdapter: ArrayAdapter<String>? = null
    private fun initAdapter() {
        arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, datas)
        lv!!.adapter = arrayAdapter
    }

    var datas: Array<String>? = null
    private fun initData() {

        datas = arrayOf("按钮", "indicator", "有输入框的对话框", "对话框", "通知", "地图", "FLOAT_LAYOUT", "进度条", "sheet", "groupListview",
                "消息提示", "emptyView", "RadiusImageView","textview","refreshView")
    }

    var lv: ListView? = null
    private fun initView() {

        lv = findViewById(R.id.lv)
    }
}
