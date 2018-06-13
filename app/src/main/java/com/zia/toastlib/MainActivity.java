package com.zia.toastlib;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zia.toastex.ToastEx;
import com.zia.toastex.anim.InfoAnim;
import com.zia.toastex.anim.ToastImage;

public class MainActivity extends AppCompatActivity {

    private final static String TOAST = "this is a toast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;//懒癌晚期
        findViewById(R.id.toast_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.getInstance().setUseAnim(false).tintIcon(false).apply();
                ToastEx.normal(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.getInstance().setUseAnim(false).tintIcon(false).apply();
                ToastEx.success(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.getInstance().setUseAnim(false).tintIcon(false).apply();
                ToastEx.warning(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.getInstance().setUseAnim(false).tintIcon(false).apply();
                ToastEx.info(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.getInstance().setUseAnim(false).tintIcon(false).apply();
                ToastEx.error(context, TOAST).show();
            }
        });

        findViewById(R.id.toast_anim_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.reset();//恢复至默认带动画的效果
                ToastEx.success(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_anim_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.reset();//恢复至默认带动画的效果
                ToastEx.error(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_anim_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.reset();//恢复至默认带动画的效果
                ToastEx.info(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_anim_warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.reset();//恢复至默认带动画的效果
                ToastEx.warning(context, TOAST).show();
            }
        });
        findViewById(R.id.toast_custom_logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.reset();
                ToastImage toastImage = new ToastImage(context);
                toastImage.setImageResource(R.drawable.ic_pets_white_48dp);
                ToastEx.custom(context, TOAST, Toast.LENGTH_SHORT, ToastEx.NO_COLOR, toastImage).show();
            }
        });
        findViewById(R.id.toast_custom_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastEx.Config.reset();
                CustomText text = new CustomText(context);
                text.setText(TOAST);
                ToastEx.custom(context, text, Toast.LENGTH_SHORT
                        , ToastEx.NO_COLOR, new InfoAnim(context)).show();
            }
        });
    }
}
