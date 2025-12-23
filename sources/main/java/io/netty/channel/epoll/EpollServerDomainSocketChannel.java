package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.ServerDomainSocketChannel;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollServerDomainSocketChannel extends AbstractEpollServerChannel implements ServerDomainSocketChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) EpollServerDomainSocketChannel.class);
    private final EpollServerChannelConfig config;
    private volatile DomainSocketAddress local;

    public EpollServerDomainSocketChannel() {
        super(LinuxSocket.newSocketDomain(), false);
        this.config = new EpollServerChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
        this.socket.listen(this.config.getBacklog());
        this.local = (DomainSocketAddress) socketAddress;
        this.active = true;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        DomainSocketAddress domainSocketAddress;
        boolean delete;
        try {
            super.doClose();
            if (domainSocketAddress != null) {
                if (delete) {
                    return;
                }
            }
        } finally {
            domainSocketAddress = this.local;
            if (domainSocketAddress != null && !new File(domainSocketAddress.path()).delete()) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Failed to delete a domain socket file: {}", domainSocketAddress.path());
                }
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    @Override // io.netty.channel.epoll.AbstractEpollServerChannel
    protected Channel newChildChannel(int i6, byte[] bArr, int i7, int i8) throws Exception {
        return new EpollDomainSocketChannel(this, new Socket(i6));
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    public EpollServerDomainSocketChannel(int i6) {
        super(i6);
        this.config = new EpollServerChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollServerChannelConfig config() {
        return this.config;
    }

    EpollServerDomainSocketChannel(LinuxSocket linuxSocket) {
        super(linuxSocket);
        this.config = new EpollServerChannelConfig(this);
    }

    EpollServerDomainSocketChannel(LinuxSocket linuxSocket, boolean z5) {
        super(linuxSocket, z5);
        this.config = new EpollServerChannelConfig(this);
    }
}
