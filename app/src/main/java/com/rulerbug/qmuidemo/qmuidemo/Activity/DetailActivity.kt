package com.rulerbug.qmuidemo.qmuidemo.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.example.indicator.indicator.Fragment.ItemFragment
import com.rulerbug.qmuidemo.qmuidemo.Fragment.*
import com.rulerbug.qmuidemo.qmuidemo.R
import kotlinx.android.synthetic.main.fragment_group_listview.*

class DetailActivity : AppCompatActivity() {


    var OPEN_TYPE: Int = BUTTON_FLAG
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
        initData()
        openFragment()
    }

    private fun openFragment() {
        var frgamnet: Fragment = ItemFragment.getInstence("错误")
        when (OPEN_TYPE) {
            BUTTON_FLAG -> {
                frgamnet = ButtonFragment()
            }
            INDICATOR_FLAG -> {
                frgamnet = IndicatorFrragment()
            }
            EDITTEXT_DIALOG_FLAG -> {
                frgamnet = EditTextDialogBuilderFragment()
            }
            DIALOG_FLAG -> {
                frgamnet = DialogBuilderFragment()
            }
            TONG_ZHI_FLAG -> {
                frgamnet = TongZhiFragment()
            }
            DI_TU_FLAG -> {
                frgamnet = DiTuFragment()
            }
            FLOAT_LAYOUT_FRAGMENT_FLAG -> {
                frgamnet = FloatLayoutFragment()
            }
            PROGRESS_BAR_FLAG -> {
                frgamnet = ProgressBarFragment()
            }
            SHEET_FLAG -> {
                frgamnet = QMUIBottomSheetFragment()
            }
            GROUP_LISTVIEW_FLAG -> {
                frgamnet = GroupListViewFragment()
            }
            ALERT_TIP_FLAG -> {
                frgamnet = AlertTipFragment()
            }
            EMPTYVIEW_FLAG -> {
                frgamnet = EmptyViewFragment()
            }
            RADIUS_IMMAGEVIEW_FLAG -> {
                frgamnet = RadiusImageViewFragment()
            }
            TEXTVIEW_FLAG -> {
                frgamnet = TextViewFragment()
            }
            REFRESH_FLAG -> {
                frgamnet = RefreshViewFragment()
            }
            POPUP_FLAG -> {
                frgamnet = PopUpFragment()
            }
            FIX_TEXTVIEW_FLAG -> {
                frgamnet = QMUISpanTouchFixTextViewFragment()
            }
        }
        val mannager = supportFragmentManager
        val tronsaction = mannager.beginTransaction()
        tronsaction.replace(R.id.fl_fragment, frgamnet)
        tronsaction.addToBackStack(null)
        tronsaction.commit()

    }

    private fun initData() {

        OPEN_TYPE = intent.getIntExtra(FLAG_KEY, BUTTON_FLAG)
    }

    companion object {
        val BUTTON_FLAG: Int = 100
        val INDICATOR_FLAG: Int = 200
        val EDITTEXT_DIALOG_FLAG: Int = 300
        val DIALOG_FLAG: Int = 400
        val TONG_ZHI_FLAG: Int = 500
        val DI_TU_FLAG: Int = 600
        val FLOAT_LAYOUT_FRAGMENT_FLAG: Int = 700
        val PROGRESS_BAR_FLAG: Int = 800
        val SHEET_FLAG: Int = 900
        val GROUP_LISTVIEW_FLAG: Int = 1000
        val ALERT_TIP_FLAG: Int = 1100
        val EMPTYVIEW_FLAG: Int = 1200
        val RADIUS_IMMAGEVIEW_FLAG: Int = 1300
        val TEXTVIEW_FLAG: Int = 1400
        val REFRESH_FLAG: Int = 1500
        val POPUP_FLAG: Int = 1600
        val FIX_TEXTVIEW_FLAG: Int = 1700
        val FLAG_KEY: String = "FLAG_KEY"
        fun actionStart(mc: Context, flag: Int) {
            val intent = Intent(mc, DetailActivity::class.java)
            intent.putExtra(FLAG_KEY, flag)
            mc.startActivity(intent)
        }
    }

    var fl_fragment: FrameLayout? = null
    private fun initView() {
        fl_fragment = findViewById(R.id.fl_fragment)
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        finish()
    }
}