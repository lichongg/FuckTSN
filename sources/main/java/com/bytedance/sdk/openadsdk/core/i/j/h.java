package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class h extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private n f29135j;

    public static void j(com.bytedance.sdk.component.j.i iVar, n nVar) {
        iVar.j("sendEventCode", (com.bytedance.sdk.component.j.up<?, ?>) new h(nVar));
    }

    public h(n nVar) {
        this.f29135j = nVar;
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        com.bytedance.sdk.openadsdk.i.cw.j.xt xtVar;
        JSONObject jSONObject2 = new JSONObject();
        n nVar = this.f29135j;
        if (nVar != null && (xtVar = (com.bytedance.sdk.openadsdk.i.cw.j.xt) com.bytedance.sdk.openadsdk.core.x.j(nVar.uv(), com.bytedance.sdk.openadsdk.i.cw.j.xt.class)) != null) {
            HashMap hashMap = new HashMap();
            int optInt = jSONObject.optInt("event_code", -1);
            if (optInt >= 200) {
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.opt(next));
                    }
                }
                xtVar.j(optInt, hashMap);
            }
        }
        return jSONObject2;
    }
}
