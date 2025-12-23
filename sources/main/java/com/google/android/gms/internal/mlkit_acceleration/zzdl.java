package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdl {
    private static final zzdj zza = new zzdk();
    private static final zzdj zzb;

    static {
        zzdj zzdjVar = null;
        try {
            zzdjVar = (zzdj) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzdjVar;
    }

    static zzdj zza() {
        zzdj zzdjVar = zzb;
        if (zzdjVar != null) {
            return zzdjVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzdj zzb() {
        return zza;
    }
}
