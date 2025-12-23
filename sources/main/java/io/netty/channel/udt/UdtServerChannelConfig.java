package io.netty.channel.udt;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface UdtServerChannelConfig extends UdtChannelConfig {
    int getBacklog();

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setAutoRead(boolean z5);

    UdtServerChannelConfig setBacklog(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setConnectTimeoutMillis(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    UdtServerChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setProtocolReceiveBufferSize(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setProtocolSendBufferSize(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setReuseAddress(boolean z5);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSendBufferSize(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSoLinger(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSystemReceiveBufferSize(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig
    UdtServerChannelConfig setSystemSendBufferSize(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.udt.UdtChannelConfig, io.netty.channel.ChannelConfig
    UdtServerChannelConfig setWriteSpinCount(int i6);
}
