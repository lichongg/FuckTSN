package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SplashClickBarArrow extends FrameLayout {
    private ImageView ae;
    private ImageView cw;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f28554g;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f28555j;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f28556m;
    private boolean oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f28557r;
    private SplashDiffuseView tl;
    private ImageView up;
    private AnimatorSet vl;
    private RelativeLayout xt;

    private static class j implements Interpolator {
        private j() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            if (f6 <= 0.38f) {
                return f6 * 2.631579f;
            }
            return (f6 * (-1.6129032f)) + 1.6129032f;
        }
    }

    private void cw() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ae, "scaleX", 1.0f, 0.9f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.oq) {
                    SplashClickBarArrow.this.tl.j();
                }
                SplashClickBarArrow.this.oq = !r2.oq;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.ae, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                SplashClickBarArrow.this.ae.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ae, "scaleY", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.vl.playTogether(ofFloat, ofFloat2);
        this.vl.setStartDelay(1000L);
    }

    private void xt(Context context) {
        View j6 = j(getContext());
        if (j6 == null) {
            return;
        }
        addView(j6);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.tl = splashDiffuseView;
        this.f28556m.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.tl.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.tl.setVisibility(4);
    }

    public Animator getAnimator() {
        return this.vl;
    }

    public SplashClickBarArrow(Context context) {
        super(context);
        this.oq = true;
        this.vl = new AnimatorSet();
        xt(context);
    }

    public void j(int i6) {
        this.qv = i6;
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.vl;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e6) {
            vl.cw(e6.getMessage());
        }
    }

    private View j(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.f28555j = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.f28555j.setId(2114387598);
        layoutParams2.gravity = 16;
        j(context, "tt_splash_click_bar_go", this.f28555j, true);
        this.f28555j.setLayoutParams(layoutParams2);
        frameLayout.addView(this.f28555j);
        ed.j((View) this.f28555j, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.xt = relativeLayout;
        relativeLayout.setId(2114387597);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.xt.setPadding(ed.cw(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.xt);
        ed.j((View) this.xt, 8);
        ImageView imageView = new ImageView(context);
        this.cw = imageView;
        imageView.setId(2114387596);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.cw.setAlpha(0.0f);
        j(context, "tt_splash_arrow", this.cw, false);
        this.cw.setLayoutParams(layoutParams3);
        this.xt.addView(this.cw);
        ImageView imageView2 = new ImageView(context);
        this.f28557r = imageView2;
        imageView2.setId(2114387595);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.f28557r.setAlpha(0.0f);
        j(context, "tt_splash_arrow", this.f28557r, true);
        this.f28557r.setLayoutParams(layoutParams4);
        this.xt.addView(this.f28557r);
        ImageView imageView3 = new ImageView(context);
        this.up = imageView3;
        imageView3.setId(2114387594);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.up.setAlpha(0.0f);
        j(context, "tt_splash_arrow", this.up, true);
        this.up.setLayoutParams(layoutParams5);
        this.xt.addView(this.up);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.xt.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.f28556m = frameLayout2;
        frameLayout2.setId(2114387593);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.f28556m.setClipChildren(false);
        this.f28556m.setLayoutParams(layoutParams6);
        frameLayout.addView(this.f28556m);
        ed.j((View) this.f28556m, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.f28554g = relativeLayout2;
        relativeLayout2.setId(2114387592);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.f28554g.setClipChildren(false);
        this.f28554g.setLayoutParams(layoutParams7);
        this.f28556m.addView(this.f28554g);
        ImageView imageView4 = new ImageView(context);
        this.ae = imageView4;
        imageView4.setId(2114387591);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        j(context, "tt_splash_hand", this.ae, false);
        this.ae.setLayoutParams(layoutParams8);
        this.f28554g.addView(this.ae);
        ed.j((View) this.ae, 4);
        return frameLayout;
    }

    private void xt() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cw, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new j());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cw, "translationX", 0.0f, ed.cw(getContext(), 20.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f28557r, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new j());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f28557r, "translationX", ed.cw(getContext(), 23.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.up, "alpha", 0.0f, 1.0f);
        ofFloat5.setInterpolator(new j());
        ofFloat5.setDuration(1300L);
        ofFloat5.setStartDelay(200L);
        ofFloat5.setRepeatCount(-1);
        ofFloat5.setRepeatMode(1);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.up, "translationX", ed.cw(getContext(), 25.0f));
        ofFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat6.setDuration(1300L);
        ofFloat6.setStartDelay(200L);
        ofFloat6.setRepeatCount(-1);
        ofFloat6.setRepeatMode(1);
        this.vl.playTogether(ofFloat, ofFloat3, ofFloat5, ofFloat2, ofFloat4, ofFloat6);
    }

    private void j() {
        this.f28555j.setVisibility(8);
        this.xt.setVisibility(8);
        int i6 = this.qv;
        if (i6 == 1) {
            this.xt.setVisibility(0);
            xt();
            return;
        }
        if (i6 == 2) {
            this.f28556m.setVisibility(0);
            post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.f28554g.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.tl.getMeasuredHeight() / 2.0f) - ed.cw(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.tl.getMeasuredWidth() / 2.0f) - ed.cw(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.tl.getMeasuredHeight()) / 2.0f) + ed.cw(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.tl.getMeasuredWidth()) / 2.0f) + ed.cw(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.f28554g.setLayoutParams(layoutParams);
                }
            });
            cw();
        } else {
            if (i6 == 3 || i6 == 4 || i6 == 5 || i6 == 7) {
                return;
            }
            this.f28555j.setVisibility(0);
        }
    }

    private void j(final Context context, final String str, final ImageView imageView, final boolean z5) {
        com.bytedance.sdk.component.utils.tl.cw().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3
            @Override // java.lang.Runnable
            public void run() {
                final Drawable cw = kt.cw(context, str);
                com.bytedance.sdk.component.utils.tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable;
                        try {
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            ImageView imageView2 = imageView;
                            if (imageView2 == null || (drawable = cw) == null) {
                                return;
                            }
                            if (z5) {
                                imageView2.setBackground(drawable);
                            } else {
                                imageView2.setImageDrawable(drawable);
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        });
    }
}
