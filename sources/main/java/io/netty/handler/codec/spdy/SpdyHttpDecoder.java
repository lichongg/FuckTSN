package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.spdy.SpdyHeaders;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SpdyHttpDecoder extends MessageToMessageDecoder<SpdyFrame> {
    private final int maxContentLength;
    private final Map<Integer, FullHttpMessage> messageMap;
    private final int spdyVersion;
    private final boolean validateHeaders;

    public SpdyHttpDecoder(SpdyVersion spdyVersion, int i6) {
        this(spdyVersion, i6, new HashMap(), true);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, SpdyFrame spdyFrame, List list) throws Exception {
        decode2(channelHandlerContext, spdyFrame, (List<Object>) list);
    }

    public SpdyHttpDecoder(SpdyVersion spdyVersion, int i6, boolean z5) {
        this(spdyVersion, i6, new HashMap(), z5);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        Iterator<Map.Entry<Integer, FullHttpMessage>> it = this.messageMap.entrySet().iterator();
        while (it.hasNext()) {
            ReferenceCountUtil.safeRelease(it.next().getValue());
        }
        this.messageMap.clear();
        super.channelInactive(channelHandlerContext);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, SpdyFrame spdyFrame, List<Object> list) throws Exception {
        if (spdyFrame instanceof SpdySynStreamFrame) {
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame) spdyFrame;
            int streamId = spdySynStreamFrame.streamId();
            if (SpdyCodecUtil.isServerId(streamId)) {
                int associatedStreamId = spdySynStreamFrame.associatedStreamId();
                if (associatedStreamId == 0) {
                    channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.INVALID_STREAM));
                    return;
                }
                if (spdySynStreamFrame.isLast()) {
                    channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.PROTOCOL_ERROR));
                    return;
                }
                if (spdySynStreamFrame.isTruncated()) {
                    channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.INTERNAL_ERROR));
                    return;
                }
                try {
                    FullHttpRequest createHttpRequest = createHttpRequest(spdySynStreamFrame, channelHandlerContext.alloc());
                    createHttpRequest.headers().setInt(SpdyHttpHeaders.Names.STREAM_ID, streamId);
                    createHttpRequest.headers().setInt(SpdyHttpHeaders.Names.ASSOCIATED_TO_STREAM_ID, associatedStreamId);
                    createHttpRequest.headers().setInt(SpdyHttpHeaders.Names.PRIORITY, spdySynStreamFrame.priority());
                    list.add(createHttpRequest);
                    return;
                } catch (Throwable unused) {
                    channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.PROTOCOL_ERROR));
                    return;
                }
            }
            if (spdySynStreamFrame.isTruncated()) {
                DefaultSpdySynReplyFrame defaultSpdySynReplyFrame = new DefaultSpdySynReplyFrame(streamId);
                defaultSpdySynReplyFrame.setLast(true);
                SpdyHeaders headers = defaultSpdySynReplyFrame.headers();
                headers.setInt(SpdyHeaders.HttpNames.STATUS, HttpResponseStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.code());
                headers.setObject((SpdyHeaders) SpdyHeaders.HttpNames.VERSION, (Object) HttpVersion.HTTP_1_0);
                channelHandlerContext.writeAndFlush(defaultSpdySynReplyFrame);
                return;
            }
            try {
                FullHttpRequest createHttpRequest2 = createHttpRequest(spdySynStreamFrame, channelHandlerContext.alloc());
                createHttpRequest2.headers().setInt(SpdyHttpHeaders.Names.STREAM_ID, streamId);
                if (spdySynStreamFrame.isLast()) {
                    list.add(createHttpRequest2);
                } else {
                    putMessage(streamId, createHttpRequest2);
                }
                return;
            } catch (Throwable unused2) {
                DefaultSpdySynReplyFrame defaultSpdySynReplyFrame2 = new DefaultSpdySynReplyFrame(streamId);
                defaultSpdySynReplyFrame2.setLast(true);
                SpdyHeaders headers2 = defaultSpdySynReplyFrame2.headers();
                headers2.setInt(SpdyHeaders.HttpNames.STATUS, HttpResponseStatus.BAD_REQUEST.code());
                headers2.setObject((SpdyHeaders) SpdyHeaders.HttpNames.VERSION, (Object) HttpVersion.HTTP_1_0);
                channelHandlerContext.writeAndFlush(defaultSpdySynReplyFrame2);
                return;
            }
        }
        if (spdyFrame instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame) spdyFrame;
            int streamId2 = spdySynReplyFrame.streamId();
            if (spdySynReplyFrame.isTruncated()) {
                channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId2, SpdyStreamStatus.INTERNAL_ERROR));
                return;
            }
            try {
                FullHttpResponse createHttpResponse = createHttpResponse(spdySynReplyFrame, channelHandlerContext.alloc(), this.validateHeaders);
                createHttpResponse.headers().setInt(SpdyHttpHeaders.Names.STREAM_ID, streamId2);
                if (spdySynReplyFrame.isLast()) {
                    HttpUtil.setContentLength(createHttpResponse, 0L);
                    list.add(createHttpResponse);
                } else {
                    putMessage(streamId2, createHttpResponse);
                }
                return;
            } catch (Throwable unused3) {
                channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId2, SpdyStreamStatus.PROTOCOL_ERROR));
                return;
            }
        }
        if (!(spdyFrame instanceof SpdyHeadersFrame)) {
            if (!(spdyFrame instanceof SpdyDataFrame)) {
                if (spdyFrame instanceof SpdyRstStreamFrame) {
                    removeMessage(((SpdyRstStreamFrame) spdyFrame).streamId());
                    return;
                }
                return;
            }
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame) spdyFrame;
            int streamId3 = spdyDataFrame.streamId();
            FullHttpMessage message = getMessage(streamId3);
            if (message == null) {
                return;
            }
            ByteBuf content = message.content();
            if (content.readableBytes() > this.maxContentLength - spdyDataFrame.content().readableBytes()) {
                removeMessage(streamId3);
                throw new TooLongFrameException("HTTP content length exceeded " + this.maxContentLength + " bytes.");
            }
            ByteBuf content2 = spdyDataFrame.content();
            content.writeBytes(content2, content2.readerIndex(), content2.readableBytes());
            if (spdyDataFrame.isLast()) {
                HttpUtil.setContentLength(message, content.readableBytes());
                removeMessage(streamId3);
                list.add(message);
                return;
            }
            return;
        }
        SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame) spdyFrame;
        int streamId4 = spdyHeadersFrame.streamId();
        FullHttpMessage message2 = getMessage(streamId4);
        if (message2 != null) {
            if (!spdyHeadersFrame.isTruncated()) {
                for (Map.Entry<CharSequence, CharSequence> entry : spdyHeadersFrame.headers()) {
                    message2.headers().add(entry.getKey(), entry.getValue());
                }
            }
            if (spdyHeadersFrame.isLast()) {
                HttpUtil.setContentLength(message2, message2.content().readableBytes());
                removeMessage(streamId4);
                list.add(message2);
                return;
            }
            return;
        }
        if (SpdyCodecUtil.isServerId(streamId4)) {
            if (spdyHeadersFrame.isTruncated()) {
                channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId4, SpdyStreamStatus.INTERNAL_ERROR));
                return;
            }
            try {
                FullHttpResponse createHttpResponse2 = createHttpResponse(spdyHeadersFrame, channelHandlerContext.alloc(), this.validateHeaders);
                createHttpResponse2.headers().setInt(SpdyHttpHeaders.Names.STREAM_ID, streamId4);
                if (!spdyHeadersFrame.isLast()) {
                    putMessage(streamId4, createHttpResponse2);
                } else {
                    HttpUtil.setContentLength(createHttpResponse2, 0L);
                    list.add(createHttpResponse2);
                }
            } catch (Throwable unused4) {
                channelHandlerContext.writeAndFlush(new DefaultSpdyRstStreamFrame(streamId4, SpdyStreamStatus.PROTOCOL_ERROR));
            }
        }
    }

    protected FullHttpMessage getMessage(int i6) {
        return this.messageMap.get(Integer.valueOf(i6));
    }

    protected FullHttpMessage putMessage(int i6, FullHttpMessage fullHttpMessage) {
        return this.messageMap.put(Integer.valueOf(i6), fullHttpMessage);
    }

    protected FullHttpMessage removeMessage(int i6) {
        return this.messageMap.remove(Integer.valueOf(i6));
    }

    protected SpdyHttpDecoder(SpdyVersion spdyVersion, int i6, Map<Integer, FullHttpMessage> map) {
        this(spdyVersion, i6, map, true);
    }

    private static FullHttpRequest createHttpRequest(SpdyHeadersFrame spdyHeadersFrame, ByteBufAllocator byteBufAllocator) throws Exception {
        SpdyHeaders headers = spdyHeadersFrame.headers();
        AsciiString asciiString = SpdyHeaders.HttpNames.METHOD;
        HttpMethod valueOf = HttpMethod.valueOf(headers.getAsString(asciiString));
        AsciiString asciiString2 = SpdyHeaders.HttpNames.PATH;
        String asString = headers.getAsString(asciiString2);
        AsciiString asciiString3 = SpdyHeaders.HttpNames.VERSION;
        HttpVersion valueOf2 = HttpVersion.valueOf(headers.getAsString(asciiString3));
        headers.remove(asciiString);
        headers.remove(asciiString2);
        headers.remove(asciiString3);
        ByteBuf buffer = byteBufAllocator.buffer();
        try {
            DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(valueOf2, valueOf, asString, buffer);
            headers.remove(SpdyHeaders.HttpNames.SCHEME);
            AsciiString asciiString4 = SpdyHeaders.HttpNames.HOST;
            CharSequence charSequence = headers.get(asciiString4);
            headers.remove(asciiString4);
            defaultFullHttpRequest.headers().set(HttpHeaderNames.HOST, charSequence);
            for (Map.Entry<CharSequence, CharSequence> entry : spdyHeadersFrame.headers()) {
                defaultFullHttpRequest.headers().add(entry.getKey(), entry.getValue());
            }
            HttpUtil.setKeepAlive(defaultFullHttpRequest, true);
            defaultFullHttpRequest.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            return defaultFullHttpRequest;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    private static FullHttpResponse createHttpResponse(SpdyHeadersFrame spdyHeadersFrame, ByteBufAllocator byteBufAllocator, boolean z5) throws Exception {
        SpdyHeaders headers = spdyHeadersFrame.headers();
        AsciiString asciiString = SpdyHeaders.HttpNames.STATUS;
        HttpResponseStatus parseLine = HttpResponseStatus.parseLine(headers.get(asciiString));
        AsciiString asciiString2 = SpdyHeaders.HttpNames.VERSION;
        HttpVersion valueOf = HttpVersion.valueOf(headers.getAsString(asciiString2));
        headers.remove(asciiString);
        headers.remove(asciiString2);
        ByteBuf buffer = byteBufAllocator.buffer();
        try {
            DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(valueOf, parseLine, buffer, z5);
            for (Map.Entry<CharSequence, CharSequence> entry : spdyHeadersFrame.headers()) {
                defaultFullHttpResponse.headers().add(entry.getKey(), entry.getValue());
            }
            HttpUtil.setKeepAlive(defaultFullHttpResponse, true);
            defaultFullHttpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            defaultFullHttpResponse.headers().remove(HttpHeaderNames.TRAILER);
            return defaultFullHttpResponse;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    protected SpdyHttpDecoder(SpdyVersion spdyVersion, int i6, Map<Integer, FullHttpMessage> map, boolean z5) {
        if (spdyVersion != null) {
            ObjectUtil.checkPositive(i6, "maxContentLength");
            this.spdyVersion = spdyVersion.getVersion();
            this.maxContentLength = i6;
            this.messageMap = map;
            this.validateHeaders = z5;
            return;
        }
        throw new NullPointerException("version");
    }
}
