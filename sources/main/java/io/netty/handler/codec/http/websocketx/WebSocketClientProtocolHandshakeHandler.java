package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class WebSocketClientProtocolHandshakeHandler extends ChannelInboundHandlerAdapter {
    private static final long DEFAULT_HANDSHAKE_TIMEOUT_MS = 10000;
    private ChannelHandlerContext ctx;
    private ChannelPromise handshakePromise;
    private final long handshakeTimeoutMillis;
    private final WebSocketClientHandshaker handshaker;

    WebSocketClientProtocolHandshakeHandler(WebSocketClientHandshaker webSocketClientHandshaker) {
        this(webSocketClientHandshaker, 10000L);
    }

    WebSocketClientProtocolHandshakeHandler(WebSocketClientHandshaker webSocketClientHandshaker, long j6) {
        this.handshaker = webSocketClientHandshaker;
        this.handshakeTimeoutMillis = ObjectUtil.checkPositive(j6, "handshakeTimeoutMillis");
    }

    private void applyHandshakeTimeout() {
        final ChannelPromise channelPromise = this.handshakePromise;
        if (this.handshakeTimeoutMillis <= 0 || channelPromise.isDone()) {
            return;
        }
        final ScheduledFuture<?> schedule = this.ctx.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandshakeHandler.2
            @Override // java.lang.Runnable
            public void run() {
                if (!channelPromise.isDone() && channelPromise.tryFailure(new WebSocketHandshakeException("handshake timed out"))) {
                    WebSocketClientProtocolHandshakeHandler.this.ctx.flush().fireUserEventTriggered((Object) WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_TIMEOUT).close();
                }
            }
        }, this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
        channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new FutureListener<Void>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandshakeHandler.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Void> future) throws Exception {
                schedule.cancel(false);
            }
        });
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (!(obj instanceof FullHttpResponse)) {
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        FullHttpResponse fullHttpResponse = (FullHttpResponse) obj;
        try {
            if (this.handshaker.isHandshakeComplete()) {
                throw new IllegalStateException("WebSocketClientHandshaker should have been non finished yet");
            }
            this.handshaker.finishHandshake(channelHandlerContext.channel(), fullHttpResponse);
            this.handshakePromise.trySuccess();
            channelHandlerContext.fireUserEventTriggered((Object) WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_COMPLETE);
            channelHandlerContext.pipeline().remove(this);
        } finally {
            fullHttpResponse.release();
        }
    }

    ChannelFuture getHandshakeFuture() {
        return this.handshakePromise;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.handshakePromise = channelHandlerContext.newPromise();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(final ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelActive(channelHandlerContext);
        this.handshaker.handshake(channelHandlerContext.channel()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandshakeHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    channelHandlerContext.fireUserEventTriggered((Object) WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_ISSUED);
                } else {
                    WebSocketClientProtocolHandshakeHandler.this.handshakePromise.tryFailure(channelFuture.cause());
                    channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                }
            }
        });
        applyHandshakeTimeout();
    }
}
