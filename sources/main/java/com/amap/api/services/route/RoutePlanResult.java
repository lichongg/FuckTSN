package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() { // from class: com.amap.api.services.route.RoutePlanResult.1
        private static RoutePlanResult a(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        private static RoutePlanResult[] a(int i6) {
            return new RoutePlanResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9630a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9631b;

    public RoutePlanResult(Parcel parcel) {
        this.f9630a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9631b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f9630a;
    }

    public LatLonPoint getTargetPos() {
        return this.f9631b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f9630a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f9631b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9630a, i6);
        parcel.writeParcelable(this.f9631b, i6);
    }

    public RoutePlanResult() {
    }
}
