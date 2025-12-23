package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdn extends zzdo {
    private final zzdm zza;

    public static zzdo zza(zzdm zzdmVar, zzay zzayVar, int i6) {
        return new zzdn(zzayVar, i6, zzdmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdo
    protected final void zzb(zzdp zzdpVar, Object obj) {
        zzdpVar.zze(obj, this.zza, zzd());
    }

    private zzdn(zzay zzayVar, int i6, zzdm zzdmVar) {
        super(zzayVar, i6);
        char c6;
        this.zza = zzdmVar;
        StringBuilder sb = new StringBuilder("%");
        zzayVar.zzh(sb);
        if (true != zzayVar.zzk()) {
            c6 = 't';
        } else {
            c6 = 'T';
        }
        sb.append(c6);
        sb.append(zzdmVar.zza());
    }
}
