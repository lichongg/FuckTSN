package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusStepV2 implements Parcelable {
    public static final Parcelable.Creator<BusStepV2> CREATOR = new Parcelable.Creator<BusStepV2>() { // from class: com.amap.api.services.route.BusStepV2.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStepV2[] newArray(int i6) {
            return null;
        }

        private static BusStepV2 a(Parcel parcel) {
            return new BusStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStepV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f9494a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f9495b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f9496c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f9497d;

    /* renamed from: e, reason: collision with root package name */
    private RouteRailwayItem f9498e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItemV2 f9499f;

    public BusStepV2(Parcel parcel) {
        this.f9495b = new ArrayList();
        this.f9494a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f9495b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f9496c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f9497d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f9498e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f9499f = (TaxiItemV2) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f9495b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f9495b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f9495b;
    }

    public Doorway getEntrance() {
        return this.f9496c;
    }

    public Doorway getExit() {
        return this.f9497d;
    }

    public RouteRailwayItem getRailway() {
        return this.f9498e;
    }

    public TaxiItemV2 getTaxi() {
        return this.f9499f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f9494a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f9495b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f9495b.add(routeBusLineItem);
        }
        this.f9495b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f9495b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f9496c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f9497d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f9498e = routeRailwayItem;
    }

    public void setTaxi(TaxiItemV2 taxiItemV2) {
        this.f9499f = taxiItemV2;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f9494a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9494a, i6);
        parcel.writeTypedList(this.f9495b);
        parcel.writeParcelable(this.f9496c, i6);
        parcel.writeParcelable(this.f9497d, i6);
        parcel.writeParcelable(this.f9498e, i6);
        parcel.writeParcelable(this.f9499f, i6);
    }

    public BusStepV2() {
        this.f9495b = new ArrayList();
    }
}
