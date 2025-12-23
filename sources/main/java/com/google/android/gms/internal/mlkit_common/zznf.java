package com.google.android.gms.internal.mlkit_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zznf implements zzba {
    SOURCE_UNKNOWN(0),
    APP_ASSET(1),
    LOCAL(2),
    CLOUD(3),
    SDK_BUILT_IN(4),
    URI(5);

    private final int zzh;

    @Override // com.google.android.gms.internal.mlkit_common.zzba
    public final int zza() {
        return this.zzh;
    }

    zznf(int i6) {
        this.zzh = i6;
    }
}
