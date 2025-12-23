package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class PoolChunkList<T> implements PoolChunkListMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Iterator<PoolChunkMetric> EMPTY_METRICS = Collections.EMPTY_LIST.iterator();
    private final PoolArena<T> arena;
    private PoolChunk<T> head;
    private final int maxCapacity;
    private final int maxUsage;
    private final int minUsage;
    private final PoolChunkList<T> nextList;
    private PoolChunkList<T> prevList;

    private static int minUsage0(int i6) {
        return Math.max(1, i6);
    }

    private boolean move0(PoolChunk<T> poolChunk) {
        PoolChunkList<T> poolChunkList = this.prevList;
        if (poolChunkList == null) {
            return false;
        }
        return poolChunkList.move(poolChunk);
    }

    private void remove(PoolChunk<T> poolChunk) {
        if (poolChunk == this.head) {
            PoolChunk<T> poolChunk2 = poolChunk.next;
            this.head = poolChunk2;
            if (poolChunk2 != null) {
                poolChunk2.prev = null;
                return;
            }
            return;
        }
        PoolChunk<T> poolChunk3 = poolChunk.next;
        PoolChunk<T> poolChunk4 = poolChunk.prev;
        poolChunk4.next = poolChunk3;
        if (poolChunk3 != null) {
            poolChunk3.prev = poolChunk4;
        }
    }

    void add0(PoolChunk<T> poolChunk) {
        poolChunk.parent = this;
        PoolChunk<T> poolChunk2 = this.head;
        if (poolChunk2 == null) {
            this.head = poolChunk;
            poolChunk.prev = null;
            poolChunk.next = null;
        } else {
            poolChunk.prev = null;
            poolChunk.next = poolChunk2;
            poolChunk2.prev = poolChunk;
            this.head = poolChunk;
        }
    }

    boolean allocate(PooledByteBuf<T> pooledByteBuf, int i6, int i7) {
        if (i7 > this.maxCapacity) {
            return false;
        }
        for (PoolChunk<T> poolChunk = this.head; poolChunk != null; poolChunk = poolChunk.next) {
            if (poolChunk.allocate(pooledByteBuf, i6, i7)) {
                if (poolChunk.usage() < this.maxUsage) {
                    return true;
                }
                remove(poolChunk);
                this.nextList.add(poolChunk);
                return true;
            }
        }
        return false;
    }

    void destroy(PoolArena<T> poolArena) {
        for (PoolChunk<T> poolChunk = this.head; poolChunk != null; poolChunk = poolChunk.next) {
            poolArena.destroyChunk(poolChunk);
        }
        this.head = null;
    }

    @Override // java.lang.Iterable
    public Iterator<PoolChunkMetric> iterator() {
        synchronized (this.arena) {
            try {
                if (this.head == null) {
                    return EMPTY_METRICS;
                }
                ArrayList arrayList = new ArrayList();
                PoolChunk<T> poolChunk = this.head;
                do {
                    arrayList.add(poolChunk);
                    poolChunk = poolChunk.next;
                } while (poolChunk != null);
                return arrayList.iterator();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.netty.buffer.PoolChunkListMetric
    public int maxUsage() {
        return Math.min(this.maxUsage, 100);
    }

    @Override // io.netty.buffer.PoolChunkListMetric
    public int minUsage() {
        return minUsage0(this.minUsage);
    }

    void prevList(PoolChunkList<T> poolChunkList) {
        this.prevList = poolChunkList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.arena) {
            try {
                PoolChunk<T> poolChunk = this.head;
                if (poolChunk == null) {
                    return "none";
                }
                while (true) {
                    sb.append(poolChunk);
                    poolChunk = poolChunk.next;
                    if (poolChunk == null) {
                        return sb.toString();
                    }
                    sb.append(StringUtil.NEWLINE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    PoolChunkList(PoolArena<T> poolArena, PoolChunkList<T> poolChunkList, int i6, int i7, int i8) {
        this.arena = poolArena;
        this.nextList = poolChunkList;
        this.minUsage = i6;
        this.maxUsage = i7;
        this.maxCapacity = calculateMaxCapacity(i6, i8);
    }

    private static int calculateMaxCapacity(int i6, int i7) {
        int minUsage0 = minUsage0(i6);
        if (minUsage0 == 100) {
            return 0;
        }
        return (int) ((i7 * (100 - minUsage0)) / 100);
    }

    private boolean move(PoolChunk<T> poolChunk) {
        if (poolChunk.usage() < this.minUsage) {
            return move0(poolChunk);
        }
        add0(poolChunk);
        return true;
    }

    void add(PoolChunk<T> poolChunk) {
        if (poolChunk.usage() >= this.maxUsage) {
            this.nextList.add(poolChunk);
        } else {
            add0(poolChunk);
        }
    }

    boolean free(PoolChunk<T> poolChunk, long j6, ByteBuffer byteBuffer) {
        poolChunk.free(j6, byteBuffer);
        if (poolChunk.usage() < this.minUsage) {
            remove(poolChunk);
            return move0(poolChunk);
        }
        return true;
    }
}
