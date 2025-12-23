package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RideRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new Parcelable.Creator<RideRouteResult>() { // from class: com.amap.api.services.route.RideRouteResult.1
        private static RideRouteResult a(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        private static RideRouteResult[] a(int i6) {
            return new RideRouteResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<RidePath> f9609a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearch.RideRouteQuery f9610b;

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.f9609a = new ArrayList();
        this.f9609a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f9610b = (RouteSearch.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f9609a;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.f9610b;
    }

    public void setPaths(List<RidePath> list) {
        this.f9609a = list;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery rideRouteQuery) {
        this.f9610b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9609a);
        parcel.writeParcelable(this.f9610b, i6);
    }

    public RideRouteResult() {
        this.f9609a = new ArrayList();
    }
}
