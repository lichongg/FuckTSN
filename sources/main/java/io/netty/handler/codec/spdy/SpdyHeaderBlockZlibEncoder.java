package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class SpdyHeaderBlockZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private final Deflater compressor;
    private boolean finished;

    private ByteBuf encode(ByteBufAllocator byteBufAllocator, int i6) {
        ByteBuf heapBuffer = byteBufAllocator.heapBuffer(i6);
        while (compressInto(heapBuffer)) {
            try {
                heapBuffer.ensureWritable(heapBuffer.capacity() << 1);
            } catch (Throwable th) {
                heapBuffer.release();
                throw th;
            }
        }
        return heapBuffer;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.compressor.end();
        super.end();
    }

    SpdyHeaderBlockZlibEncoder(SpdyVersion spdyVersion, int i6) {
        super(spdyVersion);
        if (i6 >= 0 && i6 <= 9) {
            Deflater deflater = new Deflater(i6);
            this.compressor = deflater;
            deflater.setDictionary(SpdyCodecUtil.SPDY_DICT);
        } else {
            throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
        }
    }

    private boolean compressInto(ByteBuf byteBuf) {
        byte[] array = byteBuf.array();
        int arrayOffset = byteBuf.arrayOffset() + byteBuf.writerIndex();
        int writableBytes = byteBuf.writableBytes();
        int deflate = this.compressor.deflate(array, arrayOffset, writableBytes, 2);
        byteBuf.writerIndex(byteBuf.writerIndex() + deflate);
        if (deflate == writableBytes) {
            return true;
        }
        return false;
    }

    private int setInput(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            this.compressor.setInput(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), readableBytes);
            return readableBytes;
        }
        byte[] bArr = new byte[readableBytes];
        byteBuf.getBytes(byteBuf.readerIndex(), bArr);
        this.compressor.setInput(bArr, 0, readableBytes);
        return readableBytes;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        if (spdyHeadersFrame != null) {
            if (this.finished) {
                return Unpooled.EMPTY_BUFFER;
            }
            ByteBuf encode = super.encode(byteBufAllocator, spdyHeadersFrame);
            try {
                if (!encode.isReadable()) {
                    return Unpooled.EMPTY_BUFFER;
                }
                return encode(byteBufAllocator, setInput(encode));
            } finally {
                encode.release();
            }
        }
        throw new IllegalArgumentException("frame");
    }
}
