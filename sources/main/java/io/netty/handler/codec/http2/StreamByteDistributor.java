package io.netty.handler.codec.http2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface StreamByteDistributor {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface StreamState {
        boolean hasFrame();

        long pendingBytes();

        Http2Stream stream();

        int windowSize();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Writer {
        void write(Http2Stream http2Stream, int i6);
    }

    boolean distribute(int i6, Writer writer) throws Http2Exception;

    void updateDependencyTree(int i6, int i7, short s5, boolean z5);

    void updateStreamableBytes(StreamState streamState);
}
