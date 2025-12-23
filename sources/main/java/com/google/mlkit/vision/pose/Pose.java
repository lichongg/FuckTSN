package com.google.mlkit.vision.pose;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzba;
import com.google.android.gms.internal.mlkit_vision_pose_common.zzbd;
import com.google.mlkit.vision.common.PointF3D;
import com.google.mlkit.vision.mediapipe.pose.PoseHolder;
import com.google.mlkit.vision.pose.PoseLandmark;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class Pose {
    private final zzbd zza;

    @NonNull
    public List<PoseLandmark> getAllPoseLandmarks() {
        return this.zza;
    }

    @Nullable
    public PoseLandmark getPoseLandmark(@PoseLandmark.LandmarkType int i6) {
        if (this.zza.isEmpty()) {
            return null;
        }
        return (PoseLandmark) this.zza.get(i6);
    }

    public Pose(@NonNull PoseHolder poseHolder, @Nullable Matrix matrix) {
        PoseHolder.PoseLandmarkHolder next;
        int index;
        Preconditions.checkNotNull(poseHolder);
        zzba zzbaVar = new zzba();
        Iterator<PoseHolder.PoseLandmarkHolder> it = poseHolder.getPoseLandmarkHolders().iterator();
        while (it.hasNext() && (index = (next = it.next()).getIndex()) < 33) {
            PointF pointF = new PointF(next.getX(), next.getY());
            zzbaVar.zzb(new PoseLandmark(index, PointF3D.from(pointF.x, pointF.y, next.getZ()), next.getInFrameLikelihood()));
        }
        this.zza = zzbaVar.zzc();
    }
}
