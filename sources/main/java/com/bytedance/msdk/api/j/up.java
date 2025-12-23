package com.bytedance.msdk.api.j;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up implements r {
    private Map<String, Object> cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.j f24340j;

    /* renamed from: r, reason: collision with root package name */
    private int f24342r;
    private PluginValueSet up;
    private com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xt;

    /* renamed from: m, reason: collision with root package name */
    private int f24341m = -1;
    private String ae = "";

    @Override // com.bytedance.msdk.api.j.r
    public int a() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.vl();
        }
        return 1;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean av() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.qv();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public float az() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.g();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.j.r
    public Map<String, Object> c() {
        Map<String, Object> map = this.cw;
        if (map != null) {
            return map;
        }
        if (this.xt != null) {
            this.cw = new ConcurrentHashMap();
            Map<String, Object> m6 = this.xt.m();
            if (m6 != null && m6.size() > 0) {
                for (Map.Entry<String, Object> entry : m6.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.cw.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        if (this.cw == null) {
            this.cw = new ConcurrentHashMap();
        }
        return this.cw;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int ch() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.m();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean ed() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.ae();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int f() {
        return this.f24342r;
    }

    @Override // com.bytedance.msdk.api.j.r
    public void g(int i6) {
        this.f24342r = i6;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String gq() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        return jVar != null ? jVar.ws() : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public SparseArray<Object> gx() {
        PluginValueSet pluginValueSet = this.up;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int h() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar;
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        int ch = jVar != null ? jVar.ch() : 0;
        return (ch != 0 || (xtVar = this.xt) == null) ? ch : xtVar.az();
    }

    @Override // com.bytedance.msdk.api.j.r
    public int i() {
        return this.f24341m;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean kt() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.xt();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean l() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.oq();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String la() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        return jVar != null ? jVar.jy() : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean mi() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.j();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String nd() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.p();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String p() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar;
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        String x5 = jVar != null ? jVar.x() : "";
        return (!TextUtils.isEmpty(x5) || (xtVar = this.xt) == null) ? x5 : xtVar.ws();
    }

    @Override // com.bytedance.msdk.api.j.r
    public void r(String str) {
        this.ae = str;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean rh() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.a();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int rn() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.az();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int s() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.ae();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public com.bytedance.sdk.openadsdk.mediation.xt.xt.j tj() {
        return this.f24340j;
    }

    @Override // com.bytedance.msdk.api.j.r
    public void tl(int i6) {
        this.f24341m = i6;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String uf() {
        Map<String, Object> m6;
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar = this.xt;
        if (xtVar == null || (m6 = xtVar.m()) == null) {
            return "";
        }
        Object obj = m6.get("testToolSlotId");
        return obj instanceof String ? (String) obj : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public String v() {
        if (!TextUtils.isEmpty(this.ae)) {
            return this.ae;
        }
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        return jVar != null ? jVar.r() : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean w() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.g();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean wq() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.cw();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public float ws() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = this.f24340j;
        if (jVar != null) {
            return jVar.tl();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String x() {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt xtVar = this.xt;
        return xtVar != null ? xtVar.tl() : "";
    }

    public up(int i6, PluginValueSet pluginValueSet) {
        if (pluginValueSet != null) {
            this.up = pluginValueSet;
            this.f24342r = i6;
            com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar = new com.bytedance.sdk.openadsdk.mediation.xt.xt.j(pluginValueSet.sparseArray());
            this.f24340j = jVar;
            this.xt = jVar.l();
            return;
        }
        com.bytedance.msdk.j.up.cw.xt("AdLinkInfo", "valueset is null");
    }
}
