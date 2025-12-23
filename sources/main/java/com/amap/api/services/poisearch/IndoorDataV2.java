package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IndoorDataV2 implements Parcelable {
    public static final Parcelable.Creator<IndoorDataV2> CREATOR = new Parcelable.Creator<IndoorDataV2>() { // from class: com.amap.api.services.poisearch.IndoorDataV2.1
        private static IndoorDataV2 a(Parcel parcel) {
            return new IndoorDataV2(parcel);
        }

        private static IndoorDataV2[] a(int i6) {
            return new IndoorDataV2[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private boolean f9378a;

    /* renamed from: b, reason: collision with root package name */
    private String f9379b;

    /* renamed from: c, reason: collision with root package name */
    private int f9380c;

    /* renamed from: d, reason: collision with root package name */
    private String f9381d;

    public IndoorDataV2(boolean z5, String str, int i6, String str2) {
        this.f9378a = z5;
        this.f9379b = str;
        this.f9380c = i6;
        this.f9381d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f9380c;
    }

    public String getFloorName() {
        return this.f9381d;
    }

    public String getPoiId() {
        return this.f9379b;
    }

    public boolean isIndoorMap() {
        return this.f9378a;
    }

    public void setFloor(int i6) {
        this.f9380c = i6;
    }

    public void setFloorName(String str) {
        this.f9381d = str;
    }

    public void setIndoorMap(boolean z5) {
        this.f9378a = z5;
    }

    public void setPoiId(String str) {
        this.f9379b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeBooleanArray(new boolean[]{this.f9378a});
        parcel.writeString(this.f9379b);
        parcel.writeInt(this.f9380c);
        parcel.writeString(this.f9381d);
    }

    protected IndoorDataV2(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f9378a = zArr[0];
        this.f9379b = parcel.readString();
        this.f9380c = parcel.readInt();
        this.f9381d = parcel.readString();
    }
}
