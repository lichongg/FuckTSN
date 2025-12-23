package com.bytedance.sdk.openadsdk.tj.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bytedance.sdk.openadsdk.i.cw.xt.az;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31839j;

    public void j(int i6, String str) {
        SparseArray sparseArray = new SparseArray(4);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 124101);
        sparseArray.put(-99999985, Void.class);
        this.f31839j.apply(sparseArray);
    }

    public void xt(az azVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, azVar);
        sparseArray.put(-99999987, 124103);
        sparseArray.put(-99999985, Void.class);
        this.f31839j.apply(sparseArray);
    }

    public ae(Function<SparseArray<Object>, Object> function) {
        this.f31839j = function == null ? e.f22772d : function;
    }

    public void j(az azVar) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(0, azVar);
        sparseArray.put(-99999987, 124102);
        sparseArray.put(-99999985, Void.class);
        this.f31839j.apply(sparseArray);
    }

    public void j() {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 124104);
        sparseArray.put(-99999985, Void.class);
        this.f31839j.apply(sparseArray);
    }
}
