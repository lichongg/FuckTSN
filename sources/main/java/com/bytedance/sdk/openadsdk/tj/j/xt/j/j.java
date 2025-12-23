package com.bytedance.sdk.openadsdk.tj.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31841j;

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, xtVar);
        sparseArray.put(-99999987, 114102);
        sparseArray.put(-99999985, Void.class);
        this.f31841j.apply(sparseArray);
    }

    public void xt(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, xtVar);
        sparseArray.put(-99999987, 114104);
        sparseArray.put(-99999985, Void.class);
        this.f31841j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31841j = function == null ? e.f22772d : function;
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.j jVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, jVar);
        sparseArray.put(-99999987, 114103);
        sparseArray.put(-99999985, Void.class);
        this.f31841j.apply(sparseArray);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.xt.xt xtVar, com.bytedance.sdk.openadsdk.i.cw.xt.j jVar) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, xtVar);
        sparseArray.put(1, jVar);
        sparseArray.put(-99999987, 114105);
        sparseArray.put(-99999985, Void.class);
        this.f31841j.apply(sparseArray);
    }
}
