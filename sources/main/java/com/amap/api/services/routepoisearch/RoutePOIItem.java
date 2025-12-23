package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() { // from class: com.amap.api.services.routepoisearch.RoutePOIItem.1
        private static RoutePOIItem a(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        private static RoutePOIItem[] a(int i6) {
            return new RoutePOIItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9828a;

    /* renamed from: b, reason: collision with root package name */
    private String f9829b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9830c;

    /* renamed from: d, reason: collision with root package name */
    private float f9831d;

    /* renamed from: e, reason: collision with root package name */
    private float f9832e;

    /* renamed from: f, reason: collision with root package name */
    private String f9833f;

    public RoutePOIItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected RoutePOIItem(Parcel parcel) {
        this.f9828a = parcel.readString();
        this.f9829b = parcel.readString();
        this.f9830c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9831d = parcel.readFloat();
        this.f9832e = parcel.readFloat();
        this.f9833f = parcel.readString();
    }

    public String getCPID() {
        return this.f9833f;
    }

    public float getDistance() {
        return this.f9831d;
    }

    public float getDuration() {
        return this.f9832e;
    }

    public String getID() {
        return this.f9828a;
    }

    public LatLonPoint getPoint() {
        return this.f9830c;
    }

    public String getTitle() {
        return this.f9829b;
    }

    public void setCPID(String str) {
        this.f9833f = str;
    }

    public void setDistance(float f6) {
        this.f9831d = f6;
    }

    public void setDuration(float f6) {
        this.f9832e = f6;
    }

    public void setID(String str) {
        this.f9828a = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f9830c = latLonPoint;
    }

    public void setTitle(String str) {
        this.f9829b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9828a);
        parcel.writeString(this.f9829b);
        parcel.writeParcelable(this.f9830c, i6);
        parcel.writeFloat(this.f9831d);
        parcel.writeFloat(this.f9832e);
        parcel.writeString(this.f9833f);
    }
}
