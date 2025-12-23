package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() { // from class: com.amap.api.services.busline.BusStationItem.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStationItem[] newArray(int i6) {
            return null;
        }

        private static BusStationItem a(Parcel parcel) {
            return new BusStationItem(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9141a;

    /* renamed from: b, reason: collision with root package name */
    private String f9142b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9143c;

    /* renamed from: d, reason: collision with root package name */
    private String f9144d;

    /* renamed from: e, reason: collision with root package name */
    private String f9145e;

    /* renamed from: f, reason: collision with root package name */
    private List<BusLineItem> f9146f;

    /* synthetic */ BusStationItem(Parcel parcel, byte b6) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusStationItem busStationItem = (BusStationItem) obj;
        String str = this.f9141a;
        if (str == null) {
            if (busStationItem.f9141a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.f9141a)) {
            return false;
        }
        return true;
    }

    public BusStationItem() {
        this.f9146f = new ArrayList();
    }

    private static String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i6 = 0; i6 < list.size(); i6++) {
                stringBuffer.append(list.get(i6).getBusLineName());
                if (i6 < list.size() - 1) {
                    stringBuffer.append(Logger.f33116c);
                }
            }
        }
        return stringBuffer.toString();
    }

    public String getAdCode() {
        return this.f9145e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f9146f;
    }

    public String getBusStationId() {
        return this.f9141a;
    }

    public String getBusStationName() {
        return this.f9142b;
    }

    public String getCityCode() {
        return this.f9144d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f9143c;
    }

    public int hashCode() {
        String str = this.f9141a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f9145e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f9146f = list;
    }

    public void setBusStationId(String str) {
        this.f9141a = str;
    }

    public void setBusStationName(String str) {
        this.f9142b = str;
    }

    public void setCityCode(String str) {
        this.f9144d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f9143c = latLonPoint;
    }

    public String toString() {
        return "BusStationName: " + this.f9142b + " LatLonPoint: " + this.f9143c.toString() + " BusLines: " + a(this.f9146f) + " CityCode: " + this.f9144d + " AdCode: " + this.f9145e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9142b);
        parcel.writeString(this.f9141a);
        parcel.writeValue(this.f9143c);
        parcel.writeString(this.f9144d);
        parcel.writeString(this.f9145e);
        parcel.writeList(this.f9146f);
    }

    private BusStationItem(Parcel parcel) {
        this.f9146f = new ArrayList();
        this.f9142b = parcel.readString();
        this.f9141a = parcel.readString();
        this.f9143c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f9144d = parcel.readString();
        this.f9145e = parcel.readString();
        this.f9146f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
