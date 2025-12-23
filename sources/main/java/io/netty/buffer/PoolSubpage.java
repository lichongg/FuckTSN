package io.netty.buffer;

import com.google.common.primitives.Longs;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PoolSubpage<T> implements PoolSubpageMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long[] bitmap;
    private int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    int elemSize;
    private int maxNumElems;
    private final int memoryMapIdx;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageSize;
    PoolSubpage<T> prev;
    private final int runOffset;

    PoolSubpage(int i6) {
        this.chunk = null;
        this.memoryMapIdx = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.pageSize = i6;
        this.bitmap = null;
    }

    private long toHandle(int i6) {
        return (i6 << 32) | Longs.MAX_POWER_OF_TWO | this.memoryMapIdx;
    }

    void init(PoolSubpage<T> poolSubpage, int i6) {
        this.doNotDestroy = true;
        this.elemSize = i6;
        if (i6 != 0) {
            int i7 = this.pageSize / i6;
            this.numAvail = i7;
            this.maxNumElems = i7;
            this.nextAvail = 0;
            int i8 = i7 >>> 6;
            this.bitmapLength = i8;
            if ((i7 & 63) != 0) {
                this.bitmapLength = i8 + 1;
            }
            for (int i9 = 0; i9 < this.bitmapLength; i9++) {
                this.bitmap[i9] = 0;
            }
        }
        addToPool(poolSubpage);
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        long[] jArr = this.bitmap;
        int i6 = this.bitmapLength;
        for (int i7 = 0; i7 < i6; i7++) {
            long j6 = jArr[i7];
            if ((~j6) != 0) {
                return findNextAvail0(i7, j6);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i6, long j6) {
        int i7 = this.maxNumElems;
        int i8 = i6 << 6;
        for (int i9 = 0; i9 < 64; i9++) {
            if ((1 & j6) == 0) {
                int i10 = i8 | i9;
                if (i10 < i7) {
                    return i10;
                }
                return -1;
            }
            j6 >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i6 = this.nextAvail;
        if (i6 < 0) {
            return findNextAvail();
        }
        this.nextAvail = -1;
        return i6;
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i6) {
        this.nextAvail = i6;
    }

    long allocate() {
        if (this.elemSize == 0) {
            return toHandle(0);
        }
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1L;
        }
        int nextAvail = getNextAvail();
        int i6 = nextAvail >>> 6;
        long[] jArr = this.bitmap;
        jArr[i6] = jArr[i6] | (1 << (nextAvail & 63));
        int i7 = this.numAvail - 1;
        this.numAvail = i7;
        if (i7 == 0) {
            removeFromPool();
        }
        return toHandle(nextAvail);
    }

    void destroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk != null) {
            poolChunk.destroy();
        }
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int elementSize() {
        int i6;
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return -1;
        }
        synchronized (poolChunk.arena) {
            i6 = this.elemSize;
        }
        return i6;
    }

    boolean free(PoolSubpage<T> poolSubpage, int i6) {
        if (this.elemSize == 0) {
            return true;
        }
        int i7 = i6 >>> 6;
        long[] jArr = this.bitmap;
        jArr[i7] = jArr[i7] ^ (1 << (i6 & 63));
        setNextAvail(i6);
        int i8 = this.numAvail;
        int i9 = i8 + 1;
        this.numAvail = i9;
        if (i8 == 0) {
            addToPool(poolSubpage);
            return true;
        }
        if (i9 != this.maxNumElems || this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        removeFromPool();
        return false;
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int maxNumElements() {
        int i6;
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        synchronized (poolChunk.arena) {
            i6 = this.maxNumElems;
        }
        return i6;
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int numAvailable() {
        int i6;
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        synchronized (poolChunk.arena) {
            i6 = this.numAvail;
        }
        return i6;
    }

    @Override // io.netty.buffer.PoolSubpageMetric
    public int pageSize() {
        return this.pageSize;
    }

    public String toString() {
        int i6;
        int i7;
        int i8;
        PoolChunk<T> poolChunk = this.chunk;
        int i9 = -1;
        boolean z5 = true;
        int i10 = 0;
        if (poolChunk == null) {
            i8 = 0;
        } else {
            synchronized (poolChunk.arena) {
                if (this.doNotDestroy) {
                    i9 = this.maxNumElems;
                    i6 = this.numAvail;
                    i7 = this.elemSize;
                } else {
                    z5 = false;
                    i6 = -1;
                    i7 = -1;
                }
            }
            i8 = i6;
            i10 = i9;
            i9 = i7;
        }
        if (!z5) {
            return "(" + this.memoryMapIdx + ": not in use)";
        }
        return "(" + this.memoryMapIdx + ": " + (i10 - i8) + '/' + i10 + ", offset: " + this.runOffset + ", length: " + this.pageSize + ", elemSize: " + i9 + ')';
    }

    PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i6, int i7, int i8, int i9) {
        this.chunk = poolChunk;
        this.memoryMapIdx = i6;
        this.runOffset = i7;
        this.pageSize = i8;
        this.bitmap = new long[i8 >>> 10];
        init(poolSubpage, i9);
    }
}
