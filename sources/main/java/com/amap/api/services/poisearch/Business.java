package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Business implements Parcelable {
    public static final Parcelable.Creator<Business> CREATOR = new Parcelable.Creator<Business>() { // from class: com.amap.api.services.poisearch.Business.1
        private static Business a(Parcel parcel) {
            return new Business(parcel);
        }

        private static Business[] a(int i6) {
            return new Business[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9365a;

    /* renamed from: b, reason: collision with root package name */
    private String f9366b;

    /* renamed from: c, reason: collision with root package name */
    private String f9367c;

    /* renamed from: d, reason: collision with root package name */
    private String f9368d;

    /* renamed from: e, reason: collision with root package name */
    private String f9369e;

    /* renamed from: f, reason: collision with root package name */
    private String f9370f;

    /* renamed from: g, reason: collision with root package name */
    private String f9371g;

    /* renamed from: h, reason: collision with root package name */
    private String f9372h;

    /* renamed from: i, reason: collision with root package name */
    private String f9373i;

    /* renamed from: j, reason: collision with root package name */
    private String f9374j;

    public Business(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f9365a = str;
        this.f9366b = str2;
        this.f9367c = str3;
        this.f9368d = str4;
        this.f9369e = str5;
        this.f9370f = str6;
        this.f9371g = str7;
        this.f9372h = str8;
        this.f9373i = str9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.f9373i;
    }

    public String getBusinessArea() {
        return this.f9365a;
    }

    public String getCPID() {
        return this.f9374j;
    }

    public String getCost() {
        return this.f9371g;
    }

    public String getOpentimeToday() {
        return this.f9366b;
    }

    public String getOpentimeWeek() {
        return this.f9367c;
    }

    public String getParkingType() {
        return this.f9372h;
    }

    public String getTag() {
        return this.f9369e;
    }

    public String getTel() {
        return this.f9368d;
    }

    public String getmRating() {
        return this.f9370f;
    }

    public void setCPID(String str) {
        this.f9374j = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9365a);
        parcel.writeString(this.f9366b);
        parcel.writeString(this.f9367c);
        parcel.writeString(this.f9368d);
        parcel.writeString(this.f9369e);
        parcel.writeString(this.f9370f);
        parcel.writeString(this.f9371g);
        parcel.writeString(this.f9372h);
        parcel.writeString(this.f9373i);
        parcel.writeString(this.f9374j);
    }

    protected Business(Parcel parcel) {
        this.f9365a = parcel.readString();
        this.f9366b = parcel.readString();
        this.f9367c = parcel.readString();
        this.f9368d = parcel.readString();
        this.f9369e = parcel.readString();
        this.f9370f = parcel.readString();
        this.f9371g = parcel.readString();
        this.f9372h = parcel.readString();
        this.f9373i = parcel.readString();
        this.f9374j = parcel.readString();
    }
}
