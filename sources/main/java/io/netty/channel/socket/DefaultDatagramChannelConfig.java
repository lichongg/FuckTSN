package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultDatagramChannelConfig extends DefaultChannelConfig implements DatagramChannelConfig {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultDatagramChannelConfig.class);
    private volatile boolean activeOnOpen;
    private final DatagramSocket javaSocket;

    public DefaultDatagramChannelConfig(DatagramChannel datagramChannel, DatagramSocket datagramSocket) {
        super(datagramChannel, new FixedRecvByteBufAllocator(2048));
        if (datagramSocket == null) {
            throw new NullPointerException("javaSocket");
        }
        this.javaSocket = datagramSocket;
    }

    private void setActiveOnOpen(boolean z5) {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("Can only changed before channel was registered");
        }
        this.activeOnOpen = z5;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public InetAddress getInterface() {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            return ((MulticastSocket) datagramSocket).getInterface();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            return ((MulticastSocket) datagramSocket).getNetworkInterface();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_BROADCAST ? (T) Boolean.valueOf(isBroadcast()) : channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.IP_MULTICAST_LOOP_DISABLED ? (T) Boolean.valueOf(isLoopbackModeDisabled()) : channelOption == ChannelOption.IP_MULTICAST_ADDR ? (T) getInterface() : channelOption == ChannelOption.IP_MULTICAST_IF ? (T) getNetworkInterface() : channelOption == ChannelOption.IP_MULTICAST_TTL ? (T) Integer.valueOf(getTimeToLive()) : channelOption == ChannelOption.IP_TOS ? (T) Integer.valueOf(getTrafficClass()) : channelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION ? (T) Boolean.valueOf(this.activeOnOpen) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getReceiveBufferSize() {
        try {
            return this.javaSocket.getReceiveBufferSize();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getSendBufferSize() {
        try {
            return this.javaSocket.getSendBufferSize();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getTimeToLive() {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            return ((MulticastSocket) datagramSocket).getTimeToLive();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getTrafficClass() {
        try {
            return this.javaSocket.getTrafficClass();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isBroadcast() {
        try {
            return this.javaSocket.getBroadcast();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            return ((MulticastSocket) datagramSocket).getLoopbackMode();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isReuseAddress() {
        try {
            return this.javaSocket.getReuseAddress();
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    protected final DatagramSocket javaSocket() {
        return this.javaSocket;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setBroadcast(boolean z5) {
        if (z5) {
            try {
                if (!this.javaSocket.getLocalAddress().isAnyLocalAddress() && !PlatformDependent.isWindows() && !PlatformDependent.maybeSuperUser()) {
                    logger.warn("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; setting the SO_BROADCAST flag anyway as requested on the socket which is bound to " + this.javaSocket.getLocalSocketAddress() + '.');
                }
            } catch (SocketException e6) {
                throw new ChannelException(e6);
            }
        }
        this.javaSocket.setBroadcast(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setInterface(InetAddress inetAddress) {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            ((MulticastSocket) datagramSocket).setInterface(inetAddress);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean z5) {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            ((MulticastSocket) datagramSocket).setLoopbackMode(z5);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public DatagramChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            ((MulticastSocket) datagramSocket).setNetworkInterface(networkInterface);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReceiveBufferSize(int i6) {
        try {
            this.javaSocket.setReceiveBufferSize(i6);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setReuseAddress(boolean z5) {
        try {
            this.javaSocket.setReuseAddress(z5);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setSendBufferSize(int i6) {
        try {
            this.javaSocket.setSendBufferSize(i6);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTimeToLive(int i6) {
        DatagramSocket datagramSocket = this.javaSocket;
        if (!(datagramSocket instanceof MulticastSocket)) {
            throw new UnsupportedOperationException();
        }
        try {
            ((MulticastSocket) datagramSocket).setTimeToLive(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setTrafficClass(int i6) {
        try {
            this.javaSocket.setTrafficClass(i6);
            return this;
        } catch (SocketException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public DatagramChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == ChannelOption.SO_BROADCAST) {
            setBroadcast(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.IP_MULTICAST_LOOP_DISABLED) {
            setLoopbackModeDisabled(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.IP_MULTICAST_ADDR) {
            setInterface((InetAddress) t5);
            return true;
        }
        if (channelOption == ChannelOption.IP_MULTICAST_IF) {
            setNetworkInterface((NetworkInterface) t5);
            return true;
        }
        if (channelOption == ChannelOption.IP_MULTICAST_TTL) {
            setTimeToLive(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            setActiveOnOpen(((Boolean) t5).booleanValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }
}
