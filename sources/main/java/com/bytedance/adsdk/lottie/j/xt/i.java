package com.bytedance.adsdk.lottie.j.xt;

/* loaded from: D:\Downloads\app\classes3.dex */
public class i<K, A> extends j<K, A> {

    /* renamed from: r, reason: collision with root package name */
    private final A f23301r;

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    public void j(float f6) {
        this.xt = f6;
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    public A ae() {
        com.bytedance.adsdk.lottie.m.cw<A> cwVar = this.cw;
        A a6 = this.f23301r;
        return cwVar.j(0.0f, 0.0f, a6, a6, tl(), tl(), tl());
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    A j(com.bytedance.adsdk.lottie.m.j<K> jVar, float f6) {
        return ae();
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    float m() {
        return 1.0f;
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    public void xt() {
        if (this.cw != null) {
            super.xt();
        }
    }
}
