package io.netty.channel.sctp;

import com.sun.nio.sctp.SctpStandardSocketOptions;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SctpChannelConfig extends ChannelConfig {
    SctpStandardSocketOptions.InitMaxStreams getInitMaxStreams();

    int getReceiveBufferSize();

    int getSendBufferSize();

    boolean isSctpNoDelay();

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setAutoRead(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setConnectTimeoutMillis(int i6);

    SctpChannelConfig setInitMaxStreams(SctpStandardSocketOptions.InitMaxStreams initMaxStreams);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    SctpChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    SctpChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    SctpChannelConfig setSctpNoDelay(boolean z5);

    SctpChannelConfig setSendBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    SctpChannelConfig setWriteSpinCount(int i6);
}
