package com.github.barteksc.pdfviewer.util;

import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ArrayUtils {
    public static int[] calculateIndexesInDuplicateArray(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length != 0) {
            int i6 = 0;
            iArr2[0] = 0;
            for (int i7 = 1; i7 < iArr.length; i7++) {
                if (iArr[i7] != iArr[i7 - 1]) {
                    i6++;
                }
                iArr2[i7] = i6;
            }
        }
        return iArr2;
    }

    public static String arrayToString(int[] iArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i6 = 0; i6 < iArr.length; i6++) {
            sb.append(iArr[i6]);
            if (i6 != iArr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int[] deleteDuplicatedPages(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i6 = -1;
        int i7 = 0;
        while (i7 < length) {
            int i8 = iArr[i7];
            Integer valueOf = Integer.valueOf(i8);
            if (i6 != i8) {
                arrayList.add(valueOf);
            }
            i7++;
            i6 = i8;
        }
        int[] iArr2 = new int[arrayList.size()];
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            iArr2[i9] = ((Integer) arrayList.get(i9)).intValue();
        }
        return iArr2;
    }

    private ArrayUtils() {
    }
}
