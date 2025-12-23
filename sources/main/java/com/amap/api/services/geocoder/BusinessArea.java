package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new Parcelable.Creator<BusinessArea>() { // from class: com.amap.api.services.geocoder.BusinessArea.1
        private static BusinessArea a(Parcel parcel) {
            return new BusinessArea(parcel);
        }

        private static BusinessArea[] a(int i6) {
            return new BusinessArea[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusinessArea[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9276a;

    /* renamed from: b, reason: collision with root package name */
    private String f9277b;

    public BusinessArea() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BusinessArea(Parcel parcel) {
        this.f9276a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9277b = parcel.readString();
    }

    public LatLonPoint getCenterPoint() {
        return this.f9276a;
    }

    public String getName() {
        return this.f9277b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f9276a = latLonPoint;
    }

    public void setName(String str) {
        this.f9277b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9276a, i6);
        parcel.writeString(this.f9277b);
    }
}
