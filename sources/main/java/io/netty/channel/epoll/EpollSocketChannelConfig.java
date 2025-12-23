package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollSocketChannelConfig extends EpollChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8) {
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.TCP_NODELAY ? (T) Boolean.valueOf(isTcpNoDelay()) : channelOption == ChannelOption.SO_KEEPALIVE ? (T) Boolean.valueOf(isKeepAlive()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.SO_LINGER ? (T) Integer.valueOf(getSoLinger()) : channelOption == ChannelOption.IP_TOS ? (T) Integer.valueOf(getTrafficClass()) : channelOption == ChannelOption.ALLOW_HALF_CLOSURE ? (T) Boolean.valueOf(isAllowHalfClosure()) : channelOption == EpollChannelOption.TCP_CORK ? (T) Boolean.valueOf(isTcpCork()) : channelOption == EpollChannelOption.TCP_NOTSENT_LOWAT ? (T) Long.valueOf(getTcpNotSentLowAt()) : channelOption == EpollChannelOption.TCP_KEEPIDLE ? (T) Integer.valueOf(getTcpKeepIdle()) : channelOption == EpollChannelOption.TCP_KEEPINTVL ? (T) Integer.valueOf(getTcpKeepIntvl()) : channelOption == EpollChannelOption.TCP_KEEPCNT ? (T) Integer.valueOf(getTcpKeepCnt()) : channelOption == EpollChannelOption.TCP_USER_TIMEOUT ? (T) Integer.valueOf(getTcpUserTimeout()) : channelOption == EpollChannelOption.TCP_QUICKACK ? (T) Boolean.valueOf(isTcpQuickAck()) : channelOption == EpollChannelOption.IP_TRANSPARENT ? (T) Boolean.valueOf(isIpTransparent()) : channelOption == EpollChannelOption.TCP_FASTOPEN_CONNECT ? (T) Boolean.valueOf(isTcpFastOpenConnect()) : channelOption == EpollChannelOption.SO_BUSY_POLL ? (T) Integer.valueOf(getSoBusyPoll()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public int getSoBusyPoll() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getSoBusyPoll();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getSoLinger();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public int getTcpKeepCnt() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpKeepCnt();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public int getTcpKeepIdle() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpKeepIdle();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public int getTcpKeepIntvl() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpKeepIntvl();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public long getTcpNotSentLowAt() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpNotSentLowAt();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public int getTcpUserTimeout() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTcpUserTimeout();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return ((EpollSocketChannel) this.channel).socket.getTrafficClass();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    public boolean isIpTransparent() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isIpTransparent();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isKeepAlive();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isTcpCork() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isTcpCork();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isTcpFastOpenConnect() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isTcpFastOpenConnect();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isTcpNoDelay();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isTcpQuickAck() {
        try {
            return ((EpollSocketChannel) this.channel).socket.isTcpQuickAck();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setAllowHalfClosure(boolean z5) {
        this.allowHalfClosure = z5;
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig
    public EpollSocketChannelConfig setEpollMode(EpollMode epollMode) {
        super.setEpollMode(epollMode);
        return this;
    }

    public EpollSocketChannelConfig setIpTransparent(boolean z5) {
        try {
            ((EpollSocketChannel) this.channel).socket.setIpTransparent(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setKeepAlive(boolean z5) {
        try {
            ((EpollSocketChannel) this.channel).socket.setKeepAlive(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setReceiveBufferSize(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setReceiveBufferSize(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setReuseAddress(boolean z5) {
        try {
            ((EpollSocketChannel) this.channel).socket.setReuseAddress(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setSendBufferSize(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setSendBufferSize(i6);
            calculateMaxBytesPerGatheringWrite();
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setSoBusyPoll(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setSoBusyPoll(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setSoLinger(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setSoLinger(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpCork(boolean z5) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpCork(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpFastOpenConnect(boolean z5) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpFastOpenConnect(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpKeepCnt(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpKeepCnt(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpKeepIdle(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpKeepIdle(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpKeepIntvl(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpKeepIntvl(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpMd5Sig(Map<InetAddress, byte[]> map) {
        try {
            ((EpollSocketChannel) this.channel).setTcpMd5Sig(map);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setTcpNoDelay(boolean z5) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpNoDelay(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpNotSentLowAt(long j6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpNotSentLowAt(j6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpQuickAck(boolean z5) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpQuickAck(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollSocketChannelConfig setTcpUserTimeout(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTcpUserTimeout(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public EpollSocketChannelConfig setTrafficClass(int i6) {
        try {
            ((EpollSocketChannel) this.channel).socket.setTrafficClass(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    EpollSocketChannelConfig(EpollSocketChannel epollSocketChannel) {
        super(epollSocketChannel);
        if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
            setTcpNoDelay(true);
        }
        calculateMaxBytesPerGatheringWrite();
    }

    private void calculateMaxBytesPerGatheringWrite() {
        if ((getSendBufferSize() << 1) > 0) {
            setMaxBytesPerGatheringWrite(getSendBufferSize() << 1);
        }
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE, EpollChannelOption.TCP_CORK, EpollChannelOption.TCP_NOTSENT_LOWAT, EpollChannelOption.TCP_KEEPCNT, EpollChannelOption.TCP_KEEPIDLE, EpollChannelOption.TCP_KEEPINTVL, EpollChannelOption.TCP_MD5SIG, EpollChannelOption.TCP_QUICKACK, EpollChannelOption.IP_TRANSPARENT, EpollChannelOption.TCP_FASTOPEN_CONNECT, EpollChannelOption.SO_BUSY_POLL);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.TCP_NODELAY) {
            setTcpNoDelay(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_KEEPALIVE) {
            setKeepAlive(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_LINGER) {
            setSoLinger(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.IP_TOS) {
            setTrafficClass(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            setAllowHalfClosure(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_CORK) {
            setTcpCork(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_NOTSENT_LOWAT) {
            setTcpNotSentLowAt(((Long) t5).longValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_KEEPIDLE) {
            setTcpKeepIdle(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_KEEPCNT) {
            setTcpKeepCnt(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_KEEPINTVL) {
            setTcpKeepIntvl(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_USER_TIMEOUT) {
            setTcpUserTimeout(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == EpollChannelOption.IP_TRANSPARENT) {
            setIpTransparent(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_MD5SIG) {
            setTcpMd5Sig((Map) t5);
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_QUICKACK) {
            setTcpQuickAck(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_FASTOPEN_CONNECT) {
            setTcpFastOpenConnect(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == EpollChannelOption.SO_BUSY_POLL) {
            setSoBusyPoll(((Integer) t5).intValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Deprecated
    public EpollSocketChannelConfig setTcpKeepCntl(int i6) {
        return setTcpKeepCnt(i6);
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollSocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollSocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
