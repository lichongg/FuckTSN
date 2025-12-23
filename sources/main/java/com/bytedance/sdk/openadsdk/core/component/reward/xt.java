package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.qv.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.l;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq.j.up;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.i.cw.xt.qv;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.mediation.MediationFullScreenManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j.r;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends qv {
    private final String ae;
    private com.bytedance.sdk.openadsdk.x.j.xt.j.j av;
    private com.bytedance.sdk.openadsdk.i.cw.cw.xt az;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.qv.xt.j f28492i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f28493j;

    /* renamed from: r, reason: collision with root package name */
    private String f28495r;
    private boolean tl;
    private long up;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw f28496w;
    private final n xt;

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f28494m = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private int f28491g = 102;
    private int oq = -1;
    private Double qv = null;
    private boolean vl = false;
    private boolean jy = false;
    private long ws = System.currentTimeMillis();
    private boolean cw = false;

    private void g() {
        com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar = this.av;
        if (jVar != null) {
            j.j(this.ae, jVar);
        }
    }

    public void ae() {
        if (this.xt == null || this.az == null || v.xt().mp() != 0) {
            return;
        }
        try {
            boolean z5 = this.cw;
            if (this.az == null || !z5) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.component.reward.j.j.j().j(this.az);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
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

    public void j(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw cwVar) {
        this.f28496w = cwVar;
    }

    public void m() {
        if (this.f28494m.get()) {
            return;
        }
        this.cw = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public long r() {
        return this.up;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public r up() {
        return new MediationFullScreenManagerDefault();
    }

    public void xt(int i6) {
        this.oq = i6;
    }

    public xt(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        this.f28493j = context;
        this.xt = nVar;
        this.az = xtVar;
        this.ae = nVar.hashCode() + nVar.ej() + hashCode();
    }

    public void j(boolean z5) {
        this.tl = z5;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public Map<String, Object> xt() {
        n nVar = this.xt;
        if (nVar == null) {
            return null;
        }
        Map<String, Object> lg = nVar.lg();
        lg.put("expireTimestamp", Long.valueOf(r()));
        lg.put("materialMetaIsFromPreload", Boolean.valueOf(this.tl));
        lg.put("adSceneType", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.r.r.j(this.xt)));
        return lg;
    }

    public void j(int i6) {
        this.f28491g = i6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(com.bytedance.sdk.openadsdk.x.j.xt.j.j jVar) {
        if (this.f28494m.get()) {
            j.j(this.ae, jVar);
        }
        this.av = jVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.cw cwVar) {
        this.f28492i = j.C0471j.j(cwVar);
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void xt(Double d6) {
        this.qv = d6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public int j() {
        n nVar = this.xt;
        if (nVar == null) {
            return -1;
        }
        return nVar.jl();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(Activity activity) {
        Intent intent;
        n nVar = this.xt;
        String os = nVar != null ? nVar.os() : "";
        n nVar2 = this.xt;
        new j.C0460j().up(nVar2 != null ? nVar2.fs() : "0").j("fullscreen_interstitial_ad").xt("show_start").r(os).j((com.bytedance.sdk.openadsdk.m.j.j) null);
        if (activity != null && activity.isFinishing()) {
            vl.r("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.f28494m.get()) {
            return;
        }
        this.f28494m.set(true);
        n nVar3 = this.xt;
        if (nVar3 != null) {
            if (ln.ws(nVar3) == null && this.xt.fp() == null) {
                return;
            }
            if (j() == 4) {
                ae.j(new g("full_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tl.j(xt.this.f28493j, xt.this.xt, "fullscreen_interstitial_ad", false).j(xt.this.f28492i);
                    }
                });
            }
            com.bytedance.sdk.openadsdk.core.xt.j().xt("full_video_show_time", System.currentTimeMillis());
            Context context = activity == null ? this.f28493j : activity;
            if (context == null) {
                context = v.getContext();
            }
            g();
            if (this.xt.zw() == 2) {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(268435456);
            }
            if (this.az != null) {
                intent.putExtra("is_adm", !TextUtils.isEmpty(r7.tj()));
            }
            intent.putExtra("is_preload", this.cw);
            intent.putExtra("object_create_ts", this.ws);
            Double d6 = this.qv;
            intent.putExtra("_client_bidding_aution_price", d6 != null ? String.valueOf(d6) : "");
            if (!TextUtils.isEmpty(this.f28495r)) {
                intent.putExtra("rit_scene", this.f28495r);
            }
            this.xt.tl(this.tl);
            this.xt.c(this.f28491g);
            int i6 = this.oq;
            if (i6 != -1) {
                intent.putExtra("key_video_cache_callback", i6);
            }
            uf.j(intent, this.xt);
            intent.putExtra("multi_process_key", this.ae);
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.cw cwVar = this.f28496w;
            if (cwVar != null) {
                intent.putExtra("insert_ad_bundle", cwVar.g().toString());
            }
            j(context, intent);
            com.bytedance.sdk.openadsdk.core.ae.r.j().j(this.xt).j(8);
        }
    }

    private void j(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.xt.j(context, intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xt.2
            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j() {
            }

            @Override // com.bytedance.sdk.component.utils.xt.j
            public void j(Throwable th) {
                vl.cw("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        if (this.az == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt j6 = com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j();
        com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar = this.az;
        j6.j(xtVar, xtVar.r());
        com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(false, false).j(this.az.r(), this.xt);
        ae();
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.qv
    public void j(Activity activity, Object obj, String str) {
        if (obj == null) {
            vl.r("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String j6 = up.j(obj);
        if ("customize_scenes".equalsIgnoreCase(j6)) {
            this.f28495r = str;
        } else {
            this.f28495r = j6;
        }
        j(activity);
    }

    public void j(long j6) {
        this.up = j6;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6) {
        if (this.vl) {
            return;
        }
        l.j(this.xt, d6);
        this.vl = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(Double d6, String str, String str2) {
        if (this.jy) {
            return;
        }
        l.j(this.xt, d6, str, str2);
        this.jy = true;
    }

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.tl
    public void j(com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar) {
        n nVar = this.xt;
        if (nVar != null) {
            x.j(nVar.uv(), xtVar, com.bytedance.sdk.openadsdk.i.cw.j.xt.class);
        }
    }
}
