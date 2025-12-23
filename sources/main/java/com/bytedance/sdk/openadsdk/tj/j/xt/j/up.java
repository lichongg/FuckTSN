package com.bytedance.sdk.openadsdk.tj.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31844j;

    public void j(int i6, String str) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 143101);
        sparseArray.put(-99999985, Void.class);
        this.f31844j.apply(sparseArray);
    }

    public up(Function<SparseArray<Object>, Object> function) {
        this.f31844j = function == null ? e.f22772d : function;
    }

    public void j(List<jy> list) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, list);
        sparseArray.put(-99999987, 143102);
        sparseArray.put(-99999985, Void.class);
        this.f31844j.apply(sparseArray);
    }
}
