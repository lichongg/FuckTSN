package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class HpackHuffmanEncoder {
    private final int[] codes;
    private final EncodeProcessor encodeProcessor;
    private final EncodedLengthProcessor encodedLengthProcessor;
    private final byte[] lengths;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http2.HpackHuffmanEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EncodeProcessor implements ByteProcessor {
        private long current;

        /* renamed from: n, reason: collision with root package name */
        private int f43070n;
        ByteBuf out;

        private EncodeProcessor() {
        }

        void end() {
            try {
                int i6 = this.f43070n;
                if (i6 > 0) {
                    long j6 = (this.current << (8 - i6)) | (255 >>> i6);
                    this.current = j6;
                    this.out.writeByte((int) j6);
                }
            } finally {
                this.out = null;
                this.current = 0L;
                this.f43070n = 0;
            }
        }

        /* synthetic */ EncodeProcessor(HpackHuffmanEncoder hpackHuffmanEncoder, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) {
            byte b7 = HpackHuffmanEncoder.this.lengths[b6 & 255];
            long j6 = this.current << b7;
            this.current = j6;
            this.current = j6 | HpackHuffmanEncoder.this.codes[r6];
            this.f43070n += b7;
            while (true) {
                int i6 = this.f43070n;
                if (i6 < 8) {
                    return true;
                }
                int i7 = i6 - 8;
                this.f43070n = i7;
                this.out.writeByte((int) (this.current >> i7));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class EncodedLengthProcessor implements ByteProcessor {
        private long len;

        private EncodedLengthProcessor() {
        }

        /* synthetic */ EncodedLengthProcessor(HpackHuffmanEncoder hpackHuffmanEncoder, AnonymousClass1 anonymousClass1) {
            this();
        }

        int length() {
            return (int) ((this.len + 7) >> 3);
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) {
            this.len += HpackHuffmanEncoder.this.lengths[b6 & 255];
            return true;
        }

        void reset() {
            this.len = 0L;
        }
    }

    HpackHuffmanEncoder() {
        this(HpackUtil.HUFFMAN_CODES, HpackUtil.HUFFMAN_CODE_LENGTHS);
    }

    private HpackHuffmanEncoder(int[] iArr, byte[] bArr) {
        AnonymousClass1 anonymousClass1 = null;
        this.encodedLengthProcessor = new EncodedLengthProcessor(this, anonymousClass1);
        this.encodeProcessor = new EncodeProcessor(this, anonymousClass1);
        this.codes = iArr;
        this.lengths = bArr;
    }

    private void encodeSlowPath(ByteBuf byteBuf, CharSequence charSequence) {
        long j6 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            int charAt = charSequence.charAt(i7) & 255;
            int i8 = this.codes[charAt];
            byte b6 = this.lengths[charAt];
            j6 = (j6 << b6) | i8;
            i6 += b6;
            while (i6 >= 8) {
                i6 -= 8;
                byteBuf.writeByte((int) (j6 >> i6));
            }
        }
        if (i6 > 0) {
            byteBuf.writeByte((int) ((j6 << (8 - i6)) | (255 >>> i6)));
        }
    }

    private int getEncodedLengthSlowPath(CharSequence charSequence) {
        long j6 = 0;
        for (int i6 = 0; i6 < charSequence.length(); i6++) {
            j6 += this.lengths[charSequence.charAt(i6) & 255];
        }
        return (int) ((j6 + 7) >> 3);
    }

    public void encode(ByteBuf byteBuf, CharSequence charSequence) {
        ObjectUtil.checkNotNull(byteBuf, "out");
        if (!(charSequence instanceof AsciiString)) {
            encodeSlowPath(byteBuf, charSequence);
            return;
        }
        AsciiString asciiString = (AsciiString) charSequence;
        try {
            try {
                EncodeProcessor encodeProcessor = this.encodeProcessor;
                encodeProcessor.out = byteBuf;
                asciiString.forEachByte(encodeProcessor);
            } catch (Exception e6) {
                PlatformDependent.throwException(e6);
            }
        } finally {
            this.encodeProcessor.end();
        }
    }

    int getEncodedLength(CharSequence charSequence) {
        if (!(charSequence instanceof AsciiString)) {
            return getEncodedLengthSlowPath(charSequence);
        }
        AsciiString asciiString = (AsciiString) charSequence;
        try {
            this.encodedLengthProcessor.reset();
            asciiString.forEachByte(this.encodedLengthProcessor);
            return this.encodedLengthProcessor.length();
        } catch (Exception e6) {
            PlatformDependent.throwException(e6);
            return -1;
        }
    }
}
