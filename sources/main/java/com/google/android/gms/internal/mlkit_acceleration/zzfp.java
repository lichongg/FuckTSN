package com.google.android.gms.internal.mlkit_acceleration;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfp extends zzfz {
    zzfp(int i6) {
        super(i6, null);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfz
    public final void zza() {
        if (!zzj()) {
            for (int i6 = 0; i6 < zzb(); i6++) {
                Map.Entry zzg = zzg(i6);
                if (((zzdm) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzdm) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
