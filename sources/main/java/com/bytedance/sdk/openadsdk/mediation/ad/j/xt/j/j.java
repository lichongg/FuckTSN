package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31664j;

    public void j(int i6, String str) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 268013);
        sparseArray.put(-99999985, Void.class);
        this.f31664j.apply(sparseArray);
    }

    public void xt() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268015);
        sparseArray.put(-99999985, Void.class);
        this.f31664j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31664j = function == null ? e.f22772d : function;
    }

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 268014);
        sparseArray.put(-99999985, Void.class);
        this.f31664j.apply(sparseArray);
    }
}
