package com.google.mlkit.vision.pose.defaults;

import androidx.annotation.NonNull;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PoseDetectorOptions extends PoseDetectorOptionsBase {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder extends PoseDetectorOptionsBase.Builder<Builder> {
        @Override // com.google.mlkit.vision.pose.PoseDetectorOptionsBase.Builder
        @NonNull
        public PoseDetectorOptions build() {
            super.setModelInfo(true, "mlkit_pose/pose_person_detector_f16.tflite", "mlkit_pose/pose_landmark_detector_lite_f16_inf.tflite");
            return new PoseDetectorOptions(this, null);
        }

        @Override // com.google.mlkit.vision.pose.PoseDetectorOptionsBase.Builder
        @NonNull
        public Builder setDetectorMode(@PoseDetectorOptionsBase.DetectorMode int i6) {
            return (Builder) super.setDetectorMode(i6);
        }

        @Override // com.google.mlkit.vision.pose.PoseDetectorOptionsBase.Builder
        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            return (Builder) super.setExecutor(executor);
        }

        @Override // com.google.mlkit.vision.pose.PoseDetectorOptionsBase.Builder
        @NonNull
        public Builder setPreferredHardwareConfigs(@PoseDetectorOptionsBase.HardwareConfig int i6, @NonNull @PoseDetectorOptionsBase.HardwareConfig int... iArr) {
            return (Builder) super.setPreferredHardwareConfigs(i6, iArr);
        }
    }

    /* synthetic */ PoseDetectorOptions(Builder builder, zza zzaVar) {
        super(builder);
    }
}
