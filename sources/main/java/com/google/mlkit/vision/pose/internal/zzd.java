package com.google.mlkit.vision.pose.internal;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzvi;
import com.google.mlkit.acceleration.internal.AccelerationLogger;
import com.google.mlkit.acceleration.internal.AccelerationManager;
import com.google.mlkit.acceleration.internal.PipelineId;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzd extends AccelerationManager {
    private static PipelineId zza;

    @WorkerThread
    public static synchronized PipelineId zzb() {
        PipelineId pipelineId;
        synchronized (zzd.class) {
            try {
                if (zza == null) {
                    zza = PipelineId.builder().setNamespace("mediapipe").setName("mlkit-pose").setClientLibraryName("pose-detection-common").setClientLibraryVersion(LibraryVersion.getInstance().getVersion("pose-detection-common")).build();
                }
                pipelineId = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pipelineId;
    }

    @WorkerThread
    public static synchronized zzd zzc() {
        zzd zzdVar;
        synchronized (zzd.class) {
            zzdVar = new zzd((Context) MlKitContext.getInstance().get(Context.class));
        }
        return zzdVar;
    }

    @WorkerThread
    private zzd(Context context) {
        super(context, zzb(), new zzb(), new zzc(context), zza());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.mlkit.vision.pose.internal.zza] */
    static AccelerationLogger zza() {
        return zzvi.zza(zzb(), new Object() { // from class: com.google.mlkit.vision.pose.internal.zza
        });
    }
}
