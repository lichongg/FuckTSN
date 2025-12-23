package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31665j;

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 270012);
        sparseArray.put(-99999985, Void.class);
        this.f31665j.apply(sparseArray);
    }

    public m(Function<SparseArray<Object>, Object> function) {
        this.f31665j = function == null ? e.f22772d : function;
    }
}
