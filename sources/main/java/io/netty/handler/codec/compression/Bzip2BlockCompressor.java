package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2BlockCompressor {
    private final byte[] block;
    private int blockLength;
    private final int blockLengthLimit;
    private final int[] bwtBlock;
    private int rleLength;
    private final Bzip2BitWriter writer;
    private final ByteProcessor writeProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.Bzip2BlockCompressor.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return Bzip2BlockCompressor.this.write(b6);
        }
    };
    private final Crc32 crc = new Crc32();
    private final boolean[] blockValuesPresent = new boolean[256];
    private int rleCurrentValue = -1;

    boolean write(int i6) {
        if (this.blockLength > this.blockLengthLimit) {
            return false;
        }
        int i7 = this.rleCurrentValue;
        int i8 = this.rleLength;
        if (i8 == 0) {
            this.rleCurrentValue = i6;
            this.rleLength = 1;
        } else if (i7 != i6) {
            writeRun(i7 & 255, i8);
            this.rleCurrentValue = i6;
            this.rleLength = 1;
        } else if (i8 == 254) {
            writeRun(i7 & 255, 255);
            this.rleLength = 0;
        } else {
            this.rleLength = i8 + 1;
        }
        return true;
    }

    private void writeRun(int i6, int i7) {
        int i8 = this.blockLength;
        byte[] bArr = this.block;
        this.blockValuesPresent[i6] = true;
        this.crc.updateCRC(i6, i7);
        byte b6 = (byte) i6;
        if (i7 == 1) {
            bArr[i8] = b6;
            this.blockLength = i8 + 1;
            return;
        }
        if (i7 == 2) {
            bArr[i8] = b6;
            bArr[i8 + 1] = b6;
            this.blockLength = i8 + 2;
        } else {
            if (i7 == 3) {
                bArr[i8] = b6;
                bArr[i8 + 1] = b6;
                bArr[i8 + 2] = b6;
                this.blockLength = i8 + 3;
                return;
            }
            int i9 = i7 - 4;
            this.blockValuesPresent[i9] = true;
            bArr[i8] = b6;
            bArr[i8 + 1] = b6;
            bArr[i8 + 2] = b6;
            bArr[i8 + 3] = b6;
            bArr[i8 + 4] = (byte) i9;
            this.blockLength = i8 + 5;
        }
    }

    private void writeSymbolMap(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        boolean[] zArr = this.blockValuesPresent;
        boolean[] zArr2 = new boolean[16];
        for (int i6 = 0; i6 < 16; i6++) {
            int i7 = i6 << 4;
            int i8 = 0;
            while (i8 < 16) {
                if (zArr[i7]) {
                    zArr2[i6] = true;
                }
                i8++;
                i7++;
            }
        }
        for (int i9 = 0; i9 < 16; i9++) {
            bzip2BitWriter.writeBoolean(byteBuf, zArr2[i9]);
        }
        for (int i10 = 0; i10 < 16; i10++) {
            if (zArr2[i10]) {
                int i11 = i10 << 4;
                int i12 = 0;
                while (i12 < 16) {
                    bzip2BitWriter.writeBoolean(byteBuf, zArr[i11]);
                    i12++;
                    i11++;
                }
            }
        }
    }

    int availableSize() {
        int i6 = this.blockLength;
        return i6 == 0 ? this.blockLengthLimit + 2 : (this.blockLengthLimit - i6) + 1;
    }

    void close(ByteBuf byteBuf) {
        int i6 = this.rleLength;
        if (i6 > 0) {
            writeRun(this.rleCurrentValue & 255, i6);
        }
        byte[] bArr = this.block;
        bArr[this.blockLength] = bArr[0];
        int bwt = new Bzip2DivSufSort(this.block, this.bwtBlock, this.blockLength).bwt();
        Bzip2BitWriter bzip2BitWriter = this.writer;
        bzip2BitWriter.writeBits(byteBuf, 24, 3227993L);
        bzip2BitWriter.writeBits(byteBuf, 24, 2511705L);
        bzip2BitWriter.writeInt(byteBuf, this.crc.getCRC());
        bzip2BitWriter.writeBoolean(byteBuf, false);
        bzip2BitWriter.writeBits(byteBuf, 24, bwt);
        writeSymbolMap(byteBuf);
        Bzip2MTFAndRLE2StageEncoder bzip2MTFAndRLE2StageEncoder = new Bzip2MTFAndRLE2StageEncoder(this.bwtBlock, this.blockLength, this.blockValuesPresent);
        bzip2MTFAndRLE2StageEncoder.encode();
        new Bzip2HuffmanStageEncoder(bzip2BitWriter, bzip2MTFAndRLE2StageEncoder.mtfBlock(), bzip2MTFAndRLE2StageEncoder.mtfLength(), bzip2MTFAndRLE2StageEncoder.mtfAlphabetSize(), bzip2MTFAndRLE2StageEncoder.mtfSymbolFrequencies()).encode(byteBuf);
    }

    int crc() {
        return this.crc.getCRC();
    }

    boolean isEmpty() {
        return this.blockLength == 0 && this.rleLength == 0;
    }

    boolean isFull() {
        return this.blockLength > this.blockLengthLimit;
    }

    Bzip2BlockCompressor(Bzip2BitWriter bzip2BitWriter, int i6) {
        this.writer = bzip2BitWriter;
        int i7 = i6 + 1;
        this.block = new byte[i7];
        this.bwtBlock = new int[i7];
        this.blockLengthLimit = i6 - 6;
    }

    int write(ByteBuf byteBuf, int i6, int i7) {
        int forEachByte = byteBuf.forEachByte(i6, i7, this.writeProcessor);
        return forEachByte == -1 ? i7 : forEachByte - i6;
    }
}
