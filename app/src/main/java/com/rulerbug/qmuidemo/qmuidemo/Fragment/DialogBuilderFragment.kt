package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.*
import com.qmuiteam.qmui.util.QMUIKeyboardHelper
import com.qmuiteam.qmui.widget.dialog.QMUIDialog
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R


class DialogBuilderFragment : BaseFragment() {
    private val mCurrentDialogStyle = R.style.QMUI_Dialog
    override fun init() {
        showDialog()
    }

    private fun showDialog() {
        val menuDialogBuilder = QMUIDialog.MenuDialogBuilder(context)
        menuDialogBuilder.setTitle("菜单对话框")
        menuDialogBuilder.addItem("自动伸缩的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showEditAutoDialog()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("蓝红的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showRedAndBlueDialog()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("checkbox的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showCheckBoxDialog()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("菜单自动选择的对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showMenuCheck()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("确定对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showLotsCheck()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.addItem("许多确定对话框", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                showLongLotsCheck()
                dialog!!.dismiss()
            }

        })
        menuDialogBuilder.create(mCurrentDialogStyle).show()
    }

    fun showRedAndBlueDialog() {
        QMUIDialog.MessageDialogBuilder(context).setTitle("是否删除").setMessage("请选择").addAction("取消", object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog?, index: Int) {
                showToas("你点了取消")
                dialog!!.dismiss()
            }

        }).addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE, object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog?, index: Int) {
                showToas("你点了确定")
                dialog!!.dismiss()
            }

        }).create(mCurrentDialogStyle).show()
    }

    fun showEditAutoDialog() {
        val builder = QMAutoTestDialogBuilder(context!!)
        builder.setTitle("对话框")
        builder.addAction(R.drawable.ic_child, "你好", object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog?, index: Int) {
                showToas(builder.editText!!.text.toString())
                dialog!!.dismiss()
            }

        })
        builder.create(mCurrentDialogStyle).show()
        QMUIKeyboardHelper.showKeyboard(builder.editText, true);
    }

    fun showCheckBoxDialog() {
        val dialogBuilder = QMUIDialog.CheckBoxMessageDialogBuilder(context)
        dialogBuilder.setTitle("checkbox").setMessage("确认删除").setChecked(true)
                .addAction("取消", object : QMUIDialogAction.ActionListener {
                    override fun onClick(dialog: QMUIDialog?, index: Int) {
                        showToas("你点了取消")
                        dialog!!.dismiss()
                    }

                }).addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE, object : QMUIDialogAction.ActionListener {
                    override fun onClick(dialog: QMUIDialog?, index: Int) {
                        showToas("你点了确定")
                        dialog!!.dismiss()
                    }

                }).create(mCurrentDialogStyle).show()


    }

    fun showLotsCheck() {
        val items = arrayOf("选项1", "选项2", "选项3", "选项4", "选项5", "选项6")
        val builder = QMUIDialog.MultiCheckableDialogBuilder(activity).setCheckedItems(intArrayOf(1, 3)).addItems(items) { dialog, which -> }
        builder.addAction("取消", object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog, index: Int) {
                dialog.dismiss()
            }
        })
        builder.addAction("提交", object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog, index: Int) {
                var result = "你选择了 "
                for (index in builder.checkedItemIndexes) {
                    result += (index + 1).toString() + "--"
                }
                showToas(result)
                dialog.dismiss()
            }
        })

        builder.show();
    }

    fun showLongLotsCheck() {
        val items = arrayOf("选项1", "选项2", "选项3", "选项4", "选项5", "选项6", "选项7", "选项8", "选项9", "选项10", "选项11", "选项12", "选项13", "选项14", "选项15", "选项16", "选项17", "选项18")
        val builder = QMUIDialog.MultiCheckableDialogBuilder(activity).setCheckedItems(intArrayOf(1, 3)).addItems(items) { dialog, which -> }
        builder.addAction("取消", object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog, index: Int) {
                dialog.dismiss()
            }
        })
        builder.addAction("提交", object : QMUIDialogAction.ActionListener {
            override fun onClick(dialog: QMUIDialog, index: Int) {
                var result = "你选择了 "
                for (index in builder.checkedItemIndexes) {
                    result += (index + 1).toString() + "--"
                }
                showToas(result)
                dialog.dismiss()
            }
        })

        builder.show();
    }

    fun showToas(str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

    fun showMenuCheck() {
        val items = arrayOf("选项1", "选项2", "选项3")
        val checkedIndex = 1
        QMUIDialog.CheckableDialogBuilder(activity).setCheckedIndex(checkedIndex).addItems(items) { dialog, which ->
            showToas("你选择了 " + items[which])
            dialog.dismiss()
        }.show()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_item
    }

    override fun initViews(rootView: View) {
    }


    internal inner class QMAutoTestDialogBuilder(private val context: Context) : QMUIDialog.AutoResizeDialogBuilder(context) {
        var editText: EditText? = null
            private set

        override fun onBuildContent(dialog: QMUIDialog, parent: ScrollView): View {
            val layout = View.inflate(context, R.layout.layout_content_view, null)
            editText = layout.findViewById(R.id.et)
            return layout
        }
    }
}
