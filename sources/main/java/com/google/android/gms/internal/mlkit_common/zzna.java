package com.google.android.gms.internal.mlkit_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzna implements zzba {
    UNKNOWN_STATUS(0),
    EXPLICITLY_REQUESTED(1),
    IMPLICITLY_REQUESTED(2),
    MODEL_INFO_RETRIEVAL_SUCCEEDED(3),
    MODEL_INFO_RETRIEVAL_FAILED(4),
    SCHEDULED(5),
    DOWNLOADING(6),
    SUCCEEDED(7),
    FAILED(8),
    LIVE(9),
    UPDATE_AVAILABLE(10),
    DOWNLOADED(11),
    STARTED(12);

    private final int zzo;

    @Override // com.google.android.gms.internal.mlkit_common.zzba
    public final int zza() {
        return this.zzo;
    }

    zzna(int i6) {
        this.zzo = i6;
    }
}
