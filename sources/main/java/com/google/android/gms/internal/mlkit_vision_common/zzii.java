package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzii implements zzag {
    UNKNOWN_FORMAT(0),
    NV16(1),
    NV21(2),
    YV12(3),
    YUV_420_888(7),
    JPEG(8),
    BITMAP(4),
    CM_SAMPLE_BUFFER_REF(5),
    UI_IMAGE(6),
    CV_PIXEL_BUFFER_REF(9);

    private final int zzl;

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzag
    public final int zza() {
        return this.zzl;
    }

    zzii(int i6) {
        this.zzl = i6;
    }
}
