package com.bytedance.sdk.openadsdk.core.ugeno.component.xt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.g;
import com.bytedance.adsdk.ugeno.cw.kt;
import com.bytedance.adsdk.ugeno.cw.oq;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.xt.j;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends RecyclerView.j<RecyclerView.v> {
    private r ae;
    private Context cw;

    /* renamed from: g, reason: collision with root package name */
    private oq f30665g;

    /* renamed from: j, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> f30666j;

    /* renamed from: m, reason: collision with root package name */
    private Object f30667m;
    private w oq;
    private kt qv;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.component.xt.r f30668r;
    private boolean tl = true;
    private cw up;
    private Map<Integer, g.j> xt;

    public interface cw {
    }

    public interface j {
        void J_();

        void K_();

        View cw();
    }

    public interface r {
        void j(RecyclerView.v vVar, int i6);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up$up, reason: collision with other inner class name */
    public class C0483up extends RecyclerView.v implements j {

        /* renamed from: i, reason: collision with root package name */
        com.bytedance.adsdk.ugeno.xt.cw f30669i;

        /* renamed from: w, reason: collision with root package name */
        az f30670w;

        public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
            this.f30669i = cwVar;
        }

        C0483up(View view) {
            super(view);
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up.j
        public void J_() {
            if (up.this.f30668r != null) {
                up.this.f30668r.xt(this.f30669i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up.j
        public void K_() {
            if (up.this.f30668r != null) {
                up.this.f30668r.j(this.f30669i);
            }
        }

        public com.bytedance.adsdk.ugeno.xt.cw a() {
            return this.f30669i;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up.j
        public View cw() {
            return this.f30669i.g();
        }

        public void j(az azVar) {
            this.f30670w = azVar;
        }
    }

    public class xt extends RecyclerView.v {
        public xt(View view) {
            super(view);
        }
    }

    public void j(Map<Integer, g.j> map) {
        this.xt = map;
    }

    public up(Context context) {
        this.cw = context;
    }

    public void j(List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> list) {
        if (this.f30666j == null) {
            this.f30666j = new ArrayList();
        }
        this.f30666j.addAll(list);
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.component.xt.r rVar) {
        this.f30668r = rVar;
    }

    public void j(oq oqVar) {
        this.f30665g = oqVar;
    }

    public void j(w wVar) {
        this.oq = wVar;
    }

    public void j(kt ktVar) {
        this.qv = ktVar;
    }

    public void j(cw cwVar) {
        this.up = cwVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public RecyclerView.v j(ViewGroup viewGroup, int i6) {
        g.j jVar = this.xt.get(Integer.valueOf(i6));
        az azVar = new az(this.cw);
        com.bytedance.adsdk.ugeno.xt.cw<View> j6 = azVar.j(jVar);
        azVar.j(j6);
        if (j6 != null) {
            j6.j(new ViewGroup.LayoutParams(j6.rn(), j6.wq()));
            C0483up c0483up = new C0483up(j6.g());
            c0483up.j((com.bytedance.adsdk.ugeno.xt.cw) j6);
            c0483up.j(azVar);
            return c0483up;
        }
        return new xt(new View(this.cw));
    }

    public void j(r rVar) {
        this.ae = rVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public int j(int i6) {
        return this.f30666j.get(i6).xt();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public void j(RecyclerView.v vVar, int i6, List<Object> list) {
        r rVar;
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj != null && this.f30667m != null && TextUtils.equals(obj.toString(), this.f30667m.toString()) && (rVar = this.ae) != null) {
                    rVar.j(vVar, i6);
                }
            }
            return;
        }
        j(vVar, i6);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public void j(RecyclerView.v vVar, int i6) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw cwVar;
        com.bytedance.sdk.openadsdk.core.ugeno.component.xt.r rVar;
        if (vVar == null || (cwVar = this.f30666j.get(i6)) == null || !(vVar instanceof C0483up)) {
            return;
        }
        JSONObject j6 = cwVar.j();
        C0483up c0483up = (C0483up) vVar;
        c0483up.f30669i.j(new ViewGroup.LayoutParams(c0483up.f30669i.rn(), c0483up.f30669i.wq()));
        j(j6, c0483up.a());
        j(this.cw, j6, c0483up.a());
        if (i6 == 0 && (rVar = this.f30668r) != null && this.tl) {
            this.tl = false;
            rVar.j(c0483up.f30669i);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.j
    public int j() {
        return this.f30666j.size();
    }

    public void j(Object obj) {
        this.f30667m = obj;
    }

    public void j(JSONObject jSONObject, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
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
                j(jSONObject, it.next());
            }
            return;
        }
        cwVar.j(jSONObject);
    }

    public void j(Context context, JSONObject jSONObject, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        if (cwVar instanceof com.bytedance.adsdk.ugeno.xt.j) {
            cwVar.j(this.f30665g);
            cwVar.j(this.oq);
            cwVar.xt(true);
            cwVar.xt();
            List<com.bytedance.adsdk.ugeno.xt.cw<View>> ae = ((com.bytedance.adsdk.ugeno.xt.j) cwVar).ae();
            if (ae == null || ae.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.xt.cw<View>> it = ae.iterator();
            while (it.hasNext()) {
                j(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject x5 = cwVar.x();
        Iterator<String> keys = x5.keys();
        com.bytedance.adsdk.ugeno.xt.j h6 = cwVar.h();
        j.C0328j tl = h6 != null ? h6.tl() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String j6 = com.bytedance.adsdk.ugeno.r.xt.j(x5.optString(next), jSONObject);
            cwVar.j(next, j6);
            cwVar.j(this.f30665g);
            cwVar.j(this.oq);
            if (tl != null) {
                tl.j(context, next, j6);
            }
        }
        cwVar.xt(true);
        cwVar.xt();
    }
}
