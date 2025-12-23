package com.bxkj.student.v2.common.utils;

import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f20870a = 128;

    /* renamed from: b, reason: collision with root package name */
    private static final int f20871b = 64;

    /* renamed from: c, reason: collision with root package name */
    private static final int f20872c = 24;

    /* renamed from: d, reason: collision with root package name */
    private static final int f20873d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final int f20874e = 16;

    /* renamed from: f, reason: collision with root package name */
    private static final int f20875f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static final int f20876g = -128;

    /* renamed from: h, reason: collision with root package name */
    private static final char f20877h = '=';

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f20878i = false;

    /* renamed from: j, reason: collision with root package name */
    private static final byte[] f20879j = new byte[128];

    /* renamed from: k, reason: collision with root package name */
    private static final char[] f20880k = new char[64];

    public static byte[] a(String encoded) {
        if (encoded == null) {
            return null;
        }
        char[] charArray = encoded.toCharArray();
        int f6 = f(charArray);
        if (f6 % 4 != 0) {
            return null;
        }
        int i6 = f6 / 4;
        if (i6 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i6 * 3];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i6 - 1) {
            int i10 = i8 + 1;
            char c6 = charArray[i8];
            if (c(c6)) {
                int i11 = i8 + 2;
                char c7 = charArray[i10];
                if (c(c7)) {
                    int i12 = i8 + 3;
                    char c8 = charArray[i11];
                    if (c(c8)) {
                        i8 += 4;
                        char c9 = charArray[i12];
                        if (c(c9)) {
                            byte[] bArr2 = f20879j;
                            byte b6 = bArr2[c6];
                            byte b7 = bArr2[c7];
                            byte b8 = bArr2[c8];
                            byte b9 = bArr2[c9];
                            bArr[i9] = (byte) ((b6 << 2) | (b7 >> 4));
                            int i13 = i9 + 2;
                            bArr[i9 + 1] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
                            i9 += 3;
                            bArr[i13] = (byte) ((b8 << 6) | b9);
                            i7++;
                        }
                    }
                }
            }
            return null;
        }
        int i14 = i8 + 1;
        char c10 = charArray[i8];
        if (!c(c10)) {
            return null;
        }
        int i15 = i8 + 2;
        char c11 = charArray[i14];
        if (!c(c11)) {
            return null;
        }
        byte[] bArr3 = f20879j;
        byte b10 = bArr3[c10];
        byte b11 = bArr3[c11];
        char c12 = charArray[i15];
        char c13 = charArray[i8 + 3];
        if (c(c12) && c(c13)) {
            byte b12 = bArr3[c12];
            byte b13 = bArr3[c13];
            bArr[i9] = (byte) ((b10 << 2) | (b11 >> 4));
            bArr[i9 + 1] = (byte) (((b11 & 15) << 4) | ((b12 >> 2) & 15));
            bArr[i9 + 2] = (byte) (b13 | (b12 << 6));
            return bArr;
        }
        if (d(c12) && d(c13)) {
            if ((b11 & 15) != 0) {
                return null;
            }
            int i16 = i7 * 3;
            byte[] bArr4 = new byte[i16 + 1];
            System.arraycopy(bArr, 0, bArr4, 0, i16);
            bArr4[i9] = (byte) ((b10 << 2) | (b11 >> 4));
            return bArr4;
        }
        if (d(c12) || !d(c13)) {
            return null;
        }
        byte b14 = bArr3[c12];
        if ((b14 & 3) != 0) {
            return null;
        }
        int i17 = i7 * 3;
        byte[] bArr5 = new byte[i17 + 2];
        System.arraycopy(bArr, 0, bArr5, 0, i17);
        bArr5[i9] = (byte) ((b10 << 2) | (b11 >> 4));
        bArr5[i9 + 1] = (byte) (((b14 >> 2) & 15) | ((b11 & 15) << 4));
        return bArr5;
    }

    private static int f(char[] data) {
        if (data == null) {
            return 0;
        }
        int length = data.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (!e(data[i7])) {
                data[i6] = data[i7];
                i6++;
            }
        }
        return i6;
    }

    static {
        int i6 = 0;
        for (int i7 = 0; i7 < 128; i7++) {
            f20879j[i7] = -1;
        }
        for (int i8 = 90; i8 >= 65; i8--) {
            f20879j[i8] = (byte) (i8 - 65);
        }
        for (int i9 = 122; i9 >= 97; i9--) {
            f20879j[i9] = (byte) (i9 - 71);
        }
        for (int i10 = 57; i10 >= 48; i10--) {
            f20879j[i10] = (byte) (i10 + 4);
        }
        byte[] bArr = f20879j;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i11 = 0; i11 <= 25; i11++) {
            f20880k[i11] = (char) (i11 + 65);
        }
        int i12 = 26;
        int i13 = 0;
        while (i12 <= 51) {
            f20880k[i12] = (char) (i13 + 97);
            i12++;
            i13++;
        }
        int i14 = 52;
        while (i14 <= 61) {
            f20880k[i14] = (char) (i6 + 48);
            i14++;
            i6++;
        }
        char[] cArr = f20880k;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static String b(byte[] binaryData) {
        if (binaryData == null) {
            return null;
        }
        int length = binaryData.length * 8;
        if (length == 0) {
            return "";
        }
        int i6 = length % 24;
        int i7 = length / 24;
        char[] cArr = new char[(i6 != 0 ? i7 + 1 : i7) * 4];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            byte b6 = binaryData[i8];
            int i11 = i8 + 2;
            byte b7 = binaryData[i8 + 1];
            i8 += 3;
            byte b8 = binaryData[i11];
            byte b9 = (byte) (b7 & 15);
            byte b10 = (byte) (b6 & 3);
            byte b11 = (byte) ((b6 & Byte.MIN_VALUE) == 0 ? b6 >> 2 : (b6 >> 2) ^ 192);
            byte b12 = (byte) ((b7 & Byte.MIN_VALUE) == 0 ? b7 >> 4 : (b7 >> 4) ^ 240);
            byte b13 = (byte) ((b8 & Byte.MIN_VALUE) == 0 ? b8 >> 6 : (b8 >> 6) ^ 252);
            char[] cArr2 = f20880k;
            cArr[i9] = cArr2[b11];
            cArr[i9 + 1] = cArr2[b12 | (b10 << 4)];
            int i12 = i9 + 3;
            cArr[i9 + 2] = cArr2[(b9 << 2) | b13];
            i9 += 4;
            cArr[i12] = cArr2[b8 & Utf8.REPLACEMENT_BYTE];
        }
        if (i6 == 8) {
            byte b14 = binaryData[i8];
            byte b15 = (byte) (b14 & 3);
            byte b16 = (byte) ((b14 & Byte.MIN_VALUE) == 0 ? b14 >> 2 : (b14 >> 2) ^ 192);
            char[] cArr3 = f20880k;
            cArr[i9] = cArr3[b16];
            cArr[i9 + 1] = cArr3[b15 << 4];
            cArr[i9 + 2] = f20877h;
            cArr[i9 + 3] = f20877h;
        } else if (i6 == 16) {
            byte b17 = binaryData[i8];
            byte b18 = binaryData[i8 + 1];
            byte b19 = (byte) (b18 & 15);
            byte b20 = (byte) (b17 & 3);
            byte b21 = (byte) ((b17 & Byte.MIN_VALUE) == 0 ? b17 >> 2 : (b17 >> 2) ^ 192);
            byte b22 = (byte) ((b18 & Byte.MIN_VALUE) == 0 ? b18 >> 4 : (b18 >> 4) ^ 240);
            char[] cArr4 = f20880k;
            cArr[i9] = cArr4[b21];
            cArr[i9 + 1] = cArr4[b22 | (b20 << 4)];
            cArr[i9 + 2] = cArr4[b19 << 2];
            cArr[i9 + 3] = f20877h;
        }
        return new String(cArr);
    }

    private static boolean c(char octect) {
        return octect < 128 && f20879j[octect] != -1;
    }

    private static boolean d(char octect) {
        return octect == '=';
    }

    private static boolean e(char octect) {
        return octect == ' ' || octect == '\r' || octect == '\n' || octect == '\t';
    }
}
