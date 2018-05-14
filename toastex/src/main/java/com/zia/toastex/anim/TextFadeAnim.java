package com.zia.toastex.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;

import com.zia.toastex.ToastEx;

/**
 * Created by zia on 2018/5/14.
 */
public class TextFadeAnim extends ToastText {

    private int duration;
    private boolean begin = false;
    private int color = 0;

    public TextFadeAnim(Context context) {
        super(context);
    }

    @Override
    public void setDuration(int duration) {
        super.setDuration(duration);
        this.duration = duration;
    }

    @Override
    public void setColor(int color) {
        super.setColor(color);
        this.color = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!begin) {
            begin = true;
            ValueAnimator valueAnimator;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                valueAnimator = ValueAnimator.ofArgb(ToastEx.NORMAL_COLOR, color);
            } else {
                valueAnimator = ValueAnimator.ofInt(ToastEx.NORMAL_COLOR, color);
            }
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    TextFadeAnim.this.color = (int) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            valueAnimator.setDuration(duration);
            valueAnimator.start();
        }
        setTextColor(color);
    }
}
