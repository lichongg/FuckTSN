package com.bytedance.adsdk.ugeno.widget.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class UGScrollView extends ScrollView {

    /* renamed from: j, reason: collision with root package name */
    private cw f23847j;

    public void j(cw cwVar) {
        this.f23847j = cwVar;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        cw cwVar = this.f23847j;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        cw cwVar = this.f23847j;
        if (cwVar != null) {
            int[] j6 = cwVar.j(i6, i7);
            super.onMeasure(j6[0], j6[1]);
        } else {
            super.onMeasure(i6, i7);
        }
        super.onMeasure(i6, i7);
    }

    public UGScrollView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f23847j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f23847j;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        cw cwVar = this.f23847j;
        if (cwVar != null) {
            cwVar.xt(i6, i7, i8, i9);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.f23847j;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }
}
