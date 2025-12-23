package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2FrameCodecBuilder extends AbstractHttp2ConnectionHandlerBuilder<Http2FrameCodec, Http2FrameCodecBuilder> {
    private Http2FrameWriter frameWriter;

    public static Http2FrameCodecBuilder forClient() {
        return new Http2FrameCodecBuilder(false);
    }

    public static Http2FrameCodecBuilder forServer() {
        return new Http2FrameCodecBuilder(true);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder autoAckPingFrame(boolean z5) {
        return (Http2FrameCodecBuilder) super.autoAckPingFrame(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder autoAckSettingsFrame(boolean z5) {
        return (Http2FrameCodecBuilder) super.autoAckSettingsFrame(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder decoupleCloseAndGoAway(boolean z5) {
        return (Http2FrameCodecBuilder) super.decoupleCloseAndGoAway(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public boolean encoderEnforceMaxConcurrentStreams() {
        return super.encoderEnforceMaxConcurrentStreams();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder encoderIgnoreMaxHeaderListSize(boolean z5) {
        return (Http2FrameCodecBuilder) super.encoderIgnoreMaxHeaderListSize(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameLogger frameLogger() {
        return super.frameLogger();
    }

    Http2FrameCodecBuilder frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public long gracefulShutdownTimeoutMillis() {
        return super.gracefulShutdownTimeoutMillis();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector() {
        return super.headerSensitivityDetector();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    @Deprecated
    public Http2FrameCodecBuilder initialHuffmanDecodeCapacity(int i6) {
        return (Http2FrameCodecBuilder) super.initialHuffmanDecodeCapacity(i6);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2Settings initialSettings() {
        return super.initialSettings();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public int maxReservedStreams() {
        return super.maxReservedStreams();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder validateHeaders(boolean z5) {
        return (Http2FrameCodecBuilder) super.validateHeaders(z5);
    }

    Http2FrameCodecBuilder(boolean z5) {
        server(z5);
        gracefulShutdownTimeoutMillis(0L);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodec build() {
        Http2FrameReader http2FrameReader;
        Http2FrameWriter http2FrameWriter = this.frameWriter;
        if (http2FrameWriter != null) {
            DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(isServer(), maxReservedStreams());
            Long maxHeaderListSize = initialSettings().maxHeaderListSize();
            Http2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(maxHeaderListSize == null ? new DefaultHttp2HeadersDecoder(true) : new DefaultHttp2HeadersDecoder(true, maxHeaderListSize.longValue()));
            if (frameLogger() != null) {
                Http2OutboundFrameLogger http2OutboundFrameLogger = new Http2OutboundFrameLogger(http2FrameWriter, frameLogger());
                http2FrameReader = new Http2InboundFrameLogger(defaultHttp2FrameReader, frameLogger());
                http2FrameWriter = http2OutboundFrameLogger;
            } else {
                http2FrameReader = defaultHttp2FrameReader;
            }
            DefaultHttp2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(defaultHttp2Connection, http2FrameWriter);
            Http2ConnectionEncoder streamBufferingEncoder = encoderEnforceMaxConcurrentStreams() ? new StreamBufferingEncoder(defaultHttp2ConnectionEncoder) : defaultHttp2ConnectionEncoder;
            return build((Http2ConnectionDecoder) new DefaultHttp2ConnectionDecoder(defaultHttp2Connection, streamBufferingEncoder, http2FrameReader, promisedRequestVerifier(), isAutoAckSettingsFrame(), isAutoAckPingFrame()), streamBufferingEncoder, initialSettings());
        }
        return (Http2FrameCodec) super.build();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder encoderEnforceMaxConcurrentStreams(boolean z5) {
        return (Http2FrameCodecBuilder) super.encoderEnforceMaxConcurrentStreams(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder frameLogger(Http2FrameLogger http2FrameLogger) {
        return (Http2FrameCodecBuilder) super.frameLogger(http2FrameLogger);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder gracefulShutdownTimeoutMillis(long j6) {
        return (Http2FrameCodecBuilder) super.gracefulShutdownTimeoutMillis(j6);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        return (Http2FrameCodecBuilder) super.headerSensitivityDetector(sensitivityDetector);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder initialSettings(Http2Settings http2Settings) {
        return (Http2FrameCodecBuilder) super.initialSettings(http2Settings);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public boolean isServer() {
        return super.isServer();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public boolean isValidateHeaders() {
        return super.isValidateHeaders();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodecBuilder maxReservedStreams(int i6) {
        return (Http2FrameCodecBuilder) super.maxReservedStreams(i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameCodec build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        Http2FrameCodec http2FrameCodec = new Http2FrameCodec(http2ConnectionEncoder, http2ConnectionDecoder, http2Settings, decoupleCloseAndGoAway());
        http2FrameCodec.gracefulShutdownTimeoutMillis(gracefulShutdownTimeoutMillis());
        return http2FrameCodec;
    }
}
