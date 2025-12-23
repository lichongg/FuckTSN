package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BusPathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPathV2> CREATOR = new Parcelable.Creator<BusPathV2>() { // from class: com.amap.api.services.route.BusPathV2.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPathV2[] newArray(int i6) {
            return null;
        }

        private static BusPathV2 a(Parcel parcel) {
            return new BusPathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9476a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9477b;

    /* renamed from: c, reason: collision with root package name */
    private float f9478c;

    /* renamed from: d, reason: collision with root package name */
    private float f9479d;

    /* renamed from: e, reason: collision with root package name */
    private List<BusStepV2> f9480e;

    public BusPathV2(Parcel parcel) {
        super(parcel);
        this.f9480e = new ArrayList();
        this.f9476a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f9477b = zArr[0];
        this.f9478c = parcel.readFloat();
        this.f9479d = parcel.readFloat();
        this.f9480e = parcel.createTypedArrayList(BusStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f9479d;
    }

    public float getCost() {
        return this.f9476a;
    }

    public List<BusStepV2> getSteps() {
        return this.f9480e;
    }

    public float getWalkDistance() {
        return this.f9478c;
    }

    public boolean isNightBus() {
        return this.f9477b;
    }

    public void setBusDistance(float f6) {
        this.f9479d = f6;
    }

    public void setCost(float f6) {
        this.f9476a = f6;
    }

    public void setNightBus(boolean z5) {
        this.f9477b = z5;
    }

    public void setSteps(List<BusStepV2> list) {
        this.f9480e = list;
    }

    public void setWalkDistance(float f6) {
        this.f9478c = f6;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeFloat(this.f9476a);
        parcel.writeBooleanArray(new boolean[]{this.f9477b});
        parcel.writeFloat(this.f9478c);
        parcel.writeFloat(this.f9479d);
        parcel.writeTypedList(this.f9480e);
    }

    public BusPathV2() {
        this.f9480e = new ArrayList();
    }
}
