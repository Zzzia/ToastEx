package com.zia.toastlib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

import com.zia.toastex.anim.ToastText;

/**
 * Created by zia on 2018/5/14.
 * 文字渐变
 */
public class CustomText extends ToastText {

    private int duration;
    private boolean begin = false;
    private int color = 0;

    public CustomText(Context context) {
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
                valueAnimator = ValueAnimator.ofArgb(color, Color.RED);
            } else {
                valueAnimator = ValueAnimator.ofInt(color, Color.RED);
            }
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    CustomText.this.color = (int) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
//            valueAnimator.setDuration(duration);
            //为了显示渐变效果，把时间改为1s
            valueAnimator.setDuration(1000);
            valueAnimator.start();
        }
        setTextColor(color);
    }
}
