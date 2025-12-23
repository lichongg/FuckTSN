package com.bytedance.sdk.gromore.j.j.ae.j;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.msdk.cw.r.qv;
import com.bytedance.sdk.gromore.j.j.r.oq;
import com.bytedance.sdk.openadsdk.i.cw.xt.ae;
import com.bytedance.sdk.openadsdk.i.cw.xt.r;
import com.bytedance.sdk.openadsdk.i.cw.xt.ws;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.up;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends ws {
    private com.bytedance.sdk.openadsdk.s.j.xt.j.cw ae;
    private com.bytedance.sdk.openadsdk.s.j.xt.j.j cw;

    /* renamed from: j, reason: collision with root package name */
    private final qv f27370j;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.j.cw f27371m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.s.j.xt.j.xt f27372r;
    private com.bytedance.sdk.openadsdk.i.cw.j.xt tl;
    private View up = null;
    private com.bytedance.sdk.openadsdk.kt.j.xt.j.j xt;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(int i6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
    }

    private void jy() {
        com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar;
        qv qvVar = this.f27370j;
        if (qvVar == null || (xtVar = this.tl) == null) {
            return;
        }
        qvVar.j(xtVar);
    }

    private void oq() {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            qvVar.j(new com.bytedance.msdk.api.r.j.j.j() { // from class: com.bytedance.sdk.gromore.j.j.ae.j.j.1
                @Override // com.bytedance.msdk.api.r.j.j.j
                public void j(com.bytedance.msdk.api.j jVar) {
                }

                @Override // com.bytedance.msdk.api.r.j.j.j
                public void f_() {
                    if (j.this.xt != null) {
                        j.this.xt.j(0, "ad closed", true);
                    }
                    if (j.this.cw != null) {
                        j.this.cw.j();
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.j.j
                public void j(View view) {
                    if (j.this.f27372r != null) {
                        j.this.f27372r.j(view, 0);
                    }
                    if (j.this.cw != null) {
                        j.this.cw.j(view, 0);
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.j.j
                public void xt(View view) {
                    if (j.this.f27372r != null) {
                        j.this.f27372r.xt(view, 0);
                    }
                    if (j.this.cw != null) {
                        j.this.cw.xt(view, 0);
                    }
                }
            });
        }
    }

    private void qv() {
        com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar;
        qv qvVar = this.f27370j;
        if (qvVar == null || (cwVar = this.f27371m) == null) {
            return;
        }
        qvVar.j(cwVar);
    }

    private void ws() {
        com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar;
        qv qvVar = this.f27370j;
        if (qvVar == null || (cwVar = this.ae) == null) {
            return;
        }
        qvVar.j(cwVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int cw() {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            return qvVar.jy();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public up g() {
        return new oq(new xt(this.f27370j));
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public r m() {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            return qvVar.ws();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void r() {
        com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar = this.f27372r;
        if (xtVar != null) {
            xtVar.j(this.up, 0.0f, 0.0f);
        }
        com.bytedance.sdk.openadsdk.s.j.xt.j.j jVar = this.cw;
        if (jVar != null) {
            jVar.j(this.up, 0.0f, 0.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public Map<String, Object> tl() {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            return qvVar.ae();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void up() {
        if (this.up != null) {
            this.up = null;
        }
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            qvVar.cw();
        }
        if (this.f27371m != null) {
            this.f27371m = null;
        }
        if (this.ae != null) {
            this.ae = null;
        }
    }

    public j(qv qvVar) {
        this.f27370j = qvVar;
        oq();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public int xt() {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            return qvVar.m();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(boolean z5) {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public View j() {
        qv qvVar;
        if (this.up == null && (qvVar = this.f27370j) != null) {
            this.up = qvVar.up();
        }
        qv();
        ws();
        jy();
        return this.up;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.xt xtVar) {
        this.f27372r = xtVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.j jVar) {
        this.cw = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        this.f27371m = cwVar;
        qv();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Activity activity, com.bytedance.sdk.openadsdk.kt.j.xt.j.j jVar) {
        this.xt = jVar;
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            qvVar.j(activity, jVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void ae() {
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(Dialog dialog, Integer[] numArr) {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            qvVar.j(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(String str) {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            qvVar.j(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public ae j(Activity activity) {
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            return qvVar.j(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.ws
    public void j(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        this.ae = cwVar;
        ws();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        this.tl = xtVar;
        qv qvVar = this.f27370j;
        if (qvVar != null) {
            qvVar.j(xtVar);
        }
    }
}
