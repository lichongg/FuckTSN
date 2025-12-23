package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.CommonEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j extends xt implements l.j {
    protected boolean av;
    com.bytedance.sdk.openadsdk.core.component.reward.xt.j ch;
    protected int cw;

    /* renamed from: f, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.xt.r f28365f;

    /* renamed from: g, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt f28366g;
    protected com.bytedance.sdk.openadsdk.core.component.reward.up.cw gq;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f28368i;

    /* renamed from: j, reason: collision with root package name */
    protected final TTBaseVideoActivity f28369j;
    protected boolean jy;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xt.m kt;

    /* renamed from: m, reason: collision with root package name */
    protected int f28371m;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xt.up mi;
    protected com.bytedance.sdk.openadsdk.core.component.reward.layout.up oq;
    protected AbstractEndCardFrameLayout qv;

    /* renamed from: r, reason: collision with root package name */
    protected float f28373r;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xt.xt tj;
    protected com.bytedance.sdk.openadsdk.core.xt.up tl;
    protected int up;

    /* renamed from: v, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.m f28375v;
    protected String vl;

    /* renamed from: w, reason: collision with root package name */
    protected boolean f28376w;
    protected boolean ws;

    /* renamed from: x, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.up f28377x;
    protected n xt;
    protected int ae = -1;
    protected AtomicBoolean az = new AtomicBoolean(false);

    /* renamed from: s, reason: collision with root package name */
    protected int f28374s = -5;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f28364a = false;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f28370l = false;

    /* renamed from: p, reason: collision with root package name */
    protected final l f28372p = new l(Looper.getMainLooper(), this);

    /* renamed from: h, reason: collision with root package name */
    protected int f28367h = Integer.MIN_VALUE;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.qv rn = new com.bytedance.sdk.openadsdk.core.nativeexpress.qv() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.j.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void j(int i6, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public int xt() {
            if (j.this.oq.xt()) {
                return 4;
            }
            if (j.this.oq.cw()) {
                return 5;
            }
            if (j.this.kt.r()) {
                return 1;
            }
            if (j.this.kt.xt()) {
                return 2;
            }
            j.this.kt.cw();
            return 3;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public int cw() {
            return j.this.ch();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void g() {
            j.this.f28369j.sm();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public long getActualPlayDuration() {
            return j.this.kt.gq().hh();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void j(boolean z5) {
            j jVar = j.this;
            if (jVar.jy != z5) {
                jVar.jy = z5;
                jVar.mi.xt();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void m() {
            j jVar = j.this;
            jVar.f28370l = true;
            jVar.f28369j.xq();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void oq() {
            j.this.mi.cw();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void qv() {
            j.this.f28369j.tl(3);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void r() {
            j.this.f28364a = true;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void setPauseFromExpressView(boolean z5) {
            j.this.f28369j.az(1);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void up() {
            j.this.f28364a = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void ae() {
            ws.j().cw(j.this.xt, "stats_reward_full_click_express_close");
            j.this.mi.j();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void tl() {
            ws.j().cw(j.this.xt, "stats_reward_full_click_express_close");
            j.this.f28369j.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void j(int i6) {
            if (i6 != 1) {
                if (i6 == 2) {
                    j.this.kt.s();
                    return;
                }
                if (i6 == 3) {
                    j.this.kt.a();
                    return;
                } else if (i6 == 4) {
                    j.this.kt.ae();
                    return;
                } else if (i6 != 5) {
                    return;
                }
            }
            if (j.this.kt.xt() || j.this.kt.cw() || j.this.kt.n()) {
                return;
            }
            j.this.f28369j.xt(0L, false);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void xt(int i6) {
            if (e.up(j.this.xt)) {
                j.this.f28369j.r(1);
            } else {
                j.this.f28369j.j(i6, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public long j() {
            j jVar = j.this;
            jVar.xt(jVar.m(true));
            return j.this.gq.j();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void j(float f6, float f7, float f8, float f9, int i6) {
            j.this.f28369j.j(f6, f7, f8, f9, i6);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
        public void j(float f6) {
            j.this.cw((int) (1000.0f / f6));
            j.this.f28369j.hl().j(f6);
        }
    };
    public int la = 1000;

    public boolean ae() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar;
        return m() && (upVar = this.oq) != null && upVar.m();
    }

    public void cw(boolean z5) {
    }

    protected int ed() {
        return tl(true);
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public void j(int i6) {
    }

    public void l() {
        this.av = true;
    }

    public boolean la() {
        return true;
    }

    public boolean m() {
        return hh.j(this.xt) == 2;
    }

    public int p() {
        return 0;
    }

    protected void r() {
        boolean m6 = this.oq.m();
        if (!this.tj.rn() && !m6) {
            av();
        }
        this.tj.j(this.oq.qv());
        if (m6) {
            this.oq.j().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.f28366g.cw(!m6);
        this.oq.cw(m6);
        this.mi.j(ya() || !m6);
        this.f28369j.up();
        if (e.i(this.xt)) {
            s();
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.xt.xt rn() {
        return null;
    }

    public void tl() {
        if ((this.ws || !e.v(this.xt)) && !(this instanceof qv)) {
            return;
        }
        rh();
    }

    protected void up() {
        this.f28369j.ae(0);
        this.mi.j(ya());
        float f6 = this.up;
        float f7 = this.f28371m;
        float[] fArr = {f6, f7};
        if (f6 < 10.0f || f7 < 10.0f) {
            fArr = mi();
        }
        this.oq.j(this.xt, a.j(this.f28369j.ch() ? 7 : 8, String.valueOf(uf.g(this.xt)), fArr[0], fArr[1]), this.vl, this.jy);
        this.f28366g.cw(false);
        this.oq.cw(true);
        this.oq.j(this.rn);
        this.oq.j(new com.bytedance.sdk.openadsdk.core.nativeexpress.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.j.4
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, int i6) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, String str, int i6) {
                if (j.this.tj.rn()) {
                    return;
                }
                j.this.tj.j();
                j.this.f28369j.mi();
                j.this.f28369j.ae(8);
                j.this.mi.j(true);
                j.this.f28372p.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.j.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.f28369j.w();
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, float f8, float f9) {
                if (j.this.tj.rn()) {
                    return;
                }
                j.this.tj.j();
                j.this.f28369j.mi();
                j.this.f28369j.ae(8);
                j jVar = j.this;
                jVar.ae = jVar.oq.g();
                j jVar2 = j.this;
                if (jVar2.ae == 0) {
                    e.xt(jVar2.xt, true);
                }
                j.this.cw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void xt(View view, int i6) {
            }
        });
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.f28375v.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.f28369j.nd());
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.f28377x.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.f28369j.nd());
        this.f28369j.j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) this.f28375v.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        this.f28369j.j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) this.f28377x.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        this.oq.j(this.f28375v, this.f28377x);
        this.oq.tl();
    }

    public void xt(Map<String, Object> map) {
    }

    private int kc() {
        long max = Math.max(((long) (this.kt.l() * 1000.0d)) - this.kt.h(), 0L);
        return Math.max((((int) (max / 1000)) + (((int) (max % 1000)) > 500 ? 1 : 0)) - z(), 0);
    }

    private void zz() {
        this.mi.j(false);
        this.f28366g.m(8);
        this.f28366g.up(8);
        this.f28366g.cw(8);
        ff();
    }

    protected void a() {
        if (this.f28374s < 0) {
            this.f28374s = this.tj.gx();
        }
        int i6 = this.f28374s;
        if (i6 <= 0) {
            if (i6 == 0) {
                this.f28369j.r(0);
                this.mi.j(false, "奖励已领取", null, true, true);
                return;
            }
            return;
        }
        this.f28374s = i6 - 1;
        this.mi.j(false, this.f28374s + "s", null, true, true);
    }

    protected int ae(boolean z5) {
        return z5 ? tl(false) : kc();
    }

    public void av() {
        this.f28366g.av();
    }

    public void az() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.qv;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.xt();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.oq;
        if (upVar != null) {
            upVar.r();
        }
        if (q() || this.tj.rn()) {
            return;
        }
        this.tj.f();
    }

    public boolean b() {
        return this.f28370l;
    }

    public int c() {
        int i6 = this.f28367h;
        return i6 == Integer.MIN_VALUE ? m(true) : i6;
    }

    protected int ch() {
        return this.gq.cw() + this.gq.r();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void cw() {
        r();
    }

    public void f() {
        if (!this.az.get() || this.f28372p.hasMessages(11)) {
            return;
        }
        this.f28372p.sendEmptyMessageDelayed(11, this.la);
    }

    public View g() {
        int kc = this.xt.kc();
        return kc != 1 ? kc != 3 ? com.bytedance.sdk.openadsdk.res.up.j(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.r(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.cw(this.f28369j);
    }

    protected int gx() {
        return (int) (this.kt.h() / 1000);
    }

    public com.bytedance.sdk.openadsdk.core.nativeexpress.qv hh() {
        return this.rn;
    }

    public int hl() {
        return this.gq.up();
    }

    public void j(int i6, int i7, Intent intent) {
    }

    public AbstractEndCardFrameLayout jy() {
        return this.qv;
    }

    public void kt() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.oq;
        if (upVar != null) {
            upVar.j(this.gq);
        }
        if (this.ws) {
            this.f28366g.xt((int) (this.kt.h() / 1000));
        }
    }

    public int m(boolean z5) {
        return (sm() && this.tj.c()) ? this.f28374s : (xq() && e.i(this.xt)) ? Math.max(n() - ch(), 0) : ae(z5);
    }

    protected float[] mi() {
        TTBaseVideoActivity tTBaseVideoActivity = this.f28369j;
        int r5 = ed.r(tTBaseVideoActivity, ed.qv((Context) tTBaseVideoActivity));
        float f6 = this.f28371m;
        float f7 = this.up;
        int i6 = this.cw;
        if ((i6 == 1) != (f6 > f7)) {
            float f8 = f6 + f7;
            f7 = f8 - f7;
            f6 = f8 - f7;
        }
        if (i6 == 1) {
            f6 -= r5;
        } else {
            f7 -= r5;
        }
        return new float[]{f7, f6};
    }

    protected int n() {
        return tj.cw(this.xt) ? tj.up(this.xt) : e.az(this.xt);
    }

    protected void nd() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.oq;
        if (upVar != null) {
            upVar.j(this.gq);
        }
        if (sm() && this.tj.c()) {
            a();
        } else {
            k();
        }
    }

    public boolean ol() {
        return !this.ws && e.v(this.xt) && this.cw == 1;
    }

    public View oq() {
        if (this.qv == null) {
            this.qv = new CommonEndCardFrameLayout(this.f28369j, this.xt);
        }
        return this.qv;
    }

    public View qv() {
        return com.bytedance.sdk.openadsdk.res.up.up(this.f28369j);
    }

    protected void rh() {
        if (this.f28376w || Build.VERSION.SDK_INT == 26) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.f28369j;
        tTBaseVideoActivity.setTheme(kt.tl(tTBaseVideoActivity, "tt_full_screen_interaction"));
        ed.ae((Activity) this.f28369j);
        this.f28376w = true;
    }

    protected void s() {
        if (this.az.getAndSet(true)) {
            return;
        }
        this.f28372p.sendEmptyMessage(11);
    }

    public void tj() {
        this.f28372p.removeMessages(11);
    }

    public final int v() {
        return this.ae;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.up vl() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.up(this.f28369j);
        this.oq = upVar;
        return upVar;
    }

    public FrameLayout w() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar;
        return com.bytedance.sdk.openadsdk.core.tj.kt.r(this.xt) ? this.qv.getVideoArea() : (m() && (upVar = this.oq) != null && upVar.m()) ? this.oq.j() : this.f28366g.vl();
    }

    public void x() {
        if (e.i(this.xt)) {
            f();
        }
        if (this.tj.c()) {
            s();
        }
    }

    public void xt() {
        zz();
        ry();
        if (xq()) {
            e.j(this.xt, true);
        }
        if (e()) {
            this.tj.j();
        }
        if (m()) {
            up();
        } else {
            this.f28369j.mi();
            cw();
        }
    }

    public int z() {
        return this.gq.r();
    }

    public j(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        this.f28369j = tTBaseVideoActivity;
        this.xt = nVar;
        this.cw = nVar.zw();
        this.f28373r = nVar.uo();
    }

    private int tl(boolean z5) {
        long h6 = this.kt.h();
        if (z5) {
            return (int) Math.max(((int) (r1 / 1000)) + (((int) (Math.max(Math.min(e.j(), (long) ((this.kt.l() * 1000.0d) * (this.xt.nw() / 100.0f))) - (h6 + (z() * 1000)), 0L) % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long min = Math.min(e.j(), (long) (this.kt.l() * 1000.0d));
        long z6 = z() * 1000;
        long l6 = (long) ((this.kt.l() % 1.0d) * 1000.0d);
        if (l6 > 0) {
            h6 -= 1000 - l6;
        }
        return Math.round((min - (h6 + z6)) / 1000.0f);
    }

    public void cw(int i6) {
        this.la = i6;
    }

    public void j(View view) {
    }

    public int uf() {
        if (sm() && this.tj.c()) {
            return this.f28374s;
        }
        if (xq() && e.i(this.xt)) {
            return (int) Math.max((n() * (this.xt.nw() / 100.0f)) - ch(), 0.0f);
        }
        return ed();
    }

    public int wq() {
        if (xq() && e.i(this.xt)) {
            return ch();
        }
        return gx() + z();
    }

    public void j(Map<String, Object> map) {
    }

    public void j(JSONObject jSONObject) {
    }

    public void j(com.bytedance.sdk.openadsdk.core.component.reward.xt.up upVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.m mVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.xt xtVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.r rVar, com.bytedance.sdk.openadsdk.core.component.reward.xt.j jVar) {
        this.mi = upVar;
        this.kt = mVar;
        this.tj = xtVar;
        this.f28365f = rVar;
        this.ch = jVar;
    }

    public void j(String str, boolean z5, boolean z6) {
        this.vl = str;
        this.jy = z5;
        this.ws = z6;
        this.gq = new com.bytedance.sdk.openadsdk.core.component.reward.up.cw(z6, this.xt, this.kt, this);
    }

    public void r(boolean z5) {
        if (z5) {
            if (this.cw == 1) {
                this.f28366g.r(0);
            }
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.xt)) {
                this.f28366g.m(0);
                return;
            }
            return;
        }
        if (this.cw == 1) {
            this.f28366g.r(8);
        }
    }

    public void xt(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.oq;
        if (upVar != null) {
            upVar.up();
        }
    }

    public void xt(int i6) {
        this.f28367h = i6;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.xt.up j() {
        return this.mi;
    }

    public final void j(com.bytedance.sdk.openadsdk.core.xt.up upVar) {
        this.tl = upVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.f28369j;
        n nVar = this.xt;
        String str = this.vl;
        this.f28375v = new com.bytedance.sdk.openadsdk.core.nativeexpress.m(tTBaseVideoActivity, nVar, str, uf.xt(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.j.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.m, com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                if (n.up(this.f31364j)) {
                    return;
                }
                super.j(view, qvVar);
                j.this.f28369j.j(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.f28369j;
        n nVar2 = this.xt;
        String str2 = this.vl;
        this.f28377x = new com.bytedance.sdk.openadsdk.core.nativeexpress.up(tTBaseVideoActivity2, nVar2, str2, uf.xt(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.j.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.up, com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                if (n.up(this.f31364j)) {
                    return;
                }
                super.j(view, qvVar);
                com.bytedance.sdk.openadsdk.core.xt.j.xt xtVar = (com.bytedance.sdk.openadsdk.core.xt.j.xt) this.tl.j(com.bytedance.sdk.openadsdk.core.xt.j.xt.class);
                if (xtVar == null || !xtVar.xt(view)) {
                    return;
                }
                j.this.f28369j.j(2);
            }
        };
        this.qv.setClickListener(this.tl);
    }

    public void r(int i6) {
        this.gq.j(i6);
    }

    public void gq() {
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.cw cwVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.cw(this.f28369j, this.xt, z5);
        this.f28366g = cwVar;
        return cwVar;
    }

    public void ws() {
    }

    public void j(int i6, int i7) {
        this.up = i6;
        this.f28371m = i7;
    }

    public void up(boolean z5) {
        this.jy = z5;
        this.kt.cw(z5);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what == 11) {
            if (!this.f28368i) {
                this.gq.xt();
            }
            nd();
            this.f28372p.sendEmptyMessageDelayed(11, this.la);
        }
    }

    public xt.j j(final com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.cw.cw cwVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw.cw(this.f28369j, this.xt);
        cwVar.j(c());
        cwVar.xt(wq());
        cwVar.cw(this.f28369j.h());
        cwVar.r(this.f28369j.la());
        cwVar.cw(this.f28364a);
        cwVar.r(e.s(this.xt) && !this.f28369j.tl.get());
        this.f28369j.gx();
        return cwVar.xt(new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.j.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j();
                }
                j.this.f28369j.n();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void cw() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.cw();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.xt();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j(int i6) {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j(i6);
                }
            }
        });
    }
}
