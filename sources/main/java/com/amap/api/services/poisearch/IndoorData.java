package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() { // from class: com.amap.api.services.poisearch.IndoorData.1
        private static IndoorData a(Parcel parcel) {
            return new IndoorData(parcel);
        }

        private static IndoorData[] a(int i6) {
            return new IndoorData[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9375a;

    /* renamed from: b, reason: collision with root package name */
    private int f9376b;

    /* renamed from: c, reason: collision with root package name */
    private String f9377c;

    public IndoorData(String str, int i6, String str2) {
        this.f9375a = str;
        this.f9376b = i6;
        this.f9377c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f9376b;
    }

    public String getFloorName() {
        return this.f9377c;
    }

    public String getPoiId() {
        return this.f9375a;
    }

    public void setFloor(int i6) {
        this.f9376b = i6;
    }

    public void setFloorName(String str) {
        this.f9377c = str;
    }

    public void setPoiId(String str) {
        this.f9375a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9375a);
        parcel.writeInt(this.f9376b);
        parcel.writeString(this.f9377c);
    }

    protected IndoorData(Parcel parcel) {
        this.f9375a = parcel.readString();
        this.f9376b = parcel.readInt();
        this.f9377c = parcel.readString();
    }
}
