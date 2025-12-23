package com.bytedance.sdk.openadsdk.core.ch;

import android.util.SparseArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    private SparseArray<Object> cw;

    /* renamed from: j, reason: collision with root package name */
    private int f28020j;
    private com.bytedance.sdk.openadsdk.i.j xt;

    public com.bytedance.sdk.openadsdk.i.j cw() {
        return this.xt;
    }

    public int getType() {
        return this.f28020j;
    }

    public SparseArray<Object> r() {
        return this.cw;
    }

    public void setResult(SparseArray<Object> sparseArray) {
        this.xt = new com.bytedance.sdk.openadsdk.i.j(sparseArray);
    }

    public tl(SparseArray<Object> sparseArray, int i6) {
        SparseArray<Object> sparseArray2;
        this.f28020j = i6;
        if (sparseArray != null) {
            sparseArray2 = sparseArray;
        } else {
            sparseArray2 = new SparseArray<>();
        }
        this.cw = sparseArray2;
        this.xt = new com.bytedance.sdk.openadsdk.i.j(sparseArray);
    }
}
