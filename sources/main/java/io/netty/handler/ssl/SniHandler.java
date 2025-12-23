package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.util.AsyncMapping;
import io.netty.util.DomainNameMapping;
import io.netty.util.Mapping;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SniHandler extends AbstractSniHandler<SslContext> {
    private static final Selection EMPTY_SELECTION = new Selection(null, null);
    protected final AsyncMapping<String, SslContext> mapping;
    private volatile Selection selection;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.ssl.SniHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class AsyncMappingAdapter implements AsyncMapping<String, SslContext> {
        private final Mapping<? super String, ? extends SslContext> mapping;

        /* synthetic */ AsyncMappingAdapter(Mapping mapping, AnonymousClass1 anonymousClass1) {
            this(mapping);
        }

        private AsyncMappingAdapter(Mapping<? super String, ? extends SslContext> mapping) {
            this.mapping = (Mapping) ObjectUtil.checkNotNull(mapping, "mapping");
        }

        @Override // io.netty.util.AsyncMapping
        public Future<SslContext> map(String str, Promise<SslContext> promise) {
            try {
                return promise.setSuccess(this.mapping.map(str));
            } catch (Throwable th) {
                return promise.setFailure(th);
            }
        }
    }

    public SniHandler(Mapping<? super String, ? extends SslContext> mapping) {
        this(new AsyncMappingAdapter(mapping, null));
    }

    protected void replaceHandler(ChannelHandlerContext channelHandlerContext, String str, SslContext sslContext) throws Exception {
        SslHandler sslHandler = null;
        try {
            sslHandler = newSslHandler(sslContext, channelHandlerContext.alloc());
            channelHandlerContext.pipeline().replace(this, SslHandler.class.getName(), sslHandler);
        } catch (Throwable th) {
            if (sslHandler != null) {
                ReferenceCountUtil.safeRelease(sslHandler.engine());
            }
            throw th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Selection {
        final SslContext context;
        final String hostname;

        Selection(SslContext sslContext, String str) {
            this.context = sslContext;
            this.hostname = str;
        }
    }

    public SniHandler(DomainNameMapping<? extends SslContext> domainNameMapping) {
        this((Mapping<? super String, ? extends SslContext>) domainNameMapping);
    }

    public String hostname() {
        return this.selection.hostname;
    }

    @Override // io.netty.handler.ssl.AbstractSniHandler
    protected Future<SslContext> lookup(ChannelHandlerContext channelHandlerContext, String str) throws Exception {
        return this.mapping.map(str, channelHandlerContext.executor().newPromise());
    }

    public SslContext sslContext() {
        return this.selection.context;
    }

    public SniHandler(AsyncMapping<? super String, ? extends SslContext> asyncMapping) {
        this.selection = EMPTY_SELECTION;
        this.mapping = (AsyncMapping) ObjectUtil.checkNotNull(asyncMapping, "mapping");
    }

    protected SslHandler newSslHandler(SslContext sslContext, ByteBufAllocator byteBufAllocator) {
        return sslContext.newHandler(byteBufAllocator);
    }

    @Override // io.netty.handler.ssl.AbstractSniHandler
    protected final void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<SslContext> future) throws Exception {
        if (!future.isSuccess()) {
            Throwable cause = future.cause();
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new DecoderException("failed to get the SslContext for " + str, cause);
        }
        SslContext now = future.getNow();
        this.selection = new Selection(now, str);
        try {
            replaceHandler(channelHandlerContext, str, now);
        } catch (Throwable th) {
            this.selection = EMPTY_SELECTION;
            PlatformDependent.throwException(th);
        }
    }
}
