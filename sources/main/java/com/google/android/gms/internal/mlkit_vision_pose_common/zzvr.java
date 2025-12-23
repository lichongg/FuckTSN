package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzvr {
    boolean zza;
    private long zzb;
    private long zzc;
    private final zzba zzd = new zzba();
    private final zzba zze = new zzba();
    private final zzba zzf = new zzba();
    private int zzg;

    public final void zzh() {
        this.zza = true;
    }

    @VisibleForTesting
    public final zztc zza() {
        zzq.zzd(this.zzb != 0);
        zzq.zzd(this.zzc != 0);
        long j6 = this.zzc - this.zzb;
        zztc zztcVar = new zztc();
        zztcVar.zzd(Long.valueOf(j6));
        zztcVar.zzh(this.zzd.zzc());
        zztcVar.zzg(this.zze.zzc());
        zztcVar.zze(this.zzf.zzc());
        int i6 = this.zzg;
        if (i6 != 0) {
            zztcVar.zzf(Integer.valueOf(i6));
        }
        return zztcVar;
    }

    public final void zzb(zztd zztdVar) {
        this.zzf.zzb(zztdVar);
    }

    public final void zzc(zztd zztdVar) {
        this.zze.zzb(zztdVar);
    }

    public final void zzd(zztd zztdVar) {
        if (this.zza) {
            this.zze.zzb(zztdVar);
        } else {
            this.zzd.zzb(zztdVar);
        }
    }

    public final void zzf(int i6) {
        this.zzg = i6;
    }

    public final void zze() {
        this.zzc = SystemClock.elapsedRealtime();
    }

    public final void zzg() {
        this.zzb = SystemClock.elapsedRealtime();
    }
}
