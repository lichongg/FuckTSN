package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.umeng.analytics.pro.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzdt {
    private final zzcj zza;
    private int zzb = 0;
    private int zzc = -1;

    protected abstract Object zza();

    protected abstract void zzc(int i6, int i7, zzdo zzdoVar);

    public final int zzh() {
        return this.zzc + 1;
    }

    public final zzdu zzi() {
        return this.zza.zza();
    }

    public final Object zzj() {
        this.zza.zza().zzc(this);
        int i6 = this.zzb;
        if (((i6 + 1) & i6) != 0 || (this.zzc > 31 && i6 != -1)) {
            throw zzdv.zzb(String.format("unreferenced arguments [first missing index=%d]", Integer.valueOf(Integer.numberOfTrailingZeros(~i6))), this.zza.zzb());
        }
        return zza();
    }

    public final String zzk() {
        return this.zza.zzb();
    }

    public zzdt(zzcj zzcjVar) {
        zzdy.zza(zzcjVar, d.X);
        this.zza = zzcjVar;
    }

    public final void zzl(int i6, int i7, zzdo zzdoVar) {
        if (zzdoVar.zzc() < 32) {
            this.zzb |= 1 << zzdoVar.zzc();
        }
        this.zzc = Math.max(this.zzc, zzdoVar.zzc());
        zzc(i6, i7, zzdoVar);
    }
}
