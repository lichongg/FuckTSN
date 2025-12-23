package com.google.android.gms.internal.mlkit_vision_mediapipe;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzis {

    @Nullable
    private static zzis zza;

    public static synchronized zzis zza() {
        zzis zzisVar;
        synchronized (zzis.class) {
            try {
                if (zza == null) {
                    zza = new zzis();
                }
                zzisVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzisVar;
    }

    private zzis() {
    }

    public static final boolean zzb() {
        zza();
        return Boolean.parseBoolean("");
    }
}
