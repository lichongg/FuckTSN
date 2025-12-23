package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel parcel) {
        BadParcelableException badParcelableException;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        LatLngBounds latLngBounds;
        int readInt = parcel.readInt();
        try {
            latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            } catch (BadParcelableException e6) {
                badParcelableException = e6;
                latLng2 = null;
                latLng3 = latLng2;
                latLng4 = latLng3;
                badParcelableException.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
            }
        } catch (BadParcelableException e7) {
            badParcelableException = e7;
            latLng = null;
            latLng2 = null;
        }
        try {
            latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                } catch (BadParcelableException e8) {
                    badParcelableException = e8;
                    badParcelableException.printStackTrace();
                    latLngBounds = null;
                    return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
                }
            } catch (BadParcelableException e9) {
                badParcelableException = e9;
                latLng4 = null;
            }
        } catch (BadParcelableException e10) {
            badParcelableException = e10;
            latLng3 = null;
            latLng4 = latLng3;
            badParcelableException.printStackTrace();
            latLngBounds = null;
            return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
        }
        return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int i6) {
        return new VisibleRegion[i6];
    }

    static void a(VisibleRegion visibleRegion, Parcel parcel, int i6) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i6);
        parcel.writeParcelable(visibleRegion.nearRight, i6);
        parcel.writeParcelable(visibleRegion.farLeft, i6);
        parcel.writeParcelable(visibleRegion.farRight, i6);
        parcel.writeParcelable(visibleRegion.latLngBounds, i6);
    }
}
