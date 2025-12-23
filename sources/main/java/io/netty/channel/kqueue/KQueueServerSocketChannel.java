package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.unix.NativeInetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class KQueueServerSocketChannel extends AbstractKQueueServerChannel implements ServerSocketChannel {
    private final KQueueServerSocketChannelConfig config;

    public KQueueServerSocketChannel() {
        super(BsdSocket.newSocketStream(), false);
        this.config = new KQueueServerSocketChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueServerChannel, io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof KQueueEventLoop;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueServerChannel
    protected Channel newChildChannel(int i6, byte[] bArr, int i7, int i8) throws Exception {
        return new KQueueSocketChannel(this, new BsdSocket(i6), NativeInetAddress.address(bArr, i7, i8));
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public KQueueServerSocketChannel(int i6) {
        this(new BsdSocket(i6));
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.socket.listen(this.config.getBacklog());
        this.active = true;
    }

    KQueueServerSocketChannel(BsdSocket bsdSocket) {
        super(bsdSocket);
        this.config = new KQueueServerSocketChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueServerSocketChannelConfig config() {
        return this.config;
    }

    KQueueServerSocketChannel(BsdSocket bsdSocket, boolean z5) {
        super(bsdSocket, z5);
        this.config = new KQueueServerSocketChannelConfig(this);
    }
}
