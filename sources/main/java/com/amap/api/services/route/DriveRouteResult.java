package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new Parcelable.Creator<DriveRouteResult>() { // from class: com.amap.api.services.route.DriveRouteResult.1
        private static DriveRouteResult a(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        private static DriveRouteResult[] a(int i6) {
            return new DriveRouteResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9558a;

    /* renamed from: b, reason: collision with root package name */
    private List<DrivePath> f9559b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.DriveRouteQuery f9560c;

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f9559b = new ArrayList();
        this.f9558a = parcel.readFloat();
        this.f9559b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f9560c = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f9560c;
    }

    public List<DrivePath> getPaths() {
        return this.f9559b;
    }

    public float getTaxiCost() {
        return this.f9558a;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.f9560c = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.f9559b = list;
    }

    public void setTaxiCost(float f6) {
        this.f9558a = f6;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeFloat(this.f9558a);
        parcel.writeTypedList(this.f9559b);
        parcel.writeParcelable(this.f9560c, i6);
    }

    public DriveRouteResult() {
        this.f9559b = new ArrayList();
    }
}
