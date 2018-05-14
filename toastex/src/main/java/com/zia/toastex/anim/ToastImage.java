package com.zia.toastex.anim;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by zia on 2018/5/13.
 */
public class ToastImage extends android.support.v7.widget.AppCompatImageView implements IAnim {

    public ToastImage(Context context) {
        super(context);
    }

    public ToastImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ToastImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setDuration(int duration) {

    }

    @Override
    public void setColor(int color) {

    }
}
