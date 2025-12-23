package io.netty.channel.socket.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DefaultServerSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class NioServerSocketChannel extends AbstractNioMessageChannel implements ServerSocketChannel {
    private final ServerSocketChannelConfig config;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioServerSocketChannel.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.socket.nio.NioServerSocketChannel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class NioServerSocketChannelConfig extends DefaultServerSocketChannelConfig {
        /* synthetic */ NioServerSocketChannelConfig(NioServerSocketChannel nioServerSocketChannel, NioServerSocketChannel nioServerSocketChannel2, ServerSocket serverSocket, AnonymousClass1 anonymousClass1) {
            this(nioServerSocketChannel2, serverSocket);
        }

        private NioServerSocketChannelConfig(NioServerSocketChannel nioServerSocketChannel, ServerSocket serverSocket) {
            super(nioServerSocketChannel, serverSocket);
        }

        private java.nio.channels.ServerSocketChannel jdkChannel() {
            return ((NioServerSocketChannel) this.channel).mo128javaChannel();
        }

        @Override // io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            NioServerSocketChannel.this.clearReadPending();
        }

        @Override // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public <T> T getOption(ChannelOption<T> channelOption) {
            if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
                return (T) NioChannelOption.getOption(jdkChannel(), (NioChannelOption) channelOption);
            }
            return (T) super.getOption(channelOption);
        }

        @Override // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public Map<ChannelOption<?>, Object> getOptions() {
            if (PlatformDependent.javaVersion() >= 7) {
                return getOptions(super.getOptions(), NioChannelOption.getOptions(jdkChannel()));
            }
            return super.getOptions();
        }

        @Override // io.netty.channel.socket.DefaultServerSocketChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
        public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
            if (PlatformDependent.javaVersion() >= 7 && (channelOption instanceof NioChannelOption)) {
                return NioChannelOption.setOption(jdkChannel(), (NioChannelOption) channelOption, t5);
            }
            return super.setOption(channelOption, t5);
        }
    }

    public NioServerSocketChannel() {
        this(newSocket(DEFAULT_SELECTOR_PROVIDER));
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    public NioServerSocketChannel(SelectorProvider selectorProvider) {
        this(newSocket(selectorProvider));
    }

    @Override // io.netty.channel.Channel
    public ServerSocketChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    /* renamed from: javaChannel */
    public java.nio.channels.ServerSocketChannel mo128javaChannel() {
        return (java.nio.channels.ServerSocketChannel) super.mo128javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public NioServerSocketChannel(java.nio.channels.ServerSocketChannel serverSocketChannel) {
        super(null, serverSocketChannel, 16);
        this.config = new NioServerSocketChannelConfig(this, this, mo128javaChannel().socket(), null);
    }

    private static java.nio.channels.ServerSocketChannel newSocket(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openServerSocketChannel();
        } catch (IOException e6) {
            throw new ChannelException("Failed to open a server socket.", e6);
        }
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean closeOnReadError(Throwable th) {
        return super.closeOnReadError(th);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            mo128javaChannel().bind(socketAddress, this.config.getBacklog());
        } else {
            mo128javaChannel().socket().bind(socketAddress, this.config.getBacklog());
        }
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        mo128javaChannel().close();
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        SocketChannel accept = SocketUtils.accept(mo128javaChannel());
        if (accept != null) {
            try {
                list.add(new NioSocketChannel(this, accept));
                return 1;
            } catch (Throwable th) {
                logger.warn("Failed to create a new channel from an accepted socket.", th);
                try {
                    accept.close();
                    return 0;
                } catch (Throwable th2) {
                    logger.warn("Failed to close a socket.", th2);
                    return 0;
                }
            }
        }
        return 0;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        if (isOpen() && mo128javaChannel().socket().isBound()) {
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return SocketUtils.localSocketAddress(mo128javaChannel().socket());
    }
}
