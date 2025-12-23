package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DrivePath extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() { // from class: com.amap.api.services.route.DrivePath.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePath[] newArray(int i6) {
            return null;
        }

        private static DrivePath a(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9535a;

    /* renamed from: b, reason: collision with root package name */
    private float f9536b;

    /* renamed from: c, reason: collision with root package name */
    private float f9537c;

    /* renamed from: d, reason: collision with root package name */
    private int f9538d;

    /* renamed from: e, reason: collision with root package name */
    private List<DriveStep> f9539e;

    /* renamed from: f, reason: collision with root package name */
    private int f9540f;

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f9539e = new ArrayList();
        this.f9535a = parcel.readString();
        this.f9536b = parcel.readFloat();
        this.f9537c = parcel.readFloat();
        this.f9539e = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.f9538d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f9540f;
    }

    public List<DriveStep> getSteps() {
        return this.f9539e;
    }

    public String getStrategy() {
        return this.f9535a;
    }

    public float getTollDistance() {
        return this.f9537c;
    }

    public float getTolls() {
        return this.f9536b;
    }

    public int getTotalTrafficlights() {
        return this.f9538d;
    }

    public void setRestriction(int i6) {
        this.f9540f = i6;
    }

    public void setSteps(List<DriveStep> list) {
        this.f9539e = list;
    }

    public void setStrategy(String str) {
        this.f9535a = str;
    }

    public void setTollDistance(float f6) {
        this.f9537c = f6;
    }

    public void setTolls(float f6) {
        this.f9536b = f6;
    }

    public void setTotalTrafficlights(int i6) {
        this.f9538d = i6;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeString(this.f9535a);
        parcel.writeFloat(this.f9536b);
        parcel.writeFloat(this.f9537c);
        parcel.writeTypedList(this.f9539e);
        parcel.writeInt(this.f9538d);
    }

    public DrivePath() {
        this.f9539e = new ArrayList();
    }
}
