package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.ObjectUtil;
import java.net.URI;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WebSocketClientProtocolHandler extends WebSocketProtocolHandler {
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MS = 10000;
    private final boolean handleCloseFrames;
    private final long handshakeTimeoutMillis;
    private final WebSocketClientHandshaker handshaker;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ClientHandshakeStateEvent {
        HANDSHAKE_TIMEOUT,
        HANDSHAKE_ISSUED,
        HANDSHAKE_COMPLETE
    }

    public WebSocketClientProtocolHandler(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7, boolean z8) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, z6, z7, z8, 10000L);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    public WebSocketClientProtocolHandler(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, boolean z7, boolean z8, long j6) {
        this(WebSocketClientHandshakerFactory.newHandshaker(uri, webSocketVersion, str, z5, httpHeaders, i6, z7, z8), z6, j6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler
    protected void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (this.handleCloseFrames && (webSocketFrame instanceof CloseWebSocketFrame)) {
            channelHandlerContext.close();
        } else {
            super.decode(channelHandlerContext, webSocketFrame, list);
        }
    }

    public WebSocketClientHandshaker handshaker() {
        return this.handshaker;
    }

    public WebSocketClientProtocolHandler(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, z6, 10000L);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public /* bridge */ /* synthetic */ void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        super.exceptionCaught(channelHandlerContext, th);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline pipeline = channelHandlerContext.pipeline();
        if (pipeline.get(WebSocketClientProtocolHandshakeHandler.class) == null) {
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), WebSocketClientProtocolHandshakeHandler.class.getName(), new WebSocketClientProtocolHandshakeHandler(this.handshaker, this.handshakeTimeoutMillis));
        }
        if (pipeline.get(Utf8FrameValidator.class) == null) {
            channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), Utf8FrameValidator.class.getName(), new Utf8FrameValidator());
        }
    }

    public WebSocketClientProtocolHandler(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, boolean z6, long j6) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, z6, true, false, j6);
    }

    public WebSocketClientProtocolHandler(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, 10000L);
    }

    public WebSocketClientProtocolHandler(URI uri, WebSocketVersion webSocketVersion, String str, boolean z5, HttpHeaders httpHeaders, int i6, long j6) {
        this(uri, webSocketVersion, str, z5, httpHeaders, i6, true, j6);
    }

    public WebSocketClientProtocolHandler(WebSocketClientHandshaker webSocketClientHandshaker, boolean z5) {
        this(webSocketClientHandshaker, z5, 10000L);
    }

    public WebSocketClientProtocolHandler(WebSocketClientHandshaker webSocketClientHandshaker, boolean z5, long j6) {
        this(webSocketClientHandshaker, z5, true, j6);
    }

    public WebSocketClientProtocolHandler(WebSocketClientHandshaker webSocketClientHandshaker, boolean z5, boolean z6) {
        this(webSocketClientHandshaker, z5, z6, 10000L);
    }

    public WebSocketClientProtocolHandler(WebSocketClientHandshaker webSocketClientHandshaker, boolean z5, boolean z6, long j6) {
        super(z6);
        this.handshaker = webSocketClientHandshaker;
        this.handleCloseFrames = z5;
        this.handshakeTimeoutMillis = ObjectUtil.checkPositive(j6, "handshakeTimeoutMillis");
    }

    public WebSocketClientProtocolHandler(WebSocketClientHandshaker webSocketClientHandshaker) {
        this(webSocketClientHandshaker, 10000L);
    }

    public WebSocketClientProtocolHandler(WebSocketClientHandshaker webSocketClientHandshaker, long j6) {
        this(webSocketClientHandshaker, true, j6);
    }
}
