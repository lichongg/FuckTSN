package com.bytedance.sdk.openadsdk.v.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31959j;

    public void j(int i6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(-99999987, 163101);
        sparseArray.put(-99999985, Void.class);
        this.f31959j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31959j = function == null ? e.f22772d : function;
    }
}
