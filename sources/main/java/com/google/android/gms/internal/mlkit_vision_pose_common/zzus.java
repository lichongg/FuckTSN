package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzus implements zzck {
    UNKNOWN_STATUS(0),
    COMPLETED_EVENT(1),
    MISSING_END_EVENT(2),
    HANG(3),
    ABANDONED_FROM_HANG(4),
    FORCED_CRASH_FROM_HANG(5);

    private final int zzh;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzck
    public final int zza() {
        return this.zzh;
    }

    zzus(int i6) {
        this.zzh = i6;
    }
}
