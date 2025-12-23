package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class PerMessageDeflateServerExtensionHandshaker implements WebSocketServerExtensionHandshaker {
    static final String CLIENT_MAX_WINDOW = "client_max_window_bits";
    static final String CLIENT_NO_CONTEXT = "client_no_context_takeover";
    public static final int MAX_WINDOW_SIZE = 15;
    public static final int MIN_WINDOW_SIZE = 8;
    static final String PERMESSAGE_DEFLATE_EXTENSION = "permessage-deflate";
    static final String SERVER_MAX_WINDOW = "server_max_window_bits";
    static final String SERVER_NO_CONTEXT = "server_no_context_takeover";
    private final boolean allowServerNoContext;
    private final boolean allowServerWindowSize;
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;
    private final boolean preferredClientNoContext;
    private final int preferredClientWindowSize;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PermessageDeflateExtension implements WebSocketServerExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final int compressionLevel;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerMessageDeflateDecoder(this.clientNoContext, this.extensionFilterProvider.decoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerMessageDeflateEncoder(this.compressionLevel, this.serverWindowSize, this.serverNoContext, this.extensionFilterProvider.encoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension
        public WebSocketExtensionData newReponseData() {
            HashMap hashMap = new HashMap(4);
            if (this.serverNoContext) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.SERVER_NO_CONTEXT, null);
            }
            if (this.clientNoContext) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.CLIENT_NO_CONTEXT, null);
            }
            int i6 = this.serverWindowSize;
            if (i6 != 15) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.SERVER_MAX_WINDOW, Integer.toString(i6));
            }
            int i7 = this.clientWindowSize;
            if (i7 != 15) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.CLIENT_MAX_WINDOW, Integer.toString(i7));
            }
            return new WebSocketExtensionData(PerMessageDeflateServerExtensionHandshaker.PERMESSAGE_DEFLATE_EXTENSION, hashMap);
        }

        PermessageDeflateExtension(int i6, boolean z5, int i7, boolean z6, int i8, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.compressionLevel = i6;
            this.serverNoContext = z5;
            this.serverWindowSize = i7;
            this.clientNoContext = z6;
            this.clientWindowSize = i8;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }
    }

    public PerMessageDeflateServerExtensionHandshaker() {
        this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
    }

    public PerMessageDeflateServerExtensionHandshaker(int i6, boolean z5, int i7, boolean z6, boolean z7) {
        this(i6, z5, i7, z6, z7, WebSocketExtensionFilterProvider.DEFAULT);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker
    public WebSocketServerExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (!PERMESSAGE_DEFLATE_EXTENSION.equals(webSocketExtensionData.name())) {
            return null;
        }
        Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
        boolean z5 = true;
        boolean z6 = false;
        int i6 = 15;
        boolean z7 = false;
        int i7 = 15;
        while (z5 && it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (CLIENT_MAX_WINDOW.equalsIgnoreCase(next.getKey())) {
                i7 = this.preferredClientWindowSize;
            } else if (SERVER_MAX_WINDOW.equalsIgnoreCase(next.getKey())) {
                if (this.allowServerWindowSize && (i6 = Integer.parseInt(next.getValue())) <= 15 && i6 >= 8) {
                }
                z5 = false;
            } else if (CLIENT_NO_CONTEXT.equalsIgnoreCase(next.getKey())) {
                z7 = this.preferredClientNoContext;
            } else {
                if (SERVER_NO_CONTEXT.equalsIgnoreCase(next.getKey()) && this.allowServerNoContext) {
                    z6 = true;
                }
                z5 = false;
            }
        }
        if (z5) {
            return new PermessageDeflateExtension(this.compressionLevel, z6, i6, z7, i7, this.extensionFilterProvider);
        }
        return null;
    }

    public PerMessageDeflateServerExtensionHandshaker(int i6, boolean z5, int i7, boolean z6, boolean z7, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i7 > 15 || i7 < 8) {
            throw new IllegalArgumentException("preferredServerWindowSize: " + i7 + " (expected: 8-15)");
        }
        if (i6 >= 0 && i6 <= 9) {
            this.compressionLevel = i6;
            this.allowServerWindowSize = z5;
            this.preferredClientWindowSize = i7;
            this.allowServerNoContext = z6;
            this.preferredClientNoContext = z7;
            this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
            return;
        }
        throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
    }
}
