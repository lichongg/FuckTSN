package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class tl implements Runnable {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private final Context f27589j;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, String> f27590r = m.xt();
    private String xt;

    static final class j {
        public int ae;
        public String cw;

        /* renamed from: g, reason: collision with root package name */
        public String f27591g;

        /* renamed from: j, reason: collision with root package name */
        public String f27592j;

        /* renamed from: m, reason: collision with root package name */
        public int f27593m;
        public boolean oq;

        /* renamed from: r, reason: collision with root package name */
        public String f27594r;
        public int tl;
        public String up;
        public int xt;

        public String toString() {
            try {
                return new JSONObject().put(bi.f40972o, this.f27592j).put("version_code", this.xt).put("sign", this.f27594r).put("max_version", this.ae).put("min_version", this.f27593m).put("is_revert", this.oq).put(TKDownloadReason.KSAD_TK_MD5, this.up).put("plugin_file", this.f27591g).toString();
            } catch (JSONException unused) {
                return "";
            }
        }

        j() {
        }
    }

    public void j() {
        if (com.bytedance.sdk.openadsdk.api.plugin.cw.up.j(this.f27589j)) {
            run();
        }
    }

    private JSONObject cw() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("app_id", this.f27590r.get("appid"));
        jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
        jSONObject2.put("sdk_version", "7.0.1.2");
        jSONObject2.put("plugin_update_network", "2");
        jSONObject.put("com.byted.pangle", jSONObject2);
        return jSONObject;
    }

    private String r() {
        Context context;
        if (TextUtils.isEmpty(this.xt) && (context = this.f27589j) != null) {
            try {
                this.cw = context.getPackageName();
                this.xt = this.f27589j.getPackageManager().getPackageInfo(this.cw, 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return this.xt;
    }

    private JSONObject xt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conn_type", com.bytedance.sdk.openadsdk.api.plugin.cw.up.xt(this.f27589j));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", "7.0.1.2");
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            jSONObject.put("app_version", r());
            jSONObject.put(bi.f40972o, this.cw);
            jSONObject.put("vendor", Build.MANUFACTURER);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str = this.f27590r.get("appid");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("app_id", str);
            jSONObject.put("req_sign", com.bytedance.sdk.openadsdk.api.plugin.cw.r.j(str != null ? str.concat(String.valueOf(currentTimeMillis)).concat("7.0.1.2") : ""));
            jSONObject.put("channel", "main");
            jSONObject.put("imei", this.f27590r.get("imei"));
            jSONObject.put(SocialConstants.PARAM_SOURCE, 0);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", cw());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        up.j("plugin_download", "start run");
        String j6 = com.bytedance.sdk.openadsdk.api.plugin.xt.cw.j().j(true, "https://api-access.pangolin-sdk-toutiao.com/api/ad/union/sdk/settings/plugins", com.bytedance.sdk.openadsdk.api.plugin.cw.xt.j(xt()).toString().getBytes());
        if (j6 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(j6);
            if (jSONObject.optInt("cypher") == 3) {
                String xt = com.bytedance.sdk.openadsdk.api.plugin.cw.xt.xt(jSONObject.optString(CrashHianalyticsData.MESSAGE));
                if (TextUtils.isEmpty(xt)) {
                    return;
                }
                cw.j(this.f27589j).j(j(new JSONObject(xt).optJSONArray("plugins")));
            }
        } catch (JSONException e6) {
            up.j("plugin_download", "failed:".concat(String.valueOf(e6)));
        }
    }

    tl(Context context) {
        this.f27589j = context;
    }

    private List<j> j(JSONArray jSONArray) {
        up.j("plugin_download", "parse start");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    j jVar = new j();
                    jVar.f27592j = optJSONObject.optString(bi.f40972o);
                    jVar.xt = optJSONObject.optInt("version_code");
                    jVar.cw = optJSONObject.optString("download_url");
                    jVar.f27594r = optJSONObject.optString("sign");
                    jVar.f27593m = j(optJSONObject.optString("min_version"));
                    jVar.ae = j(optJSONObject.optString("max_version"));
                    jVar.tl = optJSONObject.optInt("plugin_update_network");
                    arrayList.add(jVar);
                    up.j("plugin_download", "parse " + i6 + " : " + jVar);
                }
            }
        }
        return arrayList;
    }

    private int j(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str.replace(".", ""));
            }
        } catch (NumberFormatException unused) {
        }
        return 0;
    }
}
