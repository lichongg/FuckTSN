package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketServerHandshakerFactory {
    private final WebSocketDecoderConfig decoderConfig;
    private final String subprotocols;
    private final String webSocketURL;

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z5) {
        this(str, str2, z5, 65536);
    }

    public static ChannelFuture sendUnsupportedVersionResponse(Channel channel) {
        return sendUnsupportedVersionResponse(channel, channel.newPromise());
    }

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z5, int i6) {
        this(str, str2, z5, i6, false);
    }

    public static ChannelFuture sendUnsupportedVersionResponse(Channel channel, ChannelPromise channelPromise) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.UPGRADE_REQUIRED, channel.alloc().buffer(0));
        defaultFullHttpResponse.headers().set(HttpHeaderNames.SEC_WEBSOCKET_VERSION, WebSocketVersion.V13.toHttpHeaderValue());
        HttpUtil.setContentLength(defaultFullHttpResponse, 0L);
        return channel.writeAndFlush(defaultFullHttpResponse, channelPromise);
    }

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z5, int i6, boolean z6) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().allowExtensions(z5).maxFramePayloadLength(i6).allowMaskMismatch(z6).build());
    }

    @Deprecated
    public static void sendUnsupportedWebSocketVersionResponse(Channel channel) {
        sendUnsupportedVersionResponse(channel);
    }

    public WebSocketServerHandshaker newHandshaker(HttpRequest httpRequest) {
        String str = httpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_VERSION);
        if (str != null) {
            if (str.equals(WebSocketVersion.V13.toHttpHeaderValue())) {
                return new WebSocketServerHandshaker13(this.webSocketURL, this.subprotocols, this.decoderConfig);
            }
            if (str.equals(WebSocketVersion.V08.toHttpHeaderValue())) {
                return new WebSocketServerHandshaker08(this.webSocketURL, this.subprotocols, this.decoderConfig);
            }
            if (str.equals(WebSocketVersion.V07.toHttpHeaderValue())) {
                return new WebSocketServerHandshaker07(this.webSocketURL, this.subprotocols, this.decoderConfig);
            }
            return null;
        }
        return new WebSocketServerHandshaker00(this.webSocketURL, this.subprotocols, this.decoderConfig);
    }

    public WebSocketServerHandshakerFactory(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        this.webSocketURL = str;
        this.subprotocols = str2;
        this.decoderConfig = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }
}
