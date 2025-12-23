package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.ccg.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
final class m {
    private static final List<Pair<String, JSONObject>> cw = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    static final Map<String, String> f27580j = new HashMap();
    private static SharedPreferences xt;

    public static void xt(String str, JSONObject jSONObject) {
        cw.add(new Pair<>(str, jSONObject));
    }

    public static void j(int i6, String str, long j6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j6));
            jSONObject.putOpt("code", Integer.valueOf(i6));
            jSONObject.putOpt(CrashHianalyticsData.MESSAGE, str);
            jSONObject.putOpt("load_record", up.j());
        } catch (JSONException e6) {
            com.bytedance.sdk.openadsdk.api.m.j(e6);
        }
        up("plugin_load_failed", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject m(String str, JSONObject jSONObject) {
        String str2 = "7.0.1.2";
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            jSONObject.put("is_boost", true);
            jSONObject.put("is_only_armv8a", com.bytedance.sdk.openadsdk.api.plugin.cw.cw.cw());
            jSONObject2.put("ad_sdk_version", "7.0.1.2");
            String j6 = g.j("com.byted.pangle");
            if (!TextUtils.isEmpty(j6)) {
                str2 = j6;
            }
            jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            Map<String, String> map = f27580j;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(bn.f10753i, Build.MODEL);
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private static void r(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            up(str, jSONObject);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(a.f41544t, 1);
        bundle.putString("event_name", str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(Bundle.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(List<JSONObject> list) {
        if (list == null) {
            return;
        }
        if (xt == null) {
            xt = xt.xt(TTAppContextHolder.getContext(), "tt_sdk_settings_other", 0);
        }
        String format = String.format("https://%s%s", xt.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        JSONObject jSONObject = new JSONObject();
        try {
            List<Pair<String, JSONObject>> list2 = cw;
            if (list2.size() > 0) {
                for (Pair<String, JSONObject> pair : list2) {
                    list.add(m((String) pair.first, (JSONObject) pair.second));
                }
                cw.clear();
            }
            jSONObject.put("stats_list", new JSONArray((Collection) list));
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.xt.cw.j().j(true, format, com.bytedance.sdk.openadsdk.api.plugin.cw.xt.j(jSONObject).toString().getBytes());
    }

    private static void up(final String str, final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.mi.j.j().cw().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.m.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(m.m(str, jSONObject));
                m.xt(arrayList);
            }
        });
    }

    public static void j(String str, JSONObject jSONObject) {
        r("zeus_".concat(String.valueOf(str)), jSONObject);
    }

    public static void j() {
        List<Pair<String, JSONObject>> list = cw;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (Pair<String, JSONObject> pair : list) {
                if (pair != null) {
                    r((String) pair.first, (JSONObject) pair.second);
                }
            }
            cw.clear();
        } catch (Exception unused) {
        }
    }

    public static void j(AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        Map<String, String> map = f27580j;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        map.put("plugin_update_conf", pluginUpdateConfig != 0 ? String.valueOf(pluginUpdateConfig) : "2");
        TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (Exception unused) {
            }
        }
    }

    static Map<String, String> xt() {
        return f27580j;
    }
}
