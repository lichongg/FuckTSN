package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.fence.PoiItem.1
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
    private String f8809a;

    /* renamed from: b, reason: collision with root package name */
    private String f8810b;

    /* renamed from: c, reason: collision with root package name */
    private String f8811c;

    /* renamed from: d, reason: collision with root package name */
    private String f8812d;

    /* renamed from: e, reason: collision with root package name */
    private String f8813e;

    /* renamed from: f, reason: collision with root package name */
    private double f8814f;

    /* renamed from: g, reason: collision with root package name */
    private double f8815g;

    /* renamed from: h, reason: collision with root package name */
    private String f8816h;

    /* renamed from: i, reason: collision with root package name */
    private String f8817i;

    /* renamed from: j, reason: collision with root package name */
    private String f8818j;

    /* renamed from: k, reason: collision with root package name */
    private String f8819k;

    public PoiItem() {
        this.f8809a = "";
        this.f8810b = "";
        this.f8811c = "";
        this.f8812d = "";
        this.f8813e = "";
        this.f8814f = 0.0d;
        this.f8815g = 0.0d;
        this.f8816h = "";
        this.f8817i = "";
        this.f8818j = "";
        this.f8819k = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Parcelable.Creator<PoiItem> getCreator() {
        return CREATOR;
    }

    public String getAddress() {
        return this.f8813e;
    }

    public String getAdname() {
        return this.f8819k;
    }

    public String getCity() {
        return this.f8818j;
    }

    public double getLatitude() {
        return this.f8814f;
    }

    public double getLongitude() {
        return this.f8815g;
    }

    public String getPoiId() {
        return this.f8810b;
    }

    public String getPoiName() {
        return this.f8809a;
    }

    public String getPoiType() {
        return this.f8811c;
    }

    public String getProvince() {
        return this.f8817i;
    }

    public String getTel() {
        return this.f8816h;
    }

    public String getTypeCode() {
        return this.f8812d;
    }

    public void setAddress(String str) {
        this.f8813e = str;
    }

    public void setAdname(String str) {
        this.f8819k = str;
    }

    public void setCity(String str) {
        this.f8818j = str;
    }

    public void setLatitude(double d6) {
        this.f8814f = d6;
    }

    public void setLongitude(double d6) {
        this.f8815g = d6;
    }

    public void setPoiId(String str) {
        this.f8810b = str;
    }

    public void setPoiName(String str) {
        this.f8809a = str;
    }

    public void setPoiType(String str) {
        this.f8811c = str;
    }

    public void setProvince(String str) {
        this.f8817i = str;
    }

    public void setTel(String str) {
        this.f8816h = str;
    }

    public void setTypeCode(String str) {
        this.f8812d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f8809a);
        parcel.writeString(this.f8810b);
        parcel.writeString(this.f8811c);
        parcel.writeString(this.f8812d);
        parcel.writeString(this.f8813e);
        parcel.writeDouble(this.f8814f);
        parcel.writeDouble(this.f8815g);
        parcel.writeString(this.f8816h);
        parcel.writeString(this.f8817i);
        parcel.writeString(this.f8818j);
        parcel.writeString(this.f8819k);
    }

    protected PoiItem(Parcel parcel) {
        this.f8809a = "";
        this.f8810b = "";
        this.f8811c = "";
        this.f8812d = "";
        this.f8813e = "";
        this.f8814f = 0.0d;
        this.f8815g = 0.0d;
        this.f8816h = "";
        this.f8817i = "";
        this.f8818j = "";
        this.f8819k = "";
        this.f8809a = parcel.readString();
        this.f8810b = parcel.readString();
        this.f8811c = parcel.readString();
        this.f8812d = parcel.readString();
        this.f8813e = parcel.readString();
        this.f8814f = parcel.readDouble();
        this.f8815g = parcel.readDouble();
        this.f8816h = parcel.readString();
        this.f8817i = parcel.readString();
        this.f8818j = parcel.readString();
        this.f8819k = parcel.readString();
    }
}
