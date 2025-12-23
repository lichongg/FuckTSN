package com.bytedance.sdk.openadsdk.m.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Map<String, Map<String, Integer>>> f31628j = new HashMap();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static void j(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ch.cw cwVar = (com.bytedance.sdk.openadsdk.core.ch.cw) AutoService.j(com.bytedance.sdk.openadsdk.core.ch.cw.class);
        if (cwVar == null || cwVar.cw()) {
            try {
                String valueOf = String.valueOf(uf.tl(nVar));
                String j6 = uf.j(nVar, "-1");
                switch (str.hashCode()) {
                    case -2093321865:
                        if (str.equals("load_video_cancel")) {
                            qv(valueOf, j6);
                            break;
                        }
                        break;
                    case -1643912491:
                        if (str.equals("feed_over")) {
                            r(valueOf, j6);
                            break;
                        }
                        break;
                    case -1643892427:
                        if (str.equals("feed_play")) {
                            cw(valueOf, j6);
                            break;
                        }
                        break;
                    case 3529469:
                        if (str.equals(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_SHOW)) {
                            j(valueOf, j6);
                            break;
                        }
                        break;
                    case 211925867:
                        if (str.equals("load_video_error")) {
                            oq(valueOf, j6);
                            break;
                        }
                        break;
                    case 224898501:
                        if (str.equals("load_video_start")) {
                            tl(valueOf, j6);
                            break;
                        }
                        break;
                    case 566194974:
                        if (str.equals("feed_break")) {
                            m(valueOf, j6);
                            break;
                        }
                        break;
                    case 578633749:
                        if (str.equals("feed_pause")) {
                            up(valueOf, j6);
                            break;
                        }
                        break;
                    case 1409113254:
                        if (str.equals("load_video_success")) {
                            g(valueOf, j6);
                            break;
                        }
                        break;
                    case 1912965437:
                        if (str.equals("play_error")) {
                            ae(valueOf, j6);
                            break;
                        }
                        break;
                    case 1925938071:
                        if (str.equals("play_start")) {
                            xt(valueOf, j6);
                            break;
                        }
                        break;
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    private static void ae(String str, String str2) {
        j(str, str2, "pe_c");
    }

    private static void cw(String str, String str2) {
        j(str, str2, "fpl_c");
    }

    private static void g(String str, String str2) {
        j(str, str2, "lvsu_c");
    }

    private static void m(String str, String str2) {
        j(str, str2, "fb_c");
    }

    private static void oq(String str, String str2) {
        j(str, str2, "lve_c");
    }

    private static void qv(String str, String str2) {
        j(str, str2, "lvc_c");
    }

    private static void r(String str, String str2) {
        j(str, str2, "fo_c");
    }

    private static void tl(String str, String str2) {
        j(str, str2, "lvs_c");
    }

    private static void up(String str, String str2) {
        j(str, str2, "fpu_c");
    }

    private static void xt(String str, String str2) {
        j(str, str2, "ps_c");
    }

    private static void j(String str, String str2) {
        j(str, str2, "show_c");
    }

    private static void j(String str, String str2, String str3) {
        Map<String, Map<String, Integer>> map = f31628j.get(str);
        if (map == null) {
            map = new HashMap<>();
            f31628j.put(str, map);
        }
        Map<String, Integer> map2 = map.get(str2);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str2, map2);
        }
        Integer num = map2.get(str3);
        if (num == null) {
            map2.put(str3, 1);
        } else {
            map2.put(str3, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        if (!f31628j.isEmpty()) {
            try {
                for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : f31628j.entrySet()) {
                    String key = entry.getKey();
                    Map<String, Map<String, Integer>> value = entry.getValue();
                    JSONObject jSONObject2 = new JSONObject();
                    if (value != null) {
                        for (Map.Entry<String, Map<String, Integer>> entry2 : value.entrySet()) {
                            String key2 = entry2.getKey();
                            Map<String, Integer> value2 = entry2.getValue();
                            JSONObject jSONObject3 = new JSONObject();
                            if (value2 != null) {
                                for (Map.Entry<String, Integer> entry3 : value2.entrySet()) {
                                    jSONObject3.put(entry3.getKey(), entry3.getValue());
                                }
                            }
                            jSONObject2.put(key2, jSONObject3);
                        }
                    }
                    jSONObject.put(key, jSONObject2);
                }
            } catch (Exception e6) {
                vl.j(e6);
                return jSONObject;
            }
        }
        return jSONObject;
    }
}
