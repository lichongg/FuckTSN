package com.bytedance.sdk.openadsdk.i;

import android.util.SparseArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt<E> extends SparseArray<E> {

    /* renamed from: j, reason: collision with root package name */
    private final SparseArray<Object> f31507j;

    @Override // android.util.SparseArray
    public E get(int i6, E e6) {
        Object obj;
        E e7 = (E) super.get(i6, null);
        if (e7 != null) {
            return e7;
        }
        SparseArray<Object> sparseArray = this.f31507j;
        if (sparseArray != null && (obj = sparseArray.get(i6, null)) != null) {
            e7 = (E) obj;
        }
        return e7 != null ? e7 : e6;
    }

    public SparseArray<Object> j() {
        return this.f31507j;
    }

    public xt(SparseArray<Object> sparseArray) {
        this.f31507j = sparseArray;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i6) {
        if (!super.contains(i6)) {
            SparseArray<Object> sparseArray = this.f31507j;
            if (sparseArray == null || sparseArray.indexOfKey(i6) < 0) {
                return false;
            }
            return true;
        }
        return true;
    }
}
