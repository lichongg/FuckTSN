package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ol {

    /* renamed from: j, reason: collision with root package name */
    private int f30366j;

    public void j(JSONObject jSONObject) {
        try {
            jSONObject.put("playable_reward_type", this.f30366j);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static ol xt(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.e();
    }

    public ol(JSONObject jSONObject) {
        this.f30366j = 0;
        if (jSONObject == null) {
            return;
        }
        this.f30366j = jSONObject.optInt("playable_reward_type", 0);
    }

    public static int j(n nVar) {
        int i6;
        ol xt = xt(nVar);
        if (xt == null || (i6 = xt.f30366j) < 0 || i6 > 1) {
            return 0;
        }
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.v.xt().ed()) || kt.qv(nVar)) {
            return xt.f30366j;
        }
        return 1;
    }

    public static int j(n nVar, int i6) {
        com.bykv.vk.openvk.component.video.api.cw.cw j6 = ln.j(nVar, i6);
        String g6 = j6 != null ? j6.g() : null;
        if (TextUtils.isEmpty(g6)) {
            return 0;
        }
        String[] split = g6.split("x");
        if (split.length < 2) {
            return 0;
        }
        return Integer.parseInt(split[0]) > Integer.parseInt(split[1]) ? 1 : 0;
    }
}
