package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class CompressionUtil {
    static ByteBuffer safeNioBuffer(ByteBuf byteBuf) {
        return byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(byteBuf.readerIndex(), byteBuf.readableBytes()) : byteBuf.nioBuffer();
    }

    private CompressionUtil() {
    }

    static void checkChecksum(ByteBufChecksum byteBufChecksum, ByteBuf byteBuf, int i6) {
        byteBufChecksum.reset();
        byteBufChecksum.update(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
        int value = (int) byteBufChecksum.getValue();
        if (value == i6) {
        } else {
            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(i6)));
        }
    }

    static ByteBuffer safeNioBuffer(ByteBuf byteBuf, int i6, int i7) {
        return byteBuf.nioBufferCount() == 1 ? byteBuf.internalNioBuffer(i6, i7) : byteBuf.nioBuffer(i6, i7);
    }
}
