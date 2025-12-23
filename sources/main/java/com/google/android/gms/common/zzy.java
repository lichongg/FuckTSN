package com.google.android.gms.common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzy {
    static int zza(int i6) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i7 = 0; i7 < 6; i7++) {
            int i8 = iArr[i7];
            int i9 = i8 - 1;
            if (i8 == 0) {
                throw null;
            }
            if (i9 == i6) {
                return i8;
            }
        }
        return 1;
    }
}
