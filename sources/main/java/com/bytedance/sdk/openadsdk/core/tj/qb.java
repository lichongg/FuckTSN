package com.bytedance.sdk.openadsdk.core.tj;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qb {
    private long cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30401j;

    /* renamed from: r, reason: collision with root package name */
    private int f30402r;
    private int up;
    private int xt;

    public static qb j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        qb qbVar = new qb();
        qbVar.f30401j = jSONObject.optInt("auth_type");
        qbVar.xt = jSONObject.optInt("auth_time");
        qbVar.cw = jSONObject.optLong("auth_out_time");
        qbVar.f30402r = jSONObject.optInt("video_open_deeplink");
        qbVar.up = jSONObject.optInt("reject_in");
        return qbVar;
    }

    public int cw() {
        return this.xt;
    }

    public int m() {
        return this.up;
    }

    public int r() {
        return this.f30402r;
    }

    public long up() {
        return this.cw;
    }

    public int xt() {
        return this.f30401j;
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.f30401j);
            jSONObject.put("auth_time", this.xt);
            jSONObject.put("auth_out_time", this.cw);
            jSONObject.put("video_open_deeplink", this.f30402r);
            jSONObject.put("reject_in", this.up);
            return jSONObject;
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }
}
