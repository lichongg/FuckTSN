package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new Parcelable.Creator<TMC>() { // from class: com.amap.api.services.route.TMC.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TMC[] newArray(int i6) {
            return null;
        }

        private static TMC a(Parcel parcel) {
            return new TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TMC createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private int f9765a;

    /* renamed from: b, reason: collision with root package name */
    private String f9766b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f9767c;

    public TMC(Parcel parcel) {
        this.f9767c = new ArrayList();
        this.f9765a = parcel.readInt();
        this.f9766b = parcel.readString();
        this.f9767c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f9765a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9767c;
    }

    public String getStatus() {
        return this.f9766b;
    }

    public void setDistance(int i6) {
        this.f9765a = i6;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9767c = list;
    }

    public void setStatus(String str) {
        this.f9766b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f9765a);
        parcel.writeString(this.f9766b);
        parcel.writeTypedList(this.f9767c);
    }

    public TMC() {
        this.f9767c = new ArrayList();
    }
}
