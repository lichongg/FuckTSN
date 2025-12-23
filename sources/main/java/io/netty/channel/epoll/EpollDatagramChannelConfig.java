package io.netty.channel.epoll;

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
public final class EpollDatagramChannelConfig extends EpollChannelConfig implements DatagramChannelConfig {
    private static final RecvByteBufAllocator DEFAULT_RCVBUF_ALLOCATOR = new FixedRecvByteBufAllocator(2048);
    private boolean activeOnOpen;

    private void setActiveOnOpen(boolean z5) {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("Can only changed before channel was registered");
        }
        this.activeOnOpen = z5;
    }

    boolean getActiveOnOpen() {
        return this.activeOnOpen;
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public InetAddress getInterface() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getInterface();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getNetworkInterface();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_BROADCAST ? (T) Boolean.valueOf(isBroadcast()) : channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.IP_MULTICAST_LOOP_DISABLED ? (T) Boolean.valueOf(isLoopbackModeDisabled()) : channelOption == ChannelOption.IP_MULTICAST_ADDR ? (T) getInterface() : channelOption == ChannelOption.IP_MULTICAST_IF ? (T) getNetworkInterface() : channelOption == ChannelOption.IP_MULTICAST_TTL ? (T) Integer.valueOf(getTimeToLive()) : channelOption == ChannelOption.IP_TOS ? (T) Integer.valueOf(getTrafficClass()) : channelOption == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION ? (T) Boolean.valueOf(this.activeOnOpen) : channelOption == UnixChannelOption.SO_REUSEPORT ? (T) Boolean.valueOf(isReusePort()) : channelOption == EpollChannelOption.IP_TRANSPARENT ? (T) Boolean.valueOf(isIpTransparent()) : channelOption == EpollChannelOption.IP_FREEBIND ? (T) Boolean.valueOf(isFreeBind()) : channelOption == EpollChannelOption.IP_RECVORIGDSTADDR ? (T) Boolean.valueOf(isIpRecvOrigDestAddr()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getSendBufferSize() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getTimeToLive() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getTimeToLive();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public int getTrafficClass() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.getTrafficClass();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isBroadcast() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isBroadcast();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isFreeBind() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isIpFreeBind();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isIpRecvOrigDestAddr() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isIpRecvOrigDestAddr();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isIpTransparent() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isIpTransparent();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isLoopbackModeDisabled();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isReusePort() {
        try {
            return ((EpollDatagramChannel) this.channel).socket.isReusePort();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setBroadcast(boolean z5) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setBroadcast(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig
    public EpollDatagramChannelConfig setEpollMode(EpollMode epollMode) {
        super.setEpollMode(epollMode);
        return this;
    }

    public EpollDatagramChannelConfig setFreeBind(boolean z5) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setIpFreeBind(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setInterface(InetAddress inetAddress) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setInterface(inetAddress);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollDatagramChannelConfig setIpRecvOrigDestAddr(boolean z5) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setIpRecvOrigDestAddr(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollDatagramChannelConfig setIpTransparent(boolean z5) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setIpTransparent(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean z5) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setLoopbackModeDisabled(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setNetworkInterface(networkInterface);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setReceiveBufferSize(int i6) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setReceiveBufferSize(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setReuseAddress(boolean z5) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setReuseAddress(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollDatagramChannelConfig setReusePort(boolean z5) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setReusePort(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setSendBufferSize(int i6) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setSendBufferSize(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setTimeToLive(int i6) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setTimeToLive(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.DatagramChannelConfig
    public EpollDatagramChannelConfig setTrafficClass(int i6) {
        try {
            ((EpollDatagramChannel) this.channel).socket.setTrafficClass(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    EpollDatagramChannelConfig(EpollDatagramChannel epollDatagramChannel) {
        super(epollDatagramChannel);
        setRecvByteBufAllocator(DEFAULT_RCVBUF_ALLOCATOR);
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_BROADCAST, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.IP_MULTICAST_LOOP_DISABLED, ChannelOption.IP_MULTICAST_ADDR, ChannelOption.IP_MULTICAST_IF, ChannelOption.IP_MULTICAST_TTL, ChannelOption.IP_TOS, ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, UnixChannelOption.SO_REUSEPORT, EpollChannelOption.IP_FREEBIND, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.IP_RECVORIGDSTADDR);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
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
        if (channelOption == EpollChannelOption.IP_FREEBIND) {
            setFreeBind(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.IP_TRANSPARENT) {
            setIpTransparent(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.IP_RECVORIGDSTADDR) {
            setIpRecvOrigDestAddr(((Boolean) t5).booleanValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDatagramChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDatagramChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDatagramChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDatagramChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
