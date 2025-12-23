package com.bytedance.sdk.component.cw.j;

import java.io.UnsupportedEncodingException;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes4.dex */
final class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f26112j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] xt = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String j(byte[] bArr) {
        return j(bArr, f26112j);
    }

    private static String j(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            bArr3[i6] = bArr2[(bArr[i7] & 255) >> 2];
            int i8 = i7 + 1;
            bArr3[i6 + 1] = bArr2[((bArr[i7] & 3) << 4) | ((bArr[i8] & 255) >> 4)];
            int i9 = i6 + 3;
            int i10 = (bArr[i8] & 15) << 2;
            int i11 = i7 + 2;
            bArr3[i6 + 2] = bArr2[i10 | ((bArr[i11] & 255) >> 6)];
            i6 += 4;
            bArr3[i9] = bArr2[bArr[i11] & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            bArr3[i6] = bArr2[(bArr[length] & 255) >> 2];
            bArr3[i6 + 1] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i6 + 2] = 61;
            bArr3[i6 + 3] = 61;
        } else if (length2 == 2) {
            bArr3[i6] = bArr2[(bArr[length] & 255) >> 2];
            int i12 = (bArr[length] & 3) << 4;
            int i13 = length + 1;
            bArr3[i6 + 1] = bArr2[((bArr[i13] & 255) >> 4) | i12];
            bArr3[i6 + 2] = bArr2[(bArr[i13] & 15) << 2];
            bArr3[i6 + 3] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e6) {
            throw new AssertionError(e6);
        }
    }
}
