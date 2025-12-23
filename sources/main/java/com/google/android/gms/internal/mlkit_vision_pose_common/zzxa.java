package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.Nullable;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzxa {
    private final zzwy zza;

    public static zzxa zzb(Date date) {
        return new zzxa(date, 1, null, null);
    }

    public static zzxa zzc(zzwy zzwyVar, String str) {
        return new zzxa(zzwyVar.zzb(), 0, zzwyVar, str);
    }

    public final zzwy zza() {
        return this.zza;
    }

    private zzxa(Date date, int i6, zzwy zzwyVar, @Nullable String str) {
        this.zza = zzwyVar;
    }
}
