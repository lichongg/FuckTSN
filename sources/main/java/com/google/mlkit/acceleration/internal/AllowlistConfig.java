package com.google.mlkit.acceleration.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public interface AllowlistConfig<OptionsT extends AcceleratableDetectorOptions<OptionsT>> {
    @NonNull
    @KeepForSdk
    String getBundledAllowlistAssetPath();

    @KeepForSdk
    boolean isRunConfigCompatibleWithOptions(@NonNull String str, @NonNull OptionsT optionst);

    @KeepForSdk
    boolean shouldCheckGenericGpuAllowlist(@NonNull String str);
}
