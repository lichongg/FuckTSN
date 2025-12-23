package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zznl {
    private final zznh zza;
    private final zznj zzb;
    private final zznj zzc;
    private final Boolean zzd;

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zznl) && Objects.equal(this.zza, ((zznl) obj).zza) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    @Nullable
    @zzbc(zza = 1)
    public final zznh zza() {
        return this.zza;
    }

    /* synthetic */ zznl(zzni zzniVar, zznk zznkVar) {
        zznh zznhVar;
        zznhVar = zzniVar.zza;
        this.zza = zznhVar;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
    }
}
