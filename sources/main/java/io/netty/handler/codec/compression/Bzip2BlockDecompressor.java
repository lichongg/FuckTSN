package io.netty.handler.codec.compression;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2BlockDecompressor {
    private final int blockCRC;
    private final boolean blockRandomised;
    private final byte[] bwtBlock;
    private int bwtBlockLength;
    private int bwtBytesDecoded;
    private int bwtCurrentMergedPointer;
    private int[] bwtMergedPointers;
    private final int bwtStartPointer;
    int huffmanEndOfBlockSymbol;
    int huffmanInUse16;
    private int mtfValue;
    private int randomIndex;
    private final Bzip2BitReader reader;
    private int repeatCount;
    private int rleAccumulator;
    private int rleRepeat;
    private final Crc32 crc = new Crc32();
    final byte[] huffmanSymbolMap = new byte[256];
    private final int[] bwtByteCounts = new int[256];
    private int rleLastDecodedByte = -1;
    private int randomCount = Bzip2Rand.rNums(0) - 1;
    private final Bzip2MoveToFrontTable symbolMTF = new Bzip2MoveToFrontTable();
    private int repeatIncrement = 1;

    private int decodeNextBWTByte() {
        int i6 = this.bwtCurrentMergedPointer;
        int i7 = i6 & 255;
        this.bwtCurrentMergedPointer = this.bwtMergedPointers[i6 >>> 8];
        if (this.blockRandomised) {
            int i8 = this.randomCount - 1;
            this.randomCount = i8;
            if (i8 == 0) {
                i7 ^= 1;
                int i9 = (this.randomIndex + 1) % 512;
                this.randomIndex = i9;
                this.randomCount = Bzip2Rand.rNums(i9);
            }
        }
        this.bwtBytesDecoded++;
        return i7;
    }

    private void initialiseInverseBWT() {
        int i6 = this.bwtStartPointer;
        byte[] bArr = this.bwtBlock;
        int i7 = this.bwtBlockLength;
        int[] iArr = new int[i7];
        int[] iArr2 = new int[256];
        if (i6 < 0 || i6 >= i7) {
            throw new DecompressionException("start pointer invalid");
        }
        System.arraycopy(this.bwtByteCounts, 0, iArr2, 1, 255);
        for (int i8 = 2; i8 <= 255; i8++) {
            iArr2[i8] = iArr2[i8] + iArr2[i8 - 1];
        }
        for (int i9 = 0; i9 < this.bwtBlockLength; i9++) {
            int i10 = bArr[i9] & 255;
            int i11 = iArr2[i10];
            iArr2[i10] = i11 + 1;
            iArr[i11] = (i9 << 8) + i10;
        }
        this.bwtMergedPointers = iArr;
        this.bwtCurrentMergedPointer = iArr[i6];
    }

    public int blockLength() {
        return this.bwtBlockLength;
    }

    int checkCRC() {
        int crc = this.crc.getCRC();
        if (this.blockCRC == crc) {
            return crc;
        }
        throw new DecompressionException("block CRC error");
    }

    boolean decodeHuffmanData(Bzip2HuffmanStageDecoder bzip2HuffmanStageDecoder) {
        Bzip2BitReader bzip2BitReader = this.reader;
        byte[] bArr = this.bwtBlock;
        byte[] bArr2 = this.huffmanSymbolMap;
        int length = bArr.length;
        int i6 = this.huffmanEndOfBlockSymbol;
        int[] iArr = this.bwtByteCounts;
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = this.symbolMTF;
        int i7 = this.bwtBlockLength;
        int i8 = this.repeatCount;
        int i9 = this.repeatIncrement;
        int i10 = this.mtfValue;
        while (bzip2BitReader.hasReadableBits(23)) {
            int nextSymbol = bzip2HuffmanStageDecoder.nextSymbol();
            if (nextSymbol == 0) {
                i8 += i9;
                i9 <<= 1;
            } else if (nextSymbol == 1) {
                i9 <<= 1;
                i8 += i9;
            } else {
                if (i8 > 0) {
                    if (i7 + i8 > length) {
                        throw new DecompressionException("block exceeds declared block size");
                    }
                    byte b6 = bArr2[i10];
                    int i11 = b6 & 255;
                    iArr[i11] = iArr[i11] + i8;
                    while (true) {
                        i8--;
                        if (i8 < 0) {
                            break;
                        }
                        bArr[i7] = b6;
                        i7++;
                    }
                    i8 = 0;
                    i9 = 1;
                }
                if (nextSymbol == i6) {
                    this.bwtBlockLength = i7;
                    initialiseInverseBWT();
                    return true;
                }
                if (i7 >= length) {
                    throw new DecompressionException("block exceeds declared block size");
                }
                i10 = bzip2MoveToFrontTable.indexToFront(nextSymbol - 1) & 255;
                byte b7 = bArr2[i10];
                int i12 = b7 & 255;
                iArr[i12] = iArr[i12] + 1;
                bArr[i7] = b7;
                i7++;
            }
        }
        this.bwtBlockLength = i7;
        this.repeatCount = i8;
        this.repeatIncrement = i9;
        this.mtfValue = i10;
        return false;
    }

    public int read() {
        while (true) {
            int i6 = this.rleRepeat;
            if (i6 >= 1) {
                this.rleRepeat = i6 - 1;
                return this.rleLastDecodedByte;
            }
            if (this.bwtBytesDecoded == this.bwtBlockLength) {
                return -1;
            }
            int decodeNextBWTByte = decodeNextBWTByte();
            if (decodeNextBWTByte != this.rleLastDecodedByte) {
                this.rleLastDecodedByte = decodeNextBWTByte;
                this.rleRepeat = 1;
                this.rleAccumulator = 1;
                this.crc.updateCRC(decodeNextBWTByte);
            } else {
                int i7 = this.rleAccumulator + 1;
                this.rleAccumulator = i7;
                if (i7 == 4) {
                    int decodeNextBWTByte2 = decodeNextBWTByte() + 1;
                    this.rleRepeat = decodeNextBWTByte2;
                    this.rleAccumulator = 0;
                    this.crc.updateCRC(decodeNextBWTByte, decodeNextBWTByte2);
                } else {
                    this.rleRepeat = 1;
                    this.crc.updateCRC(decodeNextBWTByte);
                }
            }
        }
    }

    Bzip2BlockDecompressor(int i6, int i7, boolean z5, int i8, Bzip2BitReader bzip2BitReader) {
        this.bwtBlock = new byte[i6];
        this.blockCRC = i7;
        this.blockRandomised = z5;
        this.bwtStartPointer = i8;
        this.reader = bzip2BitReader;
    }
}
