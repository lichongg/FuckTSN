package com.bytedance.sdk.openadsdk.s.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31831j;

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 151105);
        sparseArray.put(-99999985, Void.class);
        this.f31831j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f31831j = function == null ? e.f22772d : function;
    }
}
