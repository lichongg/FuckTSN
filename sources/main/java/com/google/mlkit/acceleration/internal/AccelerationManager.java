package com.google.mlkit.acceleration.internal;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class AccelerationManager<OptionsT extends AcceleratableDetectorOptions<OptionsT>, InputT, ResultT> {
    private final zza zza;
    private final zzl zzb;

    @NonNull
    @KeepForSdk
    @WorkerThread
    public OptionsT getBestConfiguredOptions(@NonNull OptionsT optionst) {
        List zza = this.zzb.zza(this.zza.zza(optionst));
        if (zza.isEmpty()) {
            Log.isLoggable("AccelerationManager", 3);
            return (OptionsT) optionst.cloneWithRunConfigAssigned("default_config", false);
        }
        if (Log.isLoggable("AccelerationManager", 3)) {
            "getBestConfiguredOptions: ".concat(String.valueOf(((RunConfig) zza.get(0)).zze()));
        }
        return (OptionsT) ((RunConfig) zza.get(0)).zzb();
    }

    @KeepForSdk
    protected AccelerationManager(@NonNull Context context, @NonNull PipelineId pipelineId, @NonNull AllowlistConfig<OptionsT> allowlistConfig, @NonNull MiniBenchmarkConfig<OptionsT, InputT, ResultT> miniBenchmarkConfig, @NonNull AccelerationLogger<OptionsT> accelerationLogger) {
        this.zza = new zza(context, pipelineId, allowlistConfig, accelerationLogger);
        this.zzb = new zzl(context, pipelineId, miniBenchmarkConfig, accelerationLogger);
    }
}
