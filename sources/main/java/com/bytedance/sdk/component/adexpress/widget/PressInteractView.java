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
public class PressInteractView extends FrameLayout {
    private SplashDiffuseView cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f25950j;

    /* renamed from: m, reason: collision with root package name */
    private TextView f25951m;

    /* renamed from: r, reason: collision with root package name */
    private AnimatorSet f25952r;
    private boolean up;
    private ImageView xt;

    private void cw() {
        this.cw = new SplashDiffuseView(this.f25950j);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) tl.j(this.f25950j, 50.0f), (int) tl.j(this.f25950j, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) tl.j(this.f25950j, 40.0f);
        int j6 = (int) tl.j(this.f25950j, 20.0f);
        layoutParams.leftMargin = j6;
        layoutParams.setMarginStart(j6);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.cw, layoutParams);
        this.xt = new ImageView(this.f25950j);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) tl.j(this.f25950j, 78.0f), (int) tl.j(this.f25950j, 78.0f));
        this.xt.setImageResource(kt.up(this.f25950j, "tt_splash_hand"));
        addView(this.xt, layoutParams2);
        TextView textView = new TextView(this.f25950j);
        this.f25951m = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) tl.j(this.f25950j, 10.0f);
        addView(this.f25951m, layoutParams3);
        this.f25951m.setVisibility(8);
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xt, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat.setDuration(600L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.up) {
                    PressInteractView.this.cw.j();
                }
                PressInteractView.this.up = !r2.up;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.xt, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                PressInteractView.this.xt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xt, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat2.setDuration(600L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.f25952r.playTogether(ofFloat, ofFloat2);
    }

    public void setGuideText(String str) {
        this.f25951m.setVisibility(0);
        this.f25951m.setText(str);
    }

    public void setGuideTextColor(int i6) {
        this.f25951m.setTextColor(i6);
    }

    public void xt() {
        AnimatorSet animatorSet = this.f25952r;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.cw;
        if (splashDiffuseView != null) {
            splashDiffuseView.xt();
        }
        ImageView imageView = this.xt;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public PressInteractView(Context context) {
        super(context);
        this.up = true;
        this.f25950j = context;
        this.f25952r = new AnimatorSet();
        cw();
        r();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int j6 = (int) tl.j(PressInteractView.this.f25950j, 50.0f);
                int j7 = (int) tl.j(PressInteractView.this.f25950j, 50.0f);
                if (PressInteractView.this.cw.getMeasuredHeight() > 0) {
                    j6 = PressInteractView.this.cw.getMeasuredHeight();
                }
                if (PressInteractView.this.cw.getMeasuredWidth() > 0) {
                    j7 = PressInteractView.this.cw.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.xt.getLayoutParams();
                layoutParams.topMargin = ((int) ((j6 / 2.0f) - tl.j(PressInteractView.this.getContext(), 5.0f))) + ((int) tl.j(PressInteractView.this.f25950j, 40.0f));
                layoutParams.leftMargin = ((int) ((j7 / 2.0f) - tl.j(PressInteractView.this.getContext(), 5.0f))) + ((int) tl.j(PressInteractView.this.f25950j, 20.0f));
                layoutParams.bottomMargin = (int) (((-j6) / 2.0f) + tl.j(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-j7) / 2.0f) + tl.j(PressInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.xt.setLayoutParams(layoutParams);
            }
        });
    }

    public void j() {
        this.f25952r.start();
    }
}
