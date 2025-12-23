package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzar extends zzaf {
    final /* synthetic */ zzat zza;
    private final Object zzb;
    private int zzc;

    zzar(zzat zzatVar, int i6) {
        this.zza = zzatVar;
        this.zzb = zzat.zzg(zzatVar, i6);
        this.zzc = i6;
    }

    private final void zza() {
        int zzw;
        int i6 = this.zzc;
        if (i6 == -1 || i6 >= this.zza.size() || !zzp.zza(this.zzb, zzat.zzg(this.zza, this.zzc))) {
            zzw = this.zza.zzw(this.zzb);
            this.zzc = zzw;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzaf, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzaf, java.util.Map.Entry
    public final Object getValue() {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i6 = this.zzc;
        if (i6 == -1) {
            return null;
        }
        return zzat.zzj(this.zza, i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzaf, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i6 = this.zzc;
        if (i6 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzat zzatVar = this.zza;
        Object zzj = zzat.zzj(zzatVar, i6);
        zzat.zzn(zzatVar, this.zzc, obj);
        return zzj;
    }
}
