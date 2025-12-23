package com.beizi.ad.internal.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g {
    public static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i6 = 0; i6 < length; i6 += 2) {
            bArr[i6 / 2] = (byte) ((Character.digit(str.charAt(i6), 16) << 4) + Character.digit(str.charAt(i6 + 1), 16));
        }
        return bArr;
    }
}
