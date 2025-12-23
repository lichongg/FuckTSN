package com.bytedance.sdk.openadsdk.s.j.xt.j;

import android.util.SparseArray;
import android.view.View;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31832j;

    public void j(View view, int i6) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        sparseArray.put(1, Integer.valueOf(i6));
        sparseArray.put(-99999987, 151101);
        sparseArray.put(-99999985, Void.class);
        this.f31832j.apply(sparseArray);
    }

    public void xt(View view, int i6) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, view);
        sparseArray.put(1, Integer.valueOf(i6));
        sparseArray.put(-99999987, 151102);
        sparseArray.put(-99999985, Void.class);
        this.f31832j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31832j = function == null ? e.f22772d : function;
    }

    public void j(View view, String str, int i6) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i6));
        sparseArray.put(-99999987, 151103);
        sparseArray.put(-99999985, Void.class);
        this.f31832j.apply(sparseArray);
    }

    public void j(View view, float f6, float f7) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f6));
        sparseArray.put(2, Float.valueOf(f7));
        sparseArray.put(-99999987, 151104);
        sparseArray.put(-99999985, Void.class);
        this.f31832j.apply(sparseArray);
    }
}
