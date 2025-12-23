package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
@SafeParcelable.Class(creator = "VisionImageMetadataParcelCreator")
/* loaded from: D:\Downloads\app\classes5.dex */
public class VisionImageMetadataParcel extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new zzg();

    @KeepForSdk
    @SafeParcelable.Field(id = 2)
    public final int height;

    @KeepForSdk
    @SafeParcelable.Field(id = 5)
    public final int rotation;

    @KeepForSdk
    @SafeParcelable.Field(id = 4)
    public final long timestampMillis;

    @KeepForSdk
    @SafeParcelable.Field(id = 1)
    public final int width;

    @SafeParcelable.Field(id = 3)
    public final int zza;

    @SafeParcelable.Constructor
    public VisionImageMetadataParcel(@SafeParcelable.Param(id = 1) int i6, @SafeParcelable.Param(id = 2) int i7, @SafeParcelable.Param(id = 3) int i8, @SafeParcelable.Param(id = 4) long j6, @SafeParcelable.Param(id = 5) int i9) {
        this.width = i6;
        this.height = i7;
        this.zza = i8;
        this.timestampMillis = j6;
        this.rotation = i9;
    }

    @Nullable
    @KeepForSdk
    public Matrix getUprightRotationMatrix() {
        return ImageUtils.getInstance().getUprightRotationMatrix(this.width, this.height, this.rotation);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i6) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.width);
        SafeParcelWriter.writeInt(parcel, 2, this.height);
        SafeParcelWriter.writeInt(parcel, 3, this.zza);
        SafeParcelWriter.writeLong(parcel, 4, this.timestampMillis);
        SafeParcelWriter.writeInt(parcel, 5, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
