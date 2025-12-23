package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzlh {
    protected volatile zzlw zza;
    private volatile zzjo zzb;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlh)) {
            return false;
        }
        zzlh zzlhVar = (zzlh) obj;
        zzlw zzlwVar = this.zza;
        zzlw zzlwVar2 = zzlhVar.zza;
        if (zzlwVar == null && zzlwVar2 == null) {
            return zzb().equals(zzlhVar.zzb());
        }
        if (zzlwVar != null && zzlwVar2 != null) {
            return zzlwVar.equals(zzlwVar2);
        }
        if (zzlwVar != null) {
            zzlhVar.zzd(zzlwVar.zzm());
            return zzlwVar.equals(zzlhVar.zza);
        }
        zzd(zzlwVar2.zzm());
        return this.zza.equals(zzlwVar2);
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzjn) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzn();
        }
        return 0;
    }

    public final zzjo zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            try {
                if (this.zzb != null) {
                    return this.zzb;
                }
                if (this.zza == null) {
                    this.zzb = zzjo.zzb;
                } else {
                    this.zzb = this.zza.zzj();
                }
                return this.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzlw zzc(zzlw zzlwVar) {
        zzlw zzlwVar2 = this.zza;
        this.zzb = null;
        this.zza = zzlwVar;
        return zzlwVar2;
    }

    protected final void zzd(zzlw zzlwVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzlwVar;
                this.zzb = zzjo.zzb;
            } catch (zzlb unused) {
                this.zza = zzlwVar;
                this.zzb = zzjo.zzb;
            }
        }
    }
}
