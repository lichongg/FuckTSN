package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzms {

    @Nullable
    private static zzmr zza;

    public static synchronized zzmj zza(zzme zzmeVar) {
        zzmj zzmjVar;
        synchronized (zzms.class) {
            try {
                if (zza == null) {
                    zza = new zzmr(null);
                }
                zzmjVar = (zzmj) zza.get(zzmeVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmjVar;
    }

    public static synchronized zzmj zzb(String str) {
        zzmj zza2;
        synchronized (zzms.class) {
            zza2 = zza(zzme.zzd("vision-common").zzd());
        }
        return zza2;
    }
}
