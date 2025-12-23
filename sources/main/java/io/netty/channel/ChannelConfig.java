package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ChannelConfig {
    ByteBufAllocator getAllocator();

    int getConnectTimeoutMillis();

    @Deprecated
    int getMaxMessagesPerRead();

    MessageSizeEstimator getMessageSizeEstimator();

    <T> T getOption(ChannelOption<T> channelOption);

    Map<ChannelOption<?>, Object> getOptions();

    <T extends RecvByteBufAllocator> T getRecvByteBufAllocator();

    int getWriteBufferHighWaterMark();

    int getWriteBufferLowWaterMark();

    WriteBufferWaterMark getWriteBufferWaterMark();

    int getWriteSpinCount();

    boolean isAutoClose();

    boolean isAutoRead();

    ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    ChannelConfig setAutoClose(boolean z5);

    ChannelConfig setAutoRead(boolean z5);

    ChannelConfig setConnectTimeoutMillis(int i6);

    @Deprecated
    ChannelConfig setMaxMessagesPerRead(int i6);

    ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    <T> boolean setOption(ChannelOption<T> channelOption, T t5);

    boolean setOptions(Map<ChannelOption<?>, ?> map);

    ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    ChannelConfig setWriteBufferHighWaterMark(int i6);

    ChannelConfig setWriteBufferLowWaterMark(int i6);

    ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    ChannelConfig setWriteSpinCount(int i6);
}
