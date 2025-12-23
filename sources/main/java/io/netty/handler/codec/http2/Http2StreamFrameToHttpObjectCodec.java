package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http2.HttpConversionUtil;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ChannelHandler.Sharable
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2StreamFrameToHttpObjectCodec extends MessageToMessageCodec<Http2StreamFrame, HttpObject> {
    private static final AttributeKey<HttpScheme> SCHEME_ATTR_KEY = AttributeKey.valueOf(HttpScheme.class, "STREAMFRAMECODEC_SCHEME");
    private final boolean isServer;
    private final boolean validateHeaders;

    public Http2StreamFrameToHttpObjectCodec(boolean z5, boolean z6) {
        this.isServer = z5;
        this.validateHeaders = z6;
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, Http2StreamFrame http2StreamFrame, List list) throws Exception {
        decode2(channelHandlerContext, http2StreamFrame, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        encode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    private void encodeLastContent(LastHttpContent lastHttpContent, List<Object> list) {
        boolean z5 = !(lastHttpContent instanceof FullHttpMessage) && lastHttpContent.trailingHeaders().isEmpty();
        if (lastHttpContent.content().isReadable() || z5) {
            list.add(new DefaultHttp2DataFrame(lastHttpContent.content().retain(), lastHttpContent.trailingHeaders().isEmpty()));
        }
        if (lastHttpContent.trailingHeaders().isEmpty()) {
            return;
        }
        list.add(new DefaultHttp2HeadersFrame(HttpConversionUtil.toHttp2Headers(lastHttpContent.trailingHeaders(), this.validateHeaders), true));
    }

    private FullHttpMessage newFullMessage(int i6, Http2Headers http2Headers, ByteBufAllocator byteBufAllocator) throws Http2Exception {
        return this.isServer ? HttpConversionUtil.toFullHttpRequest(i6, http2Headers, byteBufAllocator, this.validateHeaders) : HttpConversionUtil.toFullHttpResponse(i6, http2Headers, byteBufAllocator, this.validateHeaders);
    }

    private HttpMessage newMessage(int i6, Http2Headers http2Headers) throws Http2Exception {
        return this.isServer ? HttpConversionUtil.toHttpRequest(i6, http2Headers, this.validateHeaders) : HttpConversionUtil.toHttpResponse(i6, http2Headers, this.validateHeaders);
    }

    private Http2Headers toHttp2Headers(ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage) {
        if (httpMessage instanceof HttpRequest) {
            httpMessage.headers().set(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), connectionScheme(channelHandlerContext));
        }
        return HttpConversionUtil.toHttp2Headers(httpMessage, this.validateHeaders);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public boolean acceptInboundMessage(Object obj) throws Exception {
        return (obj instanceof Http2HeadersFrame) || (obj instanceof Http2DataFrame);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, Http2StreamFrame http2StreamFrame, List<Object> list) throws Exception {
        if (!(http2StreamFrame instanceof Http2HeadersFrame)) {
            if (http2StreamFrame instanceof Http2DataFrame) {
                Http2DataFrame http2DataFrame = (Http2DataFrame) http2StreamFrame;
                if (http2DataFrame.isEndStream()) {
                    list.add(new DefaultLastHttpContent(http2DataFrame.content().retain(), this.validateHeaders));
                    return;
                } else {
                    list.add(new DefaultHttpContent(http2DataFrame.content().retain()));
                    return;
                }
            }
            return;
        }
        Http2HeadersFrame http2HeadersFrame = (Http2HeadersFrame) http2StreamFrame;
        Http2Headers headers = http2HeadersFrame.headers();
        Http2FrameStream stream = http2HeadersFrame.stream();
        int id = stream == null ? 0 : stream.id();
        CharSequence status = headers.status();
        if (status != null && HttpResponseStatus.CONTINUE.codeAsText().contentEquals(status)) {
            list.add(newFullMessage(id, headers, channelHandlerContext.alloc()));
            return;
        }
        if (!http2HeadersFrame.isEndStream()) {
            HttpMessage newMessage = newMessage(id, headers);
            if (!HttpUtil.isContentLengthSet(newMessage)) {
                newMessage.headers().add(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            }
            list.add(newMessage);
            return;
        }
        if (headers.method() != null || status != null) {
            list.add(newFullMessage(id, headers, channelHandlerContext.alloc()));
            return;
        }
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
        HttpConversionUtil.addHttp2ToHttpHeaders(id, headers, defaultLastHttpContent.trailingHeaders(), HttpVersion.HTTP_1_1, true, true);
        list.add(defaultLastHttpContent);
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        boolean z5;
        if (httpObject instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) httpObject;
            HttpResponseStatus status = httpResponse.status();
            HttpResponseStatus httpResponseStatus = HttpResponseStatus.CONTINUE;
            if (status.equals(httpResponseStatus)) {
                if (httpResponse instanceof FullHttpResponse) {
                    list.add(new DefaultHttp2HeadersFrame(toHttp2Headers(channelHandlerContext, httpResponse), false));
                    return;
                }
                throw new EncoderException(httpResponseStatus.toString() + " must be a FullHttpResponse");
            }
        }
        if (httpObject instanceof HttpMessage) {
            Http2Headers http2Headers = toHttp2Headers(channelHandlerContext, (HttpMessage) httpObject);
            if (httpObject instanceof FullHttpMessage) {
                FullHttpMessage fullHttpMessage = (FullHttpMessage) httpObject;
                if (!fullHttpMessage.content().isReadable() && fullHttpMessage.trailingHeaders().isEmpty()) {
                    z5 = true;
                    list.add(new DefaultHttp2HeadersFrame(http2Headers, z5));
                }
            }
            z5 = false;
            list.add(new DefaultHttp2HeadersFrame(http2Headers, z5));
        }
        if (httpObject instanceof LastHttpContent) {
            encodeLastContent((LastHttpContent) httpObject, list);
        } else if (httpObject instanceof HttpContent) {
            list.add(new DefaultHttp2DataFrame(((HttpContent) httpObject).content().retain(), false));
        }
    }

    private static Channel connectionChannel(ChannelHandlerContext channelHandlerContext) {
        Channel channel = channelHandlerContext.channel();
        if (channel instanceof Http2StreamChannel) {
            return channel.parent();
        }
        return channel;
    }

    private static HttpScheme connectionScheme(ChannelHandlerContext channelHandlerContext) {
        HttpScheme httpScheme = connectionSchemeAttribute(channelHandlerContext).get();
        if (httpScheme == null) {
            return HttpScheme.HTTP;
        }
        return httpScheme;
    }

    private static Attribute<HttpScheme> connectionSchemeAttribute(ChannelHandlerContext channelHandlerContext) {
        return connectionChannel(channelHandlerContext).attr(SCHEME_ATTR_KEY);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        HttpScheme httpScheme;
        super.handlerAdded(channelHandlerContext);
        Attribute<HttpScheme> connectionSchemeAttribute = connectionSchemeAttribute(channelHandlerContext);
        if (connectionSchemeAttribute.get() == null) {
            if (isSsl(channelHandlerContext)) {
                httpScheme = HttpScheme.HTTPS;
            } else {
                httpScheme = HttpScheme.HTTP;
            }
            connectionSchemeAttribute.set(httpScheme);
        }
    }

    protected boolean isSsl(ChannelHandlerContext channelHandlerContext) {
        if (connectionChannel(channelHandlerContext).pipeline().get(SslHandler.class) != null) {
            return true;
        }
        return false;
    }

    public Http2StreamFrameToHttpObjectCodec(boolean z5) {
        this(z5, true);
    }
}
