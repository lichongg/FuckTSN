package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new Parcelable.Creator<RidePath>() { // from class: com.amap.api.services.route.RidePath.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RidePath[] newArray(int i6) {
            return null;
        }

        private static RidePath a(Parcel parcel) {
            return new RidePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RidePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<RideStep> f9608a;

    public RidePath(Parcel parcel) {
        super(parcel);
        this.f9608a = new ArrayList();
        this.f9608a = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.f9608a;
    }

    public void setSteps(List<RideStep> list) {
        this.f9608a = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9608a);
    }

    public RidePath() {
        this.f9608a = new ArrayList();
    }
}
