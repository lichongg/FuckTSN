package com.bytedance.sdk.openadsdk.kt.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31553j;

    public void j() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 244101);
        sparseArray.put(-99999985, Void.class);
        this.f31553j.apply(sparseArray);
    }

    public void xt() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 244103);
        sparseArray.put(-99999985, Void.class);
        this.f31553j.apply(sparseArray);
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31553j = function == null ? e.f22772d : function;
    }

    public void j(int i6, String str, boolean z5) {
        SparseArray sparseArray = new SparseArray(5);
        sparseArray.put(0, Integer.valueOf(i6));
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z5));
        sparseArray.put(-99999987, 244102);
        sparseArray.put(-99999985, Void.class);
        this.f31553j.apply(sparseArray);
    }
}
