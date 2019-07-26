package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.content.DialogInterface
import android.view.View
import com.qmuiteam.qmui.widget.QMUIEmptyView
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R
import com.rulerbug.qmuidemo.qmuidemo.Utils.ToastUtils

class EmptyViewFragment : BaseFragment() {
    override fun init() {
        showDialog()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_empty
    }

    var mEmptyView: QMUIEmptyView? = null
    override fun initViews(rootView: View) {
        mEmptyView = rootView.findViewById(R.id.qev);
    }

    private fun showDialog() {
        val menuDialogBuilder = QMUIDialog.MenuDialogBuilder(context)
        menuDialogBuilder.setTitle("emptyView")
        menuDialogBuilder.addItem("两行文字", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                mEmptyView!!.show("1111111111", "222222222222")
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("一行文字", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                mEmptyView!!.show("1111111111", null)
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("loading", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                mEmptyView!!.show(true)
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("一行文字和按钮", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                mEmptyView!!.show(false, "111111", null, "bt", null)
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("两行文字和按钮", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                mEmptyView!!.show(false, "111111", "222222", "bt这个能点击", object :View.OnClickListener{
                    override fun onClick(v: View?) {
                    ToastUtils.show(context,"点击")

                    }

                })

                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.create().show()
    }
}