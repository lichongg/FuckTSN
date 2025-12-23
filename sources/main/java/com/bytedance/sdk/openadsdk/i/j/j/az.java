package com.bytedance.sdk.openadsdk.i.j.j;

import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.f;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class az {
    public static Function<SparseArray<Object>, Object> j(Object obj) {
        return f.a(obj) ? b.a(obj) : a.f22765e;
    }

    public static Integer[] j(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            numArr[i6] = Integer.valueOf(iArr[i6]);
        }
        return numArr;
    }
}
