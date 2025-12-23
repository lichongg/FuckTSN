package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class WebSocketServerProtocolHandshakeHandler extends ChannelInboundHandlerAdapter {
    private final boolean checkStartsWith;
    private ChannelHandlerContext ctx;
    private final WebSocketDecoderConfig decoderConfig;
    private ChannelPromise handshakePromise;
    private final long handshakeTimeoutMillis;
    private final String subprotocols;
    private final String websocketPath;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(final ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        Throwable th;
        final FullHttpRequest fullHttpRequest = (FullHttpRequest) obj;
        if (isNotWebSocketPath(fullHttpRequest)) {
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (!HttpMethod.GET.equals(fullHttpRequest.method())) {
                sendHttpResponse(channelHandlerContext, fullHttpRequest, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN, channelHandlerContext.alloc().buffer(0)));
                fullHttpRequest.release();
                return;
            }
            final WebSocketServerHandshaker newHandshaker = new WebSocketServerHandshakerFactory(getWebSocketLocation(channelHandlerContext.pipeline(), fullHttpRequest, this.websocketPath), this.subprotocols, this.decoderConfig).newHandshaker(fullHttpRequest);
            final ChannelPromise channelPromise = this.handshakePromise;
            if (newHandshaker == null) {
                WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(channelHandlerContext.channel());
            } else {
                try {
                    newHandshaker.handshake(channelHandlerContext.channel(), fullHttpRequest).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler.1
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            if (!channelFuture.isSuccess()) {
                                channelPromise.tryFailure(channelFuture.cause());
                                channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                            } else {
                                channelPromise.trySuccess();
                                channelHandlerContext.fireUserEventTriggered((Object) WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE);
                                channelHandlerContext.fireUserEventTriggered((Object) new WebSocketServerProtocolHandler.HandshakeComplete(fullHttpRequest.uri(), fullHttpRequest.headers(), newHandshaker.selectedSubprotocol()));
                            }
                        }
                    });
                    applyHandshakeTimeout();
                    WebSocketServerProtocolHandler.setHandshaker(channelHandlerContext.channel(), newHandshaker);
                    channelHandlerContext.pipeline().replace(this, "WS403Responder", WebSocketServerProtocolHandler.forbiddenHttpRequestResponder());
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    fullHttpRequest.release();
                    throw th;
                }
            }
            fullHttpRequest.release();
        } catch (Throwable th4) {
            th = th4;
            fullHttpRequest.release();
            throw th;
        }
    }

    private void applyHandshakeTimeout() {
        final ChannelPromise channelPromise = this.handshakePromise;
        long j6 = this.handshakeTimeoutMillis;
        if (j6 <= 0 || channelPromise.isDone()) {
            return;
        }
        final ScheduledFuture<?> schedule = this.ctx.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler.2
            @Override // java.lang.Runnable
            public void run() {
                if (channelPromise.isDone() || !channelPromise.tryFailure(new WebSocketHandshakeException("handshake timed out"))) {
                    return;
                }
                WebSocketServerProtocolHandshakeHandler.this.ctx.flush().fireUserEventTriggered((Object) WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_TIMEOUT).close();
            }
        }, j6, TimeUnit.MILLISECONDS);
        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new FutureListener<Void>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Void> future) throws Exception {
                schedule.cancel(false);
            }
        });
    }

    private static String getWebSocketLocation(ChannelPipeline channelPipeline, HttpRequest httpRequest, String str) {
        return (channelPipeline.get(SslHandler.class) != null ? "wss" : "ws") + "://" + httpRequest.headers().get(HttpHeaderNames.HOST) + str;
    }

    private boolean isNotWebSocketPath(FullHttpRequest fullHttpRequest) {
        boolean z5 = this.checkStartsWith;
        String uri = fullHttpRequest.uri();
        return z5 ? !uri.startsWith(this.websocketPath) : !uri.equals(this.websocketPath);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.handshakePromise = channelHandlerContext.newPromise();
    }

    WebSocketServerProtocolHandshakeHandler(String str, String str2, boolean z5, long j6, WebSocketDecoderConfig webSocketDecoderConfig) {
        this.websocketPath = str;
        this.subprotocols = str2;
        this.checkStartsWith = z5;
        this.handshakeTimeoutMillis = ObjectUtil.checkPositive(j6, "handshakeTimeoutMillis");
        this.decoderConfig = (WebSocketDecoderConfig) ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
    }

    private static void sendHttpResponse(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        ChannelFuture writeAndFlush = channelHandlerContext.channel().writeAndFlush(httpResponse);
        if (HttpUtil.isKeepAlive(httpRequest) && httpResponse.status().code() == 200) {
            return;
        }
        writeAndFlush.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
    }
}
