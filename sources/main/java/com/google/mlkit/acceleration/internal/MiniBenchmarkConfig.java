package com.google.mlkit.acceleration.internal;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public interface MiniBenchmarkConfig<OptionsT extends AcceleratableDetectorOptions<OptionsT>, InputT, ResultT> {
    @NonNull
    @KeepForSdk
    Task<Void> closeDetector();

    @KeepForSdk
    float getCorrectnessScore(@NonNull InputT inputt, @NonNull ResultT resultt, @NonNull ResultT resultt2);

    @KeepForSdk
    float getCorrectnessScoreThreshold();

    @NonNull
    @KeepForSdk
    OptionsT getDefaultOptionsAsDecoder();

    @NonNull
    @KeepForSdk
    List<Pair<InputT, ResultT>> getInputsWithExpectedResults(@NonNull OptionsT optionst);

    @KeepForSdk
    int getLatencyBenchmarkRepetitionNumber();

    @KeepForSdk
    int getMaxRetryCount();

    @KeepForSdk
    int getTaskTimeoutSeconds();

    @NonNull
    @KeepForSdk
    Class<? extends MiniBenchmarkWorker<OptionsT, InputT, ResultT>> getWorkerClass();

    @NonNull
    @KeepForSdk
    Task<Void> initDetectorForCorrectnessBenchmark(@NonNull OptionsT optionst);

    @NonNull
    @KeepForSdk
    Task<Void> initDetectorForLatencyBenchmark(@NonNull OptionsT optionst);

    @KeepForSdk
    boolean requireDeviceIdle();

    @NonNull
    @KeepForSdk
    Task<ResultT> runDetector(@NonNull InputT inputt);
}
