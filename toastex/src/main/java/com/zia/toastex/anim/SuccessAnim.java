package com.zia.toastex.anim;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zia on 2018/5/13.
 */
public class SuccessAnim extends BasePathAnim {

    private int width = 0, height = 0;

    public SuccessAnim(Context context) {
        super(context);
    }

    public SuccessAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SuccessAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    List<Path> getPaths() {
        if (width == 0 || height == 0) {
            width = getWidth();
            height = getHeight();
        }
        float x1 = width * 0.2f, y1 = height * 0.53f;
        float x2 = width * 0.36f, y2 = height * 0.7f;
        float x3 = width * 0.77f, y3 = height * 0.23f;
        Path path = new Path();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        List<Path> paths = new ArrayList<>();
        paths.add(path);
        return paths;
    }

    @Override
    void setPaint(Paint paint) {
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getWidth() * 0.05f);
        paint.setColor(Color.parseColor("#388E3C"));
    }
}
