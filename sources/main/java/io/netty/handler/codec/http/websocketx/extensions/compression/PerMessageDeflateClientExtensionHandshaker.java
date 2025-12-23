package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PerMessageDeflateClientExtensionHandshaker implements WebSocketClientExtensionHandshaker {
    private final boolean allowClientNoContext;
    private final boolean allowClientWindowSize;
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean requestedServerNoContext;
    private final int requestedServerWindowSize;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class PermessageDeflateExtension implements WebSocketClientExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }

        PermessageDeflateExtension(boolean z5, int i6, boolean z6, int i7, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.serverNoContext = z5;
            this.serverWindowSize = i6;
            this.clientNoContext = z6;
            this.clientWindowSize = i7;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerMessageDeflateDecoder(this.serverNoContext, this.extensionFilterProvider.decoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerMessageDeflateEncoder(PerMessageDeflateClientExtensionHandshaker.this.compressionLevel, this.clientWindowSize, this.clientNoContext, this.extensionFilterProvider.encoderFilter());
        }
    }

    public PerMessageDeflateClientExtensionHandshaker() {
        this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i6, boolean z5, int i7, boolean z6, boolean z7) {
        this(i6, z5, i7, z6, z7, WebSocketExtensionFilterProvider.DEFAULT);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketClientExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (!"permessage-deflate".equals(webSocketExtensionData.name())) {
            return null;
        }
        Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        int i6 = 15;
        boolean z8 = false;
        int i7 = 15;
        while (z6 && it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if ("client_max_window_bits".equalsIgnoreCase(next.getKey())) {
                if (this.allowClientWindowSize) {
                    i7 = Integer.parseInt(next.getValue());
                } else {
                    z6 = false;
                }
            } else if ("server_max_window_bits".equalsIgnoreCase(next.getKey())) {
                i6 = Integer.parseInt(next.getValue());
                if (i7 <= 15 && i7 >= 8) {
                }
                z6 = false;
            } else if (!"client_no_context_takeover".equalsIgnoreCase(next.getKey())) {
                if ("server_no_context_takeover".equalsIgnoreCase(next.getKey()) && this.requestedServerNoContext) {
                    z7 = true;
                }
                z6 = false;
            } else if (this.allowClientNoContext) {
                z8 = true;
            } else {
                z6 = false;
            }
        }
        if ((!this.requestedServerNoContext || z7) && this.requestedServerWindowSize == i6) {
            z5 = z6;
        }
        if (z5) {
            return new PermessageDeflateExtension(z7, i6, z8, i7, this.extensionFilterProvider);
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketExtensionData newRequestData() {
        HashMap hashMap = new HashMap(4);
        if (this.requestedServerWindowSize != 15) {
            hashMap.put("server_no_context_takeover", null);
        }
        if (this.allowClientNoContext) {
            hashMap.put("client_no_context_takeover", null);
        }
        int i6 = this.requestedServerWindowSize;
        if (i6 != 15) {
            hashMap.put("server_max_window_bits", Integer.toString(i6));
        }
        if (this.allowClientWindowSize) {
            hashMap.put("client_max_window_bits", null);
        }
        return new WebSocketExtensionData("permessage-deflate", hashMap);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i6, boolean z5, int i7, boolean z6, boolean z7, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i7 > 15 || i7 < 8) {
            throw new IllegalArgumentException("requestedServerWindowSize: " + i7 + " (expected: 8-15)");
        }
        if (i6 >= 0 && i6 <= 9) {
            this.compressionLevel = i6;
            this.allowClientWindowSize = z5;
            this.requestedServerWindowSize = i7;
            this.allowClientNoContext = z6;
            this.requestedServerNoContext = z7;
            this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
            return;
        }
        throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
    }
}
