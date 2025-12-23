package com.bytedance.msdk.tl;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class v {
    public static JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", x.jy());
            jSONObject.put("imei", x.tj());
            jSONObject.put("imei_md5", f.j(x.tj()));
            jSONObject.put("gaid", tl.j().xt());
            jSONObject.put("oaid", x.xt());
            jSONObject.put("applog_did", x.j());
            jSONObject.put("device_model", x.ae());
            jSONObject.put("vendor", x.i());
            jSONObject.put(au.f40899d, x.h());
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, x.f());
            jSONObject.put(bi.f40972o, rn.j());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.j.qv().w());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, x.r());
            jSONObject.put("os_version", x.ws());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", x.tj());
            jSONObject.put("imei_md5", f.j(x.tj()));
            jSONObject.put("gaid", tl.j().xt());
            jSONObject.put("applog_did", x.j());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.j.qv().w());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, x.r());
            jSONObject.put("oaid", x.xt());
            return jSONObject;
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        Context context = com.bytedance.msdk.core.xt.getContext();
        try {
            jSONObject.put("device_id", x.j());
            jSONObject.put("user_unique_id", !TextUtils.isEmpty(x.j()) ? x.j() : UUID.randomUUID().toString());
            jSONObject.put("sdk_version", com.bytedance.msdk.xt.xt.xt());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.xt.xt.r());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", x.ws());
            jSONObject.put("device_model", x.ae());
            jSONObject.put("resolution", com.bytedance.msdk.j.up.ae.cw(com.bytedance.msdk.core.xt.getContext()) + "x" + com.bytedance.msdk.j.up.ae.xt(com.bytedance.msdk.core.xt.getContext()));
            jSONObject.put("language", x.g());
            jSONObject.put(bi.M, x.gq());
            jSONObject.put(bi.Q, x.m());
            jSONObject.put("openudid", x.r());
            jSONObject.put(CommonNetImpl.AID, "5685");
            jSONObject.put("display_name", g.xt());
            jSONObject.put("app_version", g.j());
            jSONObject.put(WiseOpenHianalyticsData.UNION_PACKAGE, rn.j());
            jSONObject.put(AgConnectInfo.AgConnectKey.REGION, Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", x.la());
            jSONObject.put(bi.H, Build.MANUFACTURER);
            j(context, jSONObject);
            jSONObject.put("display_density", x.rn());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", com.bytedance.msdk.j.up.ae.up(context));
            jSONObject.put(bi.F, Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", x.a());
            jSONObject.put("version_code", rn.xt());
            jSONObject.put("udid", x.tj());
            jSONObject.put("custom", cw());
            String f6 = x.f();
            if (TextUtils.isEmpty(f6)) {
                f6 = "127.0.0.1";
            } else if (f6.contains(",")) {
                f6 = j(f6);
            }
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, f6);
            return jSONObject;
        } catch (Exception e6) {
            com.bytedance.msdk.up.xt.xt.j("getUploadEventV3Header", "exception: " + e6.toString());
            com.bytedance.sdk.component.utils.vl.j(e6);
            return jSONObject;
        }
    }

    public static JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", x.tj());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, x.r());
            jSONObject.put("uuid", x.v());
            jSONObject.put("ssid", x.ch());
            jSONObject.put("wifi_mac", x.s());
            jSONObject.put("imsi", x.x());
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            jSONObject.put("power_on_time", sb.toString());
            jSONObject.put("rom_version", a.j());
            jSONObject.put("sys_compiling_time", x.cw());
            jSONObject.put("type", x.p());
            jSONObject.put("os", x.jy());
            jSONObject.put("os_version", x.ws());
            jSONObject.put("vendor", x.i());
            jSONObject.put("device_model", x.ae());
            jSONObject.put("language", x.g());
            jSONObject.put("conn_type", x.up());
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, x.l());
            jSONObject.put("screen_width", com.bytedance.msdk.j.up.ae.xt(context));
            jSONObject.put("screen_height", com.bytedance.msdk.j.up.ae.cw(context));
            jSONObject.put("oaid", x.xt());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static void j(Context context, JSONObject jSONObject) {
        ArrayList<String> j6;
        if (context == null || jSONObject == null || (j6 = oq.j(context, by.f10823a)) == null || j6.isEmpty()) {
            return;
        }
        try {
            jSONObject.put("sig_hash", Build.MANUFACTURER);
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    private static String j(String str) {
        String[] split = str.split(",");
        if (split != null && split.length > 0 && !TextUtils.isEmpty(split[0])) {
            return split[0].trim();
        }
        return "127.0.0.1";
    }
}
