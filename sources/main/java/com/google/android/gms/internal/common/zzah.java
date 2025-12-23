package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NullMarked
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzah {
    @CanIgnoreReturnValue
    static Object[] zza(Object[] objArr, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (objArr[i7] == null) {
                throw new NullPointerException("at index " + i7);
            }
        }
        return objArr;
    }
}
