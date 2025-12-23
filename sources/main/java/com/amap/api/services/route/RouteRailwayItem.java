package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteRailwayItem extends Railway implements Parcelable {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new Parcelable.Creator<RouteRailwayItem>() { // from class: com.amap.api.services.route.RouteRailwayItem.1
        private static RouteRailwayItem a(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        private static RouteRailwayItem[] a(int i6) {
            return new RouteRailwayItem[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9632a;

    /* renamed from: b, reason: collision with root package name */
    private String f9633b;

    /* renamed from: c, reason: collision with root package name */
    private float f9634c;

    /* renamed from: d, reason: collision with root package name */
    private String f9635d;

    /* renamed from: e, reason: collision with root package name */
    private RailwayStationItem f9636e;

    /* renamed from: f, reason: collision with root package name */
    private RailwayStationItem f9637f;

    /* renamed from: g, reason: collision with root package name */
    private List<RailwayStationItem> f9638g;

    /* renamed from: h, reason: collision with root package name */
    private List<Railway> f9639h;

    /* renamed from: i, reason: collision with root package name */
    private List<RailwaySpace> f9640i;

    public RouteRailwayItem() {
        this.f9638g = new ArrayList();
        this.f9639h = new ArrayList();
        this.f9640i = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Railway> getAlters() {
        return this.f9639h;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f9637f;
    }

    public RailwayStationItem getDeparturestop() {
        return this.f9636e;
    }

    public float getDistance() {
        return this.f9634c;
    }

    public List<RailwaySpace> getSpaces() {
        return this.f9640i;
    }

    public String getTime() {
        return this.f9632a;
    }

    public String getTrip() {
        return this.f9633b;
    }

    public String getType() {
        return this.f9635d;
    }

    public List<RailwayStationItem> getViastops() {
        return this.f9638g;
    }

    public void setAlters(List<Railway> list) {
        this.f9639h = list;
    }

    public void setArrivalstop(RailwayStationItem railwayStationItem) {
        this.f9637f = railwayStationItem;
    }

    public void setDeparturestop(RailwayStationItem railwayStationItem) {
        this.f9636e = railwayStationItem;
    }

    public void setDistance(float f6) {
        this.f9634c = f6;
    }

    public void setSpaces(List<RailwaySpace> list) {
        this.f9640i = list;
    }

    public void setTime(String str) {
        this.f9632a = str;
    }

    public void setTrip(String str) {
        this.f9633b = str;
    }

    public void setType(String str) {
        this.f9635d = str;
    }

    public void setViastops(List<RailwayStationItem> list) {
        this.f9638g = list;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeString(this.f9632a);
        parcel.writeString(this.f9633b);
        parcel.writeFloat(this.f9634c);
        parcel.writeString(this.f9635d);
        parcel.writeParcelable(this.f9636e, i6);
        parcel.writeParcelable(this.f9637f, i6);
        parcel.writeTypedList(this.f9638g);
        parcel.writeTypedList(this.f9639h);
        parcel.writeTypedList(this.f9640i);
    }

    protected RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.f9638g = new ArrayList();
        this.f9639h = new ArrayList();
        this.f9640i = new ArrayList();
        this.f9632a = parcel.readString();
        this.f9633b = parcel.readString();
        this.f9634c = parcel.readFloat();
        this.f9635d = parcel.readString();
        this.f9636e = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f9637f = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f9638g = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f9639h = parcel.createTypedArrayList(Railway.CREATOR);
        this.f9640i = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
