package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoop;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.Queue;
import java.util.concurrent.Executor;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractEpollStreamChannel extends AbstractEpollChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    private FileDescriptor pipeIn;
    private FileDescriptor pipeOut;
    private volatile Queue<SpliceInTask> spliceQueue;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractEpollStreamChannel.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EpollSocketWritableByteChannel extends SocketWritableByteChannel {
        EpollSocketWritableByteChannel() {
            super(AbstractEpollStreamChannel.this.socket);
        }

        @Override // io.netty.channel.unix.SocketWritableByteChannel
        protected ByteBufAllocator alloc() {
            return AbstractEpollStreamChannel.this.alloc();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class EpollStreamUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z5, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            epollRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z5 || (th instanceof IOException)) {
                shutdownInput(false);
            }
        }

        EpollStreamUnsafe() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00b1 A[Catch: all -> 0x0086, TRY_LEAVE, TryCatch #0 {all -> 0x0086, blocks: (B:55:0x0083, B:20:0x00a9, B:22:0x00b1), top: B:54:0x0083 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0091 A[Catch: all -> 0x008b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x008b, blocks: (B:41:0x0066, B:49:0x0076, B:43:0x0091), top: B:40:0x0066 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC] */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void epollInReady() {
            /*
                r10 = this;
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.epoll.EpollChannelConfig r1 = r0.config()
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                boolean r0 = r0.shouldBreakEpollInReady(r1)
                if (r0 == 0) goto L12
                r10.clearEpollIn0()
                return
            L12:
                io.netty.channel.epoll.EpollRecvByteAllocatorHandle r7 = r10.recvBufAllocHandle()
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                int r2 = io.netty.channel.epoll.Native.EPOLLET
                boolean r0 = r0.isFlagSet(r2)
                r7.edgeTriggered(r0)
                io.netty.channel.epoll.AbstractEpollStreamChannel r0 = io.netty.channel.epoll.AbstractEpollStreamChannel.this
                io.netty.channel.ChannelPipeline r3 = r0.pipeline()
                io.netty.buffer.ByteBufAllocator r0 = r1.getAllocator()
                r7.reset(r1)
                r10.epollInBefore()
                r2 = 0
                r4 = r2
            L33:
                r5 = 0
                if (r4 != 0) goto L46
                io.netty.channel.epoll.AbstractEpollStreamChannel r4 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L3f
                java.util.Queue r4 = io.netty.channel.epoll.AbstractEpollStreamChannel.access$400(r4)     // Catch: java.lang.Throwable -> L3f
                if (r4 == 0) goto L62
                goto L46
            L3f:
                r0 = move-exception
                r5 = r0
                r4 = r2
                r6 = 0
            L43:
                r2 = r10
                goto Lb8
            L46:
                java.lang.Object r6 = r4.peek()     // Catch: java.lang.Throwable -> L3f
                io.netty.channel.epoll.AbstractEpollStreamChannel$SpliceInTask r6 = (io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask) r6     // Catch: java.lang.Throwable -> L3f
                if (r6 == 0) goto L62
                boolean r6 = r6.spliceIn(r7)     // Catch: java.lang.Throwable -> L3f
                if (r6 == 0) goto L60
                io.netty.channel.epoll.AbstractEpollStreamChannel r6 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L3f
                boolean r6 = r6.isActive()     // Catch: java.lang.Throwable -> L3f
                if (r6 == 0) goto La2
                r4.remove()     // Catch: java.lang.Throwable -> L3f
                goto La2
            L60:
                r9 = 0
                goto La9
            L62:
                io.netty.buffer.ByteBuf r6 = r7.allocate(r0)     // Catch: java.lang.Throwable -> L3f
                io.netty.channel.epoll.AbstractEpollStreamChannel r8 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L8b
                int r8 = r8.doReadBytes(r6)     // Catch: java.lang.Throwable -> L8b
                r7.lastBytesRead(r8)     // Catch: java.lang.Throwable -> L8b
                int r8 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L8b
                r9 = 1
                if (r8 > 0) goto L91
                r6.release()     // Catch: java.lang.Throwable -> L8b
                int r0 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L3f
                if (r0 >= 0) goto L80
                goto L81
            L80:
                r9 = 0
            L81:
                if (r9 == 0) goto La9
                r10.readPending = r5     // Catch: java.lang.Throwable -> L86
                goto La9
            L86:
                r0 = move-exception
                r5 = r0
                r4 = r2
                r6 = r9
                goto L43
            L8b:
                r0 = move-exception
                r2 = r10
                r5 = r0
                r4 = r6
                r6 = 0
                goto Lb8
            L91:
                r7.incMessagesRead(r9)     // Catch: java.lang.Throwable -> L8b
                r10.readPending = r5     // Catch: java.lang.Throwable -> L8b
                r3.fireChannelRead(r6)     // Catch: java.lang.Throwable -> L8b
                io.netty.channel.epoll.AbstractEpollStreamChannel r6 = io.netty.channel.epoll.AbstractEpollStreamChannel.this     // Catch: java.lang.Throwable -> L3f
                boolean r6 = r6.shouldBreakEpollInReady(r1)     // Catch: java.lang.Throwable -> L3f
                if (r6 == 0) goto La2
                goto L60
            La2:
                boolean r6 = r7.continueReading()     // Catch: java.lang.Throwable -> L3f
                if (r6 != 0) goto L33
                goto L60
            La9:
                r7.readComplete()     // Catch: java.lang.Throwable -> L86
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L86
                if (r9 == 0) goto Lb4
                r10.shutdownInput(r5)     // Catch: java.lang.Throwable -> L86
            Lb4:
                r10.epollInFinally(r1)
                return
            Lb8:
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lbf
                r10.epollInFinally(r1)
                return
            Lbf:
                r0 = move-exception
                r10.epollInFinally(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe.epollInReady():void");
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
            return new EpollRecvByteAllocatorStreamingHandle(extendedHandle);
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            return super.prepareToClose();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class SpliceFdTask extends SpliceInTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final FileDescriptor fd;
        private int offset;
        private final ChannelPromise promise;

        SpliceFdTask(FileDescriptor fileDescriptor, int i6, int i7, ChannelPromise channelPromise) {
            super(i7, channelPromise);
            this.fd = fileDescriptor;
            this.promise = channelPromise;
            this.offset = i6;
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor[] pipe = FileDescriptor.pipe();
                FileDescriptor fileDescriptor = pipe[0];
                FileDescriptor fileDescriptor2 = pipe[1];
                try {
                    int spliceIn = spliceIn(fileDescriptor2, handle);
                    if (spliceIn > 0) {
                        int i6 = this.len;
                        if (i6 != Integer.MAX_VALUE) {
                            this.len = i6 - spliceIn;
                        }
                        do {
                            int splice = Native.splice(fileDescriptor.intValue(), -1L, this.fd.intValue(), this.offset, spliceIn);
                            this.offset += splice;
                            spliceIn -= splice;
                        } while (spliceIn > 0);
                        if (this.len == 0) {
                            this.promise.setSuccess();
                            AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                            AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                            return true;
                        }
                    }
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                    return false;
                } catch (Throwable th) {
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                    throw th;
                }
            } catch (Throwable th2) {
                this.promise.setFailure(th2);
                return true;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class SpliceInChannelTask extends SpliceInTask implements ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AbstractEpollStreamChannel ch;

        SpliceInChannelTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i6, ChannelPromise channelPromise) {
            super(i6, channelPromise);
            this.ch = abstractEpollStreamChannel;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            this.promise.setFailure(channelFuture.cause());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [io.netty.channel.ChannelPromise, java.util.concurrent.Future] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r4v1, types: [io.netty.channel.Channel$Unsafe] */
        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor fileDescriptor = this.ch.pipeOut;
                if (fileDescriptor == null) {
                    FileDescriptor[] pipe = FileDescriptor.pipe();
                    this.ch.pipeIn = pipe[0];
                    fileDescriptor = this.ch.pipeOut = pipe[1];
                }
                int spliceIn = spliceIn(fileDescriptor, handle);
                if (spliceIn > 0) {
                    int i6 = this.len;
                    if (i6 != Integer.MAX_VALUE) {
                        this.len = i6 - spliceIn;
                    }
                    ?? addListener = this.len == 0 ? this.promise : this.ch.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
                    boolean isAutoRead = AbstractEpollStreamChannel.this.config().isAutoRead();
                    this.ch.unsafe().write(AbstractEpollStreamChannel.this.new SpliceOutTask(this.ch, spliceIn, isAutoRead), addListener);
                    this.ch.unsafe().flush();
                    if (isAutoRead && !addListener.isDone()) {
                        AbstractEpollStreamChannel.this.config().setAutoRead(false);
                    }
                }
                return this.len == 0;
            } catch (Throwable th) {
                this.promise.setFailure(th);
                return true;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected abstract class SpliceInTask {
        int len;
        final ChannelPromise promise;

        protected final int spliceIn(FileDescriptor fileDescriptor, RecvByteBufAllocator.Handle handle) throws IOException {
            int min = Math.min(handle.guess(), this.len);
            int i6 = 0;
            while (true) {
                int splice = Native.splice(AbstractEpollStreamChannel.this.socket.intValue(), -1L, fileDescriptor.intValue(), -1L, min);
                if (splice == 0) {
                    return i6;
                }
                i6 += splice;
                min -= splice;
            }
        }

        abstract boolean spliceIn(RecvByteBufAllocator.Handle handle);

        protected SpliceInTask(int i6, ChannelPromise channelPromise) {
            this.promise = channelPromise;
            this.len = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class SpliceOutTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean autoRead;
        private final AbstractEpollStreamChannel ch;
        private int len;

        public boolean spliceOut() throws Exception {
            try {
                int splice = this.len - Native.splice(this.ch.pipeIn.intValue(), -1L, this.ch.socket.intValue(), -1L, this.len);
                this.len = splice;
                if (splice != 0) {
                    return false;
                }
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                return true;
            } catch (IOException e6) {
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                throw e6;
            }
        }

        SpliceOutTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i6, boolean z5) {
            this.ch = abstractEpollStreamChannel;
            this.len = i6;
            this.autoRead = z5;
        }
    }

    protected AbstractEpollStreamChannel(Channel channel, int i6) {
        this(channel, new LinuxSocket(i6));
    }

    private void adjustMaxBytesPerGatheringWrite(long j6, long j7, long j8) {
        if (j6 == j7) {
            long j9 = j6 << 1;
            if (j9 > j8) {
                config().setMaxBytesPerGatheringWrite(j9);
                return;
            }
            return;
        }
        if (j6 > 4096) {
            long j10 = j6 >>> 1;
            if (j7 < j10) {
                config().setMaxBytesPerGatheringWrite(j10);
            }
        }
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, IovArray iovArray) throws IOException {
        long size = iovArray.size();
        long writevAddresses = this.socket.writevAddresses(iovArray.memoryAddress(0), iovArray.count());
        if (writevAddresses <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(size, writevAddresses, iovArray.maxBytes());
        channelOutboundBuffer.removeBytes(writevAddresses);
        return 1;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i6) {
        return spliceTo(abstractEpollStreamChannel, i6, newPromise());
    }

    protected AbstractEpollStreamChannel(int i6) {
        this(new LinuxSocket(i6));
    }

    private void addToSpliceQueue(SpliceInTask spliceInTask) {
        Queue<SpliceInTask> queue = this.spliceQueue;
        if (queue == null) {
            synchronized (this) {
                try {
                    queue = this.spliceQueue;
                    if (queue == null) {
                        queue = PlatformDependent.newMpscQueue();
                        this.spliceQueue = queue;
                    }
                } finally {
                }
            }
        }
        queue.add(spliceInTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpliceQueue() {
        Queue<SpliceInTask> queue = this.spliceQueue;
        if (queue == null) {
            return;
        }
        ClosedChannelException closedChannelException = null;
        while (true) {
            SpliceInTask poll = queue.poll();
            if (poll == null) {
                return;
            }
            if (closedChannelException == null) {
                closedChannelException = new ClosedChannelException();
            }
            poll.promise.tryFailure(closedChannelException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeClosePipe(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            try {
                fileDescriptor.close();
            } catch (IOException e6) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Error while closing a pipe", (Throwable) e6);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            this.socket.shutdown(true, false);
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected final void doShutdownOutput() throws Exception {
        this.socket.shutdown(false, true);
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        if (obj instanceof SpliceOutTask) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return this.socket.isShutdown();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollStreamUnsafe();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
            return channelPromise;
        }
        shutdownOutput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.6
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                AbstractEpollStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
            }
        });
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        Executor prepareToClose = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (prepareToClose != null) {
            prepareToClose.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
            return channelPromise;
        }
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
            return channelPromise;
        }
        eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
            }
        });
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(channelPromise);
            return channelPromise;
        }
        eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.3
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractChannel.AbstractUnsafe) AbstractEpollStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
            }
        });
        return channelPromise;
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i6, ChannelPromise channelPromise) {
        if (abstractEpollStreamChannel.eventLoop() != eventLoop()) {
            throw new IllegalArgumentException("EventLoops are not the same.");
        }
        ObjectUtil.checkPositiveOrZero(i6, "len");
        EpollMode epollMode = abstractEpollStreamChannel.config().getEpollMode();
        EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
        if (epollMode != epollMode2 || config().getEpollMode() != epollMode2) {
            throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
        }
        ObjectUtil.checkNotNull(channelPromise, "promise");
        if (!isOpen()) {
            channelPromise.tryFailure(new ClosedChannelException());
            return channelPromise;
        }
        addToSpliceQueue(new SpliceInChannelTask(abstractEpollStreamChannel, i6, channelPromise));
        failSpliceIfClosed(channelPromise);
        return channelPromise;
    }

    AbstractEpollStreamChannel(LinuxSocket linuxSocket) {
        this(linuxSocket, AbstractEpollChannel.isSoErrorZero(linuxSocket));
    }

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray cleanIovArray = ((EpollEventLoop) eventLoop()).cleanIovArray();
        cleanIovArray.maxBytes(maxBytesPerGatheringWrite);
        channelOutboundBuffer.forEachFlushedMessage(cleanIovArray);
        if (cleanIovArray.count() >= 1) {
            return writeBytesMultiple(channelOutboundBuffer, cleanIovArray);
        }
        channelOutboundBuffer.removeBytes(0L);
        return 0;
    }

    private void failSpliceIfClosed(ChannelPromise channelPromise) {
        if (!isOpen() && channelPromise.tryFailure(new ClosedChannelException())) {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.clearSpliceQueue();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture channelFuture, ChannelFuture channelFuture2, ChannelPromise channelPromise) {
        Throwable cause = channelFuture.cause();
        Throwable cause2 = channelFuture2.cause();
        if (cause != null) {
            if (cause2 != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", cause2);
            }
            channelPromise.setFailure(cause);
        } else if (cause2 != null) {
            channelPromise.setFailure(cause2);
        } else {
            channelPromise.setSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        ChannelFuture shutdownInput = shutdownInput();
        if (shutdownInput.isDone()) {
            shutdownDone(channelFuture, shutdownInput, channelPromise);
        } else {
            shutdownInput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.7
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    AbstractEpollStreamChannel.shutdownDone(channelFuture, channelFuture2, channelPromise);
                }
            });
        }
    }

    private int writeBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (!byteBuf.hasMemoryAddress() && byteBuf.nioBufferCount() != 1) {
            ByteBuffer[] nioBuffers = byteBuf.nioBuffers();
            return writeBytesMultiple(channelOutboundBuffer, nioBuffers, nioBuffers.length, readableBytes, config().getMaxBytesPerGatheringWrite());
        }
        return doWriteBytes(channelOutboundBuffer, byteBuf);
    }

    private int writeDefaultFileRegion(ChannelOutboundBuffer channelOutboundBuffer, DefaultFileRegion defaultFileRegion) throws Exception {
        long transferred = defaultFileRegion.transferred();
        long count = defaultFileRegion.count();
        if (transferred >= count) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long sendFile = this.socket.sendFile(defaultFileRegion, defaultFileRegion.position(), transferred, count - transferred);
        if (sendFile > 0) {
            channelOutboundBuffer.progress(sendFile);
            if (defaultFileRegion.transferred() >= count) {
                channelOutboundBuffer.remove();
                return 1;
            }
            return 1;
        }
        if (sendFile == 0) {
            validateFileRegion(defaultFileRegion, transferred);
            return Integer.MAX_VALUE;
        }
        return Integer.MAX_VALUE;
    }

    private int writeFileRegion(ChannelOutboundBuffer channelOutboundBuffer, FileRegion fileRegion) throws Exception {
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (this.byteChannel == null) {
            this.byteChannel = new EpollSocketWritableByteChannel();
        }
        long transferTo = fileRegion.transferTo(this.byteChannel, fileRegion.transferred());
        if (transferTo > 0) {
            channelOutboundBuffer.progress(transferTo);
            if (fileRegion.transferred() >= fileRegion.count()) {
                channelOutboundBuffer.remove();
                return 1;
            }
            return 1;
        }
        return Integer.MAX_VALUE;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        try {
            super.doClose();
        } finally {
            safeClosePipe(this.pipeIn);
            safeClosePipe(this.pipeOut);
            clearSpliceQueue();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int doWriteSingle;
        int writeSpinCount = config().getWriteSpinCount();
        do {
            int size = channelOutboundBuffer.size();
            if (size > 1 && (channelOutboundBuffer.current() instanceof ByteBuf)) {
                doWriteSingle = doWriteMultiple(channelOutboundBuffer);
            } else {
                if (size == 0) {
                    clearFlag(Native.EPOLLOUT);
                    return;
                }
                doWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= doWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            clearFlag(Native.EPOLLOUT);
            eventLoop().execute(this.flushTask);
        } else {
            setFlag(Native.EPOLLOUT);
        }
    }

    protected int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object current = channelOutboundBuffer.current();
        if (current instanceof ByteBuf) {
            return writeBytes(channelOutboundBuffer, (ByteBuf) current);
        }
        if (current instanceof DefaultFileRegion) {
            return writeDefaultFileRegion(channelOutboundBuffer, (DefaultFileRegion) current);
        }
        if (current instanceof FileRegion) {
            return writeFileRegion(channelOutboundBuffer, (FileRegion) current);
        }
        if (current instanceof SpliceOutTask) {
            if (!((SpliceOutTask) current).spliceOut()) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.remove();
            return 1;
        }
        throw new Error();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket) {
        super(channel, linuxSocket, true);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, ByteBuffer[] byteBufferArr, int i6, long j6, long j7) throws IOException {
        long j8 = j6 > j7 ? j7 : j6;
        long writev = this.socket.writev(byteBufferArr, 0, i6, j8);
        if (writev <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(j8, writev, j7);
        channelOutboundBuffer.removeBytes(writev);
        return 1;
    }

    AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket, SocketAddress socketAddress) {
        super(channel, linuxSocket, socketAddress);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    protected AbstractEpollStreamChannel(LinuxSocket linuxSocket, boolean z5) {
        super((Channel) null, linuxSocket, z5);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i6, int i7) {
        return spliceTo(fileDescriptor, i6, i7, newPromise());
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i6, int i7, ChannelPromise channelPromise) {
        ObjectUtil.checkPositiveOrZero(i7, "len");
        ObjectUtil.checkPositiveOrZero(i6, IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET);
        EpollMode epollMode = config().getEpollMode();
        EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
        if (epollMode == epollMode2) {
            ObjectUtil.checkNotNull(channelPromise, "promise");
            if (!isOpen()) {
                channelPromise.tryFailure(new ClosedChannelException());
                return channelPromise;
            }
            addToSpliceQueue(new SpliceFdTask(fileDescriptor, i6, i7, channelPromise));
            failSpliceIfClosed(channelPromise);
            return channelPromise;
        }
        throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
    }
}
