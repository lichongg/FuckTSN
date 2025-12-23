package com.bytedance.sdk.openadsdk.tj.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bytedance.sdk.openadsdk.i.cw.xt.g;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31845j;

    public void j(int i6, String str) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 172101);
        sparseArray.put(-99999985, Void.class);
        this.f31845j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31845j = function == null ? e.f22772d : function;
    }

    public void j(List<g> list) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, list);
        sparseArray.put(-99999987, 172102);
        sparseArray.put(-99999985, Void.class);
        this.f31845j.apply(sparseArray);
    }
}
