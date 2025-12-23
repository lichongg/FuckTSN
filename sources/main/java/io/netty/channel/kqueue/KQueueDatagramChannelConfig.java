package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class KQueueDatagramChannelConfig extends KQueueChannelConfig implements DatagramChannelConfig {
    private static final RecvByteBufAllocator DEFAULT_RCVBUF_ALLOCATOR = new FixedRecvByteBufAllocator(2048);
    private boolean activeOnOpen;

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public InetAddress getInterface() {
        return null;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        return null;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getTimeToLive() {
        return -1;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        return false;
    }

    private void setActiveOnOpen(boolean z5) {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("Can only changed before channel was registered");
        }
        this.activeOnOpen = z5;
    }

    boolean getActiveOnOpen() {
        return this.activeOnOpen;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_BROADCAST ? (T) Boolean.valueOf(isBroadcast()) : channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.IP_MULTICAST_LOOP_DISABLED ? (T) Boolean.valueOf(isLoopbackModeDisabled()) : channelOption == ChannelOption.IP_MULTICAST_ADDR ? (T) getInterface() : channelOption == ChannelOption.IP_MULTICAST_IF ? (T) getNetworkInterface() : channelOption == ChannelOption.IP_MULTICAST_TTL ? (T) Integer.valueOf(getTimeToLive()) : channelOption == ChannelOption.IP_TOS ? (T) Integer.valueOf(getTrafficClass()) : channelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION ? (T) Boolean.valueOf(this.activeOnOpen) : channelOption == UnixChannelOption.SO_REUSEPORT ? (T) Boolean.valueOf(isReusePort()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((KQueueDatagramChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getSendBufferSize() {
        try {
            return ((KQueueDatagramChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getTrafficClass() {
        try {
            return ((KQueueDatagramChannel) this.channel).socket.getTrafficClass();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isBroadcast() {
        try {
            return ((KQueueDatagramChannel) this.channel).socket.isBroadcast();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((KQueueDatagramChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isReusePort() {
        try {
            return ((KQueueDatagramChannel) this.channel).socket.isReusePort();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setBroadcast(boolean z5) {
        try {
            ((KQueueDatagramChannel) this.channel).socket.setBroadcast(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setInterface(InetAddress inetAddress) {
        throw new UnsupportedOperationException("Multicast not supported");
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean z5) {
        throw new UnsupportedOperationException("Multicast not supported");
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        throw new UnsupportedOperationException("Multicast not supported");
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueDatagramChannelConfig setRcvAllocTransportProvidesGuess(boolean z5) {
        super.setRcvAllocTransportProvidesGuess(z5);
        return this;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setReceiveBufferSize(int i6) {
        try {
            ((KQueueDatagramChannel) this.channel).socket.setReceiveBufferSize(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setReuseAddress(boolean z5) {
        try {
            ((KQueueDatagramChannel) this.channel).socket.setReuseAddress(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public KQueueDatagramChannelConfig setReusePort(boolean z5) {
        try {
            ((KQueueDatagramChannel) this.channel).socket.setReusePort(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setSendBufferSize(int i6) {
        try {
            ((KQueueDatagramChannel) this.channel).socket.setSendBufferSize(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setTimeToLive(int i6) {
        throw new UnsupportedOperationException("Multicast not supported");
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public KQueueDatagramChannelConfig setTrafficClass(int i6) {
        try {
            ((KQueueDatagramChannel) this.channel).socket.setTrafficClass(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    KQueueDatagramChannelConfig(KQueueDatagramChannel kQueueDatagramChannel) {
        super(kQueueDatagramChannel);
        setRecvByteBufAllocator(DEFAULT_RCVBUF_ALLOCATOR);
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, UnixChannelOption.SO_REUSEPORT);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
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
        if (channelOption == UnixChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) t5).booleanValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueDatagramChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueDatagramChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueDatagramChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDatagramChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
