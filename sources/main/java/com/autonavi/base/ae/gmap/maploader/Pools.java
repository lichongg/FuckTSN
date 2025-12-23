package com.autonavi.base.ae.gmap.maploader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class Pools {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        private boolean isInPool(T t5) {
            for (int i6 = 0; i6 < this.mPoolSize; i6++) {
                if (this.mPool[i6] == t5) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int i6 = 0;
            while (true) {
                Object[] objArr = this.mPool;
                if (i6 >= objArr.length) {
                    return;
                }
                objArr[i6] = null;
                i6++;
            }
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int i6 = this.mPoolSize;
            if (i6 <= 0) {
                return null;
            }
            int i7 = i6 - 1;
            Object[] objArr = this.mPool;
            T t5 = (T) objArr[i7];
            objArr[i7] = null;
            this.mPoolSize = i6 - 1;
            return t5;
        }

        public SimplePool(int i6) {
            if (i6 > 0) {
                this.mPool = new Object[i6];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T t5) {
            if (!isInPool(t5)) {
                int i6 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i6 < objArr.length) {
                    objArr[i6] = t5;
                    this.mPoolSize = i6 + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            T t5;
            synchronized (this.mLock) {
                t5 = (T) super.acquire();
            }
            return t5;
        }

        @Override // com.autonavi.base.ae.gmap.maploader.Pools.SimplePool, com.autonavi.base.ae.gmap.maploader.Pools.Pool
        public boolean release(T t5) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t5);
            }
            return release;
        }

        public SynchronizedPool(int i6) {
            super(i6);
            this.mLock = new Object();
        }
    }

    private Pools() {
    }
}
