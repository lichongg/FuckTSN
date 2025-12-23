package io.netty.channel.epoll;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.Socket;
import io.netty.channel.unix.UnixChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AlreadyConnectedException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ConnectionPendingException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.UnresolvedAddressException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class AbstractEpollChannel extends AbstractChannel implements UnixChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    protected volatile boolean active;
    private ChannelPromise connectPromise;
    private ScheduledFuture<?> connectTimeoutFuture;
    boolean epollInReadyRunnablePending;
    protected int flags;
    boolean inputClosedSeenErrorOnRead;
    private volatile SocketAddress local;
    private volatile SocketAddress remote;
    private SocketAddress requestedRemoteAddress;
    final LinuxSocket socket;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    protected abstract class AbstractEpollUnsafe extends AbstractChannel.AbstractUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private EpollRecvByteAllocatorHandle allocHandle;
        private final Runnable epollInReadyRunnable;
        boolean maybeMoreDataToRead;
        boolean readPending;

        /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        
            if (r5.this$0.connectTimeoutFuture == null) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void finishConnect() {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch: java.lang.Throwable -> L2f
                boolean r2 = r2.isActive()     // Catch: java.lang.Throwable -> L2f
                boolean r3 = r5.doFinishConnect()     // Catch: java.lang.Throwable -> L2f
                if (r3 != 0) goto Lf
                return
            Lf:
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch: java.lang.Throwable -> L2f
                io.netty.channel.ChannelPromise r3 = io.netty.channel.epoll.AbstractEpollChannel.access$100(r3)     // Catch: java.lang.Throwable -> L2f
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L2f
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.epoll.AbstractEpollChannel.access$300(r2)
                if (r2 == 0) goto L29
            L20:
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.epoll.AbstractEpollChannel.access$300(r2)
                r2.cancel(r1)
            L29:
                io.netty.channel.epoll.AbstractEpollChannel r1 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.channel.epoll.AbstractEpollChannel.access$102(r1, r0)
                return
            L2f:
                r2 = move-exception
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch: java.lang.Throwable -> L4c
                io.netty.channel.ChannelPromise r3 = io.netty.channel.epoll.AbstractEpollChannel.access$100(r3)     // Catch: java.lang.Throwable -> L4c
                io.netty.channel.epoll.AbstractEpollChannel r4 = io.netty.channel.epoll.AbstractEpollChannel.this     // Catch: java.lang.Throwable -> L4c
                java.net.SocketAddress r4 = io.netty.channel.epoll.AbstractEpollChannel.access$200(r4)     // Catch: java.lang.Throwable -> L4c
                java.lang.Throwable r2 = r5.annotateConnectException(r2, r4)     // Catch: java.lang.Throwable -> L4c
                r5.fulfillConnectPromise(r3, r2)     // Catch: java.lang.Throwable -> L4c
                io.netty.channel.epoll.AbstractEpollChannel r2 = io.netty.channel.epoll.AbstractEpollChannel.this
                java.util.concurrent.ScheduledFuture r2 = io.netty.channel.epoll.AbstractEpollChannel.access$300(r2)
                if (r2 == 0) goto L29
                goto L20
            L4c:
                r2 = move-exception
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.epoll.AbstractEpollChannel.access$300(r3)
                if (r3 == 0) goto L5e
                io.netty.channel.epoll.AbstractEpollChannel r3 = io.netty.channel.epoll.AbstractEpollChannel.this
                java.util.concurrent.ScheduledFuture r3 = io.netty.channel.epoll.AbstractEpollChannel.access$300(r3)
                r3.cancel(r1)
            L5e:
                io.netty.channel.epoll.AbstractEpollChannel r1 = io.netty.channel.epoll.AbstractEpollChannel.this
                io.netty.channel.epoll.AbstractEpollChannel.access$102(r1, r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.finishConnect():void");
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, boolean z5) {
            if (channelPromise == null) {
                return;
            }
            AbstractEpollChannel.this.active = true;
            boolean isActive = AbstractEpollChannel.this.isActive();
            boolean trySuccess = channelPromise.trySuccess();
            if (!z5 && isActive) {
                AbstractEpollChannel.this.pipeline().fireChannelActive();
            }
            if (trySuccess) {
                return;
            }
            close(voidPromise());
        }

        protected final void clearEpollIn0() {
            try {
                this.readPending = false;
                AbstractEpollChannel.this.clearFlag(Native.EPOLLIN);
            } catch (IOException e6) {
                AbstractEpollChannel.this.pipeline().fireExceptionCaught((Throwable) e6);
                AbstractEpollChannel.this.unsafe().close(AbstractEpollChannel.this.unsafe().voidPromise());
            }
        }

        final void epollInBefore() {
            this.maybeMoreDataToRead = false;
        }

        abstract void epollInReady();

        protected AbstractEpollUnsafe() {
            super();
            this.epollInReadyRunnable = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollUnsafe abstractEpollUnsafe = AbstractEpollUnsafe.this;
                    AbstractEpollChannel.this.epollInReadyRunnablePending = false;
                    abstractEpollUnsafe.epollInReady();
                }
            };
        }

        private void clearEpollRdHup() {
            try {
                AbstractEpollChannel.this.clearFlag(Native.EPOLLRDHUP);
            } catch (IOException e6) {
                AbstractEpollChannel.this.pipeline().fireExceptionCaught((Throwable) e6);
                close(voidPromise());
            }
        }

        private boolean doFinishConnect() throws Exception {
            if (!AbstractEpollChannel.this.socket.finishConnect()) {
                AbstractEpollChannel.this.setFlag(Native.EPOLLOUT);
                return false;
            }
            AbstractEpollChannel.this.clearFlag(Native.EPOLLOUT);
            if (AbstractEpollChannel.this.requestedRemoteAddress instanceof InetSocketAddress) {
                AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
                abstractEpollChannel.remote = UnixChannelUtil.computeRemoteAddr((InetSocketAddress) abstractEpollChannel.requestedRemoteAddress, AbstractEpollChannel.this.socket.remoteAddress());
            }
            AbstractEpollChannel.this.requestedRemoteAddress = null;
            return true;
        }

        private void fireEventAndClose(Object obj) {
            AbstractEpollChannel.this.pipeline().fireUserEventTriggered(obj);
            close(voidPromise());
        }

        final void epollInFinally(ChannelConfig channelConfig) {
            boolean z5;
            this.maybeMoreDataToRead = this.allocHandle.maybeMoreDataToRead();
            if (this.allocHandle.isReceivedRdHup() || ((z5 = this.readPending) && this.maybeMoreDataToRead)) {
                executeEpollInReadyRunnable(channelConfig);
            } else {
                if (z5 || channelConfig.isAutoRead()) {
                    return;
                }
                AbstractEpollChannel.this.clearEpollIn();
            }
        }

        final void epollOutReady() {
            if (AbstractEpollChannel.this.connectPromise != null) {
                finishConnect();
            } else {
                if (AbstractEpollChannel.this.socket.isOutputShutdown()) {
                    return;
                }
                super.flush0();
            }
        }

        final void executeEpollInReadyRunnable(ChannelConfig channelConfig) {
            AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
            if (abstractEpollChannel.epollInReadyRunnablePending || !abstractEpollChannel.isActive() || AbstractEpollChannel.this.shouldBreakEpollInReady(channelConfig)) {
                return;
            }
            AbstractEpollChannel abstractEpollChannel2 = AbstractEpollChannel.this;
            abstractEpollChannel2.epollInReadyRunnablePending = true;
            abstractEpollChannel2.eventLoop().execute(this.epollInReadyRunnable);
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected final void flush0() {
            if (AbstractEpollChannel.this.isFlagSet(Native.EPOLLOUT)) {
                return;
            }
            super.flush0();
        }

        EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
            return new EpollRecvByteAllocatorHandle(extendedHandle);
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe, io.netty.channel.Channel.Unsafe
        public EpollRecvByteAllocatorHandle recvBufAllocHandle() {
            if (this.allocHandle == null) {
                this.allocHandle = newEpollHandle((RecvByteBufAllocator.ExtendedHandle) super.recvBufAllocHandle());
            }
            return this.allocHandle;
        }

        void shutdownInput(boolean z5) {
            if (AbstractEpollChannel.this.socket.isInputShutdown()) {
                if (z5) {
                    return;
                }
                AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
                abstractEpollChannel.inputClosedSeenErrorOnRead = true;
                abstractEpollChannel.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
                return;
            }
            if (!AbstractEpollChannel.isAllowHalfClosure(AbstractEpollChannel.this.config())) {
                close(voidPromise());
                return;
            }
            try {
                AbstractEpollChannel.this.socket.shutdown(true, false);
            } catch (IOException unused) {
                fireEventAndClose(ChannelInputShutdownEvent.INSTANCE);
                return;
            } catch (NotYetConnectedException unused2) {
            }
            AbstractEpollChannel.this.clearEpollIn();
            AbstractEpollChannel.this.pipeline().fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(final SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            if (channelPromise.setUncancellable() && ensureOpen(channelPromise)) {
                try {
                    if (AbstractEpollChannel.this.connectPromise == null) {
                        boolean isActive = AbstractEpollChannel.this.isActive();
                        if (!AbstractEpollChannel.this.doConnect(socketAddress, socketAddress2)) {
                            AbstractEpollChannel.this.connectPromise = channelPromise;
                            AbstractEpollChannel.this.requestedRemoteAddress = socketAddress;
                            int connectTimeoutMillis = AbstractEpollChannel.this.config().getConnectTimeoutMillis();
                            if (connectTimeoutMillis > 0) {
                                AbstractEpollChannel abstractEpollChannel = AbstractEpollChannel.this;
                                abstractEpollChannel.connectTimeoutFuture = abstractEpollChannel.eventLoop().schedule(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ChannelPromise channelPromise2 = AbstractEpollChannel.this.connectPromise;
                                        ConnectTimeoutException connectTimeoutException = new ConnectTimeoutException("connection timed out: " + socketAddress);
                                        if (channelPromise2 == null || !channelPromise2.tryFailure(connectTimeoutException)) {
                                            return;
                                        }
                                        AbstractEpollUnsafe abstractEpollUnsafe = AbstractEpollUnsafe.this;
                                        abstractEpollUnsafe.close(abstractEpollUnsafe.voidPromise());
                                    }
                                }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
                            }
                            channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe.3
                                @Override // io.netty.util.concurrent.GenericFutureListener
                                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                    if (channelFuture.isCancelled()) {
                                        if (AbstractEpollChannel.this.connectTimeoutFuture != null) {
                                            AbstractEpollChannel.this.connectTimeoutFuture.cancel(false);
                                        }
                                        AbstractEpollChannel.this.connectPromise = null;
                                        AbstractEpollUnsafe abstractEpollUnsafe = AbstractEpollUnsafe.this;
                                        abstractEpollUnsafe.close(abstractEpollUnsafe.voidPromise());
                                    }
                                }
                            });
                            return;
                        }
                        fulfillConnectPromise(channelPromise, isActive);
                        return;
                    }
                    throw new ConnectionPendingException();
                } catch (Throwable th) {
                    closeIfClosed();
                    channelPromise.tryFailure(annotateConnectException(th, socketAddress));
                }
            }
        }

        final void epollRdHupReady() {
            recvBufAllocHandle().receivedRdHup();
            if (AbstractEpollChannel.this.isActive()) {
                epollInReady();
            } else {
                shutdownInput(true);
            }
            clearEpollRdHup();
        }

        private void fulfillConnectPromise(ChannelPromise channelPromise, Throwable th) {
            if (channelPromise == null) {
                return;
            }
            channelPromise.tryFailure(th);
            closeIfClosed();
        }
    }

    AbstractEpollChannel(LinuxSocket linuxSocket) {
        this((Channel) null, linuxSocket, false);
    }

    @Override // io.netty.channel.Channel
    public abstract EpollChannelConfig config();

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.active = false;
        this.inputClosedSeenErrorOnRead = true;
        try {
            ChannelPromise channelPromise = this.connectPromise;
            if (channelPromise != null) {
                channelPromise.tryFailure(new ClosedChannelException());
                this.connectPromise = null;
            }
            ScheduledFuture<?> scheduledFuture = this.connectTimeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.connectTimeoutFuture = null;
            }
            if (isRegistered()) {
                EventLoop eventLoop = eventLoop();
                if (eventLoop.inEventLoop()) {
                    doDeregister();
                } else {
                    eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AbstractEpollChannel.this.doDeregister();
                            } catch (Throwable th) {
                                AbstractEpollChannel.this.pipeline().fireExceptionCaught(th);
                            }
                        }
                    });
                }
            }
            this.socket.close();
        } catch (Throwable th) {
            this.socket.close();
            throw th;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        this.epollInReadyRunnablePending = false;
        ((EpollEventLoop) eventLoop()).add(this);
    }

    protected final ByteBuf newDirectBuffer(ByteBuf byteBuf) {
        return newDirectBuffer(byteBuf, byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public abstract AbstractEpollUnsafe newUnsafe();

    AbstractEpollChannel(Channel channel, LinuxSocket linuxSocket, boolean z5) {
        super(channel);
        this.flags = Native.EPOLLET;
        this.socket = (LinuxSocket) ObjectUtil.checkNotNull(linuxSocket, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        this.active = z5;
        if (z5) {
            this.local = linuxSocket.localAddress();
            this.remote = linuxSocket.remoteAddress();
        }
    }

    private boolean doConnect0(SocketAddress socketAddress) throws Exception {
        try {
            boolean connect = this.socket.connect(socketAddress);
            if (!connect) {
                setFlag(Native.EPOLLOUT);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return channelConfig instanceof EpollDomainSocketChannelConfig ? ((EpollDomainSocketChannelConfig) channelConfig).isAllowHalfClosure() : (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        if (socketAddress instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress);
        }
        this.socket.bind(socketAddress);
        this.local = this.socket.localAddress();
    }

    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 instanceof InetSocketAddress) {
            checkResolvable((InetSocketAddress) socketAddress2);
        }
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress != null) {
            checkResolvable(inetSocketAddress);
        }
        if (this.remote != null) {
            throw new AlreadyConnectedException();
        }
        if (socketAddress2 != null) {
            this.socket.bind(socketAddress2);
        }
        boolean doConnect0 = doConnect0(socketAddress);
        if (doConnect0) {
            if (inetSocketAddress != null) {
                socketAddress = UnixChannelUtil.computeRemoteAddr(inetSocketAddress, this.socket.remoteAddress());
            }
            this.remote = socketAddress;
        }
        this.local = this.socket.localAddress();
        return doConnect0;
    }

    @Override // io.netty.channel.unix.UnixChannel
    public final FileDescriptor fd() {
        return this.socket;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.active;
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    boolean isFlagSet(int i6) {
        return (i6 & this.flags) != 0;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.socket.isOpen();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    protected final ByteBuf newDirectBuffer(Object obj, ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            ReferenceCountUtil.release(obj);
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBufAllocator alloc = alloc();
        if (alloc.isDirectBufferPooled()) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        ByteBuf threadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
        if (threadLocalDirectBuffer == null) {
            return newDirectBuffer0(obj, byteBuf, alloc, readableBytes);
        }
        threadLocalDirectBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        ReferenceCountUtil.safeRelease(obj);
        return threadLocalDirectBuffer;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.remote;
    }

    final boolean shouldBreakEpollInReady(ChannelConfig channelConfig) {
        if (this.socket.isInputShutdown()) {
            return this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig);
        }
        return false;
    }

    protected static void checkResolvable(InetSocketAddress inetSocketAddress) {
        if (!inetSocketAddress.isUnresolved()) {
        } else {
            throw new UnresolvedAddressException();
        }
    }

    static boolean isSoErrorZero(Socket socket) {
        try {
            if (socket.getSoError() == 0) {
                return true;
            }
            return false;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    private void modifyEvents() throws IOException {
        if (isOpen() && isRegistered()) {
            ((EpollEventLoop) eventLoop()).modify(this);
        }
    }

    private static ByteBuf newDirectBuffer0(Object obj, ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, int i6) {
        ByteBuf directBuffer = byteBufAllocator.directBuffer(i6);
        directBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i6);
        ReferenceCountUtil.safeRelease(obj);
        return directBuffer;
    }

    final void clearEpollIn() {
        if (isRegistered()) {
            EventLoop eventLoop = eventLoop();
            final AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollUnsafe) unsafe();
            if (eventLoop.inEventLoop()) {
                abstractEpollUnsafe.clearEpollIn0();
                return;
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (abstractEpollUnsafe.readPending || AbstractEpollChannel.this.config().isAutoRead()) {
                            return;
                        }
                        abstractEpollUnsafe.clearEpollIn0();
                    }
                });
                return;
            }
        }
        this.flags &= ~Native.EPOLLIN;
    }

    void clearFlag(int i6) throws IOException {
        if (isFlagSet(i6)) {
            this.flags = (~i6) & this.flags;
            modifyEvents();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected final void doBeginRead() throws Exception {
        AbstractEpollUnsafe abstractEpollUnsafe = (AbstractEpollUnsafe) unsafe();
        abstractEpollUnsafe.readPending = true;
        setFlag(Native.EPOLLIN);
        if (abstractEpollUnsafe.maybeMoreDataToRead) {
            abstractEpollUnsafe.executeEpollInReadyRunnable(config());
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((EpollEventLoop) eventLoop()).remove(this);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    protected final int doReadBytes(ByteBuf byteBuf) throws Exception {
        int read;
        int writerIndex = byteBuf.writerIndex();
        unsafe().recvBufAllocHandle().attemptedBytesRead(byteBuf.writableBytes());
        if (byteBuf.hasMemoryAddress()) {
            read = this.socket.readAddress(byteBuf.memoryAddress(), writerIndex, byteBuf.capacity());
        } else {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(writerIndex, byteBuf.writableBytes());
            read = this.socket.read(internalNioBuffer, internalNioBuffer.position(), internalNioBuffer.limit());
        }
        if (read > 0) {
            byteBuf.writerIndex(writerIndex + read);
        }
        return read;
    }

    protected final int doWriteBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        ByteBuffer nioBuffer;
        if (byteBuf.hasMemoryAddress()) {
            int writeAddress = this.socket.writeAddress(byteBuf.memoryAddress(), byteBuf.readerIndex(), byteBuf.writerIndex());
            if (writeAddress > 0) {
                channelOutboundBuffer.removeBytes(writeAddress);
                return 1;
            }
            return Integer.MAX_VALUE;
        }
        if (byteBuf.nioBufferCount() == 1) {
            nioBuffer = byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes());
        } else {
            nioBuffer = byteBuf.nioBuffer();
        }
        int write = this.socket.write(nioBuffer, nioBuffer.position(), nioBuffer.limit());
        if (write > 0) {
            nioBuffer.position(nioBuffer.position() + write);
            channelOutboundBuffer.removeBytes(write);
            return 1;
        }
        return Integer.MAX_VALUE;
    }

    void setFlag(int i6) throws IOException {
        if (!isFlagSet(i6)) {
            this.flags = i6 | this.flags;
            modifyEvents();
        }
    }

    AbstractEpollChannel(Channel channel, LinuxSocket linuxSocket, SocketAddress socketAddress) {
        super(channel);
        this.flags = Native.EPOLLET;
        this.socket = (LinuxSocket) ObjectUtil.checkNotNull(linuxSocket, IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
        this.active = true;
        this.remote = socketAddress;
        this.local = linuxSocket.localAddress();
    }
}
