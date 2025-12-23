package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.ServerChannel;
import io.netty.channel.epoll.AbstractEpollChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractEpollServerChannel extends AbstractEpollChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class EpollServerSocketUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] acceptedAddress;

        EpollServerSocketUnsafe() {
            super();
            this.acceptedAddress = new byte[26];
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe, io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        void epollInReady() {
            EpollChannelConfig config = AbstractEpollServerChannel.this.config();
            if (AbstractEpollServerChannel.this.shouldBreakEpollInReady(config)) {
                clearEpollIn0();
                return;
            }
            EpollRecvByteAllocatorHandle recvBufAllocHandle = recvBufAllocHandle();
            recvBufAllocHandle.edgeTriggered(AbstractEpollServerChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline pipeline = AbstractEpollServerChannel.this.pipeline();
            recvBufAllocHandle.reset(config);
            recvBufAllocHandle.attemptedBytesRead(1);
            epollInBefore();
            do {
                try {
                    recvBufAllocHandle.lastBytesRead(AbstractEpollServerChannel.this.socket.accept(this.acceptedAddress));
                    if (recvBufAllocHandle.lastBytesRead() == -1) {
                        break;
                    }
                    recvBufAllocHandle.incMessagesRead(1);
                    this.readPending = false;
                    AbstractEpollServerChannel abstractEpollServerChannel = AbstractEpollServerChannel.this;
                    int lastBytesRead = recvBufAllocHandle.lastBytesRead();
                    byte[] bArr = this.acceptedAddress;
                    pipeline.fireChannelRead((Object) abstractEpollServerChannel.newChildChannel(lastBytesRead, bArr, 1, bArr[0]));
                } catch (Throwable th) {
                    th = th;
                }
            } while (recvBufAllocHandle.continueReading());
            th = null;
            try {
                recvBufAllocHandle.readComplete();
                pipeline.fireChannelReadComplete();
                if (th != null) {
                    pipeline.fireExceptionCaught(th);
                }
            } finally {
                epollInFinally(config);
            }
        }
    }

    protected AbstractEpollServerChannel(int i6) {
        this(new LinuxSocket(i6), false);
    }

    abstract Channel newChildChannel(int i6, byte[] bArr, int i7, int i8) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress0() {
        return null;
    }

    AbstractEpollServerChannel(LinuxSocket linuxSocket) {
        this(linuxSocket, AbstractEpollChannel.isSoErrorZero(linuxSocket));
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EpollEventLoop;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollServerSocketUnsafe();
    }

    AbstractEpollServerChannel(LinuxSocket linuxSocket, boolean z5) {
        super((Channel) null, linuxSocket, z5);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }
}
