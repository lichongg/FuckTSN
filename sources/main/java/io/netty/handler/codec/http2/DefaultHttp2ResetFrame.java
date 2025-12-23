package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class DefaultHttp2ResetFrame extends AbstractHttp2StreamFrame implements Http2ResetFrame {
    private final long errorCode;

    public DefaultHttp2ResetFrame(Http2Error http2Error) {
        this.errorCode = ((Http2Error) ObjectUtil.checkNotNull(http2Error, "error")).code();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttp2ResetFrame) {
            return super.equals(obj) && this.errorCode == ((DefaultHttp2ResetFrame) obj).errorCode;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2ResetFrame
    public long errorCode() {
        return this.errorCode;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "RST_STREAM";
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(stream=" + stream() + ", errorCode=" + this.errorCode + ')';
    }

    public DefaultHttp2ResetFrame(long j6) {
        this.errorCode = j6;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        long j6 = this.errorCode;
        return hashCode + ((int) (j6 ^ (j6 >>> 32)));
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2ResetFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
