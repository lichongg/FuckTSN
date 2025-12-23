package com.bytedance.pangle.util;

import androidx.annotation.Nullable;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public static <T> boolean j(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> int xt(@Nullable T[] tArr, T t5) {
        if (tArr == null) {
            return -1;
        }
        for (int i6 = 0; i6 < tArr.length; i6++) {
            T t6 = tArr[i6];
            if (t6 == t5 || (t6 != null && t6.equals(t5))) {
                return i6;
            }
        }
        return -1;
    }

    public static <T> boolean j(@Nullable T[] tArr, T t5) {
        return xt(tArr, t5) != -1;
    }

    public static <T> boolean j(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t5 : tArr2) {
            if (!j(tArr, t5)) {
                return false;
            }
        }
        return true;
    }
}
