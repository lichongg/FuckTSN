package com.bytedance.sdk.component.cw.xt.j.up;

import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class up {

    /* renamed from: j, reason: collision with root package name */
    static final com.bytedance.sdk.component.cw.j.m f26298j = com.bytedance.sdk.component.cw.j.m.j("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: r, reason: collision with root package name */
    private static final String[] f26299r = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] xt = new String[64];
    static final String[] cw = new String[256];

    static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.component.cw.xt.j.cw.j(str, objArr));
    }

    static {
        int i6 = 0;
        int i7 = 0;
        while (true) {
            String[] strArr = cw;
            if (i7 >= strArr.length) {
                break;
            }
            strArr[i7] = com.bytedance.sdk.component.cw.xt.j.cw.j("%8s", Integer.toBinaryString(i7)).replace(' ', '0');
            i7++;
        }
        String[] strArr2 = xt;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i8 = 0; i8 <= 0; i8++) {
            int i9 = iArr[i8];
            String[] strArr3 = xt;
            strArr3[i9 | 8] = strArr3[i9] + "|PADDED";
        }
        String[] strArr4 = xt;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr2[i10];
            for (int i12 = 0; i12 <= 0; i12++) {
                int i13 = iArr[i12];
                String[] strArr5 = xt;
                int i14 = i13 | i11;
                strArr5[i14] = strArr5[i13] + '|' + strArr5[i11];
                strArr5[i14 | 8] = strArr5[i13] + '|' + strArr5[i11] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = xt;
            if (i6 >= strArr6.length) {
                return;
            }
            if (strArr6[i6] == null) {
                strArr6[i6] = cw[i6];
            }
            i6++;
        }
    }

    static String j(boolean z5, int i6, int i7, byte b6, byte b7) {
        String[] strArr = f26299r;
        return com.bytedance.sdk.component.cw.xt.j.cw.j("%s 0x%08x %5d %-13s %s", z5 ? "<<" : ">>", Integer.valueOf(i6), Integer.valueOf(i7), b6 < strArr.length ? strArr[b6] : com.bytedance.sdk.component.cw.xt.j.cw.j("0x%02x", Byte.valueOf(b6)), j(b6, b7));
    }

    static IOException xt(String str, Object... objArr) throws IOException {
        throw new IOException(com.bytedance.sdk.component.cw.xt.j.cw.j(str, objArr));
    }

    private up() {
    }

    static String j(byte b6, byte b7) {
        if (b7 == 0) {
            return "";
        }
        if (b6 != 2 && b6 != 3) {
            if (b6 == 4 || b6 == 6) {
                return b7 == 1 ? "ACK" : cw[b7];
            }
            if (b6 != 7 && b6 != 8) {
                String[] strArr = xt;
                String str = b7 < strArr.length ? strArr[b7] : cw[b7];
                if (b6 != 5 || (b7 & 4) == 0) {
                    return (b6 != 0 || (b7 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return cw[b7];
    }
}
