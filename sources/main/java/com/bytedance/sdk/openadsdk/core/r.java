package com.bytedance.sdk.openadsdk.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static String f30011j = "AppEnvironment";
    private long cw;

    /* renamed from: r, reason: collision with root package name */
    private boolean f30012r;
    private String up;
    private Map<String, String> xt;

    private static class j {

        /* renamed from: j, reason: collision with root package name */
        public static final r f30014j = new r();
    }

    public void cw(String str) {
        this.xt.put("show_ad_info", str);
    }

    public void xt(String str) {
        this.xt.put("request_ad_info", str);
    }

    private r() {
        this.up = "";
        HashMap hashMap = new HashMap();
        this.xt = hashMap;
        hashMap.put("ad_style", "default");
        this.xt.put(MediationConstant.EXTRA_ADID, "default");
        this.xt.put("rit", "default");
        this.xt.put("request_id", "default");
        this.xt.put("ad_slot_type", "default");
        this.xt.put("net_type", "default");
        this.xt.put("low_memory", "default");
        this.xt.put("total_max_memory_rate", "default");
        this.xt.put("commit_hash", "eaa0e8245f");
        this.xt.put("branch", "");
        this.xt.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
        this.xt.put("sdk_api_version", h.cw);
        this.xt.put("setting_ab_version", com.bytedance.sdk.openadsdk.core.cw.up.j().up());
        this.cw = com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sp_app_env").xt("last_app_env_time", 0L);
        this.f30012r = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject up() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = v.getContext();
            if (context == null) {
                return null;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4111);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
            }
            jSONObject.put("app_id", oq.i().f());
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void cw() {
        if (this.f30012r || com.bytedance.sdk.openadsdk.core.rn.uf.j(this.cw, System.currentTimeMillis())) {
            return;
        }
        this.f30012r = true;
        com.bytedance.sdk.openadsdk.core.kt.ws.j().tl(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.r.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                r.this.f30012r = false;
                com.bytedance.sdk.openadsdk.core.kt.j.xt<com.bytedance.sdk.openadsdk.core.kt.j.xt> xt = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt();
                JSONObject up = r.this.up();
                if (up != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    r.this.cw = currentTimeMillis;
                    com.bytedance.sdk.openadsdk.core.rn.h.j("tt_sp_app_env").j("last_app_env_time", currentTimeMillis);
                    xt.xt(up.toString());
                }
                return xt;
            }
        });
    }

    public void xt(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return;
        }
        this.xt.put(MediationConstant.EXTRA_ADID, nVar.fs());
        Map<String, String> map = this.xt;
        StringBuilder sb = new StringBuilder();
        sb.append(com.bytedance.sdk.openadsdk.core.rn.uf.g(nVar));
        map.put("rit", sb.toString());
        this.xt.put("request_id", com.bytedance.sdk.openadsdk.core.rn.uf.jy(nVar));
        Map<String, String> map2 = this.xt;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.bytedance.sdk.openadsdk.core.rn.uf.tl(nVar));
        map2.put("ad_slot_type", sb2.toString());
        this.xt.put("net_type", com.bytedance.sdk.component.utils.ws.ae(v.getContext()));
        if (com.bytedance.sdk.openadsdk.core.rn.tj.xt(nVar)) {
            this.xt.put("ad_style", "is_playable");
        }
        r();
    }

    private void r() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) ((runtime.maxMemory() * 1.0d) / 1048576.0d);
        float f6 = (float) ((runtime.totalMemory() * 1.0d) / 1048576.0d);
        ActivityManager activityManager = (ActivityManager) v.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        com.bytedance.sdk.component.utils.vl.r(f30011j, "系统是否处于低内存运行：" + memoryInfo.lowMemory);
        com.bytedance.sdk.component.utils.vl.r(f30011j, "maxMemory: ".concat(String.valueOf(maxMemory)));
        com.bytedance.sdk.component.utils.vl.r(f30011j, "totalMemory: ".concat(String.valueOf(f6)));
        com.bytedance.sdk.component.utils.vl.r(f30011j, "freeMemory: ".concat(String.valueOf((float) ((runtime.freeMemory() * 1.0d) / 1048576.0d))));
        int i6 = (int) ((f6 / maxMemory) * 100.0f);
        com.bytedance.sdk.component.utils.vl.r(f30011j, "totalMaxRate: ".concat(String.valueOf(i6)));
        this.xt.put("low_memory", String.valueOf(memoryInfo.lowMemory));
        this.xt.put("total_max_memory_rate", String.valueOf(i6));
    }

    public static r j() {
        return j.f30014j;
    }

    public void j(com.bytedance.sdk.openadsdk.core.tj.n nVar) {
        if (nVar == null) {
            return;
        }
        String fj = nVar.fj();
        Map<String, String> map = this.xt;
        if (TextUtils.isEmpty(fj)) {
            fj = "";
        }
        map.put("ad_info", fj);
    }

    public void j(String str) {
        this.xt.put("dynamic_ptpl_id", str);
    }

    public Map<String, String> xt() {
        return this.xt;
    }
}
