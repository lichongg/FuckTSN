package com.bytedance.sdk.openadsdk.mediation.xt.xt;

import a1.a;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.lang.reflect.Field;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.openadsdk.i.cw.cw.xt {
    private final PluginValueSet xt;

    private static Function<SparseArray<Object>, Object> j(PluginValueSet pluginValueSet) {
        Object obj;
        if (pluginValueSet != null) {
            obj = pluginValueSet.objectValue(8260028, Object.class);
            if (obj == null) {
                try {
                    obj = pluginValueSet.objectValue(260026, a.a());
                } catch (Throwable unused) {
                }
            }
        } else {
            obj = null;
        }
        return com.bytedance.sdk.openadsdk.p.cw.j(obj);
    }

    public boolean a() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet == null) {
            return false;
        }
        return pluginValueSet.booleanValue(8260030);
    }

    public PluginValueSet h() {
        return this.xt;
    }

    public xt l() {
        Function<SparseArray<Object>, Object> j6 = j(this.xt);
        if (j6 != null) {
            return new xt(j6);
        }
        return null;
    }

    public String p() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet == null) {
            return null;
        }
        return (String) pluginValueSet.objectValue(8260029, String.class);
    }

    public j(SparseArray<Object> sparseArray) {
        super(sparseArray);
        this.xt = e.i(sparseArray).k();
    }

    public static final PluginValueSet j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        return j(xtVar, null, false);
    }

    public static final PluginValueSet j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, boolean z5) {
        e a6 = e.a();
        if (xtVar == null) {
            return a6.k();
        }
        a6.g(260001, xtVar.j());
        a6.g(260002, xtVar.xt());
        a6.g(260003, xtVar.cw());
        a6.g(260004, xtVar.r());
        a6.h(260005, xtVar.up());
        a6.e(260006, xtVar.m());
        a6.e(260007, xtVar.ae());
        a6.e(7, xtVar.m());
        a6.e(8, xtVar.ae());
        a6.d(260008, xtVar.tl());
        a6.d(260009, xtVar.g());
        a6.d(10, xtVar.tl());
        a6.d(9, xtVar.g());
        a6.h(260010, xtVar.oq());
        a6.h(260011, xtVar.qv());
        a6.e(2600012, xtVar.vl());
        a6.g(260013, xtVar.jy());
        a6.g(260014, xtVar.ws());
        a6.e(260015, xtVar.az());
        a6.e(260016, xtVar.av());
        a6.f(260017, xtVar.i());
        a6.e(260018, xtVar.w());
        a6.g(260019, xtVar.mi());
        a6.e(260020, xtVar.kt());
        a6.g(260021, xtVar.tj());
        a6.g(260022, xtVar.f());
        a6.f(260023, xtVar.v());
        PluginValueSet pluginValueSet = null;
        try {
            for (Field field : xtVar.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(xtVar) instanceof PluginValueSet) {
                    pluginValueSet = (PluginValueSet) field.get(xtVar);
                }
                field.setAccessible(false);
            }
        } catch (Exception unused) {
        }
        if (pluginValueSet != null) {
            a6.f(8260028, j(pluginValueSet));
            a6.f(260027, pluginValueSet.objectValue(260027, IMediationAdSlot.class));
        }
        a6.g(260024, xtVar.x());
        a6.e(260025, xtVar.ch());
        a6.d(260008, xtVar.tl());
        if (!TextUtils.isEmpty(str)) {
            a6.g(8260029, str);
            a6.h(8260030, z5);
        }
        return a6.k();
    }

    public static PluginValueSet j(PluginValueSet pluginValueSet, String str) {
        e j6 = e.j(pluginValueSet);
        j6.g(260022, str);
        return j6.k();
    }
}
