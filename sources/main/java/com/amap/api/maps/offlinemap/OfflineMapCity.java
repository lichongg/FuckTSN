package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator<OfflineMapCity>() { // from class: com.amap.api.maps.offlinemap.OfflineMapCity.1
        private static OfflineMapCity a(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        private static OfflineMapCity[] a(int i6) {
            return new OfflineMapCity[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapCity[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9039a;

    /* renamed from: b, reason: collision with root package name */
    private long f9040b;

    /* renamed from: c, reason: collision with root package name */
    private int f9041c;

    /* renamed from: d, reason: collision with root package name */
    private String f9042d;

    /* renamed from: e, reason: collision with root package name */
    private int f9043e;

    public OfflineMapCity() {
        this.f9039a = "";
        this.f9040b = 0L;
        this.f9041c = 6;
        this.f9042d = "";
        this.f9043e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.f9040b;
    }

    public int getState() {
        return this.f9041c;
    }

    public String getUrl() {
        return this.f9039a;
    }

    public String getVersion() {
        return this.f9042d;
    }

    public int getcompleteCode() {
        return this.f9043e;
    }

    public void setCompleteCode(int i6) {
        this.f9043e = i6;
    }

    public void setSize(long j6) {
        this.f9040b = j6;
    }

    public void setState(int i6) {
        this.f9041c = i6;
    }

    public void setUrl(String str) {
        this.f9039a = str;
    }

    public void setVersion(String str) {
        this.f9042d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeString(this.f9039a);
        parcel.writeLong(this.f9040b);
        parcel.writeInt(this.f9041c);
        parcel.writeString(this.f9042d);
        parcel.writeInt(this.f9043e);
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f9039a = "";
        this.f9040b = 0L;
        this.f9041c = 6;
        this.f9042d = "";
        this.f9043e = 0;
        this.f9039a = parcel.readString();
        this.f9040b = parcel.readLong();
        this.f9041c = parcel.readInt();
        this.f9042d = parcel.readString();
        this.f9043e = parcel.readInt();
    }
}
