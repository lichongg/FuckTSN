package com.bytedance.sdk.openadsdk.i.cw.xt;

import a1.a;
import a1.b;
import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Supplier;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class ws extends tl {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31448j;

    public abstract void ae();

    public abstract int cw();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up g();

    public abstract View j();

    public abstract ae j(Activity activity);

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
            return vl().sparseArray();
        }
        switch (intValue) {
            case 150101:
                j(new com.bytedance.sdk.openadsdk.s.j.xt.j.xt(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 150102:
                j(new com.bytedance.sdk.openadsdk.s.j.xt.j.j(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 150103:
                j(new com.bytedance.sdk.openadsdk.i.cw.j.cw(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 150104:
                r();
                return null;
            case 150105:
                up();
                return null;
            case 150106:
                j((Activity) k6.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(b.a(k6.objectValue(1, a.a()))));
                return null;
            case 150107:
                Dialog dialog = (Dialog) k6.objectValue(0, Dialog.class);
                Integer[] numArr = (Integer[]) k6.arrayValue(1, Integer.class);
                if (numArr == null) {
                    numArr = new Integer[0];
                }
                j(dialog, numArr);
                return null;
            case 150108:
                return j((Activity) k6.objectValue(0, Activity.class));
            case 150109:
                k6.objectValue(0, Activity.class);
                return null;
            case 150110:
                j(k6.intValue(0));
                return null;
            case 150111:
                j(new com.bytedance.sdk.openadsdk.s.j.xt.j.cw(b.a(k6.objectValue(0, a.a()))));
                return null;
            case 150112:
                j(k6.booleanValue(0));
                return null;
            case 150113:
                return g();
            case 150114:
                j((String) k6.objectValue(0, String.class));
                return null;
            case 150115:
                j((JSONObject) k6.objectValue(0, JSONObject.class));
                return null;
            case 150116:
                ae();
                return null;
            default:
                return super.apply(sparseArray);
        }
    }

    public abstract void j(int i6);

    public abstract void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar);

    public abstract void j(Dialog dialog, Integer[] numArr);

    public abstract void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar);

    public abstract void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar);

    public abstract void j(com.bytedance.sdk.openadsdk.s.j.xt.j.j jVar);

    public abstract void j(com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar);

    public abstract void j(String str);

    public abstract void j(JSONObject jSONObject);

    public abstract void j(boolean z5);

    public abstract r m();

    public abstract void r();

    public abstract Map<String, Object> tl();

    public abstract void up();

    public abstract int xt();

    public PluginValueSet vl() {
        PluginValueSet pluginValueSet = this.f31448j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet oq = oq();
        this.f31448j = oq;
        return oq;
    }

    private PluginValueSet oq() {
        e a6 = e.a();
        a6.f(150001, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.ws.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public View get() {
                return ws.this.j();
            }
        }));
        a6.f(150002, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.ws.2
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ws.this.xt());
            }
        }));
        a6.f(150003, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<r>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.ws.3
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public r get() {
                return ws.this.m();
            }
        }));
        a6.f(150004, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.ws.4
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ws.this.cw());
            }
        }));
        a6.f(150005, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.i.cw.xt.ws.5
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return ws.this.tl();
            }
        }));
        return a6.k();
    }
}
