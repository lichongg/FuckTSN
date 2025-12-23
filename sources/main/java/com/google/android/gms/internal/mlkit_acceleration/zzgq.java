package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzgq extends zzgp {
    @Override // com.google.android.gms.internal.mlkit_acceleration.zzgp
    final int zza(int i6, byte[] bArr, int i7, int i8) {
        while (i7 < i8 && bArr[i7] >= 0) {
            i7++;
        }
        if (i7 >= i8) {
            return 0;
        }
        while (i7 < i8) {
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            if (b6 >= 0) {
                i7 = i9;
            } else {
                if (b6 < -32) {
                    if (i9 >= i8) {
                        return b6;
                    }
                    if (b6 >= -62) {
                        i7 += 2;
                        if (bArr[i9] > -65) {
                        }
                    }
                    return -1;
                }
                if (b6 >= -16) {
                    if (i9 >= i8 - 2) {
                        return zzgs.zza(bArr, i9, i8);
                    }
                    int i10 = i7 + 2;
                    byte b7 = bArr[i9];
                    if (b7 <= -65 && (((b6 << 28) + (b7 + 112)) >> 30) == 0) {
                        int i11 = i7 + 3;
                        if (bArr[i10] <= -65) {
                            i7 += 4;
                            if (bArr[i11] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i9 >= i8 - 1) {
                    return zzgs.zza(bArr, i9, i8);
                }
                int i12 = i7 + 2;
                byte b8 = bArr[i9];
                if (b8 > -65 || (b6 == -32 && b8 < -96)) {
                    return -1;
                }
                if (b6 == -19 && b8 >= -96) {
                    return -1;
                }
                i7 += 3;
                if (bArr[i12] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }

    zzgq() {
    }
}
