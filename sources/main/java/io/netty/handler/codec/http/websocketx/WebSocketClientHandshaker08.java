package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.URI;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketClientHandshaker08 extends WebSocketClientHandshaker {
    public static final String MAGIC_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) WebSocketClientHandshaker08.class);
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private String expectedChallengeResponseString;
    private final boolean performMasking;

    public WebSocketClientHandshaker08(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, true, false, 10000L);
    }

    public WebSocketClientHandshaker08(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, z6, z7, 10000L);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket08FrameEncoder(this.performMasking);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket08FrameDecoder(false, this.allowExtensions, maxFramePayloadLength(), this.allowMaskMismatch);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketClientHandshaker08 setForceCloseTimeoutMillis(long j6) {
        super.setForceCloseTimeoutMillis(j6);
        return this;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected void verify(FullHttpResponse fullHttpResponse) {
        HttpResponseStatus httpResponseStatus = HttpResponseStatus.SWITCHING_PROTOCOLS;
        HttpHeaders headers = fullHttpResponse.headers();
        if (!fullHttpResponse.status().equals(httpResponseStatus)) {
            throw new WebSocketHandshakeException("Invalid handshake response getStatus: " + fullHttpResponse.status());
        }
        String str = headers.get(HttpHeaderNames.UPGRADE);
        if (!HttpHeaderValues.WEBSOCKET.contentEqualsIgnoreCase(str)) {
            throw new WebSocketHandshakeException("Invalid handshake response upgrade: " + ((Object) str));
        }
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        if (!headers.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
            throw new WebSocketHandshakeException("Invalid handshake response connection: " + headers.get(asciiString));
        }
        String str2 = headers.get(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT);
        if (str2 == null || !str2.equals(this.expectedChallengeResponseString)) {
            throw new WebSocketHandshakeException(String.format("Invalid challenge. Actual: %s. Expected: %s", str2, this.expectedChallengeResponseString));
        }
    }

    public WebSocketClientHandshaker08(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7, long j6) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, z6, z7, j6, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected FullHttpRequest newHandshakeRequest() {
        URI uri = uri();
        String base64 = WebSocketUtil.base64(WebSocketUtil.randomBytes(16));
        this.expectedChallengeResponseString = WebSocketUtil.base64(WebSocketUtil.sha1((base64 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("WebSocket version 08 client handshake key: {}, expected response: {}", base64, this.expectedChallengeResponseString);
        }
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl(uri), Unpooled.EMPTY_BUFFER);
        HttpHeaders headers = defaultFullHttpRequest.headers();
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            headers.add(httpHeaders);
        }
        headers.set(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.SEC_WEBSOCKET_KEY, base64).set(HttpHeaderNames.HOST, WebSocketClientHandshaker.websocketHostValue(uri)).set(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN, WebSocketClientHandshaker.websocketOriginValue(uri));
        String expectedSubprotocol = expectedSubprotocol();
        if (expectedSubprotocol != null && !expectedSubprotocol.isEmpty()) {
            headers.set(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, expectedSubprotocol);
        }
        headers.set(HttpHeaderNames.SEC_WEBSOCKET_VERSION, "8");
        return defaultFullHttpRequest;
    }

    WebSocketClientHandshaker08(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7, long j6, boolean z8) {
        super(uri, webSocketVersion, str, httpHeaders, i6, j6, z8);
        this.allowExtensions = z5;
        this.performMasking = z6;
        this.allowMaskMismatch = z7;
    }
}
