package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WalkRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<WalkRouteResultV2> CREATOR = new Parcelable.Creator<WalkRouteResultV2>() { // from class: com.amap.api.services.route.WalkRouteResultV2.1
        private static WalkRouteResultV2 a(Parcel parcel) {
            return new WalkRouteResultV2(parcel);
        }

        private static WalkRouteResultV2[] a(int i6) {
            return new WalkRouteResultV2[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<WalkPath> f9817a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearchV2.WalkRouteQuery f9818b;

    public WalkRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f9817a = new ArrayList();
        this.f9817a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f9818b = (RouteSearchV2.WalkRouteQuery) parcel.readParcelable(RouteSearchV2.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f9817a;
    }

    public RouteSearchV2.WalkRouteQuery getWalkQuery() {
        return this.f9818b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f9817a = list;
    }

    public void setWalkQuery(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        this.f9818b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9817a);
        parcel.writeParcelable(this.f9818b, i6);
    }

    public WalkRouteResultV2() {
        this.f9817a = new ArrayList();
    }
}
