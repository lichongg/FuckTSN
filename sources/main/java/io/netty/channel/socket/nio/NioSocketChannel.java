package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.SelectorProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class NioSocketChannel extends AbstractNioByteChannel implements SocketChannel {
    private final SocketChannelConfig config;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioSocketChannel.class);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class NioSocketChannelConfig extends DefaultSocketChannelConfig {
        private volatile int maxBytesPerGatheringWrite;

        private NioSocketChannelConfig(NioSocketChannel nioSocketChannel, Socket socket) {
            super(nioSocketChannel, socket);
            this.maxBytesPerGatheringWrite = Integer.MAX_VALUE;
            calculateMaxBytesPerGatheringWrite();
        }

        private java.nio.channels.SocketChannel jdkChannel() {
            return ((NioSocketChannel) this.channel).mo128javaChannel();
        }

        @Override // io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            NioSocketChannel.this.clearReadPending();
        }

        int getMaxBytesPerGatheringWrite() {
            return this.maxBytesPerGatheringWrite;
        }

        void setMaxBytesPerGatheringWrite(int i6) {
            this.maxBytesPerGatheringWrite = i6;
        }

        @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.socket.SocketChannelConfig
        public NioSocketChannelConfig setSendBufferSize(int i6) {
            super.setSendBufferSize(i6);
            calculateMaxBytesPerGatheringWrite();
            return this;
        }

        private void calculateMaxBytesPerGatheringWrite() {
            if ((getSendBufferSize() << 1) > 0) {
                setMaxBytesPerGatheringWrite(getSendBufferSize() << 1);
            }
        }

        @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public <T> T getOption(ChannelOption<T> channelOption) {
            if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
                return (T) NioChannelOption.getOption(jdkChannel(), (NioChannelOption) channelOption);
            }
            return (T) super.getOption(channelOption);
        }

        @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public Map<ChannelOption<?>, Object> getOptions() {
            if (PlatformDependent.javaVersion() >= 7) {
                return getOptions(super.getOptions(), NioChannelOption.getOptions(jdkChannel()));
            }
            return super.getOptions();
        }

        @Override // io.netty.channel.socket.DefaultSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
            if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
                return NioChannelOption.setOption(jdkChannel(), (NioChannelOption) channelOption, t5);
            }
            return super.setOption(channelOption, t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class NioSocketChannelUnsafe extends AbstractNioByteChannel.NioByteUnsafe {
        private NioSocketChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            try {
                if (!NioSocketChannel.this.mo128javaChannel().isOpen() || NioSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                NioSocketChannel.this.doDeregister();
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public NioSocketChannel() {
        this(DEFAULT_SELECTOR_PROVIDER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            shutdownInput0();
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    public NioSocketChannel(SelectorProvider selectorProvider) {
        this(newSocket(selectorProvider));
    }

    private void adjustMaxBytesPerGatheringWrite(int i6, int i7, int i8) {
        int i9;
        if (i6 == i7) {
            int i10 = i6 << 1;
            if (i10 > i8) {
                ((NioSocketChannelConfig) this.config).setMaxBytesPerGatheringWrite(i10);
                return;
            }
            return;
        }
        if (i6 <= 4096 || i7 >= (i9 = i6 >>> 1)) {
            return;
        }
        ((NioSocketChannelConfig) this.config).setMaxBytesPerGatheringWrite(i9);
    }

    @Override // io.netty.channel.Channel
    public SocketChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            doBind0(socketAddress2);
        }
        try {
            boolean connect = SocketUtils.connect(mo128javaChannel(), socketAddress);
            if (!connect) {
                selectionKey().interestOps(8);
            }
            return connect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    /* renamed from: javaChannel */
    public java.nio.channels.SocketChannel mo128javaChannel() {
        return (java.nio.channels.SocketChannel) super.mo128javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioSocketChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture shutdownOutput = shutdownOutput();
        if (shutdownOutput.isDone()) {
            shutdownOutputDone(shutdownOutput, channelPromise);
            return channelPromise;
        }
        shutdownOutput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.socket.nio.NioSocketChannel.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                NioSocketChannel.this.shutdownOutputDone(channelFuture, channelPromise);
            }
        });
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        NioEventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
            return channelPromise;
        }
        eventLoop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.2
            @Override // java.lang.Runnable
            public void run() {
                NioSocketChannel.this.shutdownInput0(channelPromise);
            }
        });
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        NioEventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(channelPromise);
            return channelPromise;
        }
        eventLoop.execute(new Runnable() { // from class: io.netty.channel.socket.nio.NioSocketChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractChannel.AbstractUnsafe) NioSocketChannel.this.unsafe()).shutdownOutput(channelPromise);
            }
        });
        return channelPromise;
    }

    public NioSocketChannel(java.nio.channels.SocketChannel socketChannel) {
        this(null, socketChannel);
    }

    private void doBind0(SocketAddress socketAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            SocketUtils.bind(mo128javaChannel(), socketAddress);
        } else {
            SocketUtils.bind(mo128javaChannel().socket(), socketAddress);
        }
    }

    private static java.nio.channels.SocketChannel newSocket(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openSocketChannel();
        } catch (IOException e6) {
            throw new ChannelException("Failed to open a socket.", e6);
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
            shutdownInput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.socket.nio.NioSocketChannel.4
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    NioSocketChannel.shutdownDone(channelFuture, channelFuture2, channelPromise);
                }
            });
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        doBind0(socketAddress);
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        super.doClose();
        mo128javaChannel().close();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        doClose();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        if (mo128javaChannel().finishConnect()) {
        } else {
            throw new Error();
        }
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.attemptedBytesRead(byteBuf.writableBytes());
        return byteBuf.writeBytes(mo128javaChannel(), recvBufAllocHandle.attemptedBytesRead());
    }

    @Override // io.netty.channel.AbstractChannel
    protected final void doShutdownOutput() throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            mo128javaChannel().shutdownOutput();
        } else {
            mo128javaChannel().socket().shutdownOutput();
        }
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        java.nio.channels.SocketChannel mo128javaChannel = mo128javaChannel();
        int writeSpinCount = config().getWriteSpinCount();
        while (!channelOutboundBuffer.isEmpty()) {
            int maxBytesPerGatheringWrite = ((NioSocketChannelConfig) this.config).getMaxBytesPerGatheringWrite();
            ByteBuffer[] nioBuffers = channelOutboundBuffer.nioBuffers(1024, maxBytesPerGatheringWrite);
            int nioBufferCount = channelOutboundBuffer.nioBufferCount();
            boolean z5 = false;
            if (nioBufferCount != 0) {
                if (nioBufferCount != 1) {
                    long nioBufferSize = channelOutboundBuffer.nioBufferSize();
                    long write = mo128javaChannel.write(nioBuffers, 0, nioBufferCount);
                    if (write <= 0) {
                        incompleteWrite(true);
                        return;
                    } else {
                        adjustMaxBytesPerGatheringWrite((int) nioBufferSize, (int) write, maxBytesPerGatheringWrite);
                        channelOutboundBuffer.removeBytes(write);
                    }
                } else {
                    ByteBuffer byteBuffer = nioBuffers[0];
                    int remaining = byteBuffer.remaining();
                    int write2 = mo128javaChannel.write(byteBuffer);
                    if (write2 <= 0) {
                        incompleteWrite(true);
                        return;
                    } else {
                        adjustMaxBytesPerGatheringWrite(remaining, write2, maxBytesPerGatheringWrite);
                        channelOutboundBuffer.removeBytes(write2);
                    }
                }
                writeSpinCount--;
            } else {
                writeSpinCount -= doWrite0(channelOutboundBuffer);
            }
            if (writeSpinCount <= 0) {
                if (writeSpinCount < 0) {
                    z5 = true;
                }
                incompleteWrite(z5);
                return;
            }
        }
        clearOpWrite();
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected int doWriteBytes(ByteBuf byteBuf) throws Exception {
        return byteBuf.readBytes(mo128javaChannel(), byteBuf.readableBytes());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected long doWriteFileRegion(FileRegion fileRegion) throws Exception {
        return fileRegion.transferTo(mo128javaChannel(), fileRegion.transferred());
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.SocketChannel mo128javaChannel = mo128javaChannel();
        if (mo128javaChannel.isOpen() && mo128javaChannel.isConnected()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        if (!mo128javaChannel().socket().isInputShutdown() && isActive()) {
            return false;
        }
        return true;
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    protected boolean isInputShutdown0() {
        return isInputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        if (!mo128javaChannel().socket().isOutputShutdown() && isActive()) {
            return false;
        }
        return true;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        Socket socket = mo128javaChannel().socket();
        if ((socket.isInputShutdown() && socket.isOutputShutdown()) || !isActive()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return mo128javaChannel().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return mo128javaChannel().socket().getRemoteSocketAddress();
    }

    public NioSocketChannel(Channel channel, java.nio.channels.SocketChannel socketChannel) {
        super(channel, socketChannel);
        this.config = new NioSocketChannelConfig(this, socketChannel.socket());
    }

    private void shutdownInput0() throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            mo128javaChannel().shutdownInput();
        } else {
            mo128javaChannel().socket().shutdownInput();
        }
    }
}
