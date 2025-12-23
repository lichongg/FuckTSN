package com.bytedance.sdk.openadsdk.core.ugeno.cw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.jy.up;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.m;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.r;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.up;
import com.bytedance.sdk.openadsdk.core.ugeno.cw.xt;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.v.xt;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements xt.j {
    private Activity ae;
    private com.bytedance.sdk.openadsdk.core.multipro.xt.j av;
    private com.bytedance.adsdk.ugeno.widget.image.xt az;
    protected com.bytedance.sdk.openadsdk.core.ugeno.r.j cw;

    /* renamed from: g, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.xt.cw f30675g;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.qv.xt.j f30676i = new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.8
        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, long j7, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void cw(long j6, long j7, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void xt(long j6, long j7, String str, String str2) {
        }
    };

    /* renamed from: j, reason: collision with root package name */
    protected n f30677j;
    private String jy;

    /* renamed from: m, reason: collision with root package name */
    private up f30678m;
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw oq;
    private JSONObject qv;

    /* renamed from: r, reason: collision with root package name */
    protected String f30679r;
    private ViewGroup tl;
    protected int up;
    private r vl;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt ws;
    protected xt xt;

    protected void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
    }

    private String ae() {
        return uf.av(this.f30677j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j(this.f30677j.tj(), "lp_" + this.f30677j.kt(), this.f30677j.f(), new up.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.up.j
            public void j(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    j.this.f30678m.j(-1, "template info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = j.this.cw;
                    if (jVar != null) {
                        jVar.j(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put("creative", j.this.f30677j.tv());
                    j.this.j(jSONObject);
                    j.this.j(jSONObject2, jSONObject);
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        });
    }

    private void g() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = this.ws;
        if (xtVar != null) {
            xtVar.j(this.av);
        }
    }

    private String m() {
        JSONObject jSONObject = this.qv;
        if (jSONObject == null) {
            return ae();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("download_buttons");
        if (optJSONArray == null) {
            return ae();
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return ae();
        }
        String optString = optJSONObject.optString("url");
        return TextUtils.isEmpty(optString) ? ae() : optString;
    }

    private void r(final JSONObject jSONObject) {
        if (this.vl != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.vl.m());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, jSONObject2);
                cw(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String m6 = m();
        this.jy = m6;
        if (!TextUtils.isEmpty(m6)) {
            ae.xt(new g("tt_pl_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.4
                @Override // java.lang.Runnable
                public void run() {
                    j jVar = j.this;
                    s<com.bytedance.sdk.openadsdk.core.jy.j> j6 = v.j();
                    j jVar2 = j.this;
                    jVar.vl = j6.j(jVar2.f30677j, jVar2.jy);
                    try {
                        JSONObject jSONObject3 = j.this.vl != null ? new JSONObject(j.this.vl.m()) : j.this.f30677j.ov() != null ? new JSONObject(j.this.f30677j.ov()) : new JSONObject();
                        jSONObject3.put("is_support_func_desc", "true");
                        jSONObject.put(Constants.JumpUrlConstants.SRC_TYPE_APP, jSONObject3);
                        jSONObject3.put("download_url", j.this.jy);
                        j.this.cw(jSONObject);
                    } catch (Throwable unused2) {
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = this.cw;
        if (jVar != null) {
            jVar.j(-4);
        }
    }

    private void tl() {
        if (this.oq == null) {
            com.bytedance.sdk.openadsdk.core.qv.xt.cw j6 = tl.j(this.ae, this.jy, this.f30677j, this.f30679r);
            this.oq = j6;
            j6.j(oq.j(this.f30677j));
            this.oq.j(this.f30676i, false);
            this.oq.xt(false);
        }
        this.oq.j(this.ae);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        n nVar = this.f30677j;
        if (nVar == null || ln.g(nVar) != 200) {
            return;
        }
        com.bytedance.adsdk.ugeno.xt.cw r5 = this.f30675g.r("video");
        if (r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt) r5;
            this.ws = xtVar;
            xtVar.up(true);
            g();
        }
        com.bytedance.adsdk.ugeno.xt.cw r6 = this.f30675g.r("mute");
        if (r6 instanceof com.bytedance.adsdk.ugeno.widget.image.xt) {
            this.az = (com.bytedance.adsdk.ugeno.widget.image.xt) r6;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(ed.cw(this.ae, 28.0f));
            shapeDrawable.setIntrinsicHeight(ed.cw(this.ae, 28.0f));
            this.az.g().setBackground(shapeDrawable);
        }
        com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = this.av;
        if (jVar != null) {
            j(jVar.tl);
        } else {
            j(true);
        }
    }

    protected void j(JSONObject jSONObject) {
    }

    public j(Activity activity, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.jy.up upVar, n nVar, String str, int i6, com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar) {
        this.f30677j = nVar;
        this.ae = activity;
        this.f30678m = upVar;
        this.tl = viewGroup;
        this.f30679r = str;
        this.up = i6;
        this.av = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(JSONObject jSONObject) {
        this.qv = jSONObject;
        r(jSONObject);
    }

    private void xt(boolean z5) {
        tl();
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.oq;
        if (cwVar instanceof com.bytedance.sdk.openadsdk.core.qv.cw.tl) {
            ((com.bytedance.sdk.openadsdk.core.qv.cw.tl) cwVar).m().j(z5);
        }
    }

    private void cw(boolean z5) {
        xt(false);
        r(z5);
    }

    private void cw(n nVar) {
        String g6;
        if (nVar == null) {
            return;
        }
        m et = nVar.et();
        r rVar = this.vl;
        if (rVar != null) {
            g6 = rVar.r();
        } else {
            g6 = et == null ? "" : et.g();
        }
        com.bytedance.sdk.openadsdk.core.rn.m.xt(this.ae, g6, nVar.fs(), new m.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.7
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                j.this.r(true);
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }
        });
    }

    private boolean xt(av avVar) {
        if (avVar == null) {
            return false;
        }
        View g6 = avVar.j().g();
        if (!(g6 instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) g6).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    public void j(com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar) {
        this.cw = jVar;
    }

    public void j() {
        this.xt = new xt(this.ae, this.f30678m, this.f30679r, this.up);
        if (this.f30677j.x() != null) {
            try {
                xt(new JSONObject(this.f30677j.x().toString()));
                return;
            } catch (JSONException e6) {
                vl.j(e6);
                return;
            }
        }
        int kt = this.f30677j.kt();
        if (kt != 5 && kt != 4) {
            com.bytedance.sdk.openadsdk.core.v.xt.j(this.f30677j.mi(), new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.1
                @Override // com.bytedance.sdk.openadsdk.core.v.xt.j
                public void j(JSONObject jSONObject) {
                    j.this.xt(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.v.xt.j
                public void j(int i6, String str) {
                    j.this.f30678m.j(-3, "ad meta info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = j.this.cw;
                    if (jVar != null) {
                        jVar.j(-3);
                    }
                }
            });
        } else {
            xt(new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z5) {
        tl();
        com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.ae, this.f30677j, "embeded_ad_landingpage", this.up);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
        this.oq.cw(z5);
        this.oq.j(this.f30677j, false);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.oq);
        this.oq.j(uf.mi(this.f30677j), false);
    }

    public void cw() {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.oq;
        if (cwVar != null) {
            cwVar.j();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = this.ws;
        if (xtVar != null) {
            xtVar.ya();
        }
    }

    private void xt(n nVar) {
        String ov;
        if (nVar == null) {
            return;
        }
        if (this.vl != null) {
            com.bytedance.sdk.openadsdk.core.tj.m et = nVar.et();
            if (et != null) {
                this.vl.j(et.r());
                this.vl.j(et.cw());
            }
            ov = this.vl.m();
        } else {
            ov = nVar.ov();
        }
        Activity activity = this.ae;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).cw();
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.ae, nVar.fs(), new m.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.6
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                j.this.r(true);
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }
        }, ov);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f30678m.xt();
        this.xt.j(this);
        this.xt.j(jSONObject, jSONObject2, new com.bytedance.sdk.openadsdk.core.ugeno.ae.ae() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(int i6, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = j.this.cw;
                if (jVar != null) {
                    jVar.j(i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                j.this.f30675g = cwVar;
                j.this.tl.addView(cwVar.g(), new FrameLayout.LayoutParams(cwVar.rn(), cwVar.wq()));
                com.bytedance.sdk.openadsdk.core.ugeno.r.j jVar = j.this.cw;
                if (jVar != null) {
                    jVar.j(cwVar.g());
                }
                j.this.up();
                j.this.j(cwVar);
            }
        });
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.oq;
        if (cwVar != null) {
            cwVar.xt();
        }
    }

    private void j(boolean z5) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = this.ws;
        if (xtVar != null) {
            xtVar.r(z5);
        }
        com.bytedance.adsdk.ugeno.widget.image.xt xtVar2 = this.az;
        if (xtVar2 == null || xtVar2.g() == null) {
            return;
        }
        kt.j((Context) this.ae, z5 ? "tt_mute" : "tt_unmute", (ImageView) this.az.g());
    }

    public void xt() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar = this.ws;
        if (xtVar != null) {
            xtVar.sm();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.cw.xt.j
    public void j(av avVar) {
        JSONObject cw;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar;
        if (avVar == null || avVar.xt() != 1 || (cw = avVar.cw()) == null) {
            return;
        }
        String optString = cw.optString("type");
        optString.getClass();
        switch (optString) {
            case "openAppPermission":
                j(this.f30677j);
                break;
            case "clickVideo":
                com.bytedance.sdk.openadsdk.core.ugeno.component.video.xt xtVar2 = this.ws;
                if (xtVar2 != null) {
                    xtVar2.ry();
                    break;
                }
                break;
            case "openAppFunctionDesc":
                cw(this.f30677j);
                break;
            case "downloadEvent":
                xt(true);
                r(xt(avVar));
                break;
            case "downloadDirect":
                cw(xt(avVar));
                break;
            case "muteVideo":
                if (this.az != null && (xtVar = this.ws) != null) {
                    j(!xtVar.tl());
                    break;
                }
                break;
            case "openAppPolicy":
                xt(this.f30677j);
                break;
            case "openInfringement":
                com.bytedance.sdk.openadsdk.core.rn.m.j(this.ae, this.f30679r, this.f30677j);
                break;
        }
    }

    private void j(n nVar) {
        String ov;
        if (nVar == null) {
            return;
        }
        if (this.vl != null) {
            com.bytedance.sdk.openadsdk.core.tj.m et = nVar.et();
            if (et != null) {
                this.vl.j(et.r());
                this.vl.j(et.cw());
            }
            ov = this.vl.m();
        } else {
            ov = nVar.ov();
        }
        Activity activity = this.ae;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).cw();
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.ae, nVar.fs(), ov, new m.j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.cw.j.5
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                j.this.r(true);
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                if (j.this.ae instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) j.this.ae).r();
                }
            }
        });
    }
}
