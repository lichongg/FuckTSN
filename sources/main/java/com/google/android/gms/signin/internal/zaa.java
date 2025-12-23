package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SafeParcelable.Class(creator = "AuthAccountResultCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();

    @SafeParcelable.VersionField(id = 1)
    final int zaa;

    @SafeParcelable.Field(getter = "getConnectionResultCode", id = 2)
    private int zab;

    @Nullable
    @SafeParcelable.Field(getter = "getRawAuthResolutionIntent", id = 3)
    private Intent zac;

    public zaa() {
        this(2, 0, null);
    }

    @SafeParcelable.Constructor
    zaa(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) int i7, @Nullable @SafeParcelable.Param(id = 3) Intent intent) {
        this.zaa = i6;
        this.zab = i7;
        this.zac = intent;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zab == 0 ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        int i7 = this.zaa;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i7);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i6, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
