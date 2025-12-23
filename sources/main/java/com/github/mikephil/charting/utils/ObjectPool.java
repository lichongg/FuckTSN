package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ObjectPool<T extends Poolable> {
    private static int ids;
    private int desiredCapacity;
    private T modelObject;
    private Object[] objects;
    private int objectsPointer;
    private int poolId;
    private float replenishPercentage;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId = NO_OWNER;

        protected abstract Poolable instantiate();
    }

    private void refillPool() {
        refillPool(this.replenishPercentage);
    }

    public synchronized T get() {
        T t5;
        try {
            if (this.objectsPointer == -1 && this.replenishPercentage > 0.0f) {
                refillPool();
            }
            Object[] objArr = this.objects;
            int i6 = this.objectsPointer;
            t5 = (T) objArr[i6];
            t5.currentOwnerId = Poolable.NO_OWNER;
            this.objectsPointer = i6 - 1;
        } catch (Throwable th) {
            throw th;
        }
        return t5;
    }

    public synchronized void recycle(T t5) {
        try {
            int i6 = t5.currentOwnerId;
            if (i6 != Poolable.NO_OWNER) {
                if (i6 == this.poolId) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t5.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            int i7 = this.objectsPointer + 1;
            this.objectsPointer = i7;
            if (i7 >= this.objects.length) {
                resizePool();
            }
            t5.currentOwnerId = this.poolId;
            this.objects[this.objectsPointer] = t5;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized ObjectPool create(int i6, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i6, poolable);
            int i7 = ids;
            objectPool.poolId = i7;
            ids = i7 + 1;
        }
        return objectPool;
    }

    private void refillPool(float f6) {
        int i6 = this.desiredCapacity;
        int i7 = (int) (i6 * f6);
        if (i7 < 1) {
            i6 = 1;
        } else if (i7 <= i6) {
            i6 = i7;
        }
        for (int i8 = 0; i8 < i6; i8++) {
            this.objects[i8] = this.modelObject.instantiate();
        }
        this.objectsPointer = i6 - 1;
    }

    private void resizePool() {
        int i6 = this.desiredCapacity;
        int i7 = i6 * 2;
        this.desiredCapacity = i7;
        Object[] objArr = new Object[i7];
        for (int i8 = 0; i8 < i6; i8++) {
            objArr[i8] = this.objects[i8];
        }
        this.objects = objArr;
    }

    public int getPoolCapacity() {
        return this.objects.length;
    }

    public int getPoolCount() {
        return this.objectsPointer + 1;
    }

    public int getPoolId() {
        return this.poolId;
    }

    public float getReplenishPercentage() {
        return this.replenishPercentage;
    }

    public void setReplenishPercentage(float f6) {
        if (f6 > 1.0f) {
            f6 = 1.0f;
        } else if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        this.replenishPercentage = f6;
    }

    private ObjectPool(int i6, T t5) {
        if (i6 > 0) {
            this.desiredCapacity = i6;
            this.objects = new Object[i6];
            this.objectsPointer = 0;
            this.modelObject = t5;
            this.replenishPercentage = 1.0f;
            refillPool();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public synchronized void recycle(List<T> list) {
        while (list.size() + this.objectsPointer + 1 > this.desiredCapacity) {
            try {
                resizePool();
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            T t5 = list.get(i6);
            int i7 = t5.currentOwnerId;
            if (i7 != Poolable.NO_OWNER) {
                if (i7 == this.poolId) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t5.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            t5.currentOwnerId = this.poolId;
            this.objects[this.objectsPointer + 1 + i6] = t5;
        }
        this.objectsPointer += size;
    }
}
