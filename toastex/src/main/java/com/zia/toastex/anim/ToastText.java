package com.zia.toastex.anim;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by zia on 2018/5/14.
 */
public class ToastText extends android.support.v7.widget.AppCompatTextView implements IAnim {
    public ToastText(Context context) {
        super(context);
    }

    public ToastText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ToastText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setDuration(int duration) {

    }

    @Override
    public void setColor(int color) {

    }
}
