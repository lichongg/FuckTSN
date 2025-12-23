package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() { // from class: com.google.common.util.concurrent.Striped.5
        @Override // com.google.common.base.Supplier
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    };
    private static final Supplier<ReadWriteLock> WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() { // from class: com.google.common.util.concurrent.Striped.6
        @Override // com.google.common.base.Supplier
        public ReadWriteLock get() {
            return new WeakSafeReadWriteLock();
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        private CompactStriped(int i6, Supplier<L> supplier) {
            super(i6);
            int i7 = 0;
            Preconditions.checkArgument(i6 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
            while (true) {
                Object[] objArr = this.array;
                if (i7 >= objArr.length) {
                    return;
                }
                objArr[i7] = supplier.get();
                i7++;
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i6) {
            return (L) this.array[i6];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.array.length;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final Supplier<L> supplier;

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i6) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i6, size());
            }
            L l6 = this.locks.get(Integer.valueOf(i6));
            if (l6 != null) {
                return l6;
            }
            L l7 = this.supplier.get();
            return (L) MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i6), l7), l7);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }

        LargeLazyStriped(int i6, Supplier<L> supplier) {
            super(i6);
            int i7;
            int i8 = this.mask;
            if (i8 == -1) {
                i7 = Integer.MAX_VALUE;
            } else {
                i7 = i8 + 1;
            }
            this.size = i7;
            this.supplier = supplier;
            this.locks = new MapMaker().weakValues().makeMap();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        PaddedLock() {
            super(false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        PaddedSemaphore(int i6) {
            super(i6, false);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue;
        final int size;
        final Supplier<L> supplier;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            ArrayReference(L l6, int i6, ReferenceQueue<L> referenceQueue) {
                super(l6, referenceQueue);
                this.index = i6;
            }
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> poll = this.queue.poll();
                if (poll == null) {
                    return;
                }
                ArrayReference arrayReference = (ArrayReference) poll;
                b.a(this.locks, arrayReference.index, arrayReference, null);
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i6) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i6, size());
            }
            ArrayReference<? extends L> arrayReference = this.locks.get(i6);
            L l6 = arrayReference == null ? null : arrayReference.get();
            if (l6 != null) {
                return l6;
            }
            L l7 = this.supplier.get();
            ArrayReference arrayReference2 = new ArrayReference(l7, i6, this.queue);
            while (!b.a(this.locks, i6, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(i6);
                L l8 = arrayReference == null ? null : arrayReference.get();
                if (l8 != null) {
                    return l8;
                }
            }
            drainQueue();
            return l7;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }

        SmallLazyStriped(int i6, Supplier<L> supplier) {
            super(i6);
            int i7;
            this.queue = new ReferenceQueue<>();
            int i8 = this.mask;
            if (i8 == -1) {
                i7 = Integer.MAX_VALUE;
            } else {
                i7 = i8 + 1;
            }
            this.size = i7;
            this.locks = new AtomicReferenceArray<>(i7);
            this.supplier = supplier;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        @Override // com.google.common.util.concurrent.ForwardingCondition
        Condition delegate() {
            return this.delegate;
        }

        WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        @Override // com.google.common.util.concurrent.ForwardingLock
        Lock delegate() {
            return this.delegate;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }

        WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }

        WeakSafeReadWriteLock() {
        }
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i6);

    abstract int indexFor(Object obj);

    public abstract int size();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        PowerOfTwoStriped(int i6) {
            super();
            Preconditions.checkArgument(i6 > 0, "Stripes must be positive");
            this.mask = i6 > 1073741824 ? -1 : Striped.ceilToPowerOfTwo(i6) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    private Striped() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i6) {
        return 1 << IntMath.log2(i6, RoundingMode.CEILING);
    }

    static <L> Striped<L> custom(int i6, Supplier<L> supplier) {
        return new CompactStriped(i6, supplier);
    }

    private static <L> Striped<L> lazy(int i6, Supplier<L> supplier) {
        return i6 < 1024 ? new SmallLazyStriped(i6, supplier) : new LargeLazyStriped(i6, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i6) {
        return lazy(i6, new Supplier<Lock>() { // from class: com.google.common.util.concurrent.Striped.2
            @Override // com.google.common.base.Supplier
            public Lock get() {
                return new ReentrantLock(false);
            }
        });
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i6) {
        return lazy(i6, WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i6, final int i7) {
        return lazy(i6, new Supplier<Semaphore>() { // from class: com.google.common.util.concurrent.Striped.4
            @Override // com.google.common.base.Supplier
            public Semaphore get() {
                return new Semaphore(i7, false);
            }
        });
    }

    public static Striped<Lock> lock(int i6) {
        return custom(i6, new Supplier<Lock>() { // from class: com.google.common.util.concurrent.Striped.1
            @Override // com.google.common.base.Supplier
            public Lock get() {
                return new PaddedLock();
            }
        });
    }

    public static Striped<ReadWriteLock> readWriteLock(int i6) {
        return custom(i6, READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> semaphore(int i6, final int i7) {
        return custom(i6, new Supplier<Semaphore>() { // from class: com.google.common.util.concurrent.Striped.3
            @Override // com.google.common.base.Supplier
            public Semaphore get() {
                return new PaddedSemaphore(i7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int smear(int i6) {
        int i7 = i6 ^ ((i6 >>> 20) ^ (i6 >>> 12));
        return (i7 >>> 4) ^ ((i7 >>> 7) ^ i7);
    }

    public Iterable<L> bulkGet(Iterable<?> iterable) {
        Object[] array = Iterables.toArray(iterable, Object.class);
        if (array.length == 0) {
            return ImmutableList.of();
        }
        int[] iArr = new int[array.length];
        for (int i6 = 0; i6 < array.length; i6++) {
            iArr[i6] = indexFor(array[i6]);
        }
        Arrays.sort(iArr);
        int i7 = iArr[0];
        array[0] = getAt(i7);
        for (int i8 = 1; i8 < array.length; i8++) {
            int i9 = iArr[i8];
            if (i9 == i7) {
                array[i8] = array[i8 - 1];
            } else {
                array[i8] = getAt(i9);
                i7 = i9;
            }
        }
        return Collections.unmodifiableList(Arrays.asList(array));
    }
}
