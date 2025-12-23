package com.bytedance.sdk.openadsdk.i.cw.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31406j;

    public abstract int j();

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
        return cw().sparseArray();
    }

    public abstract String xt();

    public PluginValueSet cw() {
        PluginValueSet pluginValueSet = this.f31406j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet r5 = r();
        this.f31406j = r5;
        return r5;
    }

    private PluginValueSet r() {
        e a6 = e.a();
        a6.f(263001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.j.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(j.this.j());
            }
        }));
        a6.f(263002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.j.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public String get() {
                return j.this.xt();
            }
        }));
        return a6.k();
    }
}
