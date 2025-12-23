package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SlideUpView extends RelativeLayout {
    private AnimatorSet ae;
    private ImageView cw;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f28546j;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f28547m;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f28548r;
    private AnimatorSet tl;
    private AnimatorSet up;
    private ImageView xt;

    private void xt(Context context) {
        if (context == null) {
            context = v.getContext();
        }
        View j6 = j(context);
        if (j6 == null) {
            return;
        }
        addView(j6);
    }

    private View j(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.cw = imageView;
        imageView.setId(2114387645);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387767);
        layoutParams2.bottomMargin = ed.cw(context, -24.0f);
        kt.j(context, "tt_splash_slide_up_circle", (View) this.cw);
        this.cw.setAlpha(0.0f);
        this.cw.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.cw);
        ImageView imageView2 = new ImageView(context);
        this.xt = imageView2;
        imageView2.setId(2114387945);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387767);
        layoutParams3.addRule(8, 2114387767);
        kt.j(context, "tt_splash_slide_up_bg", (View) this.xt);
        layoutParams3.leftMargin = ed.cw(context, -7.0f);
        this.xt.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.xt);
        ImageView imageView3 = new ImageView(context);
        this.f28546j = imageView3;
        imageView3.setId(2114387650);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387767);
        layoutParams4.addRule(8, 2114387767);
        kt.j(context, "tt_splash_slide_up_finger", (View) this.f28546j);
        layoutParams4.leftMargin = ed.cw(context, -7.0f);
        layoutParams4.bottomMargin = ed.cw(context, -20.0f);
        this.f28546j.setAlpha(0.0f);
        this.f28546j.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.f28546j);
        ImageView imageView4 = new ImageView(context);
        this.f28548r = imageView4;
        imageView4.setId(2114387767);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        kt.j(context, "tt_splash_slide_up_arrow", (View) this.f28548r);
        this.f28548r.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.f28548r);
        return relativeLayout;
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.up;
    }

    public SlideUpView(Context context) {
        super(context);
        xt(context);
    }

    public void xt() {
        AnimatorSet animatorSet = this.up;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.ae;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f28547m;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.tl;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    public void j() {
        this.f28547m = new AnimatorSet();
        this.ae = new AnimatorSet();
        this.tl = new AnimatorSet();
        this.up = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f28546j, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f28546j, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f28546j, "translationY", 0.0f, ed.cw(getContext(), -110.0f));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, ed.cw(getContext(), 110.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.xt.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.xt.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.xt, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.xt, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.cw, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.cw, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.cw, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.cw, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.cw, "translationY", 0.0f, ed.cw(getContext(), -110.0f));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.f28547m.setDuration(50L);
        this.tl.setDuration(1500L);
        this.ae.setDuration(50L);
        this.f28547m.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.ae.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.tl.playTogether(ofFloat3, ofInt, ofFloat10);
        this.up.playSequentially(this.ae, this.tl, this.f28547m);
    }
}
