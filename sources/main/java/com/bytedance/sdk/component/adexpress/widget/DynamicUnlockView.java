package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicUnlockView extends FrameLayout {
    private final FlowLightView cw;

    /* renamed from: j, reason: collision with root package name */
    private final TextView f25908j;

    /* renamed from: r, reason: collision with root package name */
    private final RotateAnimation f25909r;
    private final ImageView xt;

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.xt.startAnimation(DynamicUnlockView.this.f25909r);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.cw.j(4);
                    }
                }, 100L);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.cw.j(4);
                    }
                }, 300L);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200L);
            }
        };
    }

    public void j() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void xt() {
        this.f25909r.cancel();
    }

    public DynamicUnlockView(Context context) {
        super(context);
        addView(com.bytedance.sdk.component.adexpress.cw.j.r(context));
        this.f25908j = (TextView) findViewById(2097610742);
        this.xt = (ImageView) findViewById(2097610745);
        this.cw = (FlowLightView) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.f25909r = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "滑动或点击跳转至详情页或第三方应用";
        }
        TextView textView = this.f25908j;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
