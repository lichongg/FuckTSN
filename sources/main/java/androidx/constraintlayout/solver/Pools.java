package androidx.constraintlayout.solver;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface Pool<T> {
        T acquire();

        boolean release(T t5);

        void releaseAll(T[] tArr, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SimplePool<T> implements Pool<T> {
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

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i6) {
            if (i6 > tArr.length) {
                i6 = tArr.length;
            }
            for (int i7 = 0; i7 < i6; i7++) {
                T t5 = tArr[i7];
                int i8 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i8 < objArr.length) {
                    objArr[i8] = t5;
                    this.mPoolSize = i8 + 1;
                }
            }
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
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

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T t5) {
            int i6 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i6 >= objArr.length) {
                return false;
            }
            objArr[i6] = t5;
            this.mPoolSize = i6 + 1;
            return true;
        }

        SimplePool(int i6) {
            if (i6 > 0) {
                this.mPool = new Object[i6];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
    }

    private Pools() {
    }
}
