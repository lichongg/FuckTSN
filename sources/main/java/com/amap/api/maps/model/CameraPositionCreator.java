package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition createFromParcel(Parcel parcel) {
        float readFloat = parcel.readFloat();
        float readFloat2 = parcel.readFloat();
        float readFloat3 = parcel.readFloat();
        return new CameraPosition(new LatLng(readFloat2, readFloat3), parcel.readFloat(), parcel.readFloat(), readFloat);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CameraPosition[] newArray(int i6) {
        return new CameraPosition[i6];
    }
}
