package com.bytedance.adsdk.lottie.j.xt;

import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends ae<Integer> {
    int cw(com.bytedance.adsdk.lottie.m.j<Integer> jVar, float f6) {
        float f7;
        if (jVar.f23337j == null || jVar.xt == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.m.cw<A> cwVar = this.cw;
        if (cwVar != 0) {
            f7 = f6;
            Integer num = (Integer) cwVar.j(jVar.f23338m, jVar.ae.floatValue(), jVar.f23337j, jVar.xt, f7, r(), tl());
            if (num != null) {
                return num.intValue();
            }
        } else {
            f7 = f6;
        }
        return com.bytedance.adsdk.lottie.up.tl.j(jVar.tl(), jVar.g(), f7);
    }

    public m(List<com.bytedance.adsdk.lottie.m.j<Integer>> list) {
        super(list);
    }

    public int g() {
        return cw(cw(), up());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public Integer j(com.bytedance.adsdk.lottie.m.j<Integer> jVar, float f6) {
        return Integer.valueOf(cw(jVar, f6));
    }
}
