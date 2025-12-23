package com.bytedance.sdk.gromore.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.xt.xt.xt;
import com.bytedance.sdk.openadsdk.p.cw;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f27350j;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j xt;

    public float cw() {
        return this.xt.tl();
    }

    public int g() {
        PluginValueSet pluginValueSet = this.f27350j;
        if (pluginValueSet != null) {
            return pluginValueSet.intValue(3);
        }
        return 0;
    }

    public int j() {
        return this.xt.m();
    }

    public xt m() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.xt;
        if (jVar != null) {
            return jVar.l();
        }
        return null;
    }

    public float r() {
        return this.xt.g();
    }

    public Function<SparseArray<Object>, Object> tl() {
        PluginValueSet pluginValueSet = this.f27350j;
        if (pluginValueSet != null) {
            return cw.j(pluginValueSet.objectValue(8302, Object.class));
        }
        return null;
    }

    public String up() {
        return this.xt.r();
    }

    public int xt() {
        return this.xt.ae();
    }

    public j(SparseArray<Object> sparseArray) {
        this.f27350j = e.i(sparseArray).k();
        this.xt = new com.bytedance.sdk.openadsdk.mediation.xt.xt.j(sparseArray);
    }

    public com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.cw ae() {
        if (m() != null) {
            return m().jy();
        }
        return null;
    }
}
