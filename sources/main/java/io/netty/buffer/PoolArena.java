package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class PoolArena<T> implements PoolArenaMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    static final int numTinySubpagePools = 32;
    private long allocationsNormal;
    private final List<PoolChunkListMetric> chunkListMetrics;
    final int chunkSize;
    private long deallocationsNormal;
    private long deallocationsSmall;
    private long deallocationsTiny;
    final int directMemoryCacheAlignment;
    final int directMemoryCacheAlignmentMask;
    private final int maxOrder;
    final int numSmallSubpagePools;
    final int pageShifts;
    final int pageSize;
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    private final PoolSubpage<T>[] smallSubpagePools;
    final int subpageOverflowMask;
    private final LongCounter allocationsTiny = PlatformDependent.newLongCounter();
    private final LongCounter allocationsSmall = PlatformDependent.newLongCounter();
    private final LongCounter allocationsHuge = PlatformDependent.newLongCounter();
    private final LongCounter activeBytesHuge = PlatformDependent.newLongCounter();
    private final LongCounter deallocationsHuge = PlatformDependent.newLongCounter();
    final AtomicInteger numThreadCaches = new AtomicInteger();
    private final PoolSubpage<T>[] tinySubpagePools = newSubpagePoolArray(32);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class DirectArena extends PoolArena<ByteBuffer> {
        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(ByteBuffer byteBuffer, int i6, ByteBuffer byteBuffer2, int i7, int i8) {
            if (i8 == 0) {
                return;
            }
            if (PoolArena.HAS_UNSAFE) {
                PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + i6, PlatformDependent.directBufferAddress(byteBuffer2) + i7, i8);
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer2.duplicate();
            duplicate.position(i6).limit(i6 + i8);
            duplicate2.position(i7);
            duplicate2.put(duplicate);
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<ByteBuffer> newByteBuf(int i6) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeDirectByteBuf.newInstance(i6) : PooledDirectByteBuf.newInstance(i6);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newChunk(int i6, int i7, int i8, int i9) {
            int i10 = this.directMemoryCacheAlignment;
            if (i10 == 0) {
                return new PoolChunk<>(this, allocateDirect(i9), i6, i7, i8, i9, 0);
            }
            ByteBuffer allocateDirect = allocateDirect(i10 + i9);
            return new PoolChunk<>(this, allocateDirect, i6, i7, i8, i9, offsetCacheLine(allocateDirect));
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<ByteBuffer> newUnpooledChunk(int i6) {
            int i7 = this.directMemoryCacheAlignment;
            if (i7 == 0) {
                return new PoolChunk<>(this, allocateDirect(i6), i6, 0);
            }
            ByteBuffer allocateDirect = allocateDirect(i7 + i6);
            return new PoolChunk<>(this, allocateDirect, i6, offsetCacheLine(allocateDirect));
        }

        int offsetCacheLine(ByteBuffer byteBuffer) {
            return this.directMemoryCacheAlignment - (PoolArena.HAS_UNSAFE ? (int) (PlatformDependent.directBufferAddress(byteBuffer) & this.directMemoryCacheAlignmentMask) : 0);
        }

        DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i6, int i7, int i8, int i9, int i10) {
            super(pooledByteBufAllocator, i6, i7, i8, i9, i10);
        }

        private static ByteBuffer allocateDirect(int i6) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                return PlatformDependent.allocateDirectNoCleaner(i6);
            }
            return ByteBuffer.allocateDirect(i6);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner(poolChunk.memory);
            } else {
                PlatformDependent.freeDirectBuffer(poolChunk.memory);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class HeapArena extends PoolArena<byte[]> {
        @Override // io.netty.buffer.PoolArena
        boolean isDirect() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.buffer.PoolArena
        public void memoryCopy(byte[] bArr, int i6, byte[] bArr2, int i7, int i8) {
            if (i8 == 0) {
                return;
            }
            System.arraycopy(bArr, i6, bArr2, i7, i8);
        }

        @Override // io.netty.buffer.PoolArena
        protected PooledByteBuf<byte[]> newByteBuf(int i6) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i6) : PooledHeapByteBuf.newInstance(i6);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newChunk(int i6, int i7, int i8, int i9) {
            return new PoolChunk<>(this, newByteArray(i9), i6, i7, i8, i9, 0);
        }

        @Override // io.netty.buffer.PoolArena
        protected PoolChunk<byte[]> newUnpooledChunk(int i6) {
            return new PoolChunk<>(this, newByteArray(i6), i6, 0);
        }

        HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i6, int i7, int i8, int i9, int i10) {
            super(pooledByteBufAllocator, i6, i7, i8, i9, i10);
        }

        private static byte[] newByteArray(int i6) {
            return PlatformDependent.allocateUninitializedArray(i6);
        }

        @Override // io.netty.buffer.PoolArena
        protected void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum SizeClass {
        Tiny,
        Small,
        Normal
    }

    private static void appendPoolSubPages(StringBuilder sb, PoolSubpage<?>[] poolSubpageArr) {
        for (int i6 = 0; i6 < poolSubpageArr.length; i6++) {
            PoolSubpage<?> poolSubpage = poolSubpageArr[i6];
            if (poolSubpage.next != poolSubpage) {
                sb.append(StringUtil.NEWLINE);
                sb.append(i6);
                sb.append(": ");
                PoolSubpage poolSubpage2 = poolSubpage.next;
                do {
                    sb.append(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
    }

    private void destroyPoolChunkLists(PoolChunkList<T>... poolChunkListArr) {
        for (PoolChunkList<T> poolChunkList : poolChunkListArr) {
            poolChunkList.destroy(this);
        }
    }

    private static void destroyPoolSubPages(PoolSubpage<?>[] poolSubpageArr) {
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            poolSubpage.destroy();
        }
    }

    PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i6, int i7) {
        PooledByteBuf<T> newByteBuf = newByteBuf(i7);
        allocate(poolThreadCache, newByteBuf, i6);
        return newByteBuf;
    }

    protected abstract void destroyChunk(PoolChunk<T> poolChunk);

    protected final void finalize() throws Throwable {
        try {
            super.finalize();
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolSubPages(this.tinySubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
        } catch (Throwable th) {
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolSubPages(this.tinySubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
            throw th;
        }
    }

    void freeChunk(PoolChunk<T> poolChunk, long j6, SizeClass sizeClass, ByteBuffer byteBuffer, boolean z5) {
        boolean free;
        synchronized (this) {
            if (!z5) {
                try {
                    int i6 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
                    if (i6 == 1) {
                        this.deallocationsNormal++;
                    } else if (i6 == 2) {
                        this.deallocationsSmall++;
                    } else {
                        if (i6 != 3) {
                            throw new Error();
                        }
                        this.deallocationsTiny++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            free = poolChunk.parent.free(poolChunk, j6, byteBuffer);
        }
        if (free) {
            return;
        }
        destroyChunk(poolChunk);
    }

    abstract boolean isDirect();

    protected abstract void memoryCopy(T t5, int i6, T t6, int i7, int i8);

    protected abstract PooledByteBuf<T> newByteBuf(int i6);

    protected abstract PoolChunk<T> newChunk(int i6, int i7, int i8, int i9);

    protected abstract PoolChunk<T> newUnpooledChunk(int i6);

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveNormalAllocations() {
        long j6;
        synchronized (this) {
            j6 = this.allocationsNormal - this.deallocationsNormal;
        }
        return Math.max(j6, 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numAllocations() {
        long j6;
        synchronized (this) {
            j6 = this.allocationsNormal;
        }
        return this.allocationsTiny.value() + this.allocationsSmall.value() + j6 + this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numDeallocations() {
        long j6;
        synchronized (this) {
            j6 = this.deallocationsTiny + this.deallocationsSmall + this.deallocationsNormal;
        }
        return j6 + this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numNormalAllocations() {
        return this.allocationsNormal;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numNormalDeallocations() {
        return this.deallocationsNormal;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numSmallDeallocations() {
        return this.deallocationsSmall;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public synchronized long numTinyDeallocations() {
        return this.deallocationsTiny;
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Chunk(s) at 0~25%:");
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append(this.qInit);
        sb.append(str);
        sb.append("Chunk(s) at 0~50%:");
        sb.append(str);
        sb.append(this.q000);
        sb.append(str);
        sb.append("Chunk(s) at 25~75%:");
        sb.append(str);
        sb.append(this.q025);
        sb.append(str);
        sb.append("Chunk(s) at 50~100%:");
        sb.append(str);
        sb.append(this.q050);
        sb.append(str);
        sb.append("Chunk(s) at 75~100%:");
        sb.append(str);
        sb.append(this.q075);
        sb.append(str);
        sb.append("Chunk(s) at 100%:");
        sb.append(str);
        sb.append(this.q100);
        sb.append(str);
        sb.append("tiny subpages:");
        appendPoolSubPages(sb, this.tinySubpagePools);
        sb.append(str);
        sb.append("small subpages:");
        appendPoolSubPages(sb, this.smallSubpagePools);
        sb.append(str);
        return sb.toString();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.buffer.PoolArena$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        static {
            int[] iArr = new int[SizeClass.values().length];
            $SwitchMap$io$netty$buffer$PoolArena$SizeClass = iArr;
            try {
                iArr[SizeClass.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass[SizeClass.Tiny.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i6, int i7) {
        if (this.q050.allocate(pooledByteBuf, i6, i7) || this.q025.allocate(pooledByteBuf, i6, i7) || this.q000.allocate(pooledByteBuf, i6, i7) || this.qInit.allocate(pooledByteBuf, i6, i7) || this.q075.allocate(pooledByteBuf, i6, i7)) {
            return;
        }
        PoolChunk<T> newChunk = newChunk(this.pageSize, this.maxOrder, this.pageShifts, this.chunkSize);
        newChunk.allocate(pooledByteBuf, i6, i7);
        this.qInit.add(newChunk);
    }

    private void incTinySmallAllocation(boolean z5) {
        if (z5) {
            this.allocationsTiny.increment();
        } else {
            this.allocationsSmall.increment();
        }
    }

    static boolean isTiny(int i6) {
        return (i6 & (-512)) == 0;
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i6) {
        return new PoolSubpage[i6];
    }

    private PoolSubpage<T> newSubpagePoolHead(int i6) {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>(i6);
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    static int smallIdx(int i6) {
        int i7 = i6 >>> 10;
        int i8 = 0;
        while (i7 != 0) {
            i7 >>>= 1;
            i8++;
        }
        return i8;
    }

    private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] poolSubpageArr) {
        ArrayList arrayList = new ArrayList();
        for (PoolSubpage<?> poolSubpage : poolSubpageArr) {
            PoolSubpage poolSubpage2 = poolSubpage.next;
            if (poolSubpage2 != poolSubpage) {
                do {
                    arrayList.add(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
        return arrayList;
    }

    static int tinyIdx(int i6) {
        return i6 >>> 4;
    }

    int alignCapacity(int i6) {
        int i7 = this.directMemoryCacheAlignmentMask & i6;
        return i7 == 0 ? i6 : (i6 + this.directMemoryCacheAlignment) - i7;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    void free(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j6, int i6, PoolThreadCache poolThreadCache) {
        if (poolChunk.unpooled) {
            int chunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add(-chunkSize);
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(i6);
        if (poolThreadCache != null) {
            boolean add = poolThreadCache.add(this, poolChunk, byteBuffer, j6, i6, sizeClass);
            sizeClass = sizeClass;
            if (add) {
                return;
            }
        }
        freeChunk(poolChunk, j6, sizeClass, byteBuffer, false);
    }

    boolean isTinyOrSmall(int i6) {
        return (i6 & this.subpageOverflowMask) == 0;
    }

    int normalizeCapacity(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "reqCapacity");
        if (i6 >= this.chunkSize) {
            if (this.directMemoryCacheAlignment != 0) {
                return alignCapacity(i6);
            }
        } else {
            if (!isTiny(i6)) {
                int i7 = i6 - 1;
                int i8 = i7 | (i7 >>> 1);
                int i9 = i8 | (i8 >>> 2);
                int i10 = i9 | (i9 >>> 4);
                int i11 = i10 | (i10 >>> 8);
                int i12 = (i11 | (i11 >>> 16)) + 1;
                return i12 < 0 ? i12 >>> 1 : i12;
            }
            if (this.directMemoryCacheAlignment > 0) {
                return alignCapacity(i6);
            }
            if ((i6 & 15) != 0) {
                return (i6 & (-16)) + 16;
            }
        }
        return i6;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveAllocations() {
        long j6;
        long value = ((this.allocationsTiny.value() + this.allocationsSmall.value()) + this.allocationsHuge.value()) - this.deallocationsHuge.value();
        synchronized (this) {
            j6 = value + (this.allocationsNormal - ((this.deallocationsTiny + this.deallocationsSmall) + this.deallocationsNormal));
        }
        return Math.max(j6, 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveBytes() {
        long value = this.activeBytesHuge.value();
        synchronized (this) {
            for (int i6 = 0; i6 < this.chunkListMetrics.size(); i6++) {
                try {
                    while (this.chunkListMetrics.get(i6).iterator().hasNext()) {
                        value += r3.next().chunkSize();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Math.max(0L, value);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numSmallAllocations() {
        return this.allocationsSmall.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numThreadCaches() {
        return this.numThreadCaches.get();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numTinyAllocations() {
        return this.allocationsTiny.value();
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public int numTinySubpages() {
        return this.tinySubpagePools.length;
    }

    void reallocate(PooledByteBuf<T> pooledByteBuf, int i6, boolean z5) {
        if (i6 < 0 || i6 > pooledByteBuf.maxCapacity()) {
            throw new IllegalArgumentException("newCapacity: " + i6);
        }
        int i7 = pooledByteBuf.length;
        if (i7 == i6) {
            return;
        }
        PoolChunk<T> poolChunk = pooledByteBuf.chunk;
        ByteBuffer byteBuffer = pooledByteBuf.tmpNioBuf;
        long j6 = pooledByteBuf.handle;
        T t5 = pooledByteBuf.memory;
        int i8 = pooledByteBuf.offset;
        int i9 = pooledByteBuf.maxLength;
        int readerIndex = pooledByteBuf.readerIndex();
        int writerIndex = pooledByteBuf.writerIndex();
        allocate(this.parent.threadCache(), pooledByteBuf, i6);
        if (i6 > i7) {
            memoryCopy(t5, i8, pooledByteBuf.memory, pooledByteBuf.offset, i7);
        } else if (i6 < i7) {
            if (readerIndex < i6) {
                if (writerIndex > i6) {
                    writerIndex = i6;
                }
                memoryCopy(t5, i8 + readerIndex, pooledByteBuf.memory, pooledByteBuf.offset + readerIndex, writerIndex - readerIndex);
            } else {
                readerIndex = i6;
                writerIndex = readerIndex;
            }
        }
        pooledByteBuf.setIndex(readerIndex, writerIndex);
        if (z5) {
            free(poolChunk, byteBuffer, j6, i9, pooledByteBuf.cache);
        }
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> smallSubpages() {
        return subPageMetricList(this.smallSubpagePools);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public List<PoolSubpageMetric> tinySubpages() {
        return subPageMetricList(this.tinySubpagePools);
    }

    protected PoolArena(PooledByteBufAllocator pooledByteBufAllocator, int i6, int i7, int i8, int i9, int i10) {
        this.parent = pooledByteBufAllocator;
        this.pageSize = i6;
        this.maxOrder = i7;
        this.pageShifts = i8;
        this.chunkSize = i9;
        this.directMemoryCacheAlignment = i10;
        this.directMemoryCacheAlignmentMask = i10 - 1;
        this.subpageOverflowMask = ~(i6 - 1);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            PoolSubpage<T>[] poolSubpageArr = this.tinySubpagePools;
            if (i12 >= poolSubpageArr.length) {
                break;
            }
            poolSubpageArr[i12] = newSubpagePoolHead(i6);
            i12++;
        }
        int i13 = i8 - 9;
        this.numSmallSubpagePools = i13;
        this.smallSubpagePools = newSubpagePoolArray(i13);
        while (true) {
            PoolSubpage<T>[] poolSubpageArr2 = this.smallSubpagePools;
            if (i11 < poolSubpageArr2.length) {
                poolSubpageArr2[i11] = newSubpagePoolHead(i6);
                i11++;
            } else {
                PoolChunkList<T> poolChunkList = new PoolChunkList<>(this, null, 100, Integer.MAX_VALUE, i9);
                this.q100 = poolChunkList;
                PoolChunkList<T> poolChunkList2 = new PoolChunkList<>(this, poolChunkList, 75, 100, i9);
                this.q075 = poolChunkList2;
                PoolChunkList<T> poolChunkList3 = new PoolChunkList<>(this, poolChunkList2, 50, 100, i9);
                this.q050 = poolChunkList3;
                PoolChunkList<T> poolChunkList4 = new PoolChunkList<>(this, poolChunkList3, 25, 75, i9);
                this.q025 = poolChunkList4;
                PoolChunkList<T> poolChunkList5 = new PoolChunkList<>(this, poolChunkList4, 1, 50, i9);
                this.q000 = poolChunkList5;
                PoolChunkList<T> poolChunkList6 = new PoolChunkList<>(this, poolChunkList5, Integer.MIN_VALUE, 25, i9);
                this.qInit = poolChunkList6;
                poolChunkList.prevList(poolChunkList2);
                poolChunkList2.prevList(poolChunkList3);
                poolChunkList3.prevList(poolChunkList4);
                poolChunkList4.prevList(poolChunkList5);
                poolChunkList5.prevList(null);
                poolChunkList6.prevList(poolChunkList6);
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(poolChunkList6);
                arrayList.add(poolChunkList5);
                arrayList.add(poolChunkList4);
                arrayList.add(poolChunkList3);
                arrayList.add(poolChunkList2);
                arrayList.add(poolChunkList);
                this.chunkListMetrics = Collections.unmodifiableList(arrayList);
                return;
            }
        }
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i6) {
        int smallIdx;
        PoolSubpage<T>[] poolSubpageArr;
        int normalizeCapacity = normalizeCapacity(i6);
        if (isTinyOrSmall(normalizeCapacity)) {
            boolean isTiny = isTiny(normalizeCapacity);
            if (isTiny) {
                if (poolThreadCache.allocateTiny(this, pooledByteBuf, i6, normalizeCapacity)) {
                    return;
                }
                smallIdx = tinyIdx(normalizeCapacity);
                poolSubpageArr = this.tinySubpagePools;
            } else {
                if (poolThreadCache.allocateSmall(this, pooledByteBuf, i6, normalizeCapacity)) {
                    return;
                }
                smallIdx = smallIdx(normalizeCapacity);
                poolSubpageArr = this.smallSubpagePools;
            }
            PoolSubpage<T> poolSubpage = poolSubpageArr[smallIdx];
            synchronized (poolSubpage) {
                try {
                    PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                    if (poolSubpage2 != poolSubpage) {
                        poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, null, poolSubpage2.allocate(), i6);
                        incTinySmallAllocation(isTiny);
                        return;
                    } else {
                        synchronized (this) {
                            allocateNormal(pooledByteBuf, i6, normalizeCapacity);
                        }
                        incTinySmallAllocation(isTiny);
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (normalizeCapacity <= this.chunkSize) {
            if (poolThreadCache.allocateNormal(this, pooledByteBuf, i6, normalizeCapacity)) {
                return;
            }
            synchronized (this) {
                allocateNormal(pooledByteBuf, i6, normalizeCapacity);
                this.allocationsNormal++;
            }
            return;
        }
        allocateHuge(pooledByteBuf, i6);
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i6) {
        PoolChunk<T> newUnpooledChunk = newUnpooledChunk(i6);
        this.activeBytesHuge.add(newUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(newUnpooledChunk, i6);
        this.allocationsHuge.increment();
    }

    private SizeClass sizeClass(int i6) {
        if (!isTinyOrSmall(i6)) {
            return SizeClass.Normal;
        }
        if (isTiny(i6)) {
            return SizeClass.Tiny;
        }
        return SizeClass.Small;
    }

    PoolSubpage<T> findSubpagePoolHead(int i6) {
        PoolSubpage<T>[] poolSubpageArr;
        int i7;
        if (isTiny(i6)) {
            i7 = i6 >>> 4;
            poolSubpageArr = this.tinySubpagePools;
        } else {
            int i8 = i6 >>> 10;
            int i9 = 0;
            while (i8 != 0) {
                i8 >>>= 1;
                i9++;
            }
            int i10 = i9;
            poolSubpageArr = this.smallSubpagePools;
            i7 = i10;
        }
        return poolSubpageArr[i7];
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveHugeAllocations() {
        return Math.max(numHugeAllocations() - numHugeDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveSmallAllocations() {
        return Math.max(numSmallAllocations() - numSmallDeallocations(), 0L);
    }

    @Override // io.netty.buffer.PoolArenaMetric
    public long numActiveTinyAllocations() {
        return Math.max(numTinyAllocations() - numTinyDeallocations(), 0L);
    }
}
