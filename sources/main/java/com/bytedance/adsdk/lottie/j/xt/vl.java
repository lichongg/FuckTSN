package com.bytedance.adsdk.lottie.j.xt;

import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl extends ae<com.bytedance.adsdk.lottie.m.r> {

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.m.r f23315r;

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.m.r j(com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.m.r> jVar, float f6) {
        com.bytedance.adsdk.lottie.m.r rVar;
        float f7;
        com.bytedance.adsdk.lottie.m.r rVar2 = jVar.f23337j;
        if (rVar2 == null || (rVar = jVar.xt) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.m.r rVar3 = rVar2;
        com.bytedance.adsdk.lottie.m.r rVar4 = rVar;
        com.bytedance.adsdk.lottie.m.cw<A> cwVar = this.cw;
        if (cwVar != 0) {
            f7 = f6;
            com.bytedance.adsdk.lottie.m.r rVar5 = (com.bytedance.adsdk.lottie.m.r) cwVar.j(jVar.f23338m, jVar.ae.floatValue(), rVar3, rVar4, f7, r(), tl());
            if (rVar5 != null) {
                return rVar5;
            }
        } else {
            f7 = f6;
        }
        this.f23315r.j(com.bytedance.adsdk.lottie.up.tl.j(rVar3.j(), rVar4.j(), f7), com.bytedance.adsdk.lottie.up.tl.j(rVar3.xt(), rVar4.xt(), f7));
        return this.f23315r;
    }

    public vl(List<com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.m.r>> list) {
        super(list);
        this.f23315r = new com.bytedance.adsdk.lottie.m.r();
    }
}
