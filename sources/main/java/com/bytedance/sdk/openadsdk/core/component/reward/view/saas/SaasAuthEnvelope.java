package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tl.cw;
import com.bytedance.sdk.openadsdk.g.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SaasAuthEnvelope extends RelativeLayout {
    private ImageView cw;

    /* renamed from: j, reason: collision with root package name */
    private AnimationSet f28469j;
    private ImageView xt;

    private void j(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387470);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.cw = new ImageView(context);
        try {
            xt.j(cw.j("saas_red_envelope.webp")).j(this.cw);
        } catch (Error unused) {
        }
        linearLayout.addView(this.cw, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.xt = imageView;
        try {
            imageView.setImageResource(kt.up(context, "tt_saas_close"));
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ed.cw(context, 25.0f);
        linearLayout.addView(this.xt, layoutParams2);
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.xt;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void xt() {
        AnimationSet animationSet = this.f28469j;
        if (animationSet != null) {
            animationSet.cancel();
            this.f28469j = null;
        }
        setVisibility(8);
    }

    public SaasAuthEnvelope(@NonNull Context context) {
        super(context);
        j(context);
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xt();
    }

    public void j() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.f28469j = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.f28469j.addAnimation(scaleAnimation);
        startAnimation(this.f28469j);
    }
}
