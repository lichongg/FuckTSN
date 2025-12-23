package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TaxiItemV2 implements Parcelable {
    public static final Parcelable.Creator<TaxiItemV2> CREATOR = new Parcelable.Creator<TaxiItemV2>() { // from class: com.amap.api.services.route.TaxiItemV2.1
        private static TaxiItemV2 a(Parcel parcel) {
            return new TaxiItemV2(parcel);
        }

        private static TaxiItemV2[] a(int i6) {
            return new TaxiItemV2[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9774a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9775b;

    /* renamed from: c, reason: collision with root package name */
    private float f9776c;

    /* renamed from: d, reason: collision with root package name */
    private float f9777d;

    /* renamed from: e, reason: collision with root package name */
    private String f9778e;

    /* renamed from: f, reason: collision with root package name */
    private String f9779f;

    /* renamed from: g, reason: collision with root package name */
    private float f9780g;

    /* renamed from: h, reason: collision with root package name */
    private List<LatLonPoint> f9781h;

    public TaxiItemV2() {
        this.f9781h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f9775b;
    }

    public float getDistance() {
        return this.f9776c;
    }

    public float getDuration() {
        return this.f9777d;
    }

    public LatLonPoint getOrigin() {
        return this.f9774a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9781h;
    }

    public float getPrice() {
        return this.f9780g;
    }

    public String getmSname() {
        return this.f9778e;
    }

    public String getmTname() {
        return this.f9779f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f9775b = latLonPoint;
    }

    public void setDistance(float f6) {
        this.f9776c = f6;
    }

    public void setDuration(float f6) {
        this.f9777d = f6;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f9774a = latLonPoint;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9781h = list;
    }

    public void setPrice(float f6) {
        this.f9780g = f6;
    }

    public void setSname(String str) {
        this.f9778e = str;
    }

    public void setTname(String str) {
        this.f9779f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9774a, i6);
        parcel.writeParcelable(this.f9775b, i6);
        parcel.writeFloat(this.f9776c);
        parcel.writeFloat(this.f9777d);
        parcel.writeString(this.f9778e);
        parcel.writeString(this.f9779f);
        parcel.writeFloat(this.f9780g);
        parcel.writeTypedList(this.f9781h);
    }

    protected TaxiItemV2(Parcel parcel) {
        this.f9781h = new ArrayList();
        this.f9774a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9775b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9776c = parcel.readFloat();
        this.f9777d = parcel.readFloat();
        this.f9778e = parcel.readString();
        this.f9779f = parcel.readString();
        this.f9780g = parcel.readFloat();
        this.f9781h = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }
}
