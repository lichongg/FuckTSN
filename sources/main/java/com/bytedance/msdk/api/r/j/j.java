package com.bytedance.msdk.api.r.j;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static com.bytedance.msdk.api.j.xt j(int i6, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, Function<SparseArray<Object>, Object> function) {
        if (jVar == null) {
            return null;
        }
        com.bytedance.msdk.core.qv.j.j().j(function);
        return new com.bytedance.msdk.api.j.xt(i6, jVar.h());
    }
}
