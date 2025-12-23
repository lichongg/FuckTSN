package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class StompSubframeAggregator extends MessageAggregator<StompSubframe, StompHeadersSubframe, StompContentSubframe, StompFrame> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public Object newContinueResponse(StompHeadersSubframe stompHeadersSubframe, int i6, ChannelPipeline channelPipeline) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public StompFrame beginAggregation(StompHeadersSubframe stompHeadersSubframe, ByteBuf byteBuf) throws Exception {
        DefaultStompFrame defaultStompFrame = new DefaultStompFrame(stompHeadersSubframe.command(), byteBuf);
        defaultStompFrame.headers().set(stompHeadersSubframe.headers());
        return defaultStompFrame;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean closeAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    protected boolean ignoreContentAfterContinueResponse(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isAggregated(StompSubframe stompSubframe) throws Exception {
        return stompSubframe instanceof StompFrame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentLengthInvalid(StompHeadersSubframe stompHeadersSubframe, int i6) {
        return ((int) Math.min(2147483647L, stompHeadersSubframe.headers().getLong(StompHeaders.CONTENT_LENGTH, -1L))) > i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentMessage(StompSubframe stompSubframe) throws Exception {
        return stompSubframe instanceof StompContentSubframe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isLastContentMessage(StompContentSubframe stompContentSubframe) throws Exception {
        return stompContentSubframe instanceof LastStompContentSubframe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isStartMessage(StompSubframe stompSubframe) throws Exception {
        return stompSubframe instanceof StompHeadersSubframe;
    }

    public StompSubframeAggregator(int i6) {
        super(i6);
    }
}
