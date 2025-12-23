package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j;

import android.util.SparseArray;
import android.view.View;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31668j;

    public View j(com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt.j jVar) {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, jVar);
        sparseArray.put(-99999987, 266013);
        sparseArray.put(-99999985, View.class);
        apply = this.f31668j.apply(sparseArray);
        return (View) apply;
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31668j = function == null ? e.f22772d : function;
    }
}
