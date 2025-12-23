package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.kqueue.AbstractKQueueStreamChannel;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.channel.unix.DomainSocketChannel;
import io.netty.channel.unix.DomainSocketReadMode;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.PeerCredentials;
import java.io.IOException;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class KQueueDomainSocketChannel extends AbstractKQueueStreamChannel implements DomainSocketChannel {
    private final KQueueDomainSocketChannelConfig config;
    private volatile DomainSocketAddress local;
    private volatile DomainSocketAddress remote;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class KQueueDomainUnsafe extends AbstractKQueueStreamChannel.KQueueStreamUnsafe {
        private KQueueDomainUnsafe() {
            super();
        }

        /* synthetic */ KQueueDomainUnsafe(KQueueDomainSocketChannel kQueueDomainSocketChannel, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            r1.readComplete();
            r2.fireChannelReadComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void readReadyFd() {
            /*
                r6 = this;
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.kqueue.BsdSocket r0 = r0.socket
                boolean r0 = r0.isInputShutdown()
                if (r0 == 0) goto Le
                super.clearReadFilter0()
                return
            Le:
                io.netty.channel.kqueue.KQueueDomainSocketChannel r0 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.kqueue.KQueueDomainSocketChannelConfig r0 = r0.config()
                io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r1 = r6.recvBufAllocHandle()
                io.netty.channel.kqueue.KQueueDomainSocketChannel r2 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this
                io.netty.channel.ChannelPipeline r2 = r2.pipeline()
                r1.reset(r0)
                r6.readReadyBefore()
            L24:
                io.netty.channel.kqueue.KQueueDomainSocketChannel r3 = io.netty.channel.kqueue.KQueueDomainSocketChannel.this     // Catch: java.lang.Throwable -> L4a
                io.netty.channel.kqueue.BsdSocket r3 = r3.socket     // Catch: java.lang.Throwable -> L4a
                int r3 = r3.recvFd()     // Catch: java.lang.Throwable -> L4a
                r4 = -1
                if (r3 == r4) goto L59
                r4 = 0
                if (r3 == 0) goto L4c
                r5 = 1
                r1.lastBytesRead(r5)     // Catch: java.lang.Throwable -> L4a
                r1.incMessagesRead(r5)     // Catch: java.lang.Throwable -> L4a
                r6.readPending = r4     // Catch: java.lang.Throwable -> L4a
                io.netty.channel.unix.FileDescriptor r4 = new io.netty.channel.unix.FileDescriptor     // Catch: java.lang.Throwable -> L4a
                r4.<init>(r3)     // Catch: java.lang.Throwable -> L4a
                r2.fireChannelRead(r4)     // Catch: java.lang.Throwable -> L4a
                boolean r3 = r1.continueReading()     // Catch: java.lang.Throwable -> L4a
                if (r3 != 0) goto L24
                goto L4f
            L4a:
                r3 = move-exception
                goto L67
            L4c:
                r1.lastBytesRead(r4)     // Catch: java.lang.Throwable -> L4a
            L4f:
                r1.readComplete()     // Catch: java.lang.Throwable -> L4a
                r2.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L4a
                r6.readReadyFinally(r0)
                return
            L59:
                r1.lastBytesRead(r4)     // Catch: java.lang.Throwable -> L4a
                io.netty.channel.ChannelPromise r3 = r6.voidPromise()     // Catch: java.lang.Throwable -> L4a
                r6.close(r3)     // Catch: java.lang.Throwable -> L4a
                r6.readReadyFinally(r0)
                return
            L67:
                r1.readComplete()     // Catch: java.lang.Throwable -> L74
                r2.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L74
                r2.fireExceptionCaught(r3)     // Catch: java.lang.Throwable -> L74
                r6.readReadyFinally(r0)
                return
            L74:
                r1 = move-exception
                r6.readReadyFinally(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDomainSocketChannel.KQueueDomainUnsafe.readReadyFd():void");
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel.KQueueStreamUnsafe, io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            int i6 = AnonymousClass1.$SwitchMap$io$netty$channel$unix$DomainSocketReadMode[KQueueDomainSocketChannel.this.config().getReadMode().ordinal()];
            if (i6 == 1) {
                super.readReady(kQueueRecvByteAllocatorHandle);
            } else {
                if (i6 != 2) {
                    throw new Error();
                }
                readReadyFd();
            }
        }
    }

    public KQueueDomainSocketChannel() {
        super((Channel) null, BsdSocket.newSocketDomain(), false);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.channel.kqueue.KQueueDomainSocketChannel$1, reason: invalid class name */
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
        this.local = (DomainSocketAddress) socketAddress;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel, io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        return obj instanceof FileDescriptor ? obj : super.filterOutboundMessage(obj);
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress localAddress() {
        return (DomainSocketAddress) super.localAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress localAddress0() {
        return this.local;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel, io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDomainUnsafe(this, null);
    }

    public PeerCredentials peerCredentials() throws IOException {
        return this.socket.getPeerCredentials();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public DomainSocketAddress remoteAddress() {
        return (DomainSocketAddress) super.remoteAddress();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public DomainSocketAddress remoteAddress0() {
        return this.remote;
    }

    public KQueueDomainSocketChannel(int i6) {
        this(null, new BsdSocket(i6));
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (super.doConnect(socketAddress, socketAddress2)) {
            this.local = (DomainSocketAddress) socketAddress2;
            this.remote = (DomainSocketAddress) socketAddress;
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueStreamChannel
    protected int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object current = channelOutboundBuffer.current();
        if ((current instanceof FileDescriptor) && this.socket.sendFd(((FileDescriptor) current).intValue()) > 0) {
            channelOutboundBuffer.remove();
            return 1;
        }
        return super.doWriteSingle(channelOutboundBuffer);
    }

    KQueueDomainSocketChannel(Channel channel, BsdSocket bsdSocket) {
        super(channel, bsdSocket, true);
        this.config = new KQueueDomainSocketChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueDomainSocketChannelConfig config() {
        return this.config;
    }
}
