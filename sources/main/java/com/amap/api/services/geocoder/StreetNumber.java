package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() { // from class: com.amap.api.services.geocoder.StreetNumber.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StreetNumber[] newArray(int i6) {
            return null;
        }

        private static StreetNumber a(Parcel parcel) {
            return new StreetNumber(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StreetNumber createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9327a;

    /* renamed from: b, reason: collision with root package name */
    private String f9328b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9329c;

    /* renamed from: d, reason: collision with root package name */
    private String f9330d;

    /* renamed from: e, reason: collision with root package name */
    private float f9331e;

    /* synthetic */ StreetNumber(Parcel parcel, byte b6) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public StreetNumber() {
    }

    public final String getDirection() {
        return this.f9330d;
    }

    public final float getDistance() {
        return this.f9331e;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f9329c;
    }

    public final String getNumber() {
        return this.f9328b;
    }

    public final String getStreet() {
        return this.f9327a;
    }

    public final void setDirection(String str) {
        this.f9330d = str;
    }

    public final void setDistance(float f6) {
        this.f9331e = f6;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f9329c = latLonPoint;
    }

    public final void setNumber(String str) {
        this.f9328b = str;
    }

    public final void setStreet(String str) {
        this.f9327a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9327a);
        parcel.writeString(this.f9328b);
        parcel.writeValue(this.f9329c);
        parcel.writeString(this.f9330d);
        parcel.writeFloat(this.f9331e);
    }

    private StreetNumber(Parcel parcel) {
        this.f9327a = parcel.readString();
        this.f9328b = parcel.readString();
        this.f9329c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9330d = parcel.readString();
        this.f9331e = parcel.readFloat();
    }
}
