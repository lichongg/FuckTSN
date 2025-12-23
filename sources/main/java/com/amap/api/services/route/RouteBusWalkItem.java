package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new Parcelable.Creator<RouteBusWalkItem>() { // from class: com.amap.api.services.route.RouteBusWalkItem.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusWalkItem[] newArray(int i6) {
            return null;
        }

        private static RouteBusWalkItem a(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusWalkItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9628a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9629b;

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f9628a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9629b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f9629b;
    }

    public LatLonPoint getOrigin() {
        return this.f9628a;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f9629b = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f9628a = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeParcelable(this.f9628a, i6);
        parcel.writeParcelable(this.f9629b, i6);
    }

    public RouteBusWalkItem() {
    }
}
