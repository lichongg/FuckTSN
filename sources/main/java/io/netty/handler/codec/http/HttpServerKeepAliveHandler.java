package io.netty.handler.codec.http;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpServerKeepAliveHandler extends ChannelDuplexHandler {
    private static final String MULTIPART_PREFIX = "multipart";
    private int pendingResponses;
    private boolean persistentConnection = true;

    private boolean shouldKeepAlive() {
        return this.pendingResponses != 0 || this.persistentConnection;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (this.persistentConnection) {
                this.pendingResponses++;
                this.persistentConnection = HttpUtil.isKeepAlive(httpRequest);
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            trackResponse(httpResponse);
            if (!HttpUtil.isKeepAlive(httpResponse) || !isSelfDefinedMessageLength(httpResponse)) {
                this.pendingResponses = 0;
                this.persistentConnection = false;
            }
            if (!shouldKeepAlive()) {
                HttpUtil.setKeepAlive(httpResponse, false);
            }
        }
        ChannelPromise channelPromise2 = channelPromise;
        if (obj instanceof LastHttpContent) {
            channelPromise2 = channelPromise;
            if (!shouldKeepAlive()) {
                channelPromise2 = channelPromise.unvoid().addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            }
        }
        super.write(channelHandlerContext, obj, channelPromise2);
    }

    private static boolean isInformational(HttpResponse httpResponse) {
        if (httpResponse.status().codeClass() == HttpStatusClass.INFORMATIONAL) {
            return true;
        }
        return false;
    }

    private static boolean isMultipart(HttpResponse httpResponse) {
        String str = httpResponse.headers().get(HttpHeaderNames.CONTENT_TYPE);
        if (str != null && str.regionMatches(true, 0, MULTIPART_PREFIX, 0, 9)) {
            return true;
        }
        return false;
    }

    private static boolean isSelfDefinedMessageLength(HttpResponse httpResponse) {
        if (!HttpUtil.isContentLengthSet(httpResponse) && !HttpUtil.isTransferEncodingChunked(httpResponse) && !isMultipart(httpResponse) && !isInformational(httpResponse) && httpResponse.status().code() != HttpResponseStatus.NO_CONTENT.code()) {
            return false;
        }
        return true;
    }

    private void trackResponse(HttpResponse httpResponse) {
        if (!isInformational(httpResponse)) {
            this.pendingResponses--;
        }
    }
}
