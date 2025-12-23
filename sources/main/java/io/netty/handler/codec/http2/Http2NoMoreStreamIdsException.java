package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Exception;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Http2NoMoreStreamIdsException extends Http2Exception {
    private static final String ERROR_MESSAGE = "No more streams can be created on this connection";
    private static final long serialVersionUID = -7756236161274851110L;

    public Http2NoMoreStreamIdsException() {
        super(Http2Error.PROTOCOL_ERROR, ERROR_MESSAGE, Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN);
    }

    public Http2NoMoreStreamIdsException(Throwable th) {
        super(Http2Error.PROTOCOL_ERROR, ERROR_MESSAGE, th, Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN);
    }
}
