package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2HeadersEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Http2ConnectionHandlerBuilder extends AbstractHttp2ConnectionHandlerBuilder<Http2ConnectionHandler, Http2ConnectionHandlerBuilder> {
    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandler build() {
        return super.build();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    protected Http2ConnectionHandler build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        return new Http2ConnectionHandler(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, decoupleCloseAndGoAway());
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder codec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        return (Http2ConnectionHandlerBuilder) super.codec(http2ConnectionDecoder, http2ConnectionEncoder);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder connection(Http2Connection http2Connection) {
        return (Http2ConnectionHandlerBuilder) super.connection(http2Connection);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder decoupleCloseAndGoAway(boolean z5) {
        return (Http2ConnectionHandlerBuilder) super.decoupleCloseAndGoAway(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder encoderEnforceMaxConcurrentStreams(boolean z5) {
        return (Http2ConnectionHandlerBuilder) super.encoderEnforceMaxConcurrentStreams(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder encoderIgnoreMaxHeaderListSize(boolean z5) {
        return (Http2ConnectionHandlerBuilder) super.encoderIgnoreMaxHeaderListSize(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder frameListener(Http2FrameListener http2FrameListener) {
        return (Http2ConnectionHandlerBuilder) super.frameListener(http2FrameListener);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder frameLogger(Http2FrameLogger http2FrameLogger) {
        return (Http2ConnectionHandlerBuilder) super.frameLogger(http2FrameLogger);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder gracefulShutdownTimeoutMillis(long j6) {
        return (Http2ConnectionHandlerBuilder) super.gracefulShutdownTimeoutMillis(j6);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        return (Http2ConnectionHandlerBuilder) super.headerSensitivityDetector(sensitivityDetector);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    @Deprecated
    public Http2ConnectionHandlerBuilder initialHuffmanDecodeCapacity(int i6) {
        return (Http2ConnectionHandlerBuilder) super.initialHuffmanDecodeCapacity(i6);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder initialSettings(Http2Settings http2Settings) {
        return (Http2ConnectionHandlerBuilder) super.initialSettings(http2Settings);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder maxReservedStreams(int i6) {
        return (Http2ConnectionHandlerBuilder) super.maxReservedStreams(i6);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder server(boolean z5) {
        return (Http2ConnectionHandlerBuilder) super.server(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2ConnectionHandlerBuilder validateHeaders(boolean z5) {
        return (Http2ConnectionHandlerBuilder) super.validateHeaders(z5);
    }
}
