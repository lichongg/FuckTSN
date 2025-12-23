package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.collection.ScatterMapKt;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class MurmurHash3 {
    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i6, int i7, int i8) {
        int i9;
        int i10 = i6;
        while (true) {
            i9 = (i7 & (-4)) + i6;
            if (i10 >= i9) {
                break;
            }
            int i11 = ((bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | (bArr[i10 + 3] << 24)) * ScatterMapKt.MurmurHashC1;
            int i12 = i8 ^ (((i11 >>> 17) | (i11 << 15)) * 461845907);
            i8 = (((i12 >>> 19) | (i12 << 13)) * 5) - 430675100;
            i10 += 4;
        }
        int i13 = i7 & 3;
        if (i13 != 1) {
            if (i13 != 2) {
                r0 = i13 == 3 ? (bArr[i9 + 2] & 255) << 16 : 0;
                int i14 = i8 ^ i7;
                int i15 = (i14 ^ (i14 >>> 16)) * (-2048144789);
                int i16 = (i15 ^ (i15 >>> 13)) * (-1028477387);
                return i16 ^ (i16 >>> 16);
            }
            r0 |= (bArr[i9 + 1] & 255) << 8;
        }
        int i17 = ((bArr[i9] & 255) | r0) * ScatterMapKt.MurmurHashC1;
        i8 ^= ((i17 >>> 17) | (i17 << 15)) * 461845907;
        int i142 = i8 ^ i7;
        int i152 = (i142 ^ (i142 >>> 16)) * (-2048144789);
        int i162 = (i152 ^ (i152 >>> 13)) * (-1028477387);
        return i162 ^ (i162 >>> 16);
    }

    private MurmurHash3() {
    }
}
