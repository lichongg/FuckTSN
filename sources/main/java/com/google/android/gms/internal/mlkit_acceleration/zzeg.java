package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzeg {
    private static final zzdi zzb = zzdi.zza;
    protected volatile zzfa zza;
    private volatile zzcs zzc;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeg)) {
            return false;
        }
        zzeg zzegVar = (zzeg) obj;
        zzfa zzfaVar = this.zza;
        zzfa zzfaVar2 = zzegVar.zza;
        if (zzfaVar == null && zzfaVar2 == null) {
            return zzb().equals(zzegVar.zzb());
        }
        if (zzfaVar != null && zzfaVar2 != null) {
            return zzfaVar.equals(zzfaVar2);
        }
        if (zzfaVar != null) {
            zzegVar.zzc(zzfaVar.zzP());
            return zzfaVar.equals(zzegVar.zza);
        }
        zzc(zzfaVar2.zzP());
        return this.zza.equals(zzfaVar2);
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzcp) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzx();
        }
        return 0;
    }

    public final zzcs zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            try {
                if (this.zzc != null) {
                    return this.zzc;
                }
                if (this.zza == null) {
                    this.zzc = zzcs.zzb;
                } else {
                    this.zzc = this.zza.zzu();
                }
                return this.zzc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void zzc(zzfa zzfaVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzfaVar;
                this.zzc = zzcs.zzb;
            } catch (zzed unused) {
                this.zza = zzfaVar;
                this.zzc = zzcs.zzb;
            }
        }
    }
}
