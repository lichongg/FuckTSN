package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SocketChannelConfig extends ChannelConfig {
    int getReceiveBufferSize();

    int getSendBufferSize();

    int getSoLinger();

    int getTrafficClass();

    boolean isAllowHalfClosure();

    boolean isKeepAlive();

    boolean isReuseAddress();

    boolean isTcpNoDelay();

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    SocketChannelConfig setAllowHalfClosure(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoRead(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setConnectTimeoutMillis(int i6);

    SocketChannelConfig setKeepAlive(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    SocketChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    SocketChannelConfig setPerformancePreferences(int i6, int i7, int i8);

    SocketChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    SocketChannelConfig setReuseAddress(boolean z5);

    SocketChannelConfig setSendBufferSize(int i6);

    SocketChannelConfig setSoLinger(int i6);

    SocketChannelConfig setTcpNoDelay(boolean z5);

    SocketChannelConfig setTrafficClass(int i6);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteSpinCount(int i6);
}
