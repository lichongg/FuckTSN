package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IPoint extends Point implements Cloneable {
    private static final Pools.SynchronizedPool<IPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public IPoint() {
    }

    public static IPoint obtain() {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint();
        }
        acquire.set(0, 0);
        return acquire;
    }

    public IPoint(int i6, int i7) {
        ((Point) this).x = i6;
        ((Point) this).y = i7;
    }

    public double distance(IPoint iPoint) {
        return Math.sqrt(Math.pow(((Point) iPoint).x - ((Point) this).x, 2.0d) + Math.pow(((Point) iPoint).y - ((Point) this).y, 2.0d));
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static IPoint obtain(int i6, int i7) {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint(i6, i7);
        }
        acquire.set(i6, i7);
        return acquire;
    }
}
