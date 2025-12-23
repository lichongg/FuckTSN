package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface OioSocketChannelConfig extends SocketChannelConfig {
    int getSoTimeout();

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setAllowHalfClosure(boolean z5);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAutoRead(boolean z5);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setConnectTimeoutMillis(int i6);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setKeepAlive(boolean z5);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    OioSocketChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setPerformancePreferences(int i6, int i7, int i8);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setReuseAddress(boolean z5);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setSendBufferSize(int i6);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setSoLinger(int i6);

    OioSocketChannelConfig setSoTimeout(int i6);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setTcpNoDelay(boolean z5);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setTrafficClass(int i6);

    @Override // io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteSpinCount(int i6);
}
