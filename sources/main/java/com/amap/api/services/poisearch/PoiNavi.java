package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiNavi implements Parcelable {
    public static final Parcelable.Creator<PoiNavi> CREATOR = new Parcelable.Creator<PoiNavi>() { // from class: com.amap.api.services.poisearch.PoiNavi.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PoiNavi[] newArray(int i6) {
            return null;
        }

        private static PoiNavi a(Parcel parcel) {
            return new PoiNavi(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiNavi createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9386a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9387b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9388c;

    /* renamed from: d, reason: collision with root package name */
    private String f9389d;

    public PoiNavi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PoiNavi(String str, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, String str2) {
        this.f9386a = str;
        this.f9387b = latLonPoint;
        this.f9388c = latLonPoint2;
        this.f9389d = str2;
    }

    public LatLonPoint getEnter() {
        return this.f9387b;
    }

    public LatLonPoint getExit() {
        return this.f9388c;
    }

    public String getGridCode() {
        return this.f9389d;
    }

    public String getNaviPoiID() {
        return this.f9386a;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f9387b = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f9388c = latLonPoint;
    }

    public void setGridCode(String str) {
        this.f9389d = str;
    }

    public void setNaviPoiID(String str) {
        this.f9386a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9386a);
        parcel.writeValue(this.f9387b);
        parcel.writeValue(this.f9388c);
        parcel.writeString(this.f9389d);
    }

    public PoiNavi(Parcel parcel) {
        this.f9386a = parcel.readString();
        this.f9387b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9388c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9389d = parcel.readString();
    }
}
