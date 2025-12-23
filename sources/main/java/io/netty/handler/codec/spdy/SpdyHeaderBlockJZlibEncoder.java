package io.netty.handler.codec.spdy;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class SpdyHeaderBlockJZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private boolean finished;

    /* renamed from: z, reason: collision with root package name */
    private final Deflater f43081z;

    private ByteBuf encode(ByteBufAllocator byteBufAllocator) {
        ByteBuf byteBuf;
        try {
            int i6 = this.f43081z.next_in_index;
            int i7 = this.f43081z.next_out_index;
            int ceil = ((int) Math.ceil(this.f43081z.next_in.length * 1.001d)) + 12;
            byteBuf = byteBufAllocator.heapBuffer(ceil);
            try {
                this.f43081z.next_out = byteBuf.array();
                this.f43081z.next_out_index = byteBuf.arrayOffset() + byteBuf.writerIndex();
                this.f43081z.avail_out = ceil;
                try {
                    int deflate = this.f43081z.deflate(2);
                    if (deflate != 0) {
                        throw new CompressionException("compression failure: " + deflate);
                    }
                    int i8 = this.f43081z.next_out_index - i7;
                    if (i8 > 0) {
                        byteBuf.writerIndex(byteBuf.writerIndex() + i8);
                    }
                    this.f43081z.next_in = null;
                    this.f43081z.next_out = null;
                    return byteBuf;
                } finally {
                    byteBuf.skipBytes(this.f43081z.next_in_index - i6);
                }
            } catch (Throwable th) {
                th = th;
                this.f43081z.next_in = null;
                this.f43081z.next_out = null;
                if (byteBuf != null) {
                    byteBuf.release();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteBuf = null;
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.f43081z.deflateEnd();
        this.f43081z.next_in = null;
        this.f43081z.next_out = null;
    }

    SpdyHeaderBlockJZlibEncoder(SpdyVersion spdyVersion, int i6, int i7, int i8) {
        super(spdyVersion);
        Deflater deflater = new Deflater();
        this.f43081z = deflater;
        if (i6 >= 0 && i6 <= 9) {
            if (i7 >= 9 && i7 <= 15) {
                if (i8 >= 1 && i8 <= 9) {
                    int deflateInit = deflater.deflateInit(i6, i7, i8, JZlib.W_ZLIB);
                    if (deflateInit == 0) {
                        byte[] bArr = SpdyCodecUtil.SPDY_DICT;
                        int deflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
                        if (deflateSetDictionary == 0) {
                            return;
                        }
                        throw new CompressionException("failed to set the SPDY dictionary: " + deflateSetDictionary);
                    }
                    throw new CompressionException("failed to initialize an SPDY header block deflater: " + deflateInit);
                }
                throw new IllegalArgumentException("memLevel: " + i8 + " (expected: 1-9)");
            }
            throw new IllegalArgumentException("windowBits: " + i7 + " (expected: 9-15)");
        }
        throw new IllegalArgumentException("compressionLevel: " + i6 + " (expected: 0-9)");
    }

    private void setInput(ByteBuf byteBuf) {
        byte[] bArr;
        int i6;
        int readableBytes = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArr = byteBuf.array();
            i6 = byteBuf.arrayOffset() + byteBuf.readerIndex();
        } else {
            bArr = new byte[readableBytes];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            i6 = 0;
        }
        this.f43081z.next_in = bArr;
        this.f43081z.next_in_index = i6;
        this.f43081z.avail_in = readableBytes;
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
                setInput(encode);
                return encode(byteBufAllocator);
            } finally {
                encode.release();
            }
        }
        throw new IllegalArgumentException("frame");
    }
}
