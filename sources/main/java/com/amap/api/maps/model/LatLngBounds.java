package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.b3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class LatLngBounds implements Parcelable {
    private static final String CLASSNAME = "LatLngBounds";
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        private boolean a(double d6) {
            double d7 = this.mWest;
            double d8 = this.mEast;
            return d7 <= d8 ? d7 <= d6 && d6 <= d8 : d7 <= d6 || d6 <= d8;
        }

        public final LatLngBounds build() {
            if (Double.isNaN(this.mWest)) {
                return null;
            }
            double d6 = this.mWest;
            double d7 = this.mEast;
            if (d6 > d7) {
                this.mWest = d7;
                this.mEast = d6;
            }
            double d8 = this.mSouth;
            double d9 = this.mNorth;
            if (d8 > d9) {
                this.mSouth = d9;
                this.mNorth = d8;
            }
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest, false), new LatLng(this.mNorth, this.mEast, false));
        }

        public final Builder include(LatLng latLng) {
            if (latLng != null) {
                this.mSouth = Math.min(this.mSouth, latLng.latitude);
                this.mNorth = Math.max(this.mNorth, latLng.latitude);
                double d6 = latLng.longitude;
                if (Double.isNaN(this.mWest)) {
                    this.mWest = d6;
                } else if (!a(d6)) {
                    if (LatLngBounds.c(this.mWest, d6) < LatLngBounds.d(this.mEast, d6)) {
                        this.mWest = d6;
                        return this;
                    }
                }
                this.mEast = d6;
            }
            return this;
        }
    }

    LatLngBounds(int i6, LatLng latLng, LatLng latLng2) {
        boolean z5;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
            z5 = false;
        }
        if (latLng == null) {
            throw new RuntimeRemoteException("null southwest");
        }
        if (latLng2 == null) {
            throw new RuntimeRemoteException("null northeast");
        }
        if (latLng2.latitude >= latLng.latitude) {
            z5 = true;
            this.mVersionCode = z5 ? i6 : 0;
            this.southwest = z5 ? latLng : null;
            this.northeast = z5 ? latLng2 : null;
            return;
        }
        throw new RuntimeRemoteException("southern latitude exceeds northern latitude (" + latLng.latitude + " > " + latLng2.latitude + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double c(double d6, double d7) {
        return ((d6 - d7) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double d(double d6, double d7) {
        return ((d7 - d6) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        return (latLng == null || this.northeast == null || this.southwest == null || !a(latLng.latitude) || !b(latLng.longitude)) ? false : true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public final boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        return a(latLngBounds) || latLngBounds.a(this);
    }

    private boolean b(double d6) {
        double d7 = this.southwest.longitude;
        double d8 = this.northeast.longitude;
        return d7 <= d8 ? d7 <= d6 && d6 <= d8 : d7 <= d6 || d6 <= d8;
    }

    public static Builder builder() {
        return new Builder();
    }

    final int a() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return b3.k(new Object[]{this.southwest, this.northeast});
    }

    public final LatLngBounds including(LatLng latLng) {
        LatLng latLng2;
        double d6;
        if (latLng != null && this.northeast != null && (latLng2 = this.southwest) != null) {
            double min = Math.min(latLng2.latitude, latLng.latitude);
            double max = Math.max(this.northeast.latitude, latLng.latitude);
            double d7 = this.northeast.longitude;
            double d8 = this.southwest.longitude;
            double d9 = latLng.longitude;
            try {
                if (!b(d9)) {
                    if (c(d8, d9) >= d(d7, d9)) {
                        d6 = d9;
                        return new LatLngBounds(new LatLng(min, d8, false), new LatLng(max, d6, false));
                    }
                    d8 = d9;
                }
                return new LatLngBounds(new LatLng(min, d8, false), new LatLng(max, d6, false));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            d6 = d7;
        }
        return this;
    }

    public final String toString() {
        return b3.A(b3.z("southwest", this.southwest), b3.z("northeast", this.northeast));
    }

    private boolean a(LatLngBounds latLngBounds) {
        LatLng latLng;
        LatLng latLng2;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || (latLng2 = latLngBounds.southwest) == null) {
            return false;
        }
        double d6 = latLng.longitude;
        double d7 = latLng2.longitude;
        LatLng latLng3 = this.northeast;
        double d8 = latLng3.longitude;
        LatLng latLng4 = this.southwest;
        double d9 = latLng4.longitude;
        double d10 = ((d6 + d7) - d8) - d9;
        double d11 = ((d8 - d9) + d6) - d7;
        double d12 = latLng.latitude;
        double d13 = latLng2.latitude;
        double d14 = latLng3.latitude;
        double d15 = latLng4.latitude;
        return Math.abs(d10) < d11 && Math.abs(((d12 + d13) - d14) - d15) < ((d14 - d15) + d12) - d13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        LatLngBoundsCreator.a(this, parcel, i6);
    }

    public final boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    private boolean a(double d6) {
        return this.southwest.latitude <= d6 && d6 <= this.northeast.latitude;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }
}
