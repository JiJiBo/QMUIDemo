package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import com.qmuiteam.qmui.util.QMUIKeyboardHelper
import com.qmuiteam.qmui.widget.QMUIVerticalTextView
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R

class TextViewFragment : BaseFragment() {
    override fun init() {
        val defaultText = String.format("%s 实现对文字的垂直排版。并且对非 CJK (中文、日文、韩文)字符做90度旋转排版。可以在下方的输入框中输入文字，体验不同文字垂直排版的效果。",
                QMUIVerticalTextView::class.java.simpleName)
        mTv!!.setText(defaultText)
        mEt!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mTv!!.setText(mEt!!.text.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_textview
    }

    var mTv: QMUIVerticalTextView? = null
    var mEt: EditText? = null

    override fun initViews(rootView: View) {


        mTv = rootView.findViewById(R.id.tv);
        mEt = rootView.findViewById(R.id.et);

    }


}