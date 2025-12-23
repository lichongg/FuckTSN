package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class EpollServerChannelConfig extends EpollChannelConfig implements ServerSocketChannelConfig {
    private volatile int backlog;
    private volatile int pendingFastOpenRequestsThreshold;

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setPerformancePreferences(int i6, int i7, int i8) {
        return this;
    }

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    public int getBacklog() {
        return this.backlog;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.SO_BACKLOG ? (T) Integer.valueOf(getBacklog()) : channelOption == EpollChannelOption.TCP_FASTOPEN ? (T) Integer.valueOf(getTcpFastopen()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((AbstractEpollChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public int getTcpFastopen() {
        return this.pendingFastOpenRequestsThreshold;
    }

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((AbstractEpollChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setBacklog(int i6) {
        ObjectUtil.checkPositiveOrZero(i6, "backlog");
        this.backlog = i6;
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig
    public EpollServerChannelConfig setEpollMode(EpollMode epollMode) {
        super.setEpollMode(epollMode);
        return this;
    }

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setReceiveBufferSize(int i6) {
        try {
            ((AbstractEpollChannel) this.channel).socket.setReceiveBufferSize(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    public EpollServerChannelConfig setReuseAddress(boolean z5) {
        try {
            ((AbstractEpollChannel) this.channel).socket.setReuseAddress(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public EpollServerChannelConfig setTcpFastopen(int i6) {
        ObjectUtil.checkPositiveOrZero(this.pendingFastOpenRequestsThreshold, "pendingFastOpenRequestsThreshold");
        this.pendingFastOpenRequestsThreshold = i6;
        return this;
    }

    EpollServerChannelConfig(AbstractEpollChannel abstractEpollChannel) {
        super(abstractEpollChannel);
        this.backlog = NetUtil.SOMAXCONN;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_BACKLOG, EpollChannelOption.TCP_FASTOPEN);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_REUSEADDR) {
            setReuseAddress(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_BACKLOG) {
            setBacklog(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == EpollChannelOption.TCP_FASTOPEN) {
            setTcpFastopen(((Integer) t5).intValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollServerChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollServerChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
