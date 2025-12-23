package io.netty.channel.sctp;

import com.sun.nio.sctp.SctpStandardSocketOptions;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSctpChannelConfig extends DefaultChannelConfig implements SctpChannelConfig {
    private final com.sun.nio.sctp.SctpChannel javaChannel;

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public SctpStandardSocketOptions.InitMaxStreams getInitMaxStreams() {
        try {
            return (SctpStandardSocketOptions.InitMaxStreams) this.javaChannel.getOption(SctpStandardSocketOptions.SCTP_INIT_MAXSTREAMS);
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == SctpChannelOption.SCTP_NODELAY ? (T) Boolean.valueOf(isSctpNoDelay()) : channelOption == SctpChannelOption.SCTP_INIT_MAXSTREAMS ? (T) getInitMaxStreams() : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public int getReceiveBufferSize() {
        try {
            return ((Integer) this.javaChannel.getOption(SctpStandardSocketOptions.SO_RCVBUF)).intValue();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public int getSendBufferSize() {
        try {
            return ((Integer) this.javaChannel.getOption(SctpStandardSocketOptions.SO_SNDBUF)).intValue();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public boolean isSctpNoDelay() {
        try {
            return ((Boolean) this.javaChannel.getOption(SctpStandardSocketOptions.SCTP_NODELAY)).booleanValue();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public SctpChannelConfig setInitMaxStreams(SctpStandardSocketOptions.InitMaxStreams initMaxStreams) {
        try {
            this.javaChannel.setOption(SctpStandardSocketOptions.SCTP_INIT_MAXSTREAMS, initMaxStreams);
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public SctpChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public SctpChannelConfig setReceiveBufferSize(int i6) {
        try {
            this.javaChannel.setOption(SctpStandardSocketOptions.SO_RCVBUF, Integer.valueOf(i6));
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public SctpChannelConfig setSctpNoDelay(boolean z5) {
        try {
            this.javaChannel.setOption(SctpStandardSocketOptions.SCTP_NODELAY, Boolean.valueOf(z5));
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.sctp.SctpChannelConfig
    public SctpChannelConfig setSendBufferSize(int i6) {
        try {
            this.javaChannel.setOption(SctpStandardSocketOptions.SO_SNDBUF, Integer.valueOf(i6));
            return this;
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public SctpChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }

    public DefaultSctpChannelConfig(SctpChannel sctpChannel, com.sun.nio.sctp.SctpChannel sctpChannel2) {
        super(sctpChannel);
        if (sctpChannel2 != null) {
            this.javaChannel = sctpChannel2;
            if (PlatformDependent.canEnableTcpNoDelayByDefault()) {
                try {
                    setSctpNoDelay(true);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        throw new NullPointerException("javaChannel");
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, SctpChannelOption.SCTP_NODELAY, SctpChannelOption.SCTP_INIT_MAXSTREAMS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
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
        if (channelOption == SctpChannelOption.SCTP_NODELAY) {
            setSctpNoDelay(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == SctpChannelOption.SCTP_INIT_MAXSTREAMS) {
            setInitMaxStreams((SctpStandardSocketOptions.InitMaxStreams) t5);
            return true;
        }
        return super.setOption(channelOption, t5);
    }
}
