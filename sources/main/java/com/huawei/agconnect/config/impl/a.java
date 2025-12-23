package com.huawei.agconnect.config.impl;

/* loaded from: D:\Downloads\app\classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f32916a = "0123456789ABCDEF".toCharArray();

    private static byte[] a(char[] cArr) {
        if ((cArr.length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[cArr.length >> 1];
        int i6 = 0;
        int i7 = 0;
        while (i6 < cArr.length) {
            int digit = Character.digit(cArr[i6], 16);
            if (digit == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i6);
            }
            int i8 = i6 + 1;
            int digit2 = Character.digit(cArr[i8], 16);
            if (digit2 == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i8);
            }
            i6 += 2;
            bArr[i7] = (byte) (((digit << 4) | digit2) & 255);
            i7++;
        }
        return bArr;
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b6 : bArr) {
            char[] cArr = f32916a;
            sb.append(cArr[(b6 >> 4) & 15]);
            sb.append(cArr[b6 & 15]);
        }
        return sb.toString();
    }

    public static byte[] b(String str) {
        return a(str.toCharArray());
    }
}
