package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.os.Build;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzxq {

    @Nullable
    private static zzxq zza;

    public static synchronized zzxq zza() {
        zzxq zzxqVar;
        synchronized (zzxq.class) {
            try {
                if (zza == null) {
                    zza = new zzxq();
                }
                zzxqVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzxqVar;
    }

    public static final boolean zzb() {
        String str = Build.HARDWARE;
        if (("oriole".equals(str) || "raven".equals(str)) && Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        zza();
        return Boolean.parseBoolean("");
    }

    private zzxq() {
    }
}
