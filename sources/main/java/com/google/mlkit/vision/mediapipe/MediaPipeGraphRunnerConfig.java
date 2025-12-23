package com.google.mlkit.vision.mediapipe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class MediaPipeGraphRunnerConfig {
    abstract MlKitContext zza();

    abstract String zzb();

    abstract List zzc();

    abstract List zzd();

    @Nullable
    abstract Map zze();

    @Nullable
    abstract Map zzf();

    @NonNull
    @KeepForSdk
    public static MediaPipeGraphRunnerConfig create(@NonNull MlKitContext mlKitContext, @NonNull String str, @NonNull List<String> list, @NonNull List<String> list2, @Nullable Map<String, String> map, @Nullable Map<String, MediaPipeInput> map2) {
        return new zza(mlKitContext, str, list, list2, map, map2);
    }
}
