package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j;

import android.util.SparseArray;
import android.view.View;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends com.bytedance.sdk.openadsdk.ch.j.xt.j.cw {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31667j;

    public void j(View view, String str, int i6) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i6));
        sparseArray.put(-99999987, 142102);
        sparseArray.put(-99999985, Void.class);
        this.f31667j.apply(sparseArray);
    }

    public void xt() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 142104);
        sparseArray.put(-99999985, Void.class);
        this.f31667j.apply(sparseArray);
    }

    public up(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f31667j = function == null ? e.f22772d : function;
    }

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 142103);
        sparseArray.put(-99999985, Void.class);
        this.f31667j.apply(sparseArray);
    }
}
