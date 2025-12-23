package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() { // from class: com.amap.api.services.route.TruckRouteRestult.1
        private static TruckRouteRestult a(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        private static TruckRouteRestult[] a(int i6) {
            return new TruckRouteRestult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private RouteSearch.TruckRouteQuery f9797a;

    /* renamed from: b, reason: collision with root package name */
    private List<TruckPath> f9798b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9799c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f9800d;

    public TruckRouteRestult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected TruckRouteRestult(Parcel parcel) {
        this.f9798b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.f9799c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9800d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    public List<TruckPath> getPaths() {
        return this.f9798b;
    }

    public LatLonPoint getStartPos() {
        return this.f9799c;
    }

    public LatLonPoint getTargetPos() {
        return this.f9800d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f9797a;
    }

    public void setPaths(List<TruckPath> list) {
        this.f9798b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f9799c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f9800d = latLonPoint;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.f9797a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeTypedList(this.f9798b);
        parcel.writeParcelable(this.f9799c, i6);
        parcel.writeParcelable(this.f9800d, i6);
    }
}
