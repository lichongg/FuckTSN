package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.amap.api.services.core.AMapException;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j;
import com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.r.g;
import com.bytedance.sdk.openadsdk.core.component.reward.r.qv;
import com.bytedance.sdk.openadsdk.core.component.reward.r.tl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog;
import com.bytedance.sdk.openadsdk.core.component.reward.xt.cw;
import com.bytedance.sdk.openadsdk.core.component.reward.xt.j;
import com.bytedance.sdk.openadsdk.core.component.reward.xt.m;
import com.bytedance.sdk.openadsdk.core.component.reward.xt.r;
import com.bytedance.sdk.openadsdk.core.dislike.ui.j;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.s;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.la;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.oq;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.bytedance.sdk.openadsdk.core.tl.xt;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.xt.j;
import com.bytedance.sdk.openadsdk.core.xt.j.cw.cw;
import com.bytedance.sdk.openadsdk.core.xt.up;
import com.bytedance.sdk.openadsdk.l.oq;
import com.bytedance.sdk.openadsdk.oq.j.xt;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class TTBaseVideoActivity extends BaseThemeActivity implements l.j, xt {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f28052a;
    protected final ConcurrentHashMap<Integer, Boolean> ae;
    private j.xt aq;
    protected final AtomicBoolean av;
    protected final AtomicBoolean az;

    /* renamed from: b, reason: collision with root package name */
    protected up f28053b;

    /* renamed from: c, reason: collision with root package name */
    r f28054c;
    protected boolean ch;
    protected final AtomicBoolean cw;

    /* renamed from: e, reason: collision with root package name */
    protected int f28055e;
    m ed;

    /* renamed from: f, reason: collision with root package name */
    protected final AtomicBoolean f28056f;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j ff;

    /* renamed from: g, reason: collision with root package name */
    protected final AtomicBoolean f28057g;
    AbstractEndCardFrameLayout gq;
    protected cw gx;

    /* renamed from: h, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.component.reward.layout.xt f28058h;
    protected String hh;
    protected int hl;

    /* renamed from: i, reason: collision with root package name */
    protected final AtomicBoolean f28059i;
    private long im;

    /* renamed from: j, reason: collision with root package name */
    protected final String f28060j;
    protected final AtomicBoolean jy;

    /* renamed from: k, reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j f28061k;
    private com.bytedance.sdk.openadsdk.core.xt.xt kc;
    private AtomicBoolean ki;
    protected final AtomicBoolean kt;

    /* renamed from: l, reason: collision with root package name */
    protected int f28062l;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.up la;
    private Double ln;

    /* renamed from: m, reason: collision with root package name */
    protected final ConcurrentHashMap<Integer, Boolean> f28063m;
    protected final AtomicBoolean mi;

    /* renamed from: n, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.component.reward.r.j f28064n;
    protected TTBaseVideoActivity nd;
    private com.bytedance.sdk.openadsdk.core.component.reward.up.r nt;
    protected String ol;
    protected final AtomicBoolean oq;

    /* renamed from: p, reason: collision with root package name */
    RewardFullBaseLayout f28065p;
    private int pz;

    /* renamed from: q, reason: collision with root package name */
    protected int f28066q;
    private int qa;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r qb;
    protected final AtomicBoolean qv;

    /* renamed from: r, reason: collision with root package name */
    protected final AtomicBoolean f28067r;
    protected int rh;
    private final j.InterfaceC0466j ri;
    com.bytedance.sdk.openadsdk.core.component.reward.xt.up rn;
    private j.InterfaceC0445j rr;
    private final AtomicBoolean ry;

    /* renamed from: s, reason: collision with root package name */
    protected long f28068s;
    protected j.InterfaceC0494j sm;
    private float st;
    protected final AtomicBoolean tj;
    public final AtomicBoolean tl;
    private com.bytedance.sdk.openadsdk.l.j uc;
    com.bytedance.sdk.openadsdk.core.component.reward.xt.j uf;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f28069v;
    protected final AtomicBoolean vl;

    /* renamed from: w, reason: collision with root package name */
    protected final AtomicBoolean f28070w;
    private int wf;
    com.bytedance.sdk.openadsdk.core.component.reward.xt.xt wq;
    protected final AtomicBoolean ws;

    /* renamed from: x, reason: collision with root package name */
    protected boolean f28071x;
    private xt.j xp;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j xq;
    protected final l xt;

    /* renamed from: y, reason: collision with root package name */
    private long f28072y;
    protected com.bytedance.sdk.openadsdk.core.playable.xt.xt ya;

    /* renamed from: z, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.j f28073z;
    private boolean zz;

    public boolean a() {
        return false;
    }

    public abstract boolean ch();

    public void cw(int i6) {
    }

    protected abstract void cw(boolean z5);

    public void gx() {
        jy(0);
    }

    public int l() {
        return 0;
    }

    public void n() {
        ws(0);
    }

    public void r(int i6) {
    }

    protected abstract void r(String str);

    protected abstract void s();

    public void tl(int i6) {
    }

    private void aq() {
        n nVar = this.up;
        if (nVar == null || this.f28065p == null) {
            return;
        }
        String sz = nVar.sz();
        if (TextUtils.isEmpty(sz)) {
            return;
        }
        try {
            int optInt = new JSONObject(sz).optInt("auth_reward_gold");
            if (optInt > 0) {
                this.f28065p.addView(new RewardAuthToastLayout(this.nd, optInt));
            }
        } catch (JSONException e6) {
            vl.xt("TTBaseVideoActivity", e6);
        }
    }

    private boolean im() {
        xt.j jVar = this.xp;
        return jVar != null && jVar.r();
    }

    private void kc() {
        com.bytedance.sdk.openadsdk.core.component.reward.r.j j6 = com.bytedance.sdk.openadsdk.core.component.reward.r.r.j(this.nd, this.up);
        this.f28064n = j6;
        if (j6 == null) {
            vl.r("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        j6.getClass();
        if (!la.xt(ch(), this.up, true)) {
            this.f28069v = v.xt().j(this.up, this.rh);
        }
        this.f28064n.j(this.rn, this.ed, this.wq, this.f28054c, this.uf);
        this.f28064n.j(this.f28060j, this.f28069v, ch());
        this.f28064n.tl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ki() {
        return (this.up.ve() == 180 && e.i(this.up) && oq.j(this.up) && this.la.g() == 7) ? false : true;
    }

    private void nt() {
        this.jy.set(true);
    }

    private void pz() {
        final View view;
        n nVar = this.up;
        if (nVar == null || !nVar.r()) {
            int by = v.xt().by();
            try {
                requestWindowFeature(1);
                getWindow().addFlags(16777216);
                getWindow().addFlags(128);
                v.j(this.nd);
                if (!this.f28064n.ol()) {
                    getWindow().addFlags(1024);
                    if (by == 1) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            getWindow().setDecorFitsSystemWindows(true);
                        }
                        getWindow().getDecorView().setFitsSystemWindows(true);
                    }
                }
            } catch (Throwable unused) {
            }
            if (by == 1) {
                return;
            }
            try {
                view = getWindow().getDecorView();
            } catch (Throwable unused2) {
                view = null;
            }
            if (view == null) {
                return;
            }
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ed.xt() && TTBaseVideoActivity.this.pz == 1 && TTBaseVideoActivity.this.nd.getResources().getConfiguration().orientation == 1) {
                            Rect rect = new Rect();
                            TTBaseVideoActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                            if (Math.abs(ed.g((Context) TTBaseVideoActivity.this.nd) - (rect.bottom - rect.top)) == 0 && view.isAttachedToWindow()) {
                                View view2 = view;
                                view2.setPadding(view2.getPaddingLeft(), (int) (view.getPaddingTop() + ed.qv((Context) TTBaseVideoActivity.this.nd)), view.getPaddingRight(), view.getPaddingBottom());
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        }
    }

    private void qa() {
        if (this.wq.rn() || !this.f28071x || qb() || !this.f28064n.qb() || this.ed.n()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if ((jVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.r.cw) || (jVar instanceof qv)) {
            return;
        }
        this.xt.removeMessages(300);
        this.xt.sendEmptyMessageDelayed(300, 5000L);
    }

    private void ri() {
        if (kt.r(this.up)) {
            this.ed.nd();
            return;
        }
        qv();
        if (!e.i(this.up)) {
            com.bykv.vk.openvk.component.video.api.r.cw c6 = hl().c();
            if (!(c6 instanceof com.bytedance.sdk.openadsdk.core.video.j.j) || !((com.bytedance.sdk.openadsdk.core.video.j.j) c6).rn()) {
                cw(0);
                this.rn.j(false, null, null, true, true);
                if (e.ae(this.up) && this.ed.tj() >= e.oq(this.up)) {
                    cw(2);
                }
                this.f28064n.gq();
            }
        }
        nt();
        if (e.ae(this.up)) {
            cw(2);
        }
        this.f28064n.gq();
    }

    private void rr() {
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, getClass().getName());
        this.rh = uf.g(this.up);
        this.st = this.up.uo();
        this.pz = this.up.zw();
        e.j(this.up, false);
        e.xt(this.up, false);
        com.bytedance.sdk.openadsdk.core.tl.r.cw = false;
        com.bytedance.sdk.openadsdk.core.tl.r.xt = 0;
        com.bytedance.sdk.openadsdk.core.tl.r.f30512j = 0;
        com.bytedance.sdk.openadsdk.core.tl.r.f30514r = false;
    }

    private boolean ry() {
        if (this.up != null && com.bytedance.sdk.openadsdk.core.live.xt.j().xt(this.up)) {
            String sz = this.up.sz();
            if (TextUtils.isEmpty(sz)) {
                return false;
            }
            try {
                return new JSONObject(sz).optInt("saas_play_time_type") == 1;
            } catch (JSONException e6) {
                vl.xt("TTBaseVideoActivity", e6);
            }
        }
        return false;
    }

    private void uc() {
        if (this.ed.gq().qb()) {
            if (this.up.tz() == 9 && this.ed.wq()) {
                this.la.xt(true);
                this.ed.gx();
            } else {
                this.la.xt(false);
            }
            m(1);
            return;
        }
        this.la.xt(true);
        if (this.ed.gq().hl() < 2) {
            ri();
        }
        if (this.up.tz() == 8) {
            m(1);
        } else {
            i();
        }
    }

    private void zz() {
        this.f28065p = new RewardFullBaseLayout(this.nd);
        this.rn = new com.bytedance.sdk.openadsdk.core.component.reward.xt.up(this.nd);
        this.wq = new com.bytedance.sdk.openadsdk.core.component.reward.xt.xt(this.nd);
        this.uf = new com.bytedance.sdk.openadsdk.core.component.reward.xt.j(this.nd);
        this.ed = new m(this.nd);
        this.f28054c = new r(this.nd);
        this.gx = new cw(this.nd);
    }

    public Map<String, Object> ae() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar;
        Map<String, Object> nd = nd();
        if (this.f28068s > 0) {
            nd.put("object_media_holder_time", Long.valueOf((System.currentTimeMillis() - this.f28068s) / 1000));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if (jVar != null && jVar.m() && (upVar = this.la) != null) {
            s.j(nd, this.up, upVar.vl());
        }
        return nd;
    }

    protected void av() {
        if (!wf()) {
            i();
        }
        this.ed.oq();
    }

    protected void az() {
        this.xt.removeMessages(400);
    }

    public cw b() {
        return this.gx;
    }

    public void c() {
        this.xt.removeMessages(600);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.r.j e() {
        return this.f28064n;
    }

    public int ed() {
        return Math.max(this.f28064n.hl() - (((int) (this.ed.h() / 1000)) + this.f28064n.z()), 0);
    }

    public void f() {
        this.f28054c.cw();
        this.wq.wq();
        this.rn.j(1);
        this.xt.removeMessages(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 0);
            if (ch()) {
                jSONObject.put("reduce_duration", this.f28064n.z());
            }
            this.la.j("playableStateChange", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (!this.f28061k.j(1)) {
            this.f28059i.set(true);
        }
        j(1, (com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r) null);
    }

    public void ff() {
        this.f28061k.xt(false);
    }

    public void g() {
        if (this.wq.ws()) {
            this.wq.az();
            return;
        }
        if (!this.wq.ch() && !com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.up) && !com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.up)) {
            j();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                if (kt.qv(((BaseThemeActivity) TTBaseVideoActivity.this).up)) {
                    new j.C0460j().up(((BaseThemeActivity) TTBaseVideoActivity.this).up.fs()).j("rewarded_video").xt("popup_play").r(((BaseThemeActivity) TTBaseVideoActivity.this).up.os()).j((com.bytedance.sdk.openadsdk.m.j.j) null);
                    if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(((BaseThemeActivity) TTBaseVideoActivity.this).up) || com.bytedance.sdk.openadsdk.core.ugeno.oq.r(((BaseThemeActivity) TTBaseVideoActivity.this).up)) {
                        return;
                    }
                    TTBaseVideoActivity.this.xt("onClickModalCallback");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                if (kt.qv(((BaseThemeActivity) TTBaseVideoActivity.this).up)) {
                    new j.C0460j().up(((BaseThemeActivity) TTBaseVideoActivity.this).up.fs()).j("rewarded_video").xt("popup_cancel").r(((BaseThemeActivity) TTBaseVideoActivity.this).up.os()).j((com.bytedance.sdk.openadsdk.m.j.j) null);
                    TTBaseVideoActivity.this.jy();
                    TTBaseVideoActivity.this.j();
                }
            }
        };
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.up) || com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.up)) {
            xt(oqVar);
        } else {
            cw(oqVar);
        }
    }

    public RewardFullBaseLayout gq() {
        return this.f28065p;
    }

    public String h() {
        return "";
    }

    public void hh() {
        if (this.ws.getAndSet(true)) {
            return;
        }
        m(3);
    }

    public m hl() {
        return this.ed;
    }

    public void i() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.la;
        if (upVar != null) {
            upVar.j("videoLoopBegin", (JSONObject) null);
        }
    }

    public void j() {
        finish();
    }

    public void jy() {
        if (this.vl.get() || this.oq.getAndSet(true)) {
            return;
        }
        r("onSkippedVideo");
    }

    protected boolean kt() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.f28073z;
        if (jVar != null) {
            return jVar.cw();
        }
        return false;
    }

    public String la() {
        return "";
    }

    void m() {
        up upVar = new up(this.nd, this.up, this.f28060j, ch() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.xt.up
            public void xt(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                TTBaseVideoActivity.this.j(2);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.uf.j(view, tTBaseVideoActivity.rr, qvVar);
            }
        };
        this.f28053b = upVar;
        if (this.f28064n instanceof com.bytedance.sdk.openadsdk.core.component.reward.r.m) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.ri);
        }
        j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) this.f28053b.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        this.f28053b.j(this.f28058h.jy());
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.f28053b.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(nd());
        com.bytedance.sdk.openadsdk.core.xt.xt xtVar = new com.bytedance.sdk.openadsdk.core.xt.xt(this.nd, this.up, this.f28060j, ch() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.20
            @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                TTBaseVideoActivity.this.gx.j(view, qvVar);
            }
        };
        this.kc = xtVar;
        j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) xtVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
        this.rr = new j.InterfaceC0445j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.InterfaceC0445j
            public void j(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.gx.j(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.InterfaceC0445j
            public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                TTBaseVideoActivity.this.gx.j(view, qvVar);
            }
        };
        this.aq = new j.xt() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.xt
            public void j(boolean z5) {
                if (z5) {
                    TTBaseVideoActivity.this.wq.j(1, 0);
                }
                TTBaseVideoActivity.this.j("点击开始下载");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.xt
            public void cw(boolean z5, long j6, long j7, String str, String str2) {
                if (z5) {
                    TTBaseVideoActivity.this.wq.j(j7, j6, 4);
                }
                TTBaseVideoActivity.this.j("下载失败");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.xt
            public void xt(boolean z5, long j6, long j7, String str, String str2) {
                if (z5) {
                    TTBaseVideoActivity.this.wq.j(j7, j6, 2);
                }
                TTBaseVideoActivity.this.j("下载暂停");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.xt
            public void j(boolean z5, long j6, long j7, String str, String str2) {
                long j8;
                long j9;
                if (z5) {
                    j8 = j6;
                    j9 = j7;
                    TTBaseVideoActivity.this.wq.j(j9, j8, 3);
                } else {
                    j8 = j6;
                    j9 = j7;
                }
                if (j8 > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.j("已下载" + ((int) ((100 * j9) / j8)) + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.xt
            public void j(boolean z5, long j6, String str, String str2) {
                if (z5) {
                    TTBaseVideoActivity.this.wq.j(5, 100);
                }
                TTBaseVideoActivity.this.j("点击安装");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.xt.j.xt
            public void j(boolean z5, String str, String str2) {
                if (z5) {
                    TTBaseVideoActivity.this.wq.j(6, 100);
                }
                TTBaseVideoActivity.this.j("点击打开");
            }
        };
        this.f28064n.j(this.f28053b);
    }

    public void mi() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar;
        if (this.qb == null || (upVar = this.la) == null || upVar.vl() == null) {
            return;
        }
        this.la.vl().setEasyPlayableSender(this.qb.j());
        this.qb.j(gq().getEasyPlayableContainer(), null);
    }

    public Map<String, Object> nd() {
        HashMap hashMap = new HashMap();
        String str = this.hh;
        if (str != null) {
            hashMap.put("rit_scene", str);
        }
        hashMap.put("insert_ad_control", Integer.valueOf(la.j(this.up)));
        hashMap.put("carousel_pos", Integer.valueOf(la.r(this.up)));
        hashMap.put("refresh_ad_control", Integer.valueOf(la.xt(this.up)));
        if (this.f28061k.xt() != 0) {
            hashMap.put("carousel_type", Integer.valueOf(this.f28061k.xt()));
        }
        cw cwVar = this.gx;
        if (cwVar != null) {
            cwVar.j(hashMap);
        }
        return hashMap;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        n nVar = this.up;
        if (nVar == null) {
            return;
        }
        if (n.cw(nVar) || this.up.fv() == 1 || (this.f28064n instanceof g)) {
            this.wq.az();
        }
        com.bytedance.sdk.openadsdk.core.playable.xt.xt xtVar = this.ya;
        if ((xtVar == null || !xtVar.xt(this.nd, this.up)) && kt.qv(this.up)) {
            g();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        com.bytedance.sdk.openadsdk.core.playable.xt.xt xtVar = this.ya;
        if (xtVar != null) {
            xtVar.j(i6);
        }
        return super.onKeyDown(i6, keyEvent);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.ol);
            bundle.putBoolean("is_preload", this.ch);
            bundle.putLong("object_create_ts", this.f28068s);
            bundle.putBoolean("is_adm", this.f28052a);
            bundle.putInt("key_video_cache_callback", this.f28062l);
            bundle.putLong("video_current", this.ed.av());
            bundle.putBoolean("is_mute", this.f28069v);
            bundle.putString("rit_scene", this.hh);
            Double d6 = this.ln;
            bundle.putString("_client_bidding_aution_price", d6 == null ? "" : String.valueOf(d6));
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSkipBorderClick(View view) {
        this.f28064n.j(view);
    }

    public void oq() {
        if (this.f28064n.qb()) {
            this.ed.j(3);
            this.ed.mi();
            this.ed.cw(true);
            j(false, false);
        }
    }

    public String p() {
        return "";
    }

    public boolean q() {
        return this.f28063m.containsKey(0);
    }

    public boolean qb() {
        return !this.ae.isEmpty();
    }

    public void qv() {
        ws.j().j(this.up, "stats_reward_full_completed", this.gx.j(new JSONObject()));
        if (this.vl.getAndSet(true)) {
            return;
        }
        r("onVideoComplete");
    }

    public Double rh() {
        return this.ln;
    }

    public void rn() {
        boolean z5 = !this.f28069v;
        this.f28069v = z5;
        this.f28064n.up(z5);
    }

    public void sm() {
        this.tj.set(true);
    }

    public void tj() {
        this.rn.j(1);
        if (!e.i(this.up)) {
            this.rn.j(false, null, null, true, true);
        }
        this.rn.j(true);
        this.rn.up(true);
        this.rn.m(false);
        this.rn.xt(this.up.xa());
        this.f28054c.j(this.f28069v, this.f28063m.containsKey(0));
        this.xt.sendEmptyMessage(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", 1);
            this.la.j("playableStateChange", jSONObject);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public l uf() {
        return this.xt;
    }

    public void up() {
        if (this.f28064n.qb()) {
            if (xt(this.ed.m(), false)) {
                return;
            }
            j(true, true);
        } else {
            if (tj.ae(this.up)) {
                return;
            }
            xt(true, true);
        }
    }

    public void vl() {
        if (this.qv.getAndSet(true)) {
            return;
        }
        r("onVideoError");
    }

    public void w() {
        r();
    }

    public void wq() {
        this.f28054c.xt();
    }

    public void ws() {
        this.xt.removeMessages(700);
        this.xt.removeMessages(600);
    }

    public void xq() {
        this.f28061k.cw();
    }

    public void xt() {
        this.ed.gx();
        this.ed.j(2);
        this.ed.g();
        jy();
        m(2);
    }

    public void ya() {
        this.rn.m();
    }

    public boolean z() {
        return this.f28054c.r() || this.wq.rn();
    }

    public TTBaseVideoActivity() {
        String str;
        if (ch()) {
            str = "rewarded_video";
        } else {
            str = "fullscreen_interstitial_ad";
        }
        this.f28060j = str;
        this.xt = new l(Looper.getMainLooper(), this);
        this.cw = new AtomicBoolean(false);
        this.f28067r = new AtomicBoolean(false);
        this.f28063m = new ConcurrentHashMap<>();
        this.ae = new ConcurrentHashMap<>();
        this.tl = new AtomicBoolean(false);
        this.f28057g = new AtomicBoolean(false);
        this.oq = new AtomicBoolean(false);
        this.ry = new AtomicBoolean(false);
        this.qv = new AtomicBoolean(false);
        this.vl = new AtomicBoolean(false);
        this.jy = new AtomicBoolean(false);
        this.ws = new AtomicBoolean(false);
        this.az = new AtomicBoolean(false);
        this.av = new AtomicBoolean(false);
        this.f28059i = new AtomicBoolean(false);
        this.f28070w = new AtomicBoolean(false);
        this.mi = new AtomicBoolean(false);
        this.kt = new AtomicBoolean(false);
        this.tj = new AtomicBoolean(false);
        this.f28056f = new AtomicBoolean(false);
        this.f28062l = -1;
        this.pz = 1;
        this.ln = null;
        this.im = 0L;
        this.f28055e = 0;
        this.f28066q = 0;
        this.sm = new j.InterfaceC0494j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void j() {
                TTBaseVideoActivity.this.xt.removeMessages(300);
                TTBaseVideoActivity.this.az();
                if (!TTBaseVideoActivity.this.ed.vl()) {
                    if (TTBaseVideoActivity.this.wf()) {
                        m mVar = TTBaseVideoActivity.this.ed;
                        mVar.xt(mVar.la());
                    } else {
                        m mVar2 = TTBaseVideoActivity.this.ed;
                        mVar2.xt(mVar2.h() + 1000);
                    }
                }
                if (TTBaseVideoActivity.this.f28064n.m() && !TTBaseVideoActivity.this.ed.vl()) {
                    TTBaseVideoActivity.this.la.xt(true);
                }
                TTBaseVideoActivity.this.k();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void cw() {
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r rVar = TTBaseVideoActivity.this.qb;
                if (rVar == null || rVar.j() == null) {
                    return;
                }
                TTBaseVideoActivity.this.qb.j().j();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void xt() {
                TTBaseVideoActivity.this.xt.removeMessages(300);
                TTBaseVideoActivity.this.az();
                TTBaseVideoActivity.this.j(false, false);
                TTBaseVideoActivity.this.ed.j(6);
                TTBaseVideoActivity.this.ed.g();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void j(int i6, String str2) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (tTBaseVideoActivity.f28071x) {
                    tTBaseVideoActivity.xt.removeMessages(300);
                    TTBaseVideoActivity.this.vl();
                    TTBaseVideoActivity.this.ed.j(5);
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    tTBaseVideoActivity2.xt(tTBaseVideoActivity2.ed.xt());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xt.j.InterfaceC0494j
            public void j(long j6, long j7) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (!tTBaseVideoActivity.f28071x && tTBaseVideoActivity.ed.xt()) {
                    TTBaseVideoActivity.this.ed.j((Map<String, Object>) null);
                }
                boolean z5 = true;
                if (TTBaseVideoActivity.this.wq.rn()) {
                    TTBaseVideoActivity.this.ed.cw(true);
                    return;
                }
                TTBaseVideoActivity.this.xt.removeMessages(300);
                if (j6 != TTBaseVideoActivity.this.ed.h()) {
                    TTBaseVideoActivity.this.az();
                }
                if (TTBaseVideoActivity.this.ed.xt() || j7 == j6) {
                    TTBaseVideoActivity.this.ed.xt(j6);
                    if (TTBaseVideoActivity.this.ki()) {
                        TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = tTBaseVideoActivity2.la;
                        String valueOf = String.valueOf(tTBaseVideoActivity2.ed.p());
                        int h6 = (int) (TTBaseVideoActivity.this.ed.h() / 1000);
                        if (j6 != j7 && !TTBaseVideoActivity.this.ed.rn()) {
                            z5 = false;
                        }
                        upVar.j(valueOf, h6, 0, z5);
                    }
                    TTBaseVideoActivity.this.cw(0);
                    TTBaseVideoActivity.this.ol();
                    TTBaseVideoActivity.this.f28064n.kt();
                }
            }
        };
        this.xq = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int xt() {
                return TTBaseVideoActivity.this.f28064n.hh().xt();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public int cw() {
                return TTBaseVideoActivity.this.f28064n.hh().cw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long getActualPlayDuration() {
                return TTBaseVideoActivity.this.f28064n.hh().getActualPlayDuration();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i6) {
                TTBaseVideoActivity.this.f28064n.hh().j(i6);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void m() {
                TTBaseVideoActivity.this.f28064n.hh().m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void r() {
                TTBaseVideoActivity.this.f28064n.hh().r();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void setPauseFromExpressView(boolean z5) {
                TTBaseVideoActivity.this.f28064n.hh().setPauseFromExpressView(z5);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void up() {
                TTBaseVideoActivity.this.f28064n.hh().up();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void xt(int i6) {
                TTBaseVideoActivity.this.f28064n.hh().xt(i6);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public long j() {
                return TTBaseVideoActivity.this.f28064n.hh().j();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void xt(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                com.bytedance.sdk.openadsdk.core.tj.qv qvVar;
                if ((i6 == 1 || i6 == 2) && (cwVar instanceof x)) {
                    x xVar = (x) cwVar;
                    qvVar = new com.bytedance.sdk.openadsdk.core.tj.qv();
                    qvVar.j(xVar.f30480j);
                    qvVar.xt(xVar.xt);
                    qvVar.cw(xVar.cw);
                    qvVar.r(xVar.f30482r);
                    qvVar.j(xVar.up);
                    qvVar.xt(xVar.f30481m);
                    qvVar.j(xVar.az);
                } else {
                    qvVar = null;
                }
                if (i6 == 2) {
                    TTBaseVideoActivity.this.f28053b.j(view, qvVar);
                }
                if (i6 == 1) {
                    TTBaseVideoActivity.this.f28053b.j(view, qvVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(int i6, String str2) {
                TTBaseVideoActivity.this.f28064n.hh().j(i6, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.qv
            public void j(float f6) {
                TTBaseVideoActivity.this.f28064n.hh().j(f6);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(View view) {
                TTBaseVideoActivity.this.j(2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.j
            public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
                com.bytedance.sdk.openadsdk.core.tj.qv qvVar;
                if (TTBaseVideoActivity.this.f28053b != null) {
                    if (cwVar instanceof x) {
                        x xVar = (x) cwVar;
                        qvVar = new com.bytedance.sdk.openadsdk.core.tj.qv();
                        qvVar.j(xVar.f30480j);
                        qvVar.xt(xVar.xt);
                        qvVar.cw(xVar.cw);
                        qvVar.r(xVar.f30482r);
                        qvVar.j(xVar.up);
                        qvVar.xt(xVar.f30481m);
                        qvVar.j(xVar.az);
                    } else {
                        qvVar = null;
                    }
                    TTBaseVideoActivity.this.f28053b.j(view, qvVar);
                }
            }
        };
        this.ri = new j.InterfaceC0466j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
            public boolean p() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
            public com.bytedance.sdk.openadsdk.core.multipro.xt.j la() {
                com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
                m mVar = TTBaseVideoActivity.this.ed;
                if (mVar != null) {
                    jVar.ae = mVar.av();
                    jVar.f29581j = TTBaseVideoActivity.this.ed.j();
                    jVar.tl = TTBaseVideoActivity.this.f28069v;
                }
                return jVar;
            }
        };
        this.f28061k = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.xt(new j.InterfaceC0436j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public RewardFullBaseLayout j() {
                return TTBaseVideoActivity.this.f28065p;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public boolean ae() {
                return TTBaseVideoActivity.this.tj.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public n cw() {
                return ((BaseThemeActivity) TTBaseVideoActivity.this).up;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public boolean g() {
                return TTBaseVideoActivity.this.f28064n.b();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public TTBaseVideoActivity getActivity() {
                return TTBaseVideoActivity.this.nd;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public void j(int i6, int i7) {
                if (i6 == 3) {
                    TTBaseVideoActivity.this.jy(2);
                }
                TTBaseVideoActivity.this.j(i6, i7);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public int m() {
                return TTBaseVideoActivity.this.f28064n.m(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public void oq() {
                com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = TTBaseVideoActivity.this.f28064n;
                if (jVar instanceof qv) {
                    ((qv) jVar).zz();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public void qv() {
                com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = TTBaseVideoActivity.this.f28064n;
                if (jVar instanceof qv) {
                    ((qv) jVar).kc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public boolean r() {
                return TTBaseVideoActivity.this.zz;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public boolean tl() {
                return TTBaseVideoActivity.this.q();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public int up() {
                return TTBaseVideoActivity.this.f28066q;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public boolean xt() {
                return TTBaseVideoActivity.this.ch();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.j.InterfaceC0436j
            public void j(int i6) {
                if (i6 == 3) {
                    TTBaseVideoActivity.this.ws(2);
                }
            }
        });
        this.ff = new com.bytedance.sdk.openadsdk.core.component.reward.business.xt.xt(new j.InterfaceC0439j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.17
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public n j() {
                return ((BaseThemeActivity) TTBaseVideoActivity.this).up;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public void cw() {
                TTBaseVideoActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public Activity getActivity() {
                return TTBaseVideoActivity.this.nd;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public void j(int i6, TTProgressBar tTProgressBar) {
                try {
                    TTBaseVideoActivity.this.f28065p.j(i6, tTProgressBar);
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public void r() {
                TTBaseVideoActivity.this.gx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public void up() {
                m mVar = TTBaseVideoActivity.this.ed;
                if (mVar != null) {
                    mVar.ae();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public String xt() {
                return TTBaseVideoActivity.this.ol;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.InterfaceC0439j
            public void j(boolean z5, String str2, String str3) {
                if (tj.cw(((BaseThemeActivity) TTBaseVideoActivity.this).up)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visible", z5);
                    jSONObject.put("entrance_text", rh.j(((BaseThemeActivity) TTBaseVideoActivity.this).up, str2, str3));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                TTBaseVideoActivity.this.la.j("showPlayAgainEntrance", jSONObject);
                TTBaseVideoActivity.this.wq.j(jSONObject);
                if (TTBaseVideoActivity.this.wq.rn()) {
                    return;
                }
                TTBaseVideoActivity.this.rn.ae(z5);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.rn.j(rh.j(((BaseThemeActivity) tTBaseVideoActivity).up, str2, str3));
            }
        });
        this.ki = new AtomicBoolean(true);
    }

    private int ln() {
        com.bykv.vk.openvk.component.video.api.r.cw c6 = hl().c();
        if (c6 instanceof com.bytedance.sdk.openadsdk.core.video.xt.j) {
            return ((com.bytedance.sdk.openadsdk.core.video.xt.j) c6).hl();
        }
        return 0;
    }

    private void st() {
        ws.j().cw(this.up, "stats_reward_full_destroy");
        com.bytedance.sdk.openadsdk.core.tl.r.cw = false;
        com.bytedance.sdk.openadsdk.core.tl.r.xt = 0;
        com.bytedance.sdk.openadsdk.core.tl.r.f30512j = 0;
        com.bytedance.sdk.openadsdk.core.tl.r.f30514r = false;
        this.xt.removeCallbacksAndMessages(null);
        this.ed.ch();
        this.uf.m();
        this.wq.m();
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r rVar = this.qb;
        if (rVar != null) {
            rVar.xt();
        }
        cw(true);
        s();
        r("recycleRes");
        n nVar = this.up;
        if (nVar != null) {
            com.bytedance.sdk.openadsdk.core.x.j(nVar.uv());
            rn.xt(this.up.ae());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wf() {
        com.bykv.vk.openvk.component.video.api.r.cw c6 = hl().c();
        if (c6 instanceof com.bytedance.sdk.openadsdk.core.video.xt.j) {
            return ((com.bytedance.sdk.openadsdk.core.video.xt.j) c6).rn();
        }
        return false;
    }

    private void xp() {
        final View view;
        try {
            view = getWindow().getDecorView();
        } catch (Throwable unused) {
            view = null;
        }
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    view.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        });
        view.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    view.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (x()) {
            qa();
            this.ed.j(false, this, this.f28067r.getAndSet(true));
        }
    }

    public void az(int i6) {
        if (i6 == 0) {
            return;
        }
        this.ae.put(Integer.valueOf(i6), Boolean.TRUE);
    }

    protected void cw() {
        this.f28065p.j(this.f28064n);
        aq();
        this.f28058h = this.f28064n.j(ch());
        this.la = this.f28064n.vl();
        this.gq = this.f28064n.jy();
        this.f28058h.j();
        m();
        this.f28058h.j(this.f28053b, this.kc);
        this.f28058h.j(this.uf.ae());
        this.rn.j(this.up, this.wq, ch(), this.f28053b);
        this.rn.r(this.f28069v);
        if (this.uf.cw()) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.f28053b.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.uf.xt());
            this.uf.j(this.rr);
        }
        this.uf.j(this.aq);
        this.uf.j(this.ri);
        this.wq.j(this.rn, this.uf, ch(), this.f28060j, this.qa, this.wf);
        this.wq.j(this.up, this.f28053b, this.ri.la(), this.gq);
        this.f28054c.j(this.wq, this.up, this.f28060j, this.rn);
        this.gx.j(this.up, this.f28060j, this.f28058h.jy());
        this.ed.j(this.up);
        this.uc = new com.bytedance.sdk.openadsdk.l.j();
        this.qb = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r(this.up, false, this.xq);
        this.ya = new com.bytedance.sdk.openadsdk.core.playable.xt.xt(this.f28060j);
    }

    @Override // android.app.Activity
    public void finish() {
        Map<String, Object> nd = nd();
        com.bytedance.sdk.openadsdk.core.component.reward.xt.xt xtVar = this.wq;
        if (xtVar != null) {
            xtVar.j(nd);
            this.wq.r();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if (jVar != null) {
            jVar.xt(nd);
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.m(this.up, this.f28060j, "click_close", nd);
        s();
        super.finish();
    }

    protected boolean j(Bundle bundle) {
        this.uf.j(this.up, this.f28060j, this.ol);
        if (bundle != null) {
            this.uf.j();
        }
        com.bytedance.sdk.openadsdk.core.r.j().xt(this.up);
        if (this.up != null) {
            return true;
        }
        vl.r("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
        j();
        return false;
    }

    public void k() {
        if (wf()) {
            uc();
            return;
        }
        if (!this.ed.wq() && !this.ed.vl()) {
            ri();
        }
        m(1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ed.xt((Activity) this.nd);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i6) {
                    if (i6 == 0) {
                        com.bytedance.sdk.openadsdk.core.playable.xt.xt xtVar = TTBaseVideoActivity.this.ya;
                        if (xtVar != null) {
                            xtVar.j();
                        }
                        try {
                            if (TTBaseVideoActivity.this.isFinishing()) {
                                return;
                            }
                            if (TTBaseVideoActivity.this.pz == 2) {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ed.j((Activity) TTBaseVideoActivity.this.nd);
                                    }
                                }, 2500L);
                            } else {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ed.xt((Activity) TTBaseVideoActivity.this.nd);
                                    }
                                }, 500L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i6;
        super.onCreate(bundle);
        this.nd = this;
        zz();
        j(getIntent());
        xt(bundle);
        xt(getIntent());
        if (j(bundle)) {
            rr();
            kc();
            pz();
            tl();
            this.f28064n.j(this.qa, this.wf);
            setContentView(this.f28065p);
            cw();
            this.f28064n.xt();
            com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.la;
            if (upVar != null) {
                upVar.j(this.ri);
            }
            if (ry()) {
                this.nt = new com.bytedance.sdk.openadsdk.core.component.reward.up.r();
            }
            SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
            if (saasAuthRewardDialog != null) {
                n nVar = this.up;
                String str = this.f28060j;
                if (ch()) {
                    i6 = 7;
                } else {
                    i6 = 5;
                }
                saasAuthRewardDialog.j(nVar, str, i6);
            }
            if (la.xt(ch(), this.up, true)) {
                gq().getSceneFrameContainer().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.18
                    @Override // java.lang.Runnable
                    public void run() {
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TTBaseVideoActivity.this.gq().getSceneFrameContainer().getHeight(), 0.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setFillAfter(true);
                        TTBaseVideoActivity.this.gq().getSceneFrameContainer().startAnimation(translateAnimation);
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if (jVar != null) {
            jVar.az();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar2 = this.f28073z;
        if (jVar2 != null) {
            jVar2.xt();
        }
        st();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        gx();
        this.f28071x = false;
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if (jVar != null) {
            jVar.ws();
        }
        this.uf.up();
        this.wq.r();
        com.bytedance.sdk.openadsdk.core.component.reward.up.r rVar = this.nt;
        if (rVar != null) {
            rVar.cw();
        }
        this.xt.removeMessages(1300);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (ch() && this.ff.xt()) {
            j();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f28061k.up()) {
            j();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.up.r rVar = this.nt;
        boolean z5 = false;
        if (rVar != null) {
            rVar.r();
            int j6 = (int) this.nt.j(TimeUnit.SECONDS);
            j(j6, false);
            this.nt.up();
            if (this.la != null && !e.i(this.up)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", j6);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
                this.la.j("reduceTime", jSONObject);
            }
        }
        this.f28071x = true;
        this.wq.xt();
        this.uf.r();
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if (jVar != null) {
            jVar.xt(this.f28063m.containsKey(0));
            n();
            this.f28054c.j();
            xp();
            this.xt.sendEmptyMessageDelayed(1300, 1000L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r rVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r();
        if (la.j(ch()) > 0) {
            z5 = true;
        }
        rVar2.f28114j = z5;
        rVar2.xt = la.j(ch());
        j(1, rVar2);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.wq.vl();
        com.bytedance.sdk.openadsdk.l.j jVar = this.uc;
        if (jVar != null) {
            jVar.j();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if (jVar != null) {
            jVar.cw(this.tl.get());
        }
        this.wq.up();
        com.bytedance.sdk.openadsdk.l.j jVar2 = this.uc;
        if (jVar2 != null) {
            jVar2.xt();
        }
    }

    protected void r() {
        com.bytedance.sdk.openadsdk.core.component.reward.xt.xt xtVar;
        ws.j().cw(this.up, "stats_reward_full_show_endcard");
        if (isDestroyed() || isFinishing() || (xtVar = this.wq) == null || xtVar.rn()) {
            return;
        }
        if (!kt.r(this.up)) {
            this.wq.r(true);
        }
        this.f28064n.x();
        if (this.f28064n instanceof qv) {
            this.f28061k.xt(true);
            this.f28061k.m();
        }
        if (!(this.f28064n instanceof tl) || !this.wq.mi() || (this.f28064n instanceof g)) {
            this.wq.tj();
        }
        this.rn.j(true);
        this.f28054c.j(this.f28069v);
        this.wq.qv();
        if ((this.f28064n instanceof tl) && this.wq.l()) {
            this.wq.tl();
            return;
        }
        this.rn.j(2);
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.f28073z;
        if (jVar != null) {
            jVar.xt();
        }
        xt.j jVar2 = this.xp;
        if (jVar2 != null) {
            jVar2.up();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar2 = this.f28058h;
        if (xtVar2 != null) {
            xtVar2.up(8);
        }
        this.wq.cw(false);
        if (this.wq.av()) {
            if (!ln.oq(this.up) && !tj.xt(this.up)) {
                this.wq.j(true, 0, (String) null);
            }
            this.wq.jy();
            this.xt.sendEmptyMessageDelayed(500, 100L);
            return;
        }
        if (!ln.oq(this.up)) {
            this.wq.j(false, TTAdConstant.INTERACTION_TYPE_CODE, "end_card_timeout");
        }
        this.wq.up(true);
        this.ed.tl();
    }

    protected void tl() {
        float[] j6 = com.bytedance.sdk.openadsdk.core.component.reward.up.xt.j(StubApp.getOrigApplicationContext(this.nd.getApplicationContext()), this.st, this.pz);
        float f6 = j6[0];
        float f7 = j6[1];
        if (this.st == 100.0f) {
            this.qa = (int) f6;
            this.wf = (int) f7;
            return;
        }
        int[] j7 = com.bytedance.sdk.openadsdk.core.component.reward.up.xt.j(StubApp.getOrigApplicationContext(this.nd.getApplicationContext()), this.st, this.up.bh(), this.pz);
        int i6 = j7[0];
        int i7 = j7[1];
        int i8 = j7[2];
        int i9 = j7[3];
        float f8 = i6;
        float f9 = i8;
        this.qa = (int) ((f6 - f8) - f9);
        float f10 = i7;
        float f11 = i9;
        this.wf = (int) ((f7 - f10) - f11);
        if (!com.bytedance.sdk.openadsdk.core.tj.l.j(this.up) || com.bytedance.sdk.openadsdk.core.ws.r.j(String.valueOf(this.rh))) {
            try {
                this.f28065p.j(ed.cw(this.nd, f8), ed.cw(this.nd, f10), ed.cw(this.nd, f9), ed.cw(this.nd, f11));
            } catch (Throwable unused) {
            }
        }
    }

    protected boolean v() {
        if (!im() && !kt() && !this.f28064n.h()) {
            return false;
        }
        return true;
    }

    public boolean x() {
        if (v() || this.ed.n()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if ((jVar != null && !jVar.qb()) || this.f28054c.r() || this.wq.rn()) {
            return false;
        }
        return true;
    }

    public void vl(int i6) {
        this.f28058h.up(i6);
    }

    public void ws(int i6) {
        av(i6);
        if (this.f28064n instanceof g) {
            this.xt.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.y();
                }
            }, 500L);
        } else {
            y();
        }
        if (v()) {
            return;
        }
        if (this.wq.p()) {
            this.xt.sendEmptyMessageDelayed(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, 1000L);
        }
        if (!qb() || this.wq.rn() || this.wq.p()) {
            this.f28064n.f();
        }
        this.wq.cw();
    }

    public void av(int i6) {
        if (i6 == 0) {
            return;
        }
        this.ae.remove(Integer.valueOf(i6));
    }

    public void jy(int i6) {
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar;
        if (this.ed.xt()) {
            HashMap hashMap = new HashMap();
            hashMap.put("pause_from", Integer.valueOf(i6));
            this.ed.j(hashMap);
        }
        this.xt.removeMessages(300);
        this.xt.removeMessages(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
        az(i6);
        if ((qb() && e.i(this.up) && this.f28054c.r()) || (jVar = this.f28064n) == null) {
            return;
        }
        jVar.tj();
        this.wq.xt(qb());
    }

    public void qv(int i6) {
        this.f28064n.r(i6);
        cw(0);
    }

    private void xt(com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        int uf = this.f28064n.uf();
        TTBaseVideoActivity tTBaseVideoActivity = this.nd;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.nd.getIntent().putExtra("remainTime", uf);
        }
        if (uf > 0) {
            if (j(oqVar)) {
                return;
            }
            oqVar.xt();
            return;
        }
        j();
    }

    public void oq(int i6) {
        if (this.la != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i6);
            } catch (JSONException e6) {
                vl.j(e6);
            }
            this.la.j("reduceTime", jSONObject);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0027, code lost:
    
        if (r3 > 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
    
        if (r7 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0035, code lost:
    
        if (r6.az.get() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0039, code lost:
    
        if (r7 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0041, code lost:
    
        if (r7 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int up(int r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 2
            if (r7 != r1) goto L6
            r7 = 1
            goto L7
        L6:
            r7 = 0
        L7:
            com.bytedance.sdk.openadsdk.core.component.reward.r.j r2 = r6.f28064n
            boolean r2 = r2.q()
            com.bytedance.sdk.openadsdk.core.tj.n r3 = r6.up
            int r3 = r3.tz()
            r4 = 3
            r5 = 4
            switch(r3) {
                case 1: goto L37;
                case 2: goto L18;
                case 3: goto L41;
                case 4: goto L3c;
                case 5: goto L3c;
                case 6: goto L39;
                case 7: goto L2d;
                case 8: goto L1a;
                case 9: goto L1a;
                default: goto L18;
            }
        L18:
            r5 = 2
            goto L44
        L1a:
            boolean r3 = r6.wf()
            if (r3 == 0) goto L2a
            int r3 = r6.ln()
            if (r7 == 0) goto L27
            goto L37
        L27:
            if (r3 <= 0) goto L44
            goto L18
        L2a:
            if (r7 == 0) goto L18
            goto L37
        L2d:
            if (r7 == 0) goto L18
            java.util.concurrent.atomic.AtomicBoolean r3 = r6.az
            boolean r3 = r3.get()
            if (r3 == 0) goto L18
        L37:
            r5 = 1
            goto L44
        L39:
            if (r7 == 0) goto L44
            goto L37
        L3c:
            if (r7 == 0) goto L3f
            goto L37
        L3f:
            r5 = 3
            goto L44
        L41:
            if (r7 == 0) goto L18
            goto L37
        L44:
            if (r5 != r1) goto L49
            if (r2 != 0) goto L49
            r5 = 1
        L49:
            com.bytedance.sdk.openadsdk.core.component.reward.r.j r1 = r6.f28064n
            boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.core.component.reward.r.m
            if (r1 == 0) goto L5b
            com.bytedance.sdk.openadsdk.core.tj.n r1 = r6.up
            boolean r1 = com.bytedance.sdk.openadsdk.l.oq.j(r1)
            if (r1 == 0) goto L5b
            if (r7 == 0) goto L5a
            return r0
        L5a:
            return r4
        L5b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.up(int):int");
    }

    public void ae(int i6) {
        this.f28065p.j(i6);
    }

    protected boolean j(long j6, boolean z5) {
        if (!this.ed.v()) {
            return false;
        }
        if (!z5 || !this.ed.x()) {
            qa();
        }
        boolean j7 = this.ed.j(j6, this.f28069v, this.f28064n.v());
        if (j7 && !z5) {
            if (tj.ae(this.up)) {
                return true;
            }
            xt(true, true);
        }
        return j7;
    }

    public void g(int i6) {
        com.bytedance.sdk.openadsdk.core.video.xt.xt rn;
        com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar = this.f28064n;
        if (!(jVar instanceof g) || (rn = jVar.rn()) == null) {
            return;
        }
        if (rn.qv() == 1 && i6 == 1 && this.ki.getAndSet(false)) {
            int tl = ed.tl(v.getContext());
            float m6 = ed.m(v.getContext());
            float ae = ed.ae(v.getContext());
            Map<String, Object> nd = nd();
            nd.putAll(rn.ae());
            com.bytedance.sdk.openadsdk.core.jy.cw.j(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, this.up, new oq.j().m(-1.0f).up(-1.0f).r(-1.0f).cw(-1.0f).xt(-1L).j(-1L).cw(-1).r(-1).up(-1024).xt(com.bytedance.sdk.openadsdk.core.oq.i().cw() ? 1 : 2).j(tl).j(m6).xt(ae).j(), this.f28060j, true, nd, -1, false);
        }
    }

    public void xt(String str) {
        com.bytedance.sdk.openadsdk.core.rn s5 = this.wq.s();
        if (s5 != null && !isFinishing()) {
            try {
                s5.xt(str, (JSONObject) null);
                return;
            } catch (Exception e6) {
                j();
                vl.j(e6);
                return;
            }
        }
        j();
    }

    public void j(final com.bytedance.sdk.openadsdk.core.xt.j.cw.cw cwVar) {
        cwVar.j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.j
            public boolean j() {
                cwVar.j(TTBaseVideoActivity.this.ae());
                cwVar.j(TTBaseVideoActivity.this.f28060j);
                cwVar.j(TTBaseVideoActivity.this.ln);
                return TTBaseVideoActivity.this.ry.get();
            }
        });
    }

    protected void m(int i6) {
        int up = up(i6);
        if (i6 != 2) {
            if (this.f28054c.r()) {
                return;
            }
            if (this.ed.vl()) {
                this.ed.oq();
                return;
            }
            if (e.i(this.up)) {
                if (this.jy.get() && !this.ws.get()) {
                    if (up == 1 && !this.f28063m.containsKey(0) && ch()) {
                        this.rn.xt((this.up.jl() == 3 && e.w(this.up)) ? "奖励就快来了\n去详情页看看也累计时长哦～" : "奖励还在路上狂奔\n再等一下下哦～");
                    }
                    this.ed.nd();
                }
                if (!this.jy.get() && this.ws.get() && (!wf() || i6 == 3)) {
                    return;
                }
                if (up == 1 && (!this.jy.get() || !this.ws.get())) {
                    return;
                }
            }
        }
        if (up == 1) {
            j();
            return;
        }
        if (up == 2) {
            if (this.f28057g.get()) {
                this.wq.tj();
            }
            r();
        } else if (up == 3) {
            this.ed.nd();
        } else if (up == 4 && i6 != 3) {
            av();
        }
    }

    public void j(String str) {
        this.wq.j(str);
    }

    public boolean j(final com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        if (!ch() || !v.xt().ae(String.valueOf(this.rh)) || this.f28063m.containsKey(0) || isFinishing()) {
            return false;
        }
        if (System.currentTimeMillis() - this.im < 1000) {
            return true;
        }
        this.im = System.currentTimeMillis();
        xt.j j6 = this.f28064n.j(new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j();
                }
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.gx.j("reward_retain_dialog_cancel", tTBaseVideoActivity.xp.j(), TTBaseVideoActivity.this.xp.xt());
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
                TTBaseVideoActivity.this.az.set(true);
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.xt();
                }
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.gx.j("reward_retain_dialog_skip", tTBaseVideoActivity.xp.j(), TTBaseVideoActivity.this.xp.xt());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j(int i6) {
                TTBaseVideoActivity.this.j(i6, true);
                TTBaseVideoActivity.this.rn.xt("恭喜您，可提前" + i6 + "s获得奖励～");
            }
        });
        this.xp = j6;
        this.gx.j("reward_retain_dialog_show", j6.j(), this.xp.xt());
        return this.xp.cw();
    }

    public void xt(int i6) {
        if (i6 <= 0) {
            this.rn.j(false, null, null, true, true);
        } else {
            this.xt.sendEmptyMessageDelayed(600, i6);
        }
    }

    public void ol() {
    }

    protected void xt(boolean z5) {
        Message message = new Message();
        message.what = 400;
        this.xt.sendMessageDelayed(message, z5 ? 2000L : 0L);
    }

    public void xt(boolean z5, boolean z6) {
        Integer valueOf;
        int i6 = 1;
        if (z5) {
            Map<String, Object> ae = ae();
            this.ry.set(true);
            try {
                String ej = this.up.ej();
                Integer remove = com.bytedance.sdk.openadsdk.core.tl.r.up.remove(ej);
                if (remove == null) {
                    valueOf = 1;
                } else {
                    valueOf = Integer.valueOf(remove.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.tl.r.up.put(ej, valueOf);
                ae.put("meta_show_count", valueOf);
                String oq = uf.oq(this.up);
                Integer remove2 = com.bytedance.sdk.openadsdk.core.tl.r.f30513m.remove(oq);
                if (remove2 != null) {
                    i6 = Integer.valueOf(remove2.intValue() + 1);
                }
                com.bytedance.sdk.openadsdk.core.tl.r.f30513m.put(oq, i6);
                ae.put("meta_origin_show_count", i6);
            } catch (Throwable unused) {
            }
            ae.put("cache_strategy", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(ch())));
            ae.put("is_adm", Boolean.valueOf(this.f28052a));
            ae.put("is_play_again", Boolean.valueOf(a()));
            ae.put("if_cache_callback", Integer.valueOf(this.f28062l == 1 ? 1 : 0));
            ae.put("src_req_id", this.up.hk());
            ae.put("is_map", Boolean.valueOf(this.up.ay()));
            ae.put("is_repeat", Boolean.valueOf(this.kt.getAndSet(true)));
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, this.f28060j, ae, this.ln);
            com.bytedance.sdk.openadsdk.core.a.j.j().r();
            rn.j(this.up.ae());
        }
        if (z6) {
            if (!la.xt(ch(), this.up, true)) {
                boolean rs = v.xt().rs();
                if (this.mi.getAndSet(true) && !rs) {
                    ws.j().cw(this.up, "stats_callback_repeat");
                } else {
                    r("onAdShow");
                }
            }
            if (this.f28064n.m()) {
                this.la.ae();
            }
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.r rVar = this.qb;
            if (rVar != null && rVar.j() != null) {
                this.qb.j().r();
            }
            if (this.up.up() && this.up.m111if() != null) {
                com.bytedance.sdk.openadsdk.ae.j.j().j(StubApp.getOrigApplicationContext(getApplicationContext()), this.up.m111if().xt());
            }
        }
        cw(false);
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = message.what;
        if (i6 == 300) {
            oq();
            return;
        }
        if (i6 == 400) {
            this.ed.g();
            if (this.f28064n.m()) {
                this.la.j(true);
            }
            j(false, true);
            return;
        }
        if (i6 == 500) {
            this.wq.ae();
            this.ed.tl();
            this.f28058h.cw(false);
            this.la.cw(false);
            this.la.r();
            return;
        }
        if (i6 == 600) {
            this.rn.j(false, null, null, true, true);
            return;
        }
        if (i6 == 700) {
            this.wq.la();
            return;
        }
        if (i6 == 1200) {
            if (e.i(this.up)) {
                return;
            }
            if (this.wq.p()) {
                j(1, false);
                this.f28054c.j(ed(), this.f28064n.uf());
                cw(0);
            }
            this.xt.sendEmptyMessageDelayed(AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, 1000L);
            return;
        }
        if (i6 != 1300) {
            return;
        }
        this.xt.sendEmptyMessageDelayed(1300, 1000L);
        if (v()) {
            return;
        }
        this.f28066q++;
        if (!qb()) {
            this.f28055e++;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r rVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r();
        if (la.xt(ch()) > 0) {
            int up = la.up(this.up) / 1000;
            int xt = la.xt(ch());
            if (up < xt) {
                xt = up;
            }
            if (up - xt <= this.f28066q) {
                rVar.f28114j = true;
                rVar.xt = xt;
            }
        }
        j(2, rVar);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r rVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r();
        rVar2.f28114j = true;
        j(3, rVar2);
        this.f28061k.ae();
    }

    private void cw(final com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        final boolean[] zArr = {false};
        com.bytedance.sdk.openadsdk.oq.j.xt.j(new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.oq.j.xt.j
            public void j() {
                zArr[0] = true;
                oqVar.xt();
            }

            @Override // com.bytedance.sdk.openadsdk.oq.j.xt.j
            public void j(int i6) {
                zArr[0] = true;
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this.nd;
                if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
                    TTBaseVideoActivity.this.nd.getIntent().putExtra("remainTime", i6);
                }
                if (i6 <= 0 || !TTBaseVideoActivity.this.j(oqVar)) {
                    oqVar.xt();
                }
            }
        });
        xt("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.6
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (zArr[0]) {
                    return;
                }
                TTBaseVideoActivity.this.j();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j6) {
            }
        }.start();
    }

    public void cw(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.f28073z == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(this.nd, this.up.gs(), this.f28060j, true);
            this.f28073z = jVar;
            com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.nd, this.up, jVar);
            this.f28073z.j(new j.InterfaceC0455j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                public void j() {
                    TTBaseVideoActivity.this.gx();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                public void j(int i6, String str2, boolean z5) {
                    TTBaseVideoActivity.this.xt.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.n();
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                public void xt() {
                    TTBaseVideoActivity.this.n();
                }
            });
        }
        this.f28073z.j(str);
        this.f28073z.j();
    }

    public boolean xt(long j6, boolean z5) {
        this.ed.j(this.f28053b);
        this.ed.j(this.f28064n.w(), this.f28060j, ch());
        this.ed.xt(ae());
        if (this.f28064n.m()) {
            this.la.j(this.ed.c());
        }
        this.ed.j(this.sm);
        boolean j7 = j(j6, z5);
        if (j7 && !z5) {
            this.hl = (int) (System.currentTimeMillis() / 1000);
        }
        return j7;
    }

    public void j(long j6) {
        Message obtain = Message.obtain();
        obtain.what = 700;
        this.xt.sendMessageDelayed(obtain, j6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.tl.xt
    public void j(boolean z5) {
        if (z5) {
            if (this.la.m()) {
                return;
            }
            this.f28064n.r(true);
            return;
        }
        if (this.la.m() && this.ed.uf() != null) {
            this.ed.uf().j(8);
        }
        this.f28064n.r(false);
        if (this.la.m() || this.pz == 2 || !com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.up)) {
            return;
        }
        this.f28058h.m(8);
    }

    protected void xt(Bundle bundle) {
        if (bundle != null) {
            this.ol = bundle.getString("multi_process_key");
            this.ch = bundle.getBoolean("is_preload");
            this.f28068s = bundle.getLong("object_create_ts");
            this.f28052a = bundle.getBoolean("is_adm");
            this.f28062l = bundle.getInt("key_video_cache_callback", -1);
            this.hh = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.ln = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.f28069v = bundle.getBoolean("is_mute");
            long j6 = bundle.getLong("video_current");
            if (j6 > 0) {
                this.ed.j(j6);
            }
        }
    }

    protected void j(boolean z5, boolean z6) {
        this.ed.xt(z6);
        vl();
        if (z5) {
            this.av.set(true);
            if (e.i(this.up)) {
                this.f28064n.l();
            }
            this.rn.j(false, null, null, true, true);
            r();
            return;
        }
        if (e.tj(this.up)) {
            this.wq.ed();
        } else {
            this.rn.j(false, null, null, true, true);
            r(0);
        }
        if (this.ed.n()) {
            return;
        }
        if (e.i(this.up)) {
            this.f28064n.l();
        }
        r();
    }

    protected void xt(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("insert_ad_bundle"))) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw cwVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw(intent.getStringExtra("insert_ad_bundle"));
        this.ol = cwVar.j();
        this.f28066q = cwVar.oq();
        this.zz = cwVar.qv();
        this.vl.set(cwVar.r());
        this.f28063m.putAll(cwVar.tl());
        this.f28061k.j(cwVar);
        this.f28069v = cwVar.up();
        this.ff.cw(cwVar.m());
    }

    public void j(int i6, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.r rVar) {
        if (tj.cw(this.up) || this.az.get() || this.qv.get()) {
            return;
        }
        int i7 = 0;
        if (i6 == 1) {
            if (!this.f28059i.get()) {
                return;
            }
            if (rVar == null || !rVar.f28114j) {
                this.f28059i.set(false);
            }
        }
        int j6 = this.f28061k.j(i6, rVar != null && rVar.f28115r);
        if (j6 == 0) {
            return;
        }
        if (j6 == 3 && rVar != null && rVar.cw) {
            i7 = la.oq();
        }
        this.f28061k.j(new cw.j().j(this.ol).j(this.f28064n.uf()).xt(i7).j(this.vl.get()).j(this.f28063m.keySet()).xt(this.f28069v).j(this.ff).cw(j6).r(this.f28066q).cw(this.f28061k.r() ? this.zz : n.xt(this.up)).j(), j6, rVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.tl.xt
    public void j(int i6) {
        this.tj.set(true);
        if (System.currentTimeMillis() - this.f28072y > 50) {
            this.f28072y = System.currentTimeMillis();
            r("onAdVideoBarClick");
        }
        if (!isFinishing()) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.tl.j(this.la.vl());
        }
        if (!this.tl.get()) {
            this.tl.set(true);
        }
        if (!this.f28061k.j(1)) {
            this.f28059i.set(true);
        }
        cw(0);
        g(i6);
    }

    protected void j(Intent intent) {
        if (intent != null) {
            this.hh = intent.getStringExtra("rit_scene");
            this.ch = intent.getBooleanExtra("is_preload", false);
            this.f28068s = intent.getLongExtra("object_create_ts", 0L);
            this.f28052a = intent.getBooleanExtra("is_adm", false);
            this.ol = intent.getStringExtra("multi_process_key");
            this.f28062l = intent.getIntExtra("key_video_cache_callback", -1);
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.ln = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
        }
    }

    public void j(int i6, boolean z5) {
        qv(i6);
        if (z5) {
            oq(i6);
        }
    }

    public void j(float f6, float f7, float f8, float f9, int i6) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.la;
        if (upVar == null || upVar.j() == null) {
            return;
        }
        int measuredWidth = this.la.j().getMeasuredWidth();
        int measuredHeight = this.la.j().getMeasuredHeight();
        if (this.ed.c() instanceof com.bytedance.sdk.openadsdk.core.video.xt.j ? ((com.bytedance.sdk.openadsdk.core.video.xt.j) this.ed.c()).q() : false) {
            this.la.j().animate().translationY(-(measuredHeight * (1.0f - f7))).setDuration(i6).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f6, 1.0f, f7, measuredWidth * f8, measuredHeight * f9);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i6);
        this.la.j().startAnimation(scaleAnimation);
    }

    public void j(n nVar, com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        this.wq.j(nVar, xtVar);
        this.f28054c.j(nVar);
    }

    public void j(int i6, int i7) {
        this.f28061k.j(i6, i7, 0);
    }

    public void j(int i6, int i7, int i8) {
        this.f28061k.j(i6, i7, i8);
    }
}
