package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new Parcelable.Creator<District>() { // from class: com.amap.api.services.route.District.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ District[] newArray(int i6) {
            return null;
        }

        private static District a(Parcel parcel) {
            return new District(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ District createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9531a;

    /* renamed from: b, reason: collision with root package name */
    private String f9532b;

    public District(Parcel parcel) {
        this.f9531a = parcel.readString();
        this.f9532b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.f9532b;
    }

    public String getDistrictName() {
        return this.f9531a;
    }

    public void setDistrictAdcode(String str) {
        this.f9532b = str;
    }

    public void setDistrictName(String str) {
        this.f9531a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9531a);
        parcel.writeString(this.f9532b);
    }

    public District() {
    }
}
