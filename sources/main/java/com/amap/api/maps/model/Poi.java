package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Poi implements Parcelable {
    public static final PoiCreator CREATOR = new PoiCreator();
    private final LatLng coordinate;
    private final String name;
    private final String poiid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Poi)) {
            Poi poi = (Poi) obj;
            if (poi.getName().equals(this.name) && poi.getCoordinate().equals(this.coordinate) && poi.getPoiId().equals(this.poiid)) {
                return true;
            }
        }
        return false;
    }

    public LatLng getCoordinate() {
        return this.coordinate;
    }

    public String getName() {
        return this.name;
    }

    public String getPoiId() {
        return this.poiid;
    }

    public String toString() {
        return "poiid " + this.poiid + " name:" + this.name + "  coordinate:" + this.coordinate.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.name);
        parcel.writeParcelable(this.coordinate, i6);
        parcel.writeString(this.poiid);
    }

    public Poi(String str, LatLng latLng, String str2) {
        this.name = str;
        this.coordinate = latLng;
        this.poiid = str2;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
