package io.netty.channel;

import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PendingWriteQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long bytes;
    private final ChannelHandlerContext ctx;
    private PendingWrite head;
    private int size;
    private PendingWrite tail;
    private final PendingBytesTracker tracker;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PendingWriteQueue.class);
    private static final int PENDING_WRITE_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.pendingWriteSizeOverhead", 64);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.PendingWriteQueue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class PendingWrite {
        private static final Recycler<PendingWrite> RECYCLER = new Recycler<PendingWrite>() { // from class: io.netty.channel.PendingWriteQueue.PendingWrite.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public PendingWrite newObject(Recycler.Handle<PendingWrite> handle) {
                return new PendingWrite(handle, null);
            }
        };
        private final Recycler.Handle<PendingWrite> handle;
        private Object msg;
        private PendingWrite next;
        private ChannelPromise promise;
        private long size;

        /* synthetic */ PendingWrite(Recycler.Handle handle, AnonymousClass1 anonymousClass1) {
            this(handle);
        }

        private PendingWrite(Recycler.Handle<PendingWrite> handle) {
            this.handle = handle;
        }

        static PendingWrite newInstance(Object obj, int i6, ChannelPromise channelPromise) {
            PendingWrite pendingWrite = RECYCLER.get();
            pendingWrite.size = i6;
            pendingWrite.msg = obj;
            pendingWrite.promise = channelPromise;
            return pendingWrite;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle() {
            this.size = 0L;
            this.next = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }
    }

    public int size() {
        return this.size;
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th)) {
            return;
        }
        logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
    }

    private int size(Object obj) {
        int size = this.tracker.size(obj);
        if (size < 0) {
            size = 0;
        }
        return size + PENDING_WRITE_OVERHEAD;
    }

    public void add(Object obj, ChannelPromise channelPromise) {
        if (obj == null) {
            throw new NullPointerException("msg");
        }
        if (channelPromise == null) {
            throw new NullPointerException("promise");
        }
        int size = size(obj);
        PendingWrite newInstance = PendingWrite.newInstance(obj, size, channelPromise);
        PendingWrite pendingWrite = this.tail;
        if (pendingWrite == null) {
            this.head = newInstance;
            this.tail = newInstance;
        } else {
            pendingWrite.next = newInstance;
            this.tail = newInstance;
        }
        this.size++;
        this.bytes += size;
        this.tracker.incrementPendingOutboundBytes(newInstance.size);
    }

    public long bytes() {
        return this.bytes;
    }

    public Object current() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        return pendingWrite.msg;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public ChannelPromise remove() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        ChannelPromise channelPromise = pendingWrite.promise;
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        recycle(pendingWrite, true);
        return channelPromise;
    }

    public void removeAndFail(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return;
        }
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        safeFail(pendingWrite.promise, th);
        recycle(pendingWrite, true);
    }

    public void removeAndFailAll(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        while (true) {
            PendingWrite pendingWrite = this.head;
            if (pendingWrite == null) {
                assertEmpty();
                return;
            }
            this.tail = null;
            this.head = null;
            this.size = 0;
            this.bytes = 0L;
            while (pendingWrite != null) {
                PendingWrite pendingWrite2 = pendingWrite.next;
                ReferenceCountUtil.safeRelease(pendingWrite.msg);
                ChannelPromise channelPromise = pendingWrite.promise;
                recycle(pendingWrite, false);
                safeFail(channelPromise, th);
                pendingWrite = pendingWrite2;
            }
        }
    }

    public ChannelFuture removeAndWrite() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        Object obj = pendingWrite.msg;
        ChannelPromise channelPromise = pendingWrite.promise;
        recycle(pendingWrite, true);
        return this.ctx.write(obj, channelPromise);
    }

    public PendingWriteQueue(ChannelHandlerContext channelHandlerContext) {
        this.tracker = PendingBytesTracker.newTracker(channelHandlerContext.channel());
        this.ctx = channelHandlerContext;
    }

    private void recycle(PendingWrite pendingWrite, boolean z5) {
        PendingWrite pendingWrite2 = pendingWrite.next;
        long j6 = pendingWrite.size;
        if (z5) {
            if (pendingWrite2 == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
            } else {
                this.head = pendingWrite2;
                this.size--;
                this.bytes -= j6;
            }
        }
        pendingWrite.recycle();
        this.tracker.decrementPendingOutboundBytes(j6);
    }

    public ChannelFuture removeAndWriteAll() {
        if (isEmpty()) {
            return null;
        }
        ChannelPromise newPromise = this.ctx.newPromise();
        PromiseCombiner promiseCombiner = new PromiseCombiner(this.ctx.executor());
        while (true) {
            try {
                PendingWrite pendingWrite = this.head;
                if (pendingWrite == null) {
                    break;
                }
                this.tail = null;
                this.head = null;
                this.size = 0;
                this.bytes = 0L;
                while (pendingWrite != null) {
                    PendingWrite pendingWrite2 = pendingWrite.next;
                    Object obj = pendingWrite.msg;
                    ChannelPromise channelPromise = pendingWrite.promise;
                    recycle(pendingWrite, false);
                    if (!(channelPromise instanceof VoidChannelPromise)) {
                        promiseCombiner.add((Promise) channelPromise);
                    }
                    this.ctx.write(obj, channelPromise);
                    pendingWrite = pendingWrite2;
                }
            } catch (Throwable th) {
                newPromise.setFailure(th);
            }
        }
        promiseCombiner.finish(newPromise);
        assertEmpty();
        return newPromise;
    }

    private void assertEmpty() {
    }
}
