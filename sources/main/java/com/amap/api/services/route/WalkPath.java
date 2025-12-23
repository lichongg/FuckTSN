package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WalkPath extends Path implements Parcelable {
    public static final Parcelable.Creator<WalkPath> CREATOR = new Parcelable.Creator<WalkPath>() { // from class: com.amap.api.services.route.WalkPath.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalkPath[] newArray(int i6) {
            return null;
        }

        private static WalkPath a(Parcel parcel) {
            return new WalkPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<WalkStep> f9814a;

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.f9814a = new ArrayList();
        this.f9814a = parcel.createTypedArrayList(WalkStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkStep> getSteps() {
        return this.f9814a;
    }

    public void setSteps(List<WalkStep> list) {
        this.f9814a = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9814a);
    }

    public WalkPath() {
        this.f9814a = new ArrayList();
    }
}
