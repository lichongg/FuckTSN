package com.bytedance.msdk.j.cw;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.msdk.api.r.oq;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.cw.cw.xt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static String cw(Map<String, Object> map) {
        if (map == null || map.get("request_id") == null) {
            return null;
        }
        return (String) map.get("request_id");
    }

    public static boolean j(String str) {
        String cw = cw();
        return (TextUtils.isEmpty(cw) || TextUtils.isEmpty(str) || cw.compareTo(str) < 0) ? false : true;
    }

    public static long xt(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get(MediationConstant.EXTRA_ADID) != null) {
                return ((Long) map.get(MediationConstant.EXTRA_ADID)).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            vl.j(th);
            return 0L;
        }
    }

    static JSONArray cw(String str) {
        JSONArray jSONArray;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (Exception e6) {
            vl.j(e6);
            jSONArray = null;
        }
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static String j(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONArray = new JSONArray(str);
                    } catch (JSONException unused) {
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                int i6 = 0;
                while (true) {
                    if (i6 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                        if (optJSONObject != null && str2.equals(optJSONObject.getString(CommonNetImpl.NAME))) {
                            optJSONObject.put("value", str3);
                            break;
                        }
                        i6++;
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(CommonNetImpl.NAME, str2);
                        jSONObject.put("value", str3);
                        jSONArray.put(jSONObject);
                        break;
                    }
                }
                return jSONArray.toString();
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return str;
    }

    public static void xt(String str) {
        oq.xt(str);
    }

    private static Map<String, String> xt() {
        return oq.tl();
    }

    private static JSONArray xt(com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar) {
        if (jVar == null || TextUtils.isEmpty(jVar.f())) {
            return null;
        }
        try {
            return new JSONArray(jVar.f());
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    private static String cw() {
        try {
            return com.bytedance.sdk.gromore.init.j.cw();
        } catch (Throwable unused) {
            return cm.f10901d;
        }
    }

    public static double j(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Float) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        try {
            if (obj instanceof String) {
                return Double.valueOf((String) obj).doubleValue();
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static long j(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        try {
            if (map.get("creative_id") != null) {
                return ((Long) map.get("creative_id")).longValue();
            }
            return 0L;
        } catch (Throwable th) {
            vl.j(th);
            return 0L;
        }
    }

    public static String j() {
        return oq.ae();
    }

    public static JSONArray j(com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar) {
        JSONArray cw = cw(j());
        try {
            Map<String, String> xt = xt();
            if (xt != null && xt.size() > 0) {
                for (String str : xt.keySet()) {
                    String str2 = xt.get(str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.putOpt(CommonNetImpl.NAME, str);
                        jSONObject.putOpt("value", str2);
                        cw.put(jSONObject);
                    }
                }
            }
            JSONArray xt2 = xt(jVar);
            if (xt2 != null) {
                for (int i6 = 0; i6 < xt2.length(); i6++) {
                    JSONObject optJSONObject = xt2.optJSONObject(i6);
                    if (optJSONObject != null && !TextUtils.equals("personal_ads_type", optJSONObject.optString(CommonNetImpl.NAME))) {
                        cw.put(optJSONObject);
                    }
                }
            }
            return cw;
        } catch (Exception e6) {
            vl.j(e6);
            return cw;
        }
    }

    private static void j(xt.j jVar, String str, String str2, boolean z5, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar2) {
        JSONObject jSONObject;
        JSONArray j6 = j(jVar2);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(CommonNetImpl.NAME, "mediation_sdk_version");
            jSONObject2.putOpt("value", com.bytedance.msdk.xt.xt.xt());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt(CommonNetImpl.NAME, "mediation_req_type");
            jSONObject3.putOpt("value", "1");
            if (TextUtils.isEmpty(str)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                jSONObject.putOpt(CommonNetImpl.NAME, "waterfall_abtest");
                jSONObject.putOpt("value", str);
            }
            j6.put(jSONObject3);
            j6.put(jSONObject2);
            if (jSONObject != null) {
                j6.put(jSONObject);
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt(CommonNetImpl.NAME, "m_req_id");
                jSONObject4.putOpt("value", str2);
                j6.put(jSONObject4);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        if (!z5) {
            j(jVar);
        }
        com.bytedance.sdk.gromore.init.j.j(oq.m());
        if (jVar != null) {
            jVar.g(j6.toString());
        }
    }

    public static void j(xt.j jVar) {
        if (jVar != null && oq.g()) {
            try {
                String cw = oq.cw("tt_pangle_preview_ad_id");
                String cw2 = oq.cw("tt_pangle_preview_creative_id");
                String cw3 = oq.cw("tt_pangle_preview_ext");
                com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "pangle preview adId:" + cw + " creativeId:" + cw2 + " ext" + cw3);
                if (!TextUtils.isEmpty(cw) && !TextUtils.isEmpty(cw2)) {
                    jVar.j(cw).xt(cw2);
                }
                if (TextUtils.isEmpty(cw3)) {
                    return;
                }
                jVar.cw(cw3);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public static xt.j j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.cw.m.xt.xt xtVar2, boolean z5) {
        return j(xtVar, xtVar2.vl(), xtVar2.av(), xtVar2.i(), xtVar2.ch(), z5);
    }

    public static xt.j j(com.bytedance.msdk.api.j.xt xtVar, String str, String str2, String str3, String str4, boolean z5) {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar;
        xt.j cw = new xt.j().r(str).cw(1);
        if (xtVar != null) {
            cw.m(xtVar.xt()).ae(xtVar.v()).xt(xtVar.l());
            jVar = xtVar.tj();
            if (jVar != null) {
                cw.m(jVar.ws()).j(jVar.up()).r(jVar.s()).j(jVar.j()).xt(jVar.xt()).r(jVar.az()).j(jVar.v()).up(jVar.jy()).cw(jVar.cw());
                String mi = jVar.mi();
                if (!TextUtils.isEmpty(mi)) {
                    cw.ae(mi);
                }
                if (jVar.w() != 0) {
                    cw.m(jVar.w());
                }
            }
            int[] j6 = j(xtVar, jVar);
            if (j6 != null && j6.length > 0) {
                cw.j(j6);
            }
            if (5 == xtVar.f() || 9 == xtVar.f()) {
                cw.cw(xtVar.a());
            }
        } else {
            jVar = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            cw.tl(str4);
        }
        j(cw, str2, str3, z5, jVar);
        return cw;
    }

    private static int[] j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar) {
        if (jVar != null && jVar.i() != null && jVar.i().length > 0) {
            return jVar.i();
        }
        try {
            Map<String, Object> c6 = xtVar.c();
            if (c6 != null) {
                return (int[]) c6.get(MediationConstant.PANGLE_VID);
            }
            return null;
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    public static boolean j(com.bytedance.msdk.api.j.xt xtVar) {
        if (xtVar != null && xtVar.c() != null) {
            Object obj = xtVar.c().get(MediationConstant.BANNER_AUTO_HEIGHT);
            try {
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
