package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResultV2> CREATOR = new Parcelable.Creator<BusRouteResultV2>() { // from class: com.amap.api.services.route.BusRouteResultV2.1
        private static BusRouteResultV2 a(Parcel parcel) {
            return new BusRouteResultV2(parcel);
        }

        private static BusRouteResultV2[] a(int i6) {
            return new BusRouteResultV2[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9484a;

    /* renamed from: b, reason: collision with root package name */
    private List<BusPathV2> f9485b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearchV2.BusRouteQuery f9486c;

    /* renamed from: d, reason: collision with root package name */
    private float f9487d;

    public BusRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f9485b = new ArrayList();
        this.f9484a = parcel.readFloat();
        this.f9485b = parcel.createTypedArrayList(BusPathV2.CREATOR);
        this.f9486c = (RouteSearchV2.BusRouteQuery) parcel.readParcelable(RouteSearchV2.BusRouteQuery.class.getClassLoader());
        this.f9487d = parcel.readFloat();
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.BusRouteQuery getBusQuery() {
        return this.f9486c;
    }

    public float getDistance() {
        return this.f9487d;
    }

    public List<BusPathV2> getPaths() {
        return this.f9485b;
    }

    public float getTaxiCost() {
        return this.f9484a;
    }

    public void setBusQuery(RouteSearchV2.BusRouteQuery busRouteQuery) {
        this.f9486c = busRouteQuery;
    }

    public void setDistance(float f6) {
        this.f9487d = f6;
    }

    public void setPaths(List<BusPathV2> list) {
        this.f9485b = list;
    }

    public void setTaxiCost(float f6) {
        this.f9484a = f6;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeFloat(this.f9484a);
        parcel.writeTypedList(this.f9485b);
        parcel.writeParcelable(this.f9486c, i6);
        parcel.writeFloat(this.f9487d);
    }

    public BusRouteResultV2() {
        this.f9485b = new ArrayList();
    }
}
