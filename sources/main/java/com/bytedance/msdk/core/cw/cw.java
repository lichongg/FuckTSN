package com.bytedance.msdk.core.cw;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static boolean j(int i6) {
        return i6 == 0 || i6 == 1 || i6 == 2;
    }

    private static boolean xt(int i6) {
        return i6 == 3 || i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7 || i6 == 8 || i6 == 9;
    }

    public static void j(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.xt.xt().n() != null) {
            com.bytedance.msdk.tl.j.cw.j().insert(str, str2, str3, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW);
        }
    }

    public static void xt(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.xt.xt().n() != null) {
            com.bytedance.msdk.tl.j.cw.j().insert(str, str2, str3, "send");
        }
    }

    public static void cw(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.xt.xt().n() != null) {
            com.bytedance.msdk.tl.j.cw.j().insert(str, str2, str3, "fill");
        }
    }

    public static void j(String str, int i6) {
        if (com.bytedance.msdk.core.xt.xt().n() == null || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - (i6 * 3600000);
        com.bytedance.msdk.j.up.cw.xt("TMe", "---预缓存优化删除存储的过期数据 primeRit = " + str + " startTime = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(currentTimeMillis)));
        com.bytedance.msdk.tl.j.cw.j().j(str, currentTimeMillis);
    }

    public static com.bytedance.msdk.core.oq.xt j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.oq.xt xtVar2) {
        xt xtVar3;
        com.bytedance.msdk.core.oq.xt xtVar4;
        com.bytedance.msdk.core.oq.xt xtVar5;
        List<oq> list;
        xt xtVar6;
        com.bytedance.msdk.core.oq.xt xtVar7 = xtVar2;
        xt n6 = com.bytedance.msdk.core.xt.xt().n();
        com.bytedance.msdk.j.up.cw.xt("TMe", "----预缓存优化判断是否可以发起预缓存开始");
        HashMap hashMap = null;
        if (xtVar == null) {
            return null;
        }
        com.bytedance.msdk.j.up.cw.xt("TMe", "待检测的 behaviorState = " + xtVar.g());
        int j6 = j(xtVar7, n6, xtVar.g());
        HashSet hashSet = new HashSet();
        if (j6 == 200) {
            List<oq> ol = xtVar7.ol();
            HashSet<String> hashSet2 = new HashSet();
            for (oq oqVar : ol) {
                com.bytedance.msdk.j.up.cw.xt("TMe", "adnName = " + oqVar.i() + " adnrit = " + oqVar.w());
                hashSet2.add(oqVar.i());
            }
            LinkedList linkedList = new LinkedList();
            HashMap hashMap2 = new HashMap();
            for (oq oqVar2 : ol) {
                if (oqVar2 != null) {
                    j jVar = (j) hashMap2.get(oqVar2.i());
                    if (jVar == null) {
                        String i6 = oqVar2.i();
                        String rn = xtVar7.rn();
                        int b6 = xtVar7.b();
                        double j7 = n6.j(i6, rn);
                        double xt = n6.xt(i6, rn);
                        list = ol;
                        if (j7 == 0.0d && xt == 0.0d) {
                            com.bytedance.msdk.j.up.cw.xt("TMe", "没有配置规则，直接添加到adn list中 adnName = " + oqVar2.i() + " adnRit " + oqVar2.w());
                            linkedList.add(oqVar2);
                            ol = list;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            xtVar6 = n6;
                            List<com.bytedance.msdk.tl.j.xt> query = com.bytedance.msdk.tl.j.cw.j().query(i6, rn, currentTimeMillis - (b6 * 3600000), currentTimeMillis);
                            if (query != null && query.size() != 0) {
                                int i7 = 0;
                                int i8 = 0;
                                int i9 = 0;
                                for (com.bytedance.msdk.tl.j.xt xtVar8 : query) {
                                    if (TextUtils.equals(xtVar8.j(), "send")) {
                                        i9++;
                                    } else if (TextUtils.equals(xtVar8.j(), "fill")) {
                                        i7++;
                                    } else if (TextUtils.equals(xtVar8.j(), AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW)) {
                                        i8++;
                                    }
                                }
                                j jVar2 = new j(i7 != 0 ? i8 / i7 : 0.0d, i9 != 0 ? i7 / i9 : 0.0d, j7, xt, xtVar6.j(), xtVar6.m());
                                jVar2.xt(i7);
                                jVar2.j(i9);
                                jVar2.cw(i8);
                                hashMap2.put(oqVar2.i(), jVar2);
                                jVar = jVar2;
                            } else {
                                com.bytedance.msdk.j.up.cw.xt("TMe", "数据库里没有查询到数据，直接添加到adn list中 adnName = " + oqVar2.i() + " adnRit " + oqVar2.w());
                                linkedList.add(oqVar2);
                            }
                        }
                    } else {
                        list = ol;
                        xtVar6 = n6;
                    }
                    if (jVar != null) {
                        jVar.j(oqVar2.i());
                        jVar.xt(oqVar2.w());
                        com.bytedance.msdk.j.up.cw.xt("TMe", "compareData ".concat(String.valueOf(jVar)));
                    }
                    if (jVar != null && jVar.j()) {
                        linkedList.add(oqVar2);
                    }
                } else {
                    list = ol;
                    xtVar6 = n6;
                }
                xtVar7 = xtVar2;
                ol = list;
                n6 = xtVar6;
            }
            List<oq> list2 = ol;
            xtVar3 = n6;
            com.bytedance.msdk.j.up.cw.xt("TMe", "筛选掉代码位 后留下的代码位 ------- ");
            HashSet hashSet3 = new HashSet();
            for (oq oqVar3 : linkedList) {
                com.bytedance.msdk.j.up.cw.xt("TMe", "adnName = " + oqVar3.i() + " adnrit = " + oqVar3.w());
                hashSet3.add(oqVar3.i());
            }
            for (String str : hashSet2) {
                if (!hashSet3.contains(str)) {
                    hashSet.add(str);
                }
            }
            j6 = list2.size() == linkedList.size() ? 11 : 10;
            com.bytedance.msdk.core.oq.xt clone = xtVar2.clone();
            clone.j(linkedList);
            if (clone.qv()) {
                clone.xt(linkedList);
            } else {
                clone.j(linkedList);
            }
            xtVar4 = clone;
            hashMap = hashMap2;
        } else {
            xtVar3 = n6;
            xtVar4 = null;
        }
        int i10 = j6;
        if (xtVar4 == null) {
            j(xtVar, xtVar2, xtVar3, i10, hashSet, hashMap);
            xtVar5 = xtVar4;
        } else {
            xtVar5 = xtVar4;
            j(xtVar, xtVar5, xtVar3, i10, hashSet, hashMap);
        }
        if (xtVar2 != null) {
            j(xtVar.v(), xtVar2.b());
        }
        return xtVar5;
    }

    private static int j(com.bytedance.msdk.core.oq.xt xtVar, xt xtVar2, int i6) {
        if (!com.bytedance.msdk.core.xt.xt().c()) {
            return 0;
        }
        if (xtVar2 == null || xtVar2.up() == null) {
            return 1;
        }
        if (!xtVar2.j(i6)) {
            return 2;
        }
        if (xtVar2.xt() == 0) {
            return 3;
        }
        if (xtVar2.j() == 0) {
            return 4;
        }
        if (!xtVar2.ae()) {
            return 5;
        }
        if (xtVar == null || !xtVar2.j(xtVar.rn())) {
            return 6;
        }
        if (xtVar.b() == 0) {
            return 7;
        }
        if (j(xtVar, xtVar2)) {
            return j(xtVar) ? 9 : 200;
        }
        return 8;
    }

    private static boolean j(com.bytedance.msdk.core.oq.xt xtVar, xt xtVar2) {
        if (xtVar == null || xtVar.ol() == null || xtVar2 == null) {
            return false;
        }
        for (oq oqVar : xtVar.ol()) {
            double j6 = xtVar2.j(oqVar.i(), xtVar.rn());
            double xt = xtVar2.xt(oqVar.i(), xtVar.rn());
            if (j6 != 0.0d || xt != 0.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean j(com.bytedance.msdk.core.oq.xt xtVar) {
        if (xtVar == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<com.bytedance.msdk.tl.j.xt> query = com.bytedance.msdk.tl.j.cw.j().query("", xtVar.rn(), currentTimeMillis - (xtVar.b() * 3600000), currentTimeMillis);
        return query == null || query.isEmpty();
    }

    private static void j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.oq.xt xtVar2, xt xtVar3, int i6, Set<String> set, Map<String, j> map) {
        if (xtVar.oq() != null) {
            com.bytedance.msdk.j.up.cw.xt("TMe", "预缓存优化存在埋点数据 无需重新存储");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i6);
            if (j(i6)) {
                xtVar.j(jSONObject);
                return;
            }
            jSONObject.put("perform", j(i6, xtVar3, map));
            if (xt(i6)) {
                xtVar.j(jSONObject);
                return;
            }
            jSONObject.put("behavior_state", j(xtVar3));
            jSONObject.put("condition", xtVar3.xt());
            if (xtVar2 != null) {
                try {
                    jSONObject.put("behavior_ttl", xtVar2.b());
                } catch (JSONException unused) {
                }
            }
            if (set != null && set.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("filtered_adn", jSONArray);
            }
            xtVar.j(jSONObject);
        } catch (JSONException unused2) {
        }
    }

    private static JSONArray j(xt xtVar) {
        List<Integer> list;
        JSONArray jSONArray = new JSONArray();
        if (xtVar != null && (list = xtVar.f24461j) != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        return jSONArray;
    }

    private static JSONObject j(int i6, xt xtVar, Map<String, j> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rule_id", xtVar.cw());
        jSONObject.put("rule_timestamp", xtVar.r());
        if (!xt(i6)) {
            jSONObject.put("condition", xtVar.j());
            jSONObject.put("rule_inuse", (i6 == 10 || i6 == 11) ? 1 : 0);
            if (map != null) {
                try {
                    DecimalFormat decimalFormat = new DecimalFormat("#0.000");
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    for (Map.Entry<String, j> entry : map.entrySet()) {
                        j value = entry.getValue();
                        if (value != null) {
                            jSONObject3.put(entry.getKey(), decimalFormat.format(value.xt()));
                            jSONObject4.put(entry.getKey(), decimalFormat.format(value.cw()));
                        }
                    }
                    jSONObject2.put("ssr", jSONObject3);
                    jSONObject2.put("srr", jSONObject4);
                    jSONObject.put("res", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
