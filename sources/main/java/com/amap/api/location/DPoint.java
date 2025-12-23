package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator<DPoint>() { // from class: com.amap.api.location.DPoint.1
        private static DPoint a(Parcel parcel) {
            return new DPoint(parcel);
        }

        private static DPoint[] a(int i6) {
            return new DPoint[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DPoint[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private double f8905a;

    /* renamed from: b, reason: collision with root package name */
    private double f8906b;

    public DPoint() {
        this.f8905a = 0.0d;
        this.f8906b = 0.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return this.f8906b == dPoint.f8906b && this.f8905a == dPoint.f8905a;
    }

    public double getLatitude() {
        return this.f8906b;
    }

    public double getLongitude() {
        return this.f8905a;
    }

    public int hashCode() {
        return Double.valueOf((this.f8906b + this.f8905a) * 1000000.0d).intValue();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeDouble(this.f8905a);
        parcel.writeDouble(this.f8906b);
    }

    public DPoint(double d6, double d7) {
        this.f8905a = 0.0d;
        this.f8906b = 0.0d;
        d7 = d7 > 180.0d ? 180.0d : d7;
        d7 = d7 < -180.0d ? -180.0d : d7;
        d6 = d6 > 90.0d ? 90.0d : d6;
        d6 = d6 < -90.0d ? -90.0d : d6;
        this.f8905a = d7;
        this.f8906b = d6;
    }

    public void setLatitude(double d6) {
        if (d6 > 90.0d) {
            d6 = 90.0d;
        }
        if (d6 < -90.0d) {
            d6 = -90.0d;
        }
        this.f8906b = d6;
    }

    public void setLongitude(double d6) {
        if (d6 > 180.0d) {
            d6 = 180.0d;
        }
        if (d6 < -180.0d) {
            d6 = -180.0d;
        }
        this.f8905a = d6;
    }

    protected DPoint(Parcel parcel) {
        this.f8905a = 0.0d;
        this.f8906b = 0.0d;
        this.f8905a = parcel.readDouble();
        this.f8906b = parcel.readDouble();
    }
}
