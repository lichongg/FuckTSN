package io.netty.handler.codec.compression;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2HuffmanStageDecoder {
    final int alphabetSize;
    private final int[][] codeBases;
    private final int[][] codeLimits;
    private final int[][] codeSymbols;
    int currentAlpha;
    int currentGroup;
    int currentSelector;
    private int currentTable;
    private final int[] minimumLengths;
    boolean modifyLength;
    private final Bzip2BitReader reader;
    byte[] selectors;
    final byte[][] tableCodeLengths;
    final int totalTables;
    private int groupIndex = -1;
    private int groupPosition = -1;
    final Bzip2MoveToFrontTable tableMTF = new Bzip2MoveToFrontTable();
    int currentLength = -1;

    void createHuffmanDecodingTables() {
        int i6 = this.alphabetSize;
        int i7 = 0;
        while (true) {
            byte[][] bArr = this.tableCodeLengths;
            if (i7 >= bArr.length) {
                this.currentTable = this.selectors[0];
                return;
            }
            int[] iArr = this.codeBases[i7];
            int[] iArr2 = this.codeLimits[i7];
            int[] iArr3 = this.codeSymbols[i7];
            byte[] bArr2 = bArr[i7];
            int i8 = 23;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                byte b6 = bArr2[i10];
                i9 = Math.max((int) b6, i9);
                i8 = Math.min((int) b6, i8);
            }
            this.minimumLengths[i7] = i8;
            for (int i11 = 0; i11 < i6; i11++) {
                int i12 = bArr2[i11] + 1;
                iArr[i12] = iArr[i12] + 1;
            }
            int i13 = iArr[0];
            for (int i14 = 1; i14 < 25; i14++) {
                i13 += iArr[i14];
                iArr[i14] = i13;
            }
            int i15 = i8;
            int i16 = 0;
            while (i15 <= i9) {
                int i17 = i15 + 1;
                int i18 = iArr[i17];
                int i19 = iArr[i15];
                int i20 = (i18 - i19) + i16;
                iArr[i15] = i16 - i19;
                iArr2[i15] = i20 - 1;
                i16 = i20 << 1;
                i15 = i17;
            }
            int i21 = 0;
            while (i8 <= i9) {
                for (int i22 = 0; i22 < i6; i22++) {
                    if (bArr2[i22] == i8) {
                        iArr3[i21] = i22;
                        i21++;
                    }
                }
                i8++;
            }
            i7++;
        }
    }

    int nextSymbol() {
        int i6 = this.groupPosition + 1;
        this.groupPosition = i6;
        if (i6 % 50 == 0) {
            int i7 = this.groupIndex + 1;
            this.groupIndex = i7;
            byte[] bArr = this.selectors;
            if (i7 == bArr.length) {
                throw new DecompressionException("error decoding block");
            }
            this.currentTable = bArr[i7] & 255;
        }
        Bzip2BitReader bzip2BitReader = this.reader;
        int i8 = this.currentTable;
        int[] iArr = this.codeLimits[i8];
        int[] iArr2 = this.codeBases[i8];
        int[] iArr3 = this.codeSymbols[i8];
        int i9 = this.minimumLengths[i8];
        int readBits = bzip2BitReader.readBits(i9);
        while (i9 <= 23) {
            if (readBits <= iArr[i9]) {
                return iArr3[readBits - iArr2[i9]];
            }
            readBits = (readBits << 1) | bzip2BitReader.readBits(1);
            i9++;
        }
        throw new DecompressionException("a valid code was not recognised");
    }

    Bzip2HuffmanStageDecoder(Bzip2BitReader bzip2BitReader, int i6, int i7) {
        this.reader = bzip2BitReader;
        this.totalTables = i6;
        this.alphabetSize = i7;
        this.minimumLengths = new int[i6];
        Class cls = Integer.TYPE;
        this.codeBases = (int[][]) Array.newInstance((Class<?>) cls, i6, 25);
        this.codeLimits = (int[][]) Array.newInstance((Class<?>) cls, i6, 24);
        this.codeSymbols = (int[][]) Array.newInstance((Class<?>) cls, i6, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE);
        this.tableCodeLengths = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i6, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE);
    }
}
