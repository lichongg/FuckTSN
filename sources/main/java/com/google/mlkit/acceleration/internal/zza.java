package com.google.mlkit.acceleration.internal;

import android.content.Context;
import androidx.annotation.GuardedBy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zza {
    private static final Object zza = new Object();

    @GuardedBy("gpuAllowedLock")
    private static Boolean zzb;
    private final Context zzc;
    private final PipelineId zzd;
    private final AllowlistConfig zze;
    private final AccelerationLogger zzf;

    /* JADX WARN: Removed duplicated region for block: B:60:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List zza(@androidx.annotation.NonNull com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions r17) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.acceleration.internal.zza.zza(com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions):java.util.List");
    }

    zza(Context context, PipelineId pipelineId, AllowlistConfig allowlistConfig, AccelerationLogger accelerationLogger) {
        this.zzc = context;
        this.zzd = pipelineId;
        this.zze = allowlistConfig;
        this.zzf = accelerationLogger;
    }
}
