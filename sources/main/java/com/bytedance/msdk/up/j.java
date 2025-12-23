package com.bytedance.msdk.up;

import android.text.TextUtils;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.rn;
import com.bytedance.msdk.tl.v;
import com.bytedance.msdk.tl.x;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j implements com.bytedance.sdk.component.tl.xt.r.j.xt {
    public static final String cw = UUID.randomUUID().toString();

    /* renamed from: j, reason: collision with root package name */
    public final String f25248j;
    public final JSONObject xt;

    private static void cw(JSONObject jSONObject, r rVar) throws JSONException {
        if (jSONObject == null || rVar == null) {
            return;
        }
        if ("media_fill_fail".equals(rVar.f25313j) || "media_fill".equals(rVar.f25313j) || "bidding_adm_load".equals(rVar.f25313j) || "bidding_adm_load_fail".equals(rVar.f25313j) || "mediation_fill".equals(rVar.f25313j) || "mediation_request_end".equals(rVar.f25313j) || "mediation_video_cached".equals(rVar.f25313j) || "get_config_final".equals(rVar.f25313j) || "sdk_init_end".equals(rVar.f25313j) || "sdk_backstage".equals(rVar.f25313j) || "mediation_request".equals(rVar.f25313j) || "rit_map_query".equals(rVar.f25313j) || "return_bidding_result".equals(rVar.f25313j)) {
            jSONObject.putOpt("duration", Long.valueOf(rVar.f25317w));
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.r.j.xt
    public JSONObject j(String str) {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.tl.xt.r.j.xt
    public long xt() {
        JSONObject jSONObject = this.xt;
        if (jSONObject == null) {
            return 0L;
        }
        JSONObject optJSONObject = jSONObject.has("params") ? this.xt.optJSONObject("params") : this.xt;
        if (optJSONObject == null) {
            return 0L;
        }
        String optString = optJSONObject.optString("event_extra");
        if (TextUtils.isEmpty(optString)) {
            return 0L;
        }
        try {
            return new JSONObject(optString).optLong("eventIndex");
        } catch (JSONException unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.tl.xt.r.j.xt
    public long j() {
        JSONObject jSONObject = this.xt;
        if (jSONObject == null) {
            return 0L;
        }
        JSONObject optJSONObject = jSONObject.has("params") ? this.xt.optJSONObject("params") : this.xt;
        if (optJSONObject != null) {
            return optJSONObject.optLong("timestamp");
        }
        return 0L;
    }

    public String toString() {
        return "AdEvent{localId='" + this.f25248j + "', event=" + this.xt + '}';
    }

    public j(String str, JSONObject jSONObject) {
        this.f25248j = str;
        this.xt = jSONObject;
    }

    public static JSONObject j(r rVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("device_info", v.j());
            if (rVar != null) {
                jSONObject2.putOpt("type", rVar.f25313j);
                jSONObject2.putOpt("link_id", rVar.xt);
                jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, rVar.cw);
                jSONObject2.putOpt("ad_sdk_version", rVar.f25315r);
                jSONObject2.putOpt("rit_cpm", rVar.ae);
                jSONObject2.putOpt("mediation_rit", rVar.f25314m);
                jSONObject2.putOpt("adtype", Integer.valueOf(rVar.f25312i));
                jSONObject2.putOpt("error_msg", rVar.qv);
                jSONObject2.putOpt("error_code", Integer.valueOf(rVar.ws));
                jSONObject2.putOpt("creative_id", rVar.vl);
                jSONObject2.putOpt("exchange_rate", rVar.tj);
                jSONObject2.putOpt("msdk_session_id", cw);
                jSONObject2.putOpt("is_trusteeship_monetize", Integer.valueOf(com.bytedance.msdk.core.xt.xt().j()));
                String xt = com.bytedance.msdk.core.qv.j.j().xt(com.bytedance.msdk.core.xt.xt().jy());
                if (xt != null) {
                    jSONObject2.putOpt("app_abtest", xt);
                }
                j(jSONObject2, rVar);
                cw(jSONObject2, rVar);
                xt(rVar, jSONObject);
                if (!"total_load_fail".equalsIgnoreCase(rVar.f25313j) && !"adapter_request_fail".equalsIgnoreCase(rVar.f25313j)) {
                    jSONObject2.putOpt("req_id", TextUtils.isEmpty(rVar.up) ? rVar.xt + "_" + rVar.f25314m : rVar.up);
                }
                jSONObject2.putOpt("country", com.bytedance.msdk.core.xt.xt().tl());
                com.bytedance.msdk.core.oq.j j6 = com.bytedance.msdk.core.xt.xt().j(MediationConstant.ADN_PANGLE);
                if (j6 != null) {
                    jSONObject2.putOpt("app_id", j6.j());
                } else {
                    jSONObject2.putOpt("app_id", com.bytedance.msdk.core.j.qv().vl());
                }
                long j7 = rVar.f25311g;
                if (j7 != 0) {
                    jSONObject2.putOpt("waterfall_id", Long.valueOf(j7));
                }
                if (!TextUtils.isEmpty(rVar.oq)) {
                    jSONObject2.putOpt("version", rVar.oq);
                }
                Map<String, Object> map = rVar.f25310f;
                if (map != null && map.size() > 0) {
                    for (String str : rVar.f25310f.keySet()) {
                        Object obj = rVar.f25310f.get(str);
                        if (!TextUtils.isEmpty(str) && obj != null) {
                            jSONObject2.putOpt(str, obj);
                        }
                    }
                }
            }
            jSONObject2.putOpt("event_extra", jSONObject != null ? jSONObject.toString() : null);
            jSONObject2.putOpt("app_version", rn.cw());
            jSONObject2.putOpt("conn_type", Integer.valueOf(x.up()));
            xt(jSONObject2, rVar);
            jSONObject2.putOpt("mediation_sdk_version", com.bytedance.msdk.xt.xt.xt());
            jSONObject2.putOpt(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.xt.xt.r());
            try {
                jSONObject2.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.ch.j.j().j("DeviceRate", "bytebench_value")));
                return jSONObject2;
            } catch (NumberFormatException unused) {
                jSONObject2.put("device_score", -1);
                return jSONObject2;
            }
        } catch (Throwable th) {
            try {
                j(jSONObject2, th, rVar);
            } catch (Throwable unused2) {
            }
        }
    }

    private static void xt(JSONObject jSONObject, r rVar) throws JSONException {
        if (jSONObject == null || rVar == null) {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (TextUtils.equals(rVar.f25313j, "sdk_init")) {
            jSONObject.putOpt("timestamp", Long.valueOf(com.bytedance.msdk.api.r.oq.xt()));
            return;
        }
        if (TextUtils.equals(rVar.f25313j, "start_up")) {
            jSONObject.putOpt("timestamp", Long.valueOf(com.bytedance.msdk.api.r.oq.cw()));
        } else if (rVar.j() != -1) {
            jSONObject.putOpt("timestamp", Long.valueOf(rVar.j()));
        } else {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        }
    }

    public String cw() {
        if (TextUtils.isEmpty(this.f25248j) || this.xt == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.f25248j);
            jSONObject.putOpt("event", this.xt);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    private static void xt(r rVar, JSONObject jSONObject) {
        if (rVar != null) {
            if ("media_request".equals(rVar.f25313j) || "media_fill".equals(rVar.f25313j) || "media_fill_fail".equals(rVar.f25313j) || "get_bidding_adm_to_adn".equals(rVar.f25313j) || "bidding_adm_load".equals(rVar.f25313j) || "bidding_adm_load_fail".equals(rVar.f25313j) || "bidding_win_event".equals(rVar.f25313j) || "media_show_is_ready".equals(rVar.f25313j) || "media_will_show".equals(rVar.f25313j) || "media_show".equals(rVar.f25313j) || "media_show_fail".equals(rVar.f25313j) || "media_show_listen".equals(rVar.f25313j) || "media_show_fail_listen".equals(rVar.f25313j) || "media_click_listen".equals(rVar.f25313j) || "sdk_init".equals(rVar.f25313j) || "sdk_init_end".equals(rVar.f25313j) || "get_config_start".equals(rVar.f25313j) || "get_config_final".equals(rVar.f25313j) || "mediation_request".equals(rVar.f25313j) || "mediation_fill".equals(rVar.f25313j) || "mediation_request_end".equals(rVar.f25313j) || "total_load_fail".equals(rVar.f25313j)) {
                rVar.j("grouping_params", com.bytedance.msdk.core.ws.xt.xt());
                JSONObject cw2 = com.bytedance.msdk.core.ws.xt.cw();
                if (cw2 != null) {
                    rVar.j("user_defined_grouping_params", cw2.toString());
                } else {
                    rVar.j("user_defined_grouping_params", null);
                }
                com.bytedance.msdk.core.g.r.j(rVar.tl, rVar.f25313j, rVar.f25312i, jSONObject);
            }
        }
    }

    private static void j(JSONObject jSONObject, r rVar) throws JSONException {
        if (jSONObject == null || rVar == null) {
            return;
        }
        int i6 = rVar.mi;
        if (i6 != -1) {
            jSONObject.putOpt("result", Integer.valueOf(i6));
        }
        int i7 = rVar.kt;
        if (i7 != -1) {
            jSONObject.putOpt("status_code", Integer.valueOf(i7));
        }
        String str = rVar.av;
        if (str != null) {
            jSONObject.putOpt("show_sort", str);
        }
        String str2 = rVar.az;
        if (str2 != null) {
            jSONObject.putOpt("load_sort", str2);
        }
        String str3 = rVar.jy;
        if (str3 != null) {
            jSONObject.putOpt("req_bidding_type", str3);
        }
        jSONObject.putOpt(MediationConstant.KEY_GM_PRIME_RIT, rVar.tl);
    }

    private static void j(JSONObject jSONObject, Throwable th, r rVar) throws JSONException {
        if (jSONObject != null && th != null) {
            String optString = jSONObject.optString("event_extra");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                jSONObject2.putOpt("err_msg_comm", th.toString());
                jSONObject.putOpt("event_extra", jSONObject2.toString());
            }
        }
        if (rVar == null || th == null) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.putOpt("comm_eventId", rVar.f25310f.get("event_id"));
        jSONObject3.putOpt("err_msg_comm", th.toString());
        l.j(jSONObject3);
    }
}
