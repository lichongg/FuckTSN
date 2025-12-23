package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Pools {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NotNull T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SimplePool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    public static class SimplePool<T> implements Pool<T> {

        @NotNull
        private final Object[] pool;
        private int poolSize;

        private final boolean isInPool(T t5) {
            int i6 = this.poolSize;
            for (int i7 = 0; i7 < i6; i7++) {
                if (this.pool[i7] == t5) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        @Nullable
        public T acquire() {
            int i6 = this.poolSize;
            if (i6 <= 0) {
                return null;
            }
            int i7 = i6 - 1;
            T t5 = (T) this.pool[i7];
            g0.n(t5, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i7] = null;
            this.poolSize--;
            return t5;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NotNull T instance) {
            g0.p(instance, "instance");
            if (isInPool(instance)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i6 = this.poolSize;
            Object[] objArr = this.pool;
            if (i6 >= objArr.length) {
                return false;
            }
            objArr[i6] = instance;
            this.poolSize = i6 + 1;
            return true;
        }

        public SimplePool(@IntRange(from = 1) int i6) {
            if (i6 > 0) {
                this.pool = new Object[i6];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SynchronizedPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    public static class SynchronizedPool<T> extends SimplePool<T> {

        @NotNull
        private final Object lock;

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        @Nullable
        public T acquire() {
            T t5;
            synchronized (this.lock) {
                t5 = (T) super.acquire();
            }
            return t5;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NotNull T instance) {
            boolean release;
            g0.p(instance, "instance");
            synchronized (this.lock) {
                release = super.release(instance);
            }
            return release;
        }

        public SynchronizedPool(int i6) {
            super(i6);
            this.lock = new Object();
        }
    }

    private Pools() {
    }
}
