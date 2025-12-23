package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.unix.Limits;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class KQueueChannelConfig extends DefaultChannelConfig {
    private volatile long maxBytesPerGatheringWrite;
    private volatile boolean transportProvidesGuess;

    @Override // io.netty.channel.DefaultChannelConfig
    protected final void autoReadCleared() {
        ((AbstractKQueueChannel) this.channel).clearReadFilter();
    }

    final long getMaxBytesPerGatheringWrite() {
        return this.maxBytesPerGatheringWrite;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS ? (T) Boolean.valueOf(getRcvAllocTransportProvidesGuess()) : (T) super.getOption(channelOption);
    }

    public boolean getRcvAllocTransportProvidesGuess() {
        return this.transportProvidesGuess;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    final void setMaxBytesPerGatheringWrite(long j6) {
        this.maxBytesPerGatheringWrite = Math.min(Limits.SSIZE_MAX, j6);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    public KQueueChannelConfig setRcvAllocTransportProvidesGuess(boolean z5) {
        this.transportProvidesGuess = z5;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        if (recvByteBufAllocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle) {
            super.setRecvByteBufAllocator(recvByteBufAllocator);
            return this;
        }
        throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }

    KQueueChannelConfig(AbstractKQueueChannel abstractKQueueChannel) {
        super(abstractKQueueChannel);
        this.maxBytesPerGatheringWrite = Limits.SSIZE_MAX;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS) {
            setRcvAllocTransportProvidesGuess(((Boolean) t5).booleanValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }
}
