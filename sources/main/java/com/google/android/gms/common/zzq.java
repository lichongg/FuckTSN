package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();

    @SafeParcelable.Field(getter = "getResult", id = 1)
    private final boolean zza;

    @Nullable
    @SafeParcelable.Field(getter = "getErrorMessage", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getStatusValue", id = 3)
    private final int zzc;

    @SafeParcelable.Field(getter = "getFirstPartyStatusValue", id = 4)
    private final int zzd;

    @Nullable
    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public final int zzc() {
        return zzd.zza(this.zzd);
    }

    public final int zzd() {
        return zzy.zza(this.zzc);
    }

    @SafeParcelable.Constructor
    zzq(@SafeParcelable.Param(id = 1) boolean z5, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) int i7) {
        this.zza = z5;
        this.zzb = str;
        this.zzc = zzy.zza(i6) - 1;
        this.zzd = zzd.zza(i7) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
