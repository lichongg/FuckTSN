package com.bytedance.msdk.core.ae;

import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static void j(List<Integer> list) {
        if (list == null) {
            return;
        }
        while (list.contains(null)) {
            list.remove((Object) null);
        }
        if (list.size() <= 1) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = list.get(i6).intValue();
        }
        for (int i7 = 1; i7 < size; i7++) {
            int i8 = iArr[i7];
            int i9 = i7;
            while (i9 > 0) {
                int i10 = iArr[i9 - 1];
                if (i10 > i8) {
                    iArr[i9] = i10;
                    i9--;
                }
            }
            iArr[i9] = i8;
        }
        list.clear();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                list.add(Integer.valueOf(iArr[i11]));
            } catch (RuntimeException unused) {
                return;
            }
        }
    }
}
