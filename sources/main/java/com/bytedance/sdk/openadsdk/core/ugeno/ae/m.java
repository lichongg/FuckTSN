package com.bytedance.sdk.openadsdk.core.ugeno.ae;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.az;
import com.bytedance.adsdk.ugeno.cw.oq;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.up.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.qv;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements w {
    private com.bytedance.adsdk.ugeno.xt.cw ae;
    private com.bytedance.adsdk.ugeno.xt.cw<View> cw;

    /* renamed from: g, reason: collision with root package name */
    private tl f30543g;

    /* renamed from: j, reason: collision with root package name */
    private Context f30544j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private n f30545m;
    private qv oq;
    private rn qv;

    /* renamed from: r, reason: collision with root package name */
    private r f30546r;
    private xt tl;
    private cw up;
    private String vl;
    private com.bytedance.sdk.openadsdk.core.jy.up xt;

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, m.j jVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> list, ae aeVar) {
        az azVar = new az(this.f30544j);
        ws wsVar = new ws();
        wsVar.j(this.f30544j);
        HashMap hashMap = new HashMap();
        hashMap.put("key_material", this.f30545m);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size() && i6 <= 2; i6++) {
            arrayList.add(list.get(i6).j());
        }
        rn rnVar = new rn(this.f30544j);
        this.qv = rnVar;
        rnVar.j(this.oq);
        this.qv.j(this.tl);
        this.qv.j(this.vl);
        this.qv.cw(this.jy);
        hashMap.put("key_data_list", arrayList);
        hashMap.put("key_js_object", this.qv);
        wsVar.j(hashMap);
        azVar.j("aggPage", wsVar);
        com.bytedance.adsdk.ugeno.xt.cw<View> j6 = azVar.j(jSONObject);
        this.cw = j6;
        if (j6 == null || list.size() <= 0) {
            com.bytedance.sdk.openadsdk.core.jy.up upVar = this.xt;
            if (upVar != null) {
                upVar.j(-1, "ugeno render fail");
            }
            if (aeVar != null) {
                aeVar.j(-1, "");
                return;
            }
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw<View> r5 = this.cw.r("recycler_layout");
        this.ae = r5;
        if (r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m) r5).j(list);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m) this.ae).j(new m.xt() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.m.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m.xt
                public void j() {
                    if (m.this.f30546r != null) {
                        m.this.f30546r.r(m.this.ae);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m.xt
                public void j(int i7, int i8) {
                    if (m.this.f30546r != null) {
                        m.this.f30546r.j(i7, i8);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m.xt
                public void j(RecyclerView recyclerView, int i7) {
                    if (m.this.f30546r != null) {
                        m.this.f30546r.j(recyclerView, i7);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m.xt
                public void j(int i7, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw cwVar) {
                    if (m.this.f30546r != null) {
                        m.this.f30546r.j(m.this.ae, i7, view, cwVar);
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xt.m) this.ae).j(new com.bytedance.sdk.openadsdk.core.ugeno.component.xt.r() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.m.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.r
                public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                    if (m.this.f30546r != null) {
                        m.this.f30546r.up(cwVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xt.r
                public void xt(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                    if (m.this.f30546r != null) {
                        m.this.f30546r.m(cwVar);
                    }
                }
            });
        }
        azVar.j(new oq() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.m.4
            @Override // com.bytedance.adsdk.ugeno.cw.oq
            public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
                if (m.this.up != null) {
                    m.this.up.cw(cwVar);
                }
            }
        });
        azVar.j(this);
        JSONObject tv2 = this.f30545m.tv();
        if (list.size() > 0) {
            try {
                tv2.put("ugen_sub_meta", list.get(0).j());
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        azVar.xt(tv2);
        this.xt.j(0L);
        if (aeVar != null) {
            aeVar.j(this.cw);
        }
    }

    public m(Context context, com.bytedance.sdk.openadsdk.core.jy.up upVar, n nVar, String str, int i6) {
        this.f30544j = context;
        this.xt = upVar;
        this.f30545m = nVar;
        this.vl = str;
        this.jy = i6;
    }

    public void j(r rVar) {
        this.f30546r = rVar;
    }

    public void j(tl tlVar) {
        this.f30543g = tlVar;
    }

    public void j(cw cwVar) {
        this.up = cwVar;
    }

    public void j(final JSONObject jSONObject, final List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw> list, final ae aeVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xt(jSONObject, list, aeVar);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.xt(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.xt.cw>) list, aeVar);
                }
            });
        }
    }

    public void j(qv qvVar) {
        this.oq = qvVar;
    }

    public void j(xt xtVar) {
        this.tl = xtVar;
    }

    public com.bytedance.adsdk.ugeno.xt.cw j() {
        return this.ae;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.w
    public void j(av avVar, w.xt xtVar, w.j jVar) {
        tl tlVar;
        if (avVar == null) {
            return;
        }
        if (avVar.xt() == 1) {
            xt(avVar, (w.xt) null, (w.j) null);
            return;
        }
        if (avVar.xt() != 10 || (tlVar = this.f30543g) == null) {
            return;
        }
        tlVar.xt(avVar.j());
        rn rnVar = this.qv;
        if (rnVar != null) {
            rnVar.j("webviewVisible", (JSONObject) null);
        }
    }

    private void xt(av avVar, w.xt xtVar, w.j jVar) {
        if (avVar == null || avVar.j() == null) {
            return;
        }
        JSONObject cw = avVar.cw();
        String optString = cw.optString("type");
        String optString2 = cw.optString("nodeId");
        optString.getClass();
        if (optString.equals("onDismiss")) {
            com.bytedance.adsdk.ugeno.xt.cw<View> r5 = this.cw.r(optString2);
            if (r5 != null) {
                r5.xt(8);
            }
        } else if (!optString.equals("onShow")) {
            cw cwVar = this.up;
            if (cwVar != null) {
                cwVar.cw(avVar.j());
            }
        } else {
            com.bytedance.adsdk.ugeno.xt.cw<View> r6 = this.cw.r(optString2);
            if (r6 != null) {
                r6.xt(0);
            }
        }
        final String optString3 = cw.optString("reportType");
        if (!TextUtils.isEmpty(optString3)) {
            com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.m.5
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("type", optString3);
                    return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("agg_click").xt(jSONObject.toString());
                }
            }, "agg_click");
        }
        if (xtVar == null || avVar.r() == null) {
            return;
        }
        xtVar.j(avVar.r());
    }
}
