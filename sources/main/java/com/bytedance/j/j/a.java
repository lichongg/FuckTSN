package com.bytedance.j.j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.j.xt.a;
import com.bytedance.j.xt.ae.xt;
import com.bytedance.j.xt.e;
import com.bytedance.j.xt.tl.i;
import com.bytedance.j.xt.up.c;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile JSONObject f24135a;

    private static String a() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private static JSONObject b(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (f24135a == null) {
            Context i6 = e.i();
            try {
                JSONObject jSONObject2 = new JSONObject();
                f24135a = jSONObject2;
                jSONObject2.put("os", "Android");
                f24135a.put("platform", "Android");
                f24135a.put("sdk_lib", "Android");
                f24135a.put("os_version", a());
                f24135a.put("os_api", Build.VERSION.SDK_INT);
                f24135a.put("use_apm_sdk", "1");
                f24135a.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
                f24135a.put("sdk_version_code", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
                f24135a.put("sdk_version_name", "0.0.1-alpha.17-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                f24135a.put("device_model", str);
                f24135a.put(bi.F, str2);
                f24135a.put(bi.H, Build.MANUFACTURER);
                if (map != null) {
                    f24135a.put(CommonNetImpl.AID, String.valueOf(map.get(CommonNetImpl.AID)));
                    f24135a.put("app_version", map.get("app_version"));
                    f24135a.put("version_code", map.get("version_code"));
                    f24135a.put("update_version_code", map.get("update_version_code"));
                    f24135a.put("manifest_version_code", map.get("version_code"));
                    f24135a.put("channel", map.get("channel"));
                }
                f24135a.put("bd_did", e.b().a());
                f24135a.put(WiseOpenHianalyticsData.UNION_PACKAGE, i6.getPackageName());
                f24135a.put("display_name", i6.getApplicationInfo().name);
                d(f24135a);
            } catch (Exception unused) {
            }
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", f24135a);
        jSONObject.put("local_time", currentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long currentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", currentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put("session_id", UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(currentTimeMillis2)));
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    public static void c(b bVar) {
        Map<String, Object> b6 = e.d().b();
        if (b6 != null || b6.get(CommonNetImpl.AID) != null) {
            try {
                xt.c(new a.g.C0344a().a(xt.k(b6) + "?device_platform=android&version_code=137&iid=iid&aid=" + b6.get(CommonNetImpl.AID)).b(true).c(b(b6).toString().getBytes("UTF-8")).d());
            } catch (Throwable unused) {
            }
        }
    }

    private static void d(JSONObject jSONObject) {
        Map<String, Object> f6;
        Object obj;
        c d6 = e.d();
        if (d6 != null && jSONObject != null && (f6 = d6.f()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : f6.keySet()) {
                    if (!TextUtils.isEmpty(str) && (obj = f6.get(str)) != null) {
                        jSONObject2.put(str, obj);
                    }
                }
                jSONObject.put("custom", jSONObject2);
            } catch (Exception e6) {
                i.c(e6);
            }
        }
    }
}
