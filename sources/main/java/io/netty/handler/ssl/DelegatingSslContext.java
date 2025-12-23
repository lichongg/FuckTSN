package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSessionContext;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class DelegatingSslContext extends SslContext {
    private final SslContext ctx;

    protected abstract void initEngine(SSLEngine sSLEngine);

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        SSLEngine newEngine = this.ctx.newEngine(byteBufAllocator);
        initEngine(newEngine);
        return newEngine;
    }

    @Override // io.netty.handler.ssl.SslContext
    protected final SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z5) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, z5);
        initHandler(newHandler);
        return newHandler;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.ctx.applicationProtocolNegotiator();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.ctx.cipherSuites();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.ctx.isClient();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionCacheSize() {
        return this.ctx.sessionCacheSize();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLSessionContext sessionContext() {
        return this.ctx.sessionContext();
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionTimeout() {
        return this.ctx.sessionTimeout();
    }

    protected DelegatingSslContext(SslContext sslContext) {
        this.ctx = (SslContext) ObjectUtil.checkNotNull(sslContext, "ctx");
    }

    protected void initHandler(SslHandler sslHandler) {
        initEngine(sslHandler.engine());
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i6) {
        SSLEngine newEngine = this.ctx.newEngine(byteBufAllocator, str, i6);
        initEngine(newEngine);
        return newEngine;
    }

    @Override // io.netty.handler.ssl.SslContext
    protected final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, str, i6, z5);
        initHandler(newHandler);
        return newHandler;
    }

    @Override // io.netty.handler.ssl.SslContext
    protected SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z5, Executor executor) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, z5, executor);
        initHandler(newHandler);
        return newHandler;
    }

    @Override // io.netty.handler.ssl.SslContext
    protected SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i6, boolean z5, Executor executor) {
        SslHandler newHandler = this.ctx.newHandler(byteBufAllocator, str, i6, z5, executor);
        initHandler(newHandler);
        return newHandler;
    }
}
