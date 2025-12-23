package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class b implements Parcelable.Creator<Tile> {
    private static Tile a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() == 1);
    }

    b() {
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i6) {
        return a(i6);
    }

    private static Tile[] a(int i6) {
        return new Tile[i6];
    }
}
