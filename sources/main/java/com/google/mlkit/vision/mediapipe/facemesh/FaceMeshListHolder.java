package com.google.mlkit.vision.mediapipe.facemesh;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfo;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzfq;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhj;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzii;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzin;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzno;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zznt;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzny;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzob;
import com.google.mlkit.vision.common.PointF3D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class FaceMeshListHolder {
    private final List zza;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KeepForSdk
    public static class FaceMeshHolder {
        private final Rect zza;
        private final List zzb = new ArrayList();
        private final List zzc = new ArrayList();

        public FaceMeshHolder(@NonNull Rect rect) {
            this.zza = rect;
        }

        @NonNull
        @KeepForSdk
        public Rect getBoundingBox() {
            return this.zza;
        }

        @NonNull
        @KeepForSdk
        public List<PointF3D> getPoints() {
            return this.zzb;
        }

        @NonNull
        @KeepForSdk
        public List<int[]> getTriangles() {
            return this.zzc;
        }

        public FaceMeshHolder(Rect rect, zzfq zzfqVar, zzii zziiVar, int i6, int i7) {
            this.zza = rect;
            zzin zzc = zziiVar.zzc();
            for (zzfo zzfoVar : zzfqVar.zzd()) {
                float f6 = i6;
                this.zzb.add(PointF3D.from(zzfoVar.zza() * f6, zzfoVar.zzc() * i7, zzfoVar.zzd() * f6));
            }
            Preconditions.checkArgument(zzc.zzc() % 3 == 0);
            for (int i8 = 0; i8 < zziiVar.zzc().zzc() / 3; i8++) {
                int i9 = i8 * 3;
                this.zzc.add(new int[]{zzc.zza(i9), zzc.zza(i9 + 1), zzc.zza(i9 + 2)});
            }
        }
    }

    @VisibleForTesting(otherwise = 3)
    public FaceMeshListHolder(@NonNull List list, int i6, int i7) {
        Rect rect;
        this.zza = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzob zzf = ((zzno) it.next()).zzf();
            if (zzf.zzh() == 2) {
                zznt zzc = zzf.zzc();
                rect = new Rect(zzc.zzf(), zzc.zzg(), zzc.zzf() + zzc.zze(), zzc.zzg() + zzc.zzc());
            } else if (zzf.zzh() == 3) {
                zzny zze = zzf.zze();
                float f6 = i6;
                float f7 = i7;
                rect = new Rect(Math.round(zze.zzf() * f6), Math.round(zze.zzg() * f7), Math.round((zze.zzf() + zze.zze()) * f6), Math.round((zze.zzg() + zze.zzc()) * f7));
            } else {
                rect = null;
            }
            if (rect != null) {
                this.zza.add(new FaceMeshHolder(rect));
            }
        }
    }

    @NonNull
    @KeepForSdk
    public List<FaceMeshHolder> getFaceMeshHolders() {
        return this.zza;
    }

    FaceMeshListHolder(List list, List list2, List list3, int i6, int i7) {
        int i8 = 0;
        Preconditions.checkArgument(list.size() == list2.size(), "Landmark list size is not equal to bounding box size");
        Preconditions.checkArgument(list.size() == list3.size(), "Landmark list size is not equal to face geometries size");
        this.zza = new ArrayList();
        while (i8 < list.size()) {
            zzhj zzhjVar = (zzhj) list2.get(i8);
            float f6 = i6;
            float f7 = i7;
            int i9 = i6;
            this.zza.add(new FaceMeshHolder(new Rect(Math.round((zzhjVar.zzd() - (zzhjVar.zzc() / 2.0f)) * f6), Math.round((zzhjVar.zze() - (zzhjVar.zza() / 2.0f)) * f7), Math.round((zzhjVar.zzd() + (zzhjVar.zzc() / 2.0f)) * f6), Math.round((zzhjVar.zze() + (zzhjVar.zza() / 2.0f)) * f7)), (zzfq) list.get(i8), (zzii) list3.get(i8), i9, i7));
            i8++;
            i6 = i9;
        }
    }
}
