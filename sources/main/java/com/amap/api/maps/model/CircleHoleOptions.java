package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.umeng.analytics.pro.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {

    @JBindingExclude
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() { // from class: com.amap.api.maps.model.CircleHoleOptions.1
        private static CircleHoleOptions a(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        private static CircleHoleOptions[] a(int i6) {
            return new CircleHoleOptions[i6];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions[] newArray(int i6) {
            return a(i6);
        }
    };
    private LatLng point;
    private double radius;

    public CircleHoleOptions() {
        this.point = null;
        this.radius = 0.0d;
        this.isPolygonHoleOptions = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d6) {
        this.radius = d6;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble(d.C, latLng.latitude);
            bundle.putDouble(d.D, this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }

    @JBindingExclude
    protected CircleHoleOptions(Parcel parcel) {
        this.point = null;
        this.radius = 0.0d;
        Bundle readBundle = parcel.readBundle();
        this.point = new LatLng(readBundle.getDouble(d.C), readBundle.getDouble(d.D));
        this.radius = parcel.readDouble();
    }
}
