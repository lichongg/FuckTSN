package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsSlidePopUpView extends c {
    private ImageView KD;

    @DrawableRes
    private int KE;

    public KsSlidePopUpView(@NonNull Context context) {
        super(context);
    }

    public KsSlidePopUpView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i6, 0);
        this.KE = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_slide_square_bg);
        obtainStyledAttributes.recycle();
        this.KD = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.KD.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.KD, layoutParams);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return 500;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nu() {
        ImageView imageView = this.KD;
        if (imageView != null) {
            imageView.setImageResource(this.KE);
        }
    }

    public KsSlidePopUpView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final Animator fN() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        float a6 = com.kwad.sdk.c.a.a.a(getContext(), -60.0f);
        float a7 = com.kwad.sdk.c.a.a.a(getContext(), -68.0f);
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, "translationY", a6, a7).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "translationY", a7, a6).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "translationY", a6, a7).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "translationY", a7, a6).setDuration(200L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nv() {
        getInteractionView().setTranslationY(0.0f);
    }

    public final void nz() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(interactionView, "translationY", 0.0f, com.kwad.sdk.c.a.a.a(getContext(), -60.0f)).setDuration(300L), ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 1.0f).setDuration(300L));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsSlidePopUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                KsSlidePopUpView.this.nv();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                KsSlidePopUpView.this.getInteractionView().postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.widget.KsSlidePopUpView.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        KsSlidePopUpView.this.fM();
                    }
                }, KsSlidePopUpView.this.getAnimationDelayTime());
            }
        });
        animatorSet.start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this;
    }
}
