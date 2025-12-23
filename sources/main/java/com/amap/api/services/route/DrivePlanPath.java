package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() { // from class: com.amap.api.services.route.DrivePlanPath.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i6) {
            return null;
        }

        private static DrivePlanPath a(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    float f9547a;

    /* renamed from: b, reason: collision with root package name */
    int f9548b;

    /* renamed from: c, reason: collision with root package name */
    private List<DrivePlanStep> f9549c;

    public DrivePlanPath(Parcel parcel) {
        this.f9549c = new ArrayList();
        this.f9547a = parcel.readFloat();
        this.f9548b = parcel.readInt();
        this.f9549c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f9547a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f9549c;
    }

    public float getTrafficLights() {
        return this.f9548b;
    }

    public void setDistance(float f6) {
        this.f9547a = f6;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.f9549c = list;
    }

    public void setTrafficLights(int i6) {
        this.f9548b = i6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f9547a);
        parcel.writeInt(this.f9548b);
        parcel.writeTypedList(this.f9549c);
    }

    public DrivePlanPath() {
        this.f9549c = new ArrayList();
    }
}
