package com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt;

import a1.a;
import a1.b;
import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.i.cw.xt.ae;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f31670j;

    public abstract List<String> ae();

    public abstract String cw();

    public abstract int g();

    public abstract cw j(Activity activity);

    public abstract cw j(Activity activity, Map<String, Object> map);

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return ws().sparseArray();
        }
        switch (intValue) {
            case 268001:
                return j();
            case 268002:
                return xt();
            case 268003:
                return cw();
            case 268004:
                return r();
            case 268005:
                return up();
            case 268006:
                return Double.class.cast(Double.valueOf(m()));
            case 268007:
                return ae();
            case 268008:
                return tl();
            case 268009:
                return Integer.class.cast(Integer.valueOf(g()));
            case 268010:
                return Integer.class.cast(Integer.valueOf(oq()));
            case 268011:
                j((Activity) k6.objectValue(0, Activity.class), (ViewGroup) k6.objectValue(1, ViewGroup.class), (List) k6.objectValue(2, List.class), (List) k6.objectValue(3, List.class), (List) k6.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r(b.a(k6.objectValue(5, a.a()))));
                return null;
            case 268012:
                return Boolean.class.cast(Boolean.valueOf(vl()));
            default:
                switch (intValue) {
                    case 268016:
                        j((Activity) k6.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.kt.j.xt.j.j(b.a(k6.objectValue(1, a.a()))));
                        return null;
                    case 268017:
                        j((Dialog) k6.objectValue(0, Dialog.class), (Integer[]) k6.arrayValue(1, Integer.class));
                        return null;
                    case 268018:
                        return xt((Activity) k6.objectValue(0, Activity.class));
                    case 268019:
                        return xt((Dialog) k6.objectValue(0, Dialog.class), (Integer[]) k6.arrayValue(1, Integer.class));
                    case 268020:
                        return jy();
                    default:
                        switch (intValue) {
                            case 268102:
                                return j((Activity) k6.objectValue(0, Activity.class));
                            case 268103:
                                return j((Activity) k6.objectValue(0, Activity.class), (Map<String, Object>) k6.objectValue(1, Map.class));
                            default:
                                return null;
                        }
                }
        }
    }

    public abstract String j();

    public abstract void j(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.r rVar);

    public abstract void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar);

    public abstract void j(Dialog dialog, Integer[] numArr);

    public abstract com.bytedance.sdk.openadsdk.i.cw.xt.r jy();

    public abstract double m();

    public abstract int oq();

    public abstract r qv();

    public abstract String r();

    public abstract String tl();

    public abstract String up();

    public abstract boolean vl();

    public abstract ae xt(Activity activity);

    public abstract ae xt(Dialog dialog, Integer[] numArr);

    public abstract String xt();

    public PluginValueSet ws() {
        PluginValueSet pluginValueSet = this.f31670j;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet az = az();
        this.f31670j = az;
        return az;
    }

    private PluginValueSet az() {
        e a6 = e.a();
        a6.f(268101, com.bytedance.sdk.openadsdk.i.cw.r.j((Supplier) new Supplier<r>() { // from class: com.bytedance.sdk.openadsdk.mediation.ad.j.xt.xt.j.1
            @Override // java.util.function.Supplier
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public r get() {
                return j.this.qv();
            }
        }));
        return a6.k();
    }
}
