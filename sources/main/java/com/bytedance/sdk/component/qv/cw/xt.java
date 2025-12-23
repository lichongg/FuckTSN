package com.bytedance.sdk.component.qv.cw;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public enum xt {
    INSTANCE;

    private Map<String, cw> xt = new HashMap();

    public cw j(String str) {
        return this.xt.get(str);
    }

    public void j(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                String next = keys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
                cw cwVar = new cw(jSONObject2);
                this.xt.put(cwVar.xt(), cwVar);
            } catch (JSONException unused) {
            }
        }
    }

    xt() {
    }
}
