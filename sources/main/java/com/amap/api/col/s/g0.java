package com.amap.api.col.s;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static int f8086a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i6 = f8086a;
        int i7 = i6 - (length % i6);
        int i8 = ((length / i6) + 1) * i6;
        byte[] bArr3 = new byte[i8];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i8) {
            bArr3[length] = (byte) i7;
            length++;
        }
        return b(d(c(bArr3), c(bArr2)));
    }

    private static byte[] b(int[] iArr) {
        int length = iArr.length << 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = (byte) ((iArr[i6 >>> 2] >>> ((i6 & 3) << 3)) & 255);
        }
        return bArr;
    }

    private static int[] c(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 >>> 2;
            iArr[i7] = iArr[i7] | ((bArr[i6] & 255) << ((i6 & 3) << 3));
        }
        return iArr;
    }

    private static int[] d(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i6 = length - 1;
        if (i6 > 0) {
            if (iArr2.length < 4) {
                int[] iArr3 = new int[4];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
                iArr2 = iArr3;
            }
            int i7 = iArr[i6];
            int i8 = (52 / length) + 6;
            int i9 = 0;
            while (true) {
                int i10 = i8 - 1;
                if (i8 <= 0) {
                    break;
                }
                i9 -= 1640531527;
                int i11 = (i9 >>> 2) & 3;
                int i12 = 0;
                while (i12 < i6) {
                    int i13 = i12 + 1;
                    int i14 = iArr[i13];
                    i7 = ((((i7 >>> 5) ^ (i14 << 2)) + ((i14 >>> 3) ^ (i7 << 4))) ^ ((i14 ^ i9) + (i7 ^ iArr2[(i12 & 3) ^ i11]))) + iArr[i12];
                    iArr[i12] = i7;
                    i12 = i13;
                }
                int i15 = iArr[0];
                i7 = ((((i7 >>> 5) ^ (i15 << 2)) + ((i15 >>> 3) ^ (i7 << 4))) ^ ((i15 ^ i9) + (i7 ^ iArr2[i11 ^ (i12 & 3)]))) + iArr[i6];
                iArr[i6] = i7;
                i8 = i10;
            }
        }
        return iArr;
    }
}
