package com.bytedance.msdk.core.xt;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    public static void j(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.api.j.xt xtVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.xt.xt().ed()) {
            String v5 = xtVar != null ? xtVar.v() : null;
            xt gx = com.bytedance.msdk.core.xt.xt().gx();
            if (gx != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("lt_days", Integer.valueOf(gx.j()));
                    jSONObject.putOpt("rule_id", gx.cw(v5));
                } catch (Exception e6) {
                    com.bytedance.msdk.j.up.cw.r("AdLoadEventManager", "put 元素 异常：" + e6.getMessage());
                }
                try {
                    jSONObject.putOpt("score", Float.valueOf(com.bytedance.msdk.core.j.qv().j(v5)));
                } catch (Exception e7) {
                    com.bytedance.msdk.j.up.cw.r("AdLoadEventManager", "put 元素异常：" + e7.getMessage());
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("dis_c", Integer.valueOf(j.xt(v5)));
                    jSONObject2.putOpt("ins_d", Integer.valueOf(j.up()));
                    jSONObject2.putOpt("act_d", Integer.valueOf(j.xt()));
                    jSONObject2.putOpt("act_times", Integer.valueOf(j.r()));
                    jSONObject.putOpt("active_target", jSONObject2);
                } catch (Exception e8) {
                    com.bytedance.msdk.j.up.cw.r("AdLoadEventManager", "put 元素异常：" + e8.getMessage());
                }
                if (xtVar != null && xtVar.c() != null) {
                    Map<String, Object> c6 = xtVar.c();
                    if (c6.containsKey(MediationConstant.KEY_USE_POLICY)) {
                        try {
                            jSONObject.putOpt("user_enter", c6.get(MediationConstant.KEY_USE_POLICY));
                        } catch (Exception e9) {
                            com.bytedance.msdk.j.up.cw.r("AdLoadEventManager", "put 元素异常：" + e9.getMessage());
                        }
                    }
                }
                map.put("dynamic_policy", jSONObject);
            }
        }
    }
}
