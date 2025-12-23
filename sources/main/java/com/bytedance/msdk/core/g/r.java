package com.bytedance.msdk.core.g;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    public static final Map<String, com.bytedance.msdk.core.oq.xt> f24465j = new ConcurrentHashMap();

    public static void j(int i6, String str, int i7, double d6) {
        com.bytedance.msdk.core.oq.xt j6;
        com.bytedance.msdk.core.oq.r up;
        if (com.bytedance.msdk.core.xt.xt().hl() && (j6 = com.bytedance.msdk.core.xt.xt().j(str, i7, 101)) != null) {
            if (j6.m() == 1 && i6 == 1) {
                up.r().j(i7, d6);
                return;
            }
            if (j6.m() != 2 || (up = com.bytedance.msdk.core.xt.xt().up(str)) == null) {
                return;
            }
            if (i6 == 2 && up.cw() == 2) {
                xt.r().j(str, 2, d6);
            } else {
                if (i6 != 1 || up.cw() == 2) {
                    return;
                }
                xt.r().j(str, up.cw(), d6);
            }
        }
    }

    public static void j(com.bytedance.msdk.core.oq.xt xtVar, double d6, String str, int i6) {
        if (!com.bytedance.msdk.core.xt.xt().hl() || xtVar == null) {
            return;
        }
        if (xtVar.m() == 2) {
            j(2, str, i6, d6);
        } else if (xtVar.m() == 3 || xtVar.m() == 4) {
            xt.r().j(xtVar.rn(), "_last_load_cpm_", xtVar.la(), d6);
        }
    }

    public static void j(String str, String str2, int i6, JSONObject jSONObject) {
        com.bytedance.msdk.core.oq.xt j6;
        if (com.bytedance.msdk.core.xt.xt().hl() && (j6 = com.bytedance.msdk.ae.j.cw.j().j(str, i6, 101)) != null) {
            if ("mediation_request".equals(str2)) {
                if (j6.m() == 1) {
                    up.r().j(String.valueOf(i6), jSONObject, j6.up());
                    return;
                } else {
                    if (j6.m() == 2) {
                        xt.r().j(String.valueOf(i6), jSONObject, j6.up());
                        return;
                    }
                    return;
                }
            }
            if (j6.m() != 2 || "sdk_init".equals(str2) || "sdk_init_end".equals(str2) || "get_config_start".equals(str2) || "get_config_final".equals(str2)) {
                return;
            }
            xt.r().cw(String.valueOf(i6), jSONObject, j6.up());
        }
    }

    public static com.bytedance.msdk.core.oq.xt j(com.bytedance.msdk.core.oq.xt xtVar, int i6) {
        long currentTimeMillis = System.currentTimeMillis();
        if (xtVar != null && com.bytedance.msdk.core.xt.xt().hl()) {
            if (i6 == 101) {
                return f24465j.get(xtVar.rn());
            }
            if (i6 == 100 && (xtVar.m() == 2 || xtVar.m() == 3 || xtVar.m() == 4)) {
                List<oq> j6 = cw.j(xtVar, xtVar.rn());
                Object obj = xtVar.up().get("rule_in_use");
                int intValue = obj != null ? ((Integer) obj).intValue() : -1;
                xtVar.up().put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (j6 == null || intValue == 0) {
                    return xtVar;
                }
                com.bytedance.msdk.core.oq.xt clone = xtVar.clone();
                if (clone.qv()) {
                    clone.xt(j6);
                } else {
                    clone.j(j6);
                }
                Object obj2 = clone.up().get("max_ecpm");
                Object obj3 = clone.up().get("min_ecpm");
                if (obj2 != null) {
                    clone.r(((Double) obj2).doubleValue());
                }
                if (obj3 != null) {
                    clone.up(((Double) obj3).doubleValue());
                }
                f24465j.put(xtVar.rn(), clone);
                clone.up().put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return clone;
            }
        }
        return null;
    }

    public static int j(String str, int i6, Map<String, Object> map) {
        com.bytedance.msdk.core.oq.r up;
        int i7;
        if (!TextUtils.isEmpty(str) && i6 == 1 && (up = com.bytedance.msdk.core.xt.xt().up(str)) != null) {
            int cw = up.cw();
            String r5 = up.r();
            if (cw > 0 && !TextUtils.isEmpty(r5)) {
                double j6 = xt.r().j(3, str, cw);
                List<com.bytedance.msdk.core.oq.cw> m6 = com.bytedance.msdk.core.xt.xt().m(String.valueOf(i6));
                if (m6 != null && m6.size() > 0) {
                    for (com.bytedance.msdk.core.oq.cw cwVar : m6) {
                        if (j6 > cwVar.m() && j6 <= cwVar.up()) {
                            i7 = up.j(String.valueOf(cwVar.cw()));
                            map.put("refresh_time", Integer.valueOf(i7));
                            break;
                        }
                    }
                }
                i7 = 0;
                if (i7 >= 10000 && i7 <= 180000) {
                    return i7;
                }
            }
        }
        return 0;
    }

    public static void j(int i6, String str, JSONObject jSONObject) {
        com.bytedance.msdk.core.oq.r up;
        if (com.bytedance.msdk.core.xt.xt().hl() && i6 == 2 && (up = com.bytedance.msdk.core.xt.xt().up(str)) != null) {
            try {
                jSONObject.putOpt("dynamic_rule_id", up.r());
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }

    public static void j(List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.core.oq.xt xtVar) {
        Object obj;
        if (!com.bytedance.msdk.core.xt.xt().hl() || list == null || xtVar == null) {
            return;
        }
        for (com.bytedance.msdk.xt.cw cwVar : list) {
            if (cwVar != null) {
                if (xtVar.m() == 1) {
                    cwVar.p().put(MediationConstant.KEY_GM_USB, up.cw(xtVar.wq()));
                } else if (xtVar.m() == 2 && (obj = xtVar.up().get("user_label_value")) != null) {
                    cwVar.p().put(MediationConstant.KEY_GM_USB, ((com.bytedance.msdk.core.oq.cw) obj).j());
                }
            }
        }
    }

    public static void j(boolean z5, com.bytedance.msdk.up.r rVar, JSONObject jSONObject, Map<String, Object> map) {
        if (rVar == null || !com.bytedance.msdk.core.xt.xt().hl()) {
            return;
        }
        up.r().j(z5, rVar, jSONObject, map);
    }

    public static void j(int i6, List<oq> list, Map<String, Object> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (oq oqVar : list) {
            if (oqVar != null && oqVar.mi() == 0) {
                jSONArray.put(oqVar.w());
            }
        }
        if (map != null) {
            map.put("rit_ids", jSONArray);
        }
    }
}
