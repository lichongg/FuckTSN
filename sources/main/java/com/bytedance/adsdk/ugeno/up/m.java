package com.bytedance.adsdk.ugeno.up;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.t0;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private j f23758j;
    private List<j> xt;

    public static class j {
        private String cw = "global";

        /* renamed from: j, reason: collision with root package name */
        private String f23759j;

        /* renamed from: m, reason: collision with root package name */
        private Map<String, Object> f23760m;

        /* renamed from: r, reason: collision with root package name */
        private String f23761r;
        private Map<String, String> up;
        private String xt;

        public Map<String, String> cw() {
            return this.up;
        }

        public String j() {
            return this.cw;
        }

        public String r() {
            return this.f23759j;
        }

        public String xt() {
            return this.f23761r;
        }

        public void cw(String str) {
            this.f23759j = str;
        }

        public void j(String str) {
            this.cw = str;
        }

        public void r(String str) {
            this.xt = str;
        }

        public String toString() {
            return "Action{scheme='" + this.cw + "', name='" + this.f23761r + "', params=" + this.up + ", host='" + this.xt + "', origin='" + this.f23759j + "', extra=" + this.f23760m + '}';
        }

        public String up() {
            return this.xt;
        }

        public void xt(String str) {
            this.f23761r = str;
        }

        public void j(Map<String, String> map) {
            this.up = map;
        }
    }

    public j j() {
        return this.f23758j;
    }

    public static m j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        String optString = jSONObject.optString(t0.f49653d);
        JSONArray optJSONArray = jSONObject.optJSONArray("handlers");
        mVar.f23758j = vl.j(optString, jSONObject2);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            j j6 = vl.j(optJSONArray.optString(i6), jSONObject2);
            if (j6 != null) {
                arrayList.add(j6);
            }
        }
        mVar.xt = arrayList;
        return mVar;
    }

    public List<j> xt() {
        return this.xt;
    }
}
