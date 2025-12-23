package com.bytedance.sdk.openadsdk.i.cw.xt;

import a1.a;
import a1.b;
import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt extends tl {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31454j;

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.ae ae();

    public abstract View cw();

    public PluginValueSet j() {
        PluginValueSet pluginValueSet = this.f31454j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet tl = tl();
        this.f31454j = tl;
        return tl;
    }

    public abstract void j(ViewGroup viewGroup);

    public abstract void j(ViewGroup viewGroup, Activity activity);

    public abstract void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar);

    public abstract void j(com.bytedance.sdk.openadsdk.r.j.xt.j.j jVar);

    public abstract void j(com.bytedance.sdk.openadsdk.r.j.xt.j.xt xtVar);

    public abstract void m();

    public abstract int r();

    public abstract Map<String, Object> up();

    public abstract View xt();

    private PluginValueSet tl() {
        e a6 = e.a();
        a6.f(110001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.xt.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public View get() {
                return xt.this.xt();
            }
        }));
        a6.f(110003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.xt.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public View get() {
                return xt.this.cw();
            }
        }));
        a6.f(110004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.xt.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(xt.this.r());
            }
        }));
        a6.f(110005, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.xt.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return xt.this.up();
            }
        }));
        return a6.k();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl, java.util.function.Function
    /* renamed from: j */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        switch (intValue) {
            case -99999986:
                return j().sparseArray();
            case 110101:
                m();
                return null;
            case 110102:
                j(new com.bytedance.sdk.openadsdk.i.cw.j.cw(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 110103:
                j(new com.bytedance.sdk.openadsdk.r.j.xt.j.j(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 110106:
                j(new com.bytedance.sdk.openadsdk.r.j.xt.j.xt(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 110108:
                j((ViewGroup) k6.objectValue(0, ViewGroup.class));
                return null;
            case 110109:
                j((ViewGroup) k6.objectValue(0, ViewGroup.class), (Activity) k6.objectValue(1, Activity.class));
                return null;
            case 110110:
                return ae();
            default:
                return super.apply(sparseArray);
        }
    }
}
