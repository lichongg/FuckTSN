package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HttpClientCodec extends CombinedChannelDuplexHandler<HttpResponseDecoder, HttpRequestEncoder> implements HttpClientUpgradeHandler.SourceCodec {
    private boolean done;
    private final boolean failOnMissingResponse;
    private final boolean parseHttpAfterConnectRequest;
    private final Queue<HttpMethod> queue;
    private final AtomicLong requestResponseCounter;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.HttpClientCodec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Decoder extends HttpResponseDecoder {
        Decoder(int i6, int i7, int i8, boolean z5) {
            super(i6, i7, i8, z5);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder
        protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
            int code = ((HttpResponse) httpMessage).status().code();
            if (code == 100 || code == 101) {
                return super.isContentAlwaysEmpty(httpMessage);
            }
            HttpMethod httpMethod = (HttpMethod) HttpClientCodec.this.queue.poll();
            char charAt = httpMethod.name().charAt(0);
            if (charAt != 'C') {
                if (charAt == 'H' && HttpMethod.HEAD.equals(httpMethod)) {
                    return true;
                }
            } else if (code == 200 && HttpMethod.CONNECT.equals(httpMethod)) {
                if (!HttpClientCodec.this.parseHttpAfterConnectRequest) {
                    HttpClientCodec.this.done = true;
                    HttpClientCodec.this.queue.clear();
                }
                return true;
            }
            return super.isContentAlwaysEmpty(httpMessage);
        }

        private void decrement(Object obj) {
            if (obj != null && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.decrementAndGet();
            }
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder, io.netty.handler.codec.ByteToMessageDecoder
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            if (HttpClientCodec.this.done) {
                int actualReadableBytes = actualReadableBytes();
                if (actualReadableBytes == 0) {
                    return;
                }
                list.add(byteBuf.readBytes(actualReadableBytes));
                return;
            }
            super.decode(channelHandlerContext, byteBuf, list);
            if (HttpClientCodec.this.failOnMissingResponse) {
                int size = list.size();
                for (int size2 = list.size(); size2 < size; size2++) {
                    decrement(list.get(size2));
                }
            }
        }

        Decoder(int i6, int i7, int i8, boolean z5, int i9) {
            super(i6, i7, i8, z5, i9);
        }

        @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelInactive(channelHandlerContext);
            if (HttpClientCodec.this.failOnMissingResponse) {
                long j6 = HttpClientCodec.this.requestResponseCounter.get();
                if (j6 > 0) {
                    channelHandlerContext.fireExceptionCaught((Throwable) new PrematureChannelClosureException("channel gone inactive with " + j6 + " missing response(s)"));
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class Encoder extends HttpRequestEncoder {
        boolean upgraded;

        private Encoder() {
        }

        /* synthetic */ Encoder(HttpClientCodec httpClientCodec, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.handler.codec.http.HttpObjectEncoder, io.netty.handler.codec.MessageToMessageEncoder
        protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
            if (this.upgraded) {
                list.add(ReferenceCountUtil.retain(obj));
                return;
            }
            if ((obj instanceof HttpRequest) && !HttpClientCodec.this.done) {
                HttpClientCodec.this.queue.offer(((HttpRequest) obj).method());
            }
            super.encode(channelHandlerContext, obj, list);
            if (HttpClientCodec.this.failOnMissingResponse && !HttpClientCodec.this.done && (obj instanceof LastHttpContent)) {
                HttpClientCodec.this.requestResponseCounter.incrementAndGet();
            }
        }
    }

    public HttpClientCodec() {
        this(4096, 8192, 8192, false);
    }

    public HttpClientCodec(int i6, int i7, int i8) {
        this(i6, i7, i8, false);
    }

    public HttpClientCodec(int i6, int i7, int i8, boolean z5) {
        this(i6, i7, i8, z5, true);
    }

    public boolean isSingleDecode() {
        return inboundHandler().isSingleDecode();
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.SourceCodec
    public void prepareUpgradeFrom(ChannelHandlerContext channelHandlerContext) {
        ((Encoder) outboundHandler()).upgraded = true;
    }

    public void setSingleDecode(boolean z5) {
        inboundHandler().setSingleDecode(z5);
    }

    @Override // io.netty.handler.codec.http.HttpClientUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    public HttpClientCodec(int i6, int i7, int i8, boolean z5, boolean z6) {
        this(i6, i7, i8, z5, z6, false);
    }

    public HttpClientCodec(int i6, int i7, int i8, boolean z5, boolean z6, boolean z7) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i6, i7, i8, z6), new Encoder(this, null));
        this.failOnMissingResponse = z5;
        this.parseHttpAfterConnectRequest = z7;
    }

    public HttpClientCodec(int i6, int i7, int i8, boolean z5, boolean z6, int i9) {
        this(i6, i7, i8, z5, z6, i9, false);
    }

    public HttpClientCodec(int i6, int i7, int i8, boolean z5, boolean z6, int i9, boolean z7) {
        this.queue = new ArrayDeque();
        this.requestResponseCounter = new AtomicLong();
        init(new Decoder(i6, i7, i8, z6, i9), new Encoder(this, null));
        this.parseHttpAfterConnectRequest = z7;
        this.failOnMissingResponse = z5;
    }
}
