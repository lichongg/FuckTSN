package com.bytedance.sdk.openadsdk.api;

import a1.a;
import a1.b;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Manager {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f27525j;

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i6) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -999800);
        sparseArray.put(-998000, context);
        sparseArray.put(-99999985, a.a());
        apply = this.f27525j.apply(sparseArray);
        return new xt(b.a(apply));
    }

    public Function<SparseArray<Object>, Object> j(int i6) {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        if (i6 == 1) {
            i6 = 999801;
        }
        sparseArray.put(-99999987, Integer.valueOf(i6));
        apply = this.f27525j.apply(sparseArray);
        if (f.a(apply)) {
            return b.a(apply);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public ValueSet values() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, -99999986);
        apply = this.f27525j.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return com.bykv.j.j.j.j.a.j((SparseArray) apply).k();
        }
        return null;
    }

    public cw(Function<SparseArray<Object>, Object> function) {
        this.f27525j = function == null ? com.bykv.j.j.j.j.a.f22765e : function;
    }
}
