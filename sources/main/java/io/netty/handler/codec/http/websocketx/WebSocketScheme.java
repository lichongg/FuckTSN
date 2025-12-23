package io.netty.handler.codec.http.websocketx;

import io.netty.util.AsciiString;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WebSocketScheme {
    public static final WebSocketScheme WS = new WebSocketScheme(80, "ws");
    public static final WebSocketScheme WSS = new WebSocketScheme(443, "wss");
    private final AsciiString name;
    private final int port;

    public boolean equals(Object obj) {
        if (!(obj instanceof WebSocketScheme)) {
            return false;
        }
        WebSocketScheme webSocketScheme = (WebSocketScheme) obj;
        return webSocketScheme.port() == this.port && webSocketScheme.name().equals(this.name);
    }

    public int hashCode() {
        return (this.port * 31) + this.name.hashCode();
    }

    public AsciiString name() {
        return this.name;
    }

    public int port() {
        return this.port;
    }

    public String toString() {
        return this.name.toString();
    }

    private WebSocketScheme(int i6, String str) {
        this.port = i6;
        this.name = AsciiString.cached(str);
    }
}
