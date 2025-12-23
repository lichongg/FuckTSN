package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SmallSlideView extends RelativeLayout {
    private ObjectAnimator cw;

    /* renamed from: j, reason: collision with root package name */
    private final View f28104j;

    /* renamed from: r, reason: collision with root package name */
    private ObjectAnimator f28105r;
    private final xt xt;

    private static class j extends FrameLayout {
        public j(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            kt.j(context, "tt_splash_slide_up_finger", imageView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ed.cw(context, 38.0f);
            layoutParams.bottomMargin = ed.cw(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            kt.j(context, "tt_splash_slide_up_circle", imageView2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int cw = ed.cw(context, 30.0f);
            layoutParams2.setMargins(cw, cw, cw, cw);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    private static class xt extends FrameLayout {
        public xt(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            kt.j(context, "tt_splash_slide_up_bg", (View) imageView);
            addView(imageView);
        }
    }

    public void j() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f28104j, "translationY", ed.cw(getContext(), 30.0f), ed.cw(getContext(), -20.0f));
        this.cw = ofFloat;
        ofFloat.setDuration(800L);
        this.cw.setRepeatCount(1);
        this.cw.setRepeatMode(1);
        this.cw.start();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.xt, "newHeight", ed.cw(getContext(), 0.0f), ed.cw(getContext(), 48.0f));
        this.f28105r = ofInt;
        ofInt.setDuration(800L);
        this.f28105r.setRepeatCount(1);
        this.f28105r.setRepeatMode(1);
        this.f28105r.start();
    }

    public void xt() {
        ObjectAnimator objectAnimator = this.cw;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f28105r;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    public SmallSlideView(Context context) {
        super(context);
        View jVar = new j(context);
        this.f28104j = jVar;
        xt xtVar = new xt(context);
        this.xt = xtVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ed.cw(context, 10.0f), 0);
        layoutParams.setMargins(0, ed.cw(context, 8.0f), 0, ed.cw(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(xtVar, layoutParams);
        addView(jVar);
        setLayoutParams(new LinearLayout.LayoutParams(ed.cw(context, 80.0f), ed.cw(context, 80.0f)));
    }
}
