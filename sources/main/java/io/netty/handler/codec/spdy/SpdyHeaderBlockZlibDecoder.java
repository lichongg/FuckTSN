package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SpdyHeaderBlockZlibDecoder extends SpdyHeaderBlockRawDecoder {
    private static final int DEFAULT_BUFFER_CAPACITY = 4096;
    private static final SpdyProtocolException INVALID_HEADER_BLOCK = new SpdyProtocolException("Invalid Header Block");
    private ByteBuf decompressed;
    private final Inflater decompressor;

    private void ensureBuffer(ByteBufAllocator byteBufAllocator) {
        if (this.decompressed == null) {
            this.decompressed = byteBufAllocator.heapBuffer(4096);
        }
        this.decompressed.ensureWritable(1);
    }

    private void releaseBuffer() {
        ByteBuf byteBuf = this.decompressed;
        if (byteBuf != null) {
            byteBuf.release();
            this.decompressed = null;
        }
    }

    SpdyHeaderBlockZlibDecoder(SpdyVersion spdyVersion, int i6) {
        super(spdyVersion, i6);
        this.decompressor = new Inflater();
    }

    private int decompress(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        ensureBuffer(byteBufAllocator);
        byte[] array = this.decompressed.array();
        int arrayOffset = this.decompressed.arrayOffset() + this.decompressed.writerIndex();
        try {
            int inflate = this.decompressor.inflate(array, arrayOffset, this.decompressed.writableBytes());
            if (inflate == 0 && this.decompressor.needsDictionary()) {
                try {
                    this.decompressor.setDictionary(SpdyCodecUtil.SPDY_DICT);
                    inflate = this.decompressor.inflate(array, arrayOffset, this.decompressed.writableBytes());
                } catch (IllegalArgumentException unused) {
                    throw INVALID_HEADER_BLOCK;
                }
            }
            if (spdyHeadersFrame != null) {
                ByteBuf byteBuf = this.decompressed;
                byteBuf.writerIndex(byteBuf.writerIndex() + inflate);
                decodeHeaderBlock(this.decompressed, spdyHeadersFrame);
                this.decompressed.discardReadBytes();
            }
            return inflate;
        } catch (DataFormatException e6) {
            throw new SpdyProtocolException("Received invalid header block", e6);
        }
    }

    private int setInput(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            this.decompressor.setInput(byteBuf.array(), byteBuf.arrayOffset() + byteBuf.readerIndex(), readableBytes);
            return readableBytes;
        }
        byte[] bArr = new byte[readableBytes];
        byteBuf.getBytes(byteBuf.readerIndex(), bArr);
        this.decompressor.setInput(bArr, 0, readableBytes);
        return readableBytes;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder, io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        int input = setInput(byteBuf);
        while (decompress(byteBufAllocator, spdyHeadersFrame) > 0) {
        }
        if (this.decompressor.getRemaining() == 0) {
            byteBuf.skipBytes(input);
            return;
        }
        throw INVALID_HEADER_BLOCK;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder, io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void end() {
        super.end();
        releaseBuffer();
        this.decompressor.end();
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder, io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        super.endHeaderBlock(spdyHeadersFrame);
        releaseBuffer();
    }
}
