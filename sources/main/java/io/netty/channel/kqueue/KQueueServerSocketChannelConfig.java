package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;
import io.netty.channel.unix.UnixChannelOption;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class KQueueServerSocketChannelConfig extends KQueueServerChannelConfig implements ServerSocketChannelConfig {
    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8) {
        return this;
    }

    public AcceptFilter getAcceptFilter() {
        try {
            return ((KQueueServerSocketChannel) this.channel).socket.getAcceptFilter();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == UnixChannelOption.SO_REUSEPORT ? (T) Boolean.valueOf(isReusePort()) : channelOption == KQueueChannelOption.SO_ACCEPTFILTER ? (T) getAcceptFilter() : (T) super.getOption(channelOption);
    }

    public boolean isReusePort() {
        try {
            return ((KQueueServerSocketChannel) this.channel).socket.isReusePort();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public KQueueServerSocketChannelConfig setAcceptFilter(AcceptFilter acceptFilter) {
        try {
            ((KQueueServerSocketChannel) this.channel).socket.setAcceptFilter(acceptFilter);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public KQueueServerSocketChannelConfig setReusePort(boolean z5) {
        try {
            ((KQueueServerSocketChannel) this.channel).socket.setReusePort(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    KQueueServerSocketChannelConfig(KQueueServerSocketChannel kQueueServerSocketChannel) {
        super(kQueueServerSocketChannel);
        setReuseAddress(true);
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UnixChannelOption.SO_REUSEPORT, KQueueChannelOption.SO_ACCEPTFILTER);
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setBacklog(int i6) {
        super.setBacklog(i6);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == UnixChannelOption.SO_REUSEPORT) {
            setReusePort(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == KQueueChannelOption.SO_ACCEPTFILTER) {
            setAcceptFilter((AcceptFilter) t5);
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueServerSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean z5) {
        super.setRcvAllocTransportProvidesGuess(z5);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setReceiveBufferSize(int i6) {
        super.setReceiveBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.socket.ServerSocketChannelConfig
    public KQueueServerSocketChannelConfig setReuseAddress(boolean z5) {
        super.setReuseAddress(z5);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueServerSocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueServerChannelConfig, io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueServerSocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
