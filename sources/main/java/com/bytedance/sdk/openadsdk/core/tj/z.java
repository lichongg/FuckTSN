package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class z {
    private int ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30503j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f30504m;

    /* renamed from: r, reason: collision with root package name */
    private int f30505r;
    private int tl;
    private int up;
    private int xt;

    public void j(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("max_draw_play_time", this.xt);
            jSONObject2.put("draw_rewarded_play_time", this.cw);
            jSONObject2.put("skip_btn_left_style", this.f30505r);
            jSONObject2.put("skip_btn_right_style", this.up);
            jSONObject2.put("auto_slide", this.f30504m);
            jSONObject2.put("show_time_type", this.ae);
            jSONObject2.put("tip_time", this.tl);
            jSONObject.put("reward_draw", jSONObject2);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static z g(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.bl();
    }

    public z(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("reward_draw");
            if (optJSONObject != null) {
                this.xt = optJSONObject.optInt("max_draw_play_time", 10);
                this.cw = optJSONObject.optInt("draw_rewarded_play_time", 10);
                this.f30505r = optJSONObject.optInt("skip_btn_left_style", 0);
                this.up = optJSONObject.optInt("skip_btn_right_style", 0);
                this.f30504m = optJSONObject.optBoolean("auto_slide", false);
                this.ae = optJSONObject.optInt("show_time_type", 0);
                this.tl = optJSONObject.optInt("tip_time", 0);
            } else {
                this.xt = 10;
                this.cw = 10;
            }
            if (jSONObject.optJSONObject(d.K) != null) {
                this.f30503j = !TextUtils.isEmpty(r4.optString("group_id"));
            }
        }
    }

    public static int ae(n nVar) {
        z g6 = g(nVar);
        if (g6 == null) {
            return 10;
        }
        if (g6.ae == 1) {
            return Math.min((int) Math.max(ln.m(nVar), cw(nVar)), 60);
        }
        return cw(nVar);
    }

    public static int cw(n nVar) {
        int i6;
        z g6 = g(nVar);
        if (g6 == null || (i6 = g6.cw) <= 0) {
            return 10;
        }
        return i6;
    }

    public static boolean m(n nVar) {
        z g6 = g(nVar);
        if (g6 == null) {
            return false;
        }
        return g6.f30504m;
    }

    public static int r(n nVar) {
        z g6 = g(nVar);
        if (g6 == null) {
            return 0;
        }
        return g6.f30505r;
    }

    public static int tl(n nVar) {
        z g6 = g(nVar);
        if (g6 == null) {
            return 25;
        }
        return g6.tl;
    }

    public static int up(n nVar) {
        z g6 = g(nVar);
        if (g6 == null) {
            return 0;
        }
        return g6.up;
    }

    public static int xt(n nVar) {
        int i6;
        z g6 = g(nVar);
        if (g6 == null || (i6 = g6.xt) <= 0) {
            return 10;
        }
        return i6;
    }

    public static boolean j(n nVar) {
        z g6 = g(nVar);
        if (g6 == null) {
            return false;
        }
        return g6.f30503j;
    }
}
