package com.bytedance.msdk.api.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt implements cw, r {
    private cw cw;

    /* renamed from: j, reason: collision with root package name */
    private r f24343j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f24344r;
    private com.bytedance.msdk.core.oq.xt xt;

    public xt() {
    }

    private void j(int i6, PluginValueSet pluginValueSet, cw cwVar) {
        this.f24343j = new up(i6, pluginValueSet);
        j jVar = new j();
        this.cw = jVar;
        if (cwVar != null) {
            jVar.up(cwVar.tl());
        }
    }

    @Override // com.bytedance.msdk.api.j.r
    public int a() {
        r rVar;
        if (5 != f() && 9 != f()) {
            return 1;
        }
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        int i6 = xtVar != null ? xtVar.i() : 0;
        if (i6 == 0 && (rVar = this.f24343j) != null) {
            i6 = rVar.a();
        }
        if (i6 <= 0) {
            return 1;
        }
        if (i6 >= 3) {
            return 3;
        }
        return i6;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void ae(int i6) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.ae(i6);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void cw(String str) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.cw(str);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public int g() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.g();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void m(int i6) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.m(i6);
        }
    }

    @Override // com.bytedance.msdk.api.j.r
    public void r(String str) {
        r rVar = this.f24343j;
        if (rVar != null) {
            rVar.r(str);
        }
    }

    @Override // com.bytedance.msdk.api.j.r
    public void tl(int i6) {
        r rVar = this.f24343j;
        if (rVar != null) {
            rVar.tl(i6);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public int up() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.up();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public int xt() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.xt();
        }
        return 0;
    }

    public xt(int i6, PluginValueSet pluginValueSet) {
        j(i6, pluginValueSet, null);
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean av() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.av();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public float az() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.az();
        }
        return 0.0f;
    }

    public int b() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.hl();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public Map<String, Object> c() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.c() : new ConcurrentHashMap();
    }

    @Override // com.bytedance.msdk.api.j.r
    public int ch() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.ch();
        }
        return 0;
    }

    public String e() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        return xtVar != null ? xtVar.hh() : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean ed() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.ed();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int f() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.f();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String gq() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.gq() : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public SparseArray<Object> gx() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.gx() : e.f22771c.sparseArray();
    }

    @Override // com.bytedance.msdk.api.j.r
    public int h() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.h();
        }
        return 0;
    }

    public String hh() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        return xtVar != null ? xtVar.la() : "";
    }

    public int hl() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.z();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int i() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.i();
        }
        return -1;
    }

    public cw jy() {
        return this.cw;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean kt() {
        r rVar = this.f24343j;
        if (rVar == null) {
            return false;
        }
        rVar.kt();
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean l() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.l();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String la() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.la() : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean mi() {
        r rVar = this.f24343j;
        if (rVar == null) {
            return false;
        }
        rVar.mi();
        return false;
    }

    public com.bytedance.msdk.core.oq.xt n() {
        return this.xt;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String nd() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.nd();
        }
        return null;
    }

    public long ol() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.s();
        }
        return 0L;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public JSONObject oq() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.oq();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String p() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.p() : "";
    }

    public int q() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.a();
        }
        return 0;
    }

    public String qb() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        return xtVar != null ? xtVar.l() : "";
    }

    @Override // com.bytedance.msdk.api.j.cw
    public int qv() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.qv();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean rh() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.rh();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int rn() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.rn();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public int s() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.s();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public com.bytedance.sdk.openadsdk.mediation.xt.xt.j tj() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.tj();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String uf() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.uf() : "";
    }

    @Override // com.bytedance.msdk.api.j.r
    public String v() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.v() : "";
    }

    @Override // com.bytedance.msdk.api.j.cw
    public String vl() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.vl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean w() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.w();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public boolean wq() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.wq();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.r
    public float ws() {
        r rVar = this.f24343j;
        if (rVar != null) {
            return rVar.ws();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.j.r
    public String x() {
        r rVar = this.f24343j;
        return rVar != null ? rVar.x() : "";
    }

    public boolean xq() {
        return this.f24344r;
    }

    public String ya() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        return xtVar != null ? xtVar.mi() : "";
    }

    public double z() {
        com.bytedance.msdk.core.oq.xt xtVar = this.xt;
        if (xtVar != null) {
            return xtVar.w();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public boolean ae() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.ae();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public int cw() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.cw();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.r
    public void g(int i6) {
        r rVar = this.f24343j;
        if (rVar != null) {
            rVar.g(i6);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public String m() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.m();
        }
        return "";
    }

    @Override // com.bytedance.msdk.api.j.cw
    public int r() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.r();
        }
        return 0;
    }

    public boolean sm() {
        int f6 = f();
        Map<String, Object> c6 = c();
        if (c6 == null) {
            return false;
        }
        Object obj = c6.get("use_share_cache");
        if (!(obj instanceof Boolean) || ((f6 != 1 && f6 != 5 && f6 != 10 && f6 != 7) || !((Boolean) obj).booleanValue())) {
            return false;
        }
        return true;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public int tl() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.tl();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void up(int i6) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.up(i6);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void xt(int i6) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.xt(i6);
        }
    }

    public xt(xt xtVar) {
        if (xtVar != null) {
            j(xtVar.f(), e.i(xtVar.gx()).k(), xtVar.jy());
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void j(JSONObject jSONObject) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.j(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void cw(int i6) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.cw(i6);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void r(int i6) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.r(i6);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void xt(String str) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.xt(str);
        }
    }

    public void j(com.bytedance.msdk.core.oq.xt xtVar) {
        this.xt = xtVar;
    }

    @Override // com.bytedance.msdk.api.j.cw
    public String j() {
        cw cwVar = this.cw;
        if (cwVar != null) {
            return cwVar.j();
        }
        return "";
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void j(String str) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.j(str);
        }
    }

    @Override // com.bytedance.msdk.api.j.cw
    public void j(int i6) {
        cw cwVar = this.cw;
        if (cwVar != null) {
            cwVar.j(i6);
        }
    }

    public void j(PluginValueSet pluginValueSet) {
        if (this.f24343j == null || pluginValueSet == null) {
            return;
        }
        this.f24343j = new up(f(), pluginValueSet);
    }

    public void j(boolean z5) {
        this.f24344r = z5;
    }
}
