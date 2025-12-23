package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
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
import java.net.URI;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketClientHandshaker00 extends WebSocketClientHandshaker {
    private static final AsciiString WEBSOCKET = AsciiString.cached(HttpHeaders.Values.WEBSOCKET);
    private ByteBuf expectedChallengeResponseBytes;

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i6) {
        this(uri, webSocketVersion, str, httpHeaders, i6, 10000L);
    }

    private static String insertRandomCharacters(String str) {
        int randomNumber = WebSocketUtil.randomNumber(1, 12);
        char[] cArr = new char[randomNumber];
        int i6 = 0;
        while (i6 < randomNumber) {
            int random = (int) ((Math.random() * 126.0d) + 33.0d);
            if ((33 < random && random < 47) || (58 < random && random < 126)) {
                cArr[i6] = (char) random;
                i6++;
            }
        }
        for (int i7 = 0; i7 < randomNumber; i7++) {
            int randomNumber2 = WebSocketUtil.randomNumber(0, str.length());
            str = str.substring(0, randomNumber2) + cArr[i7] + str.substring(randomNumber2);
        }
        return str;
    }

    private static String insertSpaces(String str, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            int randomNumber = WebSocketUtil.randomNumber(1, str.length() - 1);
            str = str.substring(0, randomNumber) + ' ' + str.substring(randomNumber);
        }
        return str;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected FullHttpRequest newHandshakeRequest() {
        int randomNumber = WebSocketUtil.randomNumber(1, 12);
        int randomNumber2 = WebSocketUtil.randomNumber(1, 12);
        int randomNumber3 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / randomNumber);
        int randomNumber4 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / randomNumber2);
        String num = Integer.toString(randomNumber3 * randomNumber);
        String num2 = Integer.toString(randomNumber4 * randomNumber2);
        String insertRandomCharacters = insertRandomCharacters(num);
        String insertRandomCharacters2 = insertRandomCharacters(num2);
        String insertSpaces = insertSpaces(insertRandomCharacters, randomNumber);
        String insertSpaces2 = insertSpaces(insertRandomCharacters2, randomNumber2);
        byte[] randomBytes = WebSocketUtil.randomBytes(8);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(randomNumber3);
        byte[] array = allocate.array();
        ByteBuffer allocate2 = ByteBuffer.allocate(4);
        allocate2.putInt(randomNumber4);
        byte[] array2 = allocate2.array();
        byte[] bArr = new byte[16];
        System.arraycopy(array, 0, bArr, 0, 4);
        System.arraycopy(array2, 0, bArr, 4, 4);
        System.arraycopy(randomBytes, 0, bArr, 8, 8);
        this.expectedChallengeResponseBytes = Unpooled.wrappedBuffer(WebSocketUtil.md5(bArr));
        URI uri = uri();
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl(uri), Unpooled.wrappedBuffer(randomBytes));
        HttpHeaders headers = defaultFullHttpRequest.headers();
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            headers.add(httpHeaders);
        }
        headers.set(HttpHeaderNames.UPGRADE, WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.HOST, WebSocketClientHandshaker.websocketHostValue(uri)).set(HttpHeaderNames.ORIGIN, WebSocketClientHandshaker.websocketOriginValue(uri)).set(HttpHeaderNames.SEC_WEBSOCKET_KEY1, insertSpaces).set(HttpHeaderNames.SEC_WEBSOCKET_KEY2, insertSpaces2);
        String expectedSubprotocol = expectedSubprotocol();
        if (expectedSubprotocol != null && !expectedSubprotocol.isEmpty()) {
            headers.set(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, expectedSubprotocol);
        }
        headers.set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(randomBytes.length));
        return defaultFullHttpRequest;
    }

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i6, long j6) {
        this(uri, webSocketVersion, str, httpHeaders, i6, j6, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket00FrameEncoder();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket00FrameDecoder(maxFramePayloadLength());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketClientHandshaker00 setForceCloseTimeoutMillis(long j6) {
        super.setForceCloseTimeoutMillis(j6);
        return this;
    }

    WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i6, long j6, boolean z5) {
        super(uri, webSocketVersion, str, httpHeaders, i6, j6, z5);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected void verify(FullHttpResponse fullHttpResponse) {
        if (fullHttpResponse.status().equals(HttpResponseStatus.SWITCHING_PROTOCOLS)) {
            HttpHeaders headers = fullHttpResponse.headers();
            String str = headers.get(HttpHeaderNames.UPGRADE);
            if (WEBSOCKET.contentEqualsIgnoreCase(str)) {
                AsciiString asciiString = HttpHeaderNames.CONNECTION;
                if (headers.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
                    if (fullHttpResponse.content().equals(this.expectedChallengeResponseBytes)) {
                        return;
                    } else {
                        throw new WebSocketHandshakeException("Invalid challenge");
                    }
                } else {
                    throw new WebSocketHandshakeException("Invalid handshake response connection: " + headers.get(asciiString));
                }
            }
            throw new WebSocketHandshakeException("Invalid handshake response upgrade: " + ((Object) str));
        }
        throw new WebSocketHandshakeException("Invalid handshake response getStatus: " + fullHttpResponse.status());
    }
}
