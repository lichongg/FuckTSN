package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
abstract class SpdyHeaderBlockEncoder {
    abstract ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    abstract void end();

    SpdyHeaderBlockEncoder() {
    }

    static SpdyHeaderBlockEncoder newInstance(SpdyVersion spdyVersion, int i6, int i7, int i8) {
        if (PlatformDependent.javaVersion() >= 7) {
            return new SpdyHeaderBlockZlibEncoder(spdyVersion, i6);
        }
        return new SpdyHeaderBlockJZlibEncoder(spdyVersion, i6, i7, i8);
    }
}
