package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketFrameAggregator extends MessageAggregator<WebSocketFrame, WebSocketFrame, ContinuationWebSocketFrame, WebSocketFrame> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentLengthInvalid(WebSocketFrame webSocketFrame, int i6) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public Object newContinueResponse(WebSocketFrame webSocketFrame, int i6, ChannelPipeline channelPipeline) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public WebSocketFrame beginAggregation(WebSocketFrame webSocketFrame, ByteBuf byteBuf) throws Exception {
        if (webSocketFrame instanceof TextWebSocketFrame) {
            return new TextWebSocketFrame(true, webSocketFrame.rsv(), byteBuf);
        }
        if (webSocketFrame instanceof BinaryWebSocketFrame) {
            return new BinaryWebSocketFrame(true, webSocketFrame.rsv(), byteBuf);
        }
        throw new Error();
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
    public boolean isAggregated(WebSocketFrame webSocketFrame) throws Exception {
        return webSocketFrame.isFinalFragment() ? !isContentMessage(webSocketFrame) : (isStartMessage(webSocketFrame) || isContentMessage(webSocketFrame)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentMessage(WebSocketFrame webSocketFrame) throws Exception {
        return webSocketFrame instanceof ContinuationWebSocketFrame;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isLastContentMessage(ContinuationWebSocketFrame continuationWebSocketFrame) throws Exception {
        return isContentMessage((WebSocketFrame) continuationWebSocketFrame) && continuationWebSocketFrame.isFinalFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isStartMessage(WebSocketFrame webSocketFrame) throws Exception {
        return (webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame);
    }

    public WebSocketFrameAggregator(int i6) {
        super(i6);
    }
}
