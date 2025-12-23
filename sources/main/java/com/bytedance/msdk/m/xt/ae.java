package com.bytedance.msdk.m.xt;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Supplier;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae extends com.bytedance.sdk.openadsdk.core.wq.r implements Supplier<SparseArray<Object>> {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt f25183j;

    public boolean j() {
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt xtVar = this.f25183j;
        if (xtVar != null) {
            return xtVar.r();
        }
        return false;
    }

    public boolean m() {
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt xtVar = this.f25183j;
        if (xtVar != null) {
            return xtVar.cw();
        }
        return true;
    }

    public List<String> r() {
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt xtVar = this.f25183j;
        if (xtVar != null) {
            return xtVar.j();
        }
        return null;
    }

    public List<String> up() {
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt xtVar = this.f25183j;
        if (xtVar != null) {
            return xtVar.xt();
        }
        return null;
    }

    public boolean xt() {
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt xtVar = this.f25183j;
        if (xtVar != null) {
            return xtVar.up();
        }
        return true;
    }

    public ae(com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt xtVar) {
        this.f25183j = xtVar;
    }

    @Override // java.util.function.Supplier
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet cw = cw();
        if (cw != null) {
            return cw.sparseArray();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == -99999986) {
            return (T) cw().sparseArray();
        }
        return null;
    }

    public PluginValueSet cw() {
        e a6 = e.a();
        a6.f(8476, r());
        a6.f(8477, up());
        a6.h(8478, m());
        a6.h(8027, j());
        a6.h(8028, xt());
        return a6.k();
    }
}
