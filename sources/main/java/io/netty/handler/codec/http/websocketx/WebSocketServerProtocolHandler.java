package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketServerProtocolHandler extends WebSocketProtocolHandler {
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MS = 10000;
    private static final AttributeKey<WebSocketServerHandshaker> HANDSHAKER_ATTR_KEY = AttributeKey.valueOf(WebSocketServerHandshaker.class, "HANDSHAKER");
    private final boolean checkStartsWith;
    private final WebSocketDecoderConfig decoderConfig;
    private final long handshakeTimeoutMillis;
    private final String subprotocols;
    private final String websocketPath;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class HandshakeComplete {
        private final HttpHeaders requestHeaders;
        private final String requestUri;
        private final String selectedSubprotocol;

        public HttpHeaders requestHeaders() {
            return this.requestHeaders;
        }

        public String requestUri() {
            return this.requestUri;
        }

        public String selectedSubprotocol() {
            return this.selectedSubprotocol;
        }

        HandshakeComplete(String str, HttpHeaders httpHeaders, String str2) {
            this.requestUri = str;
            this.requestHeaders = httpHeaders;
            this.selectedSubprotocol = str2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ServerHandshakeStateEvent {
        HANDSHAKE_COMPLETE,
        HANDSHAKE_TIMEOUT
    }

    public WebSocketServerProtocolHandler(String str) {
        this(str, 10000L);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    public WebSocketServerProtocolHandler(String str, long j6) {
        this(str, (String) null, false);
    }

    static ChannelHandler forbiddenHttpRequestResponder() {
        return new ChannelInboundHandlerAdapter() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler.1
            @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
            public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
                if (!(obj instanceof FullHttpRequest)) {
                    channelHandlerContext.fireChannelRead(obj);
                    return;
                }
                ((FullHttpRequest) obj).release();
                channelHandlerContext.channel().writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN, channelHandlerContext.alloc().buffer(0)));
            }
        };
    }

    static WebSocketServerHandshaker getHandshaker(Channel channel) {
        return (WebSocketServerHandshaker) channel.attr(HANDSHAKER_ATTR_KEY).get();
    }

    static void setHandshaker(Channel channel, WebSocketServerHandshaker webSocketServerHandshaker) {
        channel.attr(HANDSHAKER_ATTR_KEY).set(webSocketServerHandshaker);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler
    protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (!(webSocketFrame instanceof CloseWebSocketFrame)) {
            super.decode(channelHandlerContext, webSocketFrame, list);
            return;
        }
        WebSocketServerHandshaker handshaker = getHandshaker(channelHandlerContext.channel());
        if (handshaker == null) {
            channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        } else {
            webSocketFrame.retain();
            handshaker.close(channelHandlerContext.channel(), (CloseWebSocketFrame) webSocketFrame);
        }
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        if (th instanceof WebSocketHandshakeException) {
            channelHandlerContext.channel().writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.wrappedBuffer(th.getMessage().getBytes()))).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        } else {
            channelHandlerContext.fireExceptionCaught(th);
            channelHandlerContext.close();
        }
    }

    public WebSocketServerProtocolHandler(String str, boolean z5) {
        this(str, z5, 10000L);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline pipeline = channelHandlerContext.pipeline();
        if (pipeline.get(WebSocketServerProtocolHandshakeHandler.class) == null) {
            pipeline.addBefore(channelHandlerContext.name(), WebSocketServerProtocolHandshakeHandler.class.getName(), new WebSocketServerProtocolHandshakeHandler(this.websocketPath, this.subprotocols, this.checkStartsWith, this.handshakeTimeoutMillis, this.decoderConfig));
        }
        if (pipeline.get(Utf8FrameValidator.class) == null) {
            pipeline.addBefore(channelHandlerContext.name(), Utf8FrameValidator.class.getName(), new Utf8FrameValidator());
        }
    }

    public WebSocketServerProtocolHandler(String str, boolean z5, long j6) {
        this(str, (String) null, false, 65536, false, z5, j6);
    }

    public WebSocketServerProtocolHandler(String str, String str2) {
        this(str, str2, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, long j6) {
        this(str, str2, false, j6);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5) {
        this(str, str2, z5, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, long j6) {
        this(str, str2, z5, 65536, j6);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6) {
        this(str, str2, z5, i6, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6, long j6) {
        this(str, str2, z5, i6, false, j6);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6, boolean z6) {
        this(str, str2, z5, i6, z6, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6, boolean z6, long j6) {
        this(str, str2, z5, i6, z6, false, j6);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6, boolean z6, boolean z7) {
        this(str, str2, z5, i6, z6, z7, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6, boolean z6, boolean z7, long j6) {
        this(str, str2, z5, i6, z6, z7, true, j6);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6, boolean z6, boolean z7, boolean z8) {
        this(str, str2, z5, i6, z6, z7, z8, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, int i6, boolean z6, boolean z7, boolean z8, long j6) {
        this(str, str2, z7, z8, j6, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(i6).allowMaskMismatch(z6).allowExtensions(z5).build());
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z5, boolean z6, long j6, WebSocketDecoderConfig webSocketDecoderConfig) {
        super(z6);
        this.websocketPath = str;
        this.subprotocols = str2;
        this.checkStartsWith = z5;
        this.handshakeTimeoutMillis = ObjectUtil.checkPositive(j6, "handshakeTimeoutMillis");
        this.decoderConfig = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }
}
