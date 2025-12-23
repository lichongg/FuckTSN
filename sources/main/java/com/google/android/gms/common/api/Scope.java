package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SafeParcelable.Class(creator = "ScopeCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new zza();

    @SafeParcelable.VersionField(id = 1)
    final int zza;

    @SafeParcelable.Field(getter = "getScopeUri", id = 2)
    private final String zzb;

    @SafeParcelable.Constructor
    Scope(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) String str) {
        Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.zza = i6;
        this.zzb = str;
    }

    public Scope(@NonNull String str) {
        this(1, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.zzb.equals(((Scope) obj).zzb);
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public String getScopeUri() {
        return this.zzb;
    }

    public int hashCode() {
        return this.zzb.hashCode();
    }

    @NonNull
    public String toString() {
        return this.zzb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        int i7 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i7);
        SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
