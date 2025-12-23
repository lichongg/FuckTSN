package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BluePressInteractView extends FrameLayout {
    private ImageView ae;
    private boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private int f25870g;

    /* renamed from: j, reason: collision with root package name */
    private AnimatorSet f25871j;

    /* renamed from: m, reason: collision with root package name */
    private View f25872m;
    private Context oq;

    /* renamed from: r, reason: collision with root package name */
    private View f25873r;
    private int tl;
    private View up;
    private ObjectAnimator xt;

    private void cw() {
        View view = new View(this.oq);
        this.f25873r = view;
        view.setBackground(j("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (this.tl * 0.45d), (int) (this.f25870g * 0.45d));
        layoutParams.gravity = 17;
        this.f25873r.setLayoutParams(layoutParams);
        addView(this.f25873r);
        View view2 = new View(this.oq);
        this.up = view2;
        view2.setBackground(j("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (this.tl * 0.25d), (int) (this.f25870g * 0.25d));
        layoutParams2.gravity = 17;
        this.up.setLayoutParams(layoutParams2);
        addView(this.up);
        View view3 = new View(this.oq);
        this.f25872m = view3;
        view3.setBackground(j("#807BBEFF", "#FF7BBEFF"));
        int i6 = this.tl;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (i6 * 0.25d), (int) (i6 * 0.25d));
        layoutParams3.gravity = 17;
        this.f25872m.setLayoutParams(layoutParams3);
        addView(this.f25872m);
        ImageView imageView = new ImageView(this.oq);
        this.ae = imageView;
        imageView.setImageResource(kt.up(getContext(), "tt_blue_hand"));
        this.ae.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (this.tl * 0.62d), (int) (this.f25870g * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.ae.setLayoutParams(layoutParams4);
        addView(this.ae);
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f25873r, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f25873r, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.up, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.up, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f25872m, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f25872m, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ae, "rotation", 0.0f, -20.0f, 0.0f);
        this.xt = ofFloat7;
        ofFloat7.setDuration(1000L);
        this.f25871j.setDuration(1500L);
        this.f25871j.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f25871j.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.f25871j.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.cw = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.cw) {
                    return;
                }
                BluePressInteractView.this.xt.start();
                BluePressInteractView.this.f25871j.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    public void xt() {
        this.cw = true;
        ObjectAnimator objectAnimator = this.xt;
        if (objectAnimator == null || this.f25871j == null) {
            return;
        }
        objectAnimator.cancel();
        this.f25871j.cancel();
    }

    public BluePressInteractView(Context context, int i6, int i7) {
        super(context);
        this.cw = false;
        this.f25871j = new AnimatorSet();
        this.tl = i6;
        this.f25870g = i7;
        this.oq = context;
        cw();
        r();
    }

    private GradientDrawable j(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void j() {
        this.cw = false;
        ObjectAnimator objectAnimator = this.xt;
        if (objectAnimator == null || this.f25871j == null) {
            return;
        }
        objectAnimator.start();
        this.f25871j.start();
    }
}
