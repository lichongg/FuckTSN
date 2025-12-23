package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new Parcelable.Creator<TaxiItem>() { // from class: com.amap.api.services.route.TaxiItem.1
        private static TaxiItem a(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        private static TaxiItem[] a(int i6) {
            return new TaxiItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9768a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9769b;

    /* renamed from: c, reason: collision with root package name */
    private float f9770c;

    /* renamed from: d, reason: collision with root package name */
    private float f9771d;

    /* renamed from: e, reason: collision with root package name */
    private String f9772e;

    /* renamed from: f, reason: collision with root package name */
    private String f9773f;

    public TaxiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected TaxiItem(Parcel parcel) {
        this.f9768a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9769b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9770c = parcel.readFloat();
        this.f9771d = parcel.readFloat();
        this.f9772e = parcel.readString();
        this.f9773f = parcel.readString();
    }

    public LatLonPoint getDestination() {
        return this.f9769b;
    }

    public float getDistance() {
        return this.f9770c;
    }

    public float getDuration() {
        return this.f9771d;
    }

    public LatLonPoint getOrigin() {
        return this.f9768a;
    }

    public String getmSname() {
        return this.f9772e;
    }

    public String getmTname() {
        return this.f9773f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f9769b = latLonPoint;
    }

    public void setDistance(float f6) {
        this.f9770c = f6;
    }

    public void setDuration(float f6) {
        this.f9771d = f6;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f9768a = latLonPoint;
    }

    public void setSname(String str) {
        this.f9772e = str;
    }

    public void setTname(String str) {
        this.f9773f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9768a, i6);
        parcel.writeParcelable(this.f9769b, i6);
        parcel.writeFloat(this.f9770c);
        parcel.writeFloat(this.f9771d);
        parcel.writeString(this.f9772e);
        parcel.writeString(this.f9773f);
    }
}
