package com.amap.api.col.p0003l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class n6 {

    /* renamed from: a, reason: collision with root package name */
    private static int f6806a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i6 = f6806a;
        int i7 = i6 - (length % i6);
        int i8 = ((length / i6) + 1) * i6;
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i8) {
            bArr3[length] = (byte) i7;
            length++;
        }
        int[] b6 = b(bArr3);
        int[] b7 = b(bArr2);
        int length2 = b6.length;
        int i9 = length2 - 1;
        if (i9 > 0) {
            if (b7.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(b7, 0, iArr, 0, b7.length);
                b7 = iArr;
            }
            int i10 = b6[i9];
            int i11 = (52 / length2) + 6;
            int i12 = 0;
            while (true) {
                int i13 = i11 - 1;
                if (i11 <= 0) {
                    break;
                }
                i12 -= 1640531527;
                int i14 = (i12 >>> 2) & 3;
                int i15 = 0;
                while (i15 < i9) {
                    int i16 = i15 + 1;
                    int i17 = b6[i16];
                    i10 = ((((i10 >>> 5) ^ (i17 << 2)) + ((i17 >>> 3) ^ (i10 << 4))) ^ ((i17 ^ i12) + (i10 ^ b7[(i15 & 3) ^ i14]))) + b6[i15];
                    b6[i15] = i10;
                    i15 = i16;
                }
                int i18 = b6[0];
                i10 = ((((i10 >>> 5) ^ (i18 << 2)) + ((i18 >>> 3) ^ (i10 << 4))) ^ ((i18 ^ i12) + (i10 ^ b7[i14 ^ (i15 & 3)]))) + b6[i9];
                b6[i9] = i10;
                i11 = i13;
            }
        }
        int length3 = b6.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i19 = 0; i19 < length3; i19++) {
            bArr4[i19] = (byte) ((b6[i19 >>> 2] >>> ((i19 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    private static int[] b(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 >>> 2;
            iArr[i7] = iArr[i7] | ((bArr[i6] & 255) << ((i6 & 3) << 3));
        }
        return iArr;
    }
}
