package com.google.mlkit.acceleration.internal;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.multiprocess.RemoteListenableWorker;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_acceleration.zzbb;
import com.google.android.gms.internal.mlkit_acceleration.zzbg;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class MiniBenchmarkWorker<OptionsT extends AcceleratableDetectorOptions<OptionsT>, InputT, ResultT> extends RemoteListenableWorker {
    private static final zzbb zza = zzbg.zza(Executors.newSingleThreadExecutor());
    private final MiniBenchmarkConfig zzb;
    private final List zzc;
    private final AcceleratableDetectorOptions zzd;
    private final zzm zze;
    private final AccelerationLogger zzf;

    private static Object zzc(Task task, String str, int i6) {
        try {
            return Tasks.await(task, i6, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e6) {
            zzd("MiniBenchmarkWorker", "waitTask failed: ".concat(str), e6);
            throw new IllegalStateException("MiniBenchmarkWorker failed with error: ".concat(str), e6);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @KeepForSdk
    public MiniBenchmarkWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters, @NonNull PipelineId pipelineId, @NonNull MiniBenchmarkConfig<OptionsT, InputT, ResultT> miniBenchmarkConfig, @NonNull AccelerationLogger<OptionsT> accelerationLogger) {
        super(context, workerParameters);
        zzm zzmVar = new zzm(context, pipelineId, accelerationLogger);
        this.zzb = miniBenchmarkConfig;
        OptionsT defaultOptionsAsDecoder = miniBenchmarkConfig.getDefaultOptionsAsDecoder();
        Data inputData = workerParameters.getInputData();
        this.zzd = (AcceleratableDetectorOptions) defaultOptionsAsDecoder.decode((String) Preconditions.checkNotNull(inputData.getString("mlkit_base_options_key")));
        this.zzc = Arrays.asList((String[]) Preconditions.checkNotNull(inputData.getStringArray("mlkit_run_config_name_array_key")));
        this.zze = zzmVar;
        this.zzf = accelerationLogger;
        zzd("MiniBenchmarkWorker", "constructed", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static /* synthetic */ ListenableWorker.Result zza(@NonNull MiniBenchmarkWorker miniBenchmarkWorker) {
        Throwable th;
        long j6;
        miniBenchmarkWorker.zze.zzc();
        Throwable th2 = null;
        zzd("MiniBenchmarkWorker", "Prepares test inputs", null);
        List<String> zza2 = miniBenchmarkWorker.zze.zza(miniBenchmarkWorker.zzd, miniBenchmarkWorker.zzc);
        if (zza2.isEmpty()) {
            zzd("MiniBenchmarkWorker", "Worker finishes: no configs need benchmark", null);
            return ListenableWorker.Result.success();
        }
        List<Pair> inputsWithExpectedResults = miniBenchmarkWorker.zzb.getInputsWithExpectedResults(miniBenchmarkWorker.zzd);
        for (String str : zza2) {
            AcceleratableDetectorOptions acceleratableDetectorOptions = (AcceleratableDetectorOptions) miniBenchmarkWorker.zzd.cloneWithRunConfigAssigned(str, true);
            try {
                String str2 = (String) Preconditions.checkNotNull(str);
                AcceleratableDetectorOptions acceleratableDetectorOptions2 = (AcceleratableDetectorOptions) Preconditions.checkNotNull(acceleratableDetectorOptions);
                zzd("MiniBenchmarkWorker", "Starts benchmarking ".concat(String.valueOf(str2)), th2);
                zzm zzmVar = miniBenchmarkWorker.zze;
                zzb zzbVar = new zzb();
                zzbVar.zzb(false);
                zzbVar.zzd(0);
                zzbVar.zza(0.0f);
                zzbVar.zzc(0);
                zzmVar.zzf(str2, acceleratableDetectorOptions2, zzbVar.zze());
                zzd("MiniBenchmarkWorker", "Step1: Measures correctness", th2);
                miniBenchmarkWorker.zzb(miniBenchmarkWorker.zzb.initDetectorForCorrectnessBenchmark(acceleratableDetectorOptions2), "correctness initDetector");
                float f6 = Float.MAX_VALUE;
                for (Pair pair : inputsWithExpectedResults) {
                    Object obj = pair.first;
                    float correctnessScore = miniBenchmarkWorker.zzb.getCorrectnessScore(obj, pair.second, miniBenchmarkWorker.zzb(miniBenchmarkWorker.zzb.runDetector(obj), "correctness runDetector"));
                    zzd("MiniBenchmarkWorker", "correctnessScore = " + correctnessScore, th2);
                    f6 = Math.min(f6, correctnessScore);
                }
                miniBenchmarkWorker.zzb(miniBenchmarkWorker.zzb.closeDetector(), "correctness closeDetector");
                zzd("MiniBenchmarkWorker", "Step2: Measures run latency", th2);
                Object obj2 = ((Pair) inputsWithExpectedResults.get(0)).first;
                int latencyBenchmarkRepetitionNumber = miniBenchmarkWorker.zzb.getLatencyBenchmarkRepetitionNumber();
                if (latencyBenchmarkRepetitionNumber > 0) {
                    zzc(miniBenchmarkWorker.zzb.initDetectorForLatencyBenchmark(acceleratableDetectorOptions2), "latency initDetector", 5);
                    zzc(miniBenchmarkWorker.zzb.runDetector(obj2), "latency runDetector", 5);
                    ArrayList arrayList = new ArrayList();
                    for (int i6 = 0; i6 < latencyBenchmarkRepetitionNumber; i6++) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        zzc(miniBenchmarkWorker.zzb.runDetector(obj2), "latency runDetector", 5);
                        arrayList.add(Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                    miniBenchmarkWorker.zzb(miniBenchmarkWorker.zzb.closeDetector(), "latency closeDetector");
                    Collections.sort(arrayList);
                    int i7 = (int) (latencyBenchmarkRepetitionNumber * 0.2d);
                    long j7 = 0;
                    for (int i8 = i7; i8 < latencyBenchmarkRepetitionNumber - i7; i8++) {
                        j7 += ((Long) arrayList.get(i8)).longValue();
                    }
                    j6 = j7 / (latencyBenchmarkRepetitionNumber - (i7 + i7));
                    th = null;
                } else {
                    th = null;
                    zzd("MiniBenchmarkWorker", "Skipping the latency measurements.", null);
                    j6 = -1;
                }
                zzd("MiniBenchmarkWorker", "Mini-benchmark completed successfully for ".concat(String.valueOf(str2)), th);
                zzd("MiniBenchmarkWorker", "    minCorrectnessScore = " + f6, null);
                zzd("MiniBenchmarkWorker", "    avgRunLatencyMs = " + j6, null);
                zzb zzbVar2 = new zzb();
                zzbVar2.zzb(false);
                zzbVar2.zzd(1);
                zzbVar2.zza(f6);
                zzbVar2.zzc((int) j6);
                miniBenchmarkWorker.zze.zzf(str2, acceleratableDetectorOptions2, zzbVar2.zze());
                th2 = null;
            } catch (RuntimeException e6) {
                miniBenchmarkWorker.zzf.logBenchmarkPipelineError((AcceleratableDetectorOptions) Preconditions.checkNotNull(acceleratableDetectorOptions), e6);
                throw e6;
            }
        }
        zzd("MiniBenchmarkWorker", "Worker finishes", null);
        return ListenableWorker.Result.success();
    }

    private final Object zzb(Task task, String str) {
        return zzc(task, str, this.zzb.getTaskTimeoutSeconds());
    }

    private static void zzd(String str, String str2, @Nullable Throwable th) {
        Log.isLoggable("MiniBenchmarkWorker", 3);
    }

    @Override // androidx.work.multiprocess.RemoteListenableWorker
    @NonNull
    @KeepForSdk
    public ListenableFuture<ListenableWorker.Result> startRemoteWork() {
        zzd("MiniBenchmarkWorker", "startRemoteWork", null);
        zzd("MiniBenchmarkWorker", "runConfigNameList = ".concat(String.valueOf(this.zzc)), null);
        return zza.zza(new Callable() { // from class: com.google.mlkit.acceleration.internal.zzu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return MiniBenchmarkWorker.zza(MiniBenchmarkWorker.this);
            }
        });
    }

    @Override // androidx.work.multiprocess.RemoteListenableWorker, androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        zzd("MiniBenchmarkWorker", "Benchmark interrupted", null);
        this.zze.zzc();
        zzb(this.zzb.closeDetector(), "onStopped closeDetector");
    }
}
