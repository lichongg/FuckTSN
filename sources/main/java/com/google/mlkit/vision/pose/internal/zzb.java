package com.google.mlkit.vision.pose.internal;

import com.google.android.gms.internal.mlkit_vision_pose_common.zzcf;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;
import com.google.mlkit.acceleration.internal.AllowlistConfig;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzb implements AllowlistConfig {
    @Override // com.google.mlkit.acceleration.internal.AllowlistConfig
    public final String getBundledAllowlistAssetPath() {
        return "mlkit_pose/bundled_allowlist.binarypb";
    }

    @Override // com.google.mlkit.acceleration.internal.AllowlistConfig
    public final /* bridge */ /* synthetic */ boolean isRunConfigCompatibleWithOptions(String str, AcceleratableDetectorOptions acceleratableDetectorOptions) {
        List zzc = zzcf.zzc(((PoseDetectorOptionsBase) acceleratableDetectorOptions).getPreferredHardwareConfigs());
        if ("default_config".equals(str)) {
            return zzc.contains(1);
        }
        if ("cpu-gpu-opencl".equals(str)) {
            return zzc.contains(2);
        }
        return false;
    }

    @Override // com.google.mlkit.acceleration.internal.AllowlistConfig
    public final boolean shouldCheckGenericGpuAllowlist(String str) {
        return "cpu-gpu-opencl".equals(str);
    }

    zzb() {
    }
}
