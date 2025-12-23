package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TruckStep implements Parcelable {
    public static final Parcelable.Creator<TruckStep> CREATOR = new Parcelable.Creator<TruckStep>() { // from class: com.amap.api.services.route.TruckStep.1
        private static TruckStep a(Parcel parcel) {
            return new TruckStep(parcel);
        }

        private static TruckStep[] a(int i6) {
            return new TruckStep[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9801a;

    /* renamed from: b, reason: collision with root package name */
    private String f9802b;

    /* renamed from: c, reason: collision with root package name */
    private String f9803c;

    /* renamed from: d, reason: collision with root package name */
    private float f9804d;

    /* renamed from: e, reason: collision with root package name */
    private float f9805e;

    /* renamed from: f, reason: collision with root package name */
    private float f9806f;

    /* renamed from: g, reason: collision with root package name */
    private String f9807g;

    /* renamed from: h, reason: collision with root package name */
    private float f9808h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f9809i;

    /* renamed from: j, reason: collision with root package name */
    private String f9810j;

    /* renamed from: k, reason: collision with root package name */
    private String f9811k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f9812l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f9813m;

    public TruckStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected TruckStep(Parcel parcel) {
        this.f9801a = parcel.readString();
        this.f9802b = parcel.readString();
        this.f9803c = parcel.readString();
        this.f9804d = parcel.readFloat();
        this.f9805e = parcel.readFloat();
        this.f9806f = parcel.readFloat();
        this.f9807g = parcel.readString();
        this.f9808h = parcel.readFloat();
        this.f9809i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9810j = parcel.readString();
        this.f9811k = parcel.readString();
        this.f9812l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f9813m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    public String getAction() {
        return this.f9810j;
    }

    public String getAssistantAction() {
        return this.f9811k;
    }

    public float getDistance() {
        return this.f9805e;
    }

    public float getDuration() {
        return this.f9808h;
    }

    public String getInstruction() {
        return this.f9801a;
    }

    public String getOrientation() {
        return this.f9802b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9809i;
    }

    public String getRoad() {
        return this.f9803c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f9812l;
    }

    public List<TMC> getTMCs() {
        return this.f9813m;
    }

    public float getTollDistance() {
        return this.f9806f;
    }

    public String getTollRoad() {
        return this.f9807g;
    }

    public float getTolls() {
        return this.f9804d;
    }

    public void setAction(String str) {
        this.f9810j = str;
    }

    public void setAssistantAction(String str) {
        this.f9811k = str;
    }

    public void setDistance(float f6) {
        this.f9805e = f6;
    }

    public void setDuration(float f6) {
        this.f9808h = f6;
    }

    public void setInstruction(String str) {
        this.f9801a = str;
    }

    public void setOrientation(String str) {
        this.f9802b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9809i = list;
    }

    public void setRoad(String str) {
        this.f9803c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f9812l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f9813m = list;
    }

    public void setTollDistance(float f6) {
        this.f9806f = f6;
    }

    public void setTollRoad(String str) {
        this.f9807g = str;
    }

    public void setTolls(float f6) {
        this.f9804d = f6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9801a);
        parcel.writeString(this.f9802b);
        parcel.writeString(this.f9803c);
        parcel.writeFloat(this.f9804d);
        parcel.writeFloat(this.f9805e);
        parcel.writeFloat(this.f9806f);
        parcel.writeString(this.f9807g);
        parcel.writeFloat(this.f9808h);
        parcel.writeTypedList(this.f9809i);
        parcel.writeString(this.f9810j);
        parcel.writeString(this.f9811k);
        parcel.writeTypedList(this.f9812l);
        parcel.writeTypedList(this.f9813m);
    }
}
