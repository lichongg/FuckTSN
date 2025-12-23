package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import java.net.InetAddress;
import java.net.NetworkInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface DatagramChannelConfig extends ChannelConfig {
    InetAddress getInterface();

    NetworkInterface getNetworkInterface();

    int getReceiveBufferSize();

    int getSendBufferSize();

    int getTimeToLive();

    int getTrafficClass();

    boolean isBroadcast();

    boolean isLoopbackModeDisabled();

    boolean isReuseAddress();

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setAutoRead(boolean z5);

    DatagramChannelConfig setBroadcast(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setConnectTimeoutMillis(int i6);

    DatagramChannelConfig setInterface(InetAddress inetAddress);

    DatagramChannelConfig setLoopbackModeDisabled(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    DatagramChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface);

    DatagramChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    DatagramChannelConfig setReuseAddress(boolean z5);

    DatagramChannelConfig setSendBufferSize(int i6);

    DatagramChannelConfig setTimeToLive(int i6);

    DatagramChannelConfig setTrafficClass(int i6);

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    DatagramChannelConfig setWriteSpinCount(int i6);
}
