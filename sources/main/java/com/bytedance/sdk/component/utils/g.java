package com.bytedance.sdk.component.utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    private static final int ae;
    private static final byte[] cw;

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f26882j;

    /* renamed from: m, reason: collision with root package name */
    private static final byte[] f26883m;

    /* renamed from: r, reason: collision with root package name */
    private static final byte[] f26884r;
    private static final byte[] up;
    private static final byte[] xt;

    static {
        byte[] bArr = {-1, -40, -1};
        f26882j = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        xt = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        cw = bArr3;
        byte[] j6 = j("BM");
        f26884r = j6;
        up = j("GIF87a");
        f26883m = j("GIF89a");
        ae = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(j6.length), 6))).intValue();
    }

    private static boolean cw(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = xt;
        return length >= bArr2.length && j(bArr, bArr2);
    }

    public static int j() {
        return ae;
    }

    private static boolean m(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = cw;
        return length >= bArr2.length && j(bArr, bArr2);
    }

    private static boolean r(byte[] bArr) {
        return (bArr.length >= 6 && j(bArr, up)) || j(bArr, f26883m);
    }

    private static boolean up(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = f26884r;
        return length >= bArr2.length && j(bArr, bArr2);
    }

    private static boolean xt(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = f26882j;
        return length >= bArr2.length && j(bArr, bArr2);
    }

    public static final String j(byte[] bArr) {
        return xt(bArr) ? "jpeg" : cw(bArr) ? "png" : r(bArr) ? "gif" : up(bArr) ? "bmp" : m(bArr) ? "ico" : "other";
    }

    private static boolean j(byte[] bArr, byte[] bArr2) {
        return j(bArr, bArr2, 0);
    }

    private static boolean j(byte[] bArr, byte[] bArr2, int i6) {
        if (bArr2.length + i6 > bArr.length) {
            return false;
        }
        for (int i7 = 0; i7 < bArr2.length; i7++) {
            if (bArr[i6 + i7] != bArr2[i7]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] j(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("ASCII not found!", e6);
        }
    }
}
