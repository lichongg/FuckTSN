package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new Parcelable.Creator<RouteSearchCity>() { // from class: com.amap.api.services.route.RouteSearchCity.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteSearchCity[] newArray(int i6) {
            return null;
        }

        private static RouteSearchCity a(Parcel parcel) {
            return new RouteSearchCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteSearchCity createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    List<District> f9690a;

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f9690a = new ArrayList();
        this.f9690a = parcel.createTypedArrayList(District.CREATOR);
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<District> getDistricts() {
        return this.f9690a;
    }

    public void setDistricts(List<District> list) {
        this.f9690a = list;
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f9690a);
    }

    public RouteSearchCity() {
        this.f9690a = new ArrayList();
    }
}
