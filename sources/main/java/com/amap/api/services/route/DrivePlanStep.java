package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new Parcelable.Creator<DrivePlanStep>() { // from class: com.amap.api.services.route.DrivePlanStep.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanStep[] newArray(int i6) {
            return null;
        }

        private static DrivePlanStep a(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9550a;

    /* renamed from: b, reason: collision with root package name */
    private String f9551b;

    /* renamed from: c, reason: collision with root package name */
    private float f9552c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9553d;

    /* renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f9554e;

    public DrivePlanStep(Parcel parcel) {
        this.f9554e = new ArrayList();
        this.f9550a = parcel.readString();
        this.f9551b = parcel.readString();
        this.f9552c = parcel.readFloat();
        this.f9553d = parcel.readInt() == 1;
        this.f9552c = parcel.readFloat();
        this.f9554e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f9551b;
    }

    public float getDistance() {
        return this.f9552c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9554e;
    }

    public String getRoad() {
        return this.f9550a;
    }

    public boolean getToll() {
        return this.f9553d;
    }

    public void setAdCode(String str) {
        this.f9551b = str;
    }

    public void setDistance(float f6) {
        this.f9552c = f6;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9554e = list;
    }

    public void setRoad(String str) {
        this.f9550a = str;
    }

    public void setToll(boolean z5) {
        this.f9553d = z5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9550a);
        parcel.writeString(this.f9551b);
        parcel.writeFloat(this.f9552c);
        parcel.writeInt(this.f9553d ? 1 : 0);
        parcel.writeFloat(this.f9552c);
        parcel.writeTypedList(this.f9554e);
    }

    public DrivePlanStep() {
        this.f9554e = new ArrayList();
    }
}
