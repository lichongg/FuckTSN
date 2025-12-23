package com.autonavi.amap.mapcore;

import com.autonavi.base.ae.gmap.maploader.Pools;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    /* renamed from: x, reason: collision with root package name */
    public double f9903x;

    /* renamed from: y, reason: collision with root package name */
    public double f9904y;

    public DPoint() {
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(0.0d, 0.0d);
        return acquire;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return Double.doubleToLongBits(this.f9903x) == Double.doubleToLongBits(dPoint.f9903x) && Double.doubleToLongBits(this.f9904y) == Double.doubleToLongBits(dPoint.f9904y);
    }

    public DPoint(double d6, double d7) {
        this.f9903x = d6;
        this.f9904y = d7;
    }

    private void set(double d6, double d7) {
        this.f9903x = d6;
        this.f9904y = d7;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public static DPoint obtain(double d6, double d7) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d6, d7);
        }
        acquire.set(d6, d7);
        return acquire;
    }
}
