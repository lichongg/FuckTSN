package com.alibaba.fastjson.util;

import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Base64 {
    public static final char[] CA;
    public static final int[] IA;

    public static byte[] decodeFast(char[] cArr, int i6, int i7) {
        int i8;
        int i9 = 0;
        if (i7 == 0) {
            return new byte[0];
        }
        int i10 = (i6 + i7) - 1;
        int i11 = i6;
        while (i11 < i10 && IA[cArr[i11]] < 0) {
            i11++;
        }
        while (i10 > 0 && IA[cArr[i10]] < 0) {
            i10--;
        }
        int i12 = cArr[i10] == '=' ? cArr[i10 + (-1)] == '=' ? 2 : 1 : 0;
        int i13 = (i10 - i11) + 1;
        if (i7 > 76) {
            i8 = (cArr[76] == '\r' ? i13 / 78 : 0) << 1;
        } else {
            i8 = 0;
        }
        int i14 = (((i13 - i8) * 6) >> 3) - i12;
        byte[] bArr = new byte[i14];
        int i15 = (i14 / 3) * 3;
        int i16 = 0;
        loop2: while (true) {
            int i17 = 0;
            while (i16 < i15) {
                int[] iArr = IA;
                int i18 = i11 + 4;
                int i19 = iArr[cArr[i11 + 3]] | (iArr[cArr[i11 + 1]] << 12) | (iArr[cArr[i11]] << 18) | (iArr[cArr[i11 + 2]] << 6);
                bArr[i16] = (byte) (i19 >> 16);
                int i20 = i16 + 2;
                bArr[i16 + 1] = (byte) (i19 >> 8);
                i16 += 3;
                bArr[i20] = (byte) i19;
                if (i8 <= 0 || (i17 = i17 + 1) != 19) {
                    i11 = i18;
                }
            }
            i11 += 6;
        }
        if (i16 < i14) {
            int i21 = 0;
            while (i11 <= i10 - i12) {
                i9 |= IA[cArr[i11]] << (18 - (i21 * 6));
                i21++;
                i11++;
            }
            int i22 = 16;
            while (i16 < i14) {
                bArr[i16] = (byte) (i9 >> i22);
                i22 -= 8;
                i16++;
            }
        }
        return bArr;
    }

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i6 = 0; i6 < length; i6++) {
            IA[CA[i6]] = i6;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(String str, int i6, int i7) {
        int i8;
        if (i7 == 0) {
            return new byte[0];
        }
        int i9 = (i6 + i7) - 1;
        int i10 = i6;
        while (i10 < i9 && IA[str.charAt(i10)] < 0) {
            i10++;
        }
        while (i9 > 0 && IA[str.charAt(i9)] < 0) {
            i9--;
        }
        int i11 = str.charAt(i9) == '=' ? str.charAt(i9 + (-1)) == '=' ? 2 : 1 : 0;
        int i12 = (i9 - i10) + 1;
        if (i7 > 76) {
            i8 = (str.charAt(76) == '\r' ? i12 / 78 : 0) << 1;
        } else {
            i8 = 0;
        }
        int i13 = (((i12 - i8) * 6) >> 3) - i11;
        byte[] bArr = new byte[i13];
        int i14 = (i13 / 3) * 3;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i14) {
            int[] iArr = IA;
            int i17 = i10 + 4;
            int i18 = iArr[str.charAt(i10 + 3)] | (iArr[str.charAt(i10 + 1)] << 12) | (iArr[str.charAt(i10)] << 18) | (iArr[str.charAt(i10 + 2)] << 6);
            bArr[i15] = (byte) (i18 >> 16);
            int i19 = i15 + 2;
            bArr[i15 + 1] = (byte) (i18 >> 8);
            i15 += 3;
            bArr[i19] = (byte) i18;
            if (i8 <= 0 || (i16 = i16 + 1) != 19) {
                i10 = i17;
            } else {
                i10 += 6;
                i16 = 0;
            }
        }
        if (i15 < i13) {
            int i20 = 0;
            int i21 = 0;
            while (i10 <= i9 - i11) {
                i20 |= IA[str.charAt(i10)] << (18 - (i21 * 6));
                i21++;
                i10++;
            }
            int i22 = 16;
            while (i15 < i13) {
                bArr[i15] = (byte) (i20 >> i22);
                i22 -= 8;
                i15++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i6;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i7 = length - 1;
        int i8 = 0;
        while (i8 < i7 && IA[str.charAt(i8) & 255] < 0) {
            i8++;
        }
        while (i7 > 0 && IA[str.charAt(i7) & 255] < 0) {
            i7--;
        }
        int i9 = str.charAt(i7) == '=' ? str.charAt(i7 + (-1)) == '=' ? 2 : 1 : 0;
        int i10 = (i7 - i8) + 1;
        if (length > 76) {
            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i8 + 4;
            int i16 = iArr[str.charAt(i8 + 3)] | (iArr[str.charAt(i8 + 1)] << 12) | (iArr[str.charAt(i8)] << 18) | (iArr[str.charAt(i8 + 2)] << 6);
            bArr[i13] = (byte) (i16 >> 16);
            int i17 = i13 + 2;
            bArr[i13 + 1] = (byte) (i16 >> 8);
            i13 += 3;
            bArr[i17] = (byte) i16;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i8 = i15;
            } else {
                i8 += 6;
                i14 = 0;
            }
        }
        if (i13 < i11) {
            int i18 = 0;
            int i19 = 0;
            while (i8 <= i7 - i9) {
                i18 |= IA[str.charAt(i8)] << (18 - (i19 * 6));
                i19++;
                i8++;
            }
            int i20 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i18 >> i20);
                i20 -= 8;
                i13++;
            }
        }
        return bArr;
    }
}
