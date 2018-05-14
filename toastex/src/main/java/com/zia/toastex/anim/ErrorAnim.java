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
public class ErrorAnim extends BasePathAnim {

    private int width = 0, height = 0;

    public ErrorAnim(Context context) {
        super(context);
    }

    public ErrorAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ErrorAnim(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    List<Path> getPaths() {
        if (width == 0 || height == 0) {
            width = getWidth();
            height = getHeight();
        }
        Path path = new Path();
        path.moveTo(width / 5, height / 5);
        path.lineTo(width / 5 * 4, height / 5 * 4);
        Path path1 = new Path();
        path1.moveTo(width / 5 * 4, height / 5);
        path1.lineTo(width / 5, height / 5 * 4);
        List<Path> paths = new ArrayList<>();
        paths.add(path);
        paths.add(path1);
        return paths;
    }

    @Override
    void setPaint(Paint paint) {
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getWidth() / 18f);
        paint.setColor(Color.parseColor("#388E3C"));
    }

}
