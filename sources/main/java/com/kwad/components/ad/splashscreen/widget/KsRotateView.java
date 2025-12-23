package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsRotateView extends c {
    private static int Ke = 50;
    private static int Kf = -12;
    private static int Kg = -25;
    private static int Kh = 12;
    private static int Ki = 25;

    @DrawableRes
    private int Kd;
    private ImageView ig;
    private ImageView qg;

    public KsRotateView(@NonNull Context context) {
        super(context);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i6, 0);
        this.Kd = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_rotate_phone);
        obtainStyledAttributes.recycle();
        ImageView imageView = new ImageView(getContext());
        this.qg = imageView;
        imageView.setImageResource(R.drawable.ksad_ic_rotate_line);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        addView(this.qg, layoutParams);
        this.ig = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(context, 22.0f);
        layoutParams2.gravity = 1;
        addView(this.ig, layoutParams2);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this.ig;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nu() {
        this.ig.setImageResource(this.Kd);
    }

    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final Animator fN() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        interactionView.setPivotX(interactionView.getWidth() / 2.0f);
        interactionView.setPivotY(interactionView.getHeight() / 2.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Kg).setDuration(500L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, "rotation", Kg, 0.0f).setDuration(Ke);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Kh).setDuration(Ke);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, "rotation", Kh, 0.0f).setDuration(Ke);
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Kf).setDuration(Ke);
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, "rotation", Kf, 0.0f).setDuration(Ke);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat2.setDuration(500L);
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Ki).setDuration(500L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(340L);
        animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, "rotation", Ki, 0.0f).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Kf).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, "rotation", Kf, 0.0f).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, "rotation", 0.0f, Kh).setDuration(Ke), ObjectAnimator.ofFloat(interactionView, "rotation", Kh, 0.0f).setDuration(Ke));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nv() {
        getInteractionView().setRotation(0.0f);
    }
}
