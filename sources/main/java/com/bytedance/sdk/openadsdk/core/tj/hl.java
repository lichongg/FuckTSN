package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class hl {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private int f30299j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f30300m;

    /* renamed from: r, reason: collision with root package name */
    private int f30301r;
    private int up;
    private int xt;

    public static boolean cw(n nVar) {
        hl g6 = g(nVar);
        return g6 == null || !g6.f30300m || g6.f30299j == 1;
    }

    public static boolean r(n nVar) {
        int i6;
        hl g6 = g(nVar);
        return g6 != null && g6.f30300m && com.bytedance.sdk.openadsdk.core.live.xt.j().j(nVar) && ((i6 = g6.f30299j) == 3 || i6 == 4);
    }

    public static int xt(n nVar) {
        hl g6 = g(nVar);
        if (g6 == null) {
            return 1;
        }
        return g6.f30299j;
    }

    public void j(JSONObject jSONObject) {
        if (this.f30300m) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_live_type", this.f30299j);
                jSONObject2.put("reward_live_style", this.xt);
                jSONObject2.put("reward_live_text", this.cw);
                jSONObject2.put("reward_start_time", this.f30301r);
                jSONObject2.put("reward_close_time", this.up);
                jSONObject.put("reward_live", jSONObject2);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
            }
        }
    }

    private static hl g(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.zd();
    }

    public hl(JSONObject jSONObject) {
        this.f30300m = false;
        JSONObject optJSONObject = jSONObject.optJSONObject("reward_live");
        if (optJSONObject != null) {
            this.f30300m = true;
            xt(optJSONObject.optInt("reward_live_type", 1));
            cw(optJSONObject.optInt("reward_live_style", 1));
            j(optJSONObject.optString("reward_live_text"));
            j(optJSONObject.optInt("reward_start_time", 5));
            r(optJSONObject.optInt("reward_close_time", 10));
        }
    }

    public static int ae(n nVar) {
        hl g6 = g(nVar);
        if (g6 == null) {
            return 5;
        }
        return Math.max(g6.f30301r, 0);
    }

    public static String m(n nVar) {
        hl g6 = g(nVar);
        if (g6 == null) {
            return "去抖音观看直播\n可提前5s获得奖励哦";
        }
        return g6.cw;
    }

    public static int tl(n nVar) {
        hl g6 = g(nVar);
        if (g6 == null) {
            return 10;
        }
        return Math.max(g6.up, 3);
    }

    public static int up(n nVar) {
        hl g6 = g(nVar);
        if (g6 == null) {
            return 1;
        }
        return g6.xt;
    }

    private void xt(int i6) {
        if (i6 != 2 && i6 != 3 && i6 != 4 && i6 != 1) {
            i6 = 1;
        }
        this.f30299j = i6;
    }

    private void cw(int i6) {
        if (i6 != 1 && i6 != 2 && i6 != 3) {
            i6 = 1;
        }
        this.xt = i6;
    }

    private void r(int i6) {
        if (i6 <= 3) {
            i6 = 3;
        }
        this.up = i6;
    }

    public static boolean j(n nVar) {
        hl g6 = g(nVar);
        if (g6 == null) {
            return false;
        }
        return g6.f30300m;
    }

    private void j(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.xt == 3) {
                str = "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦";
            } else {
                str = "去抖音观看直播\n可提前5s获得奖励哦";
            }
        }
        this.cw = str;
    }

    public void j(int i6) {
        this.f30301r = i6;
    }
}
