package com.bytedance.sdk.openadsdk.core.live.xt;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt implements Function<SparseArray<Object>, Object> {
    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null || ((Integer) sparseArray.get(-99999987)).intValue() != 1) {
            return null;
        }
        j(sparseArray.get(0, Object.class));
        return null;
    }

    protected abstract void j(Object obj);
}
