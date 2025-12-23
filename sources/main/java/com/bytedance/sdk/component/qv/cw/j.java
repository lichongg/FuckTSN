package com.bytedance.sdk.component.qv.cw;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private String f26728j;
    private String xt;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, String> f26730r = new HashMap();
    private List<C0416j> up = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final List<C0416j> f26729m = new ArrayList();
    private final List<C0416j> ae = new ArrayList();

    /* renamed from: com.bytedance.sdk.component.qv.cw.j$j, reason: collision with other inner class name */
    public static class C0416j {

        /* renamed from: j, reason: collision with root package name */
        private String f26731j;
        private String xt;

        public String j() {
            return this.f26731j;
        }

        public String xt() {
            return this.xt;
        }

        public C0416j(String str, String str2) {
            this.f26731j = str;
            this.xt = str2;
        }
    }

    public String j() {
        return this.f26728j;
    }

    public Map<String, String> cw() {
        return this.f26730r;
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f26728j = jSONObject.optString(CommonNetImpl.NAME);
        this.cw = jSONObject.optInt("index");
        this.xt = jSONObject.optString("scheme");
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.f26730r.put(next, optJSONObject.optString(next));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("next");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                if (optJSONObject2 != null) {
                    this.up.add(new C0416j(optJSONObject2.optString(CommonNetImpl.NAME), optJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("next");
            if (optJSONObject3 != null) {
                this.up.add(new C0416j(optJSONObject3.optString(CommonNetImpl.NAME), optJSONObject3.optString("condition")));
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("callback");
        if (optJSONObject4 == null) {
            optJSONObject4 = new JSONObject();
        }
        JSONArray optJSONArray2 = optJSONObject4.optJSONArray("success");
        if (optJSONArray2 == null) {
            optJSONArray2 = new JSONArray();
        }
        for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
            JSONObject optJSONObject5 = optJSONArray2.optJSONObject(i7);
            if (optJSONObject5 != null) {
                this.f26729m.add(new C0416j(optJSONObject5.optString(CommonNetImpl.NAME), optJSONObject5.optString("condition")));
            }
        }
        JSONArray optJSONArray3 = optJSONObject4.optJSONArray(CommonNetImpl.FAIL);
        if (optJSONArray3 == null) {
            optJSONArray3 = new JSONArray();
        }
        for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
            JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i8);
            if (optJSONObject6 != null) {
                this.ae.add(new C0416j(optJSONObject6.optString(CommonNetImpl.NAME), optJSONObject6.optString("condition")));
            }
        }
    }

    public List<C0416j> m() {
        return this.ae;
    }

    public List<C0416j> r() {
        return this.up;
    }

    public List<C0416j> up() {
        return this.f26729m;
    }

    public String xt() {
        return this.xt;
    }

    public j(JSONObject jSONObject) {
        j(jSONObject);
    }
}
