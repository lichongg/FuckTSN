package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class HttpContentEncoder extends MessageToMessageCodec<HttpRequest, HttpObject> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private EmbeddedChannel encoder;
    private static final CharSequence ZERO_LENGTH_HEAD = "HEAD";
    private static final CharSequence ZERO_LENGTH_CONNECT = "CONNECT";
    private static final int CONTINUE_CODE = HttpResponseStatus.CONTINUE.code();
    private final Queue<CharSequence> acceptEncodingQueue = new ArrayDeque();
    private State state = State.AWAIT_HEADERS;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Result {
        private final EmbeddedChannel contentEncoder;
        private final String targetContentEncoding;

        public EmbeddedChannel contentEncoder() {
            return this.contentEncoder;
        }

        public String targetContentEncoding() {
            return this.targetContentEncoding;
        }

        public Result(String str, EmbeddedChannel embeddedChannel) {
            if (str != null) {
                if (embeddedChannel != null) {
                    this.targetContentEncoding = str;
                    this.contentEncoder = embeddedChannel;
                    return;
                }
                throw new NullPointerException("contentEncoder");
            }
            throw new NullPointerException("targetContentEncoding");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum State {
        PASS_THROUGH,
        AWAIT_HEADERS,
        AWAIT_CONTENT
    }

    protected abstract Result beginEncode(HttpResponse httpResponse, String str) throws Exception;

    @Override // io.netty.handler.codec.MessageToMessageCodec
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, List list) throws Exception {
        decode2(channelHandlerContext, httpRequest, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    protected /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        encode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.HttpContentEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State = iArr;
            try {
                iArr[State.AWAIT_HEADERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[State.AWAIT_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[State.PASS_THROUGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void cleanup() {
        EmbeddedChannel embeddedChannel = this.encoder;
        if (embeddedChannel != null) {
            embeddedChannel.finishAndReleaseAll();
            this.encoder = null;
        }
    }

    private static void ensureContent(HttpObject httpObject) {
        if (httpObject instanceof HttpContent) {
            return;
        }
        throw new IllegalStateException("unexpected message type: " + httpObject.getClass().getName() + " (expected: " + HttpContent.class.getSimpleName() + ')');
    }

    private static void ensureHeaders(HttpObject httpObject) {
        if (httpObject instanceof HttpResponse) {
            return;
        }
        throw new IllegalStateException("unexpected message type: " + httpObject.getClass().getName() + " (expected: " + HttpResponse.class.getSimpleName() + ')');
    }

    private void fetchEncoderOutput(List<Object> list) {
        while (true) {
            ByteBuf byteBuf = (ByteBuf) this.encoder.readOutbound();
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

    private void finishEncode(List<Object> list) {
        if (this.encoder.finish()) {
            fetchEncoderOutput(list);
        }
        this.encoder = null;
    }

    private static boolean isPassthru(HttpVersion httpVersion, int i6, CharSequence charSequence) {
        if (i6 < 200 || i6 == 204 || i6 == 304 || charSequence == ZERO_LENGTH_HEAD) {
            return true;
        }
        return (charSequence == ZERO_LENGTH_CONNECT && i6 == 200) || httpVersion == HttpVersion.HTTP_1_0;
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof HttpContent) || (obj instanceof HttpResponse);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, List<Object> list) throws Exception {
        CharSequence charSequence = httpRequest.headers().get(HttpHeaderNames.ACCEPT_ENCODING);
        if (charSequence == null) {
            charSequence = HttpContentDecoder.IDENTITY;
        }
        HttpMethod method = httpRequest.method();
        if (HttpMethod.HEAD.equals(method)) {
            charSequence = ZERO_LENGTH_HEAD;
        } else if (HttpMethod.CONNECT.equals(method)) {
            charSequence = ZERO_LENGTH_CONNECT;
        }
        this.acceptEncodingQueue.add(charSequence);
        list.add(ReferenceCountUtil.retain(httpRequest));
    }

    /* renamed from: encode, reason: avoid collision after fix types in other method */
    protected void encode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        CharSequence poll;
        boolean z5 = (httpObject instanceof HttpResponse) && (httpObject instanceof LastHttpContent);
        int i6 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpContentEncoder$State[this.state.ordinal()];
        if (i6 == 1) {
            ensureHeaders(httpObject);
            HttpResponse httpResponse = (HttpResponse) httpObject;
            int code = httpResponse.status().code();
            if (code == CONTINUE_CODE) {
                poll = null;
            } else {
                poll = this.acceptEncodingQueue.poll();
                if (poll == null) {
                    throw new IllegalStateException("cannot send more responses than requests");
                }
            }
            if (isPassthru(httpResponse.protocolVersion(), code, poll)) {
                if (z5) {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    return;
                } else {
                    list.add(httpResponse);
                    this.state = State.PASS_THROUGH;
                    return;
                }
            }
            if (z5 && !((ByteBufHolder) httpResponse).content().isReadable()) {
                list.add(ReferenceCountUtil.retain(httpResponse));
                return;
            }
            Result beginEncode = beginEncode(httpResponse, poll.toString());
            if (beginEncode == null) {
                if (z5) {
                    list.add(ReferenceCountUtil.retain(httpResponse));
                    return;
                } else {
                    list.add(httpResponse);
                    this.state = State.PASS_THROUGH;
                    return;
                }
            }
            this.encoder = beginEncode.contentEncoder();
            httpResponse.headers().set(HttpHeaderNames.CONTENT_ENCODING, beginEncode.targetContentEncoding());
            if (z5) {
                DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status());
                defaultHttpResponse.headers().set(httpResponse.headers());
                list.add(defaultHttpResponse);
                ensureContent(httpResponse);
                encodeFullResponse(defaultHttpResponse, (HttpContent) httpResponse, list);
                return;
            }
            httpResponse.headers().remove(HttpHeaderNames.CONTENT_LENGTH);
            httpResponse.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            list.add(httpResponse);
            this.state = State.AWAIT_CONTENT;
            if (!(httpObject instanceof HttpContent)) {
                return;
            }
        } else if (i6 != 2) {
            if (i6 != 3) {
                return;
            }
            ensureContent(httpObject);
            list.add(ReferenceCountUtil.retain(httpObject));
            if (httpObject instanceof LastHttpContent) {
                this.state = State.AWAIT_HEADERS;
                return;
            }
            return;
        }
        ensureContent(httpObject);
        if (encodeContent((HttpContent) httpObject, list)) {
            this.state = State.AWAIT_HEADERS;
        }
    }

    private void cleanupSafely(ChannelHandlerContext channelHandlerContext) {
        try {
            cleanup();
        } catch (Throwable th) {
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    private boolean encodeContent(HttpContent httpContent, List<Object> list) {
        encode(httpContent.content(), list);
        if (httpContent instanceof LastHttpContent) {
            finishEncode(list);
            HttpHeaders trailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
            if (trailingHeaders.isEmpty()) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                return true;
            }
            list.add(new ComposedLastHttpContent(trailingHeaders, DecoderResult.SUCCESS));
            return true;
        }
        return false;
    }

    private void encodeFullResponse(HttpResponse httpResponse, HttpContent httpContent, List<Object> list) {
        encodeContent(httpContent, list);
        if (HttpUtil.isContentLengthSet(httpResponse)) {
            int i6 = 0;
            for (int size = list.size(); size < list.size(); size++) {
                Object obj = list.get(size);
                if (obj instanceof HttpContent) {
                    i6 += ((HttpContent) obj).content().readableBytes();
                }
            }
            HttpUtil.setContentLength(httpResponse, i6);
            return;
        }
        httpResponse.headers().set(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
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

    private void encode(ByteBuf byteBuf, List<Object> list) {
        this.encoder.writeOutbound(byteBuf.retain());
        fetchEncoderOutput(list);
    }
}
