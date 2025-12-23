package com.bytedance.sdk.component.qv.cw;

import android.text.TextUtils;
import com.bytedance.sdk.component.qv.cw.j;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private String f26725j;

    /* renamed from: m, reason: collision with root package name */
    private JSONObject f26726m;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, j> f26727r = new HashMap();
    private j up;
    private String xt;

    private void j(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(d.ax);
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            j jVar = new j(optJSONArray.optJSONObject(i6));
            this.f26727r.put(jVar.j(), jVar);
            if (jVar.j().equals(jSONObject.optString("main"))) {
                this.up = jVar;
            }
        }
    }

    public String xt() {
        return this.xt;
    }

    public List<j> xt(j jVar, JSONObject jSONObject, Map<String, Object> map) {
        return j(jSONObject, map, jVar.m());
    }

    public cw(JSONObject jSONObject) {
        this.cw = false;
        String next = jSONObject.keys().next();
        this.xt = next;
        JSONObject optJSONObject = jSONObject.optJSONObject(next);
        this.f26725j = optJSONObject.optString("version");
        boolean optBoolean = optJSONObject.optBoolean("lazyLoad");
        this.cw = optBoolean;
        if (!optBoolean) {
            j(optJSONObject);
        } else {
            this.f26726m = optJSONObject;
        }
    }

    public List<j> cw(j jVar, JSONObject jSONObject, Map<String, Object> map) {
        List<j.C0416j> r5 = jVar.r();
        ArrayList arrayList = new ArrayList();
        for (j.C0416j c0416j : r5) {
            if (c0416j != null && j(c0416j.xt(), jSONObject, map)) {
                arrayList.add(j(c0416j.j()));
            }
        }
        return arrayList;
    }

    public j j(String str) {
        if (this.cw) {
            j(this.f26726m);
        }
        return this.f26727r.get(str);
    }

    public j j() {
        if (this.cw) {
            j(this.f26726m);
        }
        return this.up;
    }

    public List<j> j(j jVar, JSONObject jSONObject, Map<String, Object> map) {
        return j(jSONObject, map, jVar.up());
    }

    private List<j> j(JSONObject jSONObject, Map<String, Object> map, List<j.C0416j> list) {
        j j6;
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (j.C0416j c0416j : list) {
                if (c0416j != null && (j6 = j(c0416j.j())) != null && j(c0416j.xt(), jSONObject, map)) {
                    arrayList.add(j6);
                }
            }
        }
        return arrayList;
    }

    private static boolean j(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith("}")) {
                return Boolean.parseBoolean(com.bytedance.adsdk.xt.xt.j.j(str.substring(2, str.length() - 1)).j(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
