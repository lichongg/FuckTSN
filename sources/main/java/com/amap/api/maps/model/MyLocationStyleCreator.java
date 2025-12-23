package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MyLocationStyleCreator implements Parcelable.Creator<MyLocationStyle> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MyLocationStyle createFromParcel(Parcel parcel) {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        myLocationStyle.anchor(parcel.readFloat(), parcel.readFloat());
        myLocationStyle.radiusFillColor(parcel.readInt());
        myLocationStyle.strokeColor(parcel.readInt());
        myLocationStyle.strokeWidth(parcel.readFloat());
        myLocationStyle.myLocationType(parcel.readInt());
        myLocationStyle.interval(parcel.readLong());
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        myLocationStyle.showMyLocation(zArr[0]);
        return myLocationStyle;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MyLocationStyle[] newArray(int i6) {
        return new MyLocationStyle[i6];
    }
}
