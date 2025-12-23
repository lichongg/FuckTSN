package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.tj.n;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements com.bytedance.adsdk.ugeno.cw.f, com.bytedance.sdk.component.adexpress.xt.g {
    private com.bytedance.sdk.openadsdk.az.tl ae;
    private n cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.m.j f29690j;

    /* renamed from: m, reason: collision with root package name */
    private long f29691m;

    /* renamed from: r, reason: collision with root package name */
    private String f29692r;
    private long up;
    private String xt;

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j(boolean z5) {
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void m() {
        this.f29690j.j();
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void r() {
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void up() {
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void ae() {
        com.bytedance.sdk.openadsdk.az.tl tlVar = this.ae;
        if (tlVar == null) {
            return;
        }
        tlVar.m(s.j(this.cw));
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void cw(int i6) {
        if (i6 == 3) {
            this.f29690j.xt("dynamic_sub_analysis2_end");
        } else {
            this.f29690j.xt("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void g() {
        this.f29690j.cw();
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void jy() {
        this.f29690j.xt();
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void m(int i6) {
        final String str;
        this.f29691m = System.currentTimeMillis();
        if (i6 == 3) {
            this.f29690j.cw("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.f29690j.cw("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.f29690j.j(true);
        com.bytedance.sdk.component.oq.ae.cw(new com.bytedance.sdk.component.oq.g("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.oq.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.jy.cw.ae(oq.this.cw, oq.this.xt, str, null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void oq() {
        this.f29690j.j(true);
        this.f29690j.up();
        com.bytedance.sdk.component.oq.ae.cw(new com.bytedance.sdk.component.oq.g("native_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.oq.2
            @Override // java.lang.Runnable
            public void run() {
                g.j(oq.this.xt, oq.this.f29692r, oq.this.cw);
                com.bytedance.sdk.openadsdk.core.jy.cw.ae(oq.this.cw, oq.this.xt, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void qv() {
        this.f29690j.j(true);
        this.f29690j.jy();
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void r(int i6) {
        if (i6 == 3) {
            this.f29690j.xt("dynamic_sub_render2_start");
        } else {
            this.f29690j.xt("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void tl() {
        this.f29690j.xt();
        com.bytedance.sdk.openadsdk.az.tl tlVar = this.ae;
        if (tlVar == null) {
            return;
        }
        tlVar.ae(s.j(this.cw));
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void up(int i6) {
        if (i6 == 3) {
            this.f29690j.xt("dynamic_sub_render2_end");
        } else {
            this.f29690j.xt("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void vl() {
        this.f29690j.ws();
    }

    public void ws() {
        this.f29690j.az();
        this.f29690j.av();
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void xt(boolean z5) {
        this.f29690j.j(z5 ? 1 : 0);
    }

    public oq(com.bytedance.sdk.openadsdk.m.j jVar, String str, n nVar, String str2) {
        this.f29690j = jVar;
        this.xt = str;
        this.f29692r = str2;
        this.cw = nVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void j(int i6, String str) {
        this.f29690j.j(i6, str);
        g.j(i6, this.xt, this.f29692r, this.cw);
        com.bytedance.sdk.openadsdk.az.tl tlVar = this.ae;
        if (tlVar == null) {
            return;
        }
        tlVar.j(true, s.j(this.cw), 105);
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void xt(int i6) {
        if (i6 == 3) {
            this.f29690j.xt("dynamic_sub_analysis2_start");
        } else {
            this.f29690j.xt("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void cw() {
        this.f29690j.r("ugen_sub_render_start");
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void xt() {
        this.f29690j.r("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void j(int i6) {
        this.up = System.currentTimeMillis();
        if (i6 == 3) {
            this.f29690j.j("dynamic_render2_start");
        } else {
            this.f29690j.j("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xt.g
    public void j(int i6, int i7, String str, boolean z5) {
        this.f29690j.j(true);
        if (i6 == 3) {
            this.f29690j.xt(i7, "dynamic_render2_error");
        } else {
            this.f29690j.xt(i7, "dynamic_render_error");
        }
        g.j(i7, this.xt, this.f29692r, this.cw);
    }

    public void j(com.bytedance.sdk.openadsdk.az.tl tlVar) {
        this.ae = tlVar;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j() {
        this.f29690j.r("ugen_render_start");
        this.f29690j.r("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j(com.bytedance.adsdk.ugeno.cw.tj tjVar) {
        if (tjVar.j() == 0) {
            this.f29690j.r("ugen_sub_render_end");
            this.f29690j.up("ugen_render_success");
        } else {
            this.f29690j.cw(tjVar.j(), "ugen_render_error");
        }
        this.f29690j.j(true);
    }

    @Override // com.bytedance.adsdk.ugeno.cw.f
    public void j(JSONObject jSONObject) {
        this.f29690j.j(jSONObject);
    }
}
