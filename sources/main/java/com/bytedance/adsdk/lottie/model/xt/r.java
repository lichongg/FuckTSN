package com.bytedance.adsdk.lottie.model.xt;

import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private final float[] f23477j;
    private final int[] xt;

    public float[] j() {
        return this.f23477j;
    }

    public int cw() {
        return this.xt.length;
    }

    public void j(r rVar, r rVar2, float f6) {
        if (rVar.xt.length == rVar2.xt.length) {
            for (int i6 = 0; i6 < rVar.xt.length; i6++) {
                this.f23477j[i6] = com.bytedance.adsdk.lottie.up.tl.j(rVar.f23477j[i6], rVar2.f23477j[i6], f6);
                this.xt[i6] = com.bytedance.adsdk.lottie.up.cw.j(f6, rVar.xt[i6], rVar2.xt[i6]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + rVar.xt.length + " vs " + rVar2.xt.length + ")");
    }

    public int[] xt() {
        return this.xt;
    }

    public r(float[] fArr, int[] iArr) {
        this.f23477j = fArr;
        this.xt = iArr;
    }

    public r j(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i6 = 0; i6 < fArr.length; i6++) {
            iArr[i6] = j(fArr[i6]);
        }
        return new r(fArr, iArr);
    }

    private int j(float f6) {
        int binarySearch = Arrays.binarySearch(this.f23477j, f6);
        if (binarySearch >= 0) {
            return this.xt[binarySearch];
        }
        int i6 = -(binarySearch + 1);
        if (i6 == 0) {
            return this.xt[0];
        }
        int[] iArr = this.xt;
        if (i6 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f23477j;
        int i7 = i6 - 1;
        float f7 = fArr[i7];
        return com.bytedance.adsdk.lottie.up.cw.j((f6 - f7) / (fArr[i6] - f7), iArr[i7], iArr[i6]);
    }
}
