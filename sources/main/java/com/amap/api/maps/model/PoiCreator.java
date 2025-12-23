package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiCreator implements Parcelable.Creator<Poi> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public Poi createFromParcel(Parcel parcel) {
        return new Poi(parcel.readString(), (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public Poi[] newArray(int i6) {
        return new Poi[i6];
    }
}
