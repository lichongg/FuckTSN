package com.bytedance.sdk.openadsdk.mediation.xt.xt.j;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.sdk.openadsdk.x.j.xt.j.j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31791j;

    public void j(int i6, String str) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 131106);
        sparseArray.put(-99999985, Void.class);
        this.f31791j.apply(sparseArray);
    }

    public void ae() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 131108);
        sparseArray.put(-99999985, Void.class);
        this.f31791j.apply(sparseArray);
    }

    public void m() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 131107);
        sparseArray.put(-99999985, Void.class);
        this.f31791j.apply(sparseArray);
    }

    public void tl() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 131109);
        sparseArray.put(-99999985, Void.class);
        this.f31791j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f31791j = function == null ? e.f22772d : function;
    }

    public void j(Bundle bundle) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, bundle);
        sparseArray.put(-99999987, 131110);
        sparseArray.put(-99999985, Void.class);
        this.f31791j.apply(sparseArray);
    }
}
