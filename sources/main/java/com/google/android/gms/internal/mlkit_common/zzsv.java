package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzsv {

    @Nullable
    private static zzsv zza;

    public static synchronized zzsv zza() {
        zzsv zzsvVar;
        synchronized (zzsv.class) {
            try {
                if (zza == null) {
                    zza = new zzsv();
                }
                zzsvVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzsvVar;
    }

    private zzsv() {
    }

    public static void zzb() {
        zzsu.zza();
    }
}
