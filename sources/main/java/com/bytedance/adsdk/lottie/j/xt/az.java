package com.bytedance.adsdk.lottie.j.xt;

import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class az extends ae<com.bytedance.adsdk.lottie.model.xt> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.xt j(com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt> jVar, float f6) {
        com.bytedance.adsdk.lottie.model.xt xtVar;
        com.bytedance.adsdk.lottie.m.cw<A> cwVar = this.cw;
        if (cwVar == 0) {
            return (f6 != 1.0f || (xtVar = jVar.xt) == null) ? jVar.f23337j : xtVar;
        }
        float f7 = jVar.f23338m;
        Float f8 = jVar.ae;
        float floatValue = f8 == null ? Float.MAX_VALUE : f8.floatValue();
        com.bytedance.adsdk.lottie.model.xt xtVar2 = jVar.f23337j;
        com.bytedance.adsdk.lottie.model.xt xtVar3 = jVar.xt;
        return (com.bytedance.adsdk.lottie.model.xt) cwVar.j(f7, floatValue, xtVar2, xtVar3 == null ? xtVar2 : xtVar3, f6, up(), tl());
    }

    public az(List<com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt>> list) {
        super(list);
    }
}
