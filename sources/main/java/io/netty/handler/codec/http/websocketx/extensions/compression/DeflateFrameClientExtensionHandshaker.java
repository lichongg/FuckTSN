package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DeflateFrameClientExtensionHandshaker implements WebSocketClientExtensionHandshaker {
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean useWebkitExtensionName;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class DeflateFrameClientExtension implements WebSocketClientExtension {
        private final int compressionLevel;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerFrameDeflateDecoder(false, this.extensionFilterProvider.decoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerFrameDeflateEncoder(this.compressionLevel, 15, false, this.extensionFilterProvider.encoderFilter());
        }

        DeflateFrameClientExtension(int i6, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.compressionLevel = i6;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }
    }

    public DeflateFrameClientExtensionHandshaker(boolean z5) {
        this(6, z5);
    }

    public DeflateFrameClientExtensionHandshaker(int i6, boolean z5) {
        this(i6, z5, WebSocketExtensionFilterProvider.DEFAULT);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketClientExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (("x-webkit-deflate-frame".equals(webSocketExtensionData.name()) || "deflate-frame".equals(webSocketExtensionData.name())) && webSocketExtensionData.parameters().isEmpty()) {
            return new DeflateFrameClientExtension(this.compressionLevel, this.extensionFilterProvider);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketExtensionData newRequestData() {
        return new WebSocketExtensionData(this.useWebkitExtensionName ? "x-webkit-deflate-frame" : "deflate-frame", Collections.EMPTY_MAP);
    }

    public DeflateFrameClientExtensionHandshaker(int i6, boolean z5, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i6 >= 0 && i6 <= 9) {
            this.compressionLevel = i6;
            this.useWebkitExtensionName = z5;
            this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
        } else {
            throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
        }
    }
}
