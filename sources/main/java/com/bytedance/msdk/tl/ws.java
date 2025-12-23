package com.bytedance.msdk.tl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws {
    public static com.bytedance.msdk.api.cw j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.xt.cw cwVar, boolean z5) {
        if (cwVar == null || xtVar == null) {
            return null;
        }
        com.bytedance.msdk.api.cw cwVar2 = new com.bytedance.msdk.api.cw();
        cwVar2.j(cwVar.pz());
        cwVar2.tl(cwVar.ff());
        cwVar2.g(cwVar.ry());
        cwVar2.oq(cwVar.qa());
        cwVar2.vl(cwVar.q());
        if (z5) {
            if (j() || !(cwVar.qo() || cwVar.oy() || cwVar.yl())) {
                cwVar2.qv(cwVar.u());
            } else {
                cwVar2.qv("-3");
            }
        } else if (xt() || !cwVar.qo()) {
            cwVar2.qv(cwVar.wo());
        } else {
            cwVar2.qv("-3");
        }
        cwVar2.ws(cwVar.o());
        cwVar2.xt(cwVar.xw());
        cwVar2.jy(cwVar.e());
        cwVar2.j(j(xtVar));
        cwVar2.xt(j(cwVar));
        cwVar2.ae(xtVar.x());
        cwVar2.m(j(xtVar.e()));
        StringBuilder sb = new StringBuilder();
        sb.append(xtVar.q());
        cwVar2.cw(sb.toString());
        com.bytedance.msdk.api.r.m l6 = com.bytedance.msdk.core.j.qv().l();
        cwVar2.r(l6 != null ? l6.cw() : null);
        cwVar2.up(l6 != null ? l6.r() : null);
        Map<String, Object> c6 = xtVar.c();
        if (c6 != null && !c6.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : c6.entrySet()) {
                Object value = entry.getValue();
                hashMap.put(entry.getKey(), value == null ? null : value.toString());
            }
            cwVar2.j(hashMap);
        }
        return cwVar2;
    }

    private static boolean xt() {
        return com.bytedance.msdk.core.xt.xt().ch();
    }

    private static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optString("experiment_detail_id");
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    private static String j(com.bytedance.msdk.api.j.xt xtVar) {
        if (xtVar == null) {
            return null;
        }
        switch (xtVar.f()) {
        }
        return null;
    }

    private static String j(com.bytedance.msdk.xt.cw cwVar) {
        if (cwVar == null) {
            return null;
        }
        switch (cwVar.rh()) {
            case 1:
                break;
            case 2:
            case 7:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                int om = cwVar.om();
                if (om != 1) {
                    if (om != 5) {
                        if (om != 7) {
                        }
                    }
                }
                break;
        }
        return null;
    }

    private static boolean j() {
        return com.bytedance.msdk.core.xt.xt().v();
    }

    public static boolean j(List<com.bytedance.msdk.xt.cw> list, List<com.bytedance.msdk.xt.cw> list2, List<com.bytedance.msdk.xt.cw> list3, com.bytedance.msdk.api.j.xt xtVar, boolean z5, String str, int i6, List<com.bytedance.msdk.core.oq.oq> list4) {
        int xt = com.bytedance.msdk.cw.r.xt.xt(str);
        com.bytedance.msdk.up.m.j(list, list2, list3, xtVar, xt);
        if (z5 || xt != 0) {
            return false;
        }
        if (list.size() > 0) {
            for (com.bytedance.msdk.xt.cw cwVar : list) {
                if (cwVar != null) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(str, cwVar.qa()) + "isReady-》广告类型：" + com.bytedance.msdk.xt.j.j(cwVar.pz()) + ",是否已准备好？isReady()：" + cwVar.wq(str));
                    if (cwVar.wq(str) && !cwVar.qb()) {
                        return true;
                    }
                }
            }
        }
        if (list3 != null && list3.size() > 0) {
            for (com.bytedance.msdk.xt.cw cwVar2 : list3) {
                if (cwVar2 != null) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(str, cwVar2.qa()) + "isReady-》广告类型：" + com.bytedance.msdk.xt.j.j(cwVar2.pz()) + ",是否已准备好？isReady()：" + cwVar2.wq(str));
                    if (cwVar2.wq(str) && !cwVar2.qb()) {
                        return true;
                    }
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (com.bytedance.msdk.xt.cw cwVar3 : list2) {
                if (cwVar3 != null) {
                    com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, com.bytedance.msdk.j.up.up.xt(str, cwVar3.qa()) + "isReady--->biding-->广告类型：" + com.bytedance.msdk.xt.j.j(cwVar3.pz()) + ",是否已准备好？isReady()：" + cwVar3.wq(str));
                    if (cwVar3.wq(str) && !cwVar3.qb()) {
                        return true;
                    }
                }
            }
        }
        if (list4 != null && list4.size() > 0) {
            for (com.bytedance.msdk.core.oq.oq oqVar : list4) {
                String w5 = oqVar.w();
                if (oqVar.kt() && com.bytedance.msdk.core.up.j.j.j().r(str, w5, i6) && com.bytedance.msdk.core.up.j.j.j().j(w5, xtVar, false) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("show_adn_load_error_detail");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static com.bytedance.msdk.api.j j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.j jVar, List<com.bytedance.msdk.api.xt> list) {
        if (jVar != null && xtVar != null && list != null && list.size() != 0 && j(xtVar.c())) {
            JSONArray jSONArray = new JSONArray();
            for (com.bytedance.msdk.api.xt xtVar2 : list) {
                if (xtVar2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(MediationConstant.EXTRA_ADN_NAME, TextUtils.isEmpty(xtVar2.cw()) ? xtVar2.r() : xtVar2.cw());
                        jSONObject.put("mediation_rit", xtVar2.xt());
                        jSONObject.put("ad_type", xtVar2.j());
                        jSONObject.put("error_code", xtVar2.up());
                        jSONObject.put("error_msg", xtVar2.m());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e6) {
                        throw new RuntimeException(e6);
                    }
                }
            }
            jVar.xt = jSONArray.toString();
        }
        return jVar;
    }
}
