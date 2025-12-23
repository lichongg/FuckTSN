package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new Parcelable.Creator<Tip>() { // from class: com.amap.api.services.help.Tip.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Tip[] newArray(int i6) {
            return null;
        }

        private static Tip a(Parcel parcel) {
            return new Tip(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Tip createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9338a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9339b;

    /* renamed from: c, reason: collision with root package name */
    private String f9340c;

    /* renamed from: d, reason: collision with root package name */
    private String f9341d;

    /* renamed from: e, reason: collision with root package name */
    private String f9342e;

    /* renamed from: f, reason: collision with root package name */
    private String f9343f;

    /* renamed from: g, reason: collision with root package name */
    private String f9344g;

    /* renamed from: h, reason: collision with root package name */
    private String f9345h;

    /* synthetic */ Tip(Parcel parcel, byte b6) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Tip() {
        this.f9345h = "";
    }

    public String getAdcode() {
        return this.f9342e;
    }

    public String getAddress() {
        return this.f9343f;
    }

    public String getDistrict() {
        return this.f9341d;
    }

    public String getName() {
        return this.f9340c;
    }

    public String getPoiID() {
        return this.f9338a;
    }

    public LatLonPoint getPoint() {
        return this.f9339b;
    }

    public String getTypeCode() {
        return this.f9344g;
    }

    public void setAdcode(String str) {
        this.f9342e = str;
    }

    public void setAddress(String str) {
        this.f9343f = str;
    }

    public void setDistrict(String str) {
        this.f9341d = str;
    }

    public void setID(String str) {
        this.f9338a = str;
    }

    public void setName(String str) {
        this.f9340c = str;
    }

    public void setPostion(LatLonPoint latLonPoint) {
        this.f9339b = latLonPoint;
    }

    public void setTypeCode(String str) {
        this.f9344g = str;
    }

    public String toString() {
        return "name:" + this.f9340c + " district:" + this.f9341d + " adcode:" + this.f9342e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9340c);
        parcel.writeString(this.f9342e);
        parcel.writeString(this.f9341d);
        parcel.writeString(this.f9338a);
        parcel.writeValue(this.f9339b);
        parcel.writeString(this.f9343f);
        parcel.writeString(this.f9344g);
        parcel.writeString(this.f9345h);
    }

    private Tip(Parcel parcel) {
        this.f9345h = "";
        this.f9340c = parcel.readString();
        this.f9342e = parcel.readString();
        this.f9341d = parcel.readString();
        this.f9338a = parcel.readString();
        this.f9339b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9343f = parcel.readString();
        this.f9344g = parcel.readString();
        this.f9345h = parcel.readString();
    }
}
