package com.amap.api.col.p0003l;

import java.text.SimpleDateFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u9 {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f7431a;

    /* renamed from: b, reason: collision with root package name */
    private static String f7432b;

    public static byte[] b(long j6) {
        byte[] bArr = new byte[6];
        for (int i6 = 0; i6 < 6; i6++) {
            bArr[i6] = (byte) ((j6 >> ((5 - i6) * 8)) & 255);
        }
        return bArr;
    }

    public static String a(byte[] bArr, String str) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (int i6 = 0; i6 < bArr.length; i6++) {
            String hexString = Integer.toHexString(bArr[i6] & 255);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
            if (str.length() > 0 && i6 < bArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
