package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class hh {
    private rr ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30296j;

    /* renamed from: m, reason: collision with root package name */
    private aq f30297m;

    /* renamed from: r, reason: collision with root package name */
    private int f30298r;
    private JSONObject tl;
    private int up;
    private int xt;

    public static void j(n nVar, int i6) {
        hh oq = oq(nVar);
        if (oq == null) {
            return;
        }
        oq.f30296j = i6;
    }

    private static hh oq(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.q();
    }

    public hh(JSONObject jSONObject, String str, nd ndVar) {
        int i6;
        this.f30296j = 2;
        this.xt = 0;
        this.cw = 1;
        this.f30298r = 0;
        this.up = 100;
        if (jSONObject != null) {
            if (ndVar != null) {
                i6 = ndVar.f30364m;
            } else {
                i6 = 1;
            }
            this.f30296j = jSONObject.optInt("render_control", i6);
            JSONObject optJSONObject = jSONObject.optJSONObject("render");
            if (optJSONObject != null) {
                this.xt = optJSONObject.optInt("render_sequence", 0);
                this.cw = optJSONObject.optInt("backup_render_control", 1);
                this.f30298r = optJSONObject.optInt("render_thread", 0);
                this.up = optJSONObject.optInt("reserve_time", 100);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tpl_info");
            if (optJSONObject2 != null) {
                aq aqVar = new aq();
                aqVar.xt(optJSONObject2.optString("id"));
                aqVar.cw(optJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
                aqVar.r(optJSONObject2.optString("url"));
                aqVar.up(optJSONObject2.optString("data"));
                aqVar.m(optJSONObject2.optString("diff_data"));
                aqVar.ae(optJSONObject2.optString("dynamic_creative"));
                aqVar.j(optJSONObject2.optString("version"));
                aqVar.tl(optJSONObject2.optString("material_type"));
                aqVar.g(optJSONObject2.optString("ugen_url"));
                aqVar.oq(optJSONObject2.optString("ugen_md5"));
                aqVar.vl(optJSONObject2.optString("express_gesture_priority"));
                aqVar.qv(optJSONObject2.optString("engine_version"));
                this.f30297m = aqVar;
                com.bytedance.sdk.component.adexpress.j.cw.r j6 = j(str);
                if (j6 != null) {
                    com.bytedance.sdk.component.adexpress.j.xt.xt.j(j6);
                }
                if (!TextUtils.isEmpty(aqVar.g())) {
                    com.bytedance.sdk.openadsdk.core.ugeno.oq.j(aqVar);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("tpl_info_v3");
            if (optJSONObject3 != null) {
                rr j7 = rr.j(optJSONObject3);
                this.ae = j7;
                com.bytedance.sdk.openadsdk.core.nativeexpress.j.xt.j().j(j7, str, bi.az);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("dynamic_creative");
            if (optJSONObject4 != null) {
                this.tl = optJSONObject4;
            }
        }
    }

    public static rr ae(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return null;
        }
        return oq.ae;
    }

    public static int cw(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return 1;
        }
        return oq.cw;
    }

    public static com.bytedance.sdk.component.adexpress.j.cw.r g(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return null;
        }
        return oq.j(String.valueOf(com.bytedance.sdk.openadsdk.core.rn.uf.g(nVar)));
    }

    public static aq m(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return null;
        }
        return oq.f30297m;
    }

    public static int r(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return 0;
        }
        return oq.f30298r;
    }

    public static boolean tl(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return false;
        }
        aq aqVar = oq.f30297m;
        if (aqVar != null) {
            if (TextUtils.isEmpty(aqVar.qv())) {
                return false;
            }
            return true;
        }
        int i6 = oq.xt;
        if (i6 != 9 && i6 != 10) {
            return false;
        }
        return true;
    }

    public static int up(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return 100;
        }
        return oq.up;
    }

    public static int xt(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return 0;
        }
        return oq.xt;
    }

    public void j(JSONObject jSONObject) {
        try {
            jSONObject.put("render_control", this.f30296j);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("render_sequence", this.xt);
            jSONObject2.put("backup_render_control", this.cw);
            jSONObject2.put("render_thread", this.f30298r);
            jSONObject2.put("reserve_time", this.up);
            jSONObject.put("render", jSONObject2);
            if (this.f30297m != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", this.f30297m.xt());
                jSONObject3.put(TKDownloadReason.KSAD_TK_MD5, this.f30297m.cw());
                jSONObject3.put("url", this.f30297m.r());
                jSONObject3.put("data", this.f30297m.up());
                jSONObject3.put("diff_data", this.f30297m.m());
                jSONObject3.put("version", this.f30297m.j());
                jSONObject3.put("dynamic_creative", this.f30297m.ae());
                jSONObject3.put("material_type", this.f30297m.tl());
                jSONObject3.put("ugen_url", this.f30297m.g());
                jSONObject3.put("ugen_md5", this.f30297m.oq());
                jSONObject3.put("engine_version", this.f30297m.qv());
                jSONObject3.put("express_gesture_priority", this.f30297m.vl());
                jSONObject.put("tpl_info", jSONObject3);
            }
            jSONObject.put("dynamic_creative", this.tl);
            rr rrVar = this.ae;
            if (rrVar != null) {
                jSONObject.put("tpl_info_v3", rrVar.g());
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private com.bytedance.sdk.component.adexpress.j.cw.r j(String str) {
        aq aqVar = this.f30297m;
        if (aqVar == null) {
            return null;
        }
        String xt = aqVar.xt();
        String r5 = this.f30297m.r();
        String cw = this.f30297m.cw();
        String up = this.f30297m.up();
        return com.bytedance.sdk.component.adexpress.j.cw.r.j().j(xt).xt(cw).cw(r5).r(up).up(this.f30297m.j()).m(String.valueOf(str));
    }

    public static int j(n nVar) {
        hh oq = oq(nVar);
        if (oq == null) {
            return 2;
        }
        return oq.f30296j;
    }
}
