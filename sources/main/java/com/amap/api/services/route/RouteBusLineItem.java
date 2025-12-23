package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new Parcelable.Creator<RouteBusLineItem>() { // from class: com.amap.api.services.route.RouteBusLineItem.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i6) {
            return null;
        }

        private static RouteBusLineItem a(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private BusStationItem f9622a;

    /* renamed from: b, reason: collision with root package name */
    private BusStationItem f9623b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f9624c;

    /* renamed from: d, reason: collision with root package name */
    private int f9625d;

    /* renamed from: e, reason: collision with root package name */
    private List<BusStationItem> f9626e;

    /* renamed from: f, reason: collision with root package name */
    private float f9627f;

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f9624c = new ArrayList();
        this.f9626e = new ArrayList();
        this.f9622a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f9623b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f9624c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9625d = parcel.readInt();
        this.f9626e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f9627f = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        BusStationItem busStationItem = this.f9623b;
        if (busStationItem == null) {
            if (routeBusLineItem.f9623b != null) {
                return false;
            }
        } else if (!busStationItem.equals(routeBusLineItem.f9623b)) {
            return false;
        }
        BusStationItem busStationItem2 = this.f9622a;
        if (busStationItem2 == null) {
            if (routeBusLineItem.f9622a != null) {
                return false;
            }
        } else if (!busStationItem2.equals(routeBusLineItem.f9622a)) {
            return false;
        }
        return true;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f9623b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f9622a;
    }

    public float getDuration() {
        return this.f9627f;
    }

    public int getPassStationNum() {
        return this.f9625d;
    }

    public List<BusStationItem> getPassStations() {
        return this.f9626e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9624c;
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f9623b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f9622a = busStationItem;
    }

    public void setDuration(float f6) {
        this.f9627f = f6;
    }

    public void setPassStationNum(int i6) {
        this.f9625d = i6;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f9626e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9624c = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int hashCode;
        int hashCode2 = super.hashCode() * 31;
        BusStationItem busStationItem = this.f9623b;
        int i6 = 0;
        if (busStationItem == null) {
            hashCode = 0;
        } else {
            hashCode = busStationItem.hashCode();
        }
        int i7 = (hashCode2 + hashCode) * 31;
        BusStationItem busStationItem2 = this.f9622a;
        if (busStationItem2 != null) {
            i6 = busStationItem2.hashCode();
        }
        return i7 + i6;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeParcelable(this.f9622a, i6);
        parcel.writeParcelable(this.f9623b, i6);
        parcel.writeTypedList(this.f9624c);
        parcel.writeInt(this.f9625d);
        parcel.writeTypedList(this.f9626e);
        parcel.writeFloat(this.f9627f);
    }

    public RouteBusLineItem() {
        this.f9624c = new ArrayList();
        this.f9626e = new ArrayList();
    }
}
