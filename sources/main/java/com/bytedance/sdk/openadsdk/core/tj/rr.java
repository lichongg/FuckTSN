package com.bytedance.sdk.openadsdk.core.tj;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class rr {
    private String ae;
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private String f30420j;

    /* renamed from: m, reason: collision with root package name */
    private int f30421m;

    /* renamed from: r, reason: collision with root package name */
    private String f30422r;
    private String tl;
    private JSONObject up;
    private String xt;

    public String j() {
        return this.f30420j;
    }

    public static rr j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        rr rrVar = new rr();
        rrVar.f30420j = jSONObject.optString("id");
        rrVar.f30422r = jSONObject.optString("data");
        rrVar.cw = jSONObject.optString("url");
        rrVar.xt = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        rrVar.ae = jSONObject.optString("express_gesture_priority");
        rrVar.f30421m = jSONObject.optInt("material_type");
        rrVar.up = jSONObject.optJSONObject("custom_components");
        rrVar.tl = jSONObject.optString("rule_id");
        return rrVar;
    }

    public int ae() {
        return this.f30421m;
    }

    public String cw() {
        return this.cw;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f30420j);
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, this.xt);
            jSONObject.put("url", this.cw);
            jSONObject.put("data", this.f30422r);
            jSONObject.put("material_type", this.f30421m);
            jSONObject.put("custom_components", this.up);
            jSONObject.put("express_gesture_priority", this.ae);
            jSONObject.put("rule_id", this.tl);
            return jSONObject;
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    public String m() {
        return this.ae;
    }

    public String r() {
        return this.f30422r;
    }

    public String tl() {
        return this.tl;
    }

    public JSONObject up() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }
}
