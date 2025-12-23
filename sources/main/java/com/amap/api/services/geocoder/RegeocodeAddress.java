package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new Parcelable.Creator<RegeocodeAddress>() { // from class: com.amap.api.services.geocoder.RegeocodeAddress.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeAddress[] newArray(int i6) {
            return null;
        }

        private static RegeocodeAddress a(Parcel parcel) {
            return new RegeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeAddress createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9296a;

    /* renamed from: b, reason: collision with root package name */
    private String f9297b;

    /* renamed from: c, reason: collision with root package name */
    private String f9298c;

    /* renamed from: d, reason: collision with root package name */
    private String f9299d;

    /* renamed from: e, reason: collision with root package name */
    private String f9300e;

    /* renamed from: f, reason: collision with root package name */
    private String f9301f;

    /* renamed from: g, reason: collision with root package name */
    private String f9302g;

    /* renamed from: h, reason: collision with root package name */
    private StreetNumber f9303h;

    /* renamed from: i, reason: collision with root package name */
    private String f9304i;

    /* renamed from: j, reason: collision with root package name */
    private String f9305j;

    /* renamed from: k, reason: collision with root package name */
    private String f9306k;

    /* renamed from: l, reason: collision with root package name */
    private List<RegeocodeRoad> f9307l;

    /* renamed from: m, reason: collision with root package name */
    private List<Crossroad> f9308m;

    /* renamed from: n, reason: collision with root package name */
    private List<PoiItem> f9309n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusinessArea> f9310o;

    /* renamed from: p, reason: collision with root package name */
    private List<AoiItem> f9311p;

    /* renamed from: q, reason: collision with root package name */
    private String f9312q;

    /* renamed from: r, reason: collision with root package name */
    private String f9313r;

    /* synthetic */ RegeocodeAddress(Parcel parcel, byte b6) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public RegeocodeAddress() {
        this.f9307l = new ArrayList();
        this.f9308m = new ArrayList();
        this.f9309n = new ArrayList();
        this.f9310o = new ArrayList();
        this.f9311p = new ArrayList();
    }

    public final String getAdCode() {
        return this.f9305j;
    }

    public final List<AoiItem> getAois() {
        return this.f9311p;
    }

    public final String getBuilding() {
        return this.f9302g;
    }

    public final List<BusinessArea> getBusinessAreas() {
        return this.f9310o;
    }

    public final String getCity() {
        return this.f9298c;
    }

    public final String getCityCode() {
        return this.f9304i;
    }

    public final String getCountry() {
        return this.f9312q;
    }

    public final String getCountryCode() {
        return this.f9313r;
    }

    public final List<Crossroad> getCrossroads() {
        return this.f9308m;
    }

    public final String getDistrict() {
        return this.f9299d;
    }

    public final String getFormatAddress() {
        return this.f9296a;
    }

    public final String getNeighborhood() {
        return this.f9301f;
    }

    public final List<PoiItem> getPois() {
        return this.f9309n;
    }

    public final String getProvince() {
        return this.f9297b;
    }

    public final List<RegeocodeRoad> getRoads() {
        return this.f9307l;
    }

    public final StreetNumber getStreetNumber() {
        return this.f9303h;
    }

    public final String getTowncode() {
        return this.f9306k;
    }

    public final String getTownship() {
        return this.f9300e;
    }

    public final void setAdCode(String str) {
        this.f9305j = str;
    }

    public final void setAois(List<AoiItem> list) {
        this.f9311p = list;
    }

    public final void setBuilding(String str) {
        this.f9302g = str;
    }

    public final void setBusinessAreas(List<BusinessArea> list) {
        this.f9310o = list;
    }

    public final void setCity(String str) {
        this.f9298c = str;
    }

    public final void setCityCode(String str) {
        this.f9304i = str;
    }

    public final void setCountry(String str) {
        this.f9312q = str;
    }

    public final void setCountryCode(String str) {
        this.f9313r = str;
    }

    public final void setCrossroads(List<Crossroad> list) {
        this.f9308m = list;
    }

    public final void setDistrict(String str) {
        this.f9299d = str;
    }

    public final void setFormatAddress(String str) {
        this.f9296a = str;
    }

    public final void setNeighborhood(String str) {
        this.f9301f = str;
    }

    public final void setPois(List<PoiItem> list) {
        this.f9309n = list;
    }

    public final void setProvince(String str) {
        this.f9297b = str;
    }

    public final void setRoads(List<RegeocodeRoad> list) {
        this.f9307l = list;
    }

    public final void setStreetNumber(StreetNumber streetNumber) {
        this.f9303h = streetNumber;
    }

    public final void setTowncode(String str) {
        this.f9306k = str;
    }

    public final void setTownship(String str) {
        this.f9300e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9296a);
        parcel.writeString(this.f9297b);
        parcel.writeString(this.f9298c);
        parcel.writeString(this.f9299d);
        parcel.writeString(this.f9300e);
        parcel.writeString(this.f9301f);
        parcel.writeString(this.f9302g);
        parcel.writeValue(this.f9303h);
        parcel.writeList(this.f9307l);
        parcel.writeList(this.f9308m);
        parcel.writeList(this.f9309n);
        parcel.writeString(this.f9304i);
        parcel.writeString(this.f9305j);
        parcel.writeList(this.f9310o);
        parcel.writeList(this.f9311p);
        parcel.writeString(this.f9306k);
        parcel.writeString(this.f9312q);
        parcel.writeString(this.f9313r);
    }

    private RegeocodeAddress(Parcel parcel) {
        this.f9307l = new ArrayList();
        this.f9308m = new ArrayList();
        this.f9309n = new ArrayList();
        this.f9310o = new ArrayList();
        this.f9311p = new ArrayList();
        this.f9296a = parcel.readString();
        this.f9297b = parcel.readString();
        this.f9298c = parcel.readString();
        this.f9299d = parcel.readString();
        this.f9300e = parcel.readString();
        this.f9301f = parcel.readString();
        this.f9302g = parcel.readString();
        this.f9303h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.f9307l = parcel.readArrayList(Road.class.getClassLoader());
        this.f9308m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.f9309n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.f9304i = parcel.readString();
        this.f9305j = parcel.readString();
        this.f9310o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.f9311p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.f9306k = parcel.readString();
        this.f9312q = parcel.readString();
        this.f9313r = parcel.readString();
    }
}
