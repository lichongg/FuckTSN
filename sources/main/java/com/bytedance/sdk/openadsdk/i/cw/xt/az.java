package com.bytedance.sdk.openadsdk.i.cw.xt;

import a1.a;
import a1.b;
import android.app.Activity;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class az extends tl {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31390j;

    public abstract int cw();

    public abstract int j();

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl, java.util.function.Function
    /* renamed from: j */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return tl().sparseArray();
        }
        if (intValue == 121109) {
            return up();
        }
        switch (intValue) {
            case 120101:
                j(new com.bytedance.sdk.openadsdk.a.j.xt.j.j(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 120102:
                xt(new com.bytedance.sdk.openadsdk.a.j.xt.j.j(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 120103:
                j(new com.bytedance.sdk.openadsdk.a.j.xt.j.xt(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 120104:
                j(new com.bytedance.sdk.openadsdk.i.cw.j.cw(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 120105:
                j((Activity) k6.objectValue(0, Activity.class));
                return null;
            case 120106:
                j((Activity) k6.objectValue(0, Activity.class), k6.objectValue(1, Object.class), (String) k6.objectValue(2, String.class));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void j(Activity activity);

    public abstract void j(Activity activity, Object obj, String str);

    public abstract void j(com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar);

    public abstract void j(com.bytedance.sdk.openadsdk.a.j.xt.j.xt xtVar);

    public abstract void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar);

    public abstract long r();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.m up();

    public abstract Map<String, Object> xt();

    public abstract void xt(com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar);

    public PluginValueSet tl() {
        PluginValueSet pluginValueSet = this.f31390j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet m6 = m();
        this.f31390j = m6;
        return m6;
    }

    private PluginValueSet m() {
        e a6 = e.a();
        a6.f(120001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.az.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(az.this.j());
            }
        }));
        a6.f(120002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.az.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return az.this.xt();
            }
        }));
        a6.f(120003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.az.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(az.this.cw());
            }
        }));
        a6.f(120004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Long>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.az.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(az.this.r());
            }
        }));
        return a6.k();
    }
}
