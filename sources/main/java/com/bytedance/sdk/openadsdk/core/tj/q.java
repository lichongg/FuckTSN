package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class q {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30397j;

    /* renamed from: r, reason: collision with root package name */
    private int f30398r;
    private boolean xt;

    public void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("can_jump_to_landing", this.f30397j);
            jSONObject2.put("can_click_to_landing", this.xt);
            jSONObject2.put("auto_to_landing_type", this.cw);
            jSONObject2.put("auto_to_landing_time", this.f30398r);
            jSONObject.put("window_landing", jSONObject2);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.cw("parse json:" + e6.getMessage());
        }
    }

    public static String up(n nVar) {
        return nVar == null ? "" : nVar.yb();
    }

    public q(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("window_landing");
        if (optJSONObject == null) {
            return;
        }
        this.f30397j = optJSONObject.optBoolean("can_jump_to_landing", false);
        this.xt = optJSONObject.optBoolean("can_click_to_landing", false);
        this.cw = optJSONObject.optInt("auto_to_landing_type", 0);
        this.f30398r = optJSONObject.optInt("auto_to_landing_time", 0);
    }

    public static int cw(n nVar) {
        q f6 = e.f(nVar);
        if (f6 == null) {
            return 0;
        }
        return f6.cw;
    }

    public static int r(n nVar) {
        q f6 = e.f(nVar);
        if (f6 == null) {
            return 0;
        }
        return f6.f30398r;
    }

    public static boolean xt(n nVar) {
        q f6 = e.f(nVar);
        if (f6 == null) {
            return false;
        }
        return f6.xt;
    }

    public static boolean j(n nVar) {
        q f6 = e.f(nVar);
        if (f6 == null || !f6.f30397j || hh.j(nVar) == 1) {
            return false;
        }
        if (hh.j(nVar) == 2 && hh.xt(nVar) == 3) {
            return false;
        }
        if (hh.j(nVar) == 2 && hh.xt(nVar) == 7) {
            return false;
        }
        return (nVar.ve() == 5 || nVar.ve() == 15) && !TextUtils.isEmpty(up(nVar));
    }
}
