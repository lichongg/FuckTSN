package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() { // from class: com.amap.api.services.route.Path.1
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Path[] newArray(int i6) {
            return null;
        }

        private static Path a(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Path createFromParcel(Parcel parcel) {
            return a(parcel);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9593a;

    /* renamed from: b, reason: collision with root package name */
    private long f9594b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f9595c;

    public Path(Parcel parcel) {
        this.f9595c = new ArrayList();
        this.f9593a = parcel.readFloat();
        this.f9594b = parcel.readLong();
        this.f9595c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f9593a;
    }

    public long getDuration() {
        return this.f9594b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9595c;
    }

    public void setDistance(float f6) {
        this.f9593a = f6;
    }

    public void setDuration(long j6) {
        this.f9594b = j6;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9595c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f9593a);
        parcel.writeLong(this.f9594b);
        parcel.writeTypedList(this.f9595c);
    }

    public Path() {
        this.f9595c = new ArrayList();
    }
}
