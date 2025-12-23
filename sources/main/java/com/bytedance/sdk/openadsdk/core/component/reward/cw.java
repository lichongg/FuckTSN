package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.j.up;
import com.bytedance.sdk.openadsdk.core.component.reward.r.r;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.qv.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.l;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.i.cw.xt.az;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationRewardManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.m;
import com.umeng.socialize.common.SocializeConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends az {
    private String av;
    private final com.bytedance.sdk.openadsdk.i.cw.cw.xt cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.a.j.xt.j.j f28153g;

    /* renamed from: i, reason: collision with root package name */
    private String f28154i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f28155j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private long f28156m;
    private boolean mi;
    private com.bytedance.sdk.openadsdk.a.j.xt.j.xt oq;
    private com.bytedance.sdk.openadsdk.core.qv.xt.j qv;

    /* renamed from: s, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw f28158s;
    private com.bytedance.sdk.openadsdk.a.j.xt.j.j tl;
    private String up;
    private String vl;

    /* renamed from: w, reason: collision with root package name */
    private boolean f28160w;
    private boolean ws;
    private final n xt;
    private final AtomicBoolean ae = new AtomicBoolean(false);
    private int az = 1;
    private int kt = 102;
    private int tj = -1;

    /* renamed from: f, reason: collision with root package name */
    private Double f28152f = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f28159v = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f28161x = false;
    private long ch = System.currentTimeMillis();

    /* renamed from: r, reason: collision with root package name */
    private boolean f28157r = false;

    public void r(int i6) {
        this.tj = i6;
    }

    private void g() {
        com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar = this.tl;
        if (jVar != null) {
            j.j(this.vl, jVar);
        }
        if (this.f28153g != null) {
            j.j(rh.j(this.vl), this.f28153g);
        }
        if (this.oq != null) {
            cw(true);
            j.j(rh.xt(this.vl), this.oq);
        }
    }

    public void ae() {
        if (this.xt == null || this.cw == null || this.ws || v.xt().mp() != 0) {
            return;
        }
        try {
            if (this.f28157r) {
                up.j().j(this.cw);
            }
        } catch (Throwable unused) {
        }
    }

    public void cw(int i6) {
        this.kt = i6;
    }

    public void j(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw cwVar) {
        this.f28158s = cwVar;
    }

    public void m() {
        if (this.ae.get()) {
            return;
        }
        this.f28157r = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public long r() {
        return this.f28156m;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public m up() {
        return new MediationRewardManagerDefault();
    }

    public void xt(int i6) {
        this.az = i6;
    }

    public cw(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        this.f28155j = context;
        this.xt = nVar;
        this.cw = xtVar;
        this.vl = nVar.hashCode() + nVar.ej() + hashCode();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public int cw() {
        n nVar = this.xt;
        if (nVar == null) {
            return -1;
        }
        if (tj.cw(nVar)) {
            return 2;
        }
        if (tj.r(this.xt)) {
            return 1;
        }
        return com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.xt) ? 3 : 0;
    }

    public void j(int i6) {
        this.jy = i6;
    }

    public void xt(String str) {
        this.f28154i = str;
    }

    public void j(String str) {
        this.av = str;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void xt(com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar) {
        if (this.ae.get()) {
            j.j(rh.j(this.vl), jVar);
        } else {
            this.f28153g = jVar;
        }
    }

    public void j(boolean z5) {
        this.mi = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(com.bytedance.sdk.openadsdk.a.j.xt.j.j jVar) {
        if (this.ae.get()) {
            j.j(this.vl, jVar);
        } else {
            this.tl = jVar;
        }
    }

    public void cw(String str) {
        this.vl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public Map<String, Object> xt() {
        n nVar = this.xt;
        if (nVar == null) {
            return null;
        }
        Map<String, Object> lg = nVar.lg();
        lg.put("expireTimestamp", Long.valueOf(r()));
        lg.put("materialMetaIsFromPreload", Boolean.valueOf(this.mi));
        lg.put("adSceneType", Integer.valueOf(r.j(this.xt)));
        return lg;
    }

    public void cw(boolean z5) {
        this.f28160w = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(com.bytedance.sdk.openadsdk.a.j.xt.j.xt xtVar) {
        if (this.ae.get()) {
            cw(true);
            j.j(rh.xt(this.vl), xtVar);
        } else {
            this.oq = xtVar;
        }
    }

    public void xt(boolean z5) {
        this.ws = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        this.qv = j.C0471j.j(cwVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
        this.f28152f = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public int j() {
        n nVar = this.xt;
        if (nVar == null) {
            return -1;
        }
        return nVar.jl();
    }

    public void j(long j6) {
        this.f28156m = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(Activity activity) {
        Intent intent;
        n nVar = this.xt;
        String os = nVar != null ? nVar.os() : "";
        n nVar2 = this.xt;
        new j.C0460j().up(nVar2 != null ? nVar2.fs() : "0").j("rewarded_video").xt("show_start").r(os).j((com.bytedance.sdk.openadsdk.m.j.j) null);
        if (activity != null && activity.isFinishing()) {
            vl.r("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.ae.get()) {
            return;
        }
        this.ae.set(true);
        n nVar3 = this.xt;
        if (nVar3 == null || ln.ws(nVar3) == null) {
            return;
        }
        if (j() == 4) {
            ae.j(new g("reward_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    tl.j(cw.this.f28155j, cw.this.xt, "rewarded_video", false).j(cw.this.qv);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.xt.j().j("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.f28155j : activity;
        if (context == null) {
            context = v.getContext();
        }
        g();
        if (this.xt.zw() == 2) {
            intent = new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(268435456);
        }
        if (this.ws) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.az);
        } else {
            this.jy = uf.g(this.xt);
        }
        intent.putExtra("source_rit_id", this.jy);
        intent.putExtra("custom_play_again", this.f28160w);
        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar = this.cw;
        if (xtVar != null) {
            intent.putExtra("media_extra", xtVar.jy());
            intent.putExtra(SocializeConstants.TENCENT_UID, this.cw.ws());
            intent.putExtra(MediationConstant.REWARD_NAME, this.cw.x());
            intent.putExtra(MediationConstant.REWARD_AMOUNT, this.cw.ch());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.cw.tj()));
        }
        if (this.ws && !TextUtils.isEmpty(this.av) && !TextUtils.isEmpty(this.f28154i)) {
            intent.putExtra("reward_again_name", this.av);
            intent.putExtra("reward_again_amount", this.f28154i);
        }
        intent.putExtra("is_preload", this.f28157r);
        intent.putExtra("object_create_ts", this.ch);
        Double d6 = this.f28152f;
        intent.putExtra("_client_bidding_aution_price", d6 != null ? String.valueOf(d6) : "");
        if (!TextUtils.isEmpty(this.up)) {
            intent.putExtra("rit_scene", this.up);
        }
        this.xt.tl(this.mi);
        this.xt.c(this.kt);
        int i6 = this.tj;
        if (i6 != -1) {
            intent.putExtra("key_video_cache_callback", i6);
        }
        uf.j(intent, this.xt);
        intent.putExtra("multi_process_key", this.vl);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw cwVar = this.f28158s;
        if (cwVar != null) {
            intent.putExtra("insert_ad_bundle", cwVar.g().toString());
        }
        j(context, intent);
        com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.xt).j(7);
    }

    private void j(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.xt.j(context, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.cw.2
            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j() {
            }

            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j(Throwable th) {
                vl.cw("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.cw == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt j6 = com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j();
        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar = this.cw;
        j6.j(xtVar, xtVar.r());
        if (rh.j(this.xt)) {
            com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j().xt(this.cw, rh.r(this.xt));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(true, this.ws).j(this.cw.r(), this.xt);
        ae();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.az
    public void j(Activity activity, Object obj, String str) {
        if (obj == null) {
            vl.r("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String j6 = com.bytedance.sdk.openadsdk.core.wq.j.up.j(obj);
        if ("customize_scenes".equalsIgnoreCase(j6)) {
            this.up = str;
        } else {
            this.up = j6;
        }
        j(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
        if (this.f28159v) {
            return;
        }
        l.j(this.xt, d6);
        this.f28159v = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
        if (this.f28161x) {
            return;
        }
        l.j(this.xt, d6, str, str2);
        this.f28161x = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        n nVar = this.xt;
        if (nVar != null) {
            x.j(nVar.uv(), xtVar, com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
        }
    }
}
