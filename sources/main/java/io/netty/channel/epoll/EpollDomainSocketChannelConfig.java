package io.netty.channel.epoll;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.DomainSocketChannelConfig;
import io.netty.channel.unix.DomainSocketReadMode;
import io.netty.channel.unix.UnixChannelOption;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class EpollDomainSocketChannelConfig extends EpollChannelConfig implements DomainSocketChannelConfig {
    private volatile boolean allowHalfClosure;
    private volatile DomainSocketReadMode mode;

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == UnixChannelOption.DOMAIN_SOCKET_READ_MODE ? (T) getReadMode() : channelOption == ChannelOption.ALLOW_HALF_CLOSURE ? (T) Boolean.valueOf(isAllowHalfClosure()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.unix.DomainSocketChannelConfig
    public DomainSocketReadMode getReadMode() {
        return this.mode;
    }

    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    public EpollDomainSocketChannelConfig setAllowHalfClosure(boolean z5) {
        this.allowHalfClosure = z5;
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig
    public EpollDomainSocketChannelConfig setEpollMode(EpollMode epollMode) {
        super.setEpollMode(epollMode);
        return this;
    }

    @Override // io.netty.channel.unix.DomainSocketChannelConfig
    public EpollDomainSocketChannelConfig setReadMode(DomainSocketReadMode domainSocketReadMode) {
        if (domainSocketReadMode == null) {
            throw new NullPointerException(RtspHeaders.Values.MODE);
        }
        this.mode = domainSocketReadMode;
        return this;
    }

    EpollDomainSocketChannelConfig(AbstractEpollChannel abstractEpollChannel) {
        super(abstractEpollChannel);
        this.mode = DomainSocketReadMode.BYTES;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UnixChannelOption.DOMAIN_SOCKET_READ_MODE, ChannelOption.ALLOW_HALF_CLOSURE);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == UnixChannelOption.DOMAIN_SOCKET_READ_MODE) {
            setReadMode((DomainSocketReadMode) t5);
            return true;
        }
        if (channelOption == ChannelOption.ALLOW_HALF_CLOSURE) {
            setAllowHalfClosure(((Boolean) t5).booleanValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDomainSocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDomainSocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public EpollDomainSocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.epoll.EpollChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public EpollDomainSocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
