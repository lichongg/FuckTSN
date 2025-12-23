package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() { // from class: com.amap.api.maps.offlinemap.City.1
        private static City a(Parcel parcel) {
            return new City(parcel);
        }

        private static City[] a(int i6) {
            return new City[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ City[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9019a;

    /* renamed from: b, reason: collision with root package name */
    private String f9020b;

    /* renamed from: c, reason: collision with root package name */
    private String f9021c;

    /* renamed from: d, reason: collision with root package name */
    private String f9022d;

    /* renamed from: e, reason: collision with root package name */
    private String f9023e;

    public City() {
        this.f9019a = "";
        this.f9020b = "";
        this.f9023e = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f9023e;
    }

    public String getCity() {
        return this.f9019a;
    }

    public String getCode() {
        return this.f9020b;
    }

    public String getJianpin() {
        return this.f9021c;
    }

    public String getPinyin() {
        return this.f9022d;
    }

    public void setAdcode(String str) {
        this.f9023e = str;
    }

    public void setCity(String str) {
        this.f9019a = str;
    }

    public void setCode(String str) {
        if (str == null || "[]".equals(str)) {
            return;
        }
        this.f9020b = str;
    }

    public void setJianpin(String str) {
        this.f9021c = str;
    }

    public void setPinyin(String str) {
        this.f9022d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9019a);
        parcel.writeString(this.f9020b);
        parcel.writeString(this.f9021c);
        parcel.writeString(this.f9022d);
        parcel.writeString(this.f9023e);
    }

    public City(Parcel parcel) {
        this.f9019a = "";
        this.f9020b = "";
        this.f9023e = "";
        this.f9019a = parcel.readString();
        this.f9020b = parcel.readString();
        this.f9021c = parcel.readString();
        this.f9022d = parcel.readString();
        this.f9023e = parcel.readString();
    }
}
