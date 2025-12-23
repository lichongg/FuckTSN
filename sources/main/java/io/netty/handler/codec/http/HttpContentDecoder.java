package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class HttpContentDecoder extends MessageToMessageDecoder<HttpObject> {
    static final String IDENTITY = HttpHeaderValues.IDENTITY.toString();
    private boolean continueResponse;
    protected ChannelHandlerContext ctx;
    private EmbeddedChannel decoder;
    private boolean needRead = true;

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        decode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    protected abstract EmbeddedChannel newContentDecoder(String str) throws Exception;

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.decoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.decoder = null;
        }
    }

    private void fetchDecoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.decoder.readInbound();
            if (byteBuf == null) {
                return;
            }
            if (byteBuf.isReadable()) {
                list.add(new DefaultHttpContent(byteBuf));
            } else {
                byteBuf.release();
            }
        }
    }

    private void finishDecode(List<Object> list) {
        if (this.decoder.finish()) {
            fetchDecoderOutput(list);
        }
        this.decoder = null;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        boolean z5 = this.needRead;
        this.needRead = true;
        try {
            channelHandlerContext.fireChannelReadComplete();
        } finally {
            if (z5 && !channelHandlerContext.channel().config().isAutoRead()) {
                channelHandlerContext.read();
            }
        }
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        HttpMessage defaultHttpResponse;
        try {
            if ((httpObject instanceof HttpResponse) && ((HttpResponse) httpObject).status().code() == 100) {
                if (!(httpObject instanceof LastHttpContent)) {
                    this.continueResponse = true;
                }
                list.add(ReferenceCountUtil.retain(httpObject));
            } else if (this.continueResponse) {
                if (httpObject instanceof LastHttpContent) {
                    this.continueResponse = false;
                }
                list.add(ReferenceCountUtil.retain(httpObject));
            } else {
                if (httpObject instanceof HttpMessage) {
                    cleanup();
                    HttpMessage httpMessage = (HttpMessage) httpObject;
                    HttpHeaders headers = httpMessage.headers();
                    AsciiString asciiString = HttpHeaderNames.CONTENT_ENCODING;
                    String str = headers.get(asciiString);
                    String trim = str != null ? str.trim() : IDENTITY;
                    EmbeddedChannel newContentDecoder = newContentDecoder(trim);
                    this.decoder = newContentDecoder;
                    if (newContentDecoder == null) {
                        if (httpMessage instanceof HttpContent) {
                            ((HttpContent) httpMessage).retain();
                        }
                        list.add(httpMessage);
                    } else {
                        AsciiString asciiString2 = HttpHeaderNames.CONTENT_LENGTH;
                        if (headers.contains(asciiString2)) {
                            headers.remove(asciiString2);
                            headers.set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
                        }
                        String targetContentEncoding = getTargetContentEncoding(trim);
                        if (HttpHeaderValues.IDENTITY.contentEquals(targetContentEncoding)) {
                            headers.remove(asciiString);
                        } else {
                            headers.set(asciiString, targetContentEncoding);
                        }
                        if (httpMessage instanceof HttpContent) {
                            if (httpMessage instanceof HttpRequest) {
                                HttpRequest httpRequest = (HttpRequest) httpMessage;
                                defaultHttpResponse = new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri());
                            } else {
                                if (!(httpMessage instanceof HttpResponse)) {
                                    throw new CodecException("Object of class " + httpMessage.getClass().getName() + " is not a HttpRequest or HttpResponse");
                                }
                                HttpResponse httpResponse = (HttpResponse) httpMessage;
                                defaultHttpResponse = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status());
                            }
                            defaultHttpResponse.headers().set(httpMessage.headers());
                            defaultHttpResponse.setDecoderResult(httpMessage.decoderResult());
                            list.add(defaultHttpResponse);
                        } else {
                            list.add(httpMessage);
                        }
                    }
                }
                if (httpObject instanceof HttpContent) {
                    HttpContent httpContent = (HttpContent) httpObject;
                    if (this.decoder == null) {
                        list.add(httpContent.retain());
                    } else {
                        decodeContent(httpContent, list);
                    }
                }
            }
            this.needRead = list.isEmpty();
        } catch (Throwable th) {
            this.needRead = list.isEmpty();
            throw th;
        }
    }

    protected String getTargetContentEncoding(String str) throws Exception {
        return IDENTITY;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
    }

    private void cleanupSafely(ChannelHandlerContext channelHandlerContext) {
        try {
            cleanup();
        } catch (Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    private void decodeContent(HttpContent httpContent, List<Object> list) {
        decode(httpContent.content(), list);
        if (httpContent instanceof LastHttpContent) {
            finishDecode(list);
            HttpHeaders trailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
            if (trailingHeaders.isEmpty()) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            } else {
                list.add(new ComposedLastHttpContent(trailingHeaders, DecoderResult.SUCCESS));
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        cleanupSafely(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    private void decode(ByteBuf byteBuf, List<Object> list) {
        this.decoder.writeInbound(byteBuf.retain());
        fetchDecoderOutput(list);
    }
}
