package io.netty.handler.codec.http2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class InboundHttp2ToHttpAdapterBuilder extends AbstractInboundHttp2ToHttpAdapterBuilder<InboundHttp2ToHttpAdapter, InboundHttp2ToHttpAdapterBuilder> {
    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapter build() {
        return super.build();
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    protected InboundHttp2ToHttpAdapter build(Http2Connection http2Connection, int i6, boolean z5, boolean z6) throws Exception {
        return new InboundHttp2ToHttpAdapter(http2Connection, i6, z5, z6);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder maxContentLength(int i6) {
        return (InboundHttp2ToHttpAdapterBuilder) super.maxContentLength(i6);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder propagateSettings(boolean z5) {
        return (InboundHttp2ToHttpAdapterBuilder) super.propagateSettings(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder validateHttpHeaders(boolean z5) {
        return (InboundHttp2ToHttpAdapterBuilder) super.validateHttpHeaders(z5);
    }

    public InboundHttp2ToHttpAdapterBuilder(Http2Connection http2Connection) {
        super(http2Connection);
    }
}
