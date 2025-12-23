package com.google.mlkit.vision.pose;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.vision.pose.internal.PoseDetectorImpl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PoseDetection {
    @NonNull
    public static PoseDetector getClient(@NonNull PoseDetectorOptionsBase poseDetectorOptionsBase) {
        Preconditions.checkNotNull(poseDetectorOptionsBase, "PoseDetectorOptionsBase can not be null.");
        return PoseDetectorImpl.newInstance(poseDetectorOptionsBase);
    }

    private PoseDetection() {
    }
}
