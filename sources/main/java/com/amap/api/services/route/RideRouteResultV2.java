package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RideRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResultV2> CREATOR = new Parcelable.Creator<RideRouteResultV2>() { // from class: com.amap.api.services.route.RideRouteResultV2.1
        private static RideRouteResultV2 a(Parcel parcel) {
            return new RideRouteResultV2(parcel);
        }

        private static RideRouteResultV2[] a(int i6) {
            return new RideRouteResultV2[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<RidePath> f9611a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearchV2.RideRouteQuery f9612b;

    public RideRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f9611a = new ArrayList();
        this.f9611a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f9612b = (RouteSearchV2.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f9611a;
    }

    public RouteSearchV2.RideRouteQuery getRideQuery() {
        return this.f9612b;
    }

    public void setPaths(List<RidePath> list) {
        this.f9611a = list;
    }

    public void setRideQuery(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        this.f9612b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9611a);
        parcel.writeParcelable(this.f9612b, i6);
    }

    public RideRouteResultV2() {
        this.f9611a = new ArrayList();
    }
}
