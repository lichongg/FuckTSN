package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Comparator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzde implements Comparator {
    zzde() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzdk zza = zzdk.zza(obj);
        zzdk zza2 = zzdk.zza(obj2);
        if (zza == zza2) {
            int ordinal = zza.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            return ((Double) obj).compareTo((Double) obj2);
                        }
                        throw null;
                    }
                    return ((Long) obj).compareTo((Long) obj2);
                }
                return ((String) obj).compareTo((String) obj2);
            }
            return ((Boolean) obj).compareTo((Boolean) obj2);
        }
        return zza.compareTo(zza2);
    }
}
