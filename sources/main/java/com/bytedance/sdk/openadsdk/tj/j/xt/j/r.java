package com.bytedance.sdk.openadsdk.tj.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bytedance.sdk.openadsdk.i.cw.xt.qv;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31843j;

    public void j(int i6, String str) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 132101);
        sparseArray.put(-99999985, Void.class);
        this.f31843j.apply(sparseArray);
    }

    public void xt(qv qvVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, qvVar);
        sparseArray.put(-99999987, 132103);
        sparseArray.put(-99999985, Void.class);
        this.f31843j.apply(sparseArray);
    }

    public r(Function<SparseArray<Object>, Object> function) {
        this.f31843j = function == null ? e.f22772d : function;
    }

    public void j(qv qvVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, qvVar);
        sparseArray.put(-99999987, 132102);
        sparseArray.put(-99999985, Void.class);
        this.f31843j.apply(sparseArray);
    }

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 132104);
        sparseArray.put(-99999985, Void.class);
        this.f31843j.apply(sparseArray);
    }
}
