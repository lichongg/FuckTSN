package com.bytedance.sdk.openadsdk.core.component.reward.r;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.l;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends j {
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.j> rn;
    private int wq;

    public static boolean j(n nVar) {
        if (nVar == null || !l.j(nVar)) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.ws.r.j(String.valueOf(uf.g(nVar)))) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", nVar.so());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        ws.j().j(nVar, "refresh_max", jSONObject);
        com.bytedance.sdk.openadsdk.core.jy.cw.ae(nVar, uf.xt(nVar), "refresh_max", null);
        return false;
    }

    public static int xt(n nVar) {
        return 11;
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
    public boolean q() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public boolean qb() {
        return true;
    }

    private com.bytedance.sdk.openadsdk.core.component.reward.layout.oq aq() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) xtVar;
        }
        return null;
    }

    private int rr() {
        int up;
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.j jVar;
        n j6;
        l ng;
        com.bytedance.sdk.openadsdk.core.component.reward.layout.oq oqVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) this.f28366g;
        if (oqVar == null || (up = oqVar.up()) < 0 || up >= this.rn.size() || (jVar = this.rn.get(up)) == null || (j6 = jVar.j()) == null || (ng = j6.ng()) == null) {
            return 0;
        }
        return ng.cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ae(boolean z5) {
        return z5 ? ed() : z.ae(this.xt) - this.wq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j, com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void cw() {
        this.f28366g.cw(true);
        if (aq() != null) {
            aq().j(this.rn);
        }
        this.f28369j.xt(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int ed() {
        return z.cw(this.xt) - this.wq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    public void ff() {
        this.mi.j(false);
        this.mi.xt(false);
        this.mi.up(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public View g() {
        FrameLayout frameLayout = new FrameLayout(this.f28369j);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    protected int gx() {
        return this.wq;
    }

    public void kc() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) this.f28366g).m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public int p() {
        return xt(this.xt);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void xt(boolean z5) {
        super.xt(z5);
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) this.f28366g).cw();
    }

    public void zz() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) this.f28366g).r();
    }

    public qv(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
        this.rn = new ArrayList();
        this.wq = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void az() {
        super.az();
        this.f28366g.oq();
        List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.j> list = this.rn;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.swiper.j> it = list.iterator();
            while (it.hasNext()) {
                it.next().g();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void f() {
        super.f();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) this.f28366g).cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void gq() {
        super.gq();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) xtVar).r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tj() {
        super.tj();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) this.f28366g).xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void tl() {
        super.tl();
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.j jVar = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.j(this.f28369j, this.xt, this.vl, q(), true);
        jVar.j(this.jy);
        this.rn.add(jVar);
        if (l.xt(this.xt)) {
            try {
                JSONArray jSONArray = new JSONArray(this.xt.kg());
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    arrayList.add(com.bytedance.sdk.openadsdk.core.j.j(jSONArray.getJSONObject(i6)));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.xt);
                arrayList2.addAll(arrayList);
                if (l.j(arrayList2)) {
                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                        com.bytedance.sdk.openadsdk.core.component.reward.swiper.j jVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.j(this.f28369j, (n) arrayList.get(i7), this.vl, q(), false);
                        jVar2.j(this.jy);
                        this.rn.add(jVar2);
                    }
                }
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void up(boolean z5) {
        super.up(z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void ws() {
        super.ws();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) this.f28366g).xt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void x() {
        super.x();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.xt xtVar = this.f28366g;
        if (xtVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.oq) xtVar).oq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void xt(Map<String, Object> map) {
        super.xt(map);
        map.put("refresh_num", Integer.valueOf(rr()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xt j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.oq oqVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.oq(this.f28369j, this.xt, z5);
        oqVar.j(new float[]{this.up, this.f28371m});
        this.f28366g = oqVar;
        return oqVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public xt.j j(final com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar) {
        this.f28369j.gx();
        com.bytedance.sdk.openadsdk.core.component.reward.cw.up upVar = new com.bytedance.sdk.openadsdk.core.component.reward.cw.up(this.f28369j, this.xt);
        upVar.j(c());
        return upVar.xt(new com.bytedance.sdk.openadsdk.core.component.reward.cw.oq() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.r.qv.1
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
                qv.this.f28369j.n();
                qv.this.f28369j.b().j("reward_retain_dialog_next", 0, "");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.oq
            public void j() {
                super.j();
                com.bytedance.sdk.openadsdk.core.component.reward.cw.oq oqVar2 = oqVar;
                if (oqVar2 != null) {
                    oqVar2.j();
                }
                qv.this.f28369j.n();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(Map<String, Object> map) {
        super.j(map);
        map.put("refresh_num", Integer.valueOf(rr()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(JSONObject jSONObject) {
        super.j(jSONObject);
        try {
            jSONObject.put("refresh_num", rr());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.xt
    protected void k() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.r.j
    public void j(View view) {
        super.j(view);
    }
}
