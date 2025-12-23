package com.google.android.gms.internal.mlkit_vision_pose_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzsk {
    private final zzsf zza;
    private final zzsh zzb;
    private final zzsh zzc;
    private final zzbd zzd;
    private final zzsi zze;

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsk)) {
            return false;
        }
        zzsk zzskVar = (zzsk) obj;
        return Objects.equal(this.zza, zzskVar.zza) && Objects.equal(this.zzb, zzskVar.zzb) && Objects.equal(this.zzc, zzskVar.zzc) && Objects.equal(this.zzd, zzskVar.zzd) && Objects.equal(this.zze, zzskVar.zze);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    @Nullable
    @zzcm(zza = 4)
    public final zzbd zza() {
        return this.zzd;
    }

    @Nullable
    @zzcm(zza = 1)
    public final zzsf zzb() {
        return this.zza;
    }

    @Nullable
    @zzcm(zza = 3)
    public final zzsh zzc() {
        return this.zzc;
    }

    @Nullable
    @zzcm(zza = 2)
    public final zzsh zzd() {
        return this.zzb;
    }

    @Nullable
    @zzcm(zza = 5)
    public final zzsi zze() {
        return this.zze;
    }

    /* synthetic */ zzsk(zzse zzseVar, zzsj zzsjVar) {
        zzsf zzsfVar;
        zzsh zzshVar;
        zzsh zzshVar2;
        zzbd zzbdVar;
        zzsi zzsiVar;
        zzsfVar = zzseVar.zza;
        this.zza = zzsfVar;
        zzshVar = zzseVar.zzb;
        this.zzb = zzshVar;
        zzshVar2 = zzseVar.zzc;
        this.zzc = zzshVar2;
        zzbdVar = zzseVar.zzd;
        this.zzd = zzbdVar;
        zzsiVar = zzseVar.zze;
        this.zze = zzsiVar;
    }
}
