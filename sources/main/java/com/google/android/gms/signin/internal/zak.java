package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SafeParcelable.Class(creator = "SignInResponseCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();

    @SafeParcelable.VersionField(id = 1)
    final int zaa;

    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult zab;

    @Nullable
    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)
    private final zav zac;

    public final ConnectionResult zaa() {
        return this.zab;
    }

    @Nullable
    public final zav zab() {
        return this.zac;
    }

    @SafeParcelable.Constructor
    zak(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @Nullable @SafeParcelable.Param(id = 3) zav zavVar) {
        this.zaa = i6;
        this.zab = connectionResult;
        this.zac = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaa);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i6, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i6, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
