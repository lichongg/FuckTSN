package com.bytedance.sdk.openadsdk.i.xt.xt;

import a1.a;
import a1.b;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements Initializer {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31520j;

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        Object apply;
        if (this.f31520j == null) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999000);
        sparseArray.put(-99999985, a.a());
        apply = this.f31520j.apply(sparseArray);
        if (f.a(apply)) {
            return new r(b.a(apply));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        com.bytedance.sdk.openadsdk.i.xt.j jVar = new com.bytedance.sdk.openadsdk.i.xt.j(valueSet);
        jVar.put(-99999987, -999001);
        jVar.put(-99999985, Void.class);
        jVar.put(-998000, context);
        Function<SparseArray<Object>, Object> function = this.f31520j;
        if (function != null) {
            function.apply(jVar);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        Object apply;
        if (this.f31520j != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, -999002);
            sparseArray.put(-99999985, Boolean.TYPE);
            apply = this.f31520j.apply(sparseArray);
            if (apply != null && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31520j = function;
    }
}
