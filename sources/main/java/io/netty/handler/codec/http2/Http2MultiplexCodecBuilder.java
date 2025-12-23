package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2MultiplexCodecBuilder extends AbstractHttp2ConnectionHandlerBuilder<Http2MultiplexCodec, Http2MultiplexCodecBuilder> {
    final ChannelHandler childHandler;
    private Http2FrameWriter frameWriter;
    private ChannelHandler upgradeStreamHandler;

    private static ChannelHandler checkSharable(ChannelHandler channelHandler) {
        if (!(channelHandler instanceof ChannelHandlerAdapter) || ((ChannelHandlerAdapter) channelHandler).isSharable() || channelHandler.getClass().isAnnotationPresent(ChannelHandler.Sharable.class)) {
            return channelHandler;
        }
        throw new IllegalArgumentException("The handler must be Sharable");
    }

    public static Http2MultiplexCodecBuilder forClient(ChannelHandler channelHandler) {
        return new Http2MultiplexCodecBuilder(false, channelHandler);
    }

    public static Http2MultiplexCodecBuilder forServer(ChannelHandler channelHandler) {
        return new Http2MultiplexCodecBuilder(true, channelHandler);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder autoAckPingFrame(boolean z5) {
        return (Http2MultiplexCodecBuilder) super.autoAckPingFrame(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder autoAckSettingsFrame(boolean z5) {
        return (Http2MultiplexCodecBuilder) super.autoAckSettingsFrame(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder decoupleCloseAndGoAway(boolean z5) {
        return (Http2MultiplexCodecBuilder) super.decoupleCloseAndGoAway(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public boolean encoderEnforceMaxConcurrentStreams() {
        return super.encoderEnforceMaxConcurrentStreams();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder encoderIgnoreMaxHeaderListSize(boolean z5) {
        return (Http2MultiplexCodecBuilder) super.encoderIgnoreMaxHeaderListSize(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameLogger frameLogger() {
        return super.frameLogger();
    }

    Http2MultiplexCodecBuilder frameWriter(Http2FrameWriter http2FrameWriter) {
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
    public Http2MultiplexCodecBuilder initialHuffmanDecodeCapacity(int i6) {
        return (Http2MultiplexCodecBuilder) super.initialHuffmanDecodeCapacity(i6);
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
    public Http2MultiplexCodecBuilder validateHeaders(boolean z5) {
        return (Http2MultiplexCodecBuilder) super.validateHeaders(z5);
    }

    Http2MultiplexCodecBuilder(boolean z5, ChannelHandler channelHandler) {
        server(z5);
        this.childHandler = checkSharable((ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "childHandler"));
        gracefulShutdownTimeoutMillis(0L);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodec build() {
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
        return (Http2MultiplexCodec) super.build();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder encoderEnforceMaxConcurrentStreams(boolean z5) {
        return (Http2MultiplexCodecBuilder) super.encoderEnforceMaxConcurrentStreams(z5);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder frameLogger(Http2FrameLogger http2FrameLogger) {
        return (Http2MultiplexCodecBuilder) super.frameLogger(http2FrameLogger);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder gracefulShutdownTimeoutMillis(long j6) {
        return (Http2MultiplexCodecBuilder) super.gracefulShutdownTimeoutMillis(j6);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        return (Http2MultiplexCodecBuilder) super.headerSensitivityDetector(sensitivityDetector);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder initialSettings(Http2Settings http2Settings) {
        return (Http2MultiplexCodecBuilder) super.initialSettings(http2Settings);
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
    public Http2MultiplexCodecBuilder maxReservedStreams(int i6) {
        return (Http2MultiplexCodecBuilder) super.maxReservedStreams(i6);
    }

    public Http2MultiplexCodecBuilder withUpgradeStreamHandler(ChannelHandler channelHandler) {
        if (!isServer()) {
            this.upgradeStreamHandler = channelHandler;
            return this;
        }
        throw new IllegalArgumentException("Server codecs don't use an extra handler for the upgrade stream");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodec build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        Http2MultiplexCodec http2MultiplexCodec = new Http2MultiplexCodec(http2ConnectionEncoder, http2ConnectionDecoder, http2Settings, this.childHandler, this.upgradeStreamHandler, decoupleCloseAndGoAway());
        http2MultiplexCodec.gracefulShutdownTimeoutMillis(gracefulShutdownTimeoutMillis());
        return http2MultiplexCodec;
    }
}
