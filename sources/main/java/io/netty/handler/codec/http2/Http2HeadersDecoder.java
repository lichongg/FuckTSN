package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface Http2HeadersDecoder {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Configuration {
        long maxHeaderListSize();

        void maxHeaderListSize(long j6, long j7) throws Http2Exception;

        long maxHeaderListSizeGoAway();

        long maxHeaderTableSize();

        void maxHeaderTableSize(long j6) throws Http2Exception;
    }

    Configuration configuration();

    Http2Headers decodeHeaders(int i6, ByteBuf byteBuf) throws Http2Exception;
}
