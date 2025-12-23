package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() { // from class: com.amap.api.maps.offlinemap.Province.1
        private static Province a(Parcel parcel) {
            return new Province(parcel);
        }

        private static Province[] a(int i6) {
            return new Province[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Province[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9069a;

    /* renamed from: b, reason: collision with root package name */
    private String f9070b;

    /* renamed from: c, reason: collision with root package name */
    private String f9071c;

    /* renamed from: d, reason: collision with root package name */
    private String f9072d;

    public Province() {
        this.f9069a = "";
        this.f9072d = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.f9070b;
    }

    public String getPinyin() {
        return this.f9071c;
    }

    public String getProvinceCode() {
        return this.f9072d;
    }

    public String getProvinceName() {
        return this.f9069a;
    }

    public void setJianpin(String str) {
        this.f9070b = str;
    }

    public void setPinyin(String str) {
        this.f9071c = str;
    }

    public void setProvinceCode(String str) {
        this.f9072d = str;
    }

    public void setProvinceName(String str) {
        this.f9069a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9069a);
        parcel.writeString(this.f9070b);
        parcel.writeString(this.f9071c);
        parcel.writeString(this.f9072d);
    }

    public Province(Parcel parcel) {
        this.f9069a = "";
        this.f9072d = "";
        this.f9069a = parcel.readString();
        this.f9070b = parcel.readString();
        this.f9071c = parcel.readString();
        this.f9072d = parcel.readString();
    }
}
