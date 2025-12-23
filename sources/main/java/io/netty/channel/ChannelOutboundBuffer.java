package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ChannelOutboundBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Channel channel;
    private volatile Runnable fireChannelWritabilityChangedTask;
    private int flushed;
    private Entry flushedEntry;
    private boolean inFail;
    private int nioBufferCount;
    private long nioBufferSize;
    private Entry tailEntry;
    private volatile long totalPendingSize;
    private Entry unflushedEntry;
    private volatile int unwritable;
    static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.outboundBufferEntrySizeOverhead", 96);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelOutboundBuffer.class);
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>() { // from class: io.netty.channel.ChannelOutboundBuffer.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public ByteBuffer[] initialValue() throws Exception {
            return new ByteBuffer[1024];
        }
    };
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Entry {
        private static final Recycler<Entry> RECYCLER = new Recycler<Entry>() { // from class: io.netty.channel.ChannelOutboundBuffer.Entry.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public Entry newObject(Recycler.Handle<Entry> handle) {
                return new Entry(handle);
            }
        };
        ByteBuffer buf;
        ByteBuffer[] bufs;
        boolean cancelled;
        int count;
        private final Recycler.Handle<Entry> handle;
        Object msg;
        Entry next;
        int pendingSize;
        long progress;
        ChannelPromise promise;
        long total;

        void recycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0L;
            this.total = 0L;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.recycle(this);
        }

        private Entry(Recycler.Handle<Entry> handle) {
            this.count = -1;
            this.handle = handle;
        }

        static Entry newInstance(Object obj, int i6, long j6, ChannelPromise channelPromise) {
            Entry entry = RECYCLER.get();
            entry.msg = obj;
            entry.pendingSize = i6 + ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
            entry.total = j6;
            entry.promise = channelPromise;
            return entry;
        }

        int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int i6 = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0L;
            this.progress = 0L;
            this.bufs = null;
            this.buf = null;
            return i6;
        }

        Entry recycleAndGetNext() {
            Entry entry = this.next;
            recycle();
            return entry;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface MessageProcessor {
        boolean processMessage(Object obj) throws Exception;
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] byteBufferArr, int i6, int i7) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i6 > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i7);
        return byteBufferArr2;
    }

    private static int writabilityMask(int i6) {
        if (i6 >= 1 && i6 <= 31) {
            return 1 << i6;
        }
        throw new IllegalArgumentException("index: " + i6 + " (expected: 1~31)");
    }

    void close(final Throwable th, final boolean z5) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelOutboundBuffer.this.close(th, z5);
                }
            });
            return;
        }
        this.inFail = true;
        if (!z5 && this.channel.isOpen()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        }
        if (!isEmpty()) {
            throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
        }
        try {
            for (Entry entry = this.unflushedEntry; entry != null; entry = entry.recycleAndGetNext()) {
                TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -entry.pendingSize);
                if (!entry.cancelled) {
                    ReferenceCountUtil.safeRelease(entry.msg);
                    safeFail(entry.promise, th);
                }
            }
            this.inFail = false;
            clearNioBuffers();
        } catch (Throwable th2) {
            this.inFail = false;
            throw th2;
        }
    }

    void decrementPendingOutboundBytes(long j6) {
        decrementPendingOutboundBytes(j6, true, true);
    }

    void incrementPendingOutboundBytes(long j6) {
        incrementPendingOutboundBytes(j6, true);
    }

    public ByteBuffer[] nioBuffers() {
        return nioBuffers(Integer.MAX_VALUE, 2147483647L);
    }

    public boolean remove() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i6 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeSuccess(channelPromise);
            decrementPendingOutboundBytes(i6, false, true);
        }
        entry.recycle();
        return true;
    }

    public void setUserDefinedWritability(int i6, boolean z5) {
        if (z5) {
            setUserDefinedWritability(i6);
        } else {
            clearUserDefinedWritability(i6);
        }
    }

    private void clearNioBuffers() {
        int i6 = this.nioBufferCount;
        if (i6 > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, i6, (Object) null);
        }
    }

    private void decrementPendingOutboundBytes(long j6, boolean z5, boolean z6) {
        if (j6 == 0) {
            return;
        }
        long addAndGet = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j6);
        if (!z6 || addAndGet >= this.channel.config().getWriteBufferLowWaterMark()) {
            return;
        }
        setWritable(z5);
    }

    private void fireChannelWritabilityChanged(boolean z5) {
        final ChannelPipeline pipeline = this.channel.pipeline();
        if (!z5) {
            pipeline.fireChannelWritabilityChanged();
            return;
        }
        Runnable runnable = this.fireChannelWritabilityChangedTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.2
                @Override // java.lang.Runnable
                public void run() {
                    pipeline.fireChannelWritabilityChanged();
                }
            };
            this.fireChannelWritabilityChangedTask = runnable;
        }
        this.channel.eventLoop().execute(runnable);
    }

    private void incrementPendingOutboundBytes(long j6, boolean z5) {
        if (j6 != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j6) > this.channel.config().getWriteBufferHighWaterMark()) {
            setUnwritable(z5);
        }
    }

    private boolean isFlushedEntry(Entry entry) {
        return (entry == null || entry == this.unflushedEntry) ? false : true;
    }

    private boolean remove0(Throwable th, boolean z5) {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i6 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeFail(channelPromise, th);
            decrementPendingOutboundBytes(i6, false, z5);
        }
        entry.recycle();
        return true;
    }

    private void removeEntry(Entry entry) {
        int i6 = this.flushed - 1;
        this.flushed = i6;
        if (i6 != 0) {
            this.flushedEntry = entry.next;
            return;
        }
        this.flushedEntry = null;
        if (entry == this.tailEntry) {
            this.tailEntry = null;
            this.unflushedEntry = null;
        }
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private static void safeSuccess(ChannelPromise channelPromise) {
        PromiseNotificationUtil.trySuccess(channelPromise, null, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private void setUnwritable(boolean z5) {
        int i6;
        int i7;
        do {
            i6 = this.unwritable;
            i7 = i6 | 1;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i6, i7));
        if (i6 != 0 || i7 == 0) {
            return;
        }
        fireChannelWritabilityChanged(z5);
    }

    private void setWritable(boolean z5) {
        int i6;
        int i7;
        do {
            i6 = this.unwritable;
            i7 = i6 & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i6, i7));
        if (i6 == 0 || i7 != 0) {
            return;
        }
        fireChannelWritabilityChanged(z5);
    }

    private static long total(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        if (obj instanceof ByteBufHolder) {
            return ((ByteBufHolder) obj).content().readableBytes();
        }
        return -1L;
    }

    public void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                this.flushed++;
                if (!entry.promise.setUncancellable()) {
                    decrementPendingOutboundBytes(entry.cancel(), false, true);
                }
                entry = entry.next;
            } while (entry != null);
            this.unflushedEntry = null;
        }
    }

    public long bytesBeforeUnwritable() {
        long writeBufferHighWaterMark = this.channel.config().getWriteBufferHighWaterMark() - this.totalPendingSize;
        if (writeBufferHighWaterMark <= 0 || !isWritable()) {
            return 0L;
        }
        return writeBufferHighWaterMark;
    }

    public long bytesBeforeWritable() {
        long writeBufferLowWaterMark = this.totalPendingSize - this.channel.config().getWriteBufferLowWaterMark();
        if (writeBufferLowWaterMark <= 0 || isWritable()) {
            return 0L;
        }
        return writeBufferLowWaterMark;
    }

    public Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    public long currentProgress() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return 0L;
        }
        return entry.progress;
    }

    void failFlushed(Throwable th, boolean z5) {
        if (this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            do {
            } while (remove0(th, z5));
        } finally {
            this.inFail = false;
        }
    }

    public void forEachFlushedMessage(MessageProcessor messageProcessor) throws Exception {
        if (messageProcessor == null) {
            throw new NullPointerException("processor");
        }
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return;
        }
        do {
            if (!entry.cancelled && !messageProcessor.processMessage(entry.msg)) {
                return;
            } else {
                entry = entry.next;
            }
        } while (isFlushedEntry(entry));
    }

    public boolean getUserDefinedWritability(int i6) {
        return (writabilityMask(i6) & this.unwritable) == 0;
    }

    public boolean isEmpty() {
        return this.flushed == 0;
    }

    public boolean isWritable() {
        return this.unwritable == 0;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    public ByteBuffer[] nioBuffers(int i6, long j6) {
        ByteBuf byteBuf;
        int readerIndex;
        int writerIndex;
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        ByteBuffer[] byteBufferArr = NIO_BUFFERS.get(internalThreadLocalMap);
        long j7 = 0;
        int i7 = 0;
        for (Entry entry = this.flushedEntry; isFlushedEntry(entry); entry = entry.next) {
            Object obj = entry.msg;
            if (!(obj instanceof ByteBuf)) {
                break;
            }
            if (!entry.cancelled && (writerIndex = byteBuf.writerIndex() - (readerIndex = (byteBuf = (ByteBuf) obj).readerIndex())) > 0) {
                long j8 = writerIndex;
                if (j6 - j8 < j7 && i7 != 0) {
                    break;
                }
                j7 += j8;
                int i8 = entry.count;
                if (i8 == -1) {
                    i8 = byteBuf.nioBufferCount();
                    entry.count = i8;
                }
                int min = Math.min(i6, i7 + i8);
                if (min > byteBufferArr.length) {
                    byteBufferArr = expandNioBufferArray(byteBufferArr, min, i7);
                    NIO_BUFFERS.set(internalThreadLocalMap, byteBufferArr);
                }
                if (i8 == 1) {
                    ByteBuffer byteBuffer = entry.buf;
                    if (byteBuffer == null) {
                        byteBuffer = byteBuf.internalNioBuffer(readerIndex, writerIndex);
                        entry.buf = byteBuffer;
                    }
                    byteBufferArr[i7] = byteBuffer;
                    i7++;
                } else {
                    i7 = nioBuffers(entry, byteBuf, byteBufferArr, i7, i6);
                }
                if (i7 == i6) {
                    break;
                }
            }
        }
        this.nioBufferCount = i7;
        this.nioBufferSize = j7;
        return byteBufferArr;
    }

    public void progress(long j6) {
        Entry entry = this.flushedEntry;
        ChannelPromise channelPromise = entry.promise;
        long j7 = entry.progress + j6;
        entry.progress = j7;
        if (channelPromise instanceof ChannelProgressivePromise) {
            ((ChannelProgressivePromise) channelPromise).tryProgress(j7, entry.total);
        }
    }

    public int size() {
        return this.flushed;
    }

    public long totalPendingWriteBytes() {
        return this.totalPendingSize;
    }

    ChannelOutboundBuffer(AbstractChannel abstractChannel) {
        this.channel = abstractChannel;
    }

    private void clearUserDefinedWritability(int i6) {
        int i7;
        int i8;
        int writabilityMask = writabilityMask(i6);
        do {
            i7 = this.unwritable;
            i8 = i7 | writabilityMask;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i7, i8));
        if (i7 == 0 && i8 != 0) {
            fireChannelWritabilityChanged(true);
        }
    }

    private void setUserDefinedWritability(int i6) {
        int i7;
        int i8;
        int i9 = ~writabilityMask(i6);
        do {
            i7 = this.unwritable;
            i8 = i7 & i9;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i7, i8));
        if (i7 == 0 || i8 != 0) {
            return;
        }
        fireChannelWritabilityChanged(true);
    }

    public void addMessage(Object obj, int i6, ChannelPromise channelPromise) {
        Entry newInstance = Entry.newInstance(obj, i6, total(obj), channelPromise);
        Entry entry = this.tailEntry;
        if (entry == null) {
            this.flushedEntry = null;
        } else {
            entry.next = newInstance;
        }
        this.tailEntry = newInstance;
        if (this.unflushedEntry == null) {
            this.unflushedEntry = newInstance;
        }
        incrementPendingOutboundBytes(newInstance.pendingSize, false);
    }

    public void removeBytes(long j6) {
        while (true) {
            Object current = current();
            if (!(current instanceof ByteBuf)) {
                break;
            }
            ByteBuf byteBuf = (ByteBuf) current;
            int readerIndex = byteBuf.readerIndex();
            long writerIndex = byteBuf.writerIndex() - readerIndex;
            if (writerIndex <= j6) {
                if (j6 != 0) {
                    progress(writerIndex);
                    j6 -= writerIndex;
                }
                remove();
            } else if (j6 != 0) {
                byteBuf.readerIndex(readerIndex + ((int) j6));
                progress(j6);
            }
        }
        clearNioBuffers();
    }

    public boolean remove(Throwable th) {
        return remove0(th, true);
    }

    void close(ClosedChannelException closedChannelException) {
        close(closedChannelException, false);
    }

    @Deprecated
    public void recycle() {
    }

    private static int nioBuffers(Entry entry, ByteBuf byteBuf, ByteBuffer[] byteBufferArr, int i6, int i7) {
        ByteBuffer byteBuffer;
        ByteBuffer[] byteBufferArr2 = entry.bufs;
        if (byteBufferArr2 == null) {
            byteBufferArr2 = byteBuf.nioBuffers();
            entry.bufs = byteBufferArr2;
        }
        for (int i8 = 0; i8 < byteBufferArr2.length && i6 < i7 && (byteBuffer = byteBufferArr2[i8]) != null; i8++) {
            if (byteBuffer.hasRemaining()) {
                byteBufferArr[i6] = byteBuffer;
                i6++;
            }
        }
        return i6;
    }
}
