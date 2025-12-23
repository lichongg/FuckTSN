package com.bytedance.sdk.openadsdk.mediation.xt.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31789j;

    public void j(String str, com.bytedance.sdk.openadsdk.mediation.xt.xt.xt.j jVar) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, str);
        sparseArray.put(1, jVar);
        sparseArray.put(-99999987, 270029);
        sparseArray.put(-99999985, Void.class);
        this.f31789j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31789j = function == null ? e.f22772d : function;
    }

    public void j(int i6, String str) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 270030);
        sparseArray.put(-99999985, Void.class);
        this.f31789j.apply(sparseArray);
    }
}
