package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzaa {
    static int zza(Set set) {
        int i6;
        int i7 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i6 = obj.hashCode();
            } else {
                i6 = 0;
            }
            i7 += i6;
        }
        return i7;
    }
}
