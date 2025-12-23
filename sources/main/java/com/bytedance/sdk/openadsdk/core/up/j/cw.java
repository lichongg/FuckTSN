package com.bytedance.sdk.openadsdk.core.up.j;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.component.reward.j.j.j;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jy.j;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.nativeexpress.av;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.aq;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.kt;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.la;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import com.bytedance.sdk.openadsdk.core.tj.z;
import com.bytedance.sdk.openadsdk.core.up.r.r;
import com.bytedance.sdk.openadsdk.core.up.up.up;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq.j.m;
import com.umeng.analytics.pro.d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements xt {

    /* renamed from: j, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.up.up.xt f30861j;

    protected boolean j() {
        return true;
    }

    public cw(com.bytedance.sdk.openadsdk.core.up.up.xt xtVar) {
        this.f30861j = xtVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xt(String str, n nVar) {
        int i6;
        if (!v.xt().xt(str) || nVar == null) {
            return false;
        }
        int i7 = 8;
        if (j()) {
            i6 = 7;
        } else {
            i6 = 8;
        }
        n xt = com.bytedance.sdk.openadsdk.core.component.reward.j.j.xt.j().xt(j(), str);
        if (xt == null) {
            return false;
        }
        if (xt.c() + xt.ch() < System.currentTimeMillis()) {
            r.j(i6).j(str);
            return true;
        }
        if (!TextUtils.equals(xt.wq(), nVar.wq())) {
            if (j()) {
                i7 = 7;
            }
            if (com.bytedance.sdk.openadsdk.core.j.j(nVar, i7) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(nVar.rn());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.get(next);
                xt.ot().put(next, jSONObject.get(next));
            }
            xt.tj(xt.ot().toString());
        } catch (Exception e6) {
            vl.j(e6);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.j.xt
    public boolean j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, n nVar) {
        if (!com.bytedance.sdk.openadsdk.core.up.j.j(xtVar, nVar, j())) {
            return false;
        }
        j(xtVar, nVar, j());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.j.xt
    public com.bytedance.sdk.openadsdk.core.up.up.cw j(final n nVar, final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final up upVar, Bundle bundle) {
        final com.bytedance.sdk.openadsdk.core.component.reward.cw cwVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw(v.getContext(), nVar, xtVar);
        final boolean z5 = bundle.getBoolean("is_cache", false);
        final boolean z6 = bundle.getBoolean("is_playAgain", false);
        final long j6 = bundle.getLong(d.f41197p);
        cwVar.j(z5);
        cwVar.cw(z5 ? 101 : 102);
        if (nVar.xj() <= 0) {
            cwVar.j(System.currentTimeMillis() + 10500000);
        } else {
            cwVar.j(nVar.xj() * 1000);
        }
        if (!com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar) && !tj.cw(nVar) && !z.j(nVar) && z5) {
            cwVar.m();
        }
        return new com.bytedance.sdk.openadsdk.core.up.up.cw() { // from class: com.bytedance.sdk.openadsdk.core.up.j.cw.1

            /* renamed from: g, reason: collision with root package name */
            private final AtomicBoolean f30862g = new AtomicBoolean(false);

            @Override // com.bytedance.sdk.openadsdk.core.up.up.cw
            public void cw() {
                if (this.f30862g.compareAndSet(false, true)) {
                    if (z5) {
                        com.bytedance.sdk.openadsdk.core.up.up.xt xtVar2 = cw.this.f30861j;
                        if (xtVar2 != null) {
                            xtVar2.j().cw(xtVar, nVar);
                            return;
                        }
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.up.up.xt xtVar3 = cw.this.f30861j;
                    if (xtVar3 != null) {
                        xtVar3.j().xt(xtVar, nVar);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.up.up.cw
            public void j() {
                com.bytedance.sdk.openadsdk.core.up.up.xt xtVar2 = cw.this.f30861j;
                if (xtVar2 != null) {
                    xtVar2.j().j(xtVar, nVar, cwVar, z5);
                }
                up upVar2 = upVar;
                if (upVar2 != null) {
                    upVar2.j(cwVar);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_play_again", z6);
                    jSONObject.put("is_from_cache", z5);
                    jSONObject.put("is_adm", !TextUtils.isEmpty(xtVar.tj()));
                    jSONObject.put("cache_strategy", com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(cw.this.j()));
                    jSONObject.put("src_req_id", nVar.hk());
                    jSONObject.put("is_map", nVar.ay());
                    jSONObject.put("load_duration", System.currentTimeMillis() - j6);
                } catch (JSONException unused) {
                }
                ws.j().j(nVar, "stats_reward_full_ad_loaded", jSONObject);
                cw.this.j(this, nVar, xtVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.up.up.cw
            public void xt() {
                if (j6 != 0) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.xt(nVar, uf.xt(xtVar.kt()), j6);
                }
                cwVar.r(1);
                up upVar2 = upVar;
                if (upVar2 != null) {
                    upVar2.xt(cwVar);
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.j.xt
    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
        if (xtVar != null) {
            j(xtVar.r(), i6, str, xtVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.j.xt
    public com.bytedance.sdk.openadsdk.core.up.up.cw j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar, nd ndVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar2, up upVar) {
        if (jVar.xt() != null && !jVar.xt().isEmpty()) {
            Bundle bundle = ndVar == null ? null : ndVar.az;
            boolean z5 = bundle != null && bundle.getBoolean("is_preload", false);
            boolean z6 = bundle != null && bundle.getBoolean("is_playAgain", false);
            long j6 = bundle != null ? bundle.getLong(d.f41197p, 0L) : 0L;
            jVar.xt().size();
            n nVar = jVar.xt().get(0);
            if (xt(xtVar2.r(), nVar)) {
                return null;
            }
            if (nVar.sj() && !j(jVar, xtVar2)) {
                j(jVar);
                if (z5) {
                    com.bytedance.sdk.openadsdk.core.up.up.xt xtVar3 = this.f30861j;
                    if (xtVar3 != null) {
                        xtVar3.j().j(xtVar2, nVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cache_strategy", com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(j()));
                        jSONObject.put("src_req_id", nVar.hk());
                        jSONObject.put("is_map", nVar.ay());
                    } catch (Exception unused) {
                    }
                    ws.j().j(nVar, "stats_reward_full_preload", jSONObject);
                    return null;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putLong(d.f41197p, j6);
                bundle2.putBoolean("is_playAgain", z6);
                bundle2.putBoolean("is_cache", false);
                return j(nVar, xtVar2, upVar, bundle2);
            }
            if (upVar != null) {
                upVar.j(-4, g.j(-4));
            }
            j(xtVar2.r(), -4, g.j(-4), xtVar);
            return null;
        }
        if (upVar != null) {
            upVar.j(-3, g.j(-3));
        }
        j(xtVar2.r(), -3, g.j(-3), xtVar);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, int i6, String str2, com.bytedance.sdk.openadsdk.core.tj.xt xtVar) {
        xtVar.j(i6);
        xtVar.xt(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cache_strategy", com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(j()));
            jSONObject.put("app_id", oq.i().f());
            jSONObject.put("rit", str);
        } catch (Exception unused) {
        }
        xtVar.j(jSONObject);
        com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar);
    }

    protected void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, n nVar, boolean z5) {
        if (nVar == null) {
            return;
        }
        new j.C0460j().up(nVar.fs()).j(z5 ? "rewarded_video" : "fullscreen_interstitial_ad").r(nVar.os()).xt("get_preload_ad").j(new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.up.j.cw.2
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (xtVar.v() != null) {
                    int j6 = m.j(xtVar.v());
                    if (j6 == 1) {
                        jSONObject2.put("req_type", 1);
                    } else if (j6 != 3) {
                        jSONObject2.put("req_type", -1);
                    } else {
                        jSONObject2.put("req_type", 3);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    protected void j(com.bytedance.sdk.openadsdk.core.up.up.cw cwVar, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        j(nVar, xtVar);
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            com.bytedance.sdk.openadsdk.core.video.cw.j.xt(nVar);
            cwVar.xt();
        } else {
            if (tj.cw(nVar)) {
                if (kt.j(nVar) && com.bytedance.sdk.openadsdk.l.oq.j(nVar)) {
                    j(xtVar, nVar, cwVar);
                }
                cwVar.xt();
                return;
            }
            j(xtVar, nVar, cwVar);
        }
    }

    protected void j(n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        aq m6;
        xtVar.r();
        j(xtVar.r(), nVar);
        if (com.bytedance.sdk.openadsdk.core.ugeno.oq.g(nVar) && !com.bytedance.sdk.openadsdk.core.ugeno.oq.qv(nVar) && (m6 = hh.m(nVar)) != null) {
            com.bytedance.sdk.openadsdk.core.ugeno.oq.j(m6.oq(), m6.g(), (av) null);
        }
        if (j()) {
            Iterator<qa> it = e.kt(nVar).iterator();
            while (it.hasNext()) {
                qa next = it.next();
                com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.j();
                jVar.j(next.r());
                jVar.xt(next.up());
                jVar.cw(next.r());
                com.bytedance.sdk.openadsdk.core.ugeno.oq.j(next.up(), next.r(), (av) null);
            }
            Iterator<qa> it2 = rh.up(nVar).iterator();
            while (it2.hasNext()) {
                qa next2 = it2.next();
                com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.m.j();
                jVar2.j(next2.r());
                jVar2.xt(next2.up());
                jVar2.cw(next2.r());
                com.bytedance.sdk.openadsdk.core.ugeno.oq.j(next2.up(), next2.r(), (av) null);
            }
        }
    }

    private void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final n nVar, final com.bytedance.sdk.openadsdk.core.up.up.cw cwVar) {
        if (ln.ws(nVar) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            com.bykv.vk.openvk.component.video.api.cw.r j6 = ln.j(1, nVar);
            j6.j("material_meta", nVar);
            j6.j("ad_slot", xtVar);
            com.bytedance.sdk.openadsdk.core.video.r.xt.j(j6, new com.bykv.vk.openvk.component.video.api.up.xt() { // from class: com.bytedance.sdk.openadsdk.core.up.j.cw.3
                @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
                public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar, int i6) {
                    vl.j("RewardAdStrategyCacher", "RewardFullLog: Cached ad onVideoPreloadSuccess");
                    com.bytedance.sdk.openadsdk.core.up.up.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.xt();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.up.j.InterfaceC0307j
                public void j(com.bykv.vk.openvk.component.video.api.cw.r rVar, int i6, String str) {
                    vl.j("RewardAdStrategyCacher", "RewardFullLog: Cached ad onVideoPreloadFail");
                    if (!ln.vl(nVar)) {
                        vl.j("RewardAdStrategyCacher", "RewardFullLog: Cached ad onVideoPreloadFail and block onCached");
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.up.up.cw cwVar2 = cwVar;
                    if (cwVar2 != null) {
                        cwVar2.xt();
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.j.j.j.j(j(), nVar, new j.InterfaceC0440j<Object>() { // from class: com.bytedance.sdk.openadsdk.core.up.j.cw.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.j.j.j.InterfaceC0440j
            public void j(boolean z5, Object obj) {
                com.bytedance.sdk.openadsdk.core.up.up.cw cwVar2 = cwVar;
                if (cwVar2 != null) {
                    cwVar2.xt();
                }
            }
        });
    }

    private void j(String str, n nVar) {
        try {
            h ig = nVar.ig();
            if (ig == null || TextUtils.isEmpty(ig.j())) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.v.cw cwVar = new com.bytedance.sdk.openadsdk.core.v.cw(true);
            cwVar.j(str);
            cwVar.j(8);
            cwVar.cw(nVar.fs());
            cwVar.r(nVar.os());
            cwVar.xt(uf.jy(nVar));
            com.bytedance.sdk.openadsdk.g.xt.j(ig).j(cwVar);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar) {
        if (jVar.xt().size() <= 1) {
            return;
        }
        List<n> subList = jVar.xt().subList(1, jVar.xt().size());
        JSONArray jSONArray = new JSONArray();
        for (n nVar : subList) {
            l ng = nVar.ng();
            if (ng != null) {
                ng.j(true);
            }
            jSONArray.put(nVar.tv());
        }
        if (jSONArray.length() > 0) {
            jVar.xt().get(0).uf(jSONArray.toString());
        }
    }

    protected boolean j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        List<n> xt;
        if (jVar != null && (xt = jVar.xt()) != null) {
            n nVar = xt.get(0);
            if (la.xt(j(), nVar, false) && la.r(nVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.j.xt
    public void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (v.xt().xt(xtVar.r())) {
            nd ndVar = new nd();
            ndVar.f30363j = 2;
            if (v.xt().oq(xtVar.r()) || xtVar.tl() > 0.0f) {
                ndVar.f30364m = 2;
            }
            v.j().xt(xtVar, ndVar, j() ? 7 : 8, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.up.j.cw.5
                @Override // com.bytedance.sdk.openadsdk.core.s.xt
                public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                    xtVar2.j(i6);
                    xtVar2.xt(str);
                    com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.s.xt
                public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar2) {
                    if (jVar.xt() == null || jVar.xt().isEmpty()) {
                        cw.this.j(xtVar.r(), -3, g.j(-3), xtVar2);
                        return;
                    }
                    n nVar = jVar.xt().get(0);
                    if (cw.this.xt(xtVar.r(), nVar)) {
                        return;
                    }
                    if (nVar.sj() && !cw.this.j(jVar, xtVar)) {
                        cw.this.j(jVar);
                        com.bytedance.sdk.openadsdk.core.up.up.xt xtVar3 = cw.this.f30861j;
                        if (xtVar3 != null) {
                            xtVar3.j().j(xtVar, nVar);
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("cache_strategy", com.bytedance.sdk.openadsdk.core.component.reward.j.r.j(cw.this.j()));
                            jSONObject.put("src_req_id", nVar.hk());
                            jSONObject.put("is_map", nVar.ay());
                        } catch (Exception unused) {
                        }
                        ws.j().j(nVar, "stats_reward_full_preload", jSONObject);
                        return;
                    }
                    cw.this.j(xtVar.r(), -4, g.j(-4), xtVar2);
                }
            });
        }
    }
}
