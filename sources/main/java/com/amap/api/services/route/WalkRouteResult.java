package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() { // from class: com.amap.api.services.route.WalkRouteResult.1
        private static WalkRouteResult a(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        private static WalkRouteResult[] a(int i6) {
            return new WalkRouteResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<WalkPath> f9815a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearch.WalkRouteQuery f9816b;

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f9815a = new ArrayList();
        this.f9815a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f9816b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f9815a;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f9816b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f9815a = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.f9816b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9815a);
        parcel.writeParcelable(this.f9816b, i6);
    }

    public WalkRouteResult() {
        this.f9815a = new ArrayList();
    }
}
