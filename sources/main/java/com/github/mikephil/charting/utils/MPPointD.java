package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> pool;

    /* renamed from: x, reason: collision with root package name */
    public double f32563x;

    /* renamed from: y, reason: collision with root package name */
    public double f32564y;

    static {
        ObjectPool<MPPointD> create = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public static MPPointD getInstance(double d6, double d7) {
        MPPointD mPPointD = pool.get();
        mPPointD.f32563x = d6;
        mPPointD.f32564y = d7;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        pool.recycle((ObjectPool<MPPointD>) mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        pool.recycle(list);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.f32563x + ", y: " + this.f32564y;
    }

    private MPPointD(double d6, double d7) {
        this.f32563x = d6;
        this.f32564y = d7;
    }
}
