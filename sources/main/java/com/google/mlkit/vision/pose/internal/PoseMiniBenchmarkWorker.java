package com.google.mlkit.vision.pose.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.acceleration.internal.MiniBenchmarkWorker;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.pose.Pose;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class PoseMiniBenchmarkWorker extends MiniBenchmarkWorker<PoseDetectorOptionsBase, InputImage, Pose> {
    @KeepForSdk
    public PoseMiniBenchmarkWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super((Context) MlKitContext.initializeIfNeeded(context).get(Context.class), workerParameters, zzd.zzb(), new zzc(context), zzd.zza());
    }
}
