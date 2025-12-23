package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();

    @SafeParcelable.VersionField(id = 1)
    final int zaa;

    @SafeParcelable.Field(getter = "getButtonSize", id = 2)
    private final int zab;

    @SafeParcelable.Field(getter = "getColorScheme", id = 3)
    private final int zac;

    @Nullable
    @SafeParcelable.Field(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] zad;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        int i7 = this.zaa;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i7);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zad, i6, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zax(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) int i7, @SafeParcelable.Param(id = 3) int i8, @Nullable @SafeParcelable.Param(id = 4) Scope[] scopeArr) {
        this.zaa = i6;
        this.zab = i7;
        this.zac = i8;
        this.zad = scopeArr;
    }
}
