package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http2.HttpConversionUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class InboundHttpToHttp2Adapter extends ChannelInboundHandlerAdapter {
    private final Http2Connection connection;
    private final Http2FrameListener listener;

    private static int getStreamId(Http2Connection http2Connection, HttpHeaders httpHeaders) {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), http2Connection.remote().incrementAndGetNextStreamId());
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof FullHttpMessage) {
            handle(channelHandlerContext, this.connection, this.listener, (FullHttpMessage) obj);
        } else {
            super.channelRead(channelHandlerContext, obj);
        }
    }

    public InboundHttpToHttp2Adapter(Http2Connection http2Connection, Http2FrameListener http2FrameListener) {
        this.connection = http2Connection;
        this.listener = http2FrameListener;
    }

    static void handle(ChannelHandlerContext channelHandlerContext, Http2Connection http2Connection, Http2FrameListener http2FrameListener, FullHttpMessage fullHttpMessage) throws Http2Exception {
        boolean z5;
        boolean z6;
        try {
            int streamId = getStreamId(http2Connection, fullHttpMessage.headers());
            Http2Stream stream = http2Connection.stream(streamId);
            if (stream == null) {
                stream = http2Connection.remote().createStream(streamId, false);
            }
            fullHttpMessage.headers().set(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), HttpScheme.HTTP.name());
            Http2Headers http2Headers = HttpConversionUtil.toHttp2Headers((HttpMessage) fullHttpMessage, true);
            boolean isReadable = fullHttpMessage.content().isReadable();
            boolean isEmpty = fullHttpMessage.trailingHeaders().isEmpty();
            if (!isReadable && isEmpty) {
                z5 = true;
            } else {
                z5 = false;
            }
            http2FrameListener.onHeadersRead(channelHandlerContext, streamId, http2Headers, 0, z5);
            if (isReadable) {
                z6 = isEmpty;
                http2FrameListener.onDataRead(channelHandlerContext, streamId, fullHttpMessage.content(), 0, z6);
            } else {
                z6 = isEmpty;
            }
            if (!z6) {
                http2FrameListener.onHeadersRead(channelHandlerContext, streamId, HttpConversionUtil.toHttp2Headers(fullHttpMessage.trailingHeaders(), true), 0, true);
            }
            stream.closeRemoteSide();
            fullHttpMessage.release();
        } catch (Throwable th) {
            fullHttpMessage.release();
            throw th;
        }
    }
}
