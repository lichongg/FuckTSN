package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzsg implements zzck {
    HARDWARE_CONFIG_UNKNOWN(0),
    HARDWARE_CONFIG_CPU(1),
    HARDWARE_CONFIG_CPU_GPU(2);

    private final int zze;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzck
    public final int zza() {
        return this.zze;
    }

    zzsg(int i6) {
        this.zze = i6;
    }

    public static zzsg zzb(int i6) {
        for (zzsg zzsgVar : values()) {
            if (zzsgVar.zze == i6) {
                return zzsgVar;
            }
        }
        return HARDWARE_CONFIG_UNKNOWN;
    }
}
