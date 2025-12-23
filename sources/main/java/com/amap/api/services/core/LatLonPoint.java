package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() { // from class: com.amap.api.services.core.LatLonPoint.1
        private static LatLonPoint a(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        private static LatLonPoint[] a(int i6) {
            return new LatLonPoint[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonPoint[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private double f9195a;

    /* renamed from: b, reason: collision with root package name */
    private double f9196b;

    public LatLonPoint(double d6, double d7) {
        this.f9195a = d6;
        this.f9196b = d7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.f9195a) == Double.doubleToLongBits(latLonPoint.f9195a) && Double.doubleToLongBits(this.f9196b) == Double.doubleToLongBits(latLonPoint.f9196b);
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f9195a, this.f9196b);
    }

    public double getLatitude() {
        return this.f9195a;
    }

    public double getLongitude() {
        return this.f9196b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f9195a);
        int i6 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f9196b);
        return (i6 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d6) {
        this.f9195a = d6;
    }

    public void setLongitude(double d6) {
        this.f9196b = d6;
    }

    public String toString() {
        return this.f9195a + "," + this.f9196b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeDouble(this.f9195a);
        parcel.writeDouble(this.f9196b);
    }

    protected LatLonPoint(Parcel parcel) {
        this.f9195a = parcel.readDouble();
        this.f9196b = parcel.readDouble();
    }
}
