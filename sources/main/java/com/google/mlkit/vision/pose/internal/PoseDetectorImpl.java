package com.google.mlkit.vision.pose.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpn;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpp;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzpq;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzsb;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwk;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwn;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwv;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseDetector;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PoseDetectorImpl extends MobileVisionBase<Pose> implements PoseDetector {
    private final PoseDetectorOptionsBase zzb;

    @Override // com.google.mlkit.vision.interfaces.Detector
    public final int getDetectorType() {
        return 6;
    }

    @Override // com.google.mlkit.vision.pose.PoseDetector
    @NonNull
    @KeepForSdk
    public Task<Pose> process(@NonNull MlImage mlImage) {
        return super.processBase(mlImage);
    }

    private PoseDetectorImpl(@NonNull MlKitContext mlKitContext, @NonNull PoseDetectorOptionsBase poseDetectorOptionsBase) {
        super((zzh) ((zze) mlKitContext.get(zze.class)).get(poseDetectorOptionsBase), ((ExecutorSelector) mlKitContext.get(ExecutorSelector.class)).getExecutorToUse(poseDetectorOptionsBase.getExecutor()));
        this.zzb = poseDetectorOptionsBase;
        zzd(zzpp.ON_DEVICE_POSE_CREATE, poseDetectorOptionsBase);
    }

    @NonNull
    @KeepForSdk
    public static PoseDetectorImpl newInstance(@NonNull PoseDetectorOptionsBase poseDetectorOptionsBase) {
        Preconditions.checkNotNull(poseDetectorOptionsBase, "PoseDetectorOptionsBase can not be null.");
        return new PoseDetectorImpl(MlKitContext.getInstance(), poseDetectorOptionsBase);
    }

    @Override // com.google.mlkit.vision.pose.PoseDetector
    @NonNull
    public final Task<Void> getInitTask() {
        zzd(zzpp.ON_DEVICE_POSE_PRELOAD, this.zzb);
        return super.getInitTaskBase();
    }

    @Override // com.google.mlkit.vision.pose.PoseDetector
    @NonNull
    @KeepForSdk
    public Task<Pose> process(@NonNull InputImage inputImage) {
        return super.processBase(inputImage);
    }

    private static void zzd(zzpp zzppVar, PoseDetectorOptionsBase poseDetectorOptionsBase) {
        if (poseDetectorOptionsBase.isForBenchmark()) {
            return;
        }
        zzwk zzb = zzwv.zzb("pose-detection-common");
        zzpq zzpqVar = new zzpq();
        zzpqVar.zzf(zzpn.TYPE_THICK);
        zzsb zzsbVar = new zzsb();
        zzsbVar.zzc(poseDetectorOptionsBase.zzb());
        zzpqVar.zzh(zzsbVar.zzi());
        zzb.zzd(zzwn.zzg(zzpqVar, 1), zzppVar);
    }
}
