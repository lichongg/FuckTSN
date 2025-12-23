package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public final class LatLng implements Parcelable, Cloneable {

    @JBindingExclude
    public static final LatLngCreator CREATOR = new LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d6, double d7) {
        this(d6, d7, true);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
    }

    @JBindingExclude
    public LatLng(double d6, double d7, boolean z5) {
        if (!z5) {
            this.latitude = d6;
            this.longitude = d7;
            return;
        }
        if (-180.0d > d7 || d7 >= 180.0d) {
            this.longitude = ((((d7 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.longitude = d7;
        }
        if (d6 < -90.0d || d6 > 90.0d) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e6) {
                e6.printStackTrace();
            }
        }
        this.latitude = Math.max(-90.0d, Math.min(90.0d, d6));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final LatLng m53clone() {
        return new LatLng(this.latitude, this.longitude);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i6 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i6 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }
}
