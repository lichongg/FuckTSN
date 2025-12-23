package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new Parcelable.Creator<BusStep>() { // from class: com.amap.api.services.route.BusStep.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStep[] newArray(int i6) {
            return null;
        }

        private static BusStep a(Parcel parcel) {
            return new BusStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f9488a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f9489b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f9490c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f9491d;

    /* renamed from: e, reason: collision with root package name */
    private RouteRailwayItem f9492e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItem f9493f;

    public BusStep(Parcel parcel) {
        this.f9489b = new ArrayList();
        this.f9488a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f9489b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f9490c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f9491d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f9492e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f9493f = (TaxiItem) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f9489b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f9489b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f9489b;
    }

    public Doorway getEntrance() {
        return this.f9490c;
    }

    public Doorway getExit() {
        return this.f9491d;
    }

    public RouteRailwayItem getRailway() {
        return this.f9492e;
    }

    public TaxiItem getTaxi() {
        return this.f9493f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f9488a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f9489b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f9489b.add(routeBusLineItem);
        }
        this.f9489b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f9489b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f9490c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f9491d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f9492e = routeRailwayItem;
    }

    public void setTaxi(TaxiItem taxiItem) {
        this.f9493f = taxiItem;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f9488a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9488a, i6);
        parcel.writeTypedList(this.f9489b);
        parcel.writeParcelable(this.f9490c, i6);
        parcel.writeParcelable(this.f9491d, i6);
        parcel.writeParcelable(this.f9492e, i6);
        parcel.writeParcelable(this.f9493f, i6);
    }

    public BusStep() {
        this.f9489b = new ArrayList();
    }
}
