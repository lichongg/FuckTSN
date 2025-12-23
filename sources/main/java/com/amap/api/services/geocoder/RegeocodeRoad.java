package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new Parcelable.Creator<RegeocodeRoad>() { // from class: com.amap.api.services.geocoder.RegeocodeRoad.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeRoad[] newArray(int i6) {
            return null;
        }

        private static RegeocodeRoad a(Parcel parcel) {
            return new RegeocodeRoad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeRoad createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9322a;

    /* renamed from: b, reason: collision with root package name */
    private String f9323b;

    /* renamed from: c, reason: collision with root package name */
    private float f9324c;

    /* renamed from: d, reason: collision with root package name */
    private String f9325d;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f9326e;

    /* synthetic */ RegeocodeRoad(Parcel parcel, byte b6) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public RegeocodeRoad() {
    }

    public final String getDirection() {
        return this.f9325d;
    }

    public final float getDistance() {
        return this.f9324c;
    }

    public final String getId() {
        return this.f9322a;
    }

    public final LatLonPoint getLatLngPoint() {
        return this.f9326e;
    }

    public final String getName() {
        return this.f9323b;
    }

    public final void setDirection(String str) {
        this.f9325d = str;
    }

    public final void setDistance(float f6) {
        this.f9324c = f6;
    }

    public final void setId(String str) {
        this.f9322a = str;
    }

    public final void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f9326e = latLonPoint;
    }

    public final void setName(String str) {
        this.f9323b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9322a);
        parcel.writeString(this.f9323b);
        parcel.writeFloat(this.f9324c);
        parcel.writeString(this.f9325d);
        parcel.writeValue(this.f9326e);
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f9322a = parcel.readString();
        this.f9323b = parcel.readString();
        this.f9324c = parcel.readFloat();
        this.f9325d = parcel.readString();
        this.f9326e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
