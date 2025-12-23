package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.unix.NativeInetAddress;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollServerSocketChannel extends AbstractEpollServerChannel implements ServerSocketChannel {
    private final EpollServerSocketChannelConfig config;
    private volatile Collection<InetAddress> tcpMd5SigAddresses;

    public EpollServerSocketChannel() {
        super(LinuxSocket.newSocketStream(), false);
        this.tcpMd5SigAddresses = Collections.EMPTY_LIST;
        this.config = new EpollServerSocketChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollServerChannel, io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.epoll.AbstractEpollServerChannel
    protected Channel newChildChannel(int i6, byte[] bArr, int i7, int i8) throws Exception {
        return new EpollSocketChannel(this, new LinuxSocket(i6), NativeInetAddress.address(bArr, i7, i8));
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    void setTcpMd5Sig(Map<InetAddress, byte[]> map) throws IOException {
        this.tcpMd5SigAddresses = TcpMd5Util.newTcpMd5Sigs(this, this.tcpMd5SigAddresses, map);
    }

    Collection<InetAddress> tcpMd5SigAddresses() {
        return this.tcpMd5SigAddresses;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        if (Native.IS_SUPPORTING_TCP_FASTOPEN && this.config.getTcpFastopen() > 0) {
            this.socket.setTcpFastOpen(this.config.getTcpFastopen());
        }
        this.socket.listen(this.config.getBacklog());
        this.active = true;
    }

    public EpollServerSocketChannel(int i6) {
        this(new LinuxSocket(i6));
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollServerSocketChannelConfig config() {
        return this.config;
    }

    EpollServerSocketChannel(LinuxSocket linuxSocket) {
        super(linuxSocket);
        this.tcpMd5SigAddresses = Collections.EMPTY_LIST;
        this.config = new EpollServerSocketChannelConfig(this);
    }

    EpollServerSocketChannel(LinuxSocket linuxSocket, boolean z5) {
        super(linuxSocket, z5);
        this.tcpMd5SigAddresses = Collections.EMPTY_LIST;
        this.config = new EpollServerSocketChannelConfig(this);
    }
}
