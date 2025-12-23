package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() { // from class: com.amap.api.services.geocoder.AoiItem.1
        private static AoiItem a(Parcel parcel) {
            return new AoiItem(parcel);
        }

        private static AoiItem[] a(int i6) {
            return new AoiItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9271a;

    /* renamed from: b, reason: collision with root package name */
    private String f9272b;

    /* renamed from: c, reason: collision with root package name */
    private String f9273c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f9274d;

    /* renamed from: e, reason: collision with root package name */
    private Float f9275e;

    public AoiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AoiItem(Parcel parcel) {
        this.f9271a = parcel.readString();
        this.f9272b = parcel.readString();
        this.f9273c = parcel.readString();
        this.f9274d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9275e = Float.valueOf(parcel.readFloat());
    }

    public String getAdCode() {
        return this.f9273c;
    }

    public Float getAoiArea() {
        return this.f9275e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.f9274d;
    }

    public String getAoiId() {
        return this.f9271a;
    }

    public String getAoiName() {
        return this.f9272b;
    }

    public void setAdcode(String str) {
        this.f9273c = str;
    }

    public void setArea(Float f6) {
        this.f9275e = f6;
    }

    public void setId(String str) {
        this.f9271a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f9274d = latLonPoint;
    }

    public void setName(String str) {
        this.f9272b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9271a);
        parcel.writeString(this.f9272b);
        parcel.writeString(this.f9273c);
        parcel.writeParcelable(this.f9274d, i6);
        parcel.writeFloat(this.f9275e.floatValue());
    }
}
