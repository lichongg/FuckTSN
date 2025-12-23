package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.cw;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends com.bytedance.sdk.openadsdk.core.component.reward.r.j {

    /* renamed from: c, reason: collision with root package name */
    private int f28356c;
    private int ed;
    private int gx;

    /* renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f28357n;
    private final AtomicBoolean nd;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.up rh;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.draw.xt> rn;
    private int uf;
    private int wq;

    public interface j {
        Map<String, Object> cw();

        void j();

        void j(int i6);

        void r();

        void xt();
    }

    public static int xt(n nVar) {
        return 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean e() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        return true;
    }

    private void kc() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar = this.rh;
        if (upVar == null || !upVar.ed()) {
            int r5 = this.rn.get(this.ed).r();
            if (r5 > 0) {
                this.wq += r5;
            }
            if (z.cw(this.xt) <= this.uf && !this.f28357n.get()) {
                this.f28369j.r(0);
                this.f28369j.qv();
                this.f28357n.set(true);
            }
            int i6 = this.uf;
            if (i6 < this.wq) {
                this.uf = i6 + 1;
            }
        }
    }

    private void rr() {
        if (this.gq.cw() <= z.tl(this.xt) || this.nd.get() || zz() == null) {
            return;
        }
        zz().up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st() {
        com.bykv.vk.openvk.component.video.api.cw.r rVar;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar = this.rh;
        n nVar = null;
        com.bykv.vk.openvk.component.video.api.r.cw uf = upVar != null ? upVar.uf() : null;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xt xtVar = this.rn.get(this.ed);
        if (xtVar != null) {
            nVar = xtVar.j();
            rVar = xtVar.qv();
        } else {
            rVar = null;
        }
        this.kt.j(nVar, uf, rVar);
        this.kt.xt(this.f28369j.ae());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.r zz() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.r) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.r) xtVar;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ae(boolean z5) {
        return z5 ? ed() : z.ae(this.xt) - this.uf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ed() {
        return z.cw(this.xt) - this.uf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void f() {
        if (this.tj.rn()) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.up) zz().xt().cw(this.f28356c);
            if (upVar != null) {
                upVar.l();
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw("cubic  resume exception:" + e6.getMessage());
        }
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.mi.j(true);
        this.mi.xt(this.xt.xa());
        this.mi.cw(true);
        this.mi.up(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        return com.bytedance.sdk.openadsdk.res.up.g(this.f28369j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int gx() {
        return this.uf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean q() {
        return this.xt.tz() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tl() {
        super.tl();
        this.rn.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.xt(this.f28369j, this.xt, this.vl, q(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.xt.kg());
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                this.rn.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.xt(this.f28369j, com.bytedance.sdk.openadsdk.core.j.j(jSONArray.getJSONObject(i6)), this.vl, q(), false));
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.xt> it = this.rn.iterator();
        while (it.hasNext()) {
            it.next().j(this.jy);
        }
    }

    public cw(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
        this.rn = new ArrayList();
        this.wq = 0;
        this.uf = 0;
        this.ed = 0;
        this.f28356c = 0;
        this.gx = 0;
        this.f28357n = new AtomicBoolean(false);
        this.nd = new AtomicBoolean(false);
    }

    private void aq() {
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        if (Math.max(0, this.gq.up() - ch()) == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        int r5 = z.r(this.xt);
        int up = z.up(this.xt);
        int m6 = m(false);
        String str2 = "领取成功";
        if (r5 == 0) {
            if (m6 > 0) {
                str2 = m6 + "s后可领取奖励";
            }
            z6 = true;
        } else {
            if (m6 > 0) {
                str2 = m6 + "s";
            }
            z6 = false;
        }
        xt(m(true));
        if (z5 && up == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z5 && up == 1) {
            str = "跳过";
        } else {
            str = null;
        }
        this.mi.j(z6, str2, str, z7, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void az() {
        super.az();
        List<com.bytedance.sdk.openadsdk.core.component.reward.draw.xt> list = this.rn;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.xt> it = list.iterator();
            while (it.hasNext()) {
                it.next().g();
            }
        }
        if (zz() != null) {
            zz().cw().r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j, com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void cw() {
        this.f28366g.cw(true);
        if (zz() != null) {
            zz().cw().j(this.rn);
            zz().r().j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.cw.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.cw.j
                public void j() {
                    cw.this.ed = 0;
                    j((com.bytedance.sdk.openadsdk.core.component.reward.draw.up) cw.this.zz().xt().cw(0));
                    cw.this.st();
                    if (cw.this.rn.size() > 0) {
                        ((com.bytedance.sdk.openadsdk.core.component.reward.draw.xt) cw.this.rn.get(1)).ae();
                    }
                    cw.this.f28369j.xt(false, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.cw.j
                public void j(boolean z5, int i6, boolean z6) {
                    int i7 = cw.this.f28356c;
                    if (cw.this.rh != null) {
                        cw.this.f28369j.b().j(z5, i7 + 1, cw.this.rh.la());
                    }
                    cw.this.f28356c = i6;
                    cw cwVar = cw.this;
                    cwVar.gx = Math.max(cwVar.gx, i6 + 1);
                    cw cwVar2 = cw.this;
                    cwVar2.ed = i6 % cwVar2.rn.size();
                    j((com.bytedance.sdk.openadsdk.core.component.reward.draw.up) cw.this.zz().xt().cw(i6));
                    cw.this.zz().m();
                    cw.this.nd.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.cw.j
                public void j(boolean z5, int i6) {
                    com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.up) cw.this.zz().xt().cw(i6);
                    if (upVar != null) {
                        upVar.xt(false);
                    }
                }

                private void j(com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar) {
                    if (upVar != null) {
                        cw.this.rh = upVar;
                        cw.this.rh.xt(true);
                        cw.this.rh.j(new j() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.cw.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.cw.j
                            public void j() {
                                cw cwVar = cw.this;
                                cwVar.f28368i = true;
                                cwVar.zz().j(false);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.cw.j
                            public Map<String, Object> cw() {
                                return cw.this.f28369j.ae();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.cw.j
                            public void r() {
                                if (!z.m(cw.this.xt) || cw.this.zz() == null) {
                                    return;
                                }
                                cw.this.zz().xt().xt(cw.this.f28356c + 1);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.cw.j
                            public void xt() {
                                cw cwVar = cw.this;
                                cwVar.f28368i = false;
                                cwVar.zz().j(true);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.cw.j
                            public void j(int i6) {
                                cw.this.wq += i6;
                                cw.this.uf += i6;
                            }
                        });
                        cw.this.f28368i = upVar.ed();
                        cw.this.zz().j(!upVar.c());
                    } else {
                        cw.this.f28368i = false;
                    }
                    cw.this.st();
                }
            });
        }
        s();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void k() {
        aq();
        kc();
        rr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tj() {
        super.tj();
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.up) zz().xt().cw(this.f28356c);
            if (upVar != null) {
                upVar.a();
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw("cubic pause exception:" + e6.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void up(boolean z5) {
        super.up(z5);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar = this.rh;
        if (upVar != null) {
            upVar.cw(z5);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.xt> it = this.rn.iterator();
        while (it.hasNext()) {
            it.next().j(z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void x() {
        super.x();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        this.tj.j(jSONObject);
        tj();
    }

    public static boolean j(n nVar) {
        return (nVar == null || !z.j(nVar) || TextUtils.isEmpty(nVar.kg())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.r rVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.r(this.f28369j, this.xt, z5);
        float f6 = this.up;
        float f7 = this.f28371m;
        float[] fArr = {f6, f7};
        if (f6 < 10.0f || f7 < 10.0f) {
            fArr = mi();
        }
        rVar.j(fArr);
        this.f28366g = rVar;
        return rVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public xt.j j(final com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        this.f28369j.gx();
        com.bytedance.sdk.openadsdk.core.component.reward.cw.up upVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw.up(this.f28369j, this.xt);
        upVar.j(c());
        return upVar.xt(new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.cw.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void xt() {
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.xt();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void cw() {
                super.cw();
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.cw();
                }
                cw.this.f28369j.n();
                if (cw.this.zz() != null) {
                    cw.this.zz().xt().xt(cw.this.f28356c + 1);
                }
                cw.this.f28369j.b().j("reward_retain_dialog_next", 0, "");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                super.j();
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j();
                }
                cw.this.f28369j.n();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(Map<String, Object> map) {
        super.j(map);
        map.put("group_pos", Integer.valueOf(this.f28356c + 1));
        com.bytedance.sdk.openadsdk.core.component.reward.draw.up upVar = this.rh;
        if (upVar != null) {
            map.put("duration", Long.valueOf(upVar.la()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(JSONObject jSONObject) {
        super.j(jSONObject);
        try {
            jSONObject.put("group_pos", this.ed + 1);
            jSONObject.put("duration", this.rh.la());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(View view) {
        super.j(view);
        this.rh.j(view);
    }
}
