package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzer implements zzey {
    private final zzey[] zza;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzey
    public final zzex zzb(Class cls) {
        for (int i6 = 0; i6 < 2; i6++) {
            zzey zzeyVar = this.zza[i6];
            if (zzeyVar.zzc(cls)) {
                return zzeyVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzey
    public final boolean zzc(Class cls) {
        for (int i6 = 0; i6 < 2; i6++) {
            if (this.zza[i6].zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    zzer(zzey... zzeyVarArr) {
        this.zza = zzeyVarArr;
    }
}
