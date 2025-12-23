package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class SlideUpLoadMoreArrow extends LinearLayout {

    /* renamed from: j, reason: collision with root package name */
    private final int f28444j;
    private final AnimatorSet xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j implements Interpolator {
        private j() {
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 <= 0.38f) {
                return f6 * 2.631579f;
            }
            return (f6 * (-1.6129032f)) + 1.6129032f;
        }
    }

    private View j(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setClipChildren(false);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        kt.j(context, "tt_ic_back_light", imageView);
        imageView.setAlpha(0.0f);
        linearLayout.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        kt.j(context, "tt_ic_back_light", imageView2);
        imageView2.setAlpha(0.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ed.cw(context, -8.0f);
        linearLayout.addView(imageView2, layoutParams);
        setClipChildren(false);
        j(imageView, imageView2);
        return linearLayout;
    }

    private void cw() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor("#DD000000"), 0});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        setBackground(gradientDrawable);
    }

    public void xt() {
        if (this.xt.isRunning()) {
            this.xt.cancel();
        }
    }

    public SlideUpLoadMoreArrow(Context context, int i6, boolean z5) {
        super(context);
        this.xt = new AnimatorSet();
        if (z5) {
            cw();
        }
        this.f28444j = i6;
        r();
    }

    private void r() {
        Context context = getContext();
        setOrientation(1);
        setClipChildren(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ed.cw(context, 80.0f);
        layoutParams.gravity = 1;
        addView(j(getContext()), layoutParams);
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(ed.cw(context, 17.0f));
        }
        textView.setTextSize(2, 12.0f);
        textView.setText(kt.j(context, "tt_reward_slip_up_lp_tip"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ed.cw(context, 6.0f);
        layoutParams2.bottomMargin = ed.cw(context, this.f28444j);
        layoutParams2.gravity = 1;
        addView(textView, layoutParams2);
    }

    private void j(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new j(null));
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, ed.cw(getContext(), -5.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new j(null));
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "translationY", ed.cw(getContext(), -6.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        this.xt.playTogether(ofFloat, ofFloat3, ofFloat2, ofFloat4);
    }

    public void j() {
        if (this.xt.isStarted()) {
            return;
        }
        this.xt.start();
    }
}
