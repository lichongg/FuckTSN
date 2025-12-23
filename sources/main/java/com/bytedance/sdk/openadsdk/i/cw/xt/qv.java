package com.bytedance.sdk.openadsdk.i.cw.xt;

import a1.a;
import a1.b;
import android.app.Activity;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class qv extends tl {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31434j;

    public abstract int cw();

    public abstract int j();

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl, java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        if (intValue == -99999986) {
            return tl().sparseArray();
        }
        if (intValue == 130106) {
            return up();
        }
        switch (intValue) {
            case 130101:
                Function a6 = b.a(k6.objectValue(0, a.a()));
                j(k6.intValue(1) == 1 ? new com.bytedance.sdk.openadsdk.mediation.xt.xt.j.xt(a6) : new com.bytedance.sdk.openadsdk.x.j.xt.j.j(a6));
                return null;
            case 130102:
                j(new com.bytedance.sdk.openadsdk.i.cw.j.cw(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 130103:
                j((Activity) k6.objectValue(0, Activity.class));
                return null;
            case 130104:
                j((Activity) k6.objectValue(0, Activity.class), k6.objectValue(1, Object.class), (String) k6.objectValue(2, String.class));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void j(Activity activity);

    public abstract void j(Activity activity, Object obj, String str);

    public abstract void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar);

    public abstract void j(com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar);

    public abstract long r();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.r up();

    public abstract Map<String, Object> xt();

    public PluginValueSet tl() {
        PluginValueSet pluginValueSet = this.f31434j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet m6 = m();
        this.f31434j = m6;
        return m6;
    }

    private PluginValueSet m() {
        e a6 = e.a();
        a6.f(130001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.qv.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(qv.this.j());
            }
        }));
        a6.f(130002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.qv.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return qv.this.xt();
            }
        }));
        a6.f(130003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.qv.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(qv.this.cw());
            }
        }));
        a6.f(130004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Long>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.qv.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(qv.this.r());
            }
        }));
        return a6.k();
    }
}
