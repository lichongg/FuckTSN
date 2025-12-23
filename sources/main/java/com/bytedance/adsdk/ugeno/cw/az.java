package com.bytedance.adsdk.ugeno.cw;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.cw.g;
import com.bytedance.adsdk.ugeno.xt.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class az {
    private kt ae;
    private boolean av;
    private com.bytedance.adsdk.ugeno.up.j.j az;
    private com.bytedance.adsdk.ugeno.xt.cw<View> cw;

    /* renamed from: f, reason: collision with root package name */
    private qv f23580f;

    /* renamed from: g, reason: collision with root package name */
    private g f23581g;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f23582i;

    /* renamed from: j, reason: collision with root package name */
    private Context f23583j;
    private float kt;

    /* renamed from: m, reason: collision with root package name */
    private f f23584m;
    private m mi;
    private String oq;
    private ws qv;

    /* renamed from: r, reason: collision with root package name */
    private oq f23585r;
    private float tj;
    private mi tl;
    private w up;
    private JSONObject vl;

    /* renamed from: w, reason: collision with root package name */
    private tl f23586w;
    private JSONObject xt;
    private boolean jy = true;
    private boolean ws = false;

    public void j(String str, ws wsVar) {
        this.qv = wsVar;
        this.oq = str;
        if (wsVar != null) {
            this.xt = wsVar.j();
        }
    }

    public com.bytedance.adsdk.ugeno.xt.cw<View> xt(g.j jVar, com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        List<g.j> cw;
        j.C0328j c0328j = null;
        if (!g.r(jVar)) {
            return null;
        }
        tl tlVar = this.f23586w;
        if (tlVar != null) {
            tlVar.xt(jVar);
        }
        String cw2 = jVar.cw();
        xt j6 = r.j(cw2);
        if (j6 == null) {
            this.av = true;
            if (this.f23582i == null) {
                this.f23582i = new ArrayList();
            }
            this.f23582i.add(cw2);
            return null;
        }
        com.bytedance.adsdk.ugeno.xt.cw j7 = j6.j(this.f23583j);
        if (j7 == null) {
            return null;
        }
        j7.ae(com.bytedance.adsdk.ugeno.r.xt.j(jVar.j(), this.xt));
        j7.tl(cw2);
        j7.cw(jVar.r());
        j7.j(jVar);
        j7.j(this.qv);
        if (cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) {
            com.bytedance.adsdk.ugeno.xt.j jVar2 = (com.bytedance.adsdk.ugeno.xt.j) cwVar;
            j7.j(jVar2);
            c0328j = jVar2.tl();
        }
        Iterator<String> keys = jVar.r().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String j8 = com.bytedance.adsdk.ugeno.r.xt.j(jVar.r().optString(next), this.xt);
            j7.j(next, j8);
            if (c0328j != null) {
                c0328j.j(this.f23583j, next, j8);
            }
        }
        if (j7 instanceof com.bytedance.adsdk.ugeno.xt.j) {
            List<g.j> up = jVar.up();
            if (up == null || up.size() <= 0) {
                if (TextUtils.equals(j7.gq(), "RecyclerLayout") && (cw = this.f23581g.cw()) != null && cw.size() > 0) {
                    Iterator<g.j> it = cw.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.xt.cw<View> xt = xt(it.next(), j7);
                        if (xt != null && xt.ed()) {
                            ((com.bytedance.adsdk.ugeno.xt.j) j7).j(xt);
                        }
                    }
                }
                return j7;
            }
            if (TextUtils.equals(j7.gq(), "Swiper") && up.size() != 1) {
                com.bytedance.sdk.component.utils.vl.r("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<g.j> it2 = up.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.xt.cw<View> xt2 = xt(it2.next(), j7);
                if (xt2 != null && xt2.ed()) {
                    ((com.bytedance.adsdk.ugeno.xt.j) j7).j(xt2);
                }
            }
        }
        if (c0328j != null) {
            j7.j(c0328j.j());
        }
        this.cw = j7;
        return j7;
    }

    public az(Context context) {
        this.f23583j = context;
    }

    private void cw(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        try {
            if (cwVar.p() && cwVar.l() != null && cwVar.l().m() != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i18n", cwVar.l().m());
                this.xt.put("xNode", jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    public com.bytedance.adsdk.ugeno.xt.cw<View> j(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.xt = jSONObject2;
        f fVar = this.f23584m;
        if (fVar != null) {
            fVar.j();
        }
        g gVar = new g(jSONObject, jSONObject2, jSONObject3);
        this.f23581g = gVar;
        gVar.j(this.kt, this.tj);
        this.az = new com.bytedance.adsdk.ugeno.up.j.j();
        w wVar = this.up;
        if (wVar instanceof com.bytedance.adsdk.ugeno.cw.j.xt) {
            ((com.bytedance.adsdk.ugeno.cw.j.xt) wVar).j(this.f23581g.xt());
        }
        this.cw = j(this.f23581g.j(), (com.bytedance.adsdk.ugeno.xt.cw<View>) null);
        qv qvVar = this.f23580f;
        if (qvVar != null) {
            qvVar.xt();
            if (this.f23580f.cw()) {
                this.f23580f.j(this.tl);
            }
            this.f23580f.j(this.f23584m);
        }
        f fVar2 = this.f23584m;
        if (fVar2 != null) {
            fVar2.xt();
            this.cw.j(this.f23584m);
            this.f23584m.cw();
        }
        xt(this.cw);
        if (this.f23584m != null) {
            tj tjVar = new tj();
            tjVar.j(0);
            tjVar.j(this.cw);
            this.f23584m.j(tjVar);
        }
        return this.cw;
    }

    public com.bytedance.adsdk.ugeno.xt.cw<View> j(g.j jVar, com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        List<g.j> cw;
        j.C0328j c0328j = null;
        if (!g.r(jVar)) {
            return null;
        }
        tl tlVar = this.f23586w;
        if (tlVar != null) {
            tlVar.j(jVar);
        }
        String cw2 = jVar.cw();
        xt j6 = r.j(cw2);
        xt xtVar = j6;
        if (j6 == null) {
            this.av = true;
            if (this.f23582i == null) {
                this.f23582i = new ArrayList();
            }
            this.f23582i.add(cw2);
            cw2 = "View";
            jVar.j("View");
            xt j7 = r.j("View");
            xtVar = j7;
            if (j7 == null) {
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.xt.cw j8 = xtVar.j(this.f23583j);
        if (j8 == null) {
            return null;
        }
        JSONObject r5 = jVar.r();
        j8.ae(com.bytedance.adsdk.ugeno.r.xt.j(jVar.j(), this.xt));
        j8.tl(cw2);
        j8.cw(r5);
        j8.j(jVar);
        j8.xt(this.xt);
        g gVar = this.f23581g;
        if (gVar == null) {
            j8.cw(true);
        } else {
            j8.cw(gVar.r());
        }
        j8.j(this.qv);
        j8.j(this.az);
        Iterator<String> keys = r5.keys();
        if (cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) {
            com.bytedance.adsdk.ugeno.xt.j jVar2 = (com.bytedance.adsdk.ugeno.xt.j) cwVar;
            c0328j = jVar2.tl();
            j8.j(jVar2);
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String j9 = com.bytedance.adsdk.ugeno.r.xt.j(r5.optString(next), this.xt);
            j8.j(next, j9);
            qv qvVar = this.f23580f;
            if (qvVar != null) {
                qvVar.j(next, j9);
            }
            if (c0328j != null) {
                c0328j.j(this.f23583j, next, j9);
            }
        }
        if (c0328j != null) {
            j8.j(c0328j.j());
        }
        if (j8 instanceof com.bytedance.adsdk.ugeno.xt.j) {
            List<g.j> up = jVar.up();
            if (up != null && up.size() > 0) {
                if (TextUtils.equals(j8.gq(), "Swiper") && up.size() != 1) {
                    com.bytedance.sdk.component.utils.vl.r("UGTemplateEngine", "Swiper must be only one widget");
                }
                try {
                    Collections.sort(up, new Comparator<g.j>() { // from class: com.bytedance.adsdk.ugeno.cw.az.1
                        @Override // java.util.Comparator
                        /* renamed from: j, reason: merged with bridge method [inline-methods] */
                        public int compare(g.j jVar3, g.j jVar4) {
                            return jVar3.r().optInt("order", 0) - jVar4.r().optInt("order", 0);
                        }
                    });
                } catch (Throwable unused) {
                }
                Iterator<g.j> it = up.iterator();
                while (it.hasNext()) {
                    com.bytedance.adsdk.ugeno.xt.cw<View> j10 = j(it.next(), (com.bytedance.adsdk.ugeno.xt.cw<View>) j8);
                    if (j10 != null && !j10.e()) {
                        ((com.bytedance.adsdk.ugeno.xt.j) j8).j(j10, j10.a());
                    }
                }
            } else {
                if (TextUtils.equals(j8.gq(), "RecyclerLayout") && (cw = this.f23581g.cw()) != null && cw.size() > 0) {
                    Iterator<g.j> it2 = cw.iterator();
                    while (it2.hasNext()) {
                        com.bytedance.adsdk.ugeno.xt.cw<View> j11 = j(it2.next(), (com.bytedance.adsdk.ugeno.xt.cw<View>) j8);
                        if (j11 != null && j11.ed()) {
                            ((com.bytedance.adsdk.ugeno.xt.j) j8).j(j11);
                        }
                    }
                }
                return j8;
            }
        }
        this.cw = j8;
        return j8;
    }

    public void xt(JSONObject jSONObject) {
        f fVar = this.f23584m;
        if (fVar != null) {
            fVar.cw();
        }
        this.xt = jSONObject;
        j(this.cw, jSONObject);
        xt(this.cw);
        if (this.f23584m != null) {
            tj tjVar = new tj();
            tjVar.j(0);
            tjVar.j(this.cw);
            this.f23584m.j(tjVar);
        }
    }

    private void xt(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
        List<com.bytedance.adsdk.ugeno.xt.cw<View>> ae;
        if (cwVar == null) {
            return;
        }
        JSONObject x5 = cwVar.x();
        Iterator<String> keys = x5.keys();
        com.bytedance.adsdk.ugeno.xt.j h6 = cwVar.h();
        j.C0328j tl = h6 != null ? h6.tl() : null;
        cw(cwVar);
        while (keys.hasNext()) {
            String next = keys.next();
            String j6 = com.bytedance.adsdk.ugeno.r.xt.j(x5.optString(next), this.xt);
            cwVar.j(next, j6);
            if (tl != null) {
                tl.j(this.f23583j, next, j6);
            }
        }
        cwVar.j(this.f23585r);
        cwVar.j(this.up);
        cwVar.j(this.ae);
        qv qvVar = this.f23580f;
        if (qvVar != null) {
            cwVar.j(qvVar);
        }
        m mVar = this.mi;
        if (mVar != null) {
            cwVar.j(mVar);
        }
        if ((cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) && (ae = ((com.bytedance.adsdk.ugeno.xt.j) cwVar).ae()) != null && ae.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.xt.cw<View>> it = ae.iterator();
            while (it.hasNext()) {
                xt(it.next());
            }
        }
        if (tl != null) {
            cwVar.j(tl.j());
        }
        cwVar.xt();
    }

    public List<String> xt() {
        return this.f23582i;
    }

    public com.bytedance.adsdk.ugeno.xt.cw<View> j(JSONObject jSONObject) {
        f fVar = this.f23584m;
        if (fVar != null) {
            fVar.j();
        }
        g gVar = new g(jSONObject, this.xt);
        this.f23581g = gVar;
        w wVar = this.up;
        if (wVar instanceof com.bytedance.adsdk.ugeno.cw.j.xt) {
            ((com.bytedance.adsdk.ugeno.cw.j.xt) wVar).j(gVar.xt());
        }
        this.cw = xt(this.f23581g.j(), null);
        f fVar2 = this.f23584m;
        if (fVar2 != null) {
            fVar2.xt();
            this.cw.j(this.f23584m);
        }
        return this.cw;
    }

    public com.bytedance.adsdk.ugeno.xt.cw<View> j(g.j jVar) {
        com.bytedance.adsdk.ugeno.xt.cw<View> xt = xt(jVar, null);
        this.cw = xt;
        return xt;
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        List<com.bytedance.adsdk.ugeno.xt.cw<View>> ae;
        if (cwVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xt.j h6 = cwVar.h();
        if (h6 != null) {
            j.C0328j tl = h6.tl();
            Iterator<String> keys = cwVar.x().keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String j6 = com.bytedance.adsdk.ugeno.r.xt.j(cwVar.x().optString(next), this.xt);
                cwVar.j(next, j6);
                tl.j(this.f23583j, next, j6);
            }
            cwVar.j(tl.j());
        }
        if (!(cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) || (ae = ((com.bytedance.adsdk.ugeno.xt.j) cwVar).ae()) == null || ae.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.xt.cw<View>> it = ae.iterator();
        while (it.hasNext()) {
            j(it.next());
        }
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject) {
        if (cwVar == null) {
            return;
        }
        if (cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) {
            cwVar.j(jSONObject);
            List<com.bytedance.adsdk.ugeno.xt.cw<View>> ae = ((com.bytedance.adsdk.ugeno.xt.j) cwVar).ae();
            if (ae == null || ae.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.xt.cw<View>> it = ae.iterator();
            while (it.hasNext()) {
                j(it.next(), jSONObject);
            }
            return;
        }
        cwVar.j(jSONObject);
    }

    public void j(oq oqVar) {
        this.f23585r = oqVar;
    }

    public void j(w wVar) {
        com.bytedance.adsdk.ugeno.cw.j.j up = com.bytedance.adsdk.ugeno.r.j().up();
        if (up == null) {
            this.up = wVar;
            return;
        }
        com.bytedance.adsdk.ugeno.cw.j.xt j6 = up.j(wVar);
        if (j6 == null) {
            this.up = wVar;
            return;
        }
        j6.j(this.vl);
        j6.j(this.jy);
        j6.xt(this.ws);
        g gVar = this.f23581g;
        if (gVar != null) {
            j6.j(gVar.xt());
        }
        this.up = j6;
    }

    public void j(kt ktVar) {
        this.ae = ktVar;
    }

    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.xt.cw<View>> ae;
        if (cwVar == null) {
            return;
        }
        cwVar.j(str, objArr);
        if (!(cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) || (ae = ((com.bytedance.adsdk.ugeno.xt.j) cwVar).ae()) == null || ae.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.xt.cw<View>> it = ae.iterator();
        while (it.hasNext()) {
            j(it.next(), str, objArr);
        }
    }

    public boolean j() {
        return this.av;
    }

    public void j(tl tlVar) {
        this.f23586w = tlVar;
    }
}
