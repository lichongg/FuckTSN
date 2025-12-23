package com.baidu.liantian.b;

import androidx.core.view.MotionEventCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f10341a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    public static byte[] a(byte[] bArr) {
        byte b6;
        int i6;
        int length = bArr.length;
        int i7 = (length / 4) * 3;
        if (i7 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        while (true) {
            byte b7 = bArr[length - 1];
            b6 = 10;
            if (b7 != 10 && b7 != 13 && b7 != 32 && b7 != 9) {
                if (b7 != 61) {
                    break;
                }
                i8++;
            }
            length--;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i9 < length) {
            byte b8 = bArr[i9];
            if (b8 != b6 && b8 != 13 && b8 != 32 && b8 != 9) {
                if (b8 >= 65 && b8 <= 90) {
                    i6 = b8 - 65;
                } else if (b8 >= 97 && b8 <= 122) {
                    i6 = b8 - 71;
                } else if (b8 >= 48 && b8 <= 57) {
                    i6 = b8 + 4;
                } else if (b8 == 43) {
                    i6 = 62;
                } else {
                    if (b8 != 47) {
                        return null;
                    }
                    i6 = 63;
                }
                i10 = ((byte) i6) | (i10 << 6);
                if (i12 % 4 == 3) {
                    bArr2[i11] = (byte) ((i10 & 16711680) >> 16);
                    int i13 = i11 + 2;
                    bArr2[i11 + 1] = (byte) ((i10 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    i11 += 3;
                    bArr2[i13] = (byte) (i10 & 255);
                }
                i12++;
            }
            i9++;
            b6 = 10;
        }
        if (i8 > 0) {
            int i14 = i10 << (i8 * 6);
            int i15 = i11 + 1;
            bArr2[i11] = (byte) ((i14 & 16711680) >> 16);
            if (i8 == 1) {
                i11 += 2;
                bArr2[i15] = (byte) ((i14 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
            } else {
                i11 = i15;
            }
        }
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr2, 0, bArr3, 0, i11);
        return bArr3;
    }
}
