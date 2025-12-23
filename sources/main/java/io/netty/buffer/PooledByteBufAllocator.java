package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThreadExecutorMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class PooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final PooledByteBufAllocator DEFAULT;
    private static final int DEFAULT_CACHE_TRIM_INTERVAL;
    private static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    private static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final int DEFAULT_TINY_CACHE_SIZE;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PooledByteBufAllocator.class);
    private final int chunkSize;
    private final List<PoolArenaMetric> directArenaMetrics;
    private final PoolArena<ByteBuffer>[] directArenas;
    private final List<PoolArenaMetric> heapArenaMetrics;
    private final PoolArena<byte[]>[] heapArenas;
    private final PooledByteBufAllocatorMetric metric;
    private final int normalCacheSize;
    private final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    private final int tinyCacheSize;
    private final Runnable trimTask;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        PoolThreadLocalCache(boolean z5) {
            this.useCacheForAllThreads = z5;
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] poolArenaArr) {
            if (poolArenaArr == null || poolArenaArr.length == 0) {
                return null;
            }
            PoolArena<T> poolArena = poolArenaArr[0];
            for (int i6 = 1; i6 < poolArenaArr.length; i6++) {
                PoolArena<T> poolArena2 = poolArenaArr[i6];
                if (poolArena2.numThreadCaches.get() < poolArena.numThreadCaches.get()) {
                    poolArena = poolArena2;
                }
            }
            return poolArena;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public synchronized PoolThreadCache initialValue() {
            EventExecutor currentExecutor;
            PoolArena leastUsedArena = leastUsedArena(PooledByteBufAllocator.this.heapArenas);
            PoolArena leastUsedArena2 = leastUsedArena(PooledByteBufAllocator.this.directArenas);
            Thread currentThread = Thread.currentThread();
            if (!this.useCacheForAllThreads && !(currentThread instanceof FastThreadLocalThread)) {
                return new PoolThreadCache(leastUsedArena, leastUsedArena2, 0, 0, 0, 0, 0);
            }
            PoolThreadCache poolThreadCache = new PoolThreadCache(leastUsedArena, leastUsedArena2, PooledByteBufAllocator.this.tinyCacheSize, PooledByteBufAllocator.this.smallCacheSize, PooledByteBufAllocator.this.normalCacheSize, PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL);
            if (PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS > 0 && (currentExecutor = ThreadExecutorMap.currentExecutor()) != null) {
                currentExecutor.scheduleAtFixedRate(PooledByteBufAllocator.this.trimTask, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS, TimeUnit.MILLISECONDS);
            }
            return poolThreadCache;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free(false);
        }
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    static {
        Object obj;
        int i6 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Object obj2 = null;
        try {
            validateAndCalculatePageShifts(i6);
            obj = null;
        } catch (Throwable th) {
            obj = th;
            i6 = 8192;
        }
        DEFAULT_PAGE_SIZE = i6;
        int i7 = 11;
        int i8 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 11);
        try {
            validateAndCalculateChunkSize(i6, i8);
            i7 = i8;
        } catch (Throwable th2) {
            obj2 = th2;
        }
        DEFAULT_MAX_ORDER = i7;
        Runtime runtime = Runtime.getRuntime();
        int availableProcessors = NettyRuntime.availableProcessors() * 2;
        int i9 = DEFAULT_PAGE_SIZE;
        long j6 = availableProcessors;
        long j7 = i9 << i7;
        int max = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(j6, ((runtime.maxMemory() / j7) / 2) / 3)));
        DEFAULT_NUM_HEAP_ARENA = max;
        int max2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(j6, ((PlatformDependent.maxDirectMemory() / j7) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = max2;
        int i10 = SystemPropertyUtil.getInt("io.netty.allocator.tinyCacheSize", 512);
        DEFAULT_TINY_CACHE_SIZE = i10;
        int i11 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_SMALL_CACHE_SIZE = i11;
        int i12 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_NORMAL_CACHE_SIZE = i12;
        int i13 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = i13;
        int i14 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        DEFAULT_CACHE_TRIM_INTERVAL = i14;
        long j8 = SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0L);
        DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = j8;
        boolean z5 = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", true);
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = z5;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int i15 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = i15;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.allocator.numHeapArenas: {}", Integer.valueOf(max));
            internalLogger.debug("-Dio.netty.allocator.numDirectArenas: {}", Integer.valueOf(max2));
            if (obj == null) {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i9));
            } else {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i9), obj);
            }
            if (obj2 == null) {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i7));
            } else {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i7), obj2);
            }
            internalLogger.debug("-Dio.netty.allocator.chunkSize: {}", Integer.valueOf(i9 << i7));
            internalLogger.debug("-Dio.netty.allocator.tinyCacheSize: {}", Integer.valueOf(i10));
            internalLogger.debug("-Dio.netty.allocator.smallCacheSize: {}", Integer.valueOf(i11));
            internalLogger.debug("-Dio.netty.allocator.normalCacheSize: {}", Integer.valueOf(i12));
            internalLogger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", Integer.valueOf(i13));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", Integer.valueOf(i14));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", Long.valueOf(j8));
            internalLogger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", Boolean.valueOf(z5));
            internalLogger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", Integer.valueOf(i15));
        }
        DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    }

    public PooledByteBufAllocator(boolean z5) {
        this(z5, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    public static int defaultTinyCacheSize() {
        return DEFAULT_TINY_CACHE_SIZE;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    private static <T> PoolArena<T>[] newArenaArray(int i6) {
        return new PoolArena[i6];
    }

    private static long usedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1L;
        }
        long j6 = 0;
        for (PoolArena<?> poolArena : poolArenaArr) {
            j6 += poolArena.numActiveBytes();
            if (j6 < 0) {
                return Long.MAX_VALUE;
            }
        }
        return j6;
    }

    private static int validateAndCalculateChunkSize(int i6, int i7) {
        if (i7 > 14) {
            throw new IllegalArgumentException("maxOrder: " + i7 + " (expected: 0-14)");
        }
        int i8 = i6;
        for (int i9 = i7; i9 > 0; i9--) {
            if (i8 > 536870912) {
                throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", Integer.valueOf(i6), Integer.valueOf(i7), 1073741824));
            }
            i8 <<= 1;
        }
        return i8;
    }

    private static int validateAndCalculatePageShifts(int i6) {
        if (i6 >= 4096) {
            if (((i6 - 1) & i6) == 0) {
                return 31 - Integer.numberOfLeadingZeros(i6);
            }
            throw new IllegalArgumentException("pageSize: " + i6 + " (expected: power of 2)");
        }
        throw new IllegalArgumentException("pageSize: " + i6 + " (expected: 4096)");
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Deprecated
    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    public String dumpStats() {
        PoolArena<byte[]>[] poolArenaArr = this.heapArenas;
        int length = poolArenaArr == null ? 0 : poolArenaArr.length;
        StringBuilder sb = new StringBuilder(512);
        sb.append(length);
        sb.append(" heap arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length > 0) {
            for (PoolArena<byte[]> poolArena : this.heapArenas) {
                sb.append(poolArena);
            }
        }
        PoolArena<ByteBuffer>[] poolArenaArr2 = this.directArenas;
        int length2 = poolArenaArr2 == null ? 0 : poolArenaArr2.length;
        sb.append(length2);
        sb.append(" direct arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length2 > 0) {
            for (PoolArena<ByteBuffer> poolArena2 : this.directArenas) {
                sb.append(poolArena2);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    @Override // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    @Override // io.netty.buffer.ByteBufAllocatorMetricProvider
    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newDirectBuffer(int i6, int i7) {
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<ByteBuffer> poolArena = poolThreadCache.directArena;
        return AbstractByteBufAllocator.toLeakAwareBuffer(poolArena != null ? poolArena.allocate(poolThreadCache, i6, i7) : PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i6, i7) : new UnpooledDirectByteBuf(this, i6, i7));
    }

    @Override // io.netty.buffer.AbstractByteBufAllocator
    protected ByteBuf newHeapBuffer(int i6, int i7) {
        AbstractByteBuf unpooledUnsafeHeapByteBuf;
        PoolThreadCache poolThreadCache = this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            unpooledUnsafeHeapByteBuf = poolArena.allocate(poolThreadCache, i6, i7);
        } else {
            unpooledUnsafeHeapByteBuf = PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i6, i7) : new UnpooledHeapByteBuf(this, i6, i7);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer(unpooledUnsafeHeapByteBuf);
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas;
        if (poolArenaArr == null) {
            poolArenaArr = this.directArenas;
        }
        if (poolArenaArr == null) {
            return 0;
        }
        int i6 = 0;
        for (PoolArena poolArena : poolArenaArr) {
            i6 += poolArena.numThreadCaches.get();
        }
        return i6;
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    final PoolThreadCache threadCache() {
        return this.threadCache.get();
    }

    @Deprecated
    public int tinyCacheSize() {
        return this.tinyCacheSize;
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache ifExists = this.threadCache.getIfExists();
        if (ifExists == null) {
            return false;
        }
        ifExists.trim();
        return true;
    }

    final long usedDirectMemory() {
        return usedMemory(this.directArenas);
    }

    final long usedHeapMemory() {
        return usedMemory(this.heapArenas);
    }

    public PooledByteBufAllocator(int i6, int i7, int i8, int i9) {
        this(false, i6, i7, i8, i9);
    }

    public static boolean defaultPreferDirect() {
        return PlatformDependent.directBufferPreferred();
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z5, int i6, int i7, int i8, int i9) {
        this(z5, i6, i7, i8, i9, DEFAULT_TINY_CACHE_SIZE, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this(z5, i6, i7, i8, i9, i10, i11, i12, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    public PooledByteBufAllocator(boolean z5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z6) {
        this(z5, i6, i7, i8, i9, i10, i11, i12, z6, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    public PooledByteBufAllocator(boolean z5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z6, int i13) {
        super(z5);
        int i14;
        int i15;
        int i16;
        int i17;
        PooledByteBufAllocator pooledByteBufAllocator;
        PooledByteBufAllocator pooledByteBufAllocator2;
        this.trimTask = new Runnable() { // from class: io.netty.buffer.PooledByteBufAllocator.1
            @Override // java.lang.Runnable
            public void run() {
                PooledByteBufAllocator.this.trimCurrentThreadCache();
            }
        };
        this.threadCache = new PoolThreadLocalCache(z6);
        this.tinyCacheSize = i10;
        this.smallCacheSize = i11;
        this.normalCacheSize = i12;
        this.chunkSize = validateAndCalculateChunkSize(i8, i9);
        ObjectUtil.checkPositiveOrZero(i6, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(i7, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(i13, "directMemoryCacheAlignment");
        if (i13 > 0 && !isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        }
        if (((-i13) & i13) == i13) {
            int validateAndCalculatePageShifts = validateAndCalculatePageShifts(i8);
            int i18 = 0;
            if (i6 > 0) {
                PoolArena<byte[]>[] newArenaArray = newArenaArray(i6);
                this.heapArenas = newArenaArray;
                ArrayList arrayList = new ArrayList(newArenaArray.length);
                int i19 = 0;
                while (i19 < this.heapArenas.length) {
                    int i20 = validateAndCalculatePageShifts;
                    int i21 = i8;
                    int i22 = i9;
                    PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i21, i22, i20, this.chunkSize, i13);
                    this.heapArenas[i19] = heapArena;
                    arrayList.add(heapArena);
                    i19++;
                    validateAndCalculatePageShifts = i20;
                    i8 = i21;
                    i9 = i22;
                    i13 = i13;
                }
                int i23 = validateAndCalculatePageShifts;
                i14 = i8;
                i15 = i23;
                i16 = i9;
                i17 = i13;
                pooledByteBufAllocator = this;
                pooledByteBufAllocator.heapArenaMetrics = Collections.unmodifiableList(arrayList);
            } else {
                i14 = i8;
                i15 = validateAndCalculatePageShifts;
                i16 = i9;
                i17 = i13;
                pooledByteBufAllocator = this;
                pooledByteBufAllocator.heapArenas = null;
                pooledByteBufAllocator.heapArenaMetrics = Collections.EMPTY_LIST;
            }
            if (i7 > 0) {
                PoolArena<ByteBuffer>[] newArenaArray2 = newArenaArray(i7);
                pooledByteBufAllocator.directArenas = newArenaArray2;
                ArrayList arrayList2 = new ArrayList(newArenaArray2.length);
                while (i18 < pooledByteBufAllocator.directArenas.length) {
                    PooledByteBufAllocator pooledByteBufAllocator3 = pooledByteBufAllocator;
                    int i24 = i16;
                    int i25 = i14;
                    int i26 = i15;
                    PoolArena.DirectArena directArena = new PoolArena.DirectArena(pooledByteBufAllocator3, i25, i24, i26, pooledByteBufAllocator3.chunkSize, i17);
                    i14 = i25;
                    i15 = i26;
                    pooledByteBufAllocator3.directArenas[i18] = directArena;
                    arrayList2.add(directArena);
                    i18++;
                    i16 = i24;
                    pooledByteBufAllocator = pooledByteBufAllocator3;
                }
                pooledByteBufAllocator2 = pooledByteBufAllocator;
                pooledByteBufAllocator2.directArenaMetrics = Collections.unmodifiableList(arrayList2);
            } else {
                pooledByteBufAllocator2 = pooledByteBufAllocator;
                pooledByteBufAllocator2.directArenas = null;
                pooledByteBufAllocator2.directArenaMetrics = Collections.EMPTY_LIST;
            }
            pooledByteBufAllocator2.metric = new PooledByteBufAllocatorMetric(this);
            return;
        }
        throw new IllegalArgumentException("directMemoryCacheAlignment: " + i13 + " (expected: power of two)");
    }
}
