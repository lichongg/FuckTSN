package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new Parcelable.Creator<BusLineItem>() { // from class: com.amap.api.services.busline.BusLineItem.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusLineItem[] newArray(int i6) {
            return null;
        }

        private static BusLineItem a(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9113a;

    /* renamed from: b, reason: collision with root package name */
    private String f9114b;

    /* renamed from: c, reason: collision with root package name */
    private String f9115c;

    /* renamed from: d, reason: collision with root package name */
    private String f9116d;

    /* renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f9117e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f9118f;

    /* renamed from: g, reason: collision with root package name */
    private String f9119g;

    /* renamed from: h, reason: collision with root package name */
    private String f9120h;

    /* renamed from: i, reason: collision with root package name */
    private String f9121i;

    /* renamed from: j, reason: collision with root package name */
    private Date f9122j;

    /* renamed from: k, reason: collision with root package name */
    private Date f9123k;

    /* renamed from: l, reason: collision with root package name */
    private String f9124l;

    /* renamed from: m, reason: collision with root package name */
    private float f9125m;

    /* renamed from: n, reason: collision with root package name */
    private float f9126n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusStationItem> f9127o;

    public BusLineItem() {
        this.f9117e = new ArrayList();
        this.f9118f = new ArrayList();
        this.f9127o = new ArrayList();
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
        BusLineItem busLineItem = (BusLineItem) obj;
        String str = this.f9119g;
        if (str == null) {
            if (busLineItem.f9119g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.f9119g)) {
            return false;
        }
        return true;
    }

    public float getBasicPrice() {
        return this.f9125m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f9118f;
    }

    public String getBusCompany() {
        return this.f9124l;
    }

    public String getBusLineId() {
        return this.f9119g;
    }

    public String getBusLineName() {
        return this.f9114b;
    }

    public String getBusLineType() {
        return this.f9115c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f9127o;
    }

    public String getCityCode() {
        return this.f9116d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f9117e;
    }

    public float getDistance() {
        return this.f9113a;
    }

    public Date getFirstBusTime() {
        Date date = this.f9122j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getLastBusTime() {
        Date date = this.f9123k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getOriginatingStation() {
        return this.f9120h;
    }

    public String getTerminalStation() {
        return this.f9121i;
    }

    public float getTotalPrice() {
        return this.f9126n;
    }

    public int hashCode() {
        String str = this.f9119g;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setBasicPrice(float f6) {
        this.f9125m = f6;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f9118f = list;
    }

    public void setBusCompany(String str) {
        this.f9124l = str;
    }

    public void setBusLineId(String str) {
        this.f9119g = str;
    }

    public void setBusLineName(String str) {
        this.f9114b = str;
    }

    public void setBusLineType(String str) {
        this.f9115c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f9127o = list;
    }

    public void setCityCode(String str) {
        this.f9116d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f9117e = list;
    }

    public void setDistance(float f6) {
        this.f9113a = f6;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f9122j = null;
        } else {
            this.f9122j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f9123k = null;
        } else {
            this.f9123k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.f9120h = str;
    }

    public void setTerminalStation(String str) {
        this.f9121i = str;
    }

    public void setTotalPrice(float f6) {
        this.f9126n = f6;
    }

    public String toString() {
        return this.f9114b + " " + j4.e(this.f9122j) + "-" + j4.e(this.f9123k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f9113a);
        parcel.writeString(this.f9114b);
        parcel.writeString(this.f9115c);
        parcel.writeString(this.f9116d);
        parcel.writeList(this.f9117e);
        parcel.writeList(this.f9118f);
        parcel.writeString(this.f9119g);
        parcel.writeString(this.f9120h);
        parcel.writeString(this.f9121i);
        parcel.writeString(j4.e(this.f9122j));
        parcel.writeString(j4.e(this.f9123k));
        parcel.writeString(this.f9124l);
        parcel.writeFloat(this.f9125m);
        parcel.writeFloat(this.f9126n);
        parcel.writeList(this.f9127o);
    }

    public BusLineItem(Parcel parcel) {
        this.f9117e = new ArrayList();
        this.f9118f = new ArrayList();
        this.f9127o = new ArrayList();
        this.f9113a = parcel.readFloat();
        this.f9114b = parcel.readString();
        this.f9115c = parcel.readString();
        this.f9116d = parcel.readString();
        this.f9117e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f9118f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f9119g = parcel.readString();
        this.f9120h = parcel.readString();
        this.f9121i = parcel.readString();
        this.f9122j = j4.o(parcel.readString());
        this.f9123k = j4.o(parcel.readString());
        this.f9124l = parcel.readString();
        this.f9125m = parcel.readFloat();
        this.f9126n = parcel.readFloat();
        this.f9127o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
