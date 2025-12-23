package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Http2FrameStreamException extends Exception {
    private static final long serialVersionUID = -4407186173493887044L;
    private final Http2Error error;
    private final Http2FrameStream stream;

    public Http2Error error() {
        return this.error;
    }

    public Http2FrameStream stream() {
        return this.stream;
    }

    public Http2FrameStreamException(Http2FrameStream http2FrameStream, Http2Error http2Error, Throwable th) {
        super(th.getMessage(), th);
        this.stream = (Http2FrameStream) ObjectUtil.checkNotNull(http2FrameStream, "stream");
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
    }
}
