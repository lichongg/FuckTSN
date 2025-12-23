package com.bytedance.sdk.openadsdk.i;

import android.util.SparseArray;
import r0.a;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private final SparseArray<Object> f31505j;

    private r() {
        this.f31505j = new SparseArray<>();
    }

    public static r j() {
        return new r();
    }

    public static r j(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new r(sparseArray);
    }

    public SparseArray<Object> xt() {
        return this.f31505j;
    }

    public r(SparseArray<Object> sparseArray) {
        this.f31505j = a.a().c() < 6803 ? new xt(sparseArray) : sparseArray;
    }

    public r j(int i6) {
        this.f31505j.put(-99999987, Integer.valueOf(i6));
        return this;
    }

    public r j(Class<?> cls) {
        this.f31505j.put(-99999985, cls);
        return this;
    }

    public r j(int i6, Object obj) {
        this.f31505j.put(i6, obj);
        return this;
    }
}
