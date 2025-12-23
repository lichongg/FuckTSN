package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SafeParcelable.Class(creator = "ModuleInstallIntentResponseCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new zab();

    @Nullable
    @SafeParcelable.Field(getter = "getPendingIntent", id = 1)
    private final PendingIntent zaa;

    @Nullable
    public PendingIntent getPendingIntent() {
        return this.zaa;
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public ModuleInstallIntentResponse(@Nullable @SafeParcelable.Param(id = 1) PendingIntent pendingIntent) {
        this.zaa = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i6) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPendingIntent(), i6, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
