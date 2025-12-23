package com.bytedance.adsdk.lottie.j.xt;

import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends ae<Float> {
    float cw(com.bytedance.adsdk.lottie.m.j<Float> jVar, float f6) {
        float f7;
        if (jVar.f23337j == null || jVar.xt == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.m.cw<A> cwVar = this.cw;
        if (cwVar != 0) {
            f7 = f6;
            Float f8 = (Float) cwVar.j(jVar.f23338m, jVar.ae.floatValue(), jVar.f23337j, jVar.xt, f7, r(), tl());
            if (f8 != null) {
                return f8.floatValue();
            }
        } else {
            f7 = f6;
        }
        return com.bytedance.adsdk.lottie.up.tl.j(jVar.m(), jVar.ae(), f7);
    }

    public r(List<com.bytedance.adsdk.lottie.m.j<Float>> list) {
        super(list);
    }

    public float g() {
        return cw(cw(), up());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public Float j(com.bytedance.adsdk.lottie.m.j<Float> jVar, float f6) {
        return Float.valueOf(cw(jVar, f6));
    }
}
