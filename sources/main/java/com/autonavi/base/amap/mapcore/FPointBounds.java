package com.autonavi.base.amap.mapcore;

import android.graphics.PointF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FPointBounds {
    private final int mVersionCode;
    public final FPoint northeast;
    public final FPoint southwest;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private float mSouth = Float.POSITIVE_INFINITY;
        private float mNorth = Float.NEGATIVE_INFINITY;
        private float mWest = Float.POSITIVE_INFINITY;
        private float mEast = Float.NEGATIVE_INFINITY;

        private boolean containsx(double d6) {
            float f6 = this.mWest;
            float f7 = this.mEast;
            return f6 <= f7 ? ((double) f6) <= d6 && d6 <= ((double) f7) : ((double) f6) <= d6 || d6 <= ((double) f7);
        }

        public final FPointBounds build() {
            return new FPointBounds(FPoint.obtain(this.mWest, this.mSouth), FPoint.obtain(this.mEast, this.mNorth));
        }

        public final Builder include(FPoint fPoint) {
            this.mSouth = Math.min(this.mSouth, ((PointF) fPoint).y);
            this.mNorth = Math.max(this.mNorth, ((PointF) fPoint).y);
            this.mWest = Math.min(this.mWest, ((PointF) fPoint).x);
            this.mEast = Math.max(this.mEast, ((PointF) fPoint).x);
            return this;
        }
    }

    FPointBounds(int i6, FPoint fPoint, FPoint fPoint2) {
        this.mVersionCode = i6;
        this.southwest = fPoint;
        this.northeast = fPoint2;
    }

    private boolean intersect(FPointBounds fPointBounds) {
        FPoint fPoint;
        FPoint fPoint2;
        FPoint fPoint3;
        FPoint fPoint4;
        if (fPointBounds != null && (fPoint = fPointBounds.northeast) != null && (fPoint2 = fPointBounds.southwest) != null && (fPoint3 = this.northeast) != null && (fPoint4 = this.southwest) != null) {
            float f6 = ((PointF) fPoint).x;
            float f7 = ((PointF) fPoint2).x + f6;
            float f8 = ((PointF) fPoint3).x;
            float f9 = ((PointF) fPoint4).x;
            double d6 = (f7 - f8) - f9;
            double d7 = ((f8 - f9) + f6) - f9;
            float f10 = ((PointF) fPoint).y;
            float f11 = ((PointF) fPoint2).y;
            float f12 = ((PointF) fPoint3).y;
            float f13 = ((PointF) fPoint4).y;
            double d8 = ((f10 + f11) - f12) - f13;
            double d9 = ((f12 - f13) + f10) - f11;
            if (Math.abs(d6) < d7 && Math.abs(d8) < d9) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(FPoint fPoint) {
        return containsy((double) ((PointF) fPoint).y) && containsx((double) ((PointF) fPoint).x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FPointBounds)) {
            return false;
        }
        FPointBounds fPointBounds = (FPointBounds) obj;
        return this.southwest.equals(fPointBounds.southwest) && this.northeast.equals(fPointBounds.northeast);
    }

    public boolean intersects(FPointBounds fPointBounds) {
        if (fPointBounds == null) {
            return false;
        }
        return intersect(fPointBounds) || fPointBounds.intersect(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsx(double d6) {
        float f6 = ((PointF) this.southwest).x;
        float f7 = ((PointF) this.northeast).x;
        return f6 <= f7 ? ((double) f6) <= d6 && d6 <= ((double) f7) : ((double) f6) <= d6 || d6 <= ((double) f7);
    }

    private boolean containsy(double d6) {
        return ((double) ((PointF) this.southwest).y) <= d6 && d6 <= ((double) ((PointF) this.northeast).y);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return "southwest = (" + ((PointF) this.southwest).x + "," + ((PointF) this.southwest).y + ") northeast = (" + ((PointF) this.northeast).x + "," + ((PointF) this.northeast).y + ")";
    }

    public boolean contains(FPointBounds fPointBounds) {
        return fPointBounds != null && contains(fPointBounds.southwest) && contains(fPointBounds.northeast);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public FPointBounds(FPoint fPoint, FPoint fPoint2) {
        this(1, fPoint, fPoint2);
    }
}
