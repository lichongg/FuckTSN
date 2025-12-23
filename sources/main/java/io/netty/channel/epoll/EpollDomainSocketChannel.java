package io.netty.channel.epoll;

import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.epoll.AbstractEpollChannel;
import io.netty.channel.epoll.AbstractEpollStreamChannel;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.DomainSocketChannel;
import io.netty.channel.unix.DomainSocketReadMode;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.PeerCredentials;
import java.io.IOException;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollDomainSocketChannel extends AbstractEpollStreamChannel implements DomainSocketChannel {
    private final EpollDomainSocketChannelConfig config;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EpollDomainUnsafe extends AbstractEpollStreamChannel.EpollStreamUnsafe {
        private EpollDomainUnsafe() {
            super();
        }

        /* synthetic */ EpollDomainUnsafe(EpollDomainSocketChannel epollDomainSocketChannel, AnonymousClass1 anonymousClass1) {
            this();
        }

        private void epollInReadFd() {
            if (EpollDomainSocketChannel.this.socket.isInputShutdown()) {
                clearEpollIn0();
                return;
            }
            EpollDomainSocketChannelConfig config = EpollDomainSocketChannel.this.config();
            EpollRecvByteAllocatorHandle recvBufAllocHandle = recvBufAllocHandle();
            recvBufAllocHandle.edgeTriggered(EpollDomainSocketChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline pipeline = EpollDomainSocketChannel.this.pipeline();
            recvBufAllocHandle.reset(config);
            epollInBefore();
            do {
                try {
                    recvBufAllocHandle.lastBytesRead(EpollDomainSocketChannel.this.socket.recvFd());
                    int lastBytesRead = recvBufAllocHandle.lastBytesRead();
                    if (lastBytesRead == -1) {
                        close(voidPromise());
                        return;
                    } else {
                        if (lastBytesRead == 0) {
                            break;
                        }
                        recvBufAllocHandle.incMessagesRead(1);
                        this.readPending = false;
                        pipeline.fireChannelRead((Object) new FileDescriptor(recvBufAllocHandle.lastBytesRead()));
                    }
                } catch (Throwable th) {
                    try {
                        recvBufAllocHandle.readComplete();
                        pipeline.fireChannelReadComplete();
                        pipeline.fireExceptionCaught(th);
                        return;
                    } finally {
                        epollInFinally(config);
                    }
                }
            } while (recvBufAllocHandle.continueReading());
            recvBufAllocHandle.readComplete();
            pipeline.fireChannelReadComplete();
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.EpollStreamUnsafe, io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        void epollInReady() {
            int i6 = AnonymousClass1.$SwitchMap$io$netty$channel$unix$DomainSocketReadMode[EpollDomainSocketChannel.this.config().getReadMode().ordinal()];
            if (i6 == 1) {
                super.epollInReady();
            } else {
                if (i6 != 2) {
                    throw new Error();
                }
                epollInReadFd();
            }
        }
    }

    public EpollDomainSocketChannel() {
        super(LinuxSocket.newSocketDomain(), false);
        this.config = new EpollDomainSocketChannelConfig(this);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.epoll.EpollDomainSocketChannel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$unix$DomainSocketReadMode;

        static {
            int[] iArr = new int[DomainSocketReadMode.values().length];
            $SwitchMap$io$netty$channel$unix$DomainSocketReadMode = iArr;
            try {
                iArr[DomainSocketReadMode.BYTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$unix$DomainSocketReadMode[DomainSocketReadMode.FILE_DESCRIPTORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
        this.local = (DomainSocketAddress) socketAddress;
    }

    @Override // io.netty.channel.epoll.AbstractEpollStreamChannel, io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        return obj instanceof FileDescriptor ? obj : super.filterOutboundMessage(obj);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollStreamChannel, io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollDomainUnsafe(this, null);
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    EpollDomainSocketChannel(Channel channel, FileDescriptor fileDescriptor) {
        super(channel, new LinuxSocket(fileDescriptor.intValue()));
        this.config = new EpollDomainSocketChannelConfig(this);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (super.doConnect(socketAddress, socketAddress2)) {
            this.local = (DomainSocketAddress) socketAddress2;
            this.remote = (DomainSocketAddress) socketAddress;
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.epoll.AbstractEpollStreamChannel
    protected int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object current = channelOutboundBuffer.current();
        if ((current instanceof FileDescriptor) && this.socket.sendFd(((FileDescriptor) current).intValue()) > 0) {
            channelOutboundBuffer.remove();
            return 1;
        }
        return super.doWriteSingle(channelOutboundBuffer);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public EpollDomainSocketChannelConfig config() {
        return this.config;
    }

    public EpollDomainSocketChannel(int i6) {
        super(i6);
        this.config = new EpollDomainSocketChannelConfig(this);
    }

    public EpollDomainSocketChannel(Channel channel, LinuxSocket linuxSocket) {
        super(channel, linuxSocket);
        this.config = new EpollDomainSocketChannelConfig(this);
    }

    public EpollDomainSocketChannel(int i6, boolean z5) {
        super(new LinuxSocket(i6), z5);
        this.config = new EpollDomainSocketChannelConfig(this);
    }
}
