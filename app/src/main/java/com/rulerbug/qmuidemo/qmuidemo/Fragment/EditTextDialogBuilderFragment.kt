package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.view.View
import android.widget.Toast
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R

class EditTextDialogBuilderFragment : BaseFragment() {
    override fun init() {
        val builder = QMUIDialog.EditTextDialogBuilder(context)
        builder.setTitle("对话框")

        builder.setLeftAction("你好", object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog?, index: Int) {
                val toString = builder.editText.text.toString()
                Toast.makeText(context, toString, Toast.LENGTH_SHORT).show()
                dialog!!.dismiss()
            }
        })
        val create = builder.create()
        create.show()

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_item
    }

    override fun initViews(rootView: View) {
    }

}