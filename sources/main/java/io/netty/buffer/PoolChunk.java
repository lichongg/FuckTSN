package io.netty.buffer;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import kotlinx.coroutines.internal.a0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PoolChunk<T> implements PoolChunkMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INTEGER_SIZE_MINUS_ONE = 31;
    final PoolArena<T> arena;
    private final Deque<ByteBuffer> cachedNioBuffers;
    private final int chunkSize;
    private final byte[] depthMap;
    private int freeBytes;
    private final int log2ChunkSize;
    private final int maxOrder;
    private final int maxSubpageAllocs;
    final T memory;
    private final byte[] memoryMap;
    PoolChunk<T> next;
    final int offset;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    PoolChunk<T> prev;
    private final int subpageOverflowMask;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled;
    private final byte unusable;

    PoolChunk(PoolArena<T> poolArena, T t5, int i6, int i7, int i8, int i9, int i10) {
        this.unpooled = false;
        this.arena = poolArena;
        this.memory = t5;
        this.pageSize = i6;
        this.pageShifts = i8;
        this.maxOrder = i7;
        this.chunkSize = i9;
        this.offset = i10;
        this.unusable = (byte) (i7 + 1);
        this.log2ChunkSize = log2(i9);
        this.subpageOverflowMask = ~(i6 - 1);
        this.freeBytes = i9;
        int i11 = 1 << i7;
        this.maxSubpageAllocs = i11;
        byte[] bArr = new byte[i11 << 1];
        this.memoryMap = bArr;
        this.depthMap = new byte[bArr.length];
        int i12 = 1;
        for (int i13 = 0; i13 <= i7; i13++) {
            int i14 = 1 << i13;
            for (int i15 = 0; i15 < i14; i15++) {
                byte b6 = (byte) i13;
                this.memoryMap[i12] = b6;
                this.depthMap[i12] = b6;
                i12++;
            }
        }
        this.subpages = newSubpageArray(this.maxSubpageAllocs);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    private int allocateNode(int i6) {
        int i7 = 1;
        int i8 = -(1 << i6);
        byte value = value(1);
        if (value > i6) {
            return -1;
        }
        while (true) {
            if (value >= i6 && (i7 & i8) != 0) {
                value(i7);
                setValue(i7, this.unusable);
                updateParentsAlloc(i7);
                return i7;
            }
            i7 <<= 1;
            value = value(i7);
            if (value > i6) {
                i7 ^= 1;
                value = value(i7);
            }
        }
    }

    private static int memoryMapIdx(long j6) {
        return (int) j6;
    }

    private int runOffset(int i6) {
        return ((1 << depth(i6)) ^ i6) * runLength(i6);
    }

    private void updateParentsAlloc(int i6) {
        while (i6 > 1) {
            int i7 = i6 >>> 1;
            byte value = value(i6);
            byte value2 = value(i6 ^ 1);
            if (value >= value2) {
                value = value2;
            }
            setValue(i7, value);
            i6 = i7;
        }
    }

    void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j6, int i6) {
        initBufWithSubpage(pooledByteBuf, byteBuffer, j6, bitmapIdx(j6), i6);
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int usage() {
        int i6;
        synchronized (this.arena) {
            i6 = this.freeBytes;
        }
        return usage(i6);
    }

    private long allocateRun(int i6) {
        int allocateNode = allocateNode(this.maxOrder - (log2(i6) - this.pageShifts));
        if (allocateNode < 0) {
            return allocateNode;
        }
        this.freeBytes -= runLength(allocateNode);
        return allocateNode;
    }

    private long allocateSubpage(int i6) {
        PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(i6);
        int i7 = this.maxOrder;
        synchronized (findSubpagePoolHead) {
            try {
                int allocateNode = allocateNode(i7);
                if (allocateNode < 0) {
                    return allocateNode;
                }
                PoolSubpage<T>[] poolSubpageArr = this.subpages;
                int i8 = this.pageSize;
                this.freeBytes -= i8;
                int subpageIdx = subpageIdx(allocateNode);
                PoolSubpage<T> poolSubpage = poolSubpageArr[subpageIdx];
                if (poolSubpage == null) {
                    poolSubpage = new PoolSubpage<>(findSubpagePoolHead, this, allocateNode, runOffset(allocateNode), i8, i6);
                    poolSubpageArr[subpageIdx] = poolSubpage;
                } else {
                    poolSubpage.init(findSubpagePoolHead, i6);
                }
                return poolSubpage.allocate();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static int bitmapIdx(long j6) {
        return (int) (j6 >>> 32);
    }

    private byte depth(int i6) {
        return this.depthMap[i6];
    }

    private void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j6, int i6, int i7) {
        int memoryMapIdx = memoryMapIdx(j6);
        PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
        int runOffset = runOffset(memoryMapIdx);
        int i8 = poolSubpage.elemSize;
        pooledByteBuf.init(this, byteBuffer, j6, runOffset + ((1073741823 & i6) * i8) + this.offset, i7, i8, this.arena.parent.threadCache());
    }

    private PoolSubpage<T>[] newSubpageArray(int i6) {
        return new PoolSubpage[i6];
    }

    private int runLength(int i6) {
        return 1 << (this.log2ChunkSize - depth(i6));
    }

    private void setValue(int i6, byte b6) {
        this.memoryMap[i6] = b6;
    }

    private int subpageIdx(int i6) {
        return i6 ^ this.maxSubpageAllocs;
    }

    private byte value(int i6) {
        return this.memoryMap[i6];
    }

    boolean allocate(PooledByteBuf<T> pooledByteBuf, int i6, int i7) {
        long allocateRun = (this.subpageOverflowMask & i7) != 0 ? allocateRun(i7) : allocateSubpage(i7);
        if (allocateRun < 0) {
            return false;
        }
        Deque<ByteBuffer> deque = this.cachedNioBuffers;
        initBuf(pooledByteBuf, deque != null ? deque.pollLast() : null, allocateRun, i6);
        return true;
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int chunkSize() {
        return this.chunkSize;
    }

    void destroy() {
        this.arena.destroyChunk(this);
    }

    @Override // io.netty.buffer.PoolChunkMetric
    public int freeBytes() {
        int i6;
        synchronized (this.arena) {
            i6 = this.freeBytes;
        }
        return i6;
    }

    public String toString() {
        int i6;
        synchronized (this.arena) {
            i6 = this.freeBytes;
        }
        return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage(i6) + "%, " + (this.chunkSize - i6) + '/' + this.chunkSize + ')';
    }

    private static int log2(int i6) {
        return 31 - Integer.numberOfLeadingZeros(i6);
    }

    private void updateParentsFree(int i6) {
        int depth = depth(i6) + 1;
        while (i6 > 1) {
            int i7 = i6 >>> 1;
            byte value = value(i6);
            byte value2 = value(i6 ^ 1);
            int i8 = depth - 1;
            if (value == i8 && value2 == i8) {
                setValue(i7, (byte) (depth - 2));
            } else {
                if (value >= value2) {
                    value = value2;
                }
                setValue(i7, value);
            }
            i6 = i7;
            depth = i8;
        }
    }

    void free(long j6, ByteBuffer byteBuffer) {
        Deque<ByteBuffer> deque;
        int memoryMapIdx = memoryMapIdx(j6);
        int bitmapIdx = bitmapIdx(j6);
        if (bitmapIdx != 0) {
            PoolSubpage<T> poolSubpage = this.subpages[subpageIdx(memoryMapIdx)];
            PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(poolSubpage.elemSize);
            synchronized (findSubpagePoolHead) {
                try {
                    if (poolSubpage.free(findSubpagePoolHead, bitmapIdx & a0.f49221j)) {
                        return;
                    }
                } finally {
                }
            }
        }
        this.freeBytes += runLength(memoryMapIdx);
        setValue(memoryMapIdx, depth(memoryMapIdx));
        updateParentsFree(memoryMapIdx);
        if (byteBuffer != null && (deque = this.cachedNioBuffers) != null && deque.size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
            this.cachedNioBuffers.offer(byteBuffer);
        }
    }

    void initBuf(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j6, int i6) {
        int memoryMapIdx = memoryMapIdx(j6);
        int bitmapIdx = bitmapIdx(j6);
        if (bitmapIdx == 0) {
            value(memoryMapIdx);
            pooledByteBuf.init(this, byteBuffer, j6, runOffset(memoryMapIdx) + this.offset, i6, runLength(memoryMapIdx), this.arena.parent.threadCache());
        } else {
            initBufWithSubpage(pooledByteBuf, byteBuffer, j6, bitmapIdx, i6);
        }
    }

    private int usage(int i6) {
        if (i6 == 0) {
            return 100;
        }
        int i7 = (int) ((i6 * 100) / this.chunkSize);
        if (i7 == 0) {
            return 99;
        }
        return 100 - i7;
    }

    PoolChunk(PoolArena<T> poolArena, T t5, int i6, int i7) {
        this.unpooled = true;
        this.arena = poolArena;
        this.memory = t5;
        this.offset = i7;
        this.memoryMap = null;
        this.depthMap = null;
        this.subpages = null;
        this.subpageOverflowMask = 0;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.maxOrder = 0;
        this.unusable = (byte) 1;
        this.chunkSize = i6;
        this.log2ChunkSize = log2(i6);
        this.maxSubpageAllocs = 0;
        this.cachedNioBuffers = null;
    }
}
