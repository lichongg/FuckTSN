package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new Parcelable.Creator<GeocodeAddress>() { // from class: com.amap.api.services.geocoder.GeocodeAddress.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GeocodeAddress[] newArray(int i6) {
            return null;
        }

        private static GeocodeAddress a(Parcel parcel) {
            return new GeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GeocodeAddress createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9278a;

    /* renamed from: b, reason: collision with root package name */
    private String f9279b;

    /* renamed from: c, reason: collision with root package name */
    private String f9280c;

    /* renamed from: d, reason: collision with root package name */
    private String f9281d;

    /* renamed from: e, reason: collision with root package name */
    private String f9282e;

    /* renamed from: f, reason: collision with root package name */
    private String f9283f;

    /* renamed from: g, reason: collision with root package name */
    private String f9284g;

    /* renamed from: h, reason: collision with root package name */
    private String f9285h;

    /* renamed from: i, reason: collision with root package name */
    private LatLonPoint f9286i;

    /* renamed from: j, reason: collision with root package name */
    private String f9287j;

    /* renamed from: k, reason: collision with root package name */
    private String f9288k;

    /* renamed from: l, reason: collision with root package name */
    private String f9289l;

    /* synthetic */ GeocodeAddress(Parcel parcel, byte b6) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public GeocodeAddress() {
    }

    public final String getAdcode() {
        return this.f9285h;
    }

    public final String getBuilding() {
        return this.f9284g;
    }

    public final String getCity() {
        return this.f9280c;
    }

    public final String getCountry() {
        return this.f9288k;
    }

    public final String getDistrict() {
        return this.f9281d;
    }

    public final String getFormatAddress() {
        return this.f9278a;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f9286i;
    }

    public final String getLevel() {
        return this.f9287j;
    }

    public final String getNeighborhood() {
        return this.f9283f;
    }

    public final String getPostcode() {
        return this.f9289l;
    }

    public final String getProvince() {
        return this.f9279b;
    }

    public final String getTownship() {
        return this.f9282e;
    }

    public final void setAdcode(String str) {
        this.f9285h = str;
    }

    public final void setBuilding(String str) {
        this.f9284g = str;
    }

    public final void setCity(String str) {
        this.f9280c = str;
    }

    public final void setCountry(String str) {
        this.f9288k = str;
    }

    public final void setDistrict(String str) {
        this.f9281d = str;
    }

    public final void setFormatAddress(String str) {
        this.f9278a = str;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f9286i = latLonPoint;
    }

    public final void setLevel(String str) {
        this.f9287j = str;
    }

    public final void setNeighborhood(String str) {
        this.f9283f = str;
    }

    public final void setPostcode(String str) {
        this.f9289l = str;
    }

    public final void setProvince(String str) {
        this.f9279b = str;
    }

    public final void setTownship(String str) {
        this.f9282e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9278a);
        parcel.writeString(this.f9279b);
        parcel.writeString(this.f9280c);
        parcel.writeString(this.f9281d);
        parcel.writeString(this.f9282e);
        parcel.writeString(this.f9283f);
        parcel.writeString(this.f9284g);
        parcel.writeString(this.f9285h);
        parcel.writeValue(this.f9286i);
        parcel.writeString(this.f9287j);
        parcel.writeString(this.f9288k);
        parcel.writeString(this.f9289l);
    }

    private GeocodeAddress(Parcel parcel) {
        this.f9278a = parcel.readString();
        this.f9279b = parcel.readString();
        this.f9280c = parcel.readString();
        this.f9281d = parcel.readString();
        this.f9282e = parcel.readString();
        this.f9283f = parcel.readString();
        this.f9284g = parcel.readString();
        this.f9285h = parcel.readString();
        this.f9286i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9287j = parcel.readString();
        this.f9288k = parcel.readString();
        this.f9289l = parcel.readString();
    }
}
