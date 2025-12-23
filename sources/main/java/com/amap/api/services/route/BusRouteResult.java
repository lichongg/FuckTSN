package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() { // from class: com.amap.api.services.route.BusRouteResult.1
        private static BusRouteResult a(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        private static BusRouteResult[] a(int i6) {
            return new BusRouteResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9481a;

    /* renamed from: b, reason: collision with root package name */
    private List<BusPath> f9482b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.BusRouteQuery f9483c;

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f9482b = new ArrayList();
        this.f9481a = parcel.readFloat();
        this.f9482b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f9483c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f9483c;
    }

    public List<BusPath> getPaths() {
        return this.f9482b;
    }

    public float getTaxiCost() {
        return this.f9481a;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.f9483c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.f9482b = list;
    }

    public void setTaxiCost(float f6) {
        this.f9481a = f6;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeFloat(this.f9481a);
        parcel.writeTypedList(this.f9482b);
        parcel.writeParcelable(this.f9483c, i6);
    }

    public BusRouteResult() {
        this.f9482b = new ArrayList();
    }
}
