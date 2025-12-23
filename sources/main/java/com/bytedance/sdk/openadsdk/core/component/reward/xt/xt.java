package com.bytedance.sdk.openadsdk.core.component.reward.xt;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.r.g;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private AbstractEndCardFrameLayout ae;
    private boolean az;
    private String cw;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28528f;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.xt.j f28529g;

    /* renamed from: j, reason: collision with root package name */
    private final TTBaseVideoActivity f28531j;
    private final com.bytedance.sdk.openadsdk.core.component.reward.view.j jy;

    /* renamed from: m, reason: collision with root package name */
    private int f28532m;
    private com.bytedance.sdk.openadsdk.core.xt.xt oq;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt qv;

    /* renamed from: r, reason: collision with root package name */
    private boolean f28533r;
    private up tl;
    private int up;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw vl;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.j ws;
    private n xt;
    private int av = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f28530i = false;

    /* renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f28534w = new AtomicBoolean(false);
    private final AtomicBoolean mi = new AtomicBoolean(false);
    private int tj = 0;
    private boolean kt = false;

    public interface j {
        void j();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt$xt, reason: collision with other inner class name */
    public interface InterfaceC0446xt {
        up cw();

        void j();

        void xt();
    }

    public void a() {
        cw(false);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.m();
        }
        if (this.f28530i) {
            wq();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar != null) {
            this.ws = xtVar;
        }
    }

    public void x() {
        cw(true);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar == null || !cwVar.cw()) {
            up(false);
        } else {
            this.vl.j(this.f28531j.e() instanceof g ? 2 : 0);
        }
        if (this.qv != null) {
            this.ws = this.vl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f28531j.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.f28531j);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.f28531j);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(ed.cw(this.f28531j, 20.0f), ed.cw(this.f28531j, 12.0f), ed.cw(this.f28531j, 20.0f), ed.cw(this.f28531j, 12.0f));
        TextView textView = new TextView(this.f28531j);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.f28531j.uf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.5
            @Override // java.lang.Runnable
            public void run() {
                xt.this.n();
            }
        }, 6000L);
    }

    private void nd() {
        try {
            if (!l.j(this.xt) || this.f28528f) {
                return;
            }
            float[] j6 = com.bytedance.sdk.openadsdk.core.component.reward.up.xt.j(StubApp.getOrigApplicationContext(this.f28531j.getApplicationContext()), this.xt.uo(), this.xt.zw());
            float f6 = j6[0];
            float f7 = j6[1];
            if (this.xt.uo() == 100.0f) {
                this.up = (int) f6;
                this.f28532m = (int) f7;
                return;
            }
            int[] j7 = com.bytedance.sdk.openadsdk.core.component.reward.up.xt.j(StubApp.getOrigApplicationContext(this.f28531j.getApplicationContext()), this.xt.uo(), this.xt.bh(), this.xt.zw());
            int i6 = j7[0];
            int i7 = j7[1];
            int i8 = j7[2];
            int i9 = j7[3];
            float f8 = i6;
            float f9 = i8;
            this.up = (int) ((f6 - f8) - f9);
            float f10 = i7;
            float f11 = i9;
            this.f28532m = (int) ((f7 - f10) - f11);
            this.f28531j.getWindow().getDecorView().setPadding(ed.cw(this.f28531j, f8), ed.cw(this.f28531j, f10), ed.cw(this.f28531j, f9), ed.cw(this.f28531j, f11));
        } catch (Throwable unused) {
        }
    }

    public void ae() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.av();
        }
    }

    public boolean av() {
        boolean i6 = ln.oq(this.xt) ? i() : w();
        if (mi()) {
            return i6 || tj.xt(this.xt);
        }
        return false;
    }

    public void az() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.tl();
        }
    }

    public boolean ch() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        return cwVar != null && cwVar.cw();
    }

    public void cw() {
        if (c()) {
            return;
        }
        int i6 = this.av;
        if (i6 >= 0) {
            this.f28531j.xt(i6);
            j(0L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.ch();
        }
    }

    public void ed() {
        this.tj = e.xt(this.xt, this.f28531j.e().uf());
        this.mi.set(e.tj(this.xt));
        com.bytedance.sdk.openadsdk.core.tl.r.cw = true;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar != null) {
            xtVar.g();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.g();
        }
    }

    public int g() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            return jVar.oq();
        }
        return 0;
    }

    public boolean gq() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            return cwVar.gq();
        }
        return false;
    }

    public int gx() {
        return this.tj;
    }

    public boolean h() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar == null) {
            return false;
        }
        return xtVar.tj();
    }

    public boolean i() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            return jVar.xt();
        }
        return false;
    }

    public void j(up upVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.j jVar, boolean z5, String str, int i6, int i7) {
        this.f28533r = z5;
        this.tl = upVar;
        this.f28529g = jVar;
        this.cw = str;
        this.up = i6;
        this.f28532m = i7;
    }

    public void jy() {
        if (!e.i(this.xt)) {
            v();
        }
        this.tl.cw(false);
        this.tl.m(false);
        this.tl.xt(this.xt.xa());
        this.tl.ae(false);
        this.tl.up(!(this.ws instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt));
        nd();
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.up();
            this.ws.j(1);
        }
    }

    public boolean kt() {
        if (this.f28530i) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        return jVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw ? this.vl.h() : jVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt;
    }

    public boolean l() {
        return this.ws instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw;
    }

    public void la() {
        j(1000L);
    }

    public void m() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar != null) {
            xtVar.az();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.az();
        }
    }

    public boolean mi() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            return jVar.r();
        }
        return false;
    }

    public String oq() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        return jVar != null ? jVar.qv() : "";
    }

    public boolean p() {
        return this.az;
    }

    public void qv() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.i();
        }
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.jy();
        }
    }

    public boolean rn() {
        return this.f28534w.get();
    }

    public rn s() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            return cwVar.la();
        }
        return null;
    }

    public void tj() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar != null) {
            this.ws = xtVar;
        }
    }

    public void tl() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.s();
        }
    }

    public String uf() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        return jVar != null ? jVar.x() : "endcard";
    }

    public void up() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.w();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar2 = this.ws;
        if (jVar2 != null) {
            jVar2.ws();
        }
    }

    public void v() {
        if (tj.cw(this.xt) || c()) {
            return;
        }
        this.av = Math.max(j(this.xt), 0);
        j(0L);
    }

    public void vl() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.mi();
        }
    }

    public boolean w() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            return jVar.cw();
        }
        return false;
    }

    public void wq() {
        this.jy.cw();
    }

    public boolean ws() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            return jVar.ae();
        }
        return false;
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.vl();
        }
    }

    public xt(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f28531j = tTBaseVideoActivity;
        this.jy = new com.bytedance.sdk.openadsdk.core.component.reward.view.j(tTBaseVideoActivity);
    }

    public boolean c() {
        if (rn() && this.mi.get()) {
            return true;
        }
        return false;
    }

    public void r(boolean z5) {
        this.f28534w.set(z5);
    }

    public void xt(boolean z5) {
        if (this.av >= 0) {
            this.f28531j.ws();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.r(z5);
        }
    }

    public void m(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.up(z5);
        }
    }

    public void up(boolean z5) {
        if (rn() || p()) {
            this.f28530i = true;
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
            if (jVar != null) {
                jVar.kt();
                this.ws.m();
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
            if (cwVar != null) {
                cwVar.v();
            }
            up upVar = this.tl;
            if (upVar != null) {
                upVar.ae();
            }
            ws.j().m(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.3
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    com.bytedance.sdk.openadsdk.core.kt.j.xt m6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(xt.this.f28533r ? 7 : 8).cw(String.valueOf(uf.g(xt.this.xt))).m(uf.jy(xt.this.xt));
                    m6.xt(xt.this.g()).ae(xt.this.oq());
                    m6.tl(xt.this.xt.os()).r(xt.this.xt.fs());
                    return m6;
                }
            });
            this.jy.j();
            if (kt.j(this.xt)) {
                this.f28531j.vl(8);
            }
            this.tl.j(true);
            this.tl.ae(false);
            this.f28531j.uf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.4
                @Override // java.lang.Runnable
                public void run() {
                    xt.this.tl.j(true);
                    if (xt.this.tl.up()) {
                        return;
                    }
                    xt.this.tl.j(false, null, null, true, true);
                    if (xt.this.gq() && xt.this.f28533r) {
                        xt.this.n();
                    }
                }
            }, 500L);
            if (z5) {
                if (!e.i(this.xt)) {
                    this.tl.j(false, null, null, true, true);
                }
                this.tl.up(false);
                this.tl.xt(this.xt.xa());
            }
        }
    }

    public void cw(boolean z5) {
        this.az = z5;
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.m(z5);
        }
    }

    public void j(n nVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.kt) {
            return;
        }
        this.kt = true;
        this.xt = nVar;
        this.oq = xtVar;
        this.jy.j(nVar);
        this.ae = abstractEndCardFrameLayout;
        j(abstractEndCardFrameLayout);
        j(jVar);
        this.f28528f = com.bytedance.sdk.openadsdk.core.ws.r.j(String.valueOf(uf.g(this.xt)));
    }

    public void xt(int i6, int i7) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.xt(i6, i7);
        }
    }

    void j(AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.xt.l() == 1) {
            return;
        }
        if (tj.xt(this.xt)) {
            this.vl = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw(this.f28531j, this.xt, this.cw, this.up, this.f28532m, this.f28533r, this.ae);
        }
        if (!TextUtils.isEmpty(ln.j(this.xt))) {
            this.qv = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt(this.f28531j, this.xt, this.cw, this.up, this.f28532m, this.f28533r, this.ae);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.vl;
        if (jVar == null) {
            jVar = this.qv;
        }
        this.ws = jVar;
    }

    public void j(long j6, long j7, int i6) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.j(j6, j7, i6);
        }
    }

    public void j(int i6, int i7) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.j(i6, i7);
        }
    }

    public void j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.xt(z5);
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar) {
        Map<String, Object> nd = this.f28531j.nd();
        this.jy.j(this.oq);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.j(jVar);
            this.vl.j(this.f28533r, nd, this.tl.r());
            this.vl.j(this.f28529g.ae(), this.oq);
            this.vl.j(new j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.j
                public void j() {
                    xt.this.up(false);
                }
            });
            this.vl.j(new InterfaceC0446xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.InterfaceC0446xt
                public up cw() {
                    return xt.this.tl;
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.InterfaceC0446xt
                public void j() {
                    xt.this.f28531j.xt(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.InterfaceC0446xt
                public void xt() {
                    xt.this.f28531j.qv();
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar != null) {
            xtVar.j(this.f28533r, nd, this.tl.r());
            this.qv.j(this.f28529g.ae(), this.oq);
        }
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
        if (cwVar != null) {
            cwVar.a();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar != null) {
            xtVar.l();
        }
    }

    public void j(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.j(map);
        }
    }

    public void j(boolean z5, int i6, String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.j(z5, i6, str);
        }
    }

    private int j(n nVar) {
        return nVar.cr();
    }

    private void j(long j6) {
        int i6 = this.av / 1000;
        if (!e.i(this.xt)) {
            if (i6 > 0) {
                this.tl.j(false, i6 + "s", null, false, false);
            } else {
                this.tl.j(false, null, null, true, true);
            }
        }
        if (i6 > 0) {
            this.av = (int) (this.av - j6);
            this.f28531j.j(j6);
        }
    }

    public void j(n nVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        this.xt = nVar;
        this.oq = xtVar;
        this.jy.j(nVar);
        this.jy.j(this.oq);
        if (tj.xt(nVar)) {
            if (this.vl == null) {
                this.vl = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw(this.f28531j, nVar, this.cw, this.up, this.f28532m, this.f28533r, this.ae);
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.cw cwVar = this.vl;
            this.ws = cwVar;
            cwVar.j(new j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.j
                public void j() {
                    xt.this.up(false);
                }
            });
            this.vl.j(new InterfaceC0446xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.7
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.InterfaceC0446xt
                public up cw() {
                    return xt.this.tl;
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.InterfaceC0446xt
                public void j() {
                    xt.this.f28531j.xt(true, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.InterfaceC0446xt
                public void xt() {
                    xt.this.f28531j.qv();
                }
            });
        } else {
            this.ws = this.qv;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
            if (jVar != null) {
                jVar.j(this.xt);
                this.ws.j(this.f28533r, this.f28531j.nd(), this.tl.r());
                this.ws.j(this.f28529g.ae(), this.oq);
                j();
            }
        } catch (Throwable unused) {
        }
    }

    public void j(final String str) {
        this.f28531j.uf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.xt.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                xt.this.jy.j(str);
            }
        });
    }

    public void j(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.j jVar = this.ws;
        if (jVar != null) {
            jVar.j(jSONObject);
        }
    }

    public void j(com.bytedance.sdk.component.adexpress.xt.ws wsVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.xt xtVar = this.qv;
        if (xtVar == null) {
            return;
        }
        xtVar.j(wsVar);
    }
}
