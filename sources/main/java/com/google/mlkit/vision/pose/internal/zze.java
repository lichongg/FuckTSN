package com.google.mlkit.vision.pose.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzwv;
import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zze extends LazyInstanceMap {
    private final MlKitContext zza;

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    @NonNull
    protected final /* bridge */ /* synthetic */ Object create(@NonNull Object obj) {
        return new zzh(this.zza, (PoseDetectorOptionsBase) obj, zzwv.zzb("pose-detection-common"));
    }

    public zze(@NonNull MlKitContext mlKitContext) {
        this.zza = mlKitContext;
    }
}
