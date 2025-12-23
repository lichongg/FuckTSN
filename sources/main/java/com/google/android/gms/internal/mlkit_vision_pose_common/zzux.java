package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzux implements zzck {
    UNKNOWN_METRIC(0),
    MEAN_ABSOLUTE_ERROR(1),
    MEAN_SQUARED_ERROR(2),
    ROOT_MEAN_SQUARED_ERROR(3),
    KL_DIVERGENCE(4),
    SYMMETRIC_KL_DIVERGENCE(5);

    private final int zzh;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzck
    public final int zza() {
        return this.zzh;
    }

    zzux(int i6) {
        this.zzh = i6;
    }
}
