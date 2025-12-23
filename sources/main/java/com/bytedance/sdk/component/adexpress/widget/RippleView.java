package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RippleView extends View {
    private float ae;
    private ValueAnimator cw;

    /* renamed from: g, reason: collision with root package name */
    private Animator.AnimatorListener f25959g;

    /* renamed from: j, reason: collision with root package name */
    private float f25960j;

    /* renamed from: m, reason: collision with root package name */
    private long f25961m;
    private int oq;

    /* renamed from: r, reason: collision with root package name */
    private ValueAnimator f25962r;
    private float tl;
    private Paint up;
    private float xt;

    public void cw() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.tl, 0.0f);
        this.f25962r = ofFloat;
        ofFloat.setDuration(this.f25961m);
        this.f25962r.setInterpolator(new LinearInterpolator());
        this.f25962r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.ae = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.f25959g;
        if (animatorListener != null) {
            this.f25962r.addListener(animatorListener);
        }
        this.f25962r.start();
    }

    public void j() {
        Paint paint = new Paint(1);
        this.up = paint;
        paint.setStyle(Paint.Style.FILL);
        this.up.setColor(this.oq);
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.f25959g = animatorListener;
    }

    public void xt() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.tl);
        this.cw = ofFloat;
        ofFloat.setDuration(this.f25961m);
        this.cw.setInterpolator(new LinearInterpolator());
        this.cw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.ae = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.cw.start();
    }

    public RippleView(Context context, int i6) {
        super(context);
        this.f25961m = 300L;
        this.ae = 0.0f;
        this.oq = i6;
        j();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f25960j, this.xt, this.ae, this.up);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f25960j = i6 / 2.0f;
        this.xt = i7 / 2.0f;
        this.tl = (float) (Math.hypot(i6, i7) / 2.0d);
    }
}
