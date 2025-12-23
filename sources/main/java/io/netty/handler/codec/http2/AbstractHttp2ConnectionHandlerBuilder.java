package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder;
import io.netty.handler.codec.http2.Http2ConnectionHandler;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractHttp2ConnectionHandlerBuilder<T extends Http2ConnectionHandler, B extends AbstractHttp2ConnectionHandlerBuilder<T, B>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Http2HeadersEncoder.SensitivityDetector DEFAULT_HEADER_SENSITIVITY_DETECTOR = Http2HeadersEncoder.NEVER_SENSITIVE;
    private Http2Connection connection;
    private Http2ConnectionDecoder decoder;
    private boolean decoupleCloseAndGoAway;
    private Http2ConnectionEncoder encoder;
    private Boolean encoderEnforceMaxConcurrentStreams;
    private Boolean encoderIgnoreMaxHeaderListSize;
    private Http2FrameListener frameListener;
    private Http2FrameLogger frameLogger;
    private Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector;
    private Boolean isServer;
    private Integer maxReservedStreams;
    private Boolean validateHeaders;
    private Http2Settings initialSettings = Http2Settings.defaultSettings();
    private long gracefulShutdownTimeoutMillis = Http2CodecUtil.DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS;
    private Http2PromisedRequestVerifier promisedRequestVerifier = Http2PromisedRequestVerifier.ALWAYS_VERIFY;
    private boolean autoAckSettingsFrame = true;
    private boolean autoAckPingFrame = true;

    protected T build() {
        Http2ConnectionEncoder http2ConnectionEncoder = this.encoder;
        if (http2ConnectionEncoder != null) {
            return buildFromCodec(this.decoder, http2ConnectionEncoder);
        }
        Http2Connection http2Connection = this.connection;
        if (http2Connection == null) {
            http2Connection = new DefaultHttp2Connection(isServer(), maxReservedStreams());
        }
        return buildFromConnection(http2Connection);
    }

    protected abstract T build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) throws Exception;

    protected Http2Connection connection() {
        return this.connection;
    }

    protected B decoupleCloseAndGoAway(boolean z5) {
        this.decoupleCloseAndGoAway = z5;
        return self();
    }

    protected boolean encoderEnforceMaxConcurrentStreams() {
        Boolean bool = this.encoderEnforceMaxConcurrentStreams;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    protected Http2FrameListener frameListener() {
        return this.frameListener;
    }

    protected Http2FrameLogger frameLogger() {
        return this.frameLogger;
    }

    protected long gracefulShutdownTimeoutMillis() {
        return this.gracefulShutdownTimeoutMillis;
    }

    protected Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector() {
        Http2HeadersEncoder.SensitivityDetector sensitivityDetector = this.headerSensitivityDetector;
        return sensitivityDetector != null ? sensitivityDetector : DEFAULT_HEADER_SENSITIVITY_DETECTOR;
    }

    protected Http2Settings initialSettings() {
        return this.initialSettings;
    }

    protected int maxReservedStreams() {
        Integer num = this.maxReservedStreams;
        if (num != null) {
            return num.intValue();
        }
        return 100;
    }

    protected B promisedRequestVerifier(Http2PromisedRequestVerifier http2PromisedRequestVerifier) {
        enforceNonCodecConstraints("promisedRequestVerifier");
        this.promisedRequestVerifier = (Http2PromisedRequestVerifier) ObjectUtil.checkNotNull(http2PromisedRequestVerifier, "promisedRequestVerifier");
        return self();
    }

    private T buildFromCodec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        try {
            T build = build(http2ConnectionDecoder, http2ConnectionEncoder, this.initialSettings);
            build.gracefulShutdownTimeoutMillis(this.gracefulShutdownTimeoutMillis);
            if (build.decoder().frameListener() == null) {
                build.decoder().frameListener(this.frameListener);
            }
            return build;
        } catch (Throwable th) {
            http2ConnectionEncoder.close();
            http2ConnectionDecoder.close();
            throw new IllegalStateException("failed to build a Http2ConnectionHandler", th);
        }
    }

    private T buildFromConnection(Http2Connection http2Connection) {
        Http2FrameReader http2FrameReader;
        Http2ConnectionEncoder http2ConnectionEncoder;
        Long maxHeaderListSize = this.initialSettings.maxHeaderListSize();
        Http2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(new DefaultHttp2HeadersDecoder(isValidateHeaders(), maxHeaderListSize == null ? 8192L : maxHeaderListSize.longValue(), -1));
        Http2FrameWriter defaultHttp2FrameWriter = this.encoderIgnoreMaxHeaderListSize == null ? new DefaultHttp2FrameWriter(headerSensitivityDetector()) : new DefaultHttp2FrameWriter(headerSensitivityDetector(), this.encoderIgnoreMaxHeaderListSize.booleanValue());
        Http2FrameLogger http2FrameLogger = this.frameLogger;
        if (http2FrameLogger != null) {
            Http2FrameReader http2InboundFrameLogger = new Http2InboundFrameLogger(defaultHttp2FrameReader, http2FrameLogger);
            defaultHttp2FrameWriter = new Http2OutboundFrameLogger(defaultHttp2FrameWriter, this.frameLogger);
            http2FrameReader = http2InboundFrameLogger;
        } else {
            http2FrameReader = defaultHttp2FrameReader;
        }
        Http2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(http2Connection, defaultHttp2FrameWriter);
        boolean encoderEnforceMaxConcurrentStreams = encoderEnforceMaxConcurrentStreams();
        if (!encoderEnforceMaxConcurrentStreams) {
            http2ConnectionEncoder = defaultHttp2ConnectionEncoder;
        } else {
            if (http2Connection.isServer()) {
                defaultHttp2ConnectionEncoder.close();
                http2FrameReader.close();
                throw new IllegalArgumentException("encoderEnforceMaxConcurrentStreams: " + encoderEnforceMaxConcurrentStreams + " not supported for server");
            }
            http2ConnectionEncoder = new StreamBufferingEncoder(defaultHttp2ConnectionEncoder);
        }
        return buildFromCodec(new DefaultHttp2ConnectionDecoder(http2Connection, http2ConnectionEncoder, http2FrameReader, promisedRequestVerifier(), isAutoAckSettingsFrame(), isAutoAckPingFrame()), http2ConnectionEncoder);
    }

    private static void enforceConstraint(String str, String str2, Object obj) {
        if (obj == null) {
            return;
        }
        throw new IllegalStateException(str + "() cannot be called because " + str2 + "() has been called already.");
    }

    private void enforceNonCodecConstraints(String str) {
        enforceConstraint(str, "server/connection", this.decoder);
        enforceConstraint(str, "server/connection", this.encoder);
    }

    protected B autoAckPingFrame(boolean z5) {
        enforceNonCodecConstraints("autoAckPingFrame");
        this.autoAckPingFrame = z5;
        return self();
    }

    protected B autoAckSettingsFrame(boolean z5) {
        enforceNonCodecConstraints("autoAckSettingsFrame");
        this.autoAckSettingsFrame = z5;
        return self();
    }

    protected B codec(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder) {
        enforceConstraint("codec", "server", this.isServer);
        enforceConstraint("codec", "maxReservedStreams", this.maxReservedStreams);
        enforceConstraint("codec", "connection", this.connection);
        enforceConstraint("codec", "frameLogger", this.frameLogger);
        enforceConstraint("codec", "validateHeaders", this.validateHeaders);
        enforceConstraint("codec", "headerSensitivityDetector", this.headerSensitivityDetector);
        enforceConstraint("codec", "encoderEnforceMaxConcurrentStreams", this.encoderEnforceMaxConcurrentStreams);
        ObjectUtil.checkNotNull(http2ConnectionDecoder, "decoder");
        ObjectUtil.checkNotNull(http2ConnectionEncoder, "encoder");
        if (http2ConnectionDecoder.connection() != http2ConnectionEncoder.connection()) {
            throw new IllegalArgumentException("The specified encoder and decoder have different connections.");
        }
        this.decoder = http2ConnectionDecoder;
        this.encoder = http2ConnectionEncoder;
        return self();
    }

    protected B connection(Http2Connection http2Connection) {
        enforceConstraint("connection", "maxReservedStreams", this.maxReservedStreams);
        enforceConstraint("connection", "server", this.isServer);
        enforceConstraint("connection", "codec", this.decoder);
        enforceConstraint("connection", "codec", this.encoder);
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        return self();
    }

    protected Http2ConnectionDecoder decoder() {
        return this.decoder;
    }

    protected Http2ConnectionEncoder encoder() {
        return this.encoder;
    }

    protected B encoderEnforceMaxConcurrentStreams(boolean z5) {
        enforceNonCodecConstraints("encoderEnforceMaxConcurrentStreams");
        this.encoderEnforceMaxConcurrentStreams = Boolean.valueOf(z5);
        return self();
    }

    protected B encoderIgnoreMaxHeaderListSize(boolean z5) {
        enforceNonCodecConstraints("encoderIgnoreMaxHeaderListSize");
        this.encoderIgnoreMaxHeaderListSize = Boolean.valueOf(z5);
        return self();
    }

    protected B frameListener(Http2FrameListener http2FrameListener) {
        this.frameListener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, "frameListener");
        return self();
    }

    protected B frameLogger(Http2FrameLogger http2FrameLogger) {
        enforceNonCodecConstraints("frameLogger");
        this.frameLogger = (Http2FrameLogger) ObjectUtil.checkNotNull(http2FrameLogger, "frameLogger");
        return self();
    }

    protected B gracefulShutdownTimeoutMillis(long j6) {
        if (j6 >= -1) {
            this.gracefulShutdownTimeoutMillis = j6;
            return self();
        }
        throw new IllegalArgumentException("gracefulShutdownTimeoutMillis: " + j6 + " (expected: -1 for indefinite or >= 0)");
    }

    protected B headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        enforceNonCodecConstraints("headerSensitivityDetector");
        this.headerSensitivityDetector = (Http2HeadersEncoder.SensitivityDetector) ObjectUtil.checkNotNull(sensitivityDetector, "headerSensitivityDetector");
        return self();
    }

    protected B initialSettings(Http2Settings http2Settings) {
        this.initialSettings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "settings");
        return self();
    }

    protected boolean isAutoAckPingFrame() {
        return this.autoAckPingFrame;
    }

    protected boolean isAutoAckSettingsFrame() {
        return this.autoAckSettingsFrame;
    }

    protected boolean isServer() {
        Boolean bool = this.isServer;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    protected boolean isValidateHeaders() {
        Boolean bool = this.validateHeaders;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    protected B maxReservedStreams(int i6) {
        enforceConstraint("server", "connection", this.connection);
        enforceConstraint("server", "codec", this.decoder);
        enforceConstraint("server", "codec", this.encoder);
        this.maxReservedStreams = Integer.valueOf(ObjectUtil.checkPositiveOrZero(i6, "maxReservedStreams"));
        return self();
    }

    protected B server(boolean z5) {
        enforceConstraint("server", "connection", this.connection);
        enforceConstraint("server", "codec", this.decoder);
        enforceConstraint("server", "codec", this.encoder);
        this.isServer = Boolean.valueOf(z5);
        return self();
    }

    protected B validateHeaders(boolean z5) {
        enforceNonCodecConstraints("validateHeaders");
        this.validateHeaders = Boolean.valueOf(z5);
        return self();
    }

    protected boolean decoupleCloseAndGoAway() {
        return this.decoupleCloseAndGoAway;
    }

    @Deprecated
    protected B initialHuffmanDecodeCapacity(int i6) {
        return self();
    }

    protected Http2PromisedRequestVerifier promisedRequestVerifier() {
        return this.promisedRequestVerifier;
    }

    protected final B self() {
        return this;
    }
}
