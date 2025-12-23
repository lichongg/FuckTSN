package com.google.android.gms.internal.mlkit_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzaa {
    static int zza(int i6, int i7) {
        if (i7 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i8 = i6 + (i6 >> 1) + 1;
        if (i8 < i7) {
            int highestOneBit = Integer.highestOneBit(i7 - 1);
            i8 = highestOneBit + highestOneBit;
        }
        if (i8 < 0) {
            return Integer.MAX_VALUE;
        }
        return i8;
    }

    zzaa() {
    }
}
