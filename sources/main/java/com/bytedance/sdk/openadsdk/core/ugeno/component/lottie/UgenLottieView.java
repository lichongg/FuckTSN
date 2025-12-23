package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.ugeno.cw;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UgenLottieView extends LottieAnimationView {

    /* renamed from: j, reason: collision with root package name */
    private cw f30630j;

    public void j(cw cwVar) {
        this.f30630j = cwVar;
    }

    public UgenLottieView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cw cwVar = this.f30630j;
        if (cwVar != null) {
            cwVar.up();
        }
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cw cwVar = this.f30630j;
        if (cwVar != null) {
            cwVar.m();
        }
    }
}
