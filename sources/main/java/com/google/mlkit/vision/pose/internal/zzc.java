package com.google.mlkit.vision.pose.internal;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.acceleration.internal.AcceleratableDetectorOptions;
import com.google.mlkit.acceleration.internal.MiniBenchmarkConfig;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.PointF3D;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseDetection;
import com.google.mlkit.vision.pose.PoseDetector;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import com.google.mlkit.vision.pose.PoseLandmark;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzc implements MiniBenchmarkConfig {
    final /* synthetic */ Context zza;

    @Nullable
    private PoseDetector zzb;

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final int getMaxRetryCount() {
        return 3;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final boolean requireDeviceIdle() {
        return false;
    }

    zzc(Context context) {
        this.zza = context;
    }

    private final InputImage zzc(String str) {
        try {
            return InputImage.fromBitmap(BitmapFactory.decodeStream(this.zza.getAssets().open(str)), 0);
        } catch (IOException e6) {
            throw new IllegalStateException("Failed to create test image from ".concat(str), e6);
        }
    }

    private static final Object zzd(Task task) {
        try {
            return Tasks.await(task, 20L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e6) {
            Log.isLoggable("PoseAccManager", 3);
            throw new IllegalStateException("PoseAccelerationManager failed with error: ".concat(String.valueOf(task)), e6);
        }
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final Task closeDetector() {
        PoseDetector poseDetector = this.zzb;
        Task<Void> forResult = poseDetector == null ? Tasks.forResult(null) : poseDetector.closeWithTask();
        this.zzb = null;
        return forResult;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final /* bridge */ /* synthetic */ float getCorrectnessScore(Object obj, Object obj2, Object obj3) {
        InputImage inputImage = (InputImage) obj;
        List<PoseLandmark> allPoseLandmarks = ((Pose) obj2).getAllPoseLandmarks();
        List<PoseLandmark> allPoseLandmarks2 = ((Pose) obj3).getAllPoseLandmarks();
        if (allPoseLandmarks.size() != allPoseLandmarks2.size()) {
            return 0.0f;
        }
        if (allPoseLandmarks.isEmpty()) {
            return 1.0f;
        }
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i6 = 0; i6 < allPoseLandmarks.size(); i6++) {
            PoseLandmark poseLandmark = allPoseLandmarks.get(i6);
            PoseLandmark poseLandmark2 = allPoseLandmarks2.get(i6);
            Preconditions.checkState(poseLandmark.getLandmarkType() == poseLandmark2.getLandmarkType(), "Mismatching landmark type");
            PointF3D position3D = poseLandmark.getPosition3D();
            PointF3D position3D2 = poseLandmark2.getPosition3D();
            f6 += Math.min(((float) Math.hypot(position3D.getX() - position3D2.getX(), position3D.getY() - position3D2.getY())) / inputImage.getWidth(), 1.0f);
            f7 += Math.min(Math.abs(position3D.getZ() - position3D2.getZ()) / inputImage.getWidth(), 1.0f);
            f8 += Math.abs(poseLandmark.getInFrameLikelihood() - poseLandmark2.getInFrameLikelihood());
        }
        float size = allPoseLandmarks.size();
        float f9 = f6 / size;
        float f10 = f8 / size;
        if (f7 / size >= 0.4d || f10 >= 0.1d) {
            return 0.0f;
        }
        return 1.0f - f9;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final /* bridge */ /* synthetic */ AcceleratableDetectorOptions getDefaultOptionsAsDecoder() {
        return new com.google.mlkit.vision.pose.zza().build();
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final /* bridge */ /* synthetic */ List getInputsWithExpectedResults(AcceleratableDetectorOptions acceleratableDetectorOptions) {
        List<InputImage> asList = Arrays.asList(zzc("mlkit_pose/benchmark_breaking1.data"), zzc("mlkit_pose/benchmark_breaking2.data"), zzc("mlkit_pose/benchmark_halfbody.data"), zzc("mlkit_pose/benchmark_jump.data"), zzc("mlkit_pose/benchmark_plant.data"));
        ArrayList arrayList = new ArrayList();
        initDetectorForCorrectnessBenchmark(((PoseDetectorOptionsBase) acceleratableDetectorOptions).cloneWithRunConfigAssigned("default_config", true));
        for (InputImage inputImage : asList) {
            arrayList.add(new Pair(inputImage, (Pose) zzd(runDetector(inputImage))));
        }
        zzd(closeDetector());
        return arrayList;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final int getLatencyBenchmarkRepetitionNumber() {
        return 15;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final int getTaskTimeoutSeconds() {
        return 40;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final Class getWorkerClass() {
        return PoseMiniBenchmarkWorker.class;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final /* bridge */ /* synthetic */ Task initDetectorForLatencyBenchmark(AcceleratableDetectorOptions acceleratableDetectorOptions) {
        PoseDetector client = PoseDetection.getClient((PoseDetectorOptionsBase) acceleratableDetectorOptions);
        this.zzb = client;
        return ((PoseDetector) Preconditions.checkNotNull(client)).getInitTask();
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final Task runDetector(InputImage inputImage) {
        return ((PoseDetector) Preconditions.checkNotNull(this.zzb)).process(inputImage);
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    public final float getCorrectnessScoreThreshold() {
        return 0.97f;
    }

    @Override // com.google.mlkit.acceleration.internal.MiniBenchmarkConfig
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Task initDetectorForCorrectnessBenchmark(PoseDetectorOptionsBase poseDetectorOptionsBase) {
        PoseDetector client = PoseDetection.getClient(poseDetectorOptionsBase.zzc());
        this.zzb = client;
        return ((PoseDetector) Preconditions.checkNotNull(client)).getInitTask();
    }
}
