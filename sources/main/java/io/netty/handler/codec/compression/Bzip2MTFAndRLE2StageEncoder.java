package io.netty.handler.codec.compression;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2MTFAndRLE2StageEncoder {
    private int alphabetSize;
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE];

    void encode() {
        int i6;
        int i7;
        int i8;
        int i9 = this.bwtLength;
        boolean[] zArr = this.bwtValuesPresent;
        int[] iArr = this.bwtBlock;
        char[] cArr = this.mtfBlock;
        int[] iArr2 = this.mtfSymbolFrequencies;
        byte[] bArr = new byte[256];
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (zArr[i11]) {
                bArr[i11] = (byte) i10;
                i10++;
            }
        }
        int i12 = i10 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < i9; i17++) {
            int valueToFront = bzip2MoveToFrontTable.valueToFront(bArr[iArr[i17] & 255]);
            if (valueToFront == 0) {
                i13++;
            } else {
                if (i13 > 0) {
                    int i18 = i13 - 1;
                    while (true) {
                        if ((i18 & 1) == 0) {
                            i8 = i14 + 1;
                            cArr[i14] = 0;
                            i15++;
                        } else {
                            i8 = i14 + 1;
                            cArr[i14] = 1;
                            i16++;
                        }
                        i14 = i8;
                        if (i18 <= 1) {
                            break;
                        } else {
                            i18 = (i18 - 2) >>> 1;
                        }
                    }
                    i13 = 0;
                }
                int i19 = valueToFront + 1;
                cArr[i14] = (char) i19;
                iArr2[i19] = iArr2[i19] + 1;
                i14++;
            }
        }
        char c6 = 1;
        if (i13 > 0) {
            int i20 = i13 - 1;
            while (true) {
                if ((i20 & 1) == 0) {
                    i7 = i14 + 1;
                    cArr[i14] = 0;
                    i15++;
                } else {
                    i7 = i14 + 1;
                    cArr[i14] = c6;
                    i16++;
                }
                i14 = i7;
                i6 = 1;
                if (i20 <= 1) {
                    break;
                }
                i20 = (i20 - 2) >>> 1;
                c6 = 1;
            }
        } else {
            i6 = 1;
        }
        cArr[i14] = (char) i12;
        iArr2[i12] = iArr2[i12] + i6;
        iArr2[0] = iArr2[0] + i15;
        iArr2[i6] = iArr2[i6] + i16;
        this.mtfLength = i14 + i6;
        this.alphabetSize = i10 + 2;
    }

    int mtfAlphabetSize() {
        return this.alphabetSize;
    }

    char[] mtfBlock() {
        return this.mtfBlock;
    }

    int mtfLength() {
        return this.mtfLength;
    }

    int[] mtfSymbolFrequencies() {
        return this.mtfSymbolFrequencies;
    }

    Bzip2MTFAndRLE2StageEncoder(int[] iArr, int i6, boolean[] zArr) {
        this.bwtBlock = iArr;
        this.bwtLength = i6;
        this.bwtValuesPresent = zArr;
        this.mtfBlock = new char[i6 + 1];
    }
}
