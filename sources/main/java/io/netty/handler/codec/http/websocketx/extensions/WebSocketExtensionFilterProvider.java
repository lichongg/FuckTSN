package io.netty.handler.codec.http.websocketx.extensions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface WebSocketExtensionFilterProvider {
    public static final WebSocketExtensionFilterProvider DEFAULT = new WebSocketExtensionFilterProvider() { // from class: io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider.1
        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider
        public WebSocketExtensionFilter decoderFilter() {
            return WebSocketExtensionFilter.NEVER_SKIP;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider
        public WebSocketExtensionFilter encoderFilter() {
            return WebSocketExtensionFilter.NEVER_SKIP;
        }
    };

    WebSocketExtensionFilter decoderFilter();

    WebSocketExtensionFilter encoderFilter();
}
