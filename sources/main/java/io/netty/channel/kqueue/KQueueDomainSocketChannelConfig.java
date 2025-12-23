package io.netty.channel.kqueue;

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
public final class KQueueDomainSocketChannelConfig extends KQueueChannelConfig implements DomainSocketChannelConfig {
    private volatile boolean allowHalfClosure;
    private volatile DomainSocketReadMode mode;

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
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

    public KQueueDomainSocketChannelConfig setAllowHalfClosure(boolean z5) {
        this.allowHalfClosure = z5;
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueDomainSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean z5) {
        super.setRcvAllocTransportProvidesGuess(z5);
        return this;
    }

    @Override // io.netty.channel.unix.DomainSocketChannelConfig
    public KQueueDomainSocketChannelConfig setReadMode(DomainSocketReadMode domainSocketReadMode) {
        if (domainSocketReadMode == null) {
            throw new NullPointerException(RtspHeaders.Values.MODE);
        }
        this.mode = domainSocketReadMode;
        return this;
    }

    KQueueDomainSocketChannelConfig(AbstractKQueueChannel abstractKQueueChannel) {
        super(abstractKQueueChannel);
        this.mode = DomainSocketReadMode.BYTES;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UnixChannelOption.DOMAIN_SOCKET_READ_MODE, ChannelOption.ALLOW_HALF_CLOSURE);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
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

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueDomainSocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueDomainSocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueDomainSocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueDomainSocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
