package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupWindow
import android.widget.Toast
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.popup.QMUIListPopup
import com.qmuiteam.qmui.widget.popup.QMUIPopup
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R
import com.rulerbug.qmuidemo.qmuidemo.Utils.ToastUtils
import java.util.*

class PopUpFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bt_normal -> {
                normalPop!!.setAnimStyle(QMUIPopup.ANIM_GROW_FROM_CENTER)
                normalPop!!.setPreferredDirection(QMUIPopup.DIRECTION_TOP)
                normalPop!!.show(v)
            }
            R.id.bt_list -> {
                mListPopup!!.setAnimStyle(QMUIPopup.ANIM_GROW_FROM_CENTER)
                mListPopup!!.setPreferredDirection(QMUIPopup.DIRECTION_TOP)
                mListPopup!!.show(v)
            }
        }
    }

    var normalPop: QMUIPopup? = null
    override fun init() {
        initPopUpFirst()
        initListPopupIfNeed()
        mBtNormal!!.setOnClickListener(this)
        mBtList!!.setOnClickListener(this)
    }

    fun initPopUpFirst() {

        if (normalPop == null) {
            normalPop = QMUIPopup(context, QMUIPopup.DIRECTION_BOTTOM)
            normalPop!!.setContentView(R.layout.layout_tv_list)
            normalPop!!.setOnDismissListener(object : PopupWindow.OnDismissListener {
                override fun onDismiss() {
                    ToastUtils.show(context, "消息消失了")
                }
            })
        }
    }

    var mListPopup: QMUIListPopup? = null
    private fun initListPopupIfNeed() {
        if (mListPopup == null) {

            val listItems = arrayOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
            val data = ArrayList<String>()

            Collections.addAll(data, *listItems)

            val adapter = ArrayAdapter(activity, android.R.layout.simple_list_item_1, data)

            mListPopup = QMUIListPopup(context, QMUIPopup.DIRECTION_NONE, adapter)
            mListPopup!!.create(QMUIDisplayHelper.dp2px(context, 250), QMUIDisplayHelper.dp2px(context, 200), object : AdapterView.OnItemClickListener {
                override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    mBtList!!.setText("Item " + (position + 1))
                    mListPopup!!.dismiss()
                }
            })
            mListPopup!!.setOnDismissListener(object : PopupWindow.OnDismissListener {
                override fun onDismiss() {
                    ToastUtils.show(context, "列表消失了")
                }

            })
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_popup
    }

    var mBtNormal: QMUIRoundButton? = null
    var mBtList: QMUIRoundButton? = null

    var windowContentView: View? = null
    override fun initViews(rootView: View) {
        mBtNormal = rootView.findViewById(R.id.bt_normal);
        mBtList = rootView.findViewById(R.id.bt_list);
        windowContentView = View.inflate(context, R.layout.layout_tv_list, null)
    }

}