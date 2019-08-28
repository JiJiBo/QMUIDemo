package com.rulerbug.mycode.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.rulerbug.mycode.R;


public class MoreHolder extends BaseViewHolder<String> {

    private TextView mTextView;

    public MoreHolder(Context mc) {
        super(mc);
    }

    @Override
    public View initView() {
        View view = View.inflate(mc, R.layout.view_only_textview, null);
        mTextView = view.findViewById(R.id.textview);
        mTextView.setPadding(10, 30, 10, 30);
        mTextView.setText("加载更多...");
        return mTextView;
    }

    @Override
    public void refreshView(String data) {
        mTextView.setText(data);
    }
}
