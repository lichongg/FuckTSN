package com.bytedance.sdk.openadsdk.core.ugeno;

import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.sdk.component.qv.j.xt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends com.bytedance.adsdk.ugeno.cw.j.xt {

    /* renamed from: m, reason: collision with root package name */
    private volatile j f30727m;

    class j implements com.bytedance.sdk.component.qv.r.xt {
        private av cw;

        /* renamed from: j, reason: collision with root package name */
        w.j f30732j;

        /* renamed from: r, reason: collision with root package name */
        private w.xt f30733r;

        j() {
        }

        public void j(av avVar) {
            this.cw = avVar;
        }

        public void j(w.xt xtVar) {
            this.f30733r = xtVar;
        }

        public void j(w.j jVar) {
            this.f30732j = jVar;
        }

        @Override // com.bytedance.sdk.component.qv.r.xt
        public void j() {
            g.this.xt(this.cw, this.f30733r, this.f30732j);
        }
    }

    private j xt() {
        if (this.f30727m != null) {
            return this.f30727m;
        }
        synchronized (j.class) {
            try {
                if (this.f30727m != null) {
                    return this.f30727m;
                }
                this.f30727m = new j();
                return this.f30727m;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.j.xt
    public void cw(av avVar, w.xt xtVar, w.j jVar) {
        if (this.f30727m == null) {
            this.f30727m = xt();
        }
        this.f30727m.j(avVar);
        this.f30727m.j(xtVar);
        this.f30727m.j(jVar);
        JSONObject cw = avVar.cw();
        if (cw == null) {
            return;
        }
        new xt.j(cw.optString("type")).xt(this.f23612r).j(new com.bytedance.sdk.component.qv.r.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.g.1
            @Override // com.bytedance.sdk.component.qv.r.cw
            public void j(com.bytedance.sdk.component.qv.j.j jVar2) {
                g.this.j(jVar2);
            }
        }).j().j();
    }

    public g(w wVar) {
        super(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.component.qv.j.j jVar) {
        if (this.up) {
            return;
        }
        j xt = xt();
        xt.j(j(xt.cw, jVar));
        jVar.j(xt);
    }

    protected av j(av avVar, com.bytedance.sdk.component.qv.j.j jVar) {
        com.bytedance.sdk.component.qv.cw.j jVar2;
        if (avVar == null || jVar == null) {
            return avVar;
        }
        av avVar2 = new av();
        com.bytedance.adsdk.ugeno.xt.cw j6 = avVar.j();
        if (j6 == null) {
            return avVar;
        }
        avVar2.j(avVar.xt());
        com.bytedance.sdk.component.qv.cw.j ae = jVar.ae();
        JSONObject j7 = j(j6, avVar2, ae);
        com.bytedance.sdk.component.qv.cw.cw j8 = com.bytedance.sdk.component.qv.cw.xt.INSTANCE.j(jVar.r());
        List<com.bytedance.sdk.component.qv.cw.j> j9 = j8.j(ae, j6.oq(), new HashMap());
        avVar2.j(j7);
        if (!j9.isEmpty()) {
            com.bytedance.sdk.component.qv.cw.j jVar3 = j9.get(0);
            if (jVar3 != null) {
                av avVar3 = new av();
                avVar3.j(j(j6, avVar3, jVar3));
                avVar3.j(j6);
                avVar2.j(avVar3);
            }
            return avVar2;
        }
        List<com.bytedance.sdk.component.qv.cw.j> xt = j8.xt(ae, j6.oq(), new HashMap());
        if (!xt.isEmpty() && (jVar2 = xt.get(0)) != null) {
            av avVar4 = new av();
            avVar4.j(j(j6, avVar4, jVar2));
            avVar4.j(j6);
            avVar2.xt(avVar4);
        }
        return avVar2;
    }

    private JSONObject j(com.bytedance.adsdk.ugeno.xt.cw cwVar, av avVar, com.bytedance.sdk.component.qv.cw.j jVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (jVar != null) {
                Map<String, String> cw = jVar.cw();
                String j6 = jVar.j();
                avVar.j(cwVar);
                jSONObject.put("type", j6);
                if (cw != null && !cw.isEmpty()) {
                    for (Map.Entry<String, String> entry : cw.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}
