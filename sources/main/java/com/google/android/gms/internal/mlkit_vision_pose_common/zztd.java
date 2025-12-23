package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zztd implements zzck {
    UNKNOWN_ERROR(0),
    NO_CONNECTION(1),
    RPC_ERROR(2),
    RPC_RETURNED_INVALID_RESULT(3),
    RPC_RETURNED_MALFORMED_RESULT(4),
    RPC_EXPONENTIAL_BACKOFF_FAILED(5),
    DIRECTORY_CREATION_FAILED(10),
    FILE_WRITE_FAILED_DISK_FULL(11),
    FILE_WRITE_FAILED(12),
    FILE_READ_FAILED(13),
    FILE_READ_RETURNED_INVALID_DATA(14),
    FILE_READ_RETURNED_MALFORMED_DATA(15);

    private final int zzn;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzck
    public final int zza() {
        return this.zzn;
    }

    zztd(int i6) {
        this.zzn = i6;
    }
}
