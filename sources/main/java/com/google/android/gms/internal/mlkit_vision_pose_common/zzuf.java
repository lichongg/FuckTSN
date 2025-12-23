package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzuf implements zzck {
    UNKNOWN_SOURCE(0),
    MLKIT(1),
    NNAPI(2),
    OPEN_GL(3);

    private final int zzf;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzck
    public final int zza() {
        return this.zzf;
    }

    zzuf(int i6) {
        this.zzf = i6;
    }
}
