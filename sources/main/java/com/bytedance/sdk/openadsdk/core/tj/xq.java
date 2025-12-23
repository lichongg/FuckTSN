package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xq {
    private int ae;
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30493j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f30494m;

    /* renamed from: r, reason: collision with root package name */
    private String f30495r;
    private String up;
    private int xt;

    public static boolean g(n nVar) {
        if (nVar == null || nVar.ig() == null || !nVar.ig().up() || nVar.fp() == null || nVar.fp().isEmpty() || !nVar.fp().get(0).up() || TextUtils.isEmpty(nVar.hw())) {
            return false;
        }
        if (TextUtils.isEmpty(nVar.rs())) {
            return (nVar.by() == null || TextUtils.isEmpty(nVar.by().cw())) ? false : true;
        }
        return true;
    }

    public static void xt(n nVar) {
        xq oq = oq(nVar);
        if (oq == null || nVar.vu() || nVar.zw() == 2 || !oq.f30494m || xt() >= com.bytedance.sdk.openadsdk.core.v.xt().m110if()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.cw(nVar, "splash_ad", "if_splash_card");
        if (g(nVar)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.cw(nVar, "splash_ad", "card_show_fail");
    }

    public void j(JSONObject jSONObject) {
        try {
            if (this.f30494m) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("click_on_close", this.f30493j);
                jSONObject2.put("card_stay_count_down", this.xt);
                jSONObject2.put("card_click_area", this.cw);
                jSONObject2.put("card_text", this.up);
                jSONObject2.put("card_top_text", this.f30495r);
                jSONObject2.put("splash_card_style_id", this.ae);
                jSONObject.put("splash_card", jSONObject2);
            }
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static xq oq(n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.xq();
    }

    public xq(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("splash_card")) != null) {
            this.f30494m = true;
            this.f30493j = optJSONObject.optBoolean("click_on_close", false);
            this.xt = optJSONObject.optInt("card_stay_count_down", 5);
            this.cw = optJSONObject.optInt("card_click_area", 2);
            this.up = optJSONObject.optString("card_text", "详情页或第三方应用");
            int optInt = optJSONObject.optInt("splash_card_style_id", 0);
            this.ae = optInt;
            if (optInt == 1) {
                this.f30495r = optJSONObject.optString("card_top_text", "摇一摇或点击了解更多");
            } else {
                this.f30495r = optJSONObject.optString("card_top_text", "点击跳转");
            }
        }
    }

    public static boolean ae(n nVar) {
        xq oq = oq(nVar);
        if (oq == null || oq.cw == 1) {
            return true;
        }
        return false;
    }

    public static String cw(n nVar) {
        xq oq = oq(nVar);
        if (oq == null || TextUtils.isEmpty(oq.up)) {
            return "详情页或第三方应用";
        }
        return oq.up;
    }

    public static int m(n nVar) {
        int i6;
        xq oq = oq(nVar);
        if (oq == null || (i6 = oq.xt) <= 0 || i6 > 5) {
            return 5;
        }
        return i6;
    }

    public static String r(n nVar) {
        xq oq = oq(nVar);
        if (oq == null) {
            return "点击跳转";
        }
        if (up(nVar) == 1) {
            if (TextUtils.isEmpty(oq.f30495r)) {
                return "摇一摇或点击了解更多";
            }
            return oq.f30495r;
        }
        if (TextUtils.isEmpty(oq.f30495r)) {
            return "点击跳转";
        }
        return oq.f30495r;
    }

    public static boolean tl(n nVar) {
        xq oq = oq(nVar);
        if (oq == null) {
            return true;
        }
        return oq.f30493j;
    }

    public static int up(n nVar) {
        xq oq = oq(nVar);
        if (oq == null) {
            return 0;
        }
        return oq.ae;
    }

    public static int xt() {
        int i6 = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.rn.h.j(null);
        int xt = j6.xt("splash_card_show_day", -1);
        int xt2 = j6.xt("splash_card_show_count", 0);
        if (xt == i6) {
            return xt2;
        }
        return 0;
    }

    public static boolean j(n nVar) {
        xq oq = oq(nVar);
        if (oq != null && !nVar.vu() && nVar.zw() != 2 && oq.f30494m && xt() < com.bytedance.sdk.openadsdk.core.v.xt().m110if() && g(nVar)) {
            return oq.f30494m;
        }
        return false;
    }

    public static void j() {
        int i6 = Calendar.getInstance().get(7);
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.rn.h.j(null);
        int xt = j6.xt("splash_card_show_day", -1) == i6 ? j6.xt("splash_card_show_count", 0) : 0;
        j6.j("splash_card_show_day", i6);
        j6.j("splash_card_show_count", xt + 1);
    }
}
