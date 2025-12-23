package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.r.tl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ClickSlideUpView extends SlideUpView {
    private AnimatorSet cw;

    /* renamed from: j, reason: collision with root package name */
    private TextView f25891j;
    private View xt;

    private void xt(Context context) {
        View j6 = com.bytedance.sdk.component.adexpress.cw.j.j(context);
        this.xt = j6;
        addView(j6);
        setClipChildren(false);
        this.f25891j = (TextView) findViewById(2097610748);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void j(Context context) {
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xt, "translationY", 0.0f, tl.j(getContext(), -3.0f));
        ofFloat.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xt, "alpha", 1.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat2.setRepeatCount(-1);
        this.cw.playTogether(ofFloat, ofFloat2);
        this.cw.setDuration(1000L);
        this.cw.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void j() {
        r();
    }

    public void setButtonText(String str) {
        if (this.f25891j == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25891j.setText(str);
    }

    public ClickSlideUpView(Context context) {
        super(context);
        this.cw = new AnimatorSet();
        xt(context);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xt() {
        this.cw.cancel();
    }
}
