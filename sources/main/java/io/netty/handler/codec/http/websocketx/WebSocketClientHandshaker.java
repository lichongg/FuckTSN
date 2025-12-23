package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class WebSocketClientHandshaker {
    protected static final int DEFAULT_FORCE_CLOSE_TIMEOUT_MILLIS = 10000;
    private final boolean absoluteUpgradeUrl;
    private volatile String actualSubprotocol;
    protected final HttpHeaders customHeaders;
    private final String expectedSubprotocol;
    private volatile boolean forceCloseComplete;
    private volatile int forceCloseInit;
    private volatile long forceCloseTimeoutMillis;
    private volatile boolean handshakeComplete;
    private final int maxFramePayloadLength;
    private final URI uri;
    private final WebSocketVersion version;
    private static final String HTTP_SCHEME_PREFIX = HttpScheme.HTTP + "://";
    private static final String HTTPS_SCHEME_PREFIX = HttpScheme.HTTPS + "://";
    private static final AtomicIntegerFieldUpdater<WebSocketClientHandshaker> FORCE_CLOSE_INIT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(WebSocketClientHandshaker.class, "forceCloseInit");

    protected WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i6) {
        this(uri, webSocketVersion, str, httpHeaders, i6, 10000L);
    }

    private void setHandshakeComplete() {
        this.handshakeComplete = true;
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame) {
        if (channel != null) {
            return close(channel, closeWebSocketFrame, channel.newPromise());
        }
        throw new NullPointerException("channel");
    }

    public ChannelFuture handshake(Channel channel) {
        if (channel != null) {
            return handshake(channel, channel.newPromise());
        }
        throw new NullPointerException("channel");
    }

    protected abstract FullHttpRequest newHandshakeRequest();

    protected abstract WebSocketFrameEncoder newWebSocketEncoder();

    protected abstract WebSocketFrameDecoder newWebsocketDecoder();

    public final ChannelFuture processHandshake(Channel channel, HttpResponse httpResponse) {
        return processHandshake(channel, httpResponse, channel.newPromise());
    }

    protected abstract void verify(FullHttpResponse fullHttpResponse);

    protected WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i6, long j6) {
        this(uri, webSocketVersion, str, httpHeaders, i6, j6, false);
    }

    private void applyForceCloseTimeout(final Channel channel, ChannelFuture channelFuture) {
        final long j6 = this.forceCloseTimeoutMillis;
        if (j6 > 0 && channel.isActive() && this.forceCloseInit == 0) {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.5
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    if (channelFuture2.isSuccess() && channel.isActive() && WebSocketClientHandshaker.FORCE_CLOSE_INIT_UPDATER.compareAndSet(this, 0, 1)) {
                        final ScheduledFuture<?> schedule = channel.eventLoop().schedule(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (channel.isActive()) {
                                    channel.close();
                                    WebSocketClientHandshaker.this.forceCloseComplete = true;
                                }
                            }
                        }, j6, TimeUnit.MILLISECONDS);
                        channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.5.2
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture3) throws Exception {
                                schedule.cancel(false);
                            }
                        });
                    }
                }
            });
        }
    }

    private void setActualSubprotocol(String str) {
        this.actualSubprotocol = str;
    }

    public String actualSubprotocol() {
        return this.actualSubprotocol;
    }

    public String expectedSubprotocol() {
        return this.expectedSubprotocol;
    }

    public long forceCloseTimeoutMillis() {
        return this.forceCloseTimeoutMillis;
    }

    protected boolean isForceCloseComplete() {
        return this.forceCloseComplete;
    }

    public boolean isHandshakeComplete() {
        return this.handshakeComplete;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public final ChannelFuture processHandshake(final Channel channel, HttpResponse httpResponse, final ChannelPromise channelPromise) {
        if (httpResponse instanceof FullHttpResponse) {
            try {
                finishHandshake(channel, (FullHttpResponse) httpResponse);
                channelPromise.setSuccess();
                return channelPromise;
            } catch (Throwable th) {
                channelPromise.setFailure(th);
            }
        } else {
            ChannelPipeline pipeline = channel.pipeline();
            ChannelHandlerContext context = pipeline.context(HttpResponseDecoder.class);
            if (context == null && (context = pipeline.context(HttpClientCodec.class)) == null) {
                return channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain a HttpResponseDecoder or HttpClientCodec"));
            }
            pipeline.addAfter(context.name(), "httpAggregator", new HttpObjectAggregator(8192));
            pipeline.addAfter("httpAggregator", "handshaker", new SimpleChannelInboundHandler<FullHttpResponse>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.4
                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
                public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
                    if (!channelPromise.isDone()) {
                        channelPromise.tryFailure(new ClosedChannelException());
                    }
                    channelHandlerContext.fireChannelInactive();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.netty.channel.SimpleChannelInboundHandler
                public void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception {
                    channelHandlerContext.pipeline().remove(this);
                    try {
                        WebSocketClientHandshaker.this.finishHandshake(channel, fullHttpResponse);
                        channelPromise.setSuccess();
                    } catch (Throwable th2) {
                        channelPromise.setFailure(th2);
                    }
                }

                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
                    channelHandlerContext.pipeline().remove(this);
                    channelPromise.setFailure(th2);
                }
            });
            try {
                context.fireChannelRead(ReferenceCountUtil.retain(httpResponse));
                return channelPromise;
            } catch (Throwable th2) {
                channelPromise.setFailure(th2);
            }
        }
        return channelPromise;
    }

    public WebSocketClientHandshaker setForceCloseTimeoutMillis(long j6) {
        this.forceCloseTimeoutMillis = j6;
        return this;
    }

    protected String upgradeUrl(URI uri) {
        if (this.absoluteUpgradeUrl) {
            return uri.toString();
        }
        String rawPath = uri.getRawPath();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && !rawQuery.isEmpty()) {
            rawPath = rawPath + '?' + rawQuery;
        }
        return (rawPath == null || rawPath.isEmpty()) ? "/" : rawPath;
    }

    public URI uri() {
        return this.uri;
    }

    public WebSocketVersion version() {
        return this.version;
    }

    protected WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i6, long j6, boolean z5) {
        this.forceCloseTimeoutMillis = 10000L;
        this.uri = uri;
        this.version = webSocketVersion;
        this.expectedSubprotocol = str;
        this.customHeaders = httpHeaders;
        this.maxFramePayloadLength = i6;
        this.forceCloseTimeoutMillis = j6;
        this.absoluteUpgradeUrl = z5;
    }

    static CharSequence websocketHostValue(URI uri) {
        int port = uri.getPort();
        if (port == -1) {
            return uri.getHost();
        }
        String host = uri.getHost();
        String scheme = uri.getScheme();
        HttpScheme httpScheme = HttpScheme.HTTP;
        if (port == httpScheme.port()) {
            if (!httpScheme.name().contentEquals(scheme) && !WebSocketScheme.WS.name().contentEquals(scheme)) {
                return NetUtil.toSocketAddressString(host, port);
            }
        } else {
            HttpScheme httpScheme2 = HttpScheme.HTTPS;
            if (port == httpScheme2.port()) {
                if (!httpScheme2.name().contentEquals(scheme) && !WebSocketScheme.WSS.name().contentEquals(scheme)) {
                    return NetUtil.toSocketAddressString(host, port);
                }
            } else {
                return NetUtil.toSocketAddressString(host, port);
            }
        }
        return host;
    }

    static CharSequence websocketOriginValue(URI uri) {
        String str;
        int port;
        String scheme = uri.getScheme();
        int port2 = uri.getPort();
        WebSocketScheme webSocketScheme = WebSocketScheme.WSS;
        if (!webSocketScheme.name().contentEquals(scheme) && !HttpScheme.HTTPS.name().contentEquals(scheme) && (scheme != null || port2 != webSocketScheme.port())) {
            str = HTTP_SCHEME_PREFIX;
            port = WebSocketScheme.WS.port();
        } else {
            str = HTTPS_SCHEME_PREFIX;
            port = webSocketScheme.port();
        }
        String lowerCase = uri.getHost().toLowerCase(Locale.US);
        if (port2 != port && port2 != -1) {
            return str + NetUtil.toSocketAddressString(lowerCase, port2);
        }
        return str + lowerCase;
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        if (channel != null) {
            channel.writeAndFlush(closeWebSocketFrame, channelPromise);
            applyForceCloseTimeout(channel, channelPromise);
            return channelPromise;
        }
        throw new NullPointerException("channel");
    }

    public final void finishHandshake(Channel channel, FullHttpResponse fullHttpResponse) {
        String str;
        verify(fullHttpResponse);
        String str2 = fullHttpResponse.headers().get(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL);
        if (str2 != null) {
            str = str2.trim();
        } else {
            str = null;
        }
        String str3 = this.expectedSubprotocol;
        if (str3 == null) {
            str3 = "";
        }
        if (str3.isEmpty() && str == null) {
            setActualSubprotocol(this.expectedSubprotocol);
        } else {
            if (!str3.isEmpty() && str != null && !str.isEmpty()) {
                for (String str4 : str3.split(",")) {
                    if (str4.trim().equals(str)) {
                        setActualSubprotocol(str);
                    }
                }
            }
            throw new WebSocketHandshakeException(String.format("Invalid subprotocol. Actual: %s. Expected one of: %s", str, this.expectedSubprotocol));
        }
        setHandshakeComplete();
        final ChannelPipeline pipeline = channel.pipeline();
        HttpContentDecompressor httpContentDecompressor = (HttpContentDecompressor) pipeline.get(HttpContentDecompressor.class);
        if (httpContentDecompressor != null) {
            pipeline.remove(httpContentDecompressor);
        }
        HttpObjectAggregator httpObjectAggregator = (HttpObjectAggregator) pipeline.get(HttpObjectAggregator.class);
        if (httpObjectAggregator != null) {
            pipeline.remove(httpObjectAggregator);
        }
        final ChannelHandlerContext context = pipeline.context(HttpResponseDecoder.class);
        if (context == null) {
            ChannelHandlerContext context2 = pipeline.context(HttpClientCodec.class);
            if (context2 != null) {
                final HttpClientCodec httpClientCodec = (HttpClientCodec) context2.handler();
                httpClientCodec.removeOutboundHandler();
                pipeline.addAfter(context2.name(), "ws-decoder", newWebsocketDecoder());
                channel.eventLoop().execute(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pipeline.remove(httpClientCodec);
                    }
                });
                return;
            }
            throw new IllegalStateException("ChannelPipeline does not contain a HttpRequestEncoder or HttpClientCodec");
        }
        if (pipeline.get(HttpRequestEncoder.class) != null) {
            pipeline.remove(HttpRequestEncoder.class);
        }
        pipeline.addAfter(context.name(), "ws-decoder", newWebsocketDecoder());
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.3
            @Override // java.lang.Runnable
            public void run() {
                pipeline.remove(context.handler());
            }
        });
    }

    public final ChannelFuture handshake(Channel channel, final ChannelPromise channelPromise) {
        ChannelPipeline pipeline = channel.pipeline();
        if (((HttpResponseDecoder) pipeline.get(HttpResponseDecoder.class)) == null && ((HttpClientCodec) pipeline.get(HttpClientCodec.class)) == null) {
            channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain a HttpResponseDecoder or HttpClientCodec"));
            return channelPromise;
        }
        channel.writeAndFlush(newHandshakeRequest()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                if (!channelFuture.isSuccess()) {
                    channelPromise.setFailure(channelFuture.cause());
                    return;
                }
                ChannelPipeline pipeline2 = channelFuture.channel().pipeline();
                ChannelHandlerContext context = pipeline2.context(HttpRequestEncoder.class);
                if (context == null) {
                    context = pipeline2.context(HttpClientCodec.class);
                }
                if (context == null) {
                    channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain a HttpRequestEncoder or HttpClientCodec"));
                } else {
                    pipeline2.addAfter(context.name(), "ws-encoder", WebSocketClientHandshaker.this.newWebSocketEncoder());
                    channelPromise.setSuccess();
                }
            }
        });
        return channelPromise;
    }
}
