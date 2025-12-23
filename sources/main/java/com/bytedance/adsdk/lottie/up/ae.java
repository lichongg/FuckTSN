package com.bytedance.adsdk.lottie.up;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private float f23552j;
    private int xt;

    public void j(float f6) {
        float f7 = this.f23552j + f6;
        this.f23552j = f7;
        int i6 = this.xt + 1;
        this.xt = i6;
        if (i6 == Integer.MAX_VALUE) {
            this.f23552j = f7 / 2.0f;
            this.xt = i6 / 2;
        }
    }
}
