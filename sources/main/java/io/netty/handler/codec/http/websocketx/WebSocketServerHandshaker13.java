package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketServerHandshaker13 extends WebSocketServerHandshaker {
    public static final String WEBSOCKET_13_ACCEPT_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    public WebSocketServerHandshaker13(String str, String str2, boolean z5, int i6) {
        this(str, str2, z5, i6, false);
    }

    public WebSocketServerHandshaker13(String str, String str2, boolean z5, int i6, boolean z6) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().allowExtensions(z5).maxFramePayloadLength(i6).allowMaskMismatch(z6).build());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket13FrameEncoder(false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket13FrameDecoder(decoderConfig());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        String str = fullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY);
        if (str != null) {
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, fullHttpRequest.content().alloc().buffer(0));
            if (httpHeaders != null) {
                defaultFullHttpResponse.headers().add(httpHeaders);
            }
            String base64 = WebSocketUtil.base64(WebSocketUtil.sha1((((Object) str) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
            InternalLogger internalLogger = WebSocketServerHandshaker.logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("WebSocket version 13 server handshake key: {}, response: {}", str, base64);
            }
            defaultFullHttpResponse.headers().add(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET);
            defaultFullHttpResponse.headers().add(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE);
            defaultFullHttpResponse.headers().add(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT, base64);
            HttpHeaders headers = fullHttpRequest.headers();
            AsciiString asciiString = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
            String str2 = headers.get(asciiString);
            if (str2 != null) {
                String selectSubprotocol = selectSubprotocol(str2);
                if (selectSubprotocol == null) {
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Requested subprotocol(s) not supported: {}", str2);
                        return defaultFullHttpResponse;
                    }
                } else {
                    defaultFullHttpResponse.headers().add(asciiString, selectSubprotocol);
                }
            }
            return defaultFullHttpResponse;
        }
        throw new WebSocketHandshakeException("not a WebSocket request: missing key");
    }

    public WebSocketServerHandshaker13(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        super(WebSocketVersion.V13, str, str2, webSocketDecoderConfig);
    }
}
