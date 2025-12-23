package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TileProjectionCreator implements Parcelable.Creator<TileProjection> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileProjection createFromParcel(Parcel parcel) {
        return new TileProjection(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileProjection[] newArray(int i6) {
        return new TileProjection[i6];
    }
}
