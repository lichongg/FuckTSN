package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdq implements zzey {
    private static final zzdq zza = new zzdq();

    public static zzdq zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzey
    public final zzex zzb(Class cls) {
        if (!zzdv.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzex) zzdv.zzA(cls.asSubclass(zzdv.class)).zzo(3, null, null);
        } catch (Exception e6) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzey
    public final boolean zzc(Class cls) {
        return zzdv.class.isAssignableFrom(cls);
    }

    private zzdq() {
    }
}
