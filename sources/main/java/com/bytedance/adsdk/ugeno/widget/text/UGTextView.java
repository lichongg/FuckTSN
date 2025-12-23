package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.cw;
import com.bytedance.adsdk.ugeno.cw.up;
import com.bytedance.adsdk.ugeno.j.ae;
import com.bytedance.adsdk.ugeno.j.tl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class UGTextView extends TextView implements up, ae {
    private tl cw;

    /* renamed from: j, reason: collision with root package name */
    private cw f23849j;
    private float xt;

    public float getBorderRadius() {
        return this.cw.j();
    }

    @Override // com.bytedance.adsdk.ugeno.cw.up, com.bytedance.adsdk.ugeno.j.ae
    public float getRipple() {
        return this.xt;
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getRubIn() {
        return this.cw.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getShine() {
        return this.cw.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.j.ae
    public float getStretch() {
        return this.cw.getStretch();
    }

    public void j(cw cwVar) {
        this.f23849j = cwVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.f23849j;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.f23849j;
        if (cwVar == null) {
            super.onMeasure(i6, i7);
        } else {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i6) {
        this.cw.j(i6);
    }

    public void setBorderRadius(float f6) {
        tl tlVar = this.cw;
        if (tlVar != null) {
            tlVar.j(f6);
        }
    }

    public void setRipple(float f6) {
        this.xt = f6;
        tl tlVar = this.cw;
        if (tlVar != null) {
            tlVar.xt(f6);
        }
        postInvalidate();
    }

    public void setRubIn(float f6) {
        tl tlVar = this.cw;
        if (tlVar != null) {
            tlVar.up(f6);
        }
    }

    public void setShine(float f6) {
        tl tlVar = this.cw;
        if (tlVar != null) {
            tlVar.cw(f6);
        }
    }

    public void setStretch(float f6) {
        tl tlVar = this.cw;
        if (tlVar != null) {
            tlVar.r(f6);
        }
    }

    public UGTextView(Context context) {
        super(context);
        this.cw = new tl(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f23849j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f23849j;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cw cwVar = this.f23849j;
        if (cwVar != null) {
            cwVar.j(canvas, this);
            this.f23849j.j(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        cw cwVar = this.f23849j;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i8);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.f23849j;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }
}
