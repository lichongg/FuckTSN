package io.netty.channel.udt;

import com.barchart.udt.nio.ChannelUDT;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultUdtServerChannelConfig extends DefaultUdtChannelConfig implements UdtServerChannelConfig {
    private volatile int backlog;

    @Override // io.netty.channel.udt.UdtServerChannelConfig
    public int getBacklog() {
        return this.backlog;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == ChannelOption.SO_BACKLOG ? (T) Integer.valueOf(getBacklog()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.udt.UdtServerChannelConfig
    public UdtServerChannelConfig setBacklog(int i6) {
        this.backlog = i6;
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setProtocolReceiveBufferSize(int i6) {
        super.setProtocolReceiveBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setProtocolSendBufferSize(int i6) {
        super.setProtocolSendBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setReceiveBufferSize(int i6) {
        super.setReceiveBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setReuseAddress(boolean z5) {
        super.setReuseAddress(z5);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSendBufferSize(int i6) {
        super.setSendBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSoLinger(int i6) {
        super.setSoLinger(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSystemReceiveBufferSize(int i6) {
        super.setSystemReceiveBufferSize(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.udt.UdtChannelConfig
    public UdtServerChannelConfig setSystemSendBufferSize(int i6) {
        super.setSystemSendBufferSize(i6);
        return this;
    }

    public DefaultUdtServerChannelConfig(UdtChannel udtChannel, ChannelUDT channelUDT, boolean z5) throws IOException {
        super(udtChannel, channelUDT, z5);
        this.backlog = 64;
        if (z5) {
            apply(channelUDT);
        }
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), ChannelOption.SO_BACKLOG);
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtServerChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == ChannelOption.SO_BACKLOG) {
            setBacklog(((Integer) t5).intValue());
            return true;
        }
        return super.setOption(channelOption, t5);
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig, io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtServerChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }

    @Override // io.netty.channel.udt.DefaultUdtChannelConfig
    protected void apply(ChannelUDT channelUDT) throws IOException {
    }
}
