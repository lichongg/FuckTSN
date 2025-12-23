package com.bytedance.sdk.openadsdk.cw;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.cw.j;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements j.InterfaceC0500j {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f31370j;

    @Override // com.bytedance.sdk.openadsdk.cw.j.InterfaceC0500j
    public void j() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.f31370j;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.cw.j.InterfaceC0500j
    public void xt() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.f31370j;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31370j = function;
    }
}
