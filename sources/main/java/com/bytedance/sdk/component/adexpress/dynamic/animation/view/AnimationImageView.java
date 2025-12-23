package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.ae;

/* loaded from: D:\Downloads\app\classes4.dex */
public class AnimationImageView extends ImageView implements xt {
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    j f25583j;

    /* renamed from: m, reason: collision with root package name */
    private ae f25584m;

    /* renamed from: r, reason: collision with root package name */
    private float f25585r;
    private float up;
    private float xt;

    public ae getBrickNativeValue() {
        return this.f25584m;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt
    public float getMarqueeValue() {
        return this.f25585r;
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

    public void setBrickNativeValue(ae aeVar) {
        this.f25584m = aeVar;
    }

    public void setMarqueeValue(float f6) {
        this.f25585r = f6;
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
        this.f25583j.j(this, f6);
    }

    public AnimationImageView(Context context) {
        super(context);
        this.f25583j = new j();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        ae aeVar;
        super.onDraw(canvas);
        this.f25583j.j(canvas, this, this);
        if (getRippleValue() != 0.0f && (aeVar = this.f25584m) != null && aeVar.xt() > 0) {
            ((ViewGroup) getParent()).setClipChildren(false);
            ((ViewGroup) getParent().getParent()).setClipChildren(false);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f25583j.j(this, i6, i7);
    }
}
