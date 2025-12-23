package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzcj {
    private final zzdu zza;
    private final String zzb;

    public final boolean equals(Object obj) {
        if (obj instanceof zzcj) {
            zzcj zzcjVar = (zzcj) obj;
            if (this.zza.equals(zzcjVar.zza) && this.zzb.equals(zzcjVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return str.hashCode() ^ this.zza.hashCode();
    }

    public final zzdu zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public zzcj(zzdu zzduVar, String str) {
        zzdy.zza(zzduVar, "parser");
        this.zza = zzduVar;
        zzdy.zza(str, CrashHianalyticsData.MESSAGE);
        this.zzb = str;
    }
}
