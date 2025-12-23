package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DriveRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new Parcelable.Creator<DriveRouteResultV2>() { // from class: com.amap.api.services.route.DriveRouteResultV2.1
        private static DriveRouteResultV2 a(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        private static DriveRouteResultV2[] a(int i6) {
            return new DriveRouteResultV2[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9561a;

    /* renamed from: b, reason: collision with root package name */
    private List<DrivePathV2> f9562b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearchV2.DriveRouteQuery f9563c;

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f9562b = new ArrayList();
        this.f9561a = parcel.readFloat();
        this.f9562b = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.f9563c = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.f9563c;
    }

    public List<DrivePathV2> getPaths() {
        return this.f9562b;
    }

    public float getTaxiCost() {
        return this.f9561a;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.f9563c = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
        this.f9562b = list;
    }

    public void setTaxiCost(float f6) {
        this.f9561a = f6;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeFloat(this.f9561a);
        parcel.writeTypedList(this.f9562b);
        parcel.writeParcelable(this.f9563c, i6);
    }

    public DriveRouteResultV2() {
        this.f9562b = new ArrayList();
    }
}
