package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new Parcelable.Creator<Doorway>() { // from class: com.amap.api.services.route.Doorway.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Doorway[] newArray(int i6) {
            return null;
        }

        private static Doorway a(Parcel parcel) {
            return new Doorway(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Doorway createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9533a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9534b;

    public Doorway(Parcel parcel) {
        this.f9533a = parcel.readString();
        this.f9534b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f9534b;
    }

    public String getName() {
        return this.f9533a;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f9534b = latLonPoint;
    }

    public void setName(String str) {
        this.f9533a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f9533a);
        parcel.writeParcelable(this.f9534b, i6);
    }

    public Doorway() {
    }
}
