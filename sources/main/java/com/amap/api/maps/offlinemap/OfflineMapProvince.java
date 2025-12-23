package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator<OfflineMapProvince>() { // from class: com.amap.api.maps.offlinemap.OfflineMapProvince.1
        private static OfflineMapProvince a(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        private static OfflineMapProvince[] a(int i6) {
            return new OfflineMapProvince[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineMapProvince[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9063a;

    /* renamed from: b, reason: collision with root package name */
    private int f9064b;

    /* renamed from: c, reason: collision with root package name */
    private long f9065c;

    /* renamed from: d, reason: collision with root package name */
    private String f9066d;

    /* renamed from: e, reason: collision with root package name */
    private int f9067e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<OfflineMapCity> f9068f;

    public OfflineMapProvince() {
        this.f9064b = 6;
        this.f9067e = 0;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        ArrayList<OfflineMapCity> arrayList = this.f9068f;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public ArrayList<OfflineMapCity> getDownloadedCityList() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = this.f9068f;
        if (arrayList2 != null) {
            Iterator<OfflineMapCity> it = arrayList2.iterator();
            while (it.hasNext()) {
                OfflineMapCity next = it.next();
                if (next.getState() != 6) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public long getSize() {
        return this.f9065c;
    }

    public int getState() {
        return this.f9064b;
    }

    public String getUrl() {
        return this.f9063a;
    }

    public String getVersion() {
        return this.f9066d;
    }

    public int getcompleteCode() {
        return this.f9067e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f9068f = arrayList;
    }

    public void setCompleteCode(int i6) {
        this.f9067e = i6;
    }

    public void setSize(long j6) {
        this.f9065c = j6;
    }

    public void setState(int i6) {
        this.f9064b = i6;
    }

    public void setUrl(String str) {
        this.f9063a = str;
    }

    public void setVersion(String str) {
        this.f9066d = str;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeString(this.f9063a);
        parcel.writeInt(this.f9064b);
        parcel.writeLong(this.f9065c);
        parcel.writeString(this.f9066d);
        parcel.writeInt(this.f9067e);
        parcel.writeTypedList(this.f9068f);
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f9064b = 6;
        this.f9067e = 0;
        this.f9063a = parcel.readString();
        this.f9064b = parcel.readInt();
        this.f9065c = parcel.readLong();
        this.f9066d = parcel.readString();
        this.f9067e = parcel.readInt();
        this.f9068f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
