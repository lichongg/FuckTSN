package com.bytedance.adsdk.lottie;

/* loaded from: D:\Downloads\app\classes3.dex */
class xt {

    /* renamed from: j, reason: collision with root package name */
    static final int[] f23572j = new int[0];
    static final long[] xt = new long[0];
    static final Object[] cw = new Object[0];

    static int j(int[] iArr, int i6, int i7) {
        int i8 = i6 - 1;
        int i9 = 0;
        while (i9 <= i8) {
            int i10 = (i9 + i8) >>> 1;
            int i11 = iArr[i10];
            if (i11 < i7) {
                i9 = i10 + 1;
            } else {
                if (i11 <= i7) {
                    return i10;
                }
                i8 = i10 - 1;
            }
        }
        return ~i9;
    }
}
