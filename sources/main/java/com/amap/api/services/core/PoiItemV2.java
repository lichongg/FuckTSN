package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItemV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItemV2.1
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

    /* renamed from: a, reason: collision with root package name */
    private String f9224a;

    /* renamed from: b, reason: collision with root package name */
    private String f9225b;

    /* renamed from: c, reason: collision with root package name */
    private String f9226c;

    /* renamed from: d, reason: collision with root package name */
    private String f9227d;

    /* renamed from: e, reason: collision with root package name */
    private final LatLonPoint f9228e;

    /* renamed from: f, reason: collision with root package name */
    private final String f9229f;

    /* renamed from: g, reason: collision with root package name */
    private final String f9230g;

    /* renamed from: h, reason: collision with root package name */
    private String f9231h;

    /* renamed from: i, reason: collision with root package name */
    private String f9232i;

    /* renamed from: j, reason: collision with root package name */
    private String f9233j;

    /* renamed from: k, reason: collision with root package name */
    private String f9234k;

    /* renamed from: l, reason: collision with root package name */
    private String f9235l;

    /* renamed from: m, reason: collision with root package name */
    private List<SubPoiItemV2> f9236m;

    /* renamed from: n, reason: collision with root package name */
    private Business f9237n;

    /* renamed from: o, reason: collision with root package name */
    private IndoorDataV2 f9238o;

    /* renamed from: p, reason: collision with root package name */
    private PoiNavi f9239p;

    /* renamed from: q, reason: collision with root package name */
    private List<Photo> f9240q;

    public PoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f9227d = "";
        this.f9236m = new ArrayList();
        this.f9240q = new ArrayList();
        this.f9224a = str;
        this.f9228e = latLonPoint;
        this.f9229f = str2;
        this.f9230g = str3;
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
        PoiItemV2 poiItemV2 = (PoiItemV2) obj;
        String str = this.f9224a;
        if (str == null) {
            if (poiItemV2.f9224a != null) {
                return false;
            }
        } else if (!str.equals(poiItemV2.f9224a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f9225b;
    }

    public String getAdName() {
        return this.f9234k;
    }

    public Business getBusiness() {
        return this.f9237n;
    }

    public String getCityCode() {
        return this.f9226c;
    }

    public String getCityName() {
        return this.f9233j;
    }

    public IndoorDataV2 getIndoorData() {
        return this.f9238o;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f9228e;
    }

    public List<Photo> getPhotos() {
        return this.f9240q;
    }

    public String getPoiId() {
        return this.f9224a;
    }

    public PoiNavi getPoiNavi() {
        return this.f9239p;
    }

    public String getProvinceCode() {
        return this.f9235l;
    }

    public String getProvinceName() {
        return this.f9232i;
    }

    public String getSnippet() {
        return this.f9230g;
    }

    public List<SubPoiItemV2> getSubPois() {
        return this.f9236m;
    }

    public String getTitle() {
        return this.f9229f;
    }

    public String getTypeCode() {
        return this.f9231h;
    }

    public String getTypeDes() {
        return this.f9227d;
    }

    public int hashCode() {
        String str = this.f9224a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f9225b = str;
    }

    public void setAdName(String str) {
        this.f9234k = str;
    }

    public void setBusiness(Business business) {
        this.f9237n = business;
    }

    public void setCityCode(String str) {
        this.f9226c = str;
    }

    public void setCityName(String str) {
        this.f9233j = str;
    }

    public void setIndoorData(IndoorDataV2 indoorDataV2) {
        this.f9238o = indoorDataV2;
    }

    public void setPhotos(List<Photo> list) {
        this.f9240q = list;
    }

    public void setPoiNavi(PoiNavi poiNavi) {
        this.f9239p = poiNavi;
    }

    public void setProvinceCode(String str) {
        this.f9235l = str;
    }

    public void setProvinceName(String str) {
        this.f9232i = str;
    }

    public void setSubPois(List<SubPoiItemV2> list) {
        this.f9236m = list;
    }

    public void setTypeCode(String str) {
        this.f9231h = str;
    }

    public void setTypeDes(String str) {
        this.f9227d = str;
    }

    public String toString() {
        return this.f9229f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9224a);
        parcel.writeString(this.f9225b);
        parcel.writeString(this.f9227d);
        parcel.writeValue(this.f9228e);
        parcel.writeString(this.f9229f);
        parcel.writeString(this.f9230g);
        parcel.writeString(this.f9226c);
        parcel.writeString(this.f9232i);
        parcel.writeString(this.f9233j);
        parcel.writeString(this.f9234k);
        parcel.writeString(this.f9235l);
        parcel.writeString(this.f9231h);
        parcel.writeList(this.f9236m);
        parcel.writeValue(this.f9237n);
        parcel.writeValue(this.f9238o);
        parcel.writeValue(this.f9239p);
        parcel.writeTypedList(this.f9240q);
    }

    protected PoiItemV2(Parcel parcel) {
        this.f9227d = "";
        this.f9236m = new ArrayList();
        this.f9240q = new ArrayList();
        this.f9224a = parcel.readString();
        this.f9225b = parcel.readString();
        this.f9227d = parcel.readString();
        this.f9228e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9229f = parcel.readString();
        this.f9230g = parcel.readString();
        this.f9226c = parcel.readString();
        this.f9232i = parcel.readString();
        this.f9233j = parcel.readString();
        this.f9234k = parcel.readString();
        this.f9235l = parcel.readString();
        this.f9231h = parcel.readString();
        this.f9236m = parcel.readArrayList(SubPoiItemV2.class.getClassLoader());
        this.f9237n = (Business) parcel.readValue(Business.class.getClassLoader());
        this.f9238o = (IndoorDataV2) parcel.readValue(IndoorDataV2.class.getClassLoader());
        this.f9239p = (PoiNavi) parcel.readValue(PoiNavi.class.getClassLoader());
        this.f9240q = parcel.createTypedArrayList(Photo.CREATOR);
    }
}
