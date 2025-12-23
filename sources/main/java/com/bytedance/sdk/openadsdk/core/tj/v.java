package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class v {

    /* renamed from: j, reason: collision with root package name */
    public Map<String, j> f30464j = new HashMap();

    private static class j {
        public String cw;

        /* renamed from: j, reason: collision with root package name */
        public int f30465j;

        /* renamed from: r, reason: collision with root package name */
        public String f30466r;
        public String xt;

        public boolean xt() {
            return 3 == this.f30465j ? !TextUtils.isEmpty(this.f30466r) : !TextUtils.isEmpty(this.xt);
        }

        public JSONObject j() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f30465j);
                jSONObject.put("url", this.xt);
                jSONObject.put("pid", this.cw);
                jSONObject.put("ecom_live_params", this.f30466r);
                return jSONObject;
            } catch (JSONException e6) {
                throw new RuntimeException(e6);
            }
        }

        public j(JSONObject jSONObject) {
            try {
                this.f30465j = jSONObject.optInt("type");
                this.xt = jSONObject.optString("url");
                this.cw = jSONObject.optString("pid");
                this.f30466r = jSONObject.optString("ecom_live_params");
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, j> entry : this.f30464j.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().j());
            }
            jSONObject.put("sub_convert_link", jSONObject2);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public v(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("sub_convert_link");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    j jVar = new j(optJSONObject.optJSONObject(next));
                    if (jVar.xt()) {
                        this.f30464j.put(next, jVar);
                    }
                }
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    public static String cw(n nVar, String str) {
        j jVar;
        v j6 = j(nVar);
        if (j6 == null || (jVar = j6.f30464j.get(str)) == null) {
            return "";
        }
        return jVar.xt;
    }

    public static String r(n nVar, String str) {
        j jVar;
        v j6 = j(nVar);
        if (j6 == null || (jVar = j6.f30464j.get(str)) == null) {
            return "";
        }
        return jVar.cw;
    }

    public static String up(n nVar, String str) {
        j jVar;
        v j6 = j(nVar);
        if (j6 == null || (jVar = j6.f30464j.get(str)) == null) {
            return "";
        }
        return jVar.f30466r;
    }

    public static int xt(n nVar, String str) {
        j jVar;
        v j6 = j(nVar);
        if (j6 == null || (jVar = j6.f30464j.get(str)) == null) {
            return 0;
        }
        return jVar.f30465j;
    }

    private static v j(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.ne();
    }

    public static boolean j(n nVar, String str) {
        v j6 = j(nVar);
        return (j6 == null || !j6.f30464j.containsKey(str) || TextUtils.isEmpty(cw(nVar, str))) ? false : true;
    }
}
