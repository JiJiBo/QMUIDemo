package com.rulerbug.qmuidemo.qmuidemo.Utils;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

public class as {
    public static void main(String[] args) {
//        show();
    }
//
//    private static void show() {
//        QMUICommonListItemView normalItem = mGroupListView.createItemView("Item 1");
//        normalItem.setOrientation(QMUICommonListItemView.VERTICAL); //默认文字在左边
//
//        QMUICommonListItemView itemWithDetail = mGroupListView.createItemView("Item 2");
//        itemWithDetail.setDetailText("在右方的详细信息");//默认文字在左边   描述文字在右边
//
//        QMUICommonListItemView itemWithDetailBelow = mGroupListView.createItemView("Item 3");
//        itemWithDetailBelow.setOrientation(QMUICommonListItemView.VERTICAL);
//        itemWithDetailBelow.setDetailText("在标题下方的详细信息");//默认文字在左边   描述文字在标题下边
//
//        QMUICommonListItemView itemWithChevron = mGroupListView.createItemView("Item 4");
//        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);//默认文字在左边   右侧更多按钮
//
//
//        QMUICommonListItemView itemWithSwitch = mGroupListView.createItemView("Item 5");
//        itemWithSwitch.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
//        itemWithSwitch.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(context, "checked = " + isChecked, Toast.LENGTH_SHORT).show();
//            }
//        });//默认文字在左边   右侧选择按钮
//        QMUICommonListItemView itemWithCustom = mGroupListView.createItemView("Item 6");
//        itemWithCustom.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CUSTOM);
//        QMUILoadingView loadingView = new QMUILoadingView(context);
//        itemWithCustom.addAccessoryCustomView(loadingView);
//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v instanceof QMUICommonListItemView) {
//                    CharSequence text = ((QMUICommonListItemView) v).getText();
//                    Toast.makeText(context, text + " is Clicked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        };//默认文字在左边   自定义加载框按钮
//
//        QMUIGroupListView.newSection(context)
//                .setTitle("Section 1: 默认提供的样式")
//                .setDescription("Section 1 的描述")
//                .addItemView(normalItem, onClickListener)
//                .addItemView(itemWithDetail, onClickListener)
//                .addItemView(itemWithDetailBelow, onClickListener)
//                .addItemView(itemWithChevron, onClickListener)
//                .addItemView(itemWithSwitch, onClickListener)
//                .addTo(mGroupListView);
//
//        QMUIGroupListView.newSection(context)
//                .setTitle("Section 2: 自定义右侧 View")
//                .addItemView(itemWithCustom, onClickListener)
//                .addTo(mGroupListView);
//    }

}
