package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new Parcelable.Creator<RouteResult>() { // from class: com.amap.api.services.route.RouteResult.1
        private static RouteResult a(Parcel parcel) {
            return new RouteResult(parcel);
        }

        private static RouteResult[] a(int i6) {
            return new RouteResult[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult[] newArray(int i6) {
            return a(i6);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9641a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9642b;

    public RouteResult(Parcel parcel) {
        this.f9641a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9642b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f9641a;
    }

    public LatLonPoint getTargetPos() {
        return this.f9642b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f9641a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f9642b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f9641a, i6);
        parcel.writeParcelable(this.f9642b, i6);
    }

    public RouteResult() {
    }
}
