package com.bytedance.sdk.openadsdk.i;

import android.util.SparseArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private final SparseArray<Object> f31506j = new SparseArray<>();

    public static up j() {
        return new up();
    }

    public up j(int i6) {
        this.f31506j.put(-999900, Integer.valueOf(i6));
        return this;
    }

    public SparseArray<Object> xt() {
        return this.f31506j;
    }

    private up() {
    }

    public up j(String str) {
        this.f31506j.put(-999901, str);
        return this;
    }

    public up j(boolean z5) {
        this.f31506j.put(-999903, Boolean.valueOf(z5));
        return this;
    }

    public up j(SparseArray<Object> sparseArray) {
        this.f31506j.put(-999902, sparseArray);
        return this;
    }
}
