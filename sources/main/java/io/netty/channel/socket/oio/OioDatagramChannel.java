package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Locale;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class OioDatagramChannel extends AbstractOioMessageChannel implements DatagramChannel {
    private final OioDatagramChannelConfig config;
    private final MulticastSocket socket;
    private final DatagramPacket tmpPacket;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OioDatagramChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) io.netty.channel.socket.DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + v0.f47961e + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) SocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';

    public OioDatagramChannel() {
        this(newSocket());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    public OioDatagramChannel(MulticastSocket multicastSocket) {
        super(null);
        this.tmpPacket = new DatagramPacket(EmptyArrays.EMPTY_BYTES, 0);
        try {
            try {
                multicastSocket.setSoTimeout(1000);
                multicastSocket.setBroadcast(false);
                this.socket = multicastSocket;
                this.config = new DefaultOioDatagramChannelConfig(this, multicastSocket);
            } catch (SocketException e6) {
                throw new ChannelException("Failed to configure the datagram socket timeout.", e6);
            }
        } catch (Throwable th) {
            multicastSocket.close();
            throw th;
        }
    }

    private static MulticastSocket newSocket() {
        try {
            return new MulticastSocket((SocketAddress) null);
        } catch (Exception e6) {
            throw new ChannelException("failed to create a new socket", e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }

    @Override // io.netty.channel.Channel
    public DatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.socket.bind(socketAddress);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        this.socket.close();
    }

    @Override // io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            this.socket.bind(socketAddress2);
        }
        try {
            this.socket.connect(socketAddress);
        } catch (Throwable th) {
            try {
                this.socket.close();
            } catch (Throwable th2) {
                logger.warn("Failed to close a socket.", th2);
            }
            throw th;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        this.socket.disconnect();
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof io.netty.channel.socket.DatagramPacket) {
            return obj;
        }
        if (obj instanceof ByteBuf) {
            return obj;
        }
        if ((obj instanceof AddressedEnvelope) && (((AddressedEnvelope) obj).content() instanceof ByteBuf)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return this.socket.isConnected();
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return !this.socket.isClosed();
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        ensureBound();
        try {
            this.socket.joinGroup(inetAddress);
            channelPromise.setSuccess();
            return channelPromise;
        } catch (IOException e6) {
            channelPromise.setFailure((Throwable) e6);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, ChannelPromise channelPromise) {
        try {
            this.socket.leaveGroup(inetAddress);
            channelPromise.setSuccess();
            return channelPromise;
        } catch (IOException e6) {
            channelPromise.setFailure((Throwable) e6);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.socket.getLocalSocketAddress();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return this.socket.getRemoteSocketAddress();
    }

    private void ensureBound() {
        if (isActive()) {
            return;
        }
        throw new IllegalStateException(DatagramChannel.class.getName() + " must be bound to join a group.");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.oio.AbstractOioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        DatagramChannelConfig config = config();
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        ByteBuf heapBuffer = config.getAllocator().heapBuffer(recvBufAllocHandle.guess());
        try {
            try {
                try {
                    this.tmpPacket.setAddress(null);
                    this.tmpPacket.setData(heapBuffer.array(), heapBuffer.arrayOffset(), heapBuffer.capacity());
                    this.socket.receive(this.tmpPacket);
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) this.tmpPacket.getSocketAddress();
                    recvBufAllocHandle.lastBytesRead(this.tmpPacket.getLength());
                    list.add(new io.netty.channel.socket.DatagramPacket(heapBuffer.writerIndex(recvBufAllocHandle.lastBytesRead()), localAddress(), inetSocketAddress));
                    return 1;
                } catch (SocketException e6) {
                    if (e6.getMessage().toLowerCase(Locale.US).contains("socket closed")) {
                        heapBuffer.release();
                        return -1;
                    }
                    throw e6;
                } catch (SocketTimeoutException unused) {
                    heapBuffer.release();
                    return 0;
                }
            } catch (Throwable th) {
                PlatformDependent.throwException(th);
                heapBuffer.release();
                return -1;
            }
        } catch (Throwable th2) {
            heapBuffer.release();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x003b A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:30:0x0022, B:23:0x0035, B:25:0x003b, B:26:0x005b, B:28:0x004e, B:8:0x002a, B:22:0x0030, B:11:0x0066, B:12:0x006b), top: B:29:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:30:0x0022, B:23:0x0035, B:25:0x003b, B:26:0x005b, B:28:0x004e, B:8:0x002a, B:22:0x0030, B:11:0x0066, B:12:0x006b), top: B:29:0x0022 }] */
    @Override // io.netty.channel.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doWrite(io.netty.channel.ChannelOutboundBuffer r6) throws java.lang.Exception {
        /*
            r5 = this;
        L0:
            java.lang.Object r0 = r6.current()
            if (r0 != 0) goto L7
            return
        L7:
            boolean r1 = r0 instanceof io.netty.channel.AddressedEnvelope
            r2 = 0
            if (r1 == 0) goto L19
            io.netty.channel.AddressedEnvelope r0 = (io.netty.channel.AddressedEnvelope) r0
            java.net.SocketAddress r1 = r0.recipient()
            java.lang.Object r0 = r0.content()
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            goto L1c
        L19:
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0
            r1 = r2
        L1c:
            int r3 = r0.readableBytes()
            if (r1 == 0) goto L2a
            java.net.DatagramPacket r2 = r5.tmpPacket     // Catch: java.lang.Exception -> L28
            r2.setSocketAddress(r1)     // Catch: java.lang.Exception -> L28
            goto L35
        L28:
            r0 = move-exception
            goto L6c
        L2a:
            boolean r1 = r5.isConnected()     // Catch: java.lang.Exception -> L28
            if (r1 == 0) goto L66
            java.net.DatagramPacket r1 = r5.tmpPacket     // Catch: java.lang.Exception -> L28
            r1.setAddress(r2)     // Catch: java.lang.Exception -> L28
        L35:
            boolean r1 = r0.hasArray()     // Catch: java.lang.Exception -> L28
            if (r1 == 0) goto L4e
            java.net.DatagramPacket r1 = r5.tmpPacket     // Catch: java.lang.Exception -> L28
            byte[] r2 = r0.array()     // Catch: java.lang.Exception -> L28
            int r4 = r0.arrayOffset()     // Catch: java.lang.Exception -> L28
            int r0 = r0.readerIndex()     // Catch: java.lang.Exception -> L28
            int r4 = r4 + r0
            r1.setData(r2, r4, r3)     // Catch: java.lang.Exception -> L28
            goto L5b
        L4e:
            java.net.DatagramPacket r1 = r5.tmpPacket     // Catch: java.lang.Exception -> L28
            int r2 = r0.readerIndex()     // Catch: java.lang.Exception -> L28
            byte[] r0 = io.netty.buffer.ByteBufUtil.getBytes(r0, r2, r3)     // Catch: java.lang.Exception -> L28
            r1.setData(r0)     // Catch: java.lang.Exception -> L28
        L5b:
            java.net.MulticastSocket r0 = r5.socket     // Catch: java.lang.Exception -> L28
            java.net.DatagramPacket r1 = r5.tmpPacket     // Catch: java.lang.Exception -> L28
            r0.send(r1)     // Catch: java.lang.Exception -> L28
            r6.remove()     // Catch: java.lang.Exception -> L28
            goto L0
        L66:
            java.nio.channels.NotYetConnectedException r0 = new java.nio.channels.NotYetConnectedException     // Catch: java.lang.Exception -> L28
            r0.<init>()     // Catch: java.lang.Exception -> L28
            throw r0     // Catch: java.lang.Exception -> L28
        L6c:
            r6.remove(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.socket.oio.OioDatagramChannel.doWrite(io.netty.channel.ChannelOutboundBuffer):void");
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        if (isOpen()) {
            if ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || this.socket.isBound()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return leaveGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        return joinGroup(inetSocketAddress, networkInterface, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        try {
            this.socket.leaveGroup(inetSocketAddress, networkInterface);
            channelPromise.setSuccess();
            return channelPromise;
        } catch (IOException e6) {
            channelPromise.setFailure((Throwable) e6);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        ensureBound();
        try {
            this.socket.joinGroup(inetSocketAddress, networkInterface);
            channelPromise.setSuccess();
            return channelPromise;
        } catch (IOException e6) {
            channelPromise.setFailure((Throwable) e6);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return newFailedFuture(new UnsupportedOperationException());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new UnsupportedOperationException());
        return channelPromise;
    }
}
