package com.bytedance.sdk.openadsdk.ch.j.xt.j;

import android.util.SparseArray;
import android.view.View;
import com.bykv.j.j.j.j.e;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f27751j;

    public void j(View view, jy jyVar) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        sparseArray.put(1, jyVar);
        sparseArray.put(-99999987, 141101);
        sparseArray.put(-99999985, Void.class);
        this.f27751j.apply(sparseArray);
    }

    public void xt(View view, jy jyVar) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        sparseArray.put(1, jyVar);
        sparseArray.put(-99999987, 141102);
        sparseArray.put(-99999985, Void.class);
        this.f27751j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f27751j = function == null ? e.f22772d : function;
    }

    public void j(jy jyVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, jyVar);
        sparseArray.put(-99999987, 141103);
        sparseArray.put(-99999985, Void.class);
        this.f27751j.apply(sparseArray);
    }
}
