package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class PressButtonInteractView extends FrameLayout {
    private SplashDiffuseView cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f25946j;

    /* renamed from: r, reason: collision with root package name */
    private AnimatorSet f25947r;
    private boolean up;
    private ImageView xt;

    private void cw() {
        this.cw = new SplashDiffuseView(this.f25946j);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) tl.j(this.f25946j, 40.0f), (int) tl.j(this.f25946j, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.cw, layoutParams);
        this.xt = new ImageView(this.f25946j);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) tl.j(this.f25946j, 62.0f), (int) tl.j(this.f25946j, 62.0f));
        layoutParams2.gravity = 16;
        this.xt.setImageResource(kt.up(this.f25946j, "tt_splash_hand"));
        addView(this.xt, layoutParams2);
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xt, "scaleX", 1.0f, 0.9f);
        ofFloat.setDuration(800L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.up) {
                    PressButtonInteractView.this.cw.j();
                }
                PressButtonInteractView.this.up = !r2.up;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.xt, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                PressButtonInteractView.this.xt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xt, "scaleY", 1.0f, 0.9f);
        ofFloat2.setDuration(800L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f25947r.playTogether(ofFloat, ofFloat2);
    }

    public void xt() {
        AnimatorSet animatorSet = this.f25947r;
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

    public PressButtonInteractView(Context context) {
        super(context);
        this.up = true;
        this.f25946j = context;
        this.f25947r = new AnimatorSet();
        cw();
        r();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.xt.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.cw.getMeasuredHeight() / 2.0f) - tl.j(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.cw.getMeasuredWidth() / 2.0f) - tl.j(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.cw.getMeasuredHeight()) / 2.0f) + tl.j(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.cw.getMeasuredWidth()) / 2.0f) + tl.j(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.xt.setLayoutParams(layoutParams);
            }
        });
    }

    public void j() {
        this.f25947r.start();
    }
}
