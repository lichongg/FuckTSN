package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.AbstractEpollStreamChannel;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollSocketChannel extends AbstractEpollStreamChannel implements SocketChannel {
    private final EpollSocketChannelConfig config;
    private volatile Collection<InetAddress> tcpMd5SigAddresses;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.epoll.EpollSocketChannel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EpollSocketChannelUnsafe extends AbstractEpollStreamChannel.EpollStreamUnsafe {
        private EpollSocketChannelUnsafe() {
            super();
        }

        /* synthetic */ EpollSocketChannelUnsafe(EpollSocketChannel epollSocketChannel, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe, io.netty.channel.AbstractChannel.AbstractUnsafe
        protected Executor prepareToClose() {
            try {
                if (!EpollSocketChannel.this.isOpen() || EpollSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                ((EpollEventLoop) EpollSocketChannel.this.eventLoop()).remove(EpollSocketChannel.this);
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public EpollSocketChannel() {
        super(LinuxSocket.newSocketStream(), false);
        this.tcpMd5SigAddresses = Collections.EMPTY_LIST;
        this.config = new EpollSocketChannelConfig(this);
    }

    public EpollTcpInfo tcpInfo() {
        return tcpInfo(new EpollTcpInfo());
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollStreamChannel, io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollSocketChannelUnsafe(this, null);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    void setTcpMd5Sig(Map<InetAddress, byte[]> map) throws IOException {
        this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, map);
    }

    public EpollTcpInfo tcpInfo(EpollTcpInfo epollTcpInfo) {
        try {
            this.socket.getTcpInfo(epollTcpInfo);
            return epollTcpInfo;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannel(int i6) {
        super(i6);
        this.tcpMd5SigAddresses = Collections.EMPTY_LIST;
        this.config = new EpollSocketChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollSocketChannelConfig config() {
        return this.config;
    }

    EpollSocketChannel(LinuxSocket linuxSocket, boolean z5) {
        super(linuxSocket, z5);
        this.tcpMd5SigAddresses = Collections.EMPTY_LIST;
        this.config = new EpollSocketChannelConfig(this);
    }

    EpollSocketChannel(Channel channel, LinuxSocket linuxSocket, InetSocketAddress inetSocketAddress) {
        super(channel, linuxSocket, inetSocketAddress);
        this.tcpMd5SigAddresses = Collections.EMPTY_LIST;
        this.config = new EpollSocketChannelConfig(this);
        if (channel instanceof EpollServerSocketChannel) {
            this.tcpMd5SigAddresses = ((EpollServerSocketChannel) channel).tcpMd5SigAddresses();
        }
    }
}
