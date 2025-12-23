package io.netty.channel.sctp;

import com.sun.nio.sctp.SctpStandardSocketOptions;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface SctpServerChannelConfig extends ChannelConfig {
    int getBacklog();

    SctpStandardSocketOptions.InitMaxStreams getInitMaxStreams();

    int getReceiveBufferSize();

    int getSendBufferSize();

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setAutoClose(boolean z5);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setAutoRead(boolean z5);

    SctpServerChannelConfig setBacklog(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setConnectTimeoutMillis(int i6);

    SctpServerChannelConfig setInitMaxStreams(SctpStandardSocketOptions.InitMaxStreams initMaxStreams);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    SctpServerChannelConfig setMaxMessagesPerRead(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    SctpServerChannelConfig setReceiveBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    SctpServerChannelConfig setSendBufferSize(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setWriteBufferHighWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setWriteBufferLowWaterMark(int i6);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    SctpServerChannelConfig setWriteSpinCount(int i6);
}
