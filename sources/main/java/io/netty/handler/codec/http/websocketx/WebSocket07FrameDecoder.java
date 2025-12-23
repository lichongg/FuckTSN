package io.netty.handler.codec.http.websocketx;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocket07FrameDecoder extends WebSocket08FrameDecoder {
    public WebSocket07FrameDecoder(boolean z5, boolean z6, int i6) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z5).allowExtensions(z6).maxFramePayloadLength(i6).build());
    }

    public WebSocket07FrameDecoder(boolean z5, boolean z6, int i6, boolean z7) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z5).allowExtensions(z6).maxFramePayloadLength(i6).allowMaskMismatch(z7).build());
    }

    public WebSocket07FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        super(webSocketDecoderConfig);
    }
}
