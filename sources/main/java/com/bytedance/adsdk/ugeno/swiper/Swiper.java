package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class Swiper extends BaseSwiper<cw> {

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.cw f23732r;

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View ae(int i6) {
        return ((cw) this.f23721j.get(i6)).g();
    }

    public void j(com.bytedance.adsdk.ugeno.cw cwVar) {
        this.f23732r = cwVar;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23732r;
        if (cwVar != null) {
            cwVar.r();
        }
        super.onLayout(z5, i6, i7, i8, i9);
        com.bytedance.adsdk.ugeno.cw cwVar2 = this.f23732r;
        if (cwVar2 != null) {
            cwVar2.j(i6, i7, i8, i9);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23732r;
        if (cwVar != null) {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        } else {
            super.onMeasure(i6, i7);
        }
        com.bytedance.adsdk.ugeno.cw cwVar2 = this.f23732r;
        if (cwVar2 != null) {
            cwVar2.cw();
        }
    }

    public Swiper(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23732r;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23732r;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23732r;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        com.bytedance.adsdk.ugeno.cw cwVar = this.f23732r;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }
}
