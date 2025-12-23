package com.bytedance.sdk.openadsdk.mediation.xt.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31790j;

    public void j(int i6) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(-99999987, 270025);
        sparseArray.put(-99999985, Void.class);
        this.f31790j.apply(sparseArray);
    }

    public r(Function<SparseArray<Object>, Object> function) {
        this.f31790j = function == null ? e.f22772d : function;
    }
}
