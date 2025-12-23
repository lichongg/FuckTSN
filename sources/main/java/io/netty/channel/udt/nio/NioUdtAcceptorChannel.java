package io.netty.channel.udt.nio;

import com.barchart.udt.TypeUDT;
import com.barchart.udt.nio.ServerSocketChannelUDT;
import com.barchart.udt.nio.SocketChannelUDT;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.udt.DefaultUdtServerChannelConfig;
import io.netty.channel.udt.UdtChannel;
import io.netty.channel.udt.UdtServerChannel;
import io.netty.channel.udt.UdtServerChannelConfig;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class NioUdtAcceptorChannel extends AbstractNioMessageChannel implements UdtServerChannel {
    private final UdtServerChannelConfig config;
    protected static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioUdtAcceptorChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    protected NioUdtAcceptorChannel(ServerSocketChannelUDT serverSocketChannelUDT) {
        super(null, serverSocketChannelUDT, 16);
        try {
            serverSocketChannelUDT.configureBlocking(false);
            this.config = new DefaultUdtServerChannelConfig(this, serverSocketChannelUDT, true);
        } catch (Exception e6) {
            try {
                serverSocketChannelUDT.close();
            } catch (Exception e7) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close channel.", (Throwable) e7);
                }
            }
            throw new ChannelException("Failed to configure channel.", e6);
        }
    }

    protected abstract UdtChannel newConnectorChannel(SocketChannelUDT socketChannelUDT);

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
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
    /* renamed from: javaChannel, reason: merged with bridge method [inline-methods] */
    public ServerSocketChannelUDT mo128javaChannel() {
        return super.mo128javaChannel();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.Channel
    public UdtServerChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        mo128javaChannel().socket().bind(socketAddress, this.config.getBacklog());
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        mo128javaChannel().close();
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        SocketChannelUDT socketChannelUDT = (SocketChannelUDT) SocketUtils.accept(mo128javaChannel());
        if (socketChannelUDT == null) {
            return 0;
        }
        list.add(newConnectorChannel(socketChannelUDT));
        return 1;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return mo128javaChannel().socket().isBound();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return SocketUtils.localSocketAddress(mo128javaChannel().socket());
    }

    protected NioUdtAcceptorChannel(TypeUDT typeUDT) {
        this(NioUdtProvider.newAcceptorChannelUDT(typeUDT));
    }
}
