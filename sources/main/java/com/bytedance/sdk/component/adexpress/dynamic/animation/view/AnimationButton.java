package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class AnimationButton extends TextView implements xt {
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    j f25581j;

    /* renamed from: r, reason: collision with root package name */
    private float f25582r;
    private float up;
    private float xt;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt
    public float getMarqueeValue() {
        return this.f25582r;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt
    public float getRippleValue() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt
    public float getShineValue() {
        return this.cw;
    }

    public float getStretchValue() {
        return this.up;
    }

    public void setMarqueeValue(float f6) {
        this.f25582r = f6;
        postInvalidate();
    }

    public void setRippleValue(float f6) {
        this.xt = f6;
        postInvalidate();
    }

    public void setShineValue(float f6) {
        this.cw = f6;
        postInvalidate();
    }

    public void setStretchValue(float f6) {
        this.up = f6;
        this.f25581j.j(this, f6);
    }

    public AnimationButton(Context context) {
        super(context);
        this.f25581j = new j();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f25581j.j(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f25581j.j(this, i6, i7);
    }
}
