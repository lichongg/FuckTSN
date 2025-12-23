package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultHttp2HeadersEncoder implements Http2HeadersEncoder, Http2HeadersEncoder.Configuration {
    private final HpackEncoder hpackEncoder;
    private final Http2HeadersEncoder.SensitivityDetector sensitivityDetector;
    private final ByteBuf tableSizeChangeOutput;

    public DefaultHttp2HeadersEncoder() {
        this(Http2HeadersEncoder.NEVER_SENSITIVE);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public void maxHeaderListSize(long j6) throws Http2Exception {
        this.hpackEncoder.setMaxHeaderListSize(j6);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public void maxHeaderTableSize(long j6) throws Http2Exception {
        this.hpackEncoder.setMaxHeaderTableSize(this.tableSizeChangeOutput, j6);
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this(sensitivityDetector, new HpackEncoder());
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder
    public void encodeHeaders(int i6, Http2Headers http2Headers, ByteBuf byteBuf) throws Http2Exception {
        try {
            if (this.tableSizeChangeOutput.isReadable()) {
                byteBuf.writeBytes(this.tableSizeChangeOutput);
                this.tableSizeChangeOutput.clear();
            }
            this.hpackEncoder.encodeHeaders(i6, byteBuf, http2Headers, this.sensitivityDetector);
        } catch (Http2Exception e6) {
            throw e6;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th, "Failed encoding headers block: %s", th.getMessage());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public long maxHeaderListSize() {
        return this.hpackEncoder.getMaxHeaderListSize();
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public long maxHeaderTableSize() {
        return this.hpackEncoder.getMaxHeaderTableSize();
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z5) {
        this(sensitivityDetector, new HpackEncoder(z5));
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z5, int i6) {
        this(sensitivityDetector, z5, i6, 512);
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z5, int i6, int i7) {
        this(sensitivityDetector, new HpackEncoder(z5, i6, i7));
    }

    DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, HpackEncoder hpackEncoder) {
        this.tableSizeChangeOutput = Unpooled.buffer();
        this.sensitivityDetector = (Http2HeadersEncoder.SensitivityDetector) ObjectUtil.checkNotNull(sensitivityDetector, "sensitiveDetector");
        this.hpackEncoder = (HpackEncoder) ObjectUtil.checkNotNull(hpackEncoder, "hpackEncoder");
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder
    public Http2HeadersEncoder.Configuration configuration() {
        return this;
    }
}
