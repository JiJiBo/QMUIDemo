package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.content.DialogInterface
import android.view.View
import android.widget.*
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R


class AlertTipFragment : BaseFragment() {
    private val mCurrentDialogStyle = R.style.QMUI_Dialog
    override fun init() {
        showDialog()
    }

    private fun showDialog() {
        val menuDialogBuilder = QMUIDialog.MenuDialogBuilder(context)
        menuDialogBuilder.setTitle("提示对话框")
        menuDialogBuilder.addItem("Loading的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showLoading()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("成功的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showSuccessful()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("失败的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showFail()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("信息的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showMsg()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("单独文字对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showOnlyText()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("单独图片对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showOnlyIcon()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("自定义对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showMyCustom()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.create(mCurrentDialogStyle).show()
    }

    private fun showMyCustom() {

        val tipDialog: QMUITipDialog = QMUITipDialog.CustomBuilder(context)
                .setContent(R.layout.layout_content_view)
                .create()
        tipDialog.show()
        mView!!.postDelayed(object : Runnable {
            override fun run() {
                tipDialog.dismiss()
            }

        }, 1000)
    }

    private fun showOnlyIcon() {
        val tipDialog: QMUITipDialog = QMUITipDialog.Builder(context)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                .create()
        tipDialog.show()
        mView!!.postDelayed(object : Runnable {
            override fun run() {
                tipDialog.dismiss()
            }

        }, 1000)

    }

    private fun showOnlyText() {
        val tipDialog: QMUITipDialog = QMUITipDialog.Builder(context)
                .setTipWord("只有文字")
                .create()
        tipDialog.show()
        mView!!.postDelayed(object : Runnable {
            override fun run() {
                tipDialog.dismiss()
            }

        }, 1000)

    }

    private fun showMsg() {

        showNormal(QMUITipDialog.Builder.ICON_TYPE_INFO, "信息")
    }

    private fun showFail() {

        showNormal(QMUITipDialog.Builder.ICON_TYPE_FAIL, "失败")
    }

    private fun showSuccessful() {

        showNormal(QMUITipDialog.Builder.ICON_TYPE_SUCCESS, "成功")
    }

    fun showLoading() {
        showNormal(QMUITipDialog.Builder.ICON_TYPE_LOADING, "正在加载")
    }

    fun showNormal(type: Int, msg: String) {
        val tipDialog: QMUITipDialog = QMUITipDialog.Builder(context)
                .setIconType(type)
                .setTipWord(msg)
                .create()
        tipDialog.show()
        mView!!.postDelayed(object : Runnable {
            override fun run() {
                tipDialog.dismiss()
            }

        }, 1000)
    }

    fun showToas(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_item
    }

    override fun initViews(rootView: View) {
    }


}
