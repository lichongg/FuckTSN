package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2Connection {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Endpoint<F extends Http2FlowController> {
        void allowPushTo(boolean z5);

        boolean allowPushTo();

        boolean canOpenStream();

        Http2Stream createStream(int i6, boolean z5) throws Http2Exception;

        boolean created(Http2Stream http2Stream);

        F flowController();

        void flowController(F f6);

        int incrementAndGetNextStreamId();

        boolean isServer();

        boolean isValidStreamId(int i6);

        int lastStreamCreated();

        int lastStreamKnownByPeer();

        int maxActiveStreams();

        void maxActiveStreams(int i6);

        boolean mayHaveCreatedStream(int i6);

        int numActiveStreams();

        Endpoint<? extends Http2FlowController> opposite();

        Http2Stream reservePushStream(int i6, Http2Stream http2Stream) throws Http2Exception;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Listener {
        void onGoAwayReceived(int i6, long j6, ByteBuf byteBuf);

        void onGoAwaySent(int i6, long j6, ByteBuf byteBuf);

        void onStreamActive(Http2Stream http2Stream);

        void onStreamAdded(Http2Stream http2Stream);

        void onStreamClosed(Http2Stream http2Stream);

        void onStreamHalfClosed(Http2Stream http2Stream);

        void onStreamRemoved(Http2Stream http2Stream);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface PropertyKey {
    }

    void addListener(Listener listener);

    Future<Void> close(Promise<Void> promise);

    Http2Stream connectionStream();

    Http2Stream forEachActiveStream(Http2StreamVisitor http2StreamVisitor) throws Http2Exception;

    void goAwayReceived(int i6, long j6, ByteBuf byteBuf) throws Http2Exception;

    boolean goAwayReceived();

    boolean goAwaySent();

    boolean goAwaySent(int i6, long j6, ByteBuf byteBuf) throws Http2Exception;

    boolean isServer();

    Endpoint<Http2LocalFlowController> local();

    PropertyKey newKey();

    int numActiveStreams();

    Endpoint<Http2RemoteFlowController> remote();

    void removeListener(Listener listener);

    Http2Stream stream(int i6);

    boolean streamMayHaveExisted(int i6);
}
