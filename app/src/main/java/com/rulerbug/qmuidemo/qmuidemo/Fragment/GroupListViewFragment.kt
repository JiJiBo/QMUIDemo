package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.example.indicator.indicator.Fragment.ItemFragment
import com.qmuiteam.qmui.widget.QMUILoadingView
import com.qmuiteam.qmui.widget.QMUITabSegment
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView
import com.rulerbug.qmuidemo.qmuidemo.Adapter.QMUIFragmentPagerAdapter
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R

class GroupListViewFragment : BaseFragment() {
    override fun init() {
        show()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_group_listview
    }

    var mGroupListView: QMUIGroupListView? = null
    override fun initViews(rootView: View) {
        mGroupListView = rootView.findViewById(R.id.groupListView);
    }

    private fun show() {
        val normalItem = mGroupListView!!.createItemView("Item 1")
        normalItem.orientation = QMUICommonListItemView.VERTICAL //默认文字在左边

        val itemWithDetail = mGroupListView!!.createItemView("Item 2")
        itemWithDetail.detailText = "在右方的详细信息"//默认文字在左边   描述文字在右边

        val itemWithDetailBelow = mGroupListView!!.createItemView("Item 3")
        itemWithDetailBelow.orientation = QMUICommonListItemView.VERTICAL
        itemWithDetailBelow.detailText = "在标题下方的详细信息"//默认文字在左边   描述文字在标题下边

        val itemWithChevron = mGroupListView!!.createItemView("Item 4")
        itemWithChevron.accessoryType = QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON//默认文字在左边   右侧更多按钮


        val itemWithSwitch = mGroupListView!!.createItemView("Item 5")
        itemWithSwitch.accessoryType = QMUICommonListItemView.ACCESSORY_TYPE_SWITCH
        itemWithSwitch.switch.setOnCheckedChangeListener { buttonView, isChecked -> Toast.makeText(context, "checked = $isChecked", Toast.LENGTH_SHORT).show() }//默认文字在左边   右侧选择按钮

        val itemWithCustom = mGroupListView!!.createItemView("Item 6")
        itemWithCustom.accessoryType = QMUICommonListItemView.ACCESSORY_TYPE_CUSTOM
        val loadingView = QMUILoadingView(context)
        itemWithCustom.addAccessoryCustomView(loadingView)

        val onClickListener = View.OnClickListener { v ->
            if (v is QMUICommonListItemView) {
                val text = v.text
                Toast.makeText(context, text.toString() + " is Clicked", Toast.LENGTH_SHORT).show()
            }
        }//默认文字在左边   自定义加载框按钮

        QMUIGroupListView.newSection(context)
                .setTitle("Section 1: 默认提供的样式")
                .setDescription("Section 1 的描述")
                .addItemView(normalItem, onClickListener)
                .addItemView(itemWithDetail, onClickListener)
                .addItemView(itemWithDetailBelow, onClickListener)
                .addItemView(itemWithChevron, onClickListener)
                .addItemView(itemWithSwitch, onClickListener)
                .addTo(mGroupListView)

        QMUIGroupListView.newSection(context)
                .setTitle("Section 2: 自定义右侧 View")
                .addItemView(itemWithCustom, onClickListener)
                .addTo(mGroupListView)

    }


}