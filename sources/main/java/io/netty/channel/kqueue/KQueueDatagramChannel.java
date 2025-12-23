package io.netty.channel.kqueue;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.kqueue.AbstractKQueueChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class KQueueDatagramChannel extends AbstractKQueueChannel implements DatagramChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final KQueueDatagramChannelConfig config;
    private volatile boolean connected;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + v0.f47961e + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) InetSocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class KQueueDatagramChannelUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        KQueueDatagramChannelUnsafe() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00fb A[EDGE_INSN: B:24:0x00fb->B:25:0x00fb BREAK  A[LOOP:0: B:9:0x0029->B:35:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0103 A[Catch: all -> 0x00f9, TRY_LEAVE, TryCatch #0 {all -> 0x00f9, blocks: (B:25:0x00fb, B:27:0x0103, B:57:0x00f5), top: B:56:0x00f5 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:0: B:9:0x0029->B:35:?, LOOP_END, SYNTHETIC] */
        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle r12) {
            /*
                Method dump skipped, instructions count: 270
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDatagramChannel.KQueueDatagramChannelUnsafe.readReady(io.netty.channel.kqueue.KQueueRecvByteAllocatorHandle):void");
        }
    }

    public KQueueDatagramChannel() {
        super((Channel) null, BsdSocket.newSocketDgram(), false);
        this.config = new KQueueDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean doWriteMessage(java.lang.Object r12) throws java.lang.Exception {
        /*
            r11 = this;
            boolean r0 = r12 instanceof io.netty.channel.AddressedEnvelope
            if (r0 == 0) goto L13
            io.netty.channel.AddressedEnvelope r12 = (io.netty.channel.AddressedEnvelope) r12
            java.lang.Object r0 = r12.content()
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            java.net.SocketAddress r12 = r12.recipient()
            java.net.InetSocketAddress r12 = (java.net.InetSocketAddress) r12
            goto L17
        L13:
            r0 = r12
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            r12 = 0
        L17:
            int r1 = r0.readableBytes()
            r2 = 1
            if (r1 != 0) goto L1f
            return r2
        L1f:
            boolean r1 = r0.hasMemoryAddress()
            r3 = 0
            if (r1 == 0) goto L52
            long r5 = r0.memoryAddress()
            if (r12 != 0) goto L3b
            io.netty.channel.kqueue.BsdSocket r12 = r11.socket
            int r1 = r0.readerIndex()
            int r0 = r0.writerIndex()
            int r12 = r12.writeAddress(r5, r1, r0)
            goto La5
        L3b:
            io.netty.channel.kqueue.BsdSocket r4 = r11.socket
            int r7 = r0.readerIndex()
            int r8 = r0.writerIndex()
            java.net.InetAddress r9 = r12.getAddress()
            int r10 = r12.getPort()
            int r12 = r4.sendToAddress(r5, r7, r8, r9, r10)
            goto La5
        L52:
            int r1 = r0.nioBufferCount()
            if (r1 <= r2) goto L89
            io.netty.channel.EventLoop r1 = r11.eventLoop()
            io.netty.channel.kqueue.KQueueEventLoop r1 = (io.netty.channel.kqueue.KQueueEventLoop) r1
            io.netty.channel.unix.IovArray r1 = r1.cleanArray()
            r1.add(r0)
            int r7 = r1.count()
            if (r12 != 0) goto L76
            io.netty.channel.kqueue.BsdSocket r12 = r11.socket
            long r0 = r1.memoryAddress(r3)
            long r0 = r12.writevAddresses(r0, r7)
            goto Lbe
        L76:
            io.netty.channel.kqueue.BsdSocket r4 = r11.socket
            long r5 = r1.memoryAddress(r3)
            java.net.InetAddress r8 = r12.getAddress()
            int r9 = r12.getPort()
            int r12 = r4.sendToAddresses(r5, r7, r8, r9)
            goto La5
        L89:
            int r1 = r0.readerIndex()
            int r4 = r0.readableBytes()
            java.nio.ByteBuffer r6 = r0.internalNioBuffer(r1, r4)
            if (r12 != 0) goto La7
            io.netty.channel.kqueue.BsdSocket r12 = r11.socket
            int r0 = r6.position()
            int r1 = r6.limit()
            int r12 = r12.write(r6, r0, r1)
        La5:
            long r0 = (long) r12
            goto Lbe
        La7:
            io.netty.channel.kqueue.BsdSocket r5 = r11.socket
            int r7 = r6.position()
            int r8 = r6.limit()
            java.net.InetAddress r9 = r12.getAddress()
            int r10 = r12.getPort()
            int r12 = r5.sendTo(r6, r7, r8, r9, r10)
            goto La5
        Lbe:
            r4 = 0
            int r12 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r12 <= 0) goto Lc5
            return r2
        Lc5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.kqueue.KQueueDatagramChannel.doWriteMessage(java.lang.Object):boolean");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        if (inetAddress == null) {
            throw new NullPointerException("multicastAddress");
        }
        if (inetAddress2 == null) {
            throw new NullPointerException("sourceToBlock");
        }
        if (networkInterface == null) {
            throw new NullPointerException("networkInterface");
        }
        channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
        return channelPromise;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
        this.active = false;
        this.connected = false;
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf content = datagramPacket.content();
            return UnixChannelUtil.isBufferCopyNeededForWrite(content) ? new DatagramPacket(newDirectBuffer(datagramPacket, content), datagramPacket.recipient()) : obj;
        }
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        }
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if ((addressedEnvelope.content() instanceof ByteBuf) && (addressedEnvelope.recipient() == null || (addressedEnvelope.recipient() instanceof InetSocketAddress))) {
                ByteBuf byteBuf2 = (ByteBuf) addressedEnvelope.content();
                return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf2) ? new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf2), (InetSocketAddress) addressedEnvelope.recipient()) : addressedEnvelope;
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public boolean isActive() {
        if (this.socket.isOpen()) {
            return (this.config.getActiveOnOpen() && isRegistered()) || this.active;
        }
        return false;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.connected;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return joinGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (SocketException e6) {
            channelPromise.setFailure((Throwable) e6);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            return leaveGroup(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), null, channelPromise);
        } catch (SocketException e6) {
            channelPromise.setFailure((Throwable) e6);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueDatagramChannelUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public KQueueDatagramChannel(int i6) {
        this(new BsdSocket(i6), true);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        super.doBind(socketAddress);
        this.active = true;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        super.doClose();
        this.connected = false;
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (super.doConnect(socketAddress, socketAddress2)) {
            this.connected = true;
            return true;
        }
        return false;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int writeSpinCount;
        while (true) {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                writeFilter(false);
                return;
            }
            try {
            } catch (IOException e6) {
                channelOutboundBuffer.remove(e6);
            }
            for (writeSpinCount = config().getWriteSpinCount(); writeSpinCount > 0; writeSpinCount--) {
                if (doWriteMessage(current)) {
                    channelOutboundBuffer.remove();
                }
            }
            writeFilter(true);
            return;
        }
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    KQueueDatagramChannel(BsdSocket bsdSocket, boolean z5) {
        super((Channel) null, bsdSocket, z5);
        this.config = new KQueueDatagramChannelConfig(this);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public KQueueDatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return block(inetAddress, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return joinGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return leaveGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            return block(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), inetAddress2, channelPromise);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return joinGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return leaveGroup(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        if (inetAddress == null) {
            throw new NullPointerException("multicastAddress");
        }
        if (networkInterface != null) {
            channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
            return channelPromise;
        }
        throw new NullPointerException("networkInterface");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        if (inetAddress == null) {
            throw new NullPointerException("multicastAddress");
        }
        if (networkInterface != null) {
            channelPromise.setFailure((Throwable) new UnsupportedOperationException("Multicast not supported"));
            return channelPromise;
        }
        throw new NullPointerException("networkInterface");
    }
}
