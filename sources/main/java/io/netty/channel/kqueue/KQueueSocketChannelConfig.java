package io.netty.channel.kqueue;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class KQueueSocketChannelConfig extends KQueueChannelConfig implements SocketChannelConfig {
    private volatile boolean allowHalfClosure;

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8) {
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.TCP_NODELAY ? (T) Boolean.valueOf(isTcpNoDelay()) : channelOption == ChannelOption.SO_KEEPALIVE ? (T) Boolean.valueOf(isKeepAlive()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.SO_LINGER ? (T) Integer.valueOf(getSoLinger()) : channelOption == ChannelOption.IP_TOS ? (T) Integer.valueOf(getTrafficClass()) : channelOption == ChannelOption.ALLOW_HALF_CLOSURE ? (T) Boolean.valueOf(isAllowHalfClosure()) : channelOption == KQueueChannelOption.SO_SNDLOWAT ? (T) Integer.valueOf(getSndLowAt()) : channelOption == KQueueChannelOption.TCP_NOPUSH ? (T) Boolean.valueOf(isTcpNoPush()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getReceiveBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSendBufferSize() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public int getSndLowAt() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getSndLowAt();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getSoLinger() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getSoLinger();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public int getTrafficClass() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.getTrafficClass();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isAllowHalfClosure() {
        return this.allowHalfClosure;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isKeepAlive() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isKeepAlive();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isReuseAddress() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isReuseAddress();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public boolean isTcpNoDelay() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isTcpNoDelay();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public boolean isTcpNoPush() {
        try {
            return ((KQueueSocketChannel) this.channel).socket.isTcpNoPush();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setAllowHalfClosure(boolean z5) {
        this.allowHalfClosure = z5;
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setKeepAlive(boolean z5) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setKeepAlive(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueSocketChannelConfig setRcvAllocTransportProvidesGuess(boolean z5) {
        super.setRcvAllocTransportProvidesGuess(z5);
        return this;
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setReceiveBufferSize(int i6) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setReceiveBufferSize(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setReuseAddress(boolean z5) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setReuseAddress(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setSendBufferSize(int i6) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setSendBufferSize(i6);
            calculateMaxBytesPerGatheringWrite();
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public void setSndLowAt(int i6) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setSndLowAt(i6);
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setSoLinger(int i6) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setSoLinger(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setTcpNoDelay(boolean z5) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setTcpNoDelay(z5);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    public void setTcpNoPush(boolean z5) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setTcpNoPush(z5);
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.socket.SocketChannelConfig
    public KQueueSocketChannelConfig setTrafficClass(int i6) {
        try {
            ((KQueueSocketChannel) this.channel).socket.setTrafficClass(i6);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    KQueueSocketChannelConfig(KQueueSocketChannel kQueueSocketChannel) {
        super(kQueueSocketChannel);
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

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.TCP_NODELAY, ChannelOption.SO_KEEPALIVE, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER, ChannelOption.IP_TOS, ChannelOption.ALLOW_HALF_CLOSURE, KQueueChannelOption.SO_SNDLOWAT, KQueueChannelOption.TCP_NOPUSH);
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
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
        if (channelOption == KQueueChannelOption.SO_SNDLOWAT) {
            setSndLowAt(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == KQueueChannelOption.TCP_NOPUSH) {
            setTcpNoPush(((Boolean) t5).booleanValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueSocketChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueSocketChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueSocketChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.kqueue.KQueueChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public KQueueSocketChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }
}
