package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusPath extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPath> CREATOR = new Parcelable.Creator<BusPath>() { // from class: com.amap.api.services.route.BusPath.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPath[] newArray(int i6) {
            return null;
        }

        private static BusPath a(Parcel parcel) {
            return new BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9471a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9472b;

    /* renamed from: c, reason: collision with root package name */
    private float f9473c;

    /* renamed from: d, reason: collision with root package name */
    private float f9474d;

    /* renamed from: e, reason: collision with root package name */
    private List<BusStep> f9475e;

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f9475e = new ArrayList();
        this.f9471a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f9472b = zArr[0];
        this.f9473c = parcel.readFloat();
        this.f9474d = parcel.readFloat();
        this.f9475e = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f9474d;
    }

    public float getCost() {
        return this.f9471a;
    }

    public List<BusStep> getSteps() {
        return this.f9475e;
    }

    public float getWalkDistance() {
        return this.f9473c;
    }

    public boolean isNightBus() {
        return this.f9472b;
    }

    public void setBusDistance(float f6) {
        this.f9474d = f6;
    }

    public void setCost(float f6) {
        this.f9471a = f6;
    }

    public void setNightBus(boolean z5) {
        this.f9472b = z5;
    }

    public void setSteps(List<BusStep> list) {
        this.f9475e = list;
    }

    public void setWalkDistance(float f6) {
        this.f9473c = f6;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeFloat(this.f9471a);
        parcel.writeBooleanArray(new boolean[]{this.f9472b});
        parcel.writeFloat(this.f9473c);
        parcel.writeFloat(this.f9474d);
        parcel.writeTypedList(this.f9475e);
    }

    public BusPath() {
        this.f9475e = new ArrayList();
    }
}
