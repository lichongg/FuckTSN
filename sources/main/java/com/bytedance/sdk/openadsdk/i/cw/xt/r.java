package com.bytedance.sdk.openadsdk.i.cw.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31439j;

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue != -99999986) {
            return null;
        }
        return xt();
    }

    public abstract List<m> j();

    public SparseArray<Object> xt() {
        SparseArray<Object> sparseArray = this.f31439j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> cw = cw();
        this.f31439j = cw;
        return cw;
    }

    private SparseArray<Object> cw() {
        com.bytedance.sdk.openadsdk.i.r j6 = com.bytedance.sdk.openadsdk.i.r.j();
        j6.j(243001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<List<m>>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.r.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public List<m> get() {
                return r.this.j();
            }
        }));
        return j6.xt();
    }
}
