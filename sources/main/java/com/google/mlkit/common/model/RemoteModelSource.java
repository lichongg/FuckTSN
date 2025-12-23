package com.google.mlkit.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_common.zzq;
import com.google.android.gms.internal.mlkit_common.zzr;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class RemoteModelSource {

    @Nullable
    private final String zza;

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(getClass())) {
            return Objects.equal(this.zza, ((RemoteModelSource) obj).zza);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @NonNull
    public String toString() {
        zzq zzb = zzr.zzb("RemoteModelSource");
        zzb.zza("firebaseModelName", this.zza);
        return zzb.toString();
    }

    @Nullable
    public final String zza() {
        return this.zza;
    }

    @KeepForSdk
    protected RemoteModelSource(@Nullable String str) {
        this.zza = str;
    }
}
