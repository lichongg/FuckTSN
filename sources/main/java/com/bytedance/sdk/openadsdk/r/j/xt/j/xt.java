package com.bytedance.sdk.openadsdk.r.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31815j;

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, xtVar);
        sparseArray.put(-99999987, 121201);
        sparseArray.put(-99999985, Void.class);
        this.f31815j.apply(sparseArray);
    }

    public void xt() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 112103);
        sparseArray.put(-99999985, Void.class);
        this.f31815j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31815j = function == null ? e.f22772d : function;
    }

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 112102);
        sparseArray.put(-99999985, Void.class);
        this.f31815j.apply(sparseArray);
    }
}
