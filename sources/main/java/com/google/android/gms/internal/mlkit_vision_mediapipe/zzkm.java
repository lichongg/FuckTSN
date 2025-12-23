package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzkm extends zzkk implements zzlx {
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkk, com.google.android.gms.internal.mlkit_vision_mediapipe.zzlv
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzkn zzl() {
        if (!((zzkn) this.zza).zzH()) {
            return (zzkn) this.zza;
        }
        ((zzkn) this.zza).zzb.zzh();
        return (zzkn) super.zzl();
    }

    protected zzkm(zzkn zzknVar) {
        super(zzknVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzkk
    protected final void zzo() {
        super.zzo();
        if (((zzkn) this.zza).zzb != zzkg.zze()) {
            zzkn zzknVar = (zzkn) this.zza;
            zzknVar.zzb = zzknVar.zzb.clone();
        }
    }
}
