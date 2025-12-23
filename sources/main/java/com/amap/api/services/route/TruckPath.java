package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = new Parcelable.Creator<TruckPath>() { // from class: com.amap.api.services.route.TruckPath.1
        private static TruckPath a(Parcel parcel) {
            return new TruckPath(parcel);
        }

        private static TruckPath[] a(int i6) {
            return new TruckPath[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9789a;

    /* renamed from: b, reason: collision with root package name */
    private long f9790b;

    /* renamed from: c, reason: collision with root package name */
    private String f9791c;

    /* renamed from: d, reason: collision with root package name */
    private float f9792d;

    /* renamed from: e, reason: collision with root package name */
    private float f9793e;

    /* renamed from: f, reason: collision with root package name */
    private int f9794f;

    /* renamed from: g, reason: collision with root package name */
    private int f9795g;

    /* renamed from: h, reason: collision with root package name */
    private List<TruckStep> f9796h;

    public TruckPath() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected TruckPath(Parcel parcel) {
        this.f9789a = parcel.readFloat();
        this.f9790b = parcel.readLong();
        this.f9791c = parcel.readString();
        this.f9792d = parcel.readFloat();
        this.f9793e = parcel.readFloat();
        this.f9794f = parcel.readInt();
        this.f9795g = parcel.readInt();
        this.f9796h = parcel.createTypedArrayList(TruckStep.CREATOR);
    }

    public float getDistance() {
        return this.f9789a;
    }

    public long getDuration() {
        return this.f9790b;
    }

    public int getRestriction() {
        return this.f9795g;
    }

    public List<TruckStep> getSteps() {
        return this.f9796h;
    }

    public String getStrategy() {
        return this.f9791c;
    }

    public float getTollDistance() {
        return this.f9793e;
    }

    public float getTolls() {
        return this.f9792d;
    }

    public int getTotalTrafficlights() {
        return this.f9794f;
    }

    public void setDistance(float f6) {
        this.f9789a = f6;
    }

    public void setDuration(long j6) {
        this.f9790b = j6;
    }

    public void setRestriction(int i6) {
        this.f9795g = i6;
    }

    public void setSteps(List<TruckStep> list) {
        this.f9796h = list;
    }

    public void setStrategy(String str) {
        this.f9791c = str;
    }

    public void setTollDistance(float f6) {
        this.f9793e = f6;
    }

    public void setTolls(float f6) {
        this.f9792d = f6;
    }

    public void setTotalTrafficlights(int i6) {
        this.f9794f = i6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f9789a);
        parcel.writeLong(this.f9790b);
        parcel.writeString(this.f9791c);
        parcel.writeFloat(this.f9792d);
        parcel.writeFloat(this.f9793e);
        parcel.writeInt(this.f9794f);
        parcel.writeInt(this.f9795g);
        parcel.writeTypedList(this.f9796h);
    }
}
