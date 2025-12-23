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
public class KsSlideArrowView extends c {
    private ImageView Ku;

    @DrawableRes
    private int Kv;
    private int Kw;

    public KsSlideArrowView(@NonNull Context context) {
        super(context);
        this.Kw = 0;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i6, 0);
        this.Kv = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_splash_slide_tag);
        obtainStyledAttributes.recycle();
        this.Ku = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.Ku.setScaleType(ImageView.ScaleType.FIT_XY);
        this.Ku.setAlpha(0.0f);
        addView(this.Ku, layoutParams);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected int getAnimationDelayTime() {
        return this.Kw;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected View getInteractionView() {
        return this.Ku;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nu() {
        ImageView imageView = this.Ku;
        if (imageView != null) {
            imageView.setImageResource(this.Kv);
        }
    }

    public void setAnimationDelayTime(int i6) {
        this.Kw = i6;
    }

    public KsSlideArrowView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kw = 0;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final Animator fN() {
        View interactionView = getInteractionView();
        if (interactionView == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 1.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 1.0f, 0.0f).setDuration(200L), ObjectAnimator.ofFloat(interactionView, "alpha", 0.0f, 0.0f).setDuration(200L));
        return animatorSet;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.c
    protected final void nv() {
        getInteractionView().setAlpha(1.0f);
    }

    public KsSlideArrowView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.Kw = 0;
    }
}
