package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class InboundHttp2ToHttpAdapter extends Http2EventAdapter {
    private static final ImmediateSendDetector DEFAULT_SEND_DETECTOR = new ImmediateSendDetector() { // from class: io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter.1
        @Override // io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter.ImmediateSendDetector
        public FullHttpMessage copyIfNeeded(FullHttpMessage fullHttpMessage) {
            if (!(fullHttpMessage instanceof FullHttpRequest)) {
                return null;
            }
            FullHttpRequest replace = ((FullHttpRequest) fullHttpMessage).replace(Unpooled.buffer(0));
            replace.headers().remove(HttpHeaderNames.EXPECT);
            return replace;
        }

        @Override // io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter.ImmediateSendDetector
        public boolean mustSendImmediately(FullHttpMessage fullHttpMessage) {
            if (fullHttpMessage instanceof FullHttpResponse) {
                return ((FullHttpResponse) fullHttpMessage).status().codeClass() == HttpStatusClass.INFORMATIONAL;
            }
            if (fullHttpMessage instanceof FullHttpRequest) {
                return fullHttpMessage.headers().contains(HttpHeaderNames.EXPECT);
            }
            return false;
        }
    };
    protected final Http2Connection connection;
    private final int maxContentLength;
    private final Http2Connection.PropertyKey messageKey;
    private final boolean propagateSettings;
    private final ImmediateSendDetector sendDetector;
    protected final boolean validateHttpHeaders;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface ImmediateSendDetector {
        FullHttpMessage copyIfNeeded(FullHttpMessage fullHttpMessage);

        boolean mustSendImmediately(FullHttpMessage fullHttpMessage);
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, boolean z5) throws Http2Exception {
        Http2Stream stream = this.connection.stream(i6);
        FullHttpMessage processHeadersBegin = processHeadersBegin(channelHandlerContext, stream, http2Headers, z5, true, true);
        if (processHeadersBegin != null) {
            processHeadersEnd(channelHandlerContext, stream, processHeadersBegin, z5);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i6, long j6) throws Http2Exception {
        Http2Stream stream = this.connection.stream(i6);
        FullHttpMessage message = getMessage(stream);
        if (message != null) {
            onRstStreamRead(stream, message);
        }
        channelHandlerContext.fireExceptionCaught((Throwable) Http2Exception.streamError(i6, Http2Error.valueOf(j6), "HTTP/2 to HTTP layer caught stream reset", new Object[0]));
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamRemoved(Http2Stream http2Stream) {
        removeMessage(http2Stream, true);
    }

    private void processHeadersEnd(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, FullHttpMessage fullHttpMessage, boolean z5) {
        if (z5) {
            fireChannelRead(channelHandlerContext, fullHttpMessage, getMessage(http2Stream) != fullHttpMessage, http2Stream);
        } else {
            putMessage(http2Stream, fullHttpMessage);
        }
    }

    protected final FullHttpMessage getMessage(Http2Stream http2Stream) {
        return (FullHttpMessage) http2Stream.getProperty(this.messageKey);
    }

    protected FullHttpMessage newMessage(Http2Stream http2Stream, Http2Headers http2Headers, boolean z5, ByteBufAllocator byteBufAllocator) throws Http2Exception {
        return this.connection.isServer() ? HttpConversionUtil.toFullHttpRequest(http2Stream.id(), http2Headers, byteBufAllocator, z5) : HttpConversionUtil.toFullHttpResponse(http2Stream.id(), http2Headers, byteBufAllocator, z5);
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i6, ByteBuf byteBuf, int i7, boolean z5) throws Http2Exception {
        Http2Stream stream = this.connection.stream(i6);
        FullHttpMessage message = getMessage(stream);
        if (message == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Data Frame received for unknown stream id %d", Integer.valueOf(i6));
        }
        ByteBuf content = message.content();
        int readableBytes = byteBuf.readableBytes();
        int readableBytes2 = content.readableBytes();
        int i8 = this.maxContentLength;
        if (readableBytes2 > i8 - readableBytes) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Content length exceeded max of %d for stream id %d", Integer.valueOf(i8), Integer.valueOf(i6));
        }
        content.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        if (z5) {
            fireChannelRead(channelHandlerContext, message, false, stream);
        }
        return readableBytes + i7;
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i6, int i7, Http2Headers http2Headers, int i8) throws Http2Exception {
        Http2Stream stream = this.connection.stream(i7);
        if (http2Headers.status() == null) {
            http2Headers.status(HttpResponseStatus.OK.codeAsText());
        }
        FullHttpMessage processHeadersBegin = processHeadersBegin(channelHandlerContext, stream, http2Headers, false, false, false);
        if (processHeadersBegin == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Push Promise Frame received for pre-existing stream id %d", Integer.valueOf(i7));
        }
        processHeadersBegin.headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_PROMISE_ID.text(), i6);
        processHeadersBegin.headers().setShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short) 16);
        processHeadersEnd(channelHandlerContext, stream, processHeadersBegin, false);
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
        if (this.propagateSettings) {
            channelHandlerContext.fireChannelRead((Object) http2Settings);
        }
    }

    protected final void putMessage(Http2Stream http2Stream, FullHttpMessage fullHttpMessage) {
        FullHttpMessage fullHttpMessage2 = (FullHttpMessage) http2Stream.setProperty(this.messageKey, fullHttpMessage);
        if (fullHttpMessage2 == fullHttpMessage || fullHttpMessage2 == null) {
            return;
        }
        fullHttpMessage2.release();
    }

    protected final void removeMessage(Http2Stream http2Stream, boolean z5) {
        FullHttpMessage fullHttpMessage = (FullHttpMessage) http2Stream.removeProperty(this.messageKey);
        if (!z5 || fullHttpMessage == null) {
            return;
        }
        fullHttpMessage.release();
    }

    protected InboundHttp2ToHttpAdapter(Http2Connection http2Connection, int i6, boolean z5, boolean z6) {
        ObjectUtil.checkNotNull(http2Connection, "connection");
        if (i6 > 0) {
            this.connection = http2Connection;
            this.maxContentLength = i6;
            this.validateHttpHeaders = z5;
            this.propagateSettings = z6;
            this.sendDetector = DEFAULT_SEND_DETECTOR;
            this.messageKey = http2Connection.newKey();
            return;
        }
        throw new IllegalArgumentException("maxContentLength: " + i6 + " (expected: > 0)");
    }

    protected void fireChannelRead(ChannelHandlerContext channelHandlerContext, FullHttpMessage fullHttpMessage, boolean z5, Http2Stream http2Stream) {
        removeMessage(http2Stream, z5);
        HttpUtil.setContentLength(fullHttpMessage, fullHttpMessage.content().readableBytes());
        channelHandlerContext.fireChannelRead((Object) fullHttpMessage);
    }

    protected FullHttpMessage processHeadersBegin(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, Http2Headers http2Headers, boolean z5, boolean z6, boolean z7) throws Http2Exception {
        boolean z8;
        FullHttpMessage message = getMessage(http2Stream);
        FullHttpMessage fullHttpMessage = null;
        if (message == null) {
            message = newMessage(http2Stream, http2Headers, this.validateHttpHeaders, channelHandlerContext.alloc());
            z8 = true;
        } else {
            if (z6) {
                HttpConversionUtil.addHttp2ToHttpHeaders(http2Stream.id(), http2Headers, message, z7);
            } else {
                message = null;
            }
            z8 = false;
        }
        if (this.sendDetector.mustSendImmediately(message)) {
            if (!z5) {
                fullHttpMessage = this.sendDetector.copyIfNeeded(message);
            }
            fireChannelRead(channelHandlerContext, message, z8, http2Stream);
            return fullHttpMessage;
        }
        return message;
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i6, Http2Headers http2Headers, int i7, short s5, boolean z5, int i8, boolean z6) throws Http2Exception {
        Http2Stream stream = this.connection.stream(i6);
        FullHttpMessage processHeadersBegin = processHeadersBegin(channelHandlerContext, stream, http2Headers, z6, true, true);
        if (processHeadersBegin != null) {
            if (i7 != 0) {
                processHeadersBegin.headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), i7);
            }
            processHeadersBegin.headers().setShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), s5);
            processHeadersEnd(channelHandlerContext, stream, processHeadersBegin, z6);
        }
    }

    protected void onRstStreamRead(Http2Stream http2Stream, FullHttpMessage fullHttpMessage) {
        removeMessage(http2Stream, true);
    }
}
