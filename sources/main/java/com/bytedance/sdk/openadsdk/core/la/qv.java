package com.bytedance.sdk.openadsdk.core.la;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv {

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f29436j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static String j(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = f29436j;
            cArr[i6] = cArr2[(b6 >>> 4) & 15];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }
}
