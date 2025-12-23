package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class HandLongPressView extends FrameLayout {
    private CircleRippleView cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f25928j;

    /* renamed from: m, reason: collision with root package name */
    private TextView f25929m;

    /* renamed from: r, reason: collision with root package name */
    private AnimatorSet f25930r;
    private boolean up;
    private ImageView xt;

    private void cw() {
        this.cw = new CircleRippleView(this.f25928j);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) tl.j(this.f25928j, 80.0f), (int) tl.j(this.f25928j, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) tl.j(this.f25928j, 20.0f);
        int j6 = (int) tl.j(this.f25928j, 20.0f);
        layoutParams.leftMargin = j6;
        layoutParams.setMarginStart(j6);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.cw, layoutParams);
        this.cw.j();
        this.xt = new ImageView(this.f25928j);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) tl.j(this.f25928j, 80.0f), (int) tl.j(this.f25928j, 80.0f));
        this.xt.setImageResource(kt.up(this.f25928j, "tt_splash_hand"));
        addView(this.xt, layoutParams2);
        TextView textView = new TextView(this.f25928j);
        this.f25929m = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) tl.j(this.f25928j, 10.0f);
        addView(this.f25929m, layoutParams3);
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xt, "scaleX", 1.0f, 0.8f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (HandLongPressView.this.up) {
                    HandLongPressView.this.cw.j();
                    HandLongPressView.this.cw.setAlpha(1.0f);
                } else {
                    HandLongPressView.this.cw.xt();
                    HandLongPressView.this.cw.setAlpha(0.0f);
                }
                HandLongPressView.this.up = !r2.up;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(HandLongPressView.this.xt, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                HandLongPressView.this.xt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xt, "scaleY", 1.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.f25930r.playTogether(ofFloat, ofFloat2);
    }

    public void setGuideText(String str) {
        this.f25929m.setText(str);
    }

    public void setGuideTextColor(int i6) {
        this.f25929m.setTextColor(i6);
    }

    public void xt() {
        AnimatorSet animatorSet = this.f25930r;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.cw;
        if (circleRippleView != null) {
            circleRippleView.xt();
        }
    }

    public HandLongPressView(Context context) {
        super(context);
        this.up = true;
        this.f25928j = context;
        this.f25930r = new AnimatorSet();
        cw();
        r();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.xt.getLayoutParams();
                layoutParams.topMargin = ((int) ((HandLongPressView.this.cw.getMeasuredHeight() / 2.0f) - tl.j(HandLongPressView.this.getContext(), 5.0f))) + ((int) tl.j(HandLongPressView.this.f25928j, 20.0f));
                layoutParams.leftMargin = ((int) ((HandLongPressView.this.cw.getMeasuredWidth() / 2.0f) - tl.j(HandLongPressView.this.getContext(), 5.0f))) + ((int) tl.j(HandLongPressView.this.f25928j, 20.0f));
                layoutParams.bottomMargin = (int) (((-HandLongPressView.this.cw.getMeasuredHeight()) / 2.0f) + tl.j(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-HandLongPressView.this.cw.getMeasuredWidth()) / 2.0f) + tl.j(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                HandLongPressView.this.xt.setLayoutParams(layoutParams);
            }
        });
    }

    public void j() {
        this.f25930r.start();
    }
}
