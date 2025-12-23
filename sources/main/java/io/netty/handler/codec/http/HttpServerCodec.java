package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HttpServerCodec extends CombinedChannelDuplexHandler<HttpRequestDecoder, HttpResponseEncoder> implements HttpServerUpgradeHandler.SourceCodec {
    private final Queue<HttpMethod> queue;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.HttpServerCodec$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class HttpServerResponseEncoder extends HttpResponseEncoder {
        private HttpMethod method;

        private HttpServerResponseEncoder() {
        }

        /* synthetic */ HttpServerResponseEncoder(HttpServerCodec httpServerCodec, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http.HttpResponseEncoder, io.netty.handler.codec.http.HttpObjectEncoder
        public boolean isContentAlwaysEmpty(HttpResponse httpResponse) {
            HttpMethod httpMethod = (HttpMethod) HttpServerCodec.this.queue.poll();
            this.method = httpMethod;
            return HttpMethod.HEAD.equals(httpMethod) || super.isContentAlwaysEmpty(httpResponse);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.handler.codec.http.HttpResponseEncoder, io.netty.handler.codec.http.HttpObjectEncoder
        public void sanitizeHeadersBeforeEncode(HttpResponse httpResponse, boolean z5) {
            if (!z5 && HttpMethod.CONNECT.equals(this.method) && httpResponse.status().codeClass() == HttpStatusClass.SUCCESS) {
                httpResponse.headers().remove(HttpHeaderNames.TRANSFER_ENCODING);
            } else {
                super.sanitizeHeadersBeforeEncode(httpResponse, z5);
            }
        }
    }

    public HttpServerCodec() {
        this(4096, 8192, 8192);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class HttpServerRequestDecoder extends HttpRequestDecoder {
        HttpServerRequestDecoder(int i6, int i7, int i8) {
            super(i6, i7, i8);
        }

        HttpServerRequestDecoder(int i6, int i7, int i8, boolean z5) {
            super(i6, i7, i8, z5);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder, io.netty.handler.codec.ByteToMessageDecoder
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            super.decode(channelHandlerContext, byteBuf, list);
            int size = list.size();
            for (int size2 = list.size(); size2 < size; size2++) {
                Object obj = list.get(size2);
                if (obj instanceof HttpRequest) {
                    HttpServerCodec.this.queue.add(((HttpRequest) obj).method());
                }
            }
        }

        HttpServerRequestDecoder(int i6, int i7, int i8, boolean z5, int i9) {
            super(i6, i7, i8, z5, i9);
        }
    }

    public HttpServerCodec(int i6, int i7, int i8) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i6, i7, i8), new HttpServerResponseEncoder(this, null));
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    public HttpServerCodec(int i6, int i7, int i8, boolean z5) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i6, i7, i8, z5), new HttpServerResponseEncoder(this, null));
    }

    public HttpServerCodec(int i6, int i7, int i8, boolean z5, int i9) {
        this.queue = new ArrayDeque();
        init(new HttpServerRequestDecoder(i6, i7, i8, z5, i9), new HttpServerResponseEncoder(this, null));
    }
}
