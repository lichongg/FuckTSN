package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2HuffmanStageEncoder {
    private static final int HUFFMAN_HIGH_SYMBOL_COST = 15;
    private final int[][] huffmanCodeLengths;
    private final int[][] huffmanMergedCodeSymbols;
    private final int mtfAlphabetSize;
    private final char[] mtfBlock;
    private final int mtfLength;
    private final int[] mtfSymbolFrequencies;
    private final byte[] selectors;
    private final Bzip2BitWriter writer;

    private void assignHuffmanCodeSymbols() {
        int[][] iArr = this.huffmanMergedCodeSymbols;
        int[][] iArr2 = this.huffmanCodeLengths;
        int i6 = this.mtfAlphabetSize;
        int length = iArr2.length;
        for (int i7 = 0; i7 < length; i7++) {
            int[] iArr3 = iArr2[i7];
            int i8 = 32;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = iArr3[i10];
                if (i11 > i9) {
                    i9 = i11;
                }
                if (i11 < i8) {
                    i8 = i11;
                }
            }
            int i12 = 0;
            while (i8 <= i9) {
                for (int i13 = 0; i13 < i6; i13++) {
                    if ((iArr2[i7][i13] & 255) == i8) {
                        iArr[i7][i13] = (i8 << 24) | i12;
                        i12++;
                    }
                }
                i12 <<= 1;
                i8++;
            }
        }
    }

    private static void generateHuffmanCodeLengths(int i6, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[i6];
        int[] iArr4 = new int[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            iArr3[i7] = (iArr[i7] << 9) | i7;
        }
        Arrays.sort(iArr3);
        for (int i8 = 0; i8 < i6; i8++) {
            iArr4[i8] = iArr3[i8] >>> 9;
        }
        Bzip2HuffmanAllocator.allocateHuffmanCodeLengths(iArr4, 20);
        for (int i9 = 0; i9 < i6; i9++) {
            iArr2[iArr3[i9] & 511] = iArr4[i9];
        }
    }

    private void generateHuffmanOptimisationSeeds() {
        int[][] iArr = this.huffmanCodeLengths;
        int[] iArr2 = this.mtfSymbolFrequencies;
        int i6 = this.mtfAlphabetSize;
        int length = iArr.length;
        int i7 = this.mtfLength;
        int i8 = -1;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = length - i9;
            int i11 = i7 / i10;
            int i12 = i8 + 1;
            int i13 = 0;
            while (i13 < i11 && i8 < i6 - 1) {
                i8++;
                i13 += iArr2[i8];
            }
            if (i8 > i12 && i9 != 0 && i9 != length - 1 && (i10 & 1) == 0) {
                i13 -= iArr2[i8];
                i8--;
            }
            int[] iArr3 = iArr[i9];
            for (int i14 = 0; i14 < i6; i14++) {
                if (i14 < i12 || i14 > i8) {
                    iArr3[i14] = 15;
                }
            }
            i7 -= i13;
        }
    }

    private void optimiseSelectorsAndHuffmanTables(boolean z5) {
        char[] cArr = this.mtfBlock;
        byte[] bArr = this.selectors;
        int[][] iArr = this.huffmanCodeLengths;
        int i6 = this.mtfLength;
        int i7 = this.mtfAlphabetSize;
        int length = iArr.length;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, i7);
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int min = Math.min(i8 + 50, i6);
            int i10 = min - 1;
            short[] sArr = new short[length];
            for (int i11 = i8; i11 <= i10; i11++) {
                char c6 = cArr[i11];
                for (int i12 = 0; i12 < length; i12++) {
                    sArr[i12] = (short) (sArr[i12] + iArr[i12][c6]);
                }
            }
            short s5 = sArr[0];
            byte b6 = 0;
            for (byte b7 = 1; b7 < length; b7 = (byte) (b7 + 1)) {
                short s6 = sArr[b7];
                if (s6 < s5) {
                    s5 = s6;
                    b6 = b7;
                }
            }
            int[] iArr3 = iArr2[b6];
            while (i8 <= i10) {
                char c7 = cArr[i8];
                iArr3[c7] = iArr3[c7] + 1;
                i8++;
            }
            if (z5) {
                bArr[i9] = b6;
                i9++;
            }
            i8 = min;
        }
        for (int i13 = 0; i13 < length; i13++) {
            generateHuffmanCodeLengths(i7, iArr2[i13], iArr[i13]);
        }
    }

    private static int selectTableCount(int i6) {
        if (i6 >= 2400) {
            return 6;
        }
        if (i6 >= 1200) {
            return 5;
        }
        if (i6 >= 600) {
            return 4;
        }
        return i6 >= 200 ? 3 : 2;
    }

    private void writeBlockData(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        int[][] iArr = this.huffmanMergedCodeSymbols;
        byte[] bArr = this.selectors;
        char[] cArr = this.mtfBlock;
        int i6 = this.mtfLength;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i6) {
            int min = Math.min(i7 + 50, i6) - 1;
            int i9 = i8 + 1;
            int[] iArr2 = iArr[bArr[i8]];
            while (i7 <= min) {
                int i10 = i7 + 1;
                int i11 = iArr2[cArr[i7]];
                bzip2BitWriter.writeBits(byteBuf, i11 >>> 24, i11);
                i7 = i10;
            }
            i8 = i9;
        }
    }

    private void writeSelectorsAndHuffmanTables(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        byte[] bArr = this.selectors;
        int length = bArr.length;
        int[][] iArr = this.huffmanCodeLengths;
        int length2 = iArr.length;
        int i6 = this.mtfAlphabetSize;
        bzip2BitWriter.writeBits(byteBuf, 3, length2);
        bzip2BitWriter.writeBits(byteBuf, 15, length);
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        for (byte b6 : bArr) {
            bzip2BitWriter.writeUnary(byteBuf, bzip2MoveToFrontTable.valueToFront(b6));
        }
        for (int[] iArr2 : iArr) {
            int i7 = iArr2[0];
            bzip2BitWriter.writeBits(byteBuf, 5, i7);
            int i8 = 0;
            while (i8 < i6) {
                int i9 = iArr2[i8];
                int i10 = i7 < i9 ? 2 : 3;
                int abs = Math.abs(i9 - i7);
                while (true) {
                    int i11 = abs - 1;
                    if (abs > 0) {
                        bzip2BitWriter.writeBits(byteBuf, 2, i10);
                        i6 = i6;
                        abs = i11;
                    }
                }
                bzip2BitWriter.writeBoolean(byteBuf, false);
                i8++;
                i7 = i9;
            }
        }
    }

    Bzip2HuffmanStageEncoder(Bzip2BitWriter bzip2BitWriter, char[] cArr, int i6, int i7, int[] iArr) {
        this.writer = bzip2BitWriter;
        this.mtfBlock = cArr;
        this.mtfLength = i6;
        this.mtfAlphabetSize = i7;
        this.mtfSymbolFrequencies = iArr;
        int selectTableCount = selectTableCount(i6);
        Class cls = Integer.TYPE;
        this.huffmanCodeLengths = (int[][]) Array.newInstance((Class<?>) cls, selectTableCount, i7);
        this.huffmanMergedCodeSymbols = (int[][]) Array.newInstance((Class<?>) cls, selectTableCount, i7);
        this.selectors = new byte[(i6 + 49) / 50];
    }

    void encode(ByteBuf byteBuf) {
        boolean z5;
        generateHuffmanOptimisationSeeds();
        for (int i6 = 3; i6 >= 0; i6--) {
            if (i6 == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            optimiseSelectorsAndHuffmanTables(z5);
        }
        assignHuffmanCodeSymbols();
        writeSelectorsAndHuffmanTables(byteBuf);
        writeBlockData(byteBuf);
    }
}
