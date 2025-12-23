package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class SpdyHeaderBlockDecoder {
    abstract void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    abstract void end();

    abstract void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    static SpdyHeaderBlockDecoder newInstance(SpdyVersion spdyVersion, int i6) {
        return new SpdyHeaderBlockZlibDecoder(spdyVersion, i6);
    }

    SpdyHeaderBlockDecoder() {
    }
}
