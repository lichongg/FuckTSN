package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.u2;
import com.amap.api.col.p0003l.v5;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class CameraPosition implements Parcelable {
    private static final String CLASSNAME = "CameraPosition";
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private float bearing;
        private LatLng target;
        private float tilt;
        private float zoom;

        public Builder() {
        }

        public final CameraPosition build() {
            try {
                if (this.target == null) {
                    return null;
                }
                return new CameraPosition(this.target, this.zoom, this.tilt, this.bearing);
            } catch (Throwable th) {
                v5.p(th, CameraPosition.CLASSNAME, "build");
                return null;
            }
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public final Builder bearing(float f6) {
            this.bearing = f6;
            return this;
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder tilt(float f6) {
            this.tilt = f6;
            return this;
        }

        public final Builder zoom(float f6) {
            this.zoom = f6;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f6) {
        return new CameraPosition(latLng, f6, 0.0f, 0.0f);
    }

    public final String toString() {
        return b3.A(b3.z("target", this.target), b3.z("zoom", Float.valueOf(this.zoom)), b3.z("tilt", Float.valueOf(this.tilt)), b3.z("bearing", Float.valueOf(this.bearing)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public CameraPosition(LatLng latLng, float f6, float f7, float f8) {
        this.target = latLng;
        this.zoom = f6;
        this.tilt = f7;
        this.bearing = (((double) f8) <= 0.0d ? (f8 % 360.0f) + 360.0f : f8) % 360.0f;
        if (latLng != null) {
            this.isAbroad = !u2.a(latLng.latitude, latLng.longitude);
        } else {
            this.isAbroad = false;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
