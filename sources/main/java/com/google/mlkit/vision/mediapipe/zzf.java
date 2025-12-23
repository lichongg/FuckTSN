package com.google.mlkit.vision.mediapipe;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhv;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzhz;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zziq;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@VisibleForTesting
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzf implements zzhz {
    final /* synthetic */ zzg zza;

    zzf(zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzhz
    public final void zza(List<zzhv> list) {
        ConcurrentHashMap concurrentHashMap;
        if (list == null || list.isEmpty()) {
            return;
        }
        long zzb = list.get(0).zzb();
        zziq.zze("From creating image packet to getting result packet").zzd(zzb);
        concurrentHashMap = this.zza.zzh;
        zze zzeVar = (zze) ((ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap)).remove(Long.valueOf(zzb));
        if (zzeVar != null) {
            zzeVar.zza(list);
        }
    }
}
