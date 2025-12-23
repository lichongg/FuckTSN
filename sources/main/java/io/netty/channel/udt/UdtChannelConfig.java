package io.netty.channel.udt;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface UdtChannelConfig extends ChannelConfig {
    int getProtocolReceiveBufferSize();

    int getProtocolSendBufferSize();

    int getReceiveBufferSize();

    int getSendBufferSize();

    int getSoLinger();

    int getSystemReceiveBufferSize();

    int getSystemSendBufferSize();

    boolean isReuseAddress();

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setAutoRead(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setConnectTimeoutMillis(int i6);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    UdtChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    UdtChannelConfig setProtocolReceiveBufferSize(int i6);

    UdtChannelConfig setProtocolSendBufferSize(int i6);

    UdtChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    UdtChannelConfig setReuseAddress(boolean z5);

    UdtChannelConfig setSendBufferSize(int i6);

    UdtChannelConfig setSoLinger(int i6);

    UdtChannelConfig setSystemReceiveBufferSize(int i6);

    UdtChannelConfig setSystemSendBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    UdtChannelConfig setWriteSpinCount(int i6);
}
