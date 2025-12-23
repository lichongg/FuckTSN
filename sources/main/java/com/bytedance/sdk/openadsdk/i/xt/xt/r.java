package com.bytedance.sdk.openadsdk.i.xt.xt;

import a1.b;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements Bridge, Manager {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31519j;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i6, ValueSet valueSet, Class<T> cls) {
        Object apply;
        Object apply2;
        if (this.f31519j == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.i.xt.j jVar = new com.bytedance.sdk.openadsdk.i.xt.j(valueSet);
        jVar.put(-99999987, Integer.valueOf(i6));
        jVar.put(-99999985, cls);
        apply = this.f31519j.apply(jVar);
        T t5 = (T) com.bytedance.sdk.openadsdk.i.xt.cw.j.xt(apply);
        if (t5 != null) {
            return t5;
        }
        apply2 = a.f22765e.apply(jVar);
        return (T) apply2;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        Object apply;
        if (this.f31519j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-99999985, a1.a.a());
        sparseArray.put(-998000, context);
        apply = this.f31519j.apply(sparseArray);
        if (f.a(apply)) {
            return new cw(b.a(apply));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i6) {
        Object apply;
        if (this.f31519j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        if (i6 == 1) {
            i6 = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i6));
        sparseArray.put(-99999985, a1.a.a());
        apply = this.f31519j.apply(sparseArray);
        if (f.a(apply)) {
            return new com.bytedance.sdk.openadsdk.i.xt.xt(b.a(apply));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Object apply;
        if (this.f31519j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        apply = this.f31519j.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return com.bytedance.sdk.openadsdk.i.xt.cw.j.xt((SparseArray<Object>) apply);
        }
        return null;
    }

    public r(Function<SparseArray<Object>, Object> function) {
        this.f31519j = function;
    }
}
