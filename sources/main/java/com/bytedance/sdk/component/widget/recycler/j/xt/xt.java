package com.bytedance.sdk.component.widget.recycler.j.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
class xt {

    /* renamed from: j, reason: collision with root package name */
    static final int[] f27087j = new int[0];
    static final long[] xt = new long[0];
    static final Object[] cw = new Object[0];

    public static int j(int i6) {
        return xt(i6 * 8) / 8;
    }

    public static int xt(int i6) {
        for (int i7 = 4; i7 < 32; i7++) {
            int i8 = (1 << i7) - 12;
            if (i6 <= i8) {
                return i8;
            }
        }
        return i6;
    }

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

    static int j(long[] jArr, int i6, long j6) {
        int i7 = i6 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            long j7 = jArr[i9];
            if (j7 < j6) {
                i8 = i9 + 1;
            } else {
                if (j7 <= j6) {
                    return i9;
                }
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }
}
