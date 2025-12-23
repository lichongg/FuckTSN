package com.bytedance.sdk.openadsdk.a.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f27520j;

    public void j(int i6, com.bytedance.sdk.openadsdk.w.j.j.xt.j.j jVar) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, jVar);
        sparseArray.put(-99999987, 122101);
        sparseArray.put(-99999985, Void.class);
        this.f27520j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f27520j = function == null ? e.f22772d : function;
    }
}
