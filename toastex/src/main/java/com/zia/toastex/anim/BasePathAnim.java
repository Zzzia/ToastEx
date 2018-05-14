package com.zia.toastex.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;

import java.util.List;

/**
 * Created by zia on 2018/5/13.
 * 通过画path制作动画
 */
public abstract class BasePathAnim extends ToastImage {

    private Path rightDstPath;
    private PathMeasure mPathMeasure;
    private float percentage = 0;
    private boolean begin = false;
    private int duration = 1000;
    private Paint paint;
    private int color = -23333;

    abstract List<Path> getPaths();

    abstract void setPaint(Paint paint);

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    public BasePathAnim(Context context) {
        super(context);
        init();
    }

    public BasePathAnim(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BasePathAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        paint = new Paint();
        rightDstPath = new Path();
        mPathMeasure = new PathMeasure();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!begin) {
            setPaint(paint);
            if (color != -23333) {
                paint.setColor(color);
            }
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    percentage = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            valueAnimator.setDuration(duration).start();
            begin = true;
        }
        for (Path path : getPaths()) {
            mPathMeasure.setPath(path, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * percentage, rightDstPath, true);
            canvas.drawPath(rightDstPath, paint);
        }
    }

}
