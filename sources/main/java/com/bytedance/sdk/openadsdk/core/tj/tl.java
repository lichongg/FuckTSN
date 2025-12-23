package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    private static j cw;

    /* renamed from: j, reason: collision with root package name */
    private static j f30449j;
    private static j xt;

    public static class j {
        private int ae;
        private int cw;

        /* renamed from: g, reason: collision with root package name */
        private xt f30450g;

        /* renamed from: j, reason: collision with root package name */
        private int f30451j;

        /* renamed from: m, reason: collision with root package name */
        private boolean f30452m;
        private int oq;
        private boolean qv;

        /* renamed from: r, reason: collision with root package name */
        private int f30453r;
        private int tl;
        private int up;
        private int xt;

        public boolean ae() {
            return this.f30452m;
        }

        public int cw() {
            if (this.xt <= 0) {
                this.xt = 1;
            }
            return this.xt;
        }

        public int g() {
            return this.tl;
        }

        public String j() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.f30451j);
                jSONObject.put("max_count", this.xt);
                jSONObject.put("strategy_type", this.cw);
                jSONObject.put("store_type", this.f30453r);
                jSONObject.put("online_timeout", this.up);
                jSONObject.put("enable", this.f30452m);
                jSONObject.put("load_type", this.ae);
                jSONObject.put("trans_cache", this.tl);
                jSONObject.put("cache_check_type", this.oq);
                jSONObject.put("score_config", this.f30450g.j());
                jSONObject.put("disable_sdk_bidding", this.qv);
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public int m() {
            return this.up;
        }

        public int oq() {
            return this.oq;
        }

        public xt qv() {
            return this.f30450g;
        }

        public int r() {
            return this.cw;
        }

        public int tl() {
            return this.ae;
        }

        public int up() {
            return this.f30453r;
        }

        public int xt() {
            return this.f30451j;
        }

        public j(JSONObject jSONObject) {
            this.qv = false;
            if (jSONObject != null) {
                this.f30451j = jSONObject.optInt("get_type", 1);
                this.xt = jSONObject.optInt("max_count", 1);
                this.cw = jSONObject.optInt("strategy_type", -1);
                this.f30453r = jSONObject.optInt("store_type", 1);
                this.up = jSONObject.optInt("online_timeout", 10000);
                this.f30452m = jSONObject.optBoolean("enable", false);
                this.ae = jSONObject.optInt("load_type", -1);
                this.tl = jSONObject.optInt("trans_cache", 0);
                this.f30450g = new xt(jSONObject.optJSONObject("score_config"));
                this.oq = jSONObject.optInt("cache_check_type", 0);
                this.qv = jSONObject.optBoolean("disable_sdk_bidding", false);
            }
        }

        public boolean j(n nVar) {
            Map<String, Object> lg;
            Object obj;
            return (!this.qv || nVar == null || (lg = nVar.lg()) == null || lg.isEmpty() || (obj = lg.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) ? false : true;
        }
    }

    public static class xt {
        private int ae;
        private int cw;

        /* renamed from: g, reason: collision with root package name */
        private int f30454g;

        /* renamed from: j, reason: collision with root package name */
        private int f30455j;

        /* renamed from: m, reason: collision with root package name */
        private LinkedHashMap<Integer, Integer> f30456m;
        private int oq;
        private int qv;

        /* renamed from: r, reason: collision with root package name */
        private int f30457r;
        private int tl;
        private int up;
        private int xt;

        public int ae() {
            return this.ae;
        }

        public int cw() {
            return this.xt;
        }

        public int g() {
            return this.f30454g;
        }

        public JSONObject j() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.f30455j);
                jSONObject.put("net_type_threshold", this.xt);
                jSONObject.put("base_score", this.cw);
                jSONObject.put("score_threshold", this.f30457r);
                jSONObject.put("backup_score_threshold", this.up);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.f30456m;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.f30456m.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.f30456m.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
                jSONObject.put("freq_send_score", this.ae);
                jSONObject.put("freq_send_duration", this.tl);
                jSONObject.put("continuous_send_score", this.f30454g);
                jSONObject.put("continuous_send_count", this.oq);
                jSONObject.put("show_score", this.qv);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int m() {
            return this.tl;
        }

        public int oq() {
            return this.qv;
        }

        public int qv() {
            return this.cw;
        }

        public int r() {
            return this.f30457r;
        }

        public int tl() {
            return this.oq;
        }

        public int up() {
            return this.up;
        }

        public LinkedHashMap<Integer, Integer> vl() {
            return this.f30456m;
        }

        public int xt() {
            return this.f30455j;
        }

        public xt(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f30455j = jSONObject.optInt("device_score_threshold", 0);
                this.xt = jSONObject.optInt("net_type_threshold", 0);
                this.cw = jSONObject.optInt("base_score", 60);
                this.f30457r = jSONObject.optInt("score_threshold", 60);
                this.up = jSONObject.optInt("backup_score_threshold", 0);
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("last_cache_score");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i6);
                        int optInt = optJSONArray2.optInt(0);
                        int optInt2 = optJSONArray2.optInt(1);
                        if (optInt > 0) {
                            linkedHashMap.put(Integer.valueOf(optInt), Integer.valueOf(optInt2));
                        }
                    }
                }
                this.f30456m = linkedHashMap;
                this.ae = jSONObject.optInt("freq_send_score", 0);
                this.tl = jSONObject.optInt("freq_send_duration", 0);
                this.f30454g = jSONObject.optInt("continuous_send_score", 0);
                this.oq = jSONObject.optInt("continuous_send_count", 0);
                this.qv = jSONObject.optInt("show_score", 0);
            }
        }
    }

    public static void j(com.bytedance.sdk.component.r.j.xt xtVar) {
        try {
            f30449j = new j(new JSONObject(xtVar.xt("cache_strategy_reward", "")));
        } catch (JSONException unused) {
        }
        try {
            xt = new j(new JSONObject(xtVar.xt("cache_strategy_full", "")));
        } catch (JSONException unused2) {
        }
    }

    public static void xt(com.bytedance.sdk.component.r.j.xt xtVar) {
        j jVar = f30449j;
        if (jVar != null) {
            xtVar.j("cache_strategy_reward", jVar.j());
        }
        j jVar2 = xt;
        if (jVar2 != null) {
            xtVar.j("cache_strategy_full", jVar2.j());
        }
        if (cw != null) {
            com.bytedance.sdk.openadsdk.core.cw.r.j().xt("cache_strategy_splash", cw.j());
        }
    }

    public static j cw() {
        if (cw == null) {
            String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("cache_strategy_splash", (String) null);
            try {
                if (TextUtils.isEmpty(cw2)) {
                    j jVar = new j(new JSONObject());
                    cw = jVar;
                    jVar.f30453r = 0;
                } else {
                    cw = new j(new JSONObject(cw2));
                }
            } catch (JSONException unused) {
            }
        }
        return cw;
    }

    public static j j() {
        j jVar = f30449j;
        return jVar == null ? new j(new JSONObject()) : jVar;
    }

    public static void j(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("cache_strategy_reward");
            if (optJSONObject2 != null) {
                f30449j = new j(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("cache_strategy_full");
            if (optJSONObject3 != null) {
                xt = new j(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("cache_strategy_splash");
            if (optJSONObject3 != null) {
                cw = new j(optJSONObject4);
            }
        }
    }

    public static j xt() {
        j jVar = xt;
        return jVar == null ? new j(new JSONObject()) : jVar;
    }
}
