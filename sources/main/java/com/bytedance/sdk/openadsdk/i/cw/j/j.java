package com.bytedance.sdk.openadsdk.i.cw.j;

import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31386j;

    public void j() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 223101);
        sparseArray.put(-99999985, Void.class);
        this.f31386j.apply(sparseArray);
    }

    public j(Object obj) {
        Function<SparseArray<Object>, Object> function;
        if (obj != null) {
            function = b.a(obj);
        } else {
            function = e.f22772d;
        }
        this.f31386j = function;
    }
}
