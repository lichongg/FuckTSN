package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.HttpHeaders;
import java.net.URI;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WebSocketClientHandshakerFactory {
    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders) {
        return newHandshaker(uri, webSocketVersion, str, z5, httpHeaders, 65536);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6) {
        return newHandshaker(uri, webSocketVersion, str, z5, httpHeaders, i6, true, false);
    }

    private WebSocketClientHandshakerFactory() {
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7) {
        return newHandshaker(uri, webSocketVersion, str, z5, httpHeaders, i6, true, false, -1L);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7, long j6) {
        WebSocketVersion webSocketVersion2 = WebSocketVersion.V13;
        if (webSocketVersion == webSocketVersion2) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion2, str, z5, httpHeaders, i6, z6, z7, j6);
        }
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V08;
        if (webSocketVersion == webSocketVersion3) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion3, str, z5, httpHeaders, i6, z6, z7, j6);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V07;
        if (webSocketVersion == webSocketVersion4) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion4, str, z5, httpHeaders, i6, z6, z7, j6);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V00;
        if (webSocketVersion == webSocketVersion5) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion5, str, httpHeaders, i6, j6);
        }
        throw new WebSocketHandshakeException("Protocol version " + webSocketVersion + " not supported.");
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7, long j6, boolean z8) {
        WebSocketVersion webSocketVersion2 = WebSocketVersion.V13;
        if (webSocketVersion == webSocketVersion2) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion2, str, z5, httpHeaders, i6, z6, z7, j6, z8);
        }
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V08;
        if (webSocketVersion == webSocketVersion3) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion3, str, z5, httpHeaders, i6, z6, z7, j6, z8);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V07;
        if (webSocketVersion == webSocketVersion4) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion4, str, z5, httpHeaders, i6, z6, z7, j6, z8);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V00;
        if (webSocketVersion == webSocketVersion5) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion5, str, httpHeaders, i6, j6, z8);
        }
        throw new WebSocketHandshakeException("Protocol version " + webSocketVersion + " not supported.");
    }
}
