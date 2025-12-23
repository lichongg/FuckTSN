package com.bytedance.sdk.openadsdk.core.qv.cw.cw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.ae;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private j cw;

    /* renamed from: j, reason: collision with root package name */
    private n f29886j;
    private com.bytedance.sdk.openadsdk.core.qv.cw.j.j up;
    private Context xt;

    /* renamed from: r, reason: collision with root package name */
    private boolean f29888r = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f29887m = false;
    private int ae = 0;
    private boolean tl = false;

    public boolean r(boolean z5) {
        j jVar = this.cw;
        boolean z6 = true;
        if (jVar == null) {
            return true;
        }
        if (jVar instanceof xt) {
            xt xtVar = (xt) jVar;
            if (!z5 && !this.tl) {
                z6 = false;
            }
            xtVar.cw(z6);
            xtVar.xt(this.f29887m);
            xtVar.j(this.ae);
        }
        return this.cw.j();
    }

    public void cw(boolean z5) {
        this.tl = z5;
    }

    public void xt(boolean z5) {
        this.f29887m = z5;
    }

    public cw(Context context, n nVar) {
        this.xt = context;
        this.f29886j = nVar;
    }

    private void xt(final String str) {
        if (tj.w(this.f29886j) != 4) {
            return;
        }
        TTDelegateActivity.j(new ae() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(int i6, String str2) {
                cw.this.j(str, 1, str2);
                TTDelegateActivity.j((ae) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                cw.this.j(str, 0, "");
                TTDelegateActivity.j((ae) null);
            }
        });
    }

    public String cw(long j6) {
        return j6 <= 0 ? "-" : String.format("%.1fMB", Double.valueOf((j6 / 1024.0d) / 1024.0d));
    }

    private ae cw(final String str) {
        return new ae() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(int i6, String str2) {
                cw cwVar = cw.this;
                cwVar.j(cwVar.f29886j, str, 6, i6, str2);
                TTDelegateActivity.j((ae) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                cw cwVar2 = cw.this;
                cwVar2.j(cwVar2.f29886j, str, 5, 0, "");
                TTDelegateActivity.j((ae) null);
            }
        };
    }

    public void j(j jVar) {
        j(jVar, this.f29886j);
    }

    public String xt(long j6) {
        if (j6 >= 100000000) {
            return String.format("%d亿+", Long.valueOf(Math.round(j6 / 1.0E8d)));
        }
        if (j6 >= 10000) {
            return String.format("%d万+", Long.valueOf(Math.round(j6 / 10000.0d)));
        }
        if (j6 > 0) {
            return String.valueOf(j6);
        }
        return "-";
    }

    public void j(j jVar, n nVar) {
        this.cw = jVar;
        if (jVar == null) {
            return;
        }
        jVar.j(this.xt);
        jVar.j(nVar);
        jVar.j(this.f29888r);
    }

    private String r(String str) {
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        if (j6 == null) {
            return null;
        }
        return j6.xt(str, "");
    }

    public void j(boolean z5) {
        this.f29888r = z5;
    }

    private m.j xt(final String str, final com.bytedance.sdk.openadsdk.core.qv.cw.j.xt xtVar) {
        return new m.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw.4
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                com.bytedance.sdk.openadsdk.core.qv.cw.j.xt xtVar2 = xtVar;
                if (xtVar2 != null) {
                    xtVar2.j();
                }
                if (cw.this.up != null) {
                    cw.this.up.j();
                }
                m.xt = true;
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(cw.this.f29886j, str, "pop_up_download", cw.this.j());
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                com.bytedance.sdk.openadsdk.core.jy.cw.xt(cw.this.f29886j, str, "pop_up_cancel", cw.this.j());
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }
        };
    }

    public void j(com.bytedance.sdk.openadsdk.core.qv.cw.j.j jVar) {
        this.up = jVar;
    }

    public void j(int i6) {
        this.ae = i6;
    }

    public void j(String str, com.bytedance.sdk.openadsdk.core.qv.cw.j.xt xtVar) {
        if (this.f29886j == null) {
            return;
        }
        j((com.bytedance.sdk.openadsdk.core.tj.r) null, str, xtVar);
    }

    public void j(com.bytedance.sdk.openadsdk.core.tj.r rVar, final String str, final String str2, final com.bytedance.sdk.openadsdk.core.qv.cw.j.xt xtVar) {
        n nVar = this.f29886j;
        if (nVar == null) {
            return;
        }
        if (rVar == null && nVar.nu() == 2 && !(this.cw instanceof up)) {
            com.bytedance.sdk.component.oq.ae.xt(new g("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw.1
                @Override // java.lang.Runnable
                public void run() {
                    cw.this.j(v.j().j(cw.this.f29886j, str2), str, xtVar);
                }
            });
        } else {
            j(rVar, str, xtVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.tj.r rVar, String str, com.bytedance.sdk.openadsdk.core.qv.cw.j.xt xtVar) {
        JSONException jSONException;
        String ov;
        String xt;
        String str2;
        cw cwVar;
        String str3;
        m.j xt2 = xt(str, xtVar);
        try {
            if (rVar != null) {
                com.bytedance.sdk.openadsdk.core.tj.m et = this.f29886j.et();
                if (et != null) {
                    rVar.j(et.r());
                    rVar.j(et.cw());
                }
                ov = rVar.m();
                xt = rVar.j();
                str2 = rVar.cw();
            } else {
                try {
                    ov = this.f29886j.ov();
                    xt = oq.xt(this.f29886j);
                    h ig = this.f29886j.ig();
                    if (ig != null) {
                        str2 = ig.j();
                    } else {
                        str2 = "";
                    }
                } catch (JSONException e6) {
                    e = e6;
                    jSONException = e;
                    vl.j(jSONException);
                }
            }
            String str4 = str2;
            if (com.bytedance.sdk.openadsdk.core.ugeno.oq.vl(this.f29886j)) {
                try {
                    if (com.bytedance.sdk.openadsdk.core.ugeno.oq.j(this.xt, this.f29886j, xt)) {
                        cwVar = this;
                        str3 = str;
                    } else {
                        n nVar = this.f29886j;
                        try {
                            j(nVar, str, com.bytedance.sdk.openadsdk.core.ugeno.oq.xt(this.xt, nVar, xt), 0, "");
                            cwVar = this;
                            str3 = str;
                        } catch (JSONException e7) {
                            e = e7;
                            jSONException = e;
                            vl.j(jSONException);
                        }
                    }
                } catch (JSONException e8) {
                    jSONException = e8;
                    vl.j(jSONException);
                }
            } else {
                cwVar = this;
                str3 = str;
                try {
                    com.bytedance.sdk.openadsdk.core.jy.cw.xt(cwVar.f29886j, str3, "pop_up", j());
                } catch (JSONException e9) {
                    e = e9;
                    jSONException = e;
                    vl.j(jSONException);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", xt);
            jSONObject.put("dialog_icon_url", str4);
            jSONObject.put("dialog_app_description", cwVar.f29886j.zk());
            String j6 = j(ov);
            xt(str3);
            if (com.bytedance.sdk.openadsdk.core.ugeno.oq.j(cwVar.xt, cwVar.f29886j, xt)) {
                cwVar.j(str3, xt2, j6, str4, jSONObject);
                return;
            }
            cw cwVar2 = cwVar;
            try {
                com.bytedance.sdk.openadsdk.core.rn.m.j(cwVar2.xt, cwVar2.f29886j.fs(), j6, jSONObject.toString(), xt2, cwVar2.f29886j);
            } catch (JSONException e10) {
                e = e10;
                jSONException = e;
                vl.j(jSONException);
            }
        } catch (JSONException e11) {
            jSONException = e11;
        }
    }

    private String j(String str) {
        int w5 = tj.w(this.f29886j);
        try {
            if (w5 != 4) {
                if (w5 != 3) {
                    return str;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", tj.kt(this.f29886j));
            jSONObject2.put("ugen_md5", tj.tj(this.f29886j));
            jSONObject2.put("download_num", xt(this.f29886j.ja()));
            if (this.f29886j.by() == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put("app_size", cw(r1.ae()));
            jSONObject2.put("comment_num", j(r1.m()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, int i6, String str2) {
        JSONObject j6 = j();
        try {
            j6.put("ugen_dl_render_fail_msg", str2);
            j6.put("ugen_dl_render_fail", i6);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f29886j, str, "pop_up", j6);
    }

    public String j(long j6) {
        if (j6 >= 100000000) {
            return String.format("%d亿+", Long.valueOf(j6 / 100000000));
        }
        if (j6 >= 10000) {
            return String.format("%d万+", Long.valueOf(j6 / 10000));
        }
        if (j6 > 0) {
            return String.valueOf(j6);
        }
        return "-";
    }

    private void j(String str, m.j jVar, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.xt, this.f29886j.fs(), com.bytedance.sdk.openadsdk.core.ugeno.oq.j(this.xt, str2, this.f29886j, str3), jSONObject.toString(), jVar, cw(str), this.f29886j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(n nVar, String str, int i6, int i7, String str2) {
        JSONObject j6 = j();
        if (6 == i6) {
            try {
                j6.put("easy_dl_render_fail_code", i7);
                if (nVar != null) {
                    String cw = nVar.qn().cw();
                    j6.put("easy_dl_render_fail_msg", str2);
                    j6.put("easy_dl_render_fail_dsl", r(cw));
                }
            } catch (Exception unused) {
            }
        }
        j6.put("show_easy_dl_dialog_code", i6);
        com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.f29886j, str, "pop_up", j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            j jVar = this.cw;
            jSONObject.put("download_type", jVar != null ? jVar.xt() : 0);
            return jSONObject;
        } catch (Exception e6) {
            vl.j(e6);
            return jSONObject;
        }
    }
}
