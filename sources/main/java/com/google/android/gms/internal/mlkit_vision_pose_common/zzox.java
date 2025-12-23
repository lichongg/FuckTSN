package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzox {
    private final zzov zza;
    private final Integer zzb;
    private final Integer zzc;
    private final Boolean zzd;

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzox)) {
            return false;
        }
        zzox zzoxVar = (zzox) obj;
        return Objects.equal(this.zza, zzoxVar.zza) && Objects.equal(this.zzb, zzoxVar.zzb) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, null);
    }

    @Nullable
    @zzcm(zza = 1)
    public final zzov zza() {
        return this.zza;
    }

    @Nullable
    @zzcm(zza = 2)
    public final Integer zzb() {
        return this.zzb;
    }

    /* synthetic */ zzox(zzou zzouVar, zzow zzowVar) {
        zzov zzovVar;
        Integer num;
        zzovVar = zzouVar.zza;
        this.zza = zzovVar;
        num = zzouVar.zzb;
        this.zzb = num;
        this.zzc = null;
        this.zzd = null;
    }
}
