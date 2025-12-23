package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzkj implements zzlu {
    private static final zzkj zza = new zzkj();

    public static zzkj zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlu
    public final zzlt zzb(Class cls) {
        if (!zzkr.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzlt) zzkr.zzs(cls.asSubclass(zzkr.class)).zzb(3, null, null);
        } catch (Exception e6) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlu
    public final boolean zzc(Class cls) {
        return zzkr.class.isAssignableFrom(cls);
    }

    private zzkj() {
    }
}
