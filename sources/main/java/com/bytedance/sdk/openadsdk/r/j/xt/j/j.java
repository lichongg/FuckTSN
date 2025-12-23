package com.bytedance.sdk.openadsdk.r.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31814j;

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, xtVar);
        sparseArray.put(-99999987, 111101);
        sparseArray.put(-99999985, Void.class);
        this.f31814j.apply(sparseArray);
    }

    public void xt(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, xtVar);
        sparseArray.put(-99999987, 111102);
        sparseArray.put(-99999985, Void.class);
        this.f31814j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31814j = function == null ? e.f22772d : function;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, int i6) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, xtVar);
        sparseArray.put(1, Integer.valueOf(i6));
        sparseArray.put(-99999987, 111103);
        sparseArray.put(-99999985, Void.class);
        this.f31814j.apply(sparseArray);
    }
}
