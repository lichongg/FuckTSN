package io.netty.handler.codec.spdy;

import io.netty.util.AsciiString;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class SpdyHttpHeaders {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Names {
        public static final AsciiString STREAM_ID = AsciiString.cached("x-spdy-stream-id");
        public static final AsciiString ASSOCIATED_TO_STREAM_ID = AsciiString.cached("x-spdy-associated-to-stream-id");
        public static final AsciiString PRIORITY = AsciiString.cached("x-spdy-priority");
        public static final AsciiString SCHEME = AsciiString.cached("x-spdy-scheme");

        private Names() {
        }
    }

    private SpdyHttpHeaders() {
    }
}
