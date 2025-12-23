package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.xt;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.b;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.hl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.umeng.ccg.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends j {

    /* renamed from: c, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.xt.j f28353c;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.xt ed;
    protected boolean rn;
    private boolean uf;
    protected final AtomicBoolean wq;

    public static int xt(n nVar) {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected boolean sm() {
        return true;
    }

    private void aq() {
        com.bytedance.sdk.openadsdk.core.xt.up upVar;
        if (this.rn || (upVar = this.tl) == null) {
            return;
        }
        if (((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).xt().qv()) {
            this.rn = true;
            xt(8, 0);
            return;
        }
        if (hl.j(this.xt)) {
            int up = hl.up(this.xt);
            if (this.xt.zw() == 2) {
                xt(0, -1);
            }
            if (up != 3) {
                return;
            }
            long ae = hl.ae(this.xt) * 1000;
            if (this.kt.h() < ae) {
                xt(0, (int) ((ae - this.kt.h()) / 1000));
                return;
            }
            xt(8, 0);
            rr();
            this.rn = true;
        }
    }

    private JSONObject kc() {
        JSONObject jSONObject = new JSONObject();
        uf yv = this.xt.yv();
        if (yv != null) {
            String r5 = yv.r();
            if (!TextUtils.isEmpty(r5)) {
                try {
                    String optString = new JSONObject(r5).optString(JThirdPlatFormInterface.KEY_TOKEN);
                    jSONObject.put("req_id", yv.m());
                    jSONObject.put(JThirdPlatFormInterface.KEY_TOKEN, optString);
                    jSONObject.put(a.f41544t, "query_box");
                    return jSONObject;
                } catch (JSONException e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                    return jSONObject;
                }
            }
        }
        return jSONObject;
    }

    private void rr() {
        if (this.tl == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_auto_click", Boolean.TRUE);
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.tl.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
        this.tl.j(null, new com.bytedance.sdk.openadsdk.core.tj.qv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(boolean z5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z5);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.oq;
            if (upVar != null) {
                upVar.j("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private void up(int i6) {
        com.bytedance.sdk.openadsdk.core.xt.up upVar = this.tl;
        if (upVar != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(i6);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.up upVar2 = this.f28377x;
        if (upVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) upVar2.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(i6);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.m mVar = this.f28375v;
        if (mVar != null) {
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) mVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(i6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        return this.cw == 2 ? com.bytedance.sdk.openadsdk.res.up.ws(this.f28369j) : com.bytedance.sdk.openadsdk.res.up.az(this.f28369j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean h() {
        return this.wq.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean i() {
        if (this.uf) {
            return true;
        }
        return (com.bytedance.sdk.openadsdk.core.live.xt.j().xt(this.xt) || hl.cw(this.xt)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    public void zz() {
        if (hl.j(this.xt)) {
            uf yv = this.xt.yv();
            if (yv != null || com.bytedance.sdk.openadsdk.core.live.xt.j().xt(this.xt)) {
                int uf = uf();
                if (yv != null) {
                    yv.j(uf);
                }
                up(uf);
            }
        }
    }

    public ae(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
        this.rn = false;
        this.wq = new AtomicBoolean(false);
    }

    public static boolean j(n nVar) {
        return com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void av() {
        super.av();
        this.mi.xt(this.xt.xa());
        this.mi.up(true);
        this.f28366g.m(0);
        this.f28366g.up(0);
        this.f28366g.cw(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        if (q() && hh.j(this.xt) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        if (m()) {
            this.mi.xt(false);
            this.mi.up(false);
            this.f28366g.m(8);
            this.f28366g.up(8);
            this.f28366g.cw(8);
            return;
        }
        this.mi.xt(this.xt.xa());
        this.mi.up(true);
        this.f28366g.m(0);
        this.f28366g.up(0);
        this.f28366g.cw(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void kt() {
        super.kt();
        zz();
        if (!this.oq.m()) {
            if (com.bytedance.sdk.openadsdk.core.live.xt.j().xt(this.xt)) {
                aq();
                return;
            }
            if (hl.j(this.xt) && this.ed == null && !com.bytedance.sdk.openadsdk.core.xt.j().xt("is_reward_deep_link_to_live", false) && hl.up(this.xt) != 1 && this.kt.h() >= hl.ae(this.xt) * 1000) {
                this.wq.set(true);
                com.bytedance.sdk.openadsdk.core.component.reward.xt.m mVar = this.kt;
                if (mVar != null && mVar.xt()) {
                    this.f28369j.gx();
                }
                this.ed = new com.bytedance.sdk.openadsdk.core.component.reward.view.xt(this.f28369j, this.xt, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.ae.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.xt.j
                    public void j(Dialog dialog) {
                        ae.this.ed.dismiss();
                        ae.this.f28369j.n();
                        ae.this.wq.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.xt.j
                    public void xt(Dialog dialog) {
                        if (ae.this.f28353c != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("is_auto_click", Boolean.TRUE);
                            ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) ae.this.f28353c.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
                            ae.this.f28353c.j(null, new com.bytedance.sdk.openadsdk.core.tj.qv());
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.f28369j, this.xt, this.vl, 7) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.ae.3
                    @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
                    public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                        super.j(view, qvVar);
                        ae.this.ed.dismiss();
                    }
                };
                this.f28353c = jVar;
                this.f28369j.j((com.bytedance.sdk.openadsdk.core.xt.j.cw.cw) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.cw.class));
                this.ed.j(this.f28353c);
                if (!this.f28369j.isFinishing()) {
                    this.ed.show();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void xt(boolean z5) {
        super.xt(z5);
        if (!com.bytedance.sdk.openadsdk.core.xt.j().xt("is_reward_deep_link_to_live", false) || hl.cw(this.xt) || z5) {
            return;
        }
        v.j().j(kc(), new s.r() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.ae.1
            @Override // com.bytedance.sdk.openadsdk.core.s.r
            public void j(int i6, String str) {
                ae.this.tl(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.r
            public void j(a.cw cwVar) {
                b bVar = cwVar.cw;
                if (bVar == null) {
                    return;
                }
                boolean j6 = bVar.j();
                ae.this.tl(j6);
                if (j6) {
                    ae.this.f28369j.r(0);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.tl tlVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.tl(this.f28369j, this.xt, z5);
        this.f28366g = tlVar;
        return tlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(int i6, int i7, Intent intent) {
        super.j(i6, i7, intent);
        if (hl.cw(this.xt) || i6 != 1 || intent == null || intent.getExtras() == null || this.uf) {
            return;
        }
        long j6 = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int uf = (int) (uf() - j6);
        this.f28369j.j(uf, false);
        if (j6 <= 0) {
            tl(true);
            up(0);
            this.uf = true;
            return;
        }
        j(uf);
    }

    private void xt(int i6, int i7) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if (xtVar != null && (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.tl)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tl) xtVar).j(i6, i7);
        }
    }

    private void j(long j6) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j6);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.up upVar = this.oq;
            if (upVar == null || !upVar.m()) {
                return;
            }
            this.oq.j("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }
}
