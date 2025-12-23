package com.google.android.gms.internal.mlkit_acceleration;

import java.util.logging.Logger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzba {
    private final String zza;
    private volatile Logger zzb;

    final Logger zza() {
        Logger logger = this.zzb;
        if (logger != null) {
            return logger;
        }
        synchronized (this) {
            try {
                Logger logger2 = this.zzb;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.zza);
                this.zzb = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    zzba(Class cls) {
        this.zza = cls.getName();
    }
}
