package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.DatagramChannelConfig;
import java.net.InetAddress;
import java.net.NetworkInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface OioDatagramChannelConfig extends DatagramChannelConfig {
    int getSoTimeout();

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setAutoRead(boolean z5);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setBroadcast(boolean z5);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setConnectTimeoutMillis(int i6);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setInterface(InetAddress inetAddress);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setLoopbackModeDisabled(boolean z5);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setReuseAddress(boolean z5);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setSendBufferSize(int i6);

    OioDatagramChannelConfig setSoTimeout(int i6);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setTimeToLive(int i6);

    @Override // io.netty.channel.socket.DatagramChannelConfig
    OioDatagramChannelConfig setTrafficClass(int i6);

    @Override // io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.socket.DatagramChannelConfig, io.netty.channel.ChannelConfig
    OioDatagramChannelConfig setWriteSpinCount(int i6);
}
