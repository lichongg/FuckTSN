package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() { // from class: com.amap.api.services.core.LatLonSharePoint.1
        private static LatLonSharePoint a(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        private static LatLonSharePoint[] a(int i6) {
            return new LatLonSharePoint[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLonSharePoint[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9197a;

    public LatLonSharePoint(double d6, double d7, String str) {
        super(d6, d7);
        this.f9197a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.f9197a;
        if (str == null) {
            if (latLonSharePoint.f9197a != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.f9197a)) {
            return false;
        }
        return true;
    }

    public String getSharePointName() {
        return this.f9197a;
    }

    public void setSharePointName(String str) {
        this.f9197a = str;
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public String toString() {
        return super.toString() + "," + this.f9197a;
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f9197a = parcel.readString();
    }

    @Override // com.amap.api.services.core.LatLonPoint
    public int hashCode() {
        int hashCode;
        int hashCode2 = super.hashCode() * 31;
        String str = this.f9197a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @Override // com.amap.api.services.core.LatLonPoint, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeString(this.f9197a);
    }
}
