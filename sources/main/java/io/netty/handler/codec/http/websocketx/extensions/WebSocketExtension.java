package io.netty.handler.codec.http.websocketx.extensions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface WebSocketExtension {
    public static final int RSV1 = 4;
    public static final int RSV2 = 2;
    public static final int RSV3 = 1;

    WebSocketExtensionDecoder newExtensionDecoder();

    WebSocketExtensionEncoder newExtensionEncoder();

    int rsv();
}
