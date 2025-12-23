package com.bytedance.sdk.openadsdk.core.up.xt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public int f30934j;
    public Map<String, Boolean> xt;

    public static cw j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("error_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("result");
        if (optJSONObject == null) {
            return null;
        }
        Iterator<String> keys = optJSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, Boolean.valueOf(optJSONObject.optBoolean(next)));
        }
        cw cwVar = new cw();
        cwVar.xt = hashMap;
        cwVar.f30934j = optInt;
        return cwVar;
    }
}
