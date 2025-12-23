package com.bytedance.msdk.core.j.j.xt.j.m;

import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24574j;

    public int j() {
        Object apply;
        if (this.f24574j == null) {
            return -998;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40005);
        sparseArray.put(-99999985, Integer.class);
        apply = this.f24574j.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    public String xt() {
        Object apply;
        if (this.f24574j == null) {
            return "adn no msg";
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 40006);
        sparseArray.put(-99999985, String.class);
        apply = this.f24574j.apply(sparseArray);
        return (String) apply;
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f24574j = function;
    }
}
