package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2HeadersDecoder implements Http2HeadersDecoder, Http2HeadersDecoder.Configuration {
    private static final float HEADERS_COUNT_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_COUNT_WEIGHT_NEW = 0.2f;
    private float headerArraySizeAccumulator;
    private final HpackDecoder hpackDecoder;
    private long maxHeaderListSizeGoAway;
    private final boolean validateHeaders;

    public DefaultHttp2HeadersDecoder() {
        this(true);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public void maxHeaderListSize(long j6, long j7) throws Http2Exception {
        if (j7 < j6 || j7 < 0) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Header List Size GO_AWAY %d must be non-negative and >= %d", Long.valueOf(j7), Long.valueOf(j6));
        }
        this.hpackDecoder.setMaxHeaderListSize(j6);
        this.maxHeaderListSizeGoAway = j7;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public void maxHeaderTableSize(long j6) throws Http2Exception {
        this.hpackDecoder.setMaxHeaderTableSize(j6);
    }

    public DefaultHttp2HeadersDecoder(boolean z5) {
        this(z5, 8192L);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderListSizeGoAway() {
        return this.maxHeaderListSizeGoAway;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderTableSize() {
        return this.hpackDecoder.getMaxHeaderTableSize();
    }

    protected Http2Headers newHeaders() {
        return new DefaultHttp2Headers(this.validateHeaders, (int) this.headerArraySizeAccumulator);
    }

    protected final int numberOfHeadersGuess() {
        return (int) this.headerArraySizeAccumulator;
    }

    protected final boolean validateHeaders() {
        return this.validateHeaders;
    }

    public DefaultHttp2HeadersDecoder(boolean z5, long j6) {
        this(z5, j6, -1);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2Headers decodeHeaders(int i6, ByteBuf byteBuf) throws Http2Exception {
        try {
            Http2Headers newHeaders = newHeaders();
            this.hpackDecoder.decode(i6, byteBuf, newHeaders, this.validateHeaders);
            this.headerArraySizeAccumulator = (newHeaders.size() * 0.2f) + (this.headerArraySizeAccumulator * HEADERS_COUNT_WEIGHT_HISTORICAL);
            return newHeaders;
        } catch (Http2Exception e6) {
            throw e6;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th, th.getMessage(), new Object[0]);
        }
    }

    public DefaultHttp2HeadersDecoder(boolean z5, long j6, @Deprecated int i6) {
        this(z5, new HpackDecoder(j6));
    }

    DefaultHttp2HeadersDecoder(boolean z5, HpackDecoder hpackDecoder) {
        this.headerArraySizeAccumulator = 8.0f;
        this.hpackDecoder = (HpackDecoder) ObjectUtil.checkNotNull(hpackDecoder, "hpackDecoder");
        this.validateHeaders = z5;
        this.maxHeaderListSizeGoAway = Http2CodecUtil.calculateMaxHeaderListSizeGoAway(hpackDecoder.getMaxHeaderListSize());
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderListSize() {
        return this.hpackDecoder.getMaxHeaderListSize();
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2HeadersDecoder.Configuration configuration() {
        return this;
    }
}
