package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzmw {

    @Nullable
    private static zzmw zza;

    public static synchronized zzmw zza() {
        zzmw zzmwVar;
        synchronized (zzmw.class) {
            try {
                if (zza == null) {
                    zza = new zzmw();
                }
                zzmwVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmwVar;
    }

    public static final boolean zzb() {
        return zzmv.zza("mlkit-dev-profiling");
    }

    private zzmw() {
    }
}
