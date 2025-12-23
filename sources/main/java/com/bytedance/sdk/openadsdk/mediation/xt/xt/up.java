package com.bytedance.sdk.openadsdk.mediation.xt.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f31794j;

    public List<String> cw() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271046);
        sparseArray.put(-99999985, List.class);
        apply = this.f31794j.apply(sparseArray);
        return (List) apply;
    }

    public int j() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 271044);
        sparseArray.put(-99999985, Integer.TYPE);
        apply = this.f31794j.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    public up(Function<SparseArray<Object>, Object> function) {
        this.f31794j = function == null ? e.f22772d : function;
    }

    public j xt() {
        Object apply;
        apply = this.f31794j.apply(com.bytedance.sdk.openadsdk.i.r.j().j(271045).j(SparseArray.class).xt());
        if (apply instanceof SparseArray) {
            return new j((SparseArray) apply);
        }
        return null;
    }
}
