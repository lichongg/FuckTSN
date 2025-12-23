package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.t.o;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsShakeView extends KSFrameLayout {
    private int Kj;
    private float Kk;

    @ColorInt
    private int Kl;

    @ColorInt
    private int Km;

    @ColorInt
    private int Kn;
    private float Ko;
    private float Kp;

    @DrawableRes
    private int Kq;
    private Animator Kr;
    private boolean Ks;
    private ImageView ig;

    @Nullable
    private Animator ih;
    private Paint mPaint;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    @MainThread
    public final void nx() {
        this.Ks = false;
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
            this.ih = null;
        }
        Animator a6 = a(this.ig, 100L, 16.0f);
        this.ih = a6;
        if (a6 != null) {
            a6.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.ig.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (!KsShakeView.this.Ks && KsShakeView.this.ih != null) {
                        KsShakeView.this.ih.start();
                    }
                }
            });
            this.ih.start();
        }
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i6, 0);
        this.Kk = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.Kl = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.Km = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.Kj = obtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.Kn = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.Ko = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.Kq = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
        this.Kp = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, com.kwad.sdk.c.a.a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.ig = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.ig, layoutParams);
        nu();
    }

    private void nu() {
        this.ig.setImageResource(this.Kq);
    }

    public final void aq(int i6) {
        this.Kj = i6;
        if (i6 != 2) {
            setIconDrawableRes(R.drawable.ksad_ic_shake_hand);
        } else {
            setIconDrawableRes(R.drawable.ksad_ic_shake_phone);
        }
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) {
        this.Ks = true;
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
        }
        this.ig.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_splash_shake_animator_height);
        Animator animator2 = this.Kr;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator b6 = b(this, 100L, dimensionPixelSize);
        this.Kr = b6;
        b6.addListener(animatorListenerAdapter);
        this.Kr.start();
    }

    public final void ny() {
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.Kr;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.ih = null;
        this.Kr = null;
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i6) {
        ImageView imageView = this.ig;
        if (imageView != null) {
            imageView.setImageResource(i6);
        }
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.mPaint = new Paint();
        this.Ks = false;
        a(context, attributeSet, i6);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.Km);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Ko);
        paint.setColor(this.Kn);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Kk);
        paint.setColor(this.Kl);
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        Animator animator = this.ih;
        if (animator != null) {
            animator.cancel();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        if (this.Kj == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.Kp, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
    }

    private static Animator b(View view, long j6, float f6) {
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", f6).setDuration(100L);
        duration.setInterpolator(create);
        float f7 = -f6;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "translationY", f7).setDuration(200L);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", f6).setDuration(200L);
        duration3.setInterpolator(create);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "translationY", f7).setDuration(200L);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "translationY", f6).setDuration(100L), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }

    private Animator a(View view, long j6, float f6) {
        Interpolator create;
        if (view == null) {
            return null;
        }
        if (this.Kj == 1) {
            create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else {
            create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight() / 2.0f);
        }
        return o.a(view, create, 100L, 16.0f);
    }
}
