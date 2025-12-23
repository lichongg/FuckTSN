package io.netty.channel.kqueue;

import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.EventLoop;
import io.netty.channel.ServerChannel;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractKQueueServerChannel extends AbstractKQueueChannel implements ServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class KQueueServerSocketUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] acceptedAddress;

        KQueueServerSocketUnsafe() {
            super();
            this.acceptedAddress = new byte[26];
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x002f, code lost:
        
            r8.lastBytesRead(-1);
         */
        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r8) {
            /*
                r7 = this;
                io.netty.channel.kqueue.AbstractKQueueServerChannel r0 = io.netty.channel.kqueue.AbstractKQueueServerChannel.this
                io.netty.channel.kqueue.KQueueChannelConfig r0 = r0.config()
                io.netty.channel.kqueue.AbstractKQueueServerChannel r1 = io.netty.channel.kqueue.AbstractKQueueServerChannel.this
                boolean r1 = r1.shouldBreakReadReady(r0)
                if (r1 == 0) goto L12
                r7.clearReadFilter0()
                return
            L12:
                io.netty.channel.kqueue.AbstractKQueueServerChannel r1 = io.netty.channel.kqueue.AbstractKQueueServerChannel.this
                io.netty.channel.ChannelPipeline r1 = r1.pipeline()
                r8.reset(r0)
                r2 = 1
                r8.attemptedBytesRead(r2)
                r7.readReadyBefore()
            L22:
                io.netty.channel.kqueue.AbstractKQueueServerChannel r3 = io.netty.channel.kqueue.AbstractKQueueServerChannel.this     // Catch: java.lang.Throwable -> L33
                io.netty.channel.kqueue.BsdSocket r3 = r3.socket     // Catch: java.lang.Throwable -> L33
                byte[] r4 = r7.acceptedAddress     // Catch: java.lang.Throwable -> L33
                int r3 = r3.accept(r4)     // Catch: java.lang.Throwable -> L33
                r4 = -1
                if (r3 != r4) goto L35
                r8.lastBytesRead(r4)     // Catch: java.lang.Throwable -> L33
                goto L51
            L33:
                r2 = move-exception
                goto L52
            L35:
                r8.lastBytesRead(r2)     // Catch: java.lang.Throwable -> L33
                r8.incMessagesRead(r2)     // Catch: java.lang.Throwable -> L33
                r4 = 0
                r7.readPending = r4     // Catch: java.lang.Throwable -> L33
                io.netty.channel.kqueue.AbstractKQueueServerChannel r5 = io.netty.channel.kqueue.AbstractKQueueServerChannel.this     // Catch: java.lang.Throwable -> L33
                byte[] r6 = r7.acceptedAddress     // Catch: java.lang.Throwable -> L33
                r4 = r6[r4]     // Catch: java.lang.Throwable -> L33
                io.netty.channel.Channel r3 = r5.newChildChannel(r3, r6, r2, r4)     // Catch: java.lang.Throwable -> L33
                r1.fireChannelRead(r3)     // Catch: java.lang.Throwable -> L33
                boolean r3 = r8.continueReading()     // Catch: java.lang.Throwable -> L33
                if (r3 != 0) goto L22
            L51:
                r2 = 0
            L52:
                r8.readComplete()     // Catch: java.lang.Throwable -> L5e
                r1.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L5e
                if (r2 == 0) goto L60
                r1.fireExceptionCaught(r2)     // Catch: java.lang.Throwable -> L5e
                goto L60
            L5e:
                r8 = move-exception
                goto L64
            L60:
                r7.readReadyFinally(r0)
                return
            L64:
                r7.readReadyFinally(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.AbstractKQueueServerChannel.KQueueServerSocketUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }
    }

    AbstractKQueueServerChannel(BsdSocket bsdSocket) {
        this(bsdSocket, AbstractKQueueChannel.isSoErrorZero(bsdSocket));
    }

    abstract Channel newChildChannel(int i6, byte[] bArr, int i7, int i8) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public InetSocketAddress remoteAddress0() {
        return null;
    }

    AbstractKQueueServerChannel(BsdSocket bsdSocket, boolean z5) {
        super((Channel) null, bsdSocket, z5);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof KQueueEventLoop;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueServerSocketUnsafe();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }
}
