package io.netty.channel.kqueue;

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
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractKQueueStreamChannel extends AbstractKQueueChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractKQueueStreamChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class KQueueSocketWritableByteChannel extends SocketWritableByteChannel {
        KQueueSocketWritableByteChannel() {
            super(AbstractKQueueStreamChannel.this.socket);
        }

        @Override // io.netty.channel.unix.SocketWritableByteChannel
        protected ByteBufAllocator alloc() {
            return AbstractKQueueStreamChannel.this.alloc();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class KQueueStreamUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z5, KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            if (failConnectPromise(th)) {
                return;
            }
            kQueueRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z5 || (th instanceof IOException)) {
                shutdownInput(false);
            }
        }

        KQueueStreamUnsafe() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x007b A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #1 {all -> 0x0048, blocks: (B:46:0x0045, B:20:0x0073, B:22:0x007b), top: B:45:0x0045 }] */
        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r9) {
            /*
                r8 = this;
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r0 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                io.netty.channel.kqueue.KQueueChannelConfig r1 = r0.config()
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r0 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                boolean r0 = r0.shouldBreakReadReady(r1)
                if (r0 == 0) goto L12
                r8.clearReadFilter0()
                return
            L12:
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r0 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this
                io.netty.channel.ChannelPipeline r3 = r0.pipeline()
                io.netty.buffer.ByteBufAllocator r0 = r1.getAllocator()
                r9.reset(r1)
                r8.readReadyBefore()
            L22:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r9.allocate(r0)     // Catch: java.lang.Throwable -> L4e
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r6 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this     // Catch: java.lang.Throwable -> L54
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> L54
                r9.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L54
                int r6 = r9.lastBytesRead()     // Catch: java.lang.Throwable -> L54
                r7 = 1
                if (r6 > 0) goto L5b
                r5.release()     // Catch: java.lang.Throwable -> L54
                int r0 = r9.lastBytesRead()     // Catch: java.lang.Throwable -> L4e
                if (r0 >= 0) goto L42
                goto L43
            L42:
                r7 = 0
            L43:
                if (r7 == 0) goto L73
                r8.readPending = r2     // Catch: java.lang.Throwable -> L48
                goto L73
            L48:
                r0 = move-exception
                r2 = r8
                r5 = r0
                r6 = r7
                r7 = r9
                goto L82
            L4e:
                r0 = move-exception
                r2 = r8
                r7 = r9
                r5 = r0
                r6 = 0
                goto L82
            L54:
                r0 = move-exception
                r2 = r8
                r7 = r9
                r4 = r5
                r6 = 0
                r5 = r0
                goto L82
            L5b:
                r9.incMessagesRead(r7)     // Catch: java.lang.Throwable -> L54
                r8.readPending = r2     // Catch: java.lang.Throwable -> L54
                r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> L54
                io.netty.channel.kqueue.AbstractKQueueStreamChannel r5 = io.netty.channel.kqueue.AbstractKQueueStreamChannel.this     // Catch: java.lang.Throwable -> L4e
                boolean r5 = r5.shouldBreakReadReady(r1)     // Catch: java.lang.Throwable -> L4e
                if (r5 == 0) goto L6c
                goto L72
            L6c:
                boolean r5 = r9.continueReading()     // Catch: java.lang.Throwable -> L4e
                if (r5 != 0) goto L22
            L72:
                r7 = 0
            L73:
                r9.readComplete()     // Catch: java.lang.Throwable -> L48
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L48
                if (r7 == 0) goto L7e
                r8.shutdownInput(r2)     // Catch: java.lang.Throwable -> L48
            L7e:
                r8.readReadyFinally(r1)
                return
            L82:
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L89
                r8.readReadyFinally(r1)
                return
            L89:
                r0 = move-exception
                r9 = r0
                r8.readReadyFinally(r1)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            return super.prepareToClose();
        }
    }

    AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, boolean z5) {
        super(channel, bsdSocket, z5);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueStreamUnsafe();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
            return channelPromise;
        }
        shutdownOutput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.4
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                AbstractKQueueStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
            }
        });
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
            return channelPromise;
        }
        eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.3
            @Override // java.lang.Runnable
            public void run() {
                AbstractKQueueStreamChannel.this.shutdownInput0(channelPromise);
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
        eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.2
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractChannel.AbstractUnsafe) AbstractKQueueStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
            }
        });
        return channelPromise;
    }

    AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, SocketAddress socketAddress) {
        super(channel, bsdSocket, socketAddress);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
    }

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray cleanArray = ((KQueueEventLoop) eventLoop()).cleanArray();
        cleanArray.maxBytes(maxBytesPerGatheringWrite);
        channelOutboundBuffer.forEachFlushedMessage(cleanArray);
        if (cleanArray.count() >= 1) {
            return writeBytesMultiple(channelOutboundBuffer, cleanArray);
        }
        channelOutboundBuffer.removeBytes(0L);
        return 0;
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
            shutdownInput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.5
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    AbstractKQueueStreamChannel.shutdownDone(channelFuture, channelFuture2, channelPromise);
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
        long count = defaultFileRegion.count();
        long transferred = defaultFileRegion.transferred();
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
            this.byteChannel = new KQueueSocketWritableByteChannel();
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
                    writeFilter(false);
                    return;
                }
                doWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= doWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount == 0) {
            writeFilter(false);
            eventLoop().execute(this.flushTask);
        } else {
            writeFilter(true);
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
        throw new Error();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    AbstractKQueueStreamChannel(BsdSocket bsdSocket) {
        this((Channel) null, bsdSocket, AbstractKQueueChannel.isSoErrorZero(bsdSocket));
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
}
