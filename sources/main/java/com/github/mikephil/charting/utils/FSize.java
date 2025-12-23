package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class FSize extends ObjectPool.Poolable {
    private static ObjectPool<FSize> pool;
    public float height;
    public float width;

    public FSize() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof FSize) {
            FSize fSize = (FSize) obj;
            if (this.width == fSize.width && this.height == fSize.height) {
                return true;
            }
        }
        return false;
    }

    static {
        ObjectPool<FSize> create = ObjectPool.create(256, new FSize(0.0f, 0.0f));
        pool = create;
        create.setReplenishPercentage(0.5f);
    }

    public FSize(float f6, float f7) {
        this.width = f6;
        this.height = f7;
    }

    public static FSize getInstance(float f6, float f7) {
        FSize fSize = pool.get();
        fSize.width = f6;
        fSize.height = f7;
        return fSize;
    }

    public static void recycleInstance(FSize fSize) {
        pool.recycle((ObjectPool<FSize>) fSize);
    }

    public static void recycleInstances(List<FSize> list) {
        pool.recycle(list);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.width) ^ Float.floatToIntBits(this.height);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new FSize(0.0f, 0.0f);
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}
