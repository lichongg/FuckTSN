package com.bytedance.sdk.openadsdk.i.cw.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31387j;

    public void j(int i6, Map map) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, map);
        sparseArray.put(-99999987, 100101);
        sparseArray.put(-99999985, Void.class);
        this.f31387j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31387j = function == null ? e.f22772d : function;
    }
}
