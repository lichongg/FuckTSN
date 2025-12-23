package com.bytedance.adsdk.lottie.model.j;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends ws<com.bytedance.adsdk.lottie.model.xt.r, com.bytedance.adsdk.lottie.model.xt.r> {
    private static List<com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt.r>> j(List<com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt.r>> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            list.set(i6, j(list.get(i6)));
        }
        return list;
    }

    public cw(List<com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt.r>> list) {
        super(j(list));
    }

    private static com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt.r> j(com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt.r> jVar) {
        com.bytedance.adsdk.lottie.model.xt.r rVar = jVar.f23337j;
        com.bytedance.adsdk.lottie.model.xt.r rVar2 = jVar.xt;
        if (rVar == null || rVar2 == null || rVar.j().length == rVar2.j().length) {
            return jVar;
        }
        float[] j6 = j(rVar.j(), rVar2.j());
        return jVar.j(rVar.j(j6), rVar2.j(j6));
    }

    @Override // com.bytedance.adsdk.lottie.model.j.ws, com.bytedance.adsdk.lottie.model.j.jy
    public /* bridge */ /* synthetic */ List cw() {
        return super.cw();
    }

    @Override // com.bytedance.adsdk.lottie.model.j.ws
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.bytedance.adsdk.lottie.model.j.ws, com.bytedance.adsdk.lottie.model.j.jy
    public /* bridge */ /* synthetic */ boolean xt() {
        return super.xt();
    }

    static float[] j(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f6 = Float.NaN;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            float f7 = fArr3[i7];
            if (f7 != f6) {
                fArr3[i6] = f7;
                i6++;
                f6 = fArr3[i7];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i6);
    }

    @Override // com.bytedance.adsdk.lottie.model.j.jy
    public com.bytedance.adsdk.lottie.j.xt.j<com.bytedance.adsdk.lottie.model.xt.r, com.bytedance.adsdk.lottie.model.xt.r> j() {
        return new com.bytedance.adsdk.lottie.j.xt.up(this.f23365j);
    }
}
