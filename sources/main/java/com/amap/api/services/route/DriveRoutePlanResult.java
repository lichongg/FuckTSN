package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DriveRoutePlanResult extends RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new Parcelable.Creator<DriveRoutePlanResult>() { // from class: com.amap.api.services.route.DriveRoutePlanResult.1
        private static DriveRoutePlanResult a(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }

        private static DriveRoutePlanResult[] a(int i6) {
            return new DriveRoutePlanResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<DrivePlanPath> f9555a;

    /* renamed from: b, reason: collision with root package name */
    private List<TimeInfo> f9556b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.DrivePlanQuery f9557c;

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.f9555a = new ArrayList();
        this.f9556b = new ArrayList();
        this.f9555a = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.f9556b = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.f9557c = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.f9555a;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.f9556b;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.f9557c = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.f9555a = list;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.f9556b = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9555a);
        parcel.writeTypedList(this.f9556b);
        parcel.writeParcelable(this.f9557c, i6);
    }

    public DriveRoutePlanResult() {
        this.f9555a = new ArrayList();
        this.f9556b = new ArrayList();
    }
}
