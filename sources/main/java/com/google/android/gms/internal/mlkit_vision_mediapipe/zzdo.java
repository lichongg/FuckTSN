package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzdo {
    private final int zza;
    private final zzay zzb;

    protected abstract void zzb(zzdp zzdpVar, Object obj);

    public final int zzc() {
        return this.zza;
    }

    protected final zzay zzd() {
        return this.zzb;
    }

    public final void zze(zzdp zzdpVar, Object[] objArr) {
        int i6 = this.zza;
        if (i6 >= objArr.length) {
            zzdpVar.zzf();
            return;
        }
        Object obj = objArr[i6];
        if (obj != null) {
            zzb(zzdpVar, obj);
        } else {
            zzdpVar.zzg();
        }
    }

    protected zzdo(zzay zzayVar, int i6) {
        if (zzayVar != null) {
            if (i6 >= 0) {
                this.zza = i6;
                this.zzb = zzayVar;
                return;
            } else {
                throw new IllegalArgumentException("invalid index: " + i6);
            }
        }
        throw new IllegalArgumentException("format options cannot be null");
    }
}
