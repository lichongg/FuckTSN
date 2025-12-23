package io.netty.channel.udt;

import com.barchart.udt.OptionUDT;
import com.barchart.udt.SocketUDT;
import com.barchart.udt.nio.ChannelUDT;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultUdtChannelConfig extends DefaultChannelConfig implements UdtChannelConfig {
    private static final int K = 1024;
    private static final int M = 1048576;
    private volatile int allocatorReceiveBufferSize;
    private volatile int allocatorSendBufferSize;
    private volatile int protocolReceiveBufferSize;
    private volatile int protocolSendBufferSize;
    private volatile boolean reuseAddress;
    private volatile int soLinger;
    private volatile int systemReceiveBufferSize;
    private volatile int systemSendBufferSize;

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> channelOption) {
        return channelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE ? (T) Integer.valueOf(getProtocolReceiveBufferSize()) : channelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE ? (T) Integer.valueOf(getProtocolSendBufferSize()) : channelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE ? (T) Integer.valueOf(getSystemReceiveBufferSize()) : channelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE ? (T) Integer.valueOf(getSystemSendBufferSize()) : channelOption == ChannelOption.SO_RCVBUF ? (T) Integer.valueOf(getReceiveBufferSize()) : channelOption == ChannelOption.SO_SNDBUF ? (T) Integer.valueOf(getSendBufferSize()) : channelOption == ChannelOption.SO_REUSEADDR ? (T) Boolean.valueOf(isReuseAddress()) : channelOption == ChannelOption.SO_LINGER ? (T) Integer.valueOf(getSoLinger()) : (T) super.getOption(channelOption);
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getProtocolReceiveBufferSize() {
        return this.protocolReceiveBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getProtocolSendBufferSize() {
        return this.protocolSendBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getReceiveBufferSize() {
        return this.allocatorReceiveBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSendBufferSize() {
        return this.allocatorSendBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSoLinger() {
        return this.soLinger;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSystemReceiveBufferSize() {
        return this.systemReceiveBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public int getSystemSendBufferSize() {
        return this.systemSendBufferSize;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public boolean isReuseAddress() {
        return this.reuseAddress;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setAllocator(ByteBufAllocator byteBufAllocator) {
        super.setAllocator(byteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setAutoClose(boolean z5) {
        super.setAutoClose(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setAutoRead(boolean z5) {
        super.setAutoRead(z5);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setConnectTimeoutMillis(int i6) {
        super.setConnectTimeoutMillis(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    public UdtChannelConfig setMaxMessagesPerRead(int i6) {
        super.setMaxMessagesPerRead(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator) {
        super.setMessageSizeEstimator(messageSizeEstimator);
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setProtocolReceiveBufferSize(int i6) {
        this.protocolReceiveBufferSize = i6;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setProtocolSendBufferSize(int i6) {
        this.protocolSendBufferSize = i6;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setReceiveBufferSize(int i6) {
        this.allocatorReceiveBufferSize = i6;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator) {
        super.setRecvByteBufAllocator(recvByteBufAllocator);
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setReuseAddress(boolean z5) {
        this.reuseAddress = z5;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSendBufferSize(int i6) {
        this.allocatorSendBufferSize = i6;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSoLinger(int i6) {
        this.soLinger = i6;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSystemReceiveBufferSize(int i6) {
        this.systemSendBufferSize = i6;
        return this;
    }

    @Override // io.netty.channel.udt.UdtChannelConfig
    public UdtChannelConfig setSystemSendBufferSize(int i6) {
        this.systemReceiveBufferSize = i6;
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setWriteBufferHighWaterMark(int i6) {
        super.setWriteBufferHighWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setWriteBufferLowWaterMark(int i6) {
        super.setWriteBufferLowWaterMark(i6);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        super.setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public UdtChannelConfig setWriteSpinCount(int i6) {
        super.setWriteSpinCount(i6);
        return this;
    }

    public DefaultUdtChannelConfig(UdtChannel udtChannel, ChannelUDT channelUDT, boolean z5) throws IOException {
        super(udtChannel);
        this.protocolReceiveBufferSize = 10485760;
        this.protocolSendBufferSize = 10485760;
        this.systemReceiveBufferSize = 1048576;
        this.systemSendBufferSize = 1048576;
        this.allocatorReceiveBufferSize = 131072;
        this.allocatorSendBufferSize = 131072;
        this.reuseAddress = true;
        if (z5) {
            apply(channelUDT);
        }
    }

    protected void apply(ChannelUDT channelUDT) throws IOException {
        SocketUDT socketUDT = channelUDT.socketUDT();
        socketUDT.setReuseAddress(isReuseAddress());
        socketUDT.setSendBufferSize(getSendBufferSize());
        if (getSoLinger() <= 0) {
            socketUDT.setSoLinger(false, 0);
        } else {
            socketUDT.setSoLinger(true, getSoLinger());
        }
        socketUDT.setOption(OptionUDT.Protocol_Receive_Buffer_Size, Integer.valueOf(getProtocolReceiveBufferSize()));
        socketUDT.setOption(OptionUDT.Protocol_Send_Buffer_Size, Integer.valueOf(getProtocolSendBufferSize()));
        socketUDT.setOption(OptionUDT.System_Receive_Buffer_Size, Integer.valueOf(getSystemReceiveBufferSize()));
        socketUDT.setOption(OptionUDT.System_Send_Buffer_Size, Integer.valueOf(getSystemSendBufferSize()));
    }

    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(super.getOptions(), UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE, UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE, UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE, UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE, ChannelOption.SO_RCVBUF, ChannelOption.SO_SNDBUF, ChannelOption.SO_REUSEADDR, ChannelOption.SO_LINGER);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.DefaultChannelConfig, io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> channelOption, T t5) {
        validate(channelOption, t5);
        if (channelOption == UdtChannelOption.PROTOCOL_RECEIVE_BUFFER_SIZE) {
            setProtocolReceiveBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == UdtChannelOption.PROTOCOL_SEND_BUFFER_SIZE) {
            setProtocolSendBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == UdtChannelOption.SYSTEM_RECEIVE_BUFFER_SIZE) {
            setSystemReceiveBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == UdtChannelOption.SYSTEM_SEND_BUFFER_SIZE) {
            setSystemSendBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_RCVBUF) {
            setReceiveBufferSize(((Integer) t5).intValue());
            return true;
        }
        if (channelOption == ChannelOption.SO_SNDBUF) {
            setSendBufferSize(((Integer) t5).intValue());
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
        return super.setOption(channelOption, t5);
    }
}
