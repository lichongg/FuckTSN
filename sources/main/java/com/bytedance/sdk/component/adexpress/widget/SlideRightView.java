package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SlideRightView extends FrameLayout {
    private AnimatorSet ae;
    private ImageView cw;

    /* renamed from: g, reason: collision with root package name */
    private AnimatorSet f25974g;

    /* renamed from: j, reason: collision with root package name */
    private Context f25975j;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f25976m;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f25977r;
    private AnimatorSet tl;
    private TextView up;
    private ImageView xt;

    private void cw() {
        ImageView imageView = new ImageView(this.f25975j);
        this.f25977r = imageView;
        imageView.setBackgroundResource(kt.up(this.f25975j, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) tl.j(this.f25975j, 30.0f);
        addView(this.f25977r, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.f25975j);
        this.cw = imageView2;
        imageView2.setImageResource(kt.up(this.f25975j, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) tl.j(this.f25975j, 50.0f), (int) tl.j(this.f25975j, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) tl.j(this.f25975j, 30.0f);
        addView(this.cw, layoutParams2);
        ImageView imageView3 = new ImageView(this.f25975j);
        this.xt = imageView3;
        imageView3.setImageResource(kt.up(this.f25975j, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) tl.j(this.f25975j, 80.0f), (int) tl.j(this.f25975j, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) tl.j(this.f25975j, 30.0f);
        addView(this.xt, layoutParams3);
        TextView textView = new TextView(this.f25975j);
        this.up = textView;
        textView.setTextColor(-1);
        this.up.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.up, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.xt.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.cw.getMeasuredHeight() / 2.0f) - tl.j(SlideRightView.this.getContext(), 7.0f));
                int j6 = (-SlideRightView.this.cw.getMeasuredWidth()) + ((int) tl.j(SlideRightView.this.f25975j, 30.0f));
                layoutParams5.leftMargin = j6;
                layoutParams5.setMarginStart(j6);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.xt.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.f25977r.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.cw.getMeasuredHeight() / 2.0f) - tl.j(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.cw.getMeasuredWidth() / 2.0f) + ((int) tl.j(SlideRightView.this.f25975j, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.f25977r.setLayoutParams(layoutParams6);
            }
        });
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xt, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cw, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.cw, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f25977r, "alpha", 0.0f, 1.0f);
        this.tl.setDuration(300L);
        this.tl.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.xt, "translationX", 0.0f, tl.j(getContext(), 90.0f));
        ofFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) tl.j(getContext(), 90.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.f25977r.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.f25977r.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.cw, "translationX", 0.0f, tl.j(getContext(), 90.0f));
        ofFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.f25974g.setDuration(1500L);
        this.f25974g.playTogether(ofFloat5, ofInt, ofFloat6);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.xt, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f25977r, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.cw, "alpha", 1.0f, 0.0f);
        this.ae.setDuration(50L);
        this.ae.playTogether(ofFloat7, ofFloat8, ofFloat9);
        this.f25976m.playSequentially(this.tl, this.f25974g, this.ae);
    }

    public void j() {
        r();
        this.f25976m.start();
        this.f25976m.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.f25976m.start();
                    }
                }, 200L);
            }
        });
    }

    public void setGuideText(String str) {
        this.up.setText(str);
    }

    public void xt() {
        try {
            AnimatorSet animatorSet = this.f25976m;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.tl;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.f25974g;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.ae;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public SlideRightView(Context context) {
        super(context);
        this.f25976m = new AnimatorSet();
        this.ae = new AnimatorSet();
        this.tl = new AnimatorSet();
        this.f25974g = new AnimatorSet();
        this.f25975j = context;
        cw();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
    }
}
