package com.bytedance.sdk.component.adexpress.r;

import com.bytedance.sdk.component.utils.vl;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f25840j = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] xt = {97, 99, 84, 76};

    public static boolean j(byte[] bArr) {
        try {
        } catch (Throwable th) {
            vl.j(th);
        }
        if (!j(bArr, f25840j)) {
            return false;
        }
        int i6 = 8;
        while (i6 >= 0) {
            if (i6 + 12 > bArr.length) {
                break;
            }
            int j6 = j(bArr, i6);
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, i6 + 4, bArr2, 0, 4);
            int i7 = i6 + 8;
            if (Arrays.equals(bArr2, xt)) {
                return true;
            }
            i6 = i7 + j6 + 4;
        }
        return false;
    }

    private static boolean j(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i6 = 0; i6 < bArr2.length; i6++) {
            if (bArr[i6] != bArr2[i6]) {
                return false;
            }
        }
        return true;
    }

    private static int j(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }
}
