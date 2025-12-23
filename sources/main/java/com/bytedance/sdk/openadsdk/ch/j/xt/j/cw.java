package com.bytedance.sdk.openadsdk.ch.j.xt.j;

import android.util.SparseArray;
import android.view.View;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f27750j;

    public void j(View view, float f6, float f7, boolean z5) {
        SparseArray sparseArray = new SparseArray(6);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f6));
        sparseArray.put(2, Float.valueOf(f7));
        sparseArray.put(3, Boolean.valueOf(z5));
        sparseArray.put(-99999987, 142101);
        sparseArray.put(-99999985, Void.class);
        this.f27750j.apply(sparseArray);
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        this.f27750j = function == null ? e.f22772d : function;
    }
}
