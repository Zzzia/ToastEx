package com.zia.toastex.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

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
            setTextColor(color);
            ValueAnimator valueAnimator;
            valueAnimator = ValueAnimator.ofFloat(0.5f, 1);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    setAlpha((Float) animation.getAnimatedValue());
                }
            });
            valueAnimator.setDuration(duration);
            valueAnimator.start();
            begin = true;
        }
    }
}
