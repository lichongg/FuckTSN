package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzlo implements zzmj {
    private static final zzlu zza = new zzlm();
    private final zzlu zzb;

    public zzlo() {
        zzkj zza2 = zzkj.zza();
        int i6 = zzmf.zza;
        zzln zzlnVar = new zzln(zza2, zza);
        byte[] bArr = zzkz.zzb;
        this.zzb = zzlnVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmj
    public final zzmi zza(Class cls) {
        int i6 = zzmk.zza;
        if (!zzkr.class.isAssignableFrom(cls)) {
            int i7 = zzmf.zza;
        }
        zzlt zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            int i8 = zzmf.zza;
            return zzma.zzc(zzmk.zzm(), zzke.zza(), zzb.zza());
        }
        int i9 = zzmf.zza;
        return zzlz.zzl(cls, zzb, zzmd.zza(), zzlk.zza(), zzmk.zzm(), zzb.zzc() + (-1) != 1 ? zzke.zza() : null, zzls.zza());
    }
}
