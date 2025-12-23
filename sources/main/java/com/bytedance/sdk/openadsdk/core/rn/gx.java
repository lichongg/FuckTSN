package com.bytedance.sdk.openadsdk.core.rn;

import android.util.Pair;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class gx extends com.bytedance.sdk.component.g.xt.up {
    public gx(com.bytedance.sdk.component.xt.j.vl vlVar) {
        super(vlVar);
    }

    public void cw(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.v.xt().ik()) {
            j(jSONObject, str);
        } else {
            cw(com.bytedance.sdk.component.utils.j.j(jSONObject).toString());
        }
    }

    public void j(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pair;
        Object obj;
        try {
            pair = com.bytedance.sdk.openadsdk.core.cw.m.j().j(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.cw(th.getMessage());
            pair = null;
        }
        if (pair != null && (obj = pair.first) != null) {
            if (((Integer) obj).intValue() == 4) {
                j("application/octet-stream", (byte[]) pair.second);
                j(true);
                xt("x-pglcypher", String.valueOf(pair.first));
                return;
            }
            j((JSONObject) pair.second);
            return;
        }
        cw(com.bytedance.sdk.component.utils.j.j(jSONObject).toString());
    }

    public void xt(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.v.xt().ka()) {
            j(jSONObject, str);
        } else {
            cw(com.bytedance.sdk.component.utils.j.j(jSONObject).toString());
        }
    }
}
