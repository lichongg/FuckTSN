package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new Parcelable.Creator<DriveStep>() { // from class: com.amap.api.services.route.DriveStep.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStep[] newArray(int i6) {
            return null;
        }

        private static DriveStep a(Parcel parcel) {
            return new DriveStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9564a;

    /* renamed from: b, reason: collision with root package name */
    private String f9565b;

    /* renamed from: c, reason: collision with root package name */
    private String f9566c;

    /* renamed from: d, reason: collision with root package name */
    private float f9567d;

    /* renamed from: e, reason: collision with root package name */
    private float f9568e;

    /* renamed from: f, reason: collision with root package name */
    private float f9569f;

    /* renamed from: g, reason: collision with root package name */
    private String f9570g;

    /* renamed from: h, reason: collision with root package name */
    private float f9571h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f9572i;

    /* renamed from: j, reason: collision with root package name */
    private String f9573j;

    /* renamed from: k, reason: collision with root package name */
    private String f9574k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f9575l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f9576m;

    public DriveStep(Parcel parcel) {
        this.f9572i = new ArrayList();
        this.f9575l = new ArrayList();
        this.f9576m = new ArrayList();
        this.f9564a = parcel.readString();
        this.f9565b = parcel.readString();
        this.f9566c = parcel.readString();
        this.f9567d = parcel.readFloat();
        this.f9568e = parcel.readFloat();
        this.f9569f = parcel.readFloat();
        this.f9570g = parcel.readString();
        this.f9571h = parcel.readFloat();
        this.f9572i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9573j = parcel.readString();
        this.f9574k = parcel.readString();
        this.f9575l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f9576m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f9573j;
    }

    public String getAssistantAction() {
        return this.f9574k;
    }

    public float getDistance() {
        return this.f9567d;
    }

    public float getDuration() {
        return this.f9571h;
    }

    public String getInstruction() {
        return this.f9564a;
    }

    public String getOrientation() {
        return this.f9565b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9572i;
    }

    public String getRoad() {
        return this.f9566c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f9575l;
    }

    public List<TMC> getTMCs() {
        return this.f9576m;
    }

    public float getTollDistance() {
        return this.f9569f;
    }

    public String getTollRoad() {
        return this.f9570g;
    }

    public float getTolls() {
        return this.f9568e;
    }

    public void setAction(String str) {
        this.f9573j = str;
    }

    public void setAssistantAction(String str) {
        this.f9574k = str;
    }

    public void setDistance(float f6) {
        this.f9567d = f6;
    }

    public void setDuration(float f6) {
        this.f9571h = f6;
    }

    public void setInstruction(String str) {
        this.f9564a = str;
    }

    public void setOrientation(String str) {
        this.f9565b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9572i = list;
    }

    public void setRoad(String str) {
        this.f9566c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f9575l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f9576m = list;
    }

    public void setTollDistance(float f6) {
        this.f9569f = f6;
    }

    public void setTollRoad(String str) {
        this.f9570g = str;
    }

    public void setTolls(float f6) {
        this.f9568e = f6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9564a);
        parcel.writeString(this.f9565b);
        parcel.writeString(this.f9566c);
        parcel.writeFloat(this.f9567d);
        parcel.writeFloat(this.f9568e);
        parcel.writeFloat(this.f9569f);
        parcel.writeString(this.f9570g);
        parcel.writeFloat(this.f9571h);
        parcel.writeTypedList(this.f9572i);
        parcel.writeString(this.f9573j);
        parcel.writeString(this.f9574k);
        parcel.writeTypedList(this.f9575l);
        parcel.writeTypedList(this.f9576m);
    }

    public DriveStep() {
        this.f9572i = new ArrayList();
        this.f9575l = new ArrayList();
        this.f9576m = new ArrayList();
    }
}
