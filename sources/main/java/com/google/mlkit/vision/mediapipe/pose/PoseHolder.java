package com.google.mlkit.vision.mediapipe.pose;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfk;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfm;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class PoseHolder {
    private final List zza = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class PoseLandmarkHolder {
        private final int zza;
        private final float zzb;
        private final float zzc;
        private final float zzd;
        private final float zze;

        @KeepForSdk
        public float getInFrameLikelihood() {
            return this.zze;
        }

        @KeepForSdk
        public int getIndex() {
            return this.zza;
        }

        @KeepForSdk
        public float getX() {
            return this.zzb;
        }

        @KeepForSdk
        public float getY() {
            return this.zzc;
        }

        @KeepForSdk
        public float getZ() {
            return this.zzd;
        }

        PoseLandmarkHolder(int i6, float f6, float f7, float f8, float f9) {
            this.zza = i6;
            this.zzb = f6;
            this.zzc = f7;
            this.zzd = f8;
            this.zze = f9;
        }
    }

    @NonNull
    @KeepForSdk
    public List<PoseLandmarkHolder> getPoseLandmarkHolders() {
        return this.zza;
    }

    @VisibleForTesting
    public PoseHolder(zzfm zzfmVar) {
        int i6 = 0;
        for (zzfk zzfkVar : zzfmVar.zzd()) {
            this.zza.add(new PoseLandmarkHolder(i6, zzfkVar.zzc(), zzfkVar.zzd(), zzfkVar.zze(), zzfkVar.zza()));
            i6++;
        }
    }
}
