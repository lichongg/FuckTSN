package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface OioServerSocketChannelConfig extends ServerSocketChannelConfig {
    int getSoTimeout();

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setAutoRead(boolean z5);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setBacklog(int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setConnectTimeoutMillis(int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    OioServerSocketChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig
    OioServerSocketChannelConfig setReuseAddress(boolean z5);

    OioServerSocketChannelConfig setSoTimeout(int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.socket.ServerSocketChannelConfig, io.netty.channel.ChannelConfig
    OioServerSocketChannelConfig setWriteSpinCount(int i6);
}
