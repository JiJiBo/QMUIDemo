package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Toast
import com.example.indicator.indicator.Fragment.ItemFragment
import com.qmuiteam.qmui.widget.QMUITabSegment
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton
import com.rulerbug.qmuidemo.qmuidemo.Adapter.QMUIFragmentPagerAdapter
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R

class QMUIBottomSheetFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_list -> {
                showSimpleBottomSheetList()
            }
            R.id.bt_grid -> {
                showSimpleBottomSheetGrid()
            }
        }
    }

    private fun showSimpleBottomSheetList() {
        QMUIBottomSheet.BottomListSheetBuilder(context)
                .addItem("Item 1")
                .addItem("Item 2")
                .addItem("Item 3")
                .setOnSheetItemClickListener { dialog, itemView, position, tag ->
                    dialog.dismiss()
                    Toast.makeText(context, "Item " + (position + 1), Toast.LENGTH_SHORT).show()
                }
                .build()
                .show()
    }

    private fun showSimpleBottomSheetGrid() {
        val TAG_SHARE_WECHAT_FRIEND = 0
        val TAG_SHARE_WECHAT_MOMENT = 1
        val TAG_SHARE_WEIBO = 2
        val TAG_SHARE_CHAT = 3
        val TAG_SHARE_LOCAL = 4
        QMUIBottomSheet.BottomGridSheetBuilder(context)
                .addItem(R.mipmap.ic_launcher, "分享到微信", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "分享到朋友圈", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "分享到微博", TAG_SHARE_WEIBO, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "分享到私信", TAG_SHARE_CHAT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.ic_launcher, "保存到本地", TAG_SHARE_LOCAL, QMUIBottomSheet.BottomGridSheetBuilder.SECOND_LINE)
                .setOnSheetItemClickListener { dialog, itemView ->
                    dialog.dismiss()
                    val tag = itemView.tag as Int
                    when (tag) {
                        TAG_SHARE_WECHAT_FRIEND -> Toast.makeText(context, "分享到微信", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_WECHAT_MOMENT -> Toast.makeText(context, "分享到朋友圈", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_WEIBO -> Toast.makeText(context, "分享到微博", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_CHAT -> Toast.makeText(context, "分享到私信", Toast.LENGTH_SHORT).show()
                        TAG_SHARE_LOCAL -> Toast.makeText(context, "保存到本地", Toast.LENGTH_SHORT).show()
                    }
                }
                .build().show()
    }

    var btList: QMUIRoundButton? = null
    var btGrid: QMUIRoundButton? = null
    override fun init() {
        btList!!.setOnClickListener(this)
        btGrid!!.setOnClickListener(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_bottom_sheet
    }


    override fun initViews(rootView: View) {


        btList = rootView.findViewById(R.id.bt_list)
        btGrid = rootView.findViewById(R.id.bt_grid)

    }


}