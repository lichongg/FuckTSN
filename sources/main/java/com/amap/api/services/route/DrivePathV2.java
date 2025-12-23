package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DrivePathV2 extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePathV2> CREATOR = new Parcelable.Creator<DrivePathV2>() { // from class: com.amap.api.services.route.DrivePathV2.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePathV2[] newArray(int i6) {
            return null;
        }

        private static DrivePathV2 a(Parcel parcel) {
            return new DrivePathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9541a;

    /* renamed from: b, reason: collision with root package name */
    private List<DriveStepV2> f9542b;

    /* renamed from: c, reason: collision with root package name */
    private int f9543c;

    /* renamed from: d, reason: collision with root package name */
    private Cost f9544d;

    /* renamed from: e, reason: collision with root package name */
    private ElecConsumeInfo f9545e;

    /* renamed from: f, reason: collision with root package name */
    private List<ChargeStationInfo> f9546f;

    public DrivePathV2(Parcel parcel) {
        super(parcel);
        this.f9542b = new ArrayList();
        this.f9546f = new ArrayList();
        this.f9541a = parcel.readString();
        this.f9542b = parcel.createTypedArrayList(DriveStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ChargeStationInfo> getChargeStationInfo() {
        return this.f9546f;
    }

    public Cost getCost() {
        return this.f9544d;
    }

    public ElecConsumeInfo getElecConsumeInfo() {
        return this.f9545e;
    }

    public int getRestriction() {
        return this.f9543c;
    }

    public List<DriveStepV2> getSteps() {
        return this.f9542b;
    }

    public String getStrategy() {
        return this.f9541a;
    }

    public void setChargeStationInfo(List<ChargeStationInfo> list) {
        this.f9546f = list;
    }

    public void setCost(Cost cost) {
        this.f9544d = cost;
    }

    public void setElecConsumeInfo(ElecConsumeInfo elecConsumeInfo) {
        this.f9545e = elecConsumeInfo;
    }

    public void setRestriction(int i6) {
        this.f9543c = i6;
    }

    public void setSteps(List<DriveStepV2> list) {
        this.f9542b = list;
    }

    public void setStrategy(String str) {
        this.f9541a = str;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9542b);
    }

    public DrivePathV2() {
        this.f9542b = new ArrayList();
        this.f9546f = new ArrayList();
    }
}
