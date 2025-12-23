package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class GroundOverlayOptionsCreator implements Parcelable.Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions(readInt, (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), parcel.readByte() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        groundOverlayOptions.image(bitmapDescriptor);
        return groundOverlayOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions[] newArray(int i6) {
        return new GroundOverlayOptions[i6];
    }
}
