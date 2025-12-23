package io.netty.channel.unix;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DomainSocketChannelConfig extends ChannelConfig {
    DomainSocketReadMode getReadMode();

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAutoRead(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setConnectTimeoutMillis(int i6);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    DomainSocketChannelConfig setReadMode(DomainSocketReadMode domainSocketReadMode);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setWriteSpinCount(int i6);
}
