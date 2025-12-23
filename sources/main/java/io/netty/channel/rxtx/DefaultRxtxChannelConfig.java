package io.netty.channel.rxtx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.PreferHeapByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.rxtx.RxtxChannelConfig;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
final class DefaultRxtxChannelConfig extends DefaultChannelConfig implements RxtxChannelConfig {
    private volatile int baudrate;
    private volatile RxtxChannelConfig.Databits databits;
    private volatile boolean dtr;
    private volatile RxtxChannelConfig.Paritybit paritybit;
    private volatile int readTimeout;
    private volatile boolean rts;
    private volatile RxtxChannelConfig.Stopbits stopbits;
    private volatile int waitTime;

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public int getBaudrate() {
        return this.baudrate;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig.Databits getDatabits() {
        return this.databits;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == RxtxChannelOption.BAUD_RATE ? (T) Integer.valueOf(getBaudrate()) : channelOption == RxtxChannelOption.DTR ? (T) Boolean.valueOf(isDtr()) : channelOption == RxtxChannelOption.RTS ? (T) Boolean.valueOf(isRts()) : channelOption == RxtxChannelOption.STOP_BITS ? (T) getStopbits() : channelOption == RxtxChannelOption.DATA_BITS ? (T) getDatabits() : channelOption == RxtxChannelOption.PARITY_BIT ? (T) getParitybit() : channelOption == RxtxChannelOption.WAIT_TIME ? (T) Integer.valueOf(getWaitTimeMillis()) : channelOption == RxtxChannelOption.READ_TIMEOUT ? (T) Integer.valueOf(getReadTimeout()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig.Paritybit getParitybit() {
        return this.paritybit;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public int getReadTimeout() {
        return this.readTimeout;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig.Stopbits getStopbits() {
        return this.stopbits;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public int getWaitTimeMillis() {
        return this.waitTime;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public boolean isDtr() {
        return this.dtr;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public boolean isRts() {
        return this.rts;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setBaudrate(int i6) {
        this.baudrate = i6;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setDatabits(RxtxChannelConfig.Databits databits) {
        this.databits = databits;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setDtr(boolean z5) {
        this.dtr = z5;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public RxtxChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setParitybit(RxtxChannelConfig.Paritybit paritybit) {
        this.paritybit = paritybit;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setReadTimeout(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("readTime must be >= 0");
        }
        this.readTimeout = i6;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setRts(boolean z5) {
        this.rts = z5;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setStopbits(RxtxChannelConfig.Stopbits stopbits) {
        this.stopbits = stopbits;
        return this;
    }

    @Override // io.netty.channel.rxtx.RxtxChannelConfig
    public RxtxChannelConfig setWaitTimeMillis(int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Wait time must be >= 0");
        }
        this.waitTime = i6;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public RxtxChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }

    DefaultRxtxChannelConfig(RxtxChannel rxtxChannel) {
        super(rxtxChannel);
        this.baudrate = 115200;
        this.stopbits = RxtxChannelConfig.Stopbits.STOPBITS_1;
        this.databits = RxtxChannelConfig.Databits.DATABITS_8;
        this.paritybit = RxtxChannelConfig.Paritybit.NONE;
        this.readTimeout = 1000;
        setAllocator((ByteBufAllocator) new PreferHeapByteBufAllocator(getAllocator()));
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), RxtxChannelOption.BAUD_RATE, RxtxChannelOption.DTR, RxtxChannelOption.RTS, RxtxChannelOption.STOP_BITS, RxtxChannelOption.DATA_BITS, RxtxChannelOption.PARITY_BIT, RxtxChannelOption.WAIT_TIME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == RxtxChannelOption.BAUD_RATE) {
            setBaudrate(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == RxtxChannelOption.DTR) {
            setDtr(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == RxtxChannelOption.RTS) {
            setRts(((Boolean) t5).booleanValue());
            return true;
        }
        if (channelOption == RxtxChannelOption.STOP_BITS) {
            setStopbits((RxtxChannelConfig.Stopbits) t5);
            return true;
        }
        if (channelOption == RxtxChannelOption.DATA_BITS) {
            setDatabits((RxtxChannelConfig.Databits) t5);
            return true;
        }
        if (channelOption == RxtxChannelOption.PARITY_BIT) {
            setParitybit((RxtxChannelConfig.Paritybit) t5);
            return true;
        }
        if (channelOption == RxtxChannelOption.WAIT_TIME) {
            setWaitTimeMillis(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == RxtxChannelOption.READ_TIMEOUT) {
            setReadTimeout(((Integer) t5).intValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }
}
