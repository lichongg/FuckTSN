package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.util.Recycler;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PoolThreadCache {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PoolThreadCache.class);
    private int allocations;
    final PoolArena<ByteBuffer> directArena;
    private final int freeSweepAllocationThreshold;
    private final AtomicBoolean freed = new AtomicBoolean();
    final PoolArena<byte[]> heapArena;
    private final MemoryRegionCache<ByteBuffer>[] normalDirectCaches;
    private final MemoryRegionCache<byte[]>[] normalHeapCaches;
    private final int numShiftsNormalDirect;
    private final int numShiftsNormalHeap;
    private final MemoryRegionCache<ByteBuffer>[] smallSubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] smallSubPageHeapCaches;
    private final MemoryRegionCache<ByteBuffer>[] tinySubPageDirectCaches;
    private final MemoryRegionCache<byte[]>[] tinySubPageHeapCaches;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class MemoryRegionCache<T> {
        private static final Recycler<Entry> RECYCLER = new Recycler<Entry>() { // from class: io.netty.buffer.PoolThreadCache.MemoryRegionCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public Entry newObject(Recycler.Handle<Entry> handle) {
                return new Entry(handle);
            }
        };
        private int allocations;
        private final Queue<Entry<T>> queue;
        private final int size;
        private final PoolArena.SizeClass sizeClass;

        public final int free(boolean z5) {
            return free(Integer.MAX_VALUE, z5);
        }

        protected abstract void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j6, PooledByteBuf<T> pooledByteBuf, int i6);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class Entry<T> {
            PoolChunk<T> chunk;
            long handle = -1;
            ByteBuffer nioBuffer;
            final Recycler.Handle<Entry<?>> recyclerHandle;

            void recycle() {
                this.chunk = null;
                this.nioBuffer = null;
                this.handle = -1L;
                this.recyclerHandle.recycle(this);
            }

            Entry(Recycler.Handle<Entry<?>> handle) {
                this.recyclerHandle = handle;
            }
        }

        private int free(int i6, boolean z5) {
            int i7 = 0;
            while (i7 < i6) {
                Entry<T> poll = this.queue.poll();
                if (poll == null) {
                    break;
                }
                freeEntry(poll, z5);
                i7++;
            }
            return i7;
        }

        private void freeEntry(Entry entry, boolean z5) {
            PoolChunk<T> poolChunk = entry.chunk;
            long j6 = entry.handle;
            ByteBuffer byteBuffer = entry.nioBuffer;
            if (!z5) {
                entry.recycle();
            }
            poolChunk.arena.freeChunk(poolChunk, j6, this.sizeClass, byteBuffer, z5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static Entry newEntry(PoolChunk<?> poolChunk, ByteBuffer byteBuffer, long j6) {
            Entry entry = RECYCLER.get();
            entry.chunk = poolChunk;
            entry.nioBuffer = byteBuffer;
            entry.handle = j6;
            return entry;
        }

        public final boolean allocate(PooledByteBuf<T> pooledByteBuf, int i6) {
            Entry<T> poll = this.queue.poll();
            if (poll == null) {
                return false;
            }
            initBuf(poll.chunk, poll.nioBuffer, poll.handle, pooledByteBuf, i6);
            poll.recycle();
            this.allocations++;
            return true;
        }

        public final void trim() {
            int i6 = this.size - this.allocations;
            this.allocations = 0;
            if (i6 > 0) {
                free(i6, false);
            }
        }

        MemoryRegionCache(int i6, PoolArena.SizeClass sizeClass) {
            int safeFindNextPositivePowerOfTwo = MathUtil.safeFindNextPositivePowerOfTwo(i6);
            this.size = safeFindNextPositivePowerOfTwo;
            this.queue = PlatformDependent.newFixedMpscQueue(safeFindNextPositivePowerOfTwo);
            this.sizeClass = sizeClass;
        }

        public final boolean add(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j6) {
            Entry<T> newEntry = newEntry(poolChunk, byteBuffer, j6);
            boolean offer = this.queue.offer(newEntry);
            if (!offer) {
                newEntry.recycle();
            }
            return offer;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NormalMemoryRegionCache<T> extends MemoryRegionCache<T> {
        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j6, PooledByteBuf<T> pooledByteBuf, int i6) {
            poolChunk.initBuf(pooledByteBuf, byteBuffer, j6, i6);
        }

        NormalMemoryRegionCache(int i6) {
            super(i6, PoolArena.SizeClass.Normal);
        }
    }

    private boolean allocate(MemoryRegionCache<?> memoryRegionCache, PooledByteBuf pooledByteBuf, int i6) {
        if (memoryRegionCache == null) {
            return false;
        }
        boolean allocate = memoryRegionCache.allocate(pooledByteBuf, i6);
        int i7 = this.allocations + 1;
        this.allocations = i7;
        if (i7 >= this.freeSweepAllocationThreshold) {
            this.allocations = 0;
            trim();
        }
        return allocate;
    }

    private MemoryRegionCache<?> cache(PoolArena<?> poolArena, int i6, PoolArena.SizeClass sizeClass) {
        int i7 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
        if (i7 == 1) {
            return cacheForNormal(poolArena, i6);
        }
        if (i7 == 2) {
            return cacheForSmall(poolArena, i6);
        }
        if (i7 == 3) {
            return cacheForTiny(poolArena, i6);
        }
        throw new Error();
    }

    private static int log2(int i6) {
        int i7 = 0;
        while (i6 > 1) {
            i6 >>= 1;
            i7++;
        }
        return i7;
    }

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            free(true);
        }
    }

    void free(boolean z5) {
        if (this.freed.compareAndSet(false, true)) {
            int free = free(this.tinySubPageDirectCaches, z5) + free(this.smallSubPageDirectCaches, z5) + free(this.normalDirectCaches, z5) + free((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches, z5) + free((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches, z5) + free((MemoryRegionCache<?>[]) this.normalHeapCaches, z5);
            if (free > 0) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Freed {} thread-local buffer(s) from thread: {}", Integer.valueOf(free), Thread.currentThread().getName());
                }
            }
            PoolArena<ByteBuffer> poolArena = this.directArena;
            if (poolArena != null) {
                poolArena.numThreadCaches.getAndDecrement();
            }
            PoolArena<byte[]> poolArena2 = this.heapArena;
            if (poolArena2 != null) {
                poolArena2.numThreadCaches.getAndDecrement();
            }
        }
    }

    void trim() {
        trim(this.tinySubPageDirectCaches);
        trim(this.smallSubPageDirectCaches);
        trim(this.normalDirectCaches);
        trim((MemoryRegionCache<?>[]) this.tinySubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.smallSubPageHeapCaches);
        trim((MemoryRegionCache<?>[]) this.normalHeapCaches);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.buffer.PoolThreadCache$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[PoolArena.SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[PoolArena.SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[PoolArena.SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class SubPageMemoryRegionCache<T> extends MemoryRegionCache<T> {
        @Override // io.netty.buffer.PoolThreadCache.MemoryRegionCache
        protected void initBuf(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j6, PooledByteBuf<T> pooledByteBuf, int i6) {
            poolChunk.initBufWithSubpage(pooledByteBuf, byteBuffer, j6, i6);
        }

        SubPageMemoryRegionCache(int i6, PoolArena.SizeClass sizeClass) {
            super(i6, sizeClass);
        }
    }

    private static <T> MemoryRegionCache<T>[] createNormalCaches(int i6, int i7, PoolArena<T> poolArena) {
        if (i6 <= 0 || i7 <= 0) {
            return null;
        }
        int max = Math.max(1, log2(Math.min(poolArena.chunkSize, i7) / poolArena.pageSize) + 1);
        MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[max];
        for (int i8 = 0; i8 < max; i8++) {
            memoryRegionCacheArr[i8] = new NormalMemoryRegionCache(i6);
        }
        return memoryRegionCacheArr;
    }

    private static <T> MemoryRegionCache<T>[] createSubPageCaches(int i6, int i7, PoolArena.SizeClass sizeClass) {
        if (i6 <= 0 || i7 <= 0) {
            return null;
        }
        MemoryRegionCache<T>[] memoryRegionCacheArr = new MemoryRegionCache[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            memoryRegionCacheArr[i8] = new SubPageMemoryRegionCache(i6, sizeClass);
        }
        return memoryRegionCacheArr;
    }

    PoolThreadCache(PoolArena<byte[]> poolArena, PoolArena<ByteBuffer> poolArena2, int i6, int i7, int i8, int i9, int i10) {
        ObjectUtil.checkPositiveOrZero(i9, "maxCachedBufferCapacity");
        this.freeSweepAllocationThreshold = i10;
        this.heapArena = poolArena;
        this.directArena = poolArena2;
        if (poolArena2 != null) {
            this.tinySubPageDirectCaches = createSubPageCaches(i6, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageDirectCaches = createSubPageCaches(i7, poolArena2.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalDirect = log2(poolArena2.pageSize);
            this.normalDirectCaches = createNormalCaches(i8, i9, poolArena2);
            poolArena2.numThreadCaches.getAndIncrement();
        } else {
            this.tinySubPageDirectCaches = null;
            this.smallSubPageDirectCaches = null;
            this.normalDirectCaches = null;
            this.numShiftsNormalDirect = -1;
        }
        if (poolArena != null) {
            this.tinySubPageHeapCaches = createSubPageCaches(i6, 32, PoolArena.SizeClass.Tiny);
            this.smallSubPageHeapCaches = createSubPageCaches(i7, poolArena.numSmallSubpagePools, PoolArena.SizeClass.Small);
            this.numShiftsNormalHeap = log2(poolArena.pageSize);
            this.normalHeapCaches = createNormalCaches(i8, i9, poolArena);
            poolArena.numThreadCaches.getAndIncrement();
        } else {
            this.tinySubPageHeapCaches = null;
            this.smallSubPageHeapCaches = null;
            this.normalHeapCaches = null;
            this.numShiftsNormalHeap = -1;
        }
        if ((this.tinySubPageDirectCaches == null && this.smallSubPageDirectCaches == null && this.normalDirectCaches == null && this.tinySubPageHeapCaches == null && this.smallSubPageHeapCaches == null && this.normalHeapCaches == null) || i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException("freeSweepAllocationThreshold: " + i10 + " (expected: > 0)");
    }

    private MemoryRegionCache<?> cacheForNormal(PoolArena<?> poolArena, int i6) {
        if (poolArena.isDirect()) {
            return cache(this.normalDirectCaches, log2(i6 >> this.numShiftsNormalDirect));
        }
        return cache(this.normalHeapCaches, log2(i6 >> this.numShiftsNormalHeap));
    }

    private MemoryRegionCache<?> cacheForSmall(PoolArena<?> poolArena, int i6) {
        int smallIdx = PoolArena.smallIdx(i6);
        if (poolArena.isDirect()) {
            return cache(this.smallSubPageDirectCaches, smallIdx);
        }
        return cache(this.smallSubPageHeapCaches, smallIdx);
    }

    private MemoryRegionCache<?> cacheForTiny(PoolArena<?> poolArena, int i6) {
        int tinyIdx = PoolArena.tinyIdx(i6);
        if (poolArena.isDirect()) {
            return cache(this.tinySubPageDirectCaches, tinyIdx);
        }
        return cache(this.tinySubPageHeapCaches, tinyIdx);
    }

    boolean add(PoolArena<?> poolArena, PoolChunk poolChunk, ByteBuffer byteBuffer, long j6, int i6, PoolArena.SizeClass sizeClass) {
        MemoryRegionCache<?> cache = cache(poolArena, i6, sizeClass);
        if (cache == null) {
            return false;
        }
        return cache.add(poolChunk, byteBuffer, j6);
    }

    boolean allocateNormal(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i6, int i7) {
        return allocate(cacheForNormal(poolArena, i7), pooledByteBuf, i6);
    }

    boolean allocateSmall(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i6, int i7) {
        return allocate(cacheForSmall(poolArena, i7), pooledByteBuf, i6);
    }

    boolean allocateTiny(PoolArena<?> poolArena, PooledByteBuf<?> pooledByteBuf, int i6, int i7) {
        return allocate(cacheForTiny(poolArena, i7), pooledByteBuf, i6);
    }

    private static <T> MemoryRegionCache<T> cache(MemoryRegionCache<T>[] memoryRegionCacheArr, int i6) {
        if (memoryRegionCacheArr == null || i6 > memoryRegionCacheArr.length - 1) {
            return null;
        }
        return memoryRegionCacheArr[i6];
    }

    private static void trim(MemoryRegionCache<?>[] memoryRegionCacheArr) {
        if (memoryRegionCacheArr == null) {
            return;
        }
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            trim(memoryRegionCache);
        }
    }

    private static void trim(MemoryRegionCache<?> memoryRegionCache) {
        if (memoryRegionCache == null) {
            return;
        }
        memoryRegionCache.trim();
    }

    private static int free(MemoryRegionCache<?>[] memoryRegionCacheArr, boolean z5) {
        if (memoryRegionCacheArr == null) {
            return 0;
        }
        int i6 = 0;
        for (MemoryRegionCache<?> memoryRegionCache : memoryRegionCacheArr) {
            i6 += free(memoryRegionCache, z5);
        }
        return i6;
    }

    private static int free(MemoryRegionCache<?> memoryRegionCache, boolean z5) {
        if (memoryRegionCache == null) {
            return 0;
        }
        return memoryRegionCache.free(z5);
    }
}
