package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder;
import io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractInboundHttp2ToHttpAdapterBuilder<T extends InboundHttp2ToHttpAdapter, B extends AbstractInboundHttp2ToHttpAdapterBuilder<T, B>> {
    private final Http2Connection connection;
    private int maxContentLength;
    private boolean propagateSettings;
    private boolean validateHttpHeaders;

    protected T build() {
        try {
            T build = build(connection(), maxContentLength(), isValidateHttpHeaders(), isPropagateSettings());
            this.connection.addListener(build);
            return build;
        } catch (Throwable th) {
            throw new IllegalStateException("failed to create a new InboundHttp2ToHttpAdapter", th);
        }
    }

    protected abstract T build(Http2Connection http2Connection, int i6, boolean z5, boolean z6) throws Exception;

    protected int maxContentLength() {
        return this.maxContentLength;
    }

    protected Http2Connection connection() {
        return this.connection;
    }

    protected boolean isPropagateSettings() {
        return this.propagateSettings;
    }

    protected boolean isValidateHttpHeaders() {
        return this.validateHttpHeaders;
    }

    protected B maxContentLength(int i6) {
        this.maxContentLength = i6;
        return self();
    }

    protected B propagateSettings(boolean z5) {
        this.propagateSettings = z5;
        return self();
    }

    protected B validateHttpHeaders(boolean z5) {
        this.validateHttpHeaders = z5;
        return self();
    }

    protected AbstractInboundHttp2ToHttpAdapterBuilder(Http2Connection http2Connection) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
    }

    protected final B self() {
        return this;
    }
}
