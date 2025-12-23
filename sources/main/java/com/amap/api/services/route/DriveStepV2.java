package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DriveStepV2 implements Parcelable {
    public static final Parcelable.Creator<DriveStepV2> CREATOR = new Parcelable.Creator<DriveStepV2>() { // from class: com.amap.api.services.route.DriveStepV2.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStepV2[] newArray(int i6) {
            return null;
        }

        private static DriveStepV2 a(Parcel parcel) {
            return new DriveStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStepV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9577a;

    /* renamed from: b, reason: collision with root package name */
    private String f9578b;

    /* renamed from: c, reason: collision with root package name */
    private String f9579c;

    /* renamed from: d, reason: collision with root package name */
    private List<LatLonPoint> f9580d;

    /* renamed from: e, reason: collision with root package name */
    private List<RouteSearchCity> f9581e;

    /* renamed from: f, reason: collision with root package name */
    private List<TMC> f9582f;

    /* renamed from: g, reason: collision with root package name */
    private int f9583g;

    /* renamed from: h, reason: collision with root package name */
    private Cost f9584h;

    /* renamed from: i, reason: collision with root package name */
    private Navi f9585i;

    public DriveStepV2(Parcel parcel) {
        this.f9580d = new ArrayList();
        this.f9581e = new ArrayList();
        this.f9582f = new ArrayList();
        this.f9583g = -1;
        this.f9577a = parcel.readString();
        this.f9578b = parcel.readString();
        this.f9579c = parcel.readString();
        this.f9580d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9581e = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f9582f = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Cost getCostDetail() {
        return this.f9584h;
    }

    public String getInstruction() {
        return this.f9577a;
    }

    public Navi getNavi() {
        return this.f9585i;
    }

    public String getOrientation() {
        return this.f9578b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9580d;
    }

    public String getRoad() {
        return this.f9579c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f9581e;
    }

    public int getStepDistance() {
        return this.f9583g;
    }

    public List<TMC> getTMCs() {
        return this.f9582f;
    }

    public void setCostDetail(Cost cost) {
        this.f9584h = cost;
    }

    public void setInstruction(String str) {
        this.f9577a = str;
    }

    public void setNavi(Navi navi) {
        this.f9585i = navi;
    }

    public void setOrientation(String str) {
        this.f9578b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9580d = list;
    }

    public void setRoad(String str) {
        this.f9579c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f9581e = list;
    }

    public void setStepDistance(int i6) {
        this.f9583g = i6;
    }

    public void setTMCs(List<TMC> list) {
        this.f9582f = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9577a);
        parcel.writeString(this.f9578b);
        parcel.writeString(this.f9579c);
        parcel.writeTypedList(this.f9580d);
        parcel.writeTypedList(this.f9581e);
        parcel.writeTypedList(this.f9582f);
    }

    public DriveStepV2() {
        this.f9580d = new ArrayList();
        this.f9581e = new ArrayList();
        this.f9582f = new ArrayList();
        this.f9583g = -1;
    }
}
