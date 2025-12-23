package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Connection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2Stream {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum State {
        IDLE(false, false),
        RESERVED_LOCAL(false, false),
        RESERVED_REMOTE(false, false),
        OPEN(true, true),
        HALF_CLOSED_LOCAL(false, true),
        HALF_CLOSED_REMOTE(true, false),
        CLOSED(false, false);

        private final boolean localSideOpen;
        private final boolean remoteSideOpen;

        public boolean localSideOpen() {
            return this.localSideOpen;
        }

        public boolean remoteSideOpen() {
            return this.remoteSideOpen;
        }

        State(boolean z5, boolean z6) {
            this.localSideOpen = z5;
            this.remoteSideOpen = z6;
        }
    }

    Http2Stream close();

    Http2Stream closeLocalSide();

    Http2Stream closeRemoteSide();

    <V> V getProperty(Http2Connection.PropertyKey propertyKey);

    Http2Stream headersReceived(boolean z5);

    Http2Stream headersSent(boolean z5);

    int id();

    boolean isHeadersReceived();

    boolean isHeadersSent();

    boolean isPushPromiseSent();

    boolean isResetSent();

    boolean isTrailersReceived();

    boolean isTrailersSent();

    Http2Stream open(boolean z5) throws Http2Exception;

    Http2Stream pushPromiseSent();

    <V> V removeProperty(Http2Connection.PropertyKey propertyKey);

    Http2Stream resetSent();

    <V> V setProperty(Http2Connection.PropertyKey propertyKey, V v5);

    State state();
}
