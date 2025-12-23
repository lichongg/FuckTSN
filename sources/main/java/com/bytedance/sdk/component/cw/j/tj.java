package com.bytedance.sdk.component.cw.j;

import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
final class tj {

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f26105j = Charset.forName("UTF-8");

    public static int j(int i6) {
        return ((i6 & 255) << 24) | (((-16777216) & i6) >>> 24) | ((16711680 & i6) >>> 8) | ((65280 & i6) << 8);
    }

    public static short j(short s5) {
        return (short) (((s5 & 255) << 8) | ((65280 & s5) >>> 8));
    }

    public static void j(long j6, long j7, long j8) {
        if ((j7 | j8) < 0 || j7 > j6 || j6 - j7 < j8) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8)));
        }
    }

    public static void j(Throwable th) {
        xt(th);
    }

    public static boolean j(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (bArr[i9 + i6] != bArr2[i9 + i7]) {
                return false;
            }
        }
        return true;
    }

    private static <T extends Throwable> void xt(Throwable th) throws Throwable {
        throw th;
    }
}
