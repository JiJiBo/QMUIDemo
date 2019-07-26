package com.rulerbug.qmuidemo.qmuidemo.Manager;

import android.graphics.drawable.Drawable;

import com.qmuiteam.qmui.qqface.IQMUIQQFaceManager;
import com.rulerbug.qmuidemo.qmuidemo.R;

public class FaceManager implements IQMUIQQFaceManager {

    private static FaceManager faceManager=new FaceManager();

    public static FaceManager getInstance(){

        return faceManager;

    }

    @Override

    public boolean maybeSoftBankEmoji(char c) {

        return false;

    }

    @Override

    public int getSoftbankEmojiResource(char c) {

        return 0;

    }

    @Override

    public boolean maybeEmoji(int codePoint) {

        return false;

    }

    @Override

    public int getEmojiResource(int codePoint) {

        return 0;

    }

    @Override

    public int getDoubleUnicodeEmoji(int currentCodePoint, int nextCodePoint) {

        return 0;

    }

    @Override

    public int getQQfaceResource(CharSequence text) {

        if (text.equals("[微笑]"))

            return R.mipmap.ic_launcher;

        return 0;

    }

    @Override
    public Drawable getSpecialBoundsDrawable(CharSequence text) {
        return null;
    }


    @Override

    public int getSpecialDrawableMaxHeight() {

        return 0;

    }

}

