package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import com.bytedance.adsdk.ugeno.cw;
import com.bytedance.sdk.component.adexpress.widget.GifView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UgenGif extends GifView {

    /* renamed from: j, reason: collision with root package name */
    private cw f30575j;

    public void j(cw cwVar) {
        this.f30575j = cwVar;
    }

    public UgenGif(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f30575j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f30575j;
        if (cwVar != null) {
            cwVar.m();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        cw cwVar = this.f30575j;
        if (cwVar != null) {
            cwVar.j(i6, i7, i8, i9);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.GifView, android.widget.ImageView, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        cw cwVar = this.f30575j;
        if (cwVar != null) {
            cwVar.cw();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        cw cwVar = this.f30575j;
        if (cwVar != null) {
            cwVar.j(z5);
        }
    }
}
