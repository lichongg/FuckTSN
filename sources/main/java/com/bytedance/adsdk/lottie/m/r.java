package com.bytedance.adsdk.lottie.m;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private float f23343j;
    private float xt;

    public r(float f6, float f7) {
        this.f23343j = f6;
        this.xt = f7;
    }

    public float j() {
        return this.f23343j;
    }

    public float xt() {
        return this.xt;
    }

    public void j(float f6, float f7) {
        this.f23343j = f6;
        this.xt = f7;
    }

    public String toString() {
        return j() + "x" + xt();
    }

    public boolean xt(float f6, float f7) {
        return this.f23343j == f6 && this.xt == f7;
    }

    public r() {
        this(1.0f, 1.0f);
    }
}
