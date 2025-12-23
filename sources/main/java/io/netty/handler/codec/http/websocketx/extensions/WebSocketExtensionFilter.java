package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.handler.codec.http.websocketx.WebSocketFrame;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface WebSocketExtensionFilter {
    public static final WebSocketExtensionFilter NEVER_SKIP = new WebSocketExtensionFilter() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter.1
        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter
        public boolean mustSkip(WebSocketFrame webSocketFrame) {
            return false;
        }
    };
    public static final WebSocketExtensionFilter ALWAYS_SKIP = new WebSocketExtensionFilter() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter.2
        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter
        public boolean mustSkip(WebSocketFrame webSocketFrame) {
            return true;
        }
    };

    boolean mustSkip(WebSocketFrame webSocketFrame);
}
