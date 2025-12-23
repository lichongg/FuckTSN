package io.netty.handler.codec.compression;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;
    private final int[] SA;
    private final byte[] T;

    /* renamed from: n, reason: collision with root package name */
    private final int f43061n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TRBudget {
        int budget;
        int chance;

        boolean update(int i6, int i7) {
            int i8 = this.budget - i7;
            this.budget = i8;
            if (i8 <= 0) {
                int i9 = this.chance - 1;
                this.chance = i9;
                if (i9 == 0) {
                    return false;
                }
                this.budget = i8 + i6;
            }
            return true;
        }

        TRBudget(int i6, int i7) {
            this.budget = i6;
            this.chance = i7;
        }
    }

    private void lsIntroSort(int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int[] iArr = bzip2DivSufSort.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int trLog = trLog(i10 - i9);
        int i15 = i9;
        int i16 = i10;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = i16 - i15;
            if (i19 <= 8) {
                if (1 < i19) {
                    bzip2DivSufSort.trInsertionSort(i6, i7, i8, i15, i16);
                    bzip2DivSufSort.lsUpdateGroup(i6, i15, i16);
                } else if (i19 == 1) {
                    iArr[i15] = -1;
                }
                if (i17 == 0) {
                    return;
                }
                i17--;
                StackEntry stackEntry = stackEntryArr[i17];
                i15 = stackEntry.f43062a;
                i16 = stackEntry.f43063b;
                trLog = stackEntry.f43064c;
            } else {
                int i20 = i16;
                int i21 = trLog - 1;
                if (trLog == 0) {
                    bzip2DivSufSort.trHeapSort(i6, i7, i8, i15, i19);
                    int i22 = i20 - 1;
                    while (i15 < i22) {
                        i18 = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i22]);
                        i22--;
                        while (i15 <= i22 && bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i22]) == i18) {
                            iArr[i22] = ~iArr[i22];
                            i22--;
                        }
                    }
                    bzip2DivSufSort.lsUpdateGroup(i6, i15, i20);
                    if (i17 == 0) {
                        return;
                    }
                    i17--;
                    StackEntry stackEntry2 = stackEntryArr[i17];
                    int i23 = stackEntry2.f43062a;
                    int i24 = stackEntry2.f43063b;
                    trLog = stackEntry2.f43064c;
                    i15 = i23;
                    i16 = i24;
                } else {
                    i16 = i20;
                    swapElements(iArr, i15, iArr, bzip2DivSufSort.trPivot(i6, i7, i8, i15, i16));
                    int trGetC = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i15]);
                    int i25 = i15 + 1;
                    while (i25 < i16) {
                        i18 = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i25]);
                        if (i18 != trGetC) {
                            break;
                        } else {
                            i25++;
                        }
                    }
                    if (i25 < i16 && i18 < trGetC) {
                        i12 = i25;
                        i11 = -1;
                        while (true) {
                            i25++;
                            if (i25 >= i16 || (i18 = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i25])) > trGetC) {
                                break;
                            } else if (i18 == trGetC) {
                                swapElements(iArr, i25, iArr, i12);
                                i12++;
                            }
                        }
                    } else {
                        i11 = -1;
                        i12 = i25;
                    }
                    int i26 = i16 - 1;
                    while (i25 < i26) {
                        i18 = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i26]);
                        if (i18 != trGetC) {
                            break;
                        } else {
                            i26--;
                        }
                    }
                    if (i25 < i26 && i18 > trGetC) {
                        int i27 = i18;
                        i14 = i26;
                        while (true) {
                            i26--;
                            if (i25 >= i26) {
                                i13 = i27;
                                break;
                            }
                            i13 = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i26]);
                            if (i13 < trGetC) {
                                break;
                            }
                            if (i13 == trGetC) {
                                swapElements(iArr, i26, iArr, i14);
                                i14--;
                            }
                            i27 = i13;
                        }
                    } else {
                        i13 = i18;
                        i14 = i26;
                    }
                    while (i25 < i26) {
                        swapElements(iArr, i25, iArr, i26);
                        while (true) {
                            i25++;
                            if (i25 >= i26 || (i13 = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i25])) > trGetC) {
                                break;
                            } else if (i13 == trGetC) {
                                swapElements(iArr, i25, iArr, i12);
                                i12++;
                            }
                        }
                        while (true) {
                            i26--;
                            if (i25 < i26 && (i13 = bzip2DivSufSort.trGetC(i6, i7, i8, iArr[i26])) >= trGetC) {
                                if (i13 == trGetC) {
                                    swapElements(iArr, i26, iArr, i14);
                                    i14--;
                                }
                            }
                        }
                    }
                    if (i12 <= i14) {
                        int i28 = i25 - 1;
                        int i29 = i12 - i15;
                        int i30 = i25 - i12;
                        if (i29 > i30) {
                            i29 = i30;
                        }
                        int i31 = i25 - i29;
                        int i32 = i29;
                        int i33 = i15;
                        while (i32 > 0) {
                            swapElements(iArr, i33, iArr, i31);
                            i32--;
                            i33++;
                            i31++;
                        }
                        int i34 = i14 - i28;
                        int i35 = (i16 - i14) - 1;
                        if (i34 <= i35) {
                            i35 = i34;
                        }
                        int i36 = i16 - i35;
                        while (i35 > 0) {
                            swapElements(iArr, i25, iArr, i36);
                            i35--;
                            i25++;
                            i36++;
                        }
                        int i37 = i15 + i30;
                        int i38 = i16 - i34;
                        int i39 = i37 - 1;
                        for (int i40 = i15; i40 < i37; i40++) {
                            iArr[iArr[i40] + i6] = i39;
                        }
                        if (i38 < i16) {
                            int i41 = i38 - 1;
                            for (int i42 = i37; i42 < i38; i42++) {
                                iArr[iArr[i42] + i6] = i41;
                            }
                        }
                        if (i38 - i37 == 1) {
                            iArr[i37] = i11;
                        }
                        if (i37 - i15 <= i16 - i38) {
                            if (i15 < i37) {
                                stackEntryArr[i17] = new StackEntry(i38, i16, i21, 0);
                                bzip2DivSufSort = this;
                                i16 = i37;
                                i17++;
                                i18 = i13;
                                trLog = i21;
                            } else {
                                i15 = i38;
                                i18 = i13;
                                trLog = i21;
                            }
                        } else if (i38 < i16) {
                            stackEntryArr[i17] = new StackEntry(i15, i37, i21, 0);
                            i15 = i38;
                            i17++;
                            i18 = i13;
                            trLog = i21;
                        } else {
                            bzip2DivSufSort = this;
                            i16 = i37;
                            i18 = i13;
                            trLog = i21;
                        }
                    } else {
                        if (i17 == 0) {
                            return;
                        }
                        i17--;
                        StackEntry stackEntry3 = stackEntryArr[i17];
                        i15 = stackEntry3.f43062a;
                        i16 = stackEntry3.f43063b;
                        trLog = stackEntry3.f43064c;
                        i18 = i13;
                    }
                    bzip2DivSufSort = this;
                }
            }
        }
    }

    private int sortTypeBstar(int[] iArr, int[] iArr2) {
        boolean z5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr3;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z6;
        int i20;
        byte[] bArr = this.T;
        int[] iArr4 = this.SA;
        int i21 = this.f43061n;
        int[] iArr5 = new int[256];
        int i22 = 1;
        while (true) {
            if (i22 >= i21) {
                break;
            }
            byte b6 = bArr[i22 - 1];
            byte b7 = bArr[i22];
            if (b6 == b7) {
                i22++;
            } else if ((b6 & 255) > (b7 & 255)) {
                z5 = false;
            }
        }
        z5 = true;
        int i23 = i21 - 1;
        byte b8 = bArr[i23];
        int i24 = b8 & 255;
        byte b9 = bArr[0];
        int i25 = b9 & 255;
        if (i24 < i25 || (b8 == b9 && z5)) {
            if (z5) {
                int BUCKET_B = BUCKET_B(i24, i25);
                iArr2[BUCKET_B] = iArr2[BUCKET_B] + 1;
                i6 = i21;
            } else {
                int BUCKET_BSTAR = BUCKET_BSTAR(i24, i25);
                iArr2[BUCKET_BSTAR] = iArr2[BUCKET_BSTAR] + 1;
                i6 = i21 - 1;
                iArr4[i6] = i23;
            }
            i7 = i21 - 2;
            while (i7 >= 0) {
                int i26 = bArr[i7] & 255;
                int i27 = bArr[i7 + 1] & 255;
                if (i26 <= i27) {
                    int BUCKET_B2 = BUCKET_B(i26, i27);
                    iArr2[BUCKET_B2] = iArr2[BUCKET_B2] + 1;
                    i7--;
                }
            }
        } else {
            i6 = i21;
            i7 = i23;
        }
        while (i7 >= 0) {
            while (true) {
                int i28 = bArr[i7] & 255;
                iArr[i28] = iArr[i28] + 1;
                i20 = i7 - 1;
                if (i20 < 0 || (bArr[i20] & 255) < (bArr[i7] & 255)) {
                    break;
                }
                i7 = i20;
            }
            if (i20 >= 0) {
                int BUCKET_BSTAR2 = BUCKET_BSTAR(bArr[i20] & 255, bArr[i7] & 255);
                iArr2[BUCKET_BSTAR2] = iArr2[BUCKET_BSTAR2] + 1;
                i6--;
                iArr4[i6] = i20;
                i7 -= 2;
                while (i7 >= 0) {
                    int i29 = bArr[i7] & 255;
                    int i30 = bArr[i7 + 1] & 255;
                    if (i29 <= i30) {
                        int BUCKET_B3 = BUCKET_B(i29, i30);
                        iArr2[BUCKET_B3] = iArr2[BUCKET_B3] + 1;
                        i7--;
                    }
                }
            } else {
                i7 = i20;
            }
        }
        int i31 = i21 - i6;
        if (i31 == 0) {
            for (int i32 = 0; i32 < i21; i32++) {
                iArr4[i32] = i32;
            }
            return 0;
        }
        int i33 = -1;
        int i34 = 0;
        int i35 = 0;
        while (i34 < 256) {
            int i36 = iArr[i34] + i33;
            iArr[i34] = i33 + i35;
            int i37 = i36 + iArr2[BUCKET_B(i34, i34)];
            int i38 = i34 + 1;
            for (int i39 = i38; i39 < 256; i39++) {
                i35 += iArr2[BUCKET_BSTAR(i34, i39)];
                iArr2[(i34 << 8) | i39] = i35;
                i37 += iArr2[BUCKET_B(i34, i39)];
            }
            i34 = i38;
            i33 = i37;
        }
        int i40 = i21 - i31;
        for (int i41 = i31 - 2; i41 >= 0; i41--) {
            int i42 = iArr4[i40 + i41];
            int BUCKET_BSTAR3 = BUCKET_BSTAR(bArr[i42] & 255, bArr[i42 + 1] & 255);
            int i43 = iArr2[BUCKET_BSTAR3] - 1;
            iArr2[BUCKET_BSTAR3] = i43;
            iArr4[i43] = i41;
        }
        int i44 = iArr4[(i40 + i31) - 1];
        int BUCKET_BSTAR4 = BUCKET_BSTAR(bArr[i44] & 255, bArr[i44 + 1] & 255);
        int i45 = iArr2[BUCKET_BSTAR4] - 1;
        iArr2[BUCKET_BSTAR4] = i45;
        int i46 = i31 - 1;
        iArr4[i45] = i46;
        int i47 = i21 - (i31 * 2);
        if (i47 <= 256) {
            i8 = 0;
            i47 = 256;
        } else {
            i8 = i31;
            iArr5 = iArr4;
        }
        int i48 = i31;
        int i49 = 255;
        while (i48 > 0) {
            int i50 = 255;
            while (i49 < i50) {
                int i51 = iArr2[BUCKET_BSTAR(i49, i50)];
                if (1 < i48 - i51) {
                    if (iArr4[i51] == i46) {
                        i19 = i49;
                        z6 = true;
                    } else {
                        i19 = i49;
                        z6 = false;
                    }
                    int i52 = i46;
                    i13 = i8;
                    i14 = i40;
                    iArr3 = iArr5;
                    i15 = i51;
                    i16 = i52;
                    i18 = i19;
                    i17 = i31;
                    subStringSort(i14, i15, i48, iArr3, i13, i47, 2, z6, i21);
                } else {
                    int i53 = i46;
                    i13 = i8;
                    i14 = i40;
                    iArr3 = iArr5;
                    i15 = i51;
                    i16 = i53;
                    i17 = i31;
                    i18 = i49;
                }
                i50--;
                i48 = i15;
                iArr5 = iArr3;
                i31 = i17;
                i49 = i18;
                i40 = i14;
                i8 = i13;
                i46 = i16;
            }
            i49--;
            i31 = i31;
            i40 = i40;
            i8 = i8;
            i46 = i46;
        }
        int i54 = i31;
        int i55 = i46;
        while (i46 >= 0) {
            if (iArr4[i46] >= 0) {
                int i56 = i46;
                while (true) {
                    iArr4[i54 + iArr4[i56]] = i56;
                    i12 = i56 - 1;
                    if (i12 < 0 || iArr4[i12] < 0) {
                        break;
                    }
                    i56 = i12;
                }
                iArr4[i56] = i12 - i46;
                if (i12 <= 0) {
                    break;
                }
                i46 = i12;
            }
            int i57 = i46;
            while (true) {
                int i58 = ~iArr4[i57];
                iArr4[i57] = i58;
                iArr4[i54 + i58] = i46;
                int i59 = i57 - 1;
                i11 = iArr4[i59];
                if (i11 >= 0) {
                    break;
                }
                i57 = i59;
            }
            iArr4[i11 + i54] = i46;
            i46 = i57 - 2;
        }
        trSort(i54, i54, 1);
        byte b10 = bArr[i23];
        int i60 = b10 & 255;
        byte b11 = bArr[0];
        if (i60 < (b11 & 255) || (b10 == b11 && z5)) {
            if (z5) {
                i9 = i54;
            } else {
                i9 = i54 - 1;
                iArr4[iArr4[i54 + i9]] = i23;
            }
            i10 = i21 - 2;
            while (i10 >= 0 && (bArr[i10] & 255) <= (bArr[i10 + 1] & 255)) {
                i10--;
            }
        } else {
            i9 = i54;
            i10 = i23;
        }
        while (i10 >= 0) {
            do {
                i10--;
                if (i10 < 0) {
                    break;
                }
            } while ((bArr[i10] & 255) >= (bArr[i10 + 1] & 255));
            if (i10 >= 0) {
                i9--;
                iArr4[iArr4[i54 + i9]] = i10;
                do {
                    i10--;
                    if (i10 >= 0) {
                    }
                } while ((bArr[i10] & 255) <= (bArr[i10 + 1] & 255));
            }
        }
        int i61 = i55;
        for (int i62 = 255; i62 >= 0; i62--) {
            for (int i63 = 255; i62 < i63; i63--) {
                int i64 = i23 - iArr2[BUCKET_B(i62, i63)];
                iArr2[BUCKET_B(i62, i63)] = i23 + 1;
                int i65 = iArr2[BUCKET_BSTAR(i62, i63)];
                i23 = i64;
                while (i65 <= i61) {
                    iArr4[i23] = iArr4[i61];
                    i23--;
                    i61--;
                }
            }
            int i66 = i23 - iArr2[BUCKET_B(i62, i62)];
            iArr2[BUCKET_B(i62, i62)] = i23 + 1;
            if (i62 < 255) {
                iArr2[BUCKET_BSTAR(i62, i62 + 1)] = i66 + 1;
            }
            i23 = iArr[i62];
        }
        return i54;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class PartitionResult {
        final int first;
        final int last;

        PartitionResult(int i6, int i7) {
            this.first = i6;
            this.last = i7;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class StackEntry {

        /* renamed from: a, reason: collision with root package name */
        final int f43062a;

        /* renamed from: b, reason: collision with root package name */
        final int f43063b;

        /* renamed from: c, reason: collision with root package name */
        final int f43064c;

        /* renamed from: d, reason: collision with root package name */
        final int f43065d;

        StackEntry(int i6, int i7, int i8, int i9) {
            this.f43062a = i6;
            this.f43063b = i7;
            this.f43064c = i8;
            this.f43065d = i9;
        }
    }

    private static int BUCKET_B(int i6, int i7) {
        return i6 | (i7 << 8);
    }

    private static int BUCKET_BSTAR(int i6, int i7) {
        return (i6 << 8) | i7;
    }

    private int constructBWT(int[] iArr, int[] iArr2) {
        byte[] bArr = this.T;
        int[] iArr3 = this.SA;
        int i6 = this.f43061n;
        int i7 = 254;
        int i8 = 0;
        int i9 = 0;
        while (i7 >= 0) {
            int i10 = i7 + 1;
            int i11 = iArr2[BUCKET_BSTAR(i7, i10)];
            int i12 = 0;
            int i13 = -1;
            for (int i14 = iArr[i10]; i11 <= i14; i14--) {
                int i15 = iArr3[i14];
                if (i15 >= 0) {
                    int i16 = i15 - 1;
                    if (i16 < 0) {
                        i16 = i6 - 1;
                    }
                    int i17 = bArr[i16] & 255;
                    if (i17 <= i7) {
                        iArr3[i14] = ~i15;
                        if (i16 > 0 && (bArr[i16 - 1] & 255) > i17) {
                            i16 = ~i16;
                        }
                        if (i13 == i17) {
                            i12--;
                            iArr3[i12] = i16;
                        } else {
                            if (i13 >= 0) {
                                iArr2[BUCKET_B(i13, i7)] = i12;
                            }
                            i12 = iArr2[BUCKET_B(i17, i7)] - 1;
                            iArr3[i12] = i16;
                            i13 = i17;
                        }
                    }
                } else {
                    iArr3[i14] = ~i15;
                }
            }
            i7--;
            i8 = i12;
            i9 = i13;
        }
        int i18 = -1;
        for (int i19 = 0; i19 < i6; i19++) {
            int i20 = iArr3[i19];
            if (i20 >= 0) {
                int i21 = i20 - 1;
                if (i21 < 0) {
                    i21 = i6 - 1;
                }
                int i22 = bArr[i21] & 255;
                if (i22 >= (bArr[i21 + 1] & 255)) {
                    if (i21 > 0 && (bArr[i21 - 1] & 255) < i22) {
                        i21 = ~i21;
                    }
                    if (i22 == i9) {
                        i8++;
                        iArr3[i8] = i21;
                    } else {
                        if (i9 != -1) {
                            iArr[i9] = i8;
                        }
                        i8 = iArr[i22] + 1;
                        iArr3[i8] = i21;
                        i9 = i22;
                    }
                }
            } else {
                i20 = ~i20;
            }
            if (i20 == 0) {
                iArr3[i19] = bArr[i6 - 1];
                i18 = i19;
            } else {
                iArr3[i19] = bArr[i20 - 1];
            }
        }
        return i18;
    }

    private static int getIDX(int i6) {
        return i6 >= 0 ? i6 : ~i6;
    }

    private void lsSort(int i6, int i7, int i8) {
        int i9;
        int[] iArr = this.SA;
        int i10 = i8 + i6;
        while (true) {
            int i11 = 0;
            if ((-i7) >= iArr[0]) {
                return;
            }
            int i12 = 0;
            int i13 = 0;
            while (true) {
                int i14 = iArr[i13];
                if (i14 < 0) {
                    i13 -= i14;
                    i12 += i14;
                    i9 = i6;
                } else {
                    if (i12 != 0) {
                        iArr[i13 + i12] = i12;
                        i12 = 0;
                    }
                    int i15 = iArr[i14 + i6] + 1;
                    i9 = i6;
                    lsIntroSort(i9, i10, i6 + i7, i13, i15);
                    i13 = i15;
                }
                if (i13 >= i7) {
                    break;
                } else {
                    i6 = i9;
                }
            }
            if (i12 != 0) {
                iArr[i13 + i12] = i12;
            }
            int i16 = i10 - i9;
            if (i7 < i16) {
                do {
                    int i17 = iArr[i11];
                    if (i17 < 0) {
                        i11 -= i17;
                    } else {
                        int i18 = iArr[i17 + i9] + 1;
                        while (i11 < i18) {
                            iArr[iArr[i11] + i9] = i11;
                            i11++;
                        }
                        i11 = i18;
                    }
                } while (i11 < i7);
                return;
            }
            i10 += i16;
            i6 = i9;
        }
    }

    private void lsUpdateGroup(int i6, int i7, int i8) {
        int i9;
        int[] iArr = this.SA;
        while (i7 < i8) {
            if (iArr[i7] >= 0) {
                int i10 = i7;
                do {
                    iArr[iArr[i10] + i6] = i10;
                    i10++;
                    if (i10 >= i8) {
                        break;
                    }
                } while (iArr[i10] >= 0);
                iArr[i7] = i7 - i10;
                if (i8 <= i10) {
                    return;
                } else {
                    i7 = i10;
                }
            }
            int i11 = i7;
            while (true) {
                iArr[i11] = ~iArr[i11];
                i9 = i11 + 1;
                if (iArr[i9] >= 0) {
                    break;
                } else {
                    i11 = i9;
                }
            }
            do {
                iArr[iArr[i7] + i6] = i9;
                i7++;
            } while (i7 <= i9);
            i7 = i11 + 2;
        }
    }

    private static void ssBlockSwap(int[] iArr, int i6, int[] iArr2, int i7, int i8) {
        while (i8 > 0) {
            swapElements(iArr, i6, iArr2, i7);
            i8--;
            i6++;
            i7++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        return (r1[r5] & 255) - (r1[r7] & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (r7 >= r3) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ssCompare(int r5, int r6, int r7) {
        /*
            r4 = this;
            int[] r0 = r4.SA
            byte[] r1 = r4.T
            int r2 = r5 + 1
            r2 = r0[r2]
            int r2 = r2 + 2
            int r3 = r6 + 1
            r3 = r0[r3]
            int r3 = r3 + 2
            r5 = r0[r5]
            int r5 = r5 + r7
            r6 = r0[r6]
            int r7 = r7 + r6
        L16:
            if (r5 >= r2) goto L25
            if (r7 >= r3) goto L25
            r6 = r1[r5]
            r0 = r1[r7]
            if (r6 != r0) goto L25
            int r5 = r5 + 1
            int r7 = r7 + 1
            goto L16
        L25:
            if (r5 >= r2) goto L35
            if (r7 >= r3) goto L33
            r5 = r1[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r5 = r5 - r6
            return r5
        L33:
            r5 = 1
            return r5
        L35:
            if (r7 >= r3) goto L39
            r5 = -1
            return r5
        L39:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.ssCompare(int, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        r6 = r1[r7] & 255;
        r7 = r1[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        return r6 - (r7 & 255);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r9 >= r8) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        r6 = r1[r7] & 255;
        r7 = r1[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r9 >= r8) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ssCompareLast(int r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            int[] r0 = r5.SA
            byte[] r1 = r5.T
            r7 = r0[r7]
            int r7 = r7 + r9
            r2 = r0[r8]
            int r9 = r9 + r2
            r2 = 1
            int r8 = r8 + r2
            r8 = r0[r8]
            int r8 = r8 + 2
        L10:
            if (r7 >= r10) goto L1f
            if (r9 >= r8) goto L1f
            r3 = r1[r7]
            r4 = r1[r9]
            if (r3 != r4) goto L1f
            int r7 = r7 + 1
            int r9 = r9 + 1
            goto L10
        L1f:
            if (r7 >= r10) goto L2e
            if (r9 >= r8) goto L2d
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = r1[r9]
        L29:
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r6 = r6 - r7
            return r6
        L2d:
            return r2
        L2e:
            if (r9 != r8) goto L31
            return r2
        L31:
            int r7 = r7 % r10
            r6 = r0[r6]
            int r6 = r6 + 2
        L36:
            if (r7 >= r6) goto L45
            if (r9 >= r8) goto L45
            r10 = r1[r7]
            r0 = r1[r9]
            if (r10 != r0) goto L45
            int r7 = r7 + 1
            int r9 = r9 + 1
            goto L36
        L45:
            if (r7 >= r6) goto L51
            if (r9 >= r8) goto L50
            r6 = r1[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = r1[r9]
            goto L29
        L50:
            return r2
        L51:
            if (r9 >= r8) goto L55
            r6 = -1
            return r6
        L55:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.ssCompareLast(int, int, int, int, int):int");
    }

    private void ssFixdown(int i6, int i7, int i8, int i9, int i10) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i11 = iArr[i8 + i9];
        int i12 = bArr[iArr[i7 + i11] + i6] & 255;
        while (true) {
            int i13 = i9 * 2;
            int i14 = i13 + 1;
            if (i14 >= i10) {
                break;
            }
            int i15 = i13 + 2;
            int i16 = bArr[iArr[iArr[i8 + i14] + i7] + i6] & 255;
            int i17 = bArr[iArr[iArr[i8 + i15] + i7] + i6] & 255;
            if (i16 < i17) {
                i16 = i17;
            } else {
                i15 = i14;
            }
            if (i16 <= i12) {
                break;
            }
            iArr[i9 + i8] = iArr[i8 + i15];
            i9 = i15;
        }
        iArr[i8 + i9] = i11;
    }

    private void ssHeapSort(int i6, int i7, int i8, int i9) {
        int i10;
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i11 = i9 % 2;
        if (i11 == 0) {
            int i12 = i9 - 1;
            int i13 = (i12 / 2) + i8;
            int i14 = i8 + i12;
            if ((bArr[iArr[iArr[i13] + i7] + i6] & 255) < (bArr[iArr[iArr[i14] + i7] + i6] & 255)) {
                swapElements(iArr, i14, iArr, i13);
            }
            i10 = i12;
        } else {
            i10 = i9;
        }
        for (int i15 = (i10 / 2) - 1; i15 >= 0; i15--) {
            ssFixdown(i6, i7, i8, i15, i10);
        }
        if (i11 == 0) {
            swapElements(iArr, i8, iArr, i8 + i10);
            ssFixdown(i6, i7, i8, 0, i10);
        }
        for (int i16 = i10 - 1; i16 > 0; i16--) {
            int i17 = iArr[i8];
            int i18 = i8 + i16;
            iArr[i8] = iArr[i18];
            ssFixdown(i6, i7, i8, 0, i16);
            iArr[i18] = i17;
        }
    }

    private void ssInsertionSort(int i6, int i7, int i8, int i9) {
        int ssCompare;
        int[] iArr = this.SA;
        for (int i10 = i8 - 2; i7 <= i10; i10--) {
            int i11 = iArr[i10];
            int i12 = i10 + 1;
            do {
                ssCompare = ssCompare(i6 + i11, iArr[i12] + i6, i9);
                if (ssCompare <= 0) {
                    break;
                }
                do {
                    iArr[i12 - 1] = iArr[i12];
                    i12++;
                    if (i12 >= i8) {
                        break;
                    }
                } while (iArr[i12] < 0);
            } while (i8 > i12);
            if (ssCompare == 0) {
                iArr[i12] = ~iArr[i12];
            }
            iArr[i12 - 1] = i11;
        }
    }

    private int ssMedian3(int i6, int i7, int i8, int i9, int i10) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i11 = bArr[iArr[iArr[i8] + i7] + i6] & 255;
        int i12 = bArr[iArr[iArr[i9] + i7] + i6] & 255;
        int i13 = bArr[i6 + iArr[i7 + iArr[i10]]] & 255;
        if (i11 <= i12) {
            i9 = i8;
            i8 = i9;
            i12 = i11;
            i11 = i12;
        }
        return i11 > i13 ? i12 > i13 ? i9 : i10 : i8;
    }

    private int ssMedian5(int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i13 = bArr[iArr[iArr[i8] + i7] + i6] & 255;
        int i14 = bArr[iArr[iArr[i9] + i7] + i6] & 255;
        int i15 = bArr[iArr[iArr[i10] + i7] + i6] & 255;
        int i16 = bArr[iArr[iArr[i11] + i7] + i6] & 255;
        int i17 = bArr[i6 + iArr[i7 + iArr[i12]]] & 255;
        if (i14 > i15) {
            i10 = i9;
            i9 = i10;
            i15 = i14;
            i14 = i15;
        }
        if (i16 > i17) {
            i16 = i17;
            i17 = i16;
        } else {
            i12 = i11;
            i11 = i12;
        }
        if (i14 > i16) {
            int i18 = i15;
            i15 = i17;
            i17 = i18;
            int i19 = i11;
            i11 = i10;
            i10 = i19;
        } else {
            i9 = i12;
            i14 = i16;
        }
        if (i13 > i15) {
            int i20 = i10;
            i10 = i8;
            i8 = i20;
            int i21 = i15;
            i15 = i13;
            i13 = i21;
        }
        if (i13 > i14) {
            i9 = i8;
            i14 = i13;
        } else {
            i11 = i10;
            i17 = i15;
        }
        return i17 > i14 ? i9 : i11;
    }

    private void ssMerge(int i6, int i7, int i8, int i9, int[] iArr, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        int[] iArr2 = this.SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i19 = i7;
        int i20 = i8;
        int i21 = i9;
        int i22 = 0;
        int i23 = 0;
        while (true) {
            int i24 = i21 - i20;
            if (i24 <= i18) {
                if (i19 >= i20 || i20 >= i21) {
                    i13 = i6;
                    i14 = i12;
                } else {
                    i14 = i12;
                    ssMergeBackward(i6, iArr, i10, i19, i20, i21, i14);
                    i13 = i6;
                }
                if ((i22 & 1) != 0) {
                    ssMergeCheckEqual(i13, i14, i19);
                }
                if ((i22 & 2) != 0) {
                    ssMergeCheckEqual(i13, i14, i21);
                }
                if (i23 == 0) {
                    return;
                }
                i23--;
                StackEntry stackEntry = stackEntryArr[i23];
                i19 = stackEntry.f43062a;
                i20 = stackEntry.f43063b;
                i21 = stackEntry.f43064c;
                i22 = stackEntry.f43065d;
            } else {
                int i25 = i6;
                int i26 = i20 - i19;
                if (i26 <= i18) {
                    if (i19 < i20) {
                        ssMergeForward(i25, iArr, i10, i19, i20, i21, i12);
                        i25 = i25;
                    }
                    if ((i22 & 1) != 0) {
                        ssMergeCheckEqual(i25, i12, i19);
                    }
                    if ((i22 & 2) != 0) {
                        ssMergeCheckEqual(i25, i12, i21);
                    }
                    if (i23 == 0) {
                        return;
                    }
                    i23--;
                    StackEntry stackEntry2 = stackEntryArr[i23];
                    i19 = stackEntry2.f43062a;
                    i20 = stackEntry2.f43063b;
                    i21 = stackEntry2.f43064c;
                    i22 = stackEntry2.f43065d;
                } else {
                    int min = Math.min(i26, i24);
                    int i27 = min >> 1;
                    int i28 = 0;
                    while (min > 0) {
                        if (ssCompare(i25 + getIDX(iArr2[i20 + i28 + i27]), i25 + getIDX(iArr2[((i20 - i28) - i27) - 1]), i12) < 0) {
                            i28 += i27 + 1;
                            i27 -= (min & 1) ^ 1;
                        }
                        min = i27;
                        i27 = min >> 1;
                    }
                    if (i28 > 0) {
                        int i29 = i20 - i28;
                        ssBlockSwap(iArr2, i29, iArr2, i20, i28);
                        int i30 = i20 + i28;
                        if (i30 < i21) {
                            if (iArr2[i30] < 0) {
                                i15 = i20;
                                while (iArr2[i15 - 1] < 0) {
                                    i15--;
                                }
                                iArr2[i30] = ~iArr2[i30];
                            } else {
                                i15 = i20;
                            }
                            i16 = i20;
                            while (iArr2[i16] < 0) {
                                i16++;
                            }
                            i17 = 1;
                        } else {
                            i15 = i20;
                            i16 = i15;
                            i17 = 0;
                        }
                        int[] iArr3 = iArr2;
                        if (i15 - i19 <= i21 - i16) {
                            stackEntryArr[i23] = new StackEntry(i16, i30, i21, (i22 & 2) | i17);
                            i22 &= 1;
                            i18 = i11;
                            i23++;
                            i21 = i15;
                            iArr2 = iArr3;
                            i20 = i29;
                        } else {
                            if (i15 == i20 && i20 == i16) {
                                i17 <<= 1;
                            }
                            stackEntryArr[i23] = new StackEntry(i19, i29, i15, (i22 & 1) | (i17 & 2));
                            i22 = (i22 & 2) | (i17 & 1);
                            i18 = i11;
                            i23++;
                            i19 = i16;
                            iArr2 = iArr3;
                            i20 = i30;
                        }
                    } else {
                        int[] iArr4 = iArr2;
                        if ((i22 & 1) != 0) {
                            ssMergeCheckEqual(i25, i12, i19);
                        }
                        ssMergeCheckEqual(i25, i12, i20);
                        if ((i22 & 2) != 0) {
                            ssMergeCheckEqual(i25, i12, i21);
                        }
                        if (i23 == 0) {
                            return;
                        }
                        i23--;
                        StackEntry stackEntry3 = stackEntryArr[i23];
                        i19 = stackEntry3.f43062a;
                        i20 = stackEntry3.f43063b;
                        i21 = stackEntry3.f43064c;
                        i22 = stackEntry3.f43065d;
                        i18 = i11;
                        iArr2 = iArr4;
                    }
                }
            }
        }
    }

    private void ssMergeBackward(int i6, int[] iArr, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int[] iArr2 = this.SA;
        int i23 = i10 - i9;
        ssBlockSwap(iArr, i7, iArr2, i9, i23);
        int i24 = (i7 + i23) - 1;
        int i25 = iArr[i24];
        if (i25 < 0) {
            i12 = (~i25) + i6;
            i13 = 1;
        } else {
            i12 = i25 + i6;
            i13 = 0;
        }
        int i26 = i9 - 1;
        int i27 = iArr2[i26];
        if (i27 < 0) {
            i13 |= 2;
            i27 = ~i27;
        }
        int i28 = i27 + i6;
        int i29 = i10 - 1;
        int i30 = iArr2[i29];
        while (true) {
            int ssCompare = ssCompare(i12, i28, i11);
            if (ssCompare > 0) {
                if ((i13 & 1) != 0) {
                    while (true) {
                        i14 = i29 - 1;
                        iArr2[i29] = iArr[i24];
                        i15 = i24 - 1;
                        iArr[i24] = iArr2[i14];
                        if (iArr[i15] >= 0) {
                            break;
                        }
                        i24 = i15;
                        i29 = i14;
                    }
                    i13 ^= 1;
                    i24 = i15;
                    i29 = i14;
                }
                int i31 = i29 - 1;
                iArr2[i29] = iArr[i24];
                if (i24 <= i7) {
                    iArr[i24] = i30;
                    return;
                }
                int i32 = i24 - 1;
                iArr[i24] = iArr2[i31];
                int i33 = iArr[i32];
                if (i33 < 0) {
                    i13 |= 1;
                    i33 = ~i33;
                }
                int i34 = i33 + i6;
                i24 = i32;
                i29 = i31;
                i12 = i34;
            } else {
                if (ssCompare < 0) {
                    if ((i13 & 2) != 0) {
                        while (true) {
                            i21 = i29 - 1;
                            iArr2[i29] = iArr2[i26];
                            i22 = i26 - 1;
                            iArr2[i26] = iArr2[i21];
                            if (iArr2[i22] >= 0) {
                                break;
                            }
                            i26 = i22;
                            i29 = i21;
                        }
                        i13 ^= 2;
                        i26 = i22;
                        i29 = i21;
                    }
                    int i35 = i29 - 1;
                    iArr2[i29] = iArr2[i26];
                    int i36 = i26 - 1;
                    iArr2[i26] = iArr2[i35];
                    if (i36 < i8) {
                        while (i7 < i24) {
                            int i37 = i35 - 1;
                            iArr2[i35] = iArr[i24];
                            iArr[i24] = iArr2[i37];
                            i35 = i37;
                            i24--;
                        }
                        iArr2[i35] = iArr[i24];
                        iArr[i24] = i30;
                        return;
                    }
                    int i38 = iArr2[i36];
                    if (i38 < 0) {
                        i13 |= 2;
                        i38 = ~i38;
                    }
                    i16 = i35;
                    i28 = i38 + i6;
                    i26 = i36;
                } else {
                    if ((i13 & 1) != 0) {
                        while (true) {
                            i19 = i29 - 1;
                            iArr2[i29] = iArr[i24];
                            i20 = i24 - 1;
                            iArr[i24] = iArr2[i19];
                            if (iArr[i20] >= 0) {
                                break;
                            }
                            i24 = i20;
                            i29 = i19;
                        }
                        i13 ^= 1;
                        i24 = i20;
                        i29 = i19;
                    }
                    int i39 = i29 - 1;
                    iArr2[i29] = ~iArr[i24];
                    if (i24 <= i7) {
                        iArr[i24] = i30;
                        return;
                    }
                    int i40 = i24 - 1;
                    iArr[i24] = iArr2[i39];
                    if ((i13 & 2) != 0) {
                        while (true) {
                            i17 = i39 - 1;
                            iArr2[i39] = iArr2[i26];
                            i18 = i26 - 1;
                            iArr2[i26] = iArr2[i17];
                            if (iArr2[i18] >= 0) {
                                break;
                            }
                            i26 = i18;
                            i39 = i17;
                        }
                        i13 ^= 2;
                        i26 = i18;
                        i39 = i17;
                    }
                    int i41 = i39 - 1;
                    iArr2[i39] = iArr2[i26];
                    int i42 = i26 - 1;
                    iArr2[i26] = iArr2[i41];
                    if (i42 < i8) {
                        while (i7 < i40) {
                            int i43 = i41 - 1;
                            iArr2[i41] = iArr[i40];
                            iArr[i40] = iArr2[i43];
                            i41 = i43;
                            i40--;
                        }
                        iArr2[i41] = iArr[i40];
                        iArr[i40] = i30;
                        return;
                    }
                    int i44 = iArr[i40];
                    if (i44 < 0) {
                        i13 |= 1;
                        i44 = ~i44;
                    }
                    int i45 = i44 + i6;
                    int i46 = iArr2[i42];
                    if (i46 < 0) {
                        i13 |= 2;
                        i46 = ~i46;
                    }
                    i28 = i46 + i6;
                    i12 = i45;
                    i26 = i42;
                    i16 = i41;
                    i24 = i40;
                }
                i29 = i16;
            }
        }
    }

    private void ssMergeCheckEqual(int i6, int i7, int i8) {
        int[] iArr = this.SA;
        if (iArr[i8] < 0 || ssCompare(getIDX(iArr[i8 - 1]) + i6, i6 + iArr[i8], i7) != 0) {
            return;
        }
        iArr[i8] = ~iArr[i8];
    }

    private void ssMergeForward(int i6, int[] iArr, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int[] iArr2 = this.SA;
        int i13 = i9 - i8;
        int i14 = (i7 + i13) - 1;
        ssBlockSwap(iArr, i7, iArr2, i8, i13);
        int i15 = iArr2[i8];
        while (true) {
            int ssCompare = ssCompare(iArr[i7] + i6, iArr2[i9] + i6, i11);
            if (ssCompare < 0) {
                while (true) {
                    i12 = i8 + 1;
                    iArr2[i8] = iArr[i7];
                    if (i14 <= i7) {
                        iArr[i7] = i15;
                        return;
                    }
                    int i16 = i7 + 1;
                    iArr[i7] = iArr2[i12];
                    if (iArr[i16] >= 0) {
                        i7 = i16;
                        break;
                    } else {
                        i7 = i16;
                        i8 = i12;
                    }
                }
            } else if (ssCompare > 0) {
                while (true) {
                    i12 = i8 + 1;
                    iArr2[i8] = iArr2[i9];
                    int i17 = i9 + 1;
                    iArr2[i9] = iArr2[i12];
                    if (i10 <= i17) {
                        while (i7 < i14) {
                            int i18 = i12 + 1;
                            iArr2[i12] = iArr[i7];
                            iArr[i7] = iArr2[i18];
                            i12 = i18;
                            i7++;
                        }
                        iArr2[i12] = iArr[i7];
                        iArr[i7] = i15;
                        return;
                    }
                    if (iArr2[i17] >= 0) {
                        i9 = i17;
                        break;
                    } else {
                        i9 = i17;
                        i8 = i12;
                    }
                }
            } else {
                iArr2[i9] = ~iArr2[i9];
                while (true) {
                    int i19 = i8 + 1;
                    iArr2[i8] = iArr[i7];
                    if (i14 <= i7) {
                        iArr[i7] = i15;
                        return;
                    }
                    int i20 = i7 + 1;
                    iArr[i7] = iArr2[i19];
                    if (iArr[i20] >= 0) {
                        while (true) {
                            int i21 = i19 + 1;
                            iArr2[i19] = iArr2[i9];
                            int i22 = i9 + 1;
                            iArr2[i9] = iArr2[i21];
                            if (i10 <= i22) {
                                while (i20 < i14) {
                                    int i23 = i21 + 1;
                                    iArr2[i21] = iArr[i20];
                                    iArr[i20] = iArr2[i23];
                                    i20++;
                                    i21 = i23;
                                }
                                iArr2[i21] = iArr[i20];
                                iArr[i20] = i15;
                                return;
                            }
                            if (iArr2[i22] >= 0) {
                                i8 = i21;
                                i7 = i20;
                                i9 = i22;
                                break;
                            }
                            i9 = i22;
                            i19 = i21;
                        }
                    } else {
                        i7 = i20;
                        i8 = i19;
                    }
                }
            }
            i8 = i12;
        }
    }

    private void ssMultiKeyIntroSort(int i6, int i7, int i8, int i9) {
        int i10;
        byte[] bArr;
        int i11;
        StackEntry[] stackEntryArr;
        int ssLog;
        int[] iArr = this.SA;
        byte[] bArr2 = this.T;
        StackEntry[] stackEntryArr2 = new StackEntry[64];
        int i12 = i8;
        int i13 = i9;
        int ssLog2 = ssLog(i8 - i7);
        int i14 = 0;
        int i15 = 0;
        int i16 = i7;
        while (true) {
            int i17 = i12 - i16;
            if (i17 <= 8) {
                if (1 < i17) {
                    ssInsertionSort(i6, i16, i12, i13);
                }
                if (i14 == 0) {
                    return;
                }
                i14--;
                StackEntry stackEntry = stackEntryArr2[i14];
                int i18 = stackEntry.f43062a;
                int i19 = stackEntry.f43063b;
                int i20 = stackEntry.f43064c;
                ssLog2 = stackEntry.f43065d;
                i16 = i18;
                i12 = i19;
                i13 = i20;
            } else {
                int i21 = ssLog2 - 1;
                if (ssLog2 == 0) {
                    ssHeapSort(i13, i6, i16, i17);
                }
                if (i21 < 0) {
                    int i22 = bArr2[iArr[iArr[i16] + i6] + i13] & 255;
                    int i23 = i16;
                    i16++;
                    while (i16 < i12) {
                        i15 = bArr2[iArr[iArr[i16] + i6] + i13] & 255;
                        if (i15 != i22) {
                            if (1 < i16 - i23) {
                                break;
                            }
                            i23 = i16;
                            i22 = i15;
                        }
                        i16++;
                    }
                    if ((bArr2[(iArr[iArr[i23] + i6] + i13) - 1] & 255) < i22) {
                        i23 = ssSubstringPartition(i6, i23, i16, i13);
                    }
                    int i24 = i16 - i23;
                    int i25 = i12 - i16;
                    if (i24 <= i25) {
                        if (1 < i24) {
                            stackEntryArr2[i14] = new StackEntry(i16, i12, i13, -1);
                            i13++;
                            i12 = i16;
                            i16 = i23;
                            ssLog2 = ssLog(i24);
                            i14++;
                        } else {
                            ssLog2 = -1;
                        }
                    } else if (1 < i25) {
                        stackEntryArr2[i14] = new StackEntry(i23, i16, i13 + 1, ssLog(i24));
                        i14++;
                        ssLog2 = -1;
                    } else {
                        i13++;
                        i12 = i16;
                        i16 = i23;
                        ssLog2 = ssLog(i24);
                    }
                } else {
                    int ssPivot = ssPivot(i13, i6, i16, i12);
                    int i26 = bArr2[iArr[iArr[ssPivot] + i6] + i13] & 255;
                    swapElements(iArr, i16, iArr, ssPivot);
                    int i27 = i16 + 1;
                    while (i27 < i12) {
                        i15 = bArr2[iArr[iArr[i27] + i6] + i13] & 255;
                        if (i15 != i26) {
                            break;
                        } else {
                            i27++;
                        }
                    }
                    if (i27 < i12 && i15 < i26) {
                        i10 = i27;
                        while (true) {
                            i27++;
                            if (i27 >= i12 || (i15 = bArr2[iArr[iArr[i27] + i6] + i13] & 255) > i26) {
                                break;
                            } else if (i15 == i26) {
                                swapElements(iArr, i27, iArr, i10);
                                i10++;
                            }
                        }
                    } else {
                        i10 = i27;
                    }
                    int i28 = i12 - 1;
                    while (i27 < i28) {
                        i15 = bArr2[iArr[iArr[i28] + i6] + i13] & 255;
                        if (i15 != i26) {
                            break;
                        } else {
                            i28--;
                        }
                    }
                    if (i27 < i28 && i15 > i26) {
                        bArr = bArr2;
                        i11 = i28;
                        while (true) {
                            i28--;
                            if (i27 >= i28 || (i15 = bArr[iArr[iArr[i28] + i6] + i13] & 255) < i26) {
                                break;
                            } else if (i15 == i26) {
                                swapElements(iArr, i28, iArr, i11);
                                i11--;
                            }
                        }
                    } else {
                        bArr = bArr2;
                        i11 = i28;
                    }
                    while (i27 < i28) {
                        swapElements(iArr, i27, iArr, i28);
                        while (true) {
                            i27++;
                            if (i27 >= i28 || (i15 = bArr[iArr[iArr[i27] + i6] + i13] & 255) > i26) {
                                break;
                            } else if (i15 == i26) {
                                swapElements(iArr, i27, iArr, i10);
                                i10++;
                            }
                        }
                        while (true) {
                            i28--;
                            if (i27 < i28 && (i15 = bArr[iArr[iArr[i28] + i6] + i13] & 255) >= i26) {
                                if (i15 == i26) {
                                    swapElements(iArr, i28, iArr, i11);
                                    i11--;
                                }
                            }
                        }
                    }
                    if (i10 <= i11) {
                        int i29 = i27 - 1;
                        int i30 = i10 - i16;
                        int i31 = i27 - i10;
                        if (i30 > i31) {
                            i30 = i31;
                        }
                        int i32 = i11;
                        int i33 = i27 - i30;
                        stackEntryArr = stackEntryArr2;
                        int i34 = i16;
                        while (i30 > 0) {
                            swapElements(iArr, i34, iArr, i33);
                            i30--;
                            i34++;
                            i33++;
                        }
                        int i35 = i32 - i29;
                        int i36 = (i12 - i32) - 1;
                        if (i35 <= i36) {
                            i36 = i35;
                        }
                        int i37 = i12 - i36;
                        while (i36 > 0) {
                            swapElements(iArr, i27, iArr, i37);
                            i36--;
                            i27++;
                            i37++;
                        }
                        int i38 = i16 + i31;
                        int i39 = i12 - i35;
                        int ssSubstringPartition = i26 <= (bArr[(iArr[iArr[i38] + i6] + i13) + (-1)] & 255) ? i38 : ssSubstringPartition(i6, i38, i39, i13);
                        int i40 = i38 - i16;
                        int i41 = i12 - i39;
                        if (i40 <= i41) {
                            int i42 = i39 - ssSubstringPartition;
                            if (i41 <= i42) {
                                int i43 = i14 + 1;
                                stackEntryArr[i14] = new StackEntry(ssSubstringPartition, i39, i13 + 1, ssLog(i42));
                                i14 += 2;
                                stackEntryArr[i43] = new StackEntry(i39, i12, i13, i21);
                            } else if (i40 <= i42) {
                                int i44 = i14 + 1;
                                stackEntryArr[i14] = new StackEntry(i39, i12, i13, i21);
                                i14 += 2;
                                stackEntryArr[i44] = new StackEntry(ssSubstringPartition, i39, i13 + 1, ssLog(i42));
                            } else {
                                int i45 = i14 + 1;
                                stackEntryArr[i14] = new StackEntry(i39, i12, i13, i21);
                                i14 += 2;
                                stackEntryArr[i45] = new StackEntry(i16, i38, i13, i21);
                                i13++;
                                ssLog = ssLog(i42);
                                i12 = i39;
                                i16 = ssSubstringPartition;
                                bArr2 = bArr;
                                ssLog2 = ssLog;
                                stackEntryArr2 = stackEntryArr;
                            }
                            i12 = i38;
                            ssLog2 = i21;
                        } else {
                            int i46 = i39 - ssSubstringPartition;
                            if (i40 <= i46) {
                                int i47 = i14 + 1;
                                stackEntryArr[i14] = new StackEntry(ssSubstringPartition, i39, i13 + 1, ssLog(i46));
                                i14 += 2;
                                stackEntryArr[i47] = new StackEntry(i16, i38, i13, i21);
                            } else if (i41 <= i46) {
                                int i48 = i14 + 1;
                                stackEntryArr[i14] = new StackEntry(i16, i38, i13, i21);
                                i14 += 2;
                                stackEntryArr[i48] = new StackEntry(ssSubstringPartition, i39, i13 + 1, ssLog(i46));
                            } else {
                                int i49 = i14 + 1;
                                stackEntryArr[i14] = new StackEntry(i16, i38, i13, i21);
                                i14 += 2;
                                stackEntryArr[i49] = new StackEntry(i39, i12, i13, i21);
                                i13++;
                                ssLog = ssLog(i46);
                                i12 = i39;
                                i16 = ssSubstringPartition;
                                bArr2 = bArr;
                                ssLog2 = ssLog;
                                stackEntryArr2 = stackEntryArr;
                            }
                            i16 = i39;
                            ssLog2 = i21;
                        }
                    } else {
                        stackEntryArr = stackEntryArr2;
                        if ((bArr[(iArr[iArr[i16] + i6] + i13) - 1] & 255) < i26) {
                            int ssSubstringPartition2 = ssSubstringPartition(i6, i16, i12, i13);
                            i16 = ssSubstringPartition2;
                            ssLog2 = ssLog(i12 - ssSubstringPartition2);
                        }
                        i13++;
                    }
                    bArr2 = bArr;
                    stackEntryArr2 = stackEntryArr;
                }
            }
        }
    }

    private int ssPivot(int i6, int i7, int i8, int i9) {
        int i10 = i9 - i8;
        int i11 = i8 + (i10 / 2);
        if (i10 <= 512) {
            if (i10 <= 32) {
                return ssMedian3(i6, i7, i8, i11, i9 - 1);
            }
            int i12 = i10 >> 2;
            int i13 = i9 - 1;
            return ssMedian5(i6, i7, i8, i8 + i12, i11, i13 - i12, i13);
        }
        int i14 = i10 >> 3;
        int i15 = i14 << 1;
        int i16 = i9 - 1;
        return ssMedian3(i6, i7, ssMedian3(i6, i7, i8, i8 + i14, i8 + i15), ssMedian3(i6, i7, i11 - i14, i11, i11 + i14), ssMedian3(i6, i7, i16 - i15, i16 - i14, i16));
    }

    private int ssSubstringPartition(int i6, int i7, int i8, int i9) {
        int i10;
        int[] iArr = this.SA;
        int i11 = i7 - 1;
        while (true) {
            i11++;
            if (i11 < i8) {
                int i12 = iArr[i11];
                if (iArr[i6 + i12] + i9 >= iArr[i6 + i12 + 1] + 1) {
                    iArr[i11] = ~i12;
                }
            }
            do {
                i8--;
                if (i11 >= i8) {
                    break;
                }
                i10 = iArr[i8];
            } while (iArr[i6 + i10] + i9 < iArr[i10 + i6 + 1] + 1);
            if (i8 <= i11) {
                break;
            }
            int i13 = ~iArr[i8];
            iArr[i8] = iArr[i11];
            iArr[i11] = i13;
        }
        if (i7 < i11) {
            iArr[i7] = ~iArr[i7];
        }
        return i11;
    }

    private void subStringSort(int i6, int i7, int i8, int[] iArr, int i9, int i10, int i11, boolean z5, int i12) {
        int i13;
        int[] iArr2;
        int i14;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int i15 = i6;
        int i16 = i11;
        int[] iArr3 = bzip2DivSufSort.SA;
        int i17 = z5 ? i7 + 1 : i7;
        int i18 = i17;
        int i19 = 0;
        while (true) {
            int i20 = i18 + 1024;
            if (i20 >= i8) {
                break;
            }
            bzip2DivSufSort.ssMultiKeyIntroSort(i15, i18, i20, i16);
            int i21 = i8 - i20;
            if (i21 <= i10) {
                iArr2 = iArr;
                i14 = i9;
                i13 = i10;
            } else {
                i13 = i21;
                iArr2 = iArr3;
                i14 = i20;
            }
            int i22 = i19;
            int i23 = 1024;
            while (true) {
                int i24 = i18;
                if ((i22 & 1) != 0) {
                    i18 = i24 - i23;
                    bzip2DivSufSort.ssMerge(i15, i18, i24, i24 + i23, iArr2, i14, i13, i16);
                    i23 <<= 1;
                    i22 >>>= 1;
                }
            }
            i19++;
            i18 = i20;
        }
        int i25 = i10;
        bzip2DivSufSort.ssMultiKeyIntroSort(i15, i18, i8, i16);
        int i26 = i18;
        int i27 = i19;
        int i28 = 1024;
        while (i27 != 0) {
            if ((i27 & 1) != 0) {
                int i29 = i26 - i28;
                bzip2DivSufSort.ssMerge(i15, i29, i26, i8, iArr, i9, i25, i16);
                i26 = i29;
            }
            i28 <<= 1;
            i27 >>= 1;
            bzip2DivSufSort = this;
            i15 = i6;
            i25 = i10;
            i16 = i11;
        }
        if (z5) {
            int i30 = iArr3[i17 - 1];
            int i31 = 1;
            while (i17 < i8) {
                int i32 = iArr3[i17];
                if (i32 >= 0) {
                    int ssCompareLast = ssCompareLast(i6, i6 + i30, i6 + i32, i11, i12);
                    i31 = ssCompareLast;
                    if (ssCompareLast <= 0) {
                        break;
                    }
                }
                iArr3[i17 - 1] = iArr3[i17];
                i17++;
            }
            if (i31 == 0) {
                iArr3[i17] = ~iArr3[i17];
            }
            iArr3[i17 - 1] = i30;
        }
    }

    private static void swapElements(int[] iArr, int i6, int[] iArr2, int i7) {
        int i8 = iArr[i6];
        iArr[i6] = iArr2[i7];
        iArr2[i7] = i8;
    }

    private void trCopy(int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int[] iArr = this.SA;
        int i13 = i10 - 1;
        int i14 = i9 - 1;
        while (i8 <= i14) {
            int i15 = iArr[i8] - i12;
            if (i15 < 0) {
                i15 += i7 - i6;
            }
            int i16 = i6 + i15;
            if (iArr[i16] == i13) {
                i14++;
                iArr[i14] = i15;
                iArr[i16] = i14;
            }
            i8++;
        }
        int i17 = i11 - 1;
        int i18 = i14 + 1;
        while (i18 < i10) {
            int i19 = iArr[i17] - i12;
            if (i19 < 0) {
                i19 += i7 - i6;
            }
            int i20 = i6 + i19;
            if (iArr[i20] == i13) {
                i10--;
                iArr[i10] = i19;
                iArr[i20] = i10;
            }
            i17--;
        }
    }

    private void trFixdown(int i6, int i7, int i8, int i9, int i10, int i11) {
        int[] iArr = this.SA;
        int i12 = iArr[i9 + i10];
        int trGetC = trGetC(i6, i7, i8, i12);
        while (true) {
            int i13 = i10 * 2;
            int i14 = i13 + 1;
            if (i14 >= i11) {
                break;
            }
            int i15 = i13 + 2;
            int trGetC2 = trGetC(i6, i7, i8, iArr[i9 + i14]);
            int trGetC3 = trGetC(i6, i7, i8, iArr[i9 + i15]);
            if (trGetC2 < trGetC3) {
                trGetC2 = trGetC3;
            } else {
                i15 = i14;
            }
            if (trGetC2 <= trGetC) {
                break;
            }
            iArr[i10 + i9] = iArr[i9 + i15];
            i10 = i15;
        }
        iArr[i9 + i10] = i12;
    }

    private int trGetC(int i6, int i7, int i8, int i9) {
        int i10 = i7 + i9;
        return i10 < i8 ? this.SA[i10] : this.SA[i6 + (((i7 - i6) + i9) % (i8 - i6))];
    }

    private void trHeapSort(int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int[] iArr = this.SA;
        int i12 = i10 % 2;
        if (i12 == 0) {
            int i13 = i10 - 1;
            int i14 = (i13 / 2) + i9;
            int i15 = i9 + i13;
            if (trGetC(i6, i7, i8, iArr[i14]) < trGetC(i6, i7, i8, iArr[i15])) {
                swapElements(iArr, i15, iArr, i14);
            }
            i11 = i13;
        } else {
            i11 = i10;
        }
        for (int i16 = (i11 / 2) - 1; i16 >= 0; i16--) {
            trFixdown(i6, i7, i8, i9, i16, i11);
        }
        if (i12 == 0) {
            swapElements(iArr, i9, iArr, i9 + i11);
            trFixdown(i6, i7, i8, i9, 0, i11);
        }
        for (int i17 = i11 - 1; i17 > 0; i17--) {
            int i18 = iArr[i9];
            int i19 = i9 + i17;
            iArr[i9] = iArr[i19];
            trFixdown(i6, i7, i8, i9, 0, i17);
            iArr[i19] = i18;
        }
    }

    private void trInsertionSort(int i6, int i7, int i8, int i9, int i10) {
        int trGetC;
        int[] iArr = this.SA;
        for (int i11 = i9 + 1; i11 < i10; i11++) {
            int i12 = iArr[i11];
            int i13 = i11 - 1;
            do {
                trGetC = trGetC(i6, i7, i8, i12) - trGetC(i6, i7, i8, iArr[i13]);
                if (trGetC >= 0) {
                    break;
                }
                do {
                    iArr[i13 + 1] = iArr[i13];
                    i13--;
                    if (i9 > i13) {
                        break;
                    }
                } while (iArr[i13] < 0);
            } while (i13 >= i9);
            if (trGetC == 0) {
                iArr[i13] = ~iArr[i13];
            }
            iArr[i13 + 1] = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:290:0x04d8, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0305  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:152:0x02f5 -> B:138:0x02b3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trIntroSort(int r24, int r25, int r26, int r27, int r28, io.netty.handler.codec.compression.Bzip2DivSufSort.TRBudget r29, int r30) {
        /*
            Method dump skipped, instructions count: 1249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2DivSufSort.trIntroSort(int, int, int, int, int, io.netty.handler.codec.compression.Bzip2DivSufSort$TRBudget, int):void");
    }

    private static int trLog(int i6) {
        return ((-65536) & i6) != 0 ? ((-16777216) & i6) != 0 ? LOG_2_TABLE[(i6 >> 24) & 255] + 24 : LOG_2_TABLE[(i6 >> 16) & MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME] : (65280 & i6) != 0 ? LOG_2_TABLE[(i6 >> 8) & 255] + 8 : LOG_2_TABLE[i6 & 255];
    }

    private int trMedian3(int i6, int i7, int i8, int i9, int i10, int i11) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i6, i7, i8, iArr[i9]);
        int trGetC2 = trGetC(i6, i7, i8, iArr[i10]);
        int trGetC3 = trGetC(i6, i7, i8, iArr[i11]);
        if (trGetC <= trGetC2) {
            i10 = i9;
            i9 = i10;
            trGetC2 = trGetC;
            trGetC = trGetC2;
        }
        return trGetC > trGetC3 ? trGetC2 > trGetC3 ? i10 : i11 : i9;
    }

    private int trMedian5(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        int[] iArr = this.SA;
        int trGetC = trGetC(i6, i7, i8, iArr[i9]);
        int trGetC2 = trGetC(i6, i7, i8, iArr[i10]);
        int trGetC3 = trGetC(i6, i7, i8, iArr[i11]);
        int trGetC4 = trGetC(i6, i7, i8, iArr[i12]);
        int trGetC5 = trGetC(i6, i7, i8, iArr[i13]);
        if (trGetC2 > trGetC3) {
            i11 = i10;
            i10 = i11;
            trGetC3 = trGetC2;
            trGetC2 = trGetC3;
        }
        if (trGetC4 > trGetC5) {
            trGetC4 = trGetC5;
            trGetC5 = trGetC4;
        } else {
            i13 = i12;
            i12 = i13;
        }
        if (trGetC2 > trGetC4) {
            int i14 = trGetC3;
            trGetC3 = trGetC5;
            trGetC5 = i14;
            int i15 = i12;
            i12 = i11;
            i11 = i15;
        } else {
            i10 = i13;
            trGetC2 = trGetC4;
        }
        if (trGetC > trGetC3) {
            int i16 = i11;
            i11 = i9;
            i9 = i16;
            int i17 = trGetC3;
            trGetC3 = trGetC;
            trGetC = i17;
        }
        if (trGetC > trGetC2) {
            i10 = i9;
            trGetC2 = trGetC;
        } else {
            i12 = i11;
            trGetC5 = trGetC3;
        }
        return trGetC5 > trGetC2 ? i10 : i12;
    }

    private PartitionResult trPartition(int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        int trGetC;
        int trGetC2;
        int trGetC3;
        int[] iArr = this.SA;
        int i14 = 0;
        int i15 = i9;
        while (i15 < i10) {
            i14 = trGetC(i6, i7, i8, iArr[i15]);
            if (i14 != i11) {
                break;
            }
            i15++;
        }
        if (i15 < i10 && i14 < i11) {
            i12 = i15;
            while (true) {
                i15++;
                if (i15 >= i10 || (i14 = trGetC(i6, i7, i8, iArr[i15])) > i11) {
                    break;
                }
                if (i14 == i11) {
                    swapElements(iArr, i15, iArr, i12);
                    i12++;
                }
            }
        } else {
            i12 = i15;
        }
        int i16 = i10 - 1;
        while (i15 < i16) {
            i14 = trGetC(i6, i7, i8, iArr[i16]);
            if (i14 != i11) {
                break;
            }
            i16--;
        }
        if (i15 < i16 && i14 > i11) {
            i13 = i16;
            while (true) {
                i16--;
                if (i15 >= i16 || (trGetC3 = trGetC(i6, i7, i8, iArr[i16])) < i11) {
                    break;
                }
                if (trGetC3 == i11) {
                    swapElements(iArr, i16, iArr, i13);
                    i13--;
                }
            }
        } else {
            i13 = i16;
        }
        while (i15 < i16) {
            swapElements(iArr, i15, iArr, i16);
            while (true) {
                i15++;
                if (i15 >= i16 || (trGetC2 = trGetC(i6, i7, i8, iArr[i15])) > i11) {
                    break;
                }
                if (trGetC2 == i11) {
                    swapElements(iArr, i15, iArr, i12);
                    i12++;
                }
            }
            while (true) {
                i16--;
                if (i15 < i16 && (trGetC = trGetC(i6, i7, i8, iArr[i16])) >= i11) {
                    if (trGetC == i11) {
                        swapElements(iArr, i16, iArr, i13);
                        i13--;
                    }
                }
            }
        }
        if (i12 <= i13) {
            int i17 = i15 - 1;
            int i18 = i12 - i9;
            int i19 = i15 - i12;
            if (i18 > i19) {
                i18 = i19;
            }
            int i20 = i15 - i18;
            int i21 = i9;
            while (i18 > 0) {
                swapElements(iArr, i21, iArr, i20);
                i18--;
                i21++;
                i20++;
            }
            int i22 = i13 - i17;
            int i23 = (i10 - i13) - 1;
            if (i22 <= i23) {
                i23 = i22;
            }
            int i24 = i10 - i23;
            while (i23 > 0) {
                swapElements(iArr, i15, iArr, i24);
                i23--;
                i15++;
                i24++;
            }
            i9 += i19;
            i10 -= i22;
        }
        return new PartitionResult(i9, i10);
    }

    private int trPivot(int i6, int i7, int i8, int i9, int i10) {
        int i11 = i10 - i9;
        int i12 = i9 + (i11 / 2);
        if (i11 <= 512) {
            if (i11 <= 32) {
                return trMedian3(i6, i7, i8, i9, i12, i10 - 1);
            }
            int i13 = i11 >> 2;
            int i14 = i10 - 1;
            return trMedian5(i6, i7, i8, i9, i9 + i13, i12, i14 - i13, i14);
        }
        int i15 = i11 >> 3;
        int i16 = i15 << 1;
        int i17 = i10 - 1;
        return trMedian3(i6, i7, i8, trMedian3(i6, i7, i8, i9, i9 + i15, i9 + i16), trMedian3(i6, i7, i8, i12 - i15, i12, i12 + i15), trMedian3(i6, i7, i8, i17 - i16, i17 - i15, i17));
    }

    private void trSort(int i6, int i7, int i8) {
        int i9;
        int i10;
        int[] iArr = this.SA;
        if ((-i7) >= iArr[0]) {
            return;
        }
        TRBudget tRBudget = new TRBudget(i7, ((trLog(i7) * 2) / 3) + 1);
        int i11 = 0;
        while (true) {
            int i12 = iArr[i11];
            if (i12 < 0) {
                i11 -= i12;
                i9 = i6;
                i10 = i7;
            } else {
                int i13 = iArr[i12 + i6] + 1;
                if (1 < i13 - i11) {
                    i9 = i6;
                    i10 = i7;
                    trIntroSort(i9, i6 + i8, i6 + i7, i11, i13, tRBudget, i10);
                    if (tRBudget.chance == 0) {
                        if (i11 > 0) {
                            iArr[0] = -i11;
                        }
                        lsSort(i9, i10, i8);
                        return;
                    }
                } else {
                    i9 = i6;
                    i10 = i7;
                }
                i11 = i13;
            }
            if (i11 >= i10) {
                return;
            }
            i6 = i9;
            i7 = i10;
        }
    }

    public int bwt() {
        int[] iArr = this.SA;
        byte[] bArr = this.T;
        int i6 = this.f43061n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i6 == 0) {
            return 0;
        }
        if (i6 == 1) {
            iArr[0] = bArr[0];
            return 0;
        }
        if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        }
        return 0;
    }

    Bzip2DivSufSort(byte[] bArr, int[] iArr, int i6) {
        this.T = bArr;
        this.SA = iArr;
        this.f43061n = i6;
    }

    private static int ssLog(int i6) {
        if ((65280 & i6) != 0) {
            return LOG_2_TABLE[(i6 >> 8) & 255] + 8;
        }
        return LOG_2_TABLE[i6 & 255];
    }
}
