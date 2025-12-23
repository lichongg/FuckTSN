package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LatLngCreator implements Parcelable.Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLng createFromParcel(Parcel parcel) {
        return new LatLng(parcel.readDouble(), parcel.readDouble());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLng[] newArray(int i6) {
        return new LatLng[i6];
    }
}
