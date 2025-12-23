package io.netty.handler.codec.compression;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class Bzip2HuffmanAllocator {
    static void allocateHuffmanCodeLengths(int[] iArr, int i6) {
        int length = iArr.length;
        if (length != 1) {
            if (length != 2) {
                setExtendedParentPointers(iArr);
                int findNodesToRelocate = findNodesToRelocate(iArr, i6);
                if (iArr[0] % iArr.length >= findNodesToRelocate) {
                    allocateNodeLengths(iArr);
                    return;
                } else {
                    allocateNodeLengthsWithRelocation(iArr, findNodesToRelocate, i6 - (32 - Integer.numberOfLeadingZeros(findNodesToRelocate - 1)));
                    return;
                }
            }
            iArr[1] = 1;
        }
        iArr[0] = 1;
    }

    private static void allocateNodeLengths(int[] iArr) {
        int i6 = 2;
        int length = iArr.length - 2;
        int i7 = 1;
        int length2 = iArr.length - 1;
        while (i6 > 0) {
            int first = first(iArr, length - 1, 0);
            int i8 = length - first;
            int i9 = i6 - i8;
            while (i9 > 0) {
                iArr[length2] = i7;
                i9--;
                length2--;
            }
            i6 = i8 << 1;
            i7++;
            length = first;
        }
    }

    private static void allocateNodeLengthsWithRelocation(int[] iArr, int i6, int i7) {
        int i8;
        int length = iArr.length - 2;
        int length2 = iArr.length - 1;
        int i9 = i7 != 1 ? 1 : 2;
        int i10 = i7 == 1 ? i6 - 2 : i6;
        int i11 = i9 << 1;
        while (i11 > 0) {
            int first = length <= i6 ? length : first(iArr, length - 1, i6);
            if (i9 >= i7) {
                i8 = Math.min(i10, 1 << (i9 - i7));
            } else if (i9 == i7 - 1) {
                if (iArr[first] == length) {
                    first++;
                }
                i8 = 1;
            } else {
                i8 = 0;
            }
            int i12 = (length - first) + i8;
            int i13 = i11 - i12;
            while (i13 > 0) {
                iArr[length2] = i9;
                i13--;
                length2--;
            }
            i10 -= i8;
            i11 = i12 << 1;
            i9++;
            length = first;
        }
    }

    private static int findNodesToRelocate(int[] iArr, int i6) {
        int length = iArr.length - 2;
        for (int i7 = 1; i7 < i6 - 1 && length > 1; i7++) {
            length = first(iArr, length - 1, 0);
        }
        return length;
    }

    private static int first(int[] iArr, int i6, int i7) {
        int length = iArr.length;
        int length2 = iArr.length - 2;
        int i8 = i6;
        while (i8 >= i7 && iArr[i8] % length > i6) {
            length2 = i8;
            i8 -= (i6 - i8) + 1;
        }
        int max = Math.max(i7 - 1, i8);
        while (length2 > max + 1) {
            int i9 = (max + length2) >>> 1;
            if (iArr[i9] % length > i6) {
                length2 = i9;
            } else {
                max = i9;
            }
        }
        return length2;
    }

    private static void setExtendedParentPointers(int[] iArr) {
        int i6;
        int i7;
        int length = iArr.length;
        int i8 = 0;
        iArr[0] = iArr[0] + iArr[1];
        int i9 = 2;
        for (int i10 = 1; i10 < length - 1; i10++) {
            if (i9 < length) {
                int i11 = iArr[i8];
                i6 = iArr[i9];
                if (i11 >= i6) {
                    i9++;
                    if (i9 < length || (i8 < i10 && iArr[i8] < iArr[i9])) {
                        i7 = i6 + iArr[i8];
                        iArr[i8] = i10 + length;
                        i8++;
                    } else {
                        i7 = i6 + iArr[i9];
                        i9++;
                    }
                    iArr[i10] = i7;
                }
            }
            i6 = iArr[i8];
            iArr[i8] = i10;
            i8++;
            if (i9 < length) {
            }
            i7 = i6 + iArr[i8];
            iArr[i8] = i10 + length;
            i8++;
            iArr[i10] = i7;
        }
    }

    private Bzip2HuffmanAllocator() {
    }
}
