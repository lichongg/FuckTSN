package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzag implements zzbr {

    @CheckForNull
    private transient Set zza;

    @CheckForNull
    private transient Map zzb;

    abstract Map zzh();

    abstract Set zzi();

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbr
    public boolean zzm(Object obj, Object obj2) {
        throw null;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbr) {
            return zzn().equals(((zzbr) obj).zzn());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbr
    public final Map zzn() {
        Map map = this.zzb;
        if (map != null) {
            return map;
        }
        Map zzh = zzh();
        this.zzb = zzh;
        return zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzbr
    public final Set zzo() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set zzi = zzi();
        this.zza = zzi;
        return zzi;
    }

    zzag() {
    }

    public final int hashCode() {
        return zzn().hashCode();
    }

    public final String toString() {
        return zzn().toString();
    }
}
