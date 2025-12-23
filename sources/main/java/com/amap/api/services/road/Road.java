package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new Parcelable.Creator<Road>() { // from class: com.amap.api.services.road.Road.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Road[] newArray(int i6) {
            return null;
        }

        private static Road a(Parcel parcel) {
            return new Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Road createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9465a;

    /* renamed from: b, reason: collision with root package name */
    private String f9466b;

    /* renamed from: c, reason: collision with root package name */
    private String f9467c;

    /* renamed from: d, reason: collision with root package name */
    private float f9468d;

    /* renamed from: e, reason: collision with root package name */
    private String f9469e;

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f9470f;

    public Road() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Road(String str, String str2) {
        this.f9465a = str;
        this.f9466b = str2;
    }

    public LatLonPoint getCenterPoint() {
        return this.f9470f;
    }

    public String getCityCode() {
        return this.f9467c;
    }

    public String getId() {
        return this.f9465a;
    }

    public String getName() {
        return this.f9466b;
    }

    public float getRoadWidth() {
        return this.f9468d;
    }

    public String getType() {
        return this.f9469e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f9470f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f9467c = str;
    }

    public void setId(String str) {
        this.f9465a = str;
    }

    public void setName(String str) {
        this.f9466b = str;
    }

    public void setRoadWidth(float f6) {
        this.f9468d = f6;
    }

    public void setType(String str) {
        this.f9469e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9465a);
        parcel.writeString(this.f9466b);
        parcel.writeString(this.f9467c);
        parcel.writeFloat(this.f9468d);
        parcel.writeString(this.f9469e);
        parcel.writeValue(this.f9470f);
    }

    protected Road(Parcel parcel) {
        this.f9465a = parcel.readString();
        this.f9466b = parcel.readString();
        this.f9467c = parcel.readString();
        this.f9468d = parcel.readFloat();
        this.f9469e = parcel.readString();
        this.f9470f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
