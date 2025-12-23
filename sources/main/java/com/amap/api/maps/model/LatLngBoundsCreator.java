package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        int readInt = parcel.readInt();
        LatLng latLng2 = null;
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        } catch (BadParcelableException e6) {
            e = e6;
            latLng = null;
        }
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        } catch (BadParcelableException e7) {
            e = e7;
            e.printStackTrace();
            return new LatLngBounds(readInt, latLng, latLng2);
        }
        return new LatLngBounds(readInt, latLng, latLng2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds[] newArray(int i6) {
        return new LatLngBounds[i6];
    }

    static void a(LatLngBounds latLngBounds, Parcel parcel, int i6) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i6);
        parcel.writeParcelable(latLngBounds.northeast, i6);
    }
}
