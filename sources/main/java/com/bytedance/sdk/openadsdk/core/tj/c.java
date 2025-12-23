package com.bytedance.sdk.openadsdk.core.tj;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class c {
    private JSONArray ae;
    private boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private xt f30227g;

    /* renamed from: j, reason: collision with root package name */
    private String f30228j;

    /* renamed from: m, reason: collision with root package name */
    private String f30229m;
    private j oq;

    /* renamed from: r, reason: collision with root package name */
    private String f30230r;
    private int tl;
    private String up;
    private boolean xt;

    public static class j {
        double cw;

        /* renamed from: j, reason: collision with root package name */
        String f30231j;

        /* renamed from: r, reason: collision with root package name */
        double f30232r;
        String xt;

        public static j j(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            j jVar = new j();
            jVar.f30231j = jSONObject.optString("title");
            jVar.xt = jSONObject.optString(SocializeProtocolConstants.IMAGE);
            jVar.f30232r = jSONObject.optDouble("price");
            jVar.cw = jSONObject.optDouble("origin_price");
            return jVar;
        }

        public double cw() {
            return this.cw;
        }

        public double r() {
            return this.f30232r;
        }

        public JSONObject up() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.f30231j);
                jSONObject.put(SocializeProtocolConstants.IMAGE, this.xt);
                jSONObject.put("price", this.f30232r);
                jSONObject.put("origin_price", this.cw);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public String xt() {
            return this.xt;
        }

        public String j() {
            return this.f30231j;
        }
    }

    public static class xt {

        /* renamed from: j, reason: collision with root package name */
        int f30233j;
        int xt;

        public static xt j(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            xt xtVar = new xt();
            xtVar.f30233j = jSONObject.optInt("amount");
            xtVar.xt = jSONObject.optInt("threshold");
            return xtVar;
        }

        public JSONObject cw() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("amount", this.f30233j);
                jSONObject.put("threshold", this.xt);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public int xt() {
            return this.xt;
        }

        public int j() {
            return this.f30233j;
        }
    }

    public static c j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f30228j = jSONObject.optString("promotion_id");
        cVar.xt = jSONObject.optBoolean("is_silent_auth", false);
        cVar.cw = jSONObject.optBoolean("enable_playable_auth", false);
        cVar.f30230r = jSONObject.optString("aweme_agreements");
        cVar.up = jSONObject.optString("aweme_privacy");
        cVar.f30229m = jSONObject.optString("live_csj_libra_param");
        cVar.ae = jSONObject.optJSONArray("tasks");
        cVar.tl = jSONObject.optInt("live_playable");
        cVar.oq = j.j(jSONObject.optJSONObject("product"));
        cVar.f30227g = xt.j(jSONObject.optJSONObject("coupon"));
        return cVar;
    }

    public String ae() {
        return this.f30229m;
    }

    public boolean cw() {
        return this.xt;
    }

    public boolean g() {
        return this.tl == 2 && this.cw;
    }

    public String m() {
        return this.up;
    }

    public xt oq() {
        return this.f30227g;
    }

    public j qv() {
        return this.oq;
    }

    public boolean r() {
        return this.cw;
    }

    public JSONArray tl() {
        return this.ae;
    }

    public String up() {
        return this.f30230r;
    }

    public String xt() {
        return this.f30228j;
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.f30228j);
            jSONObject.put("is_silent_auth", this.xt);
            jSONObject.put("enable_playable_auth", this.cw);
            jSONObject.put("aweme_agreements", this.f30230r);
            jSONObject.put("aweme_privacy", this.up);
            jSONObject.put("live_csj_libra_param", this.f30229m);
            jSONObject.put("tasks", this.ae);
            jSONObject.put("live_playable", this.tl);
            j jVar = this.oq;
            if (jVar != null) {
                jSONObject.put("product", jVar.up());
            }
            xt xtVar = this.f30227g;
            if (xtVar != null) {
                jSONObject.put("coupon", xtVar.cw());
            }
            return jSONObject;
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }
}
