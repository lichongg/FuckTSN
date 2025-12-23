package com.google.android.gms.internal.mlkit_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzmm implements zzba {
    UNKNOWN(0),
    TRANSLATE(1);

    private final int zzd;

    @Override // com.google.android.gms.internal.mlkit_common.zzba
    public final int zza() {
        return this.zzd;
    }

    zzmm(int i6) {
        this.zzd = i6;
    }

    public static zzmm zzb(int i6) {
        for (zzmm zzmmVar : values()) {
            if (zzmmVar.zzd == i6) {
                return zzmmVar;
            }
        }
        return UNKNOWN;
    }
}
