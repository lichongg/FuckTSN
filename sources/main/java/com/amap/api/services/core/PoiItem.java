package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItem.1
        private static PoiItem a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        private static PoiItem[] a(int i6) {
            return new PoiItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i6) {
            return a(i6);
        }
    };
    private String A;
    private String B;

    /* renamed from: a, reason: collision with root package name */
    private String f9198a;

    /* renamed from: b, reason: collision with root package name */
    private String f9199b;

    /* renamed from: c, reason: collision with root package name */
    private String f9200c;

    /* renamed from: d, reason: collision with root package name */
    private String f9201d;

    /* renamed from: e, reason: collision with root package name */
    private String f9202e;

    /* renamed from: f, reason: collision with root package name */
    private int f9203f;

    /* renamed from: g, reason: collision with root package name */
    private final LatLonPoint f9204g;

    /* renamed from: h, reason: collision with root package name */
    private final String f9205h;

    /* renamed from: i, reason: collision with root package name */
    private final String f9206i;

    /* renamed from: j, reason: collision with root package name */
    private LatLonPoint f9207j;

    /* renamed from: k, reason: collision with root package name */
    private LatLonPoint f9208k;

    /* renamed from: l, reason: collision with root package name */
    private String f9209l;

    /* renamed from: m, reason: collision with root package name */
    private String f9210m;

    /* renamed from: n, reason: collision with root package name */
    private String f9211n;

    /* renamed from: o, reason: collision with root package name */
    private String f9212o;

    /* renamed from: p, reason: collision with root package name */
    private String f9213p;

    /* renamed from: q, reason: collision with root package name */
    private String f9214q;

    /* renamed from: r, reason: collision with root package name */
    private String f9215r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9216s;

    /* renamed from: t, reason: collision with root package name */
    private IndoorData f9217t;

    /* renamed from: u, reason: collision with root package name */
    private String f9218u;

    /* renamed from: v, reason: collision with root package name */
    private String f9219v;

    /* renamed from: w, reason: collision with root package name */
    private String f9220w;

    /* renamed from: x, reason: collision with root package name */
    private List<SubPoiItem> f9221x;

    /* renamed from: y, reason: collision with root package name */
    private List<Photo> f9222y;

    /* renamed from: z, reason: collision with root package name */
    private PoiItemExtension f9223z;

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f9202e = "";
        this.f9203f = -1;
        this.f9221x = new ArrayList();
        this.f9222y = new ArrayList();
        this.f9198a = str;
        this.f9204g = latLonPoint;
        this.f9205h = str2;
        this.f9206i = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PoiItem poiItem = (PoiItem) obj;
        String str = this.f9198a;
        if (str == null) {
            if (poiItem.f9198a != null) {
                return false;
            }
        } else if (!str.equals(poiItem.f9198a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f9200c;
    }

    public String getAdName() {
        return this.f9215r;
    }

    public String getBusinessArea() {
        return this.f9219v;
    }

    public String getCityCode() {
        return this.f9201d;
    }

    public String getCityName() {
        return this.f9214q;
    }

    public String getDirection() {
        return this.f9212o;
    }

    public int getDistance() {
        return this.f9203f;
    }

    public String getEmail() {
        return this.f9211n;
    }

    public LatLonPoint getEnter() {
        return this.f9207j;
    }

    public LatLonPoint getExit() {
        return this.f9208k;
    }

    public IndoorData getIndoorData() {
        return this.f9217t;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f9204g;
    }

    public String getParkingType() {
        return this.f9220w;
    }

    public List<Photo> getPhotos() {
        return this.f9222y;
    }

    public PoiItemExtension getPoiExtension() {
        return this.f9223z;
    }

    public String getPoiId() {
        return this.f9198a;
    }

    public String getPostcode() {
        return this.f9210m;
    }

    public String getProvinceCode() {
        return this.f9218u;
    }

    public String getProvinceName() {
        return this.f9213p;
    }

    public String getShopID() {
        return this.B;
    }

    public String getSnippet() {
        return this.f9206i;
    }

    public List<SubPoiItem> getSubPois() {
        return this.f9221x;
    }

    public String getTel() {
        return this.f9199b;
    }

    public String getTitle() {
        return this.f9205h;
    }

    public String getTypeCode() {
        return this.A;
    }

    public String getTypeDes() {
        return this.f9202e;
    }

    public String getWebsite() {
        return this.f9209l;
    }

    public int hashCode() {
        String str = this.f9198a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public boolean isIndoorMap() {
        return this.f9216s;
    }

    public void setAdCode(String str) {
        this.f9200c = str;
    }

    public void setAdName(String str) {
        this.f9215r = str;
    }

    public void setBusinessArea(String str) {
        this.f9219v = str;
    }

    public void setCityCode(String str) {
        this.f9201d = str;
    }

    public void setCityName(String str) {
        this.f9214q = str;
    }

    public void setDirection(String str) {
        this.f9212o = str;
    }

    public void setDistance(int i6) {
        this.f9203f = i6;
    }

    public void setEmail(String str) {
        this.f9211n = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f9207j = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f9208k = latLonPoint;
    }

    public void setIndoorDate(IndoorData indoorData) {
        this.f9217t = indoorData;
    }

    public void setIndoorMap(boolean z5) {
        this.f9216s = z5;
    }

    public void setParkingType(String str) {
        this.f9220w = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f9222y = list;
    }

    public void setPoiExtension(PoiItemExtension poiItemExtension) {
        this.f9223z = poiItemExtension;
    }

    public void setPostcode(String str) {
        this.f9210m = str;
    }

    public void setProvinceCode(String str) {
        this.f9218u = str;
    }

    public void setProvinceName(String str) {
        this.f9213p = str;
    }

    public void setShopID(String str) {
        this.B = str;
    }

    public void setSubPois(List<SubPoiItem> list) {
        this.f9221x = list;
    }

    public void setTel(String str) {
        this.f9199b = str;
    }

    public void setTypeCode(String str) {
        this.A = str;
    }

    public void setTypeDes(String str) {
        this.f9202e = str;
    }

    public void setWebsite(String str) {
        this.f9209l = str;
    }

    public String toString() {
        return this.f9205h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9198a);
        parcel.writeString(this.f9200c);
        parcel.writeString(this.f9199b);
        parcel.writeString(this.f9202e);
        parcel.writeInt(this.f9203f);
        parcel.writeValue(this.f9204g);
        parcel.writeString(this.f9205h);
        parcel.writeString(this.f9206i);
        parcel.writeString(this.f9201d);
        parcel.writeValue(this.f9207j);
        parcel.writeValue(this.f9208k);
        parcel.writeString(this.f9209l);
        parcel.writeString(this.f9210m);
        parcel.writeString(this.f9211n);
        parcel.writeBooleanArray(new boolean[]{this.f9216s});
        parcel.writeString(this.f9212o);
        parcel.writeString(this.f9213p);
        parcel.writeString(this.f9214q);
        parcel.writeString(this.f9215r);
        parcel.writeString(this.f9218u);
        parcel.writeString(this.f9219v);
        parcel.writeString(this.f9220w);
        parcel.writeList(this.f9221x);
        parcel.writeValue(this.f9217t);
        parcel.writeTypedList(this.f9222y);
        parcel.writeParcelable(this.f9223z, i6);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }

    protected PoiItem(Parcel parcel) {
        this.f9202e = "";
        this.f9203f = -1;
        this.f9221x = new ArrayList();
        this.f9222y = new ArrayList();
        this.f9198a = parcel.readString();
        this.f9200c = parcel.readString();
        this.f9199b = parcel.readString();
        this.f9202e = parcel.readString();
        this.f9203f = parcel.readInt();
        this.f9204g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9205h = parcel.readString();
        this.f9206i = parcel.readString();
        this.f9201d = parcel.readString();
        this.f9207j = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9208k = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9209l = parcel.readString();
        this.f9210m = parcel.readString();
        this.f9211n = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f9216s = zArr[0];
        this.f9212o = parcel.readString();
        this.f9213p = parcel.readString();
        this.f9214q = parcel.readString();
        this.f9215r = parcel.readString();
        this.f9218u = parcel.readString();
        this.f9219v = parcel.readString();
        this.f9220w = parcel.readString();
        this.f9221x = parcel.readArrayList(SubPoiItem.class.getClassLoader());
        this.f9217t = (IndoorData) parcel.readValue(IndoorData.class.getClassLoader());
        this.f9222y = parcel.createTypedArrayList(Photo.CREATOR);
        this.f9223z = (PoiItemExtension) parcel.readParcelable(PoiItemExtension.class.getClassLoader());
        this.A = parcel.readString();
        this.B = parcel.readString();
    }
}
