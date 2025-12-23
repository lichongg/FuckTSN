package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ServerSocketChannelConfig extends ChannelConfig {
    int getBacklog();

    int getReceiveBufferSize();

    boolean isReuseAddress();

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setAutoRead(boolean z5);

    ServerSocketChannelConfig setBacklog(int i6);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setConnectTimeoutMillis(int i6);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    ServerSocketChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    ServerSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8);

    ServerSocketChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    ServerSocketChannelConfig setReuseAddress(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    ServerSocketChannelConfig setWriteSpinCount(int i6);
}
