package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzfc {
    private final zzpo zza;
    private final Boolean zzb;
    private final zzox zzc;
    private final zzsk zzd;

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfc)) {
            return false;
        }
        zzfc zzfcVar = (zzfc) obj;
        return Objects.equal(this.zza, zzfcVar.zza) && Objects.equal(this.zzb, zzfcVar.zzb) && Objects.equal(null, null) && Objects.equal(this.zzd, zzfcVar.zzd);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, null, this.zzd);
    }

    @Nullable
    @zzcm(zza = 1)
    public final zzpo zza() {
        return this.zza;
    }

    @Nullable
    @zzcm(zza = 4)
    public final zzsk zzb() {
        return this.zzd;
    }

    @Nullable
    @zzcm(zza = 2)
    public final Boolean zzc() {
        return this.zzb;
    }

    /* synthetic */ zzfc(zzfa zzfaVar, zzfb zzfbVar) {
        zzpo zzpoVar;
        Boolean bool;
        zzsk zzskVar;
        zzpoVar = zzfaVar.zza;
        this.zza = zzpoVar;
        bool = zzfaVar.zzb;
        this.zzb = bool;
        this.zzc = null;
        zzskVar = zzfaVar.zzc;
        this.zzd = zzskVar;
    }
}
