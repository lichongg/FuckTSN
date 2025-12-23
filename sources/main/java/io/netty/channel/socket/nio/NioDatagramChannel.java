package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultAddressedEnvelope;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.MembershipKey;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class NioDatagramChannel extends AbstractNioMessageChannel implements DatagramChannel {
    private final DatagramChannelConfig config;
    private Map<InetAddress, List<MembershipKey>> memberships;
    private static final ChannelMetadata METADATA = new ChannelMetadata(true);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) DatagramPacket.class) + ", " + StringUtil.simpleClassName((Class<?>) AddressedEnvelope.class) + v0.f47961e + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) SocketAddress.class) + ">, " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ')';

    public NioDatagramChannel() {
        this(newSocket(DEFAULT_SELECTOR_PROVIDER));
    }

    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openDatagramChannel();
        } catch (IOException e6) {
            throw new ChannelException("Failed to open a socket.", e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2) {
        return block(inetAddress, networkInterface, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean continueOnWriteError() {
        return true;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture joinGroup(InetAddress inetAddress) {
        return joinGroup(inetAddress, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress) {
        return leaveGroup(inetAddress, newPromise());
    }

    public NioDatagramChannel(SelectorProvider selectorProvider) {
        this(newSocket(selectorProvider));
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        NetworkInterface networkInterface2;
        checkJavaVersion();
        if (inetAddress == null) {
            throw new NullPointerException("multicastAddress");
        }
        if (inetAddress2 == null) {
            throw new NullPointerException("sourceToBlock");
        }
        if (networkInterface == null) {
            throw new NullPointerException("networkInterface");
        }
        synchronized (this) {
            Map<InetAddress, List<MembershipKey>> map = this.memberships;
            if (map != null) {
                Iterator<MembershipKey> it = map.get(inetAddress).iterator();
                while (it.hasNext()) {
                    MembershipKey a6 = i.a(it.next());
                    networkInterface2 = a6.networkInterface();
                    if (networkInterface.equals(networkInterface2)) {
                        try {
                            a6.block(inetAddress2);
                        } catch (IOException e6) {
                            channelPromise.setFailure((Throwable) e6);
                        }
                    }
                }
            }
        }
        channelPromise.setSuccess();
        return channelPromise;
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean closeOnReadError(Throwable th) {
        if (th instanceof SocketException) {
            return false;
        }
        return super.closeOnReadError(th);
    }

    @Override // io.netty.channel.Channel
    public DatagramChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        if (socketAddress2 != null) {
            doBind0(socketAddress2);
        }
        try {
            mo128javaChannel().connect(socketAddress);
            return true;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    protected void doFinishConnect() throws Exception {
        throw new Error();
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        ByteBuf byteBuf;
        SocketAddress socketAddress;
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            socketAddress = addressedEnvelope.recipient();
            byteBuf = (ByteBuf) addressedEnvelope.content();
        } else {
            byteBuf = (ByteBuf) obj;
            socketAddress = null;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return true;
        }
        ByteBuffer internalNioBuffer = byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), readableBytes) : byteBuf.nioBuffer(byteBuf.readerIndex(), readableBytes);
        return (socketAddress != null ? mo128javaChannel().send(internalNioBuffer, socketAddress) : mo128javaChannel().write(internalNioBuffer)) > 0;
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) {
        if (obj instanceof DatagramPacket) {
            DatagramPacket datagramPacket = (DatagramPacket) obj;
            ByteBuf content = datagramPacket.content();
            return isSingleDirectBuffer(content) ? datagramPacket : new DatagramPacket(newDirectBuffer(datagramPacket, content), datagramPacket.recipient());
        }
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return isSingleDirectBuffer(byteBuf) ? byteBuf : newDirectBuffer(byteBuf);
        }
        if (obj instanceof AddressedEnvelope) {
            AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
            if (addressedEnvelope.content() instanceof ByteBuf) {
                ByteBuf byteBuf2 = (ByteBuf) addressedEnvelope.content();
                return isSingleDirectBuffer(byteBuf2) ? addressedEnvelope : new DefaultAddressedEnvelope(newDirectBuffer(addressedEnvelope, byteBuf2), addressedEnvelope.recipient());
            }
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    /* renamed from: javaChannel */
    public java.nio.channels.DatagramChannel mo128javaChannel() {
        return (java.nio.channels.DatagramChannel) super.mo128javaChannel();
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

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    public NioDatagramChannel(InternetProtocolFamily internetProtocolFamily) {
        this(newSocket(DEFAULT_SELECTOR_PROVIDER, internetProtocolFamily));
    }

    private static void checkJavaVersion() {
        if (PlatformDependent.javaVersion() >= 7) {
        } else {
            throw new UnsupportedOperationException("Only supported on java 7+.");
        }
    }

    private void doBind0(SocketAddress socketAddress) throws Exception {
        if (PlatformDependent.javaVersion() >= 7) {
            SocketUtils.bind(mo128javaChannel(), socketAddress);
        } else {
            mo128javaChannel().socket().bind(socketAddress);
        }
    }

    private static boolean isSingleDirectBuffer(ByteBuf byteBuf) {
        if (byteBuf.isDirect() && byteBuf.nioBufferCount() == 1) {
            return true;
        }
        return false;
    }

    private static java.nio.channels.DatagramChannel newSocket(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        java.nio.channels.DatagramChannel openDatagramChannel;
        if (internetProtocolFamily == null) {
            return newSocket(selectorProvider);
        }
        checkJavaVersion();
        try {
            openDatagramChannel = selectorProvider.openDatagramChannel(ProtocolFamilyConverter.convert(internetProtocolFamily));
            return openDatagramChannel;
        } catch (IOException e6) {
            throw new ChannelException("Failed to open a socket.", e6);
        }
    }

    void clearReadPending0() {
        clearReadPending();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        doBind0(socketAddress);
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        mo128javaChannel().close();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        mo128javaChannel().disconnect();
    }

    @Override // io.netty.channel.nio.AbstractNioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        java.nio.channels.DatagramChannel mo128javaChannel = mo128javaChannel();
        DatagramChannelConfig config = config();
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        ByteBuf allocate = recvBufAllocHandle.allocate(config.getAllocator());
        recvBufAllocHandle.attemptedBytesRead(allocate.writableBytes());
        try {
            ByteBuffer internalNioBuffer = allocate.internalNioBuffer(allocate.writerIndex(), allocate.writableBytes());
            int position = internalNioBuffer.position();
            InetSocketAddress inetSocketAddress = (InetSocketAddress) mo128javaChannel.receive(internalNioBuffer);
            if (inetSocketAddress == null) {
                allocate.release();
                return 0;
            }
            recvBufAllocHandle.lastBytesRead(internalNioBuffer.position() - position);
            list.add(new DatagramPacket(allocate.writerIndex(allocate.writerIndex() + recvBufAllocHandle.lastBytesRead()), localAddress(), inetSocketAddress));
            return 1;
        } catch (Throwable th) {
            try {
                PlatformDependent.throwException(th);
                allocate.release();
                return -1;
            } catch (Throwable th2) {
                allocate.release();
                throw th2;
            }
        }
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.DatagramChannel mo128javaChannel = mo128javaChannel();
        if (mo128javaChannel.isOpen()) {
            if ((((Boolean) this.config.getOption(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION)).booleanValue() && isRegistered()) || mo128javaChannel.socket().isBound()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public boolean isConnected() {
        return mo128javaChannel().isConnected();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return mo128javaChannel().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return mo128javaChannel().socket().getRemoteSocketAddress();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    @Deprecated
    protected void setReadPending(boolean z5) {
        super.setReadPending(z5);
    }

    public NioDatagramChannel(SelectorProvider selectorProvider, InternetProtocolFamily internetProtocolFamily) {
        this(newSocket(selectorProvider, internetProtocolFamily));
    }

    public NioDatagramChannel(java.nio.channels.DatagramChannel datagramChannel) {
        super(null, datagramChannel, 1);
        this.config = new NioDatagramChannelConfig(this, datagramChannel);
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
    public ChannelFuture joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return joinGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface, ChannelPromise channelPromise) {
        return leaveGroup(inetSocketAddress.getAddress(), networkInterface, null, channelPromise);
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
        MembershipKey join;
        List<MembershipKey> list;
        checkJavaVersion();
        if (inetAddress == null) {
            throw new NullPointerException("multicastAddress");
        }
        if (networkInterface != null) {
            try {
                if (inetAddress2 == null) {
                    join = mo128javaChannel().join(inetAddress, networkInterface);
                } else {
                    join = mo128javaChannel().join(inetAddress, networkInterface, inetAddress2);
                }
                synchronized (this) {
                    try {
                        Map<InetAddress, List<MembershipKey>> map = this.memberships;
                        if (map == null) {
                            this.memberships = new HashMap();
                            list = null;
                        } else {
                            list = map.get(inetAddress);
                        }
                        if (list == null) {
                            list = new ArrayList<>();
                            this.memberships.put(inetAddress, list);
                        }
                        list.add(join);
                    } finally {
                    }
                }
                channelPromise.setSuccess();
                return channelPromise;
            } catch (Throwable th) {
                channelPromise.setFailure(th);
                return channelPromise;
            }
        }
        throw new NullPointerException("networkInterface");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture leaveGroup(InetAddress inetAddress, NetworkInterface networkInterface, InetAddress inetAddress2, ChannelPromise channelPromise) {
        List<MembershipKey> list;
        NetworkInterface networkInterface2;
        InetAddress sourceAddress;
        InetAddress sourceAddress2;
        checkJavaVersion();
        if (inetAddress == null) {
            throw new NullPointerException("multicastAddress");
        }
        if (networkInterface != null) {
            synchronized (this) {
                try {
                    Map<InetAddress, List<MembershipKey>> map = this.memberships;
                    if (map != null && (list = map.get(inetAddress)) != null) {
                        Iterator<MembershipKey> it = list.iterator();
                        while (it.hasNext()) {
                            MembershipKey a6 = i.a(it.next());
                            networkInterface2 = a6.networkInterface();
                            if (networkInterface.equals(networkInterface2)) {
                                if (inetAddress2 == null) {
                                    sourceAddress2 = a6.sourceAddress();
                                    if (sourceAddress2 == null) {
                                        a6.drop();
                                        it.remove();
                                    }
                                }
                                if (inetAddress2 != null) {
                                    sourceAddress = a6.sourceAddress();
                                    if (inetAddress2.equals(sourceAddress)) {
                                        a6.drop();
                                        it.remove();
                                    }
                                }
                            }
                        }
                        if (list.isEmpty()) {
                            this.memberships.remove(inetAddress);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            channelPromise.setSuccess();
            return channelPromise;
        }
        throw new NullPointerException("networkInterface");
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2) {
        return block(inetAddress, inetAddress2, newPromise());
    }

    @Override // io.netty.channel.socket.DatagramChannel
    public ChannelFuture block(InetAddress inetAddress, InetAddress inetAddress2, ChannelPromise channelPromise) {
        try {
            return block(inetAddress, NetworkInterface.getByInetAddress(localAddress().getAddress()), inetAddress2, channelPromise);
        } catch (SocketException e6) {
            channelPromise.setFailure((Throwable) e6);
            return channelPromise;
        }
    }
}
