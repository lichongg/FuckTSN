package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new Parcelable.Creator<SubPoiItem>() { // from class: com.amap.api.services.poisearch.SubPoiItem.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItem[] newArray(int i6) {
            return null;
        }

        private static SubPoiItem a(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9446a;

    /* renamed from: b, reason: collision with root package name */
    private String f9447b;

    /* renamed from: c, reason: collision with root package name */
    private String f9448c;

    /* renamed from: d, reason: collision with root package name */
    private int f9449d;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f9450e;

    /* renamed from: f, reason: collision with root package name */
    private String f9451f;

    /* renamed from: g, reason: collision with root package name */
    private String f9452g;

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f9446a = str;
        this.f9450e = latLonPoint;
        this.f9447b = str2;
        this.f9451f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f9449d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f9450e;
    }

    public String getPoiId() {
        return this.f9446a;
    }

    public String getSnippet() {
        return this.f9451f;
    }

    public String getSubName() {
        return this.f9448c;
    }

    public String getSubTypeDes() {
        return this.f9452g;
    }

    public String getTitle() {
        return this.f9447b;
    }

    public void setDistance(int i6) {
        this.f9449d = i6;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f9450e = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f9446a = str;
    }

    public void setSnippet(String str) {
        this.f9451f = str;
    }

    public void setSubName(String str) {
        this.f9448c = str;
    }

    public void setSubTypeDes(String str) {
        this.f9452g = str;
    }

    public void setTitle(String str) {
        this.f9447b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9446a);
        parcel.writeString(this.f9447b);
        parcel.writeString(this.f9448c);
        parcel.writeInt(this.f9449d);
        parcel.writeValue(this.f9450e);
        parcel.writeString(this.f9451f);
        parcel.writeString(this.f9452g);
    }

    public SubPoiItem(Parcel parcel) {
        this.f9446a = parcel.readString();
        this.f9447b = parcel.readString();
        this.f9448c = parcel.readString();
        this.f9449d = parcel.readInt();
        this.f9450e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9451f = parcel.readString();
        this.f9452g = parcel.readString();
    }
}
