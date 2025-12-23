package com.bytedance.sdk.openadsdk.core.kt;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qb;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.wq;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws {

    /* renamed from: j, reason: collision with root package name */
    private static volatile ws f29352j;

    public static ws j() {
        if (f29352j == null) {
            synchronized (ws.class) {
                try {
                    if (f29352j == null) {
                        f29352j = new ws();
                    }
                } finally {
                }
            }
        }
        return f29352j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void up(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !str.startsWith("zeus") && !TextUtils.equals("plugin_load_failed", str)) {
                str = "zeus_".concat(str);
            }
            final String str3 = str;
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
            if (str2 != null) {
                jSONObject.put("current_version", "7.0.1.2");
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("support_abi", Arrays.toString(Build.SUPPORTED_ABIS));
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            final int optInt = jSONObject.has("status_code") ? jSONObject.optInt("status_code") : jSONObject.optInt("code");
            final String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            final String optString2 = jSONObject.optString("duration");
            final String jSONObject2 = jSONObject.toString();
            xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.41
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    return "zeus_load_finish".equals(str3) ? com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(str3).xt(jSONObject2).xt(optInt).ae(optString).up(optString2).j(ws.j("7.0.1.2") ? 1 : 0) : com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(str3).xt(jSONObject2).xt(optInt).up(optString2).ae(optString);
                }
            }, str3, true);
        } catch (Throwable unused) {
        }
    }

    private boolean xt(com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar) {
        return xtVar == null;
    }

    public void cw(final String str, final String str2) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.42
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("lp_monitor").m(str2).xt(str);
            }
        }, "lp_monitor", true);
    }

    public void m(com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        r(jVar, "show_backup_endcard");
    }

    private void cw(com.bytedance.sdk.openadsdk.vl.j.j jVar, String str) {
        j(jVar, str, true);
    }

    private void r(final com.bytedance.sdk.openadsdk.vl.j.j jVar, final String str) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.5
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar = (com.bytedance.sdk.openadsdk.core.kt.j.xt) jVar.j();
                xtVar.j(str);
                xtVar.j(currentTimeMillis);
                return xtVar;
            }
        }, str, true);
    }

    public void ae(com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        cw(jVar, "splash_creative_check");
    }

    public void m(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.37
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("landingpage_check_info");
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "landingpage_check_info", true);
    }

    public void tl(final com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        if (jVar == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.9
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return ((com.bytedance.sdk.openadsdk.core.kt.j.xt) jVar.j()).j("app_env").j(System.currentTimeMillis() / 1000);
            }
        }, "app_env", true);
    }

    public void xt(final String str, final String str2) {
        com.bytedance.sdk.component.oq.ae.cw(new com.bytedance.sdk.component.oq.g("plugin_report") { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.40
            @Override // java.lang.Runnable
            public void run() {
                if (!"exception".equals(str)) {
                    ws.up(str, str2);
                    return;
                }
                try {
                    JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : null;
                    if (str2 != null) {
                        ws.this.j(jSONObject.optString("scene"), jSONObject, (Throwable) null);
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    private ws() {
    }

    public void cw(com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        cw(jVar, "outer_call_no_rsp");
    }

    public void xt() {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.43
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.i.cw.cw.r kt = com.bytedance.sdk.openadsdk.core.oq.i().kt();
                boolean xt = kt.xt();
                boolean j6 = kt.j();
                boolean up = kt.up();
                boolean r5 = kt.r();
                boolean cw = kt.cw();
                boolean m6 = kt.m();
                String vl = kt.vl();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("access_fine_location", j6 ? 1 : 0);
                    jSONObject.put("applist", xt ? 1 : 0);
                    jSONObject.put("external_storage", up ? 1 : 0);
                    jSONObject.put("wifi_state", r5 ? 1 : 0);
                    jSONObject.put("phone_state", cw ? 1 : 0);
                    jSONObject.put("can_use_androidId", m6 ? 1 : 0);
                    jSONObject.put("dev_oaid", vl);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("sdk_permission").xt(jSONObject.toString());
            }
        }, "sdk_permission", true);
    }

    public void cw(n nVar, String str) {
        j(nVar, str, (JSONObject) null);
    }

    public void r(com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        cw(jVar, "load_timeout");
    }

    public void xt(com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        cw(jVar, "outer_call_send");
    }

    public void cw(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.34
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("device_qty_compare");
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "device_qty_compare", true);
    }

    public void r(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.35
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("device_bytebench");
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "device_bytebench", true);
    }

    public void xt(final int i6) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.18
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("get_ad_cache_failed").xt(i6);
            }
        }, "get_ad_cache_failed", true);
    }

    public void xt(final String str) {
        if (str == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.19
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("error_ad_info").j(System.currentTimeMillis() / 1000).g(str);
            }
        }, "error_ad_info", true);
    }

    public void j(com.bytedance.sdk.openadsdk.vl.j.j jVar, String str) {
        xt.cw().j(jVar, str, true);
    }

    public void xt(com.bytedance.sdk.openadsdk.vl.j.j jVar, String str) {
        xt.cw().j(jVar, str, true);
    }

    public void j(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("render_backup").xt(jSONObject.toString());
            }
        }, "render_backup", true);
    }

    public void xt(final JSONObject jSONObject) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.23
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("saas_schema").xt(jSONObject.toString());
            }
        }, "saas_schema");
    }

    public static void j(SparseArray<Object> sparseArray, JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        com.bytedance.sdk.openadsdk.i.j jVar = new com.bytedance.sdk.openadsdk.i.j(sparseArray);
        PluginValueSet r5 = jVar.r();
        boolean j6 = jVar.j();
        int xt = jVar.xt();
        String cw = jVar.cw();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("success", j6);
            jSONObject4.put("code", xt);
            jSONObject4.put(CrashHianalyticsData.MESSAGE, cw);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
        if (r5 != null) {
            JSONObject jSONObject5 = (JSONObject) r5.objectValue(10, JSONObject.class);
            String stringValue = r5.stringValue(5);
            r0 = jSONObject5 != null ? System.currentTimeMillis() - jSONObject5.optLong("run_package_start", 0L) : -1L;
            JSONObject jSONObject6 = (JSONObject) r5.objectValue(3, JSONObject.class);
            jSONObject3 = (JSONObject) r5.objectValue(4, JSONObject.class);
            jSONObject2 = jSONObject6;
            str = stringValue;
        } else {
            str = null;
            jSONObject2 = null;
            jSONObject3 = null;
        }
        j().j(str, jSONObject != null ? jSONObject.optString("business_type") : "", j6, r0, jSONObject2, jSONObject3, jSONObject4);
    }

    public void xt(final n nVar, final String str) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.31
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("uttie_close");
                n nVar2 = nVar;
                if (nVar2 != null) {
                    j6.m(nVar2.ej());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "uttie_close");
    }

    public void up(com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        r(jVar, "express_ad_render");
    }

    public void up(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.36
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("render_timeout_opt");
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "render_timeout_opt", true);
    }

    public void j(final long j6, final long j7, final int i6) {
        final long j8 = j7 - j6;
        if (j8 <= 0 || j8 >= 30000000) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.12
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("starttime", j6);
                    jSONObject.put("endtime", j7);
                    jSONObject.put("start_type", i6);
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.core.kt.j.xt j9 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("general_label");
                StringBuilder sb = new StringBuilder();
                sb.append(j8);
                return j9.up(sb.toString()).xt(jSONObject.toString());
            }
        }, "general_label", true);
    }

    public void j(final String str, final String str2) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.22
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("close_time_1", str2);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("sdk_retention").up(str).xt(jSONObject.toString());
            }
        }, "sdk_retention", true);
    }

    public void j(final Object obj, final Object obj2, final String str, final String str2, final String str3) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.33
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    Object obj3 = obj;
                    if (obj3 instanceof Boolean) {
                        jSONObject.put("is_button", obj3);
                    }
                    Object obj4 = obj2;
                    if (obj4 instanceof Boolean) {
                        jSONObject.put("convert_result", obj4);
                    }
                    jSONObject.put("error_msg", str);
                    jSONObject.put("req_id", str2);
                    jSONObject.put(MediationConstant.EXTRA_ADID, str3);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("obm_result").xt(jSONObject.toString());
            }
        }, "obm_result", true);
    }

    public void j(String str, int i6, int i7, String str2, final int i8, final String str3, final long j6) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i8);
            jSONObject.put(CrashHianalyticsData.MESSAGE, str3);
            jSONObject.put("version", i7);
            jSONObject.put("current_version", i6);
            jSONObject.put(bi.f40972o, str);
            jSONObject.put("url", str2);
            jSONObject.put("duration", j6);
        } catch (Throwable unused) {
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.39
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt ae = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("plugin_download").xt(i8).ae(str3);
                StringBuilder sb = new StringBuilder();
                sb.append(j6);
                return ae.up(sb.toString()).xt(jSONObject.toString());
            }
        }, "plugin_download", true);
    }

    public static boolean j(String str) {
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        String xt = j6.xt("plugin_first_load", "");
        if (!TextUtils.isEmpty(xt) && xt.endsWith(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(xt)) {
            str = xt + "-" + str;
        }
        j6.j("plugin_first_load", str);
        return true;
    }

    public void j(final n nVar, final JSONObject jSONObject) {
        if (nVar == null) {
            return;
        }
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt m6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("jsb_video_action").m(nVar.ej());
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    m6.xt(jSONObject2.toString());
                }
                m6.cw(uf.j(nVar, ""));
                return m6;
            }
        }, "jsb_video_action", true);
    }

    public static void j(final String str, final long j6, final boolean z5) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.3
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_agg", z5);
                jSONObject.put("timestamp", j6);
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("over_freq").cw(str).xt(jSONObject.toString());
            }
        }, "over_freq", true);
    }

    private void j(final com.bytedance.sdk.openadsdk.vl.j.j jVar, final String str, boolean z5) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.4
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar = (com.bytedance.sdk.openadsdk.core.kt.j.xt) jVar.j();
                xtVar.j(str);
                xtVar.j(currentTimeMillis);
                return xtVar;
            }
        }, str, true);
    }

    public void j(com.bytedance.sdk.openadsdk.vl.j.j jVar) {
        cw(jVar, "outer_call");
    }

    private boolean j(String str, int i6) {
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        int xt = j6.xt(str, 0);
        boolean z5 = (xt & 2) == 0 || (xt & 1) != i6;
        if (z5) {
            j6.j(str, i6 + 2);
        }
        return z5;
    }

    public void j(final int i6, n nVar, final boolean z5) {
        final String valueOf = String.valueOf(uf.g(nVar));
        if (j(valueOf, z5 ? 1 : 0)) {
            xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.6
                @Override // com.bytedance.sdk.openadsdk.vl.j.j
                public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                    com.bytedance.sdk.openadsdk.core.kt.j.xt cw = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(i6).cw(valueOf);
                    if (z5) {
                        cw.j("reg_creative");
                        return cw;
                    }
                    cw.j("no_reg_creative");
                    return cw;
                }
            }, z5 ? "reg_creative" : "no_reg_creative", true);
        }
    }

    public void j(final com.bytedance.sdk.openadsdk.core.kt.j.xt xtVar) {
        if (xt(xtVar)) {
            return;
        }
        xtVar.j("load_icon_error");
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.7
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return xtVar;
            }
        }, "load_icon_error", true);
    }

    public void j(final boolean z5, final String[] strArr) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.8
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("if_sd", z5 ? 1 : 0);
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (String str : strArr) {
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str);
                                sb.append(",");
                            }
                        }
                        jSONObject.put("permission", sb.toString());
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("download_permission").j(System.currentTimeMillis() / 1000).xt(jSONObject.toString());
            }
        }, "download_permission", true);
    }

    public void j(final String str, final String str2, final String str3, final boolean z5) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.10
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("get_bidding_token");
                boolean xt = v.xt().xt(str);
                JSONObject jSONObject = new JSONObject();
                if (xt) {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("cache_req_id", str2);
                    }
                    if (TextUtils.equals(str3, "0")) {
                        jSONObject.put("no_cache_reason", 0);
                    } else if (TextUtils.equals(str3, "1")) {
                        jSONObject.put("no_cache_reason", 1);
                    }
                }
                if (z5) {
                    jSONObject.put("opt_sample", 1);
                }
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "get_bidding_token", z5);
    }

    public void j(final long j6, final com.bytedance.sdk.openadsdk.core.ch.r rVar) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.11
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", j6);
                jSONObject.put("ext_plugin_code", wq.xt());
                com.bytedance.sdk.openadsdk.core.ch.r rVar2 = rVar;
                if (rVar2 != null) {
                    jSONObject.put("success", rVar2.j() ? 1 : 0);
                    com.bytedance.sdk.openadsdk.core.ch.m xt = rVar.xt();
                    if (xt != null) {
                        jSONObject.put("msg", xt.toString());
                        jSONObject.put("code", xt.j());
                    }
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("pitaya_init").xt(jSONObject.toString());
            }
        }, "pitaya_init", true);
    }

    public void j(final String str, final String str2, final boolean z5, final long j6, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.13
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("duration", j6);
                jSONObject4.put("business", str);
                jSONObject4.put("biztype", str2);
                jSONObject4.put("result", z5);
                JSONObject jSONObject5 = jSONObject;
                if (jSONObject5 != null) {
                    jSONObject4.put("package_info", jSONObject5.toString());
                }
                JSONObject jSONObject6 = jSONObject2;
                if (jSONObject6 != null) {
                    jSONObject4.put("error_info", jSONObject6.toString());
                }
                JSONObject jSONObject7 = jSONObject3;
                if (jSONObject7 != null) {
                    jSONObject4.put("common_info", jSONObject7.toString());
                }
                jSONObject4.put("ext_plugin_code", wq.xt());
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("pitaya_run_task").xt(jSONObject4.toString());
            }
        }, "pitaya_run_task", true);
    }

    public void j(final int i6, ch chVar) {
        if (chVar == null) {
            return;
        }
        final JSONObject j6 = chVar.j(-1L);
        final long xt = chVar.xt();
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.14
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j7 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("bid_token_time");
                try {
                    j6.put("total", xt);
                    j6.put("opt_sample", 1);
                    j6.put("slot_type", i6);
                    j7.xt(j6.toString());
                } catch (Throwable unused) {
                }
                return j7;
            }
        }, "get_bidding_token", true);
    }

    public void j(int i6, long j6, String str) {
        j(i6, j6, (Boolean) null, str);
    }

    public void j(final int i6, final long j6, final Boolean bool, final String str) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.15
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                int i7;
                com.bytedance.sdk.openadsdk.core.kt.j.xt j7 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("encrypt_track");
                try {
                    JSONObject jSONObject = new JSONObject();
                    long j8 = j6;
                    if (j8 >= 0) {
                        jSONObject.put("cost_time", j8);
                    }
                    Boolean bool2 = bool;
                    if (bool2 != null) {
                        if (bool2.booleanValue()) {
                            i7 = 1;
                        } else {
                            i7 = 2;
                        }
                        jSONObject.put("init_succ", i7);
                    }
                    jSONObject.put("opt_sample", 1);
                    int i8 = i6;
                    if (i8 != -1) {
                        jSONObject.put("event_res", i8);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("type", str);
                    }
                    j7.xt(jSONObject.toString());
                } catch (Throwable unused) {
                }
                return j7;
            }
        }, "encrypt_track", true);
    }

    public void j(final int i6) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.16
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("has_pre_req").xt(i6);
            }
        }, "has_pre_req", true);
    }

    public void j(final int i6, final String str, final String str2, final String str3, final String str4) {
        xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.17
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fetch_adm", i6 == 0 ? 1 : 0);
                jSONObject.put("code", i6);
                jSONObject.put("msg", str);
                jSONObject.put("material_keys", str4);
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("fetch_adm_status").xt(i6).cw(str3).m(str2).xt(jSONObject.toString());
            }
        }, "fetch_adm_status", true);
    }

    public void j(final String str, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.20
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(str);
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    j6.xt(jSONObject2.toString());
                }
                return j6;
            }
        }, str);
    }

    public void j(String str, Throwable th) {
        j(str, (JSONObject) null, th);
    }

    public void j(final String str, final JSONObject jSONObject, final Throwable th) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.21
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("scene", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("exception", th);
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("exception").xt(jSONObject2.toString());
            }
        }, "exception");
    }

    public void j(final n nVar, final long j6, final boolean z5, final boolean z6) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.24
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("req_id", nVar.ej());
                jSONObject.put("auth", z5);
                jSONObject.put("duration", j6);
                jSONObject.put("time_out", z6);
                qb uw = nVar.uw();
                if (uw != null) {
                    jSONObject.put("saas_info", uw.j());
                }
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, nVar.os());
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("auth_time").xt(jSONObject.toString());
            }
        }, "auth_time");
    }

    public void j(final String str, final String str2, final int i6, final JSONObject jSONObject) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.25
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("event_type", str2);
                jSONObject2.putOpt("event", str);
                jSONObject2.putOpt("object", jSONObject);
                jSONObject2.putOpt("state", Integer.valueOf(i6));
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("convert_event").xt(jSONObject2.toString());
            }
        }, "convert_event");
    }

    public void j(final boolean z5) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.26
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", z5);
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("live_init_success").xt(jSONObject.toString());
            }
        }, "live_init_success");
    }

    public void j(final n nVar, final Object obj) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.27
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("upie_img_play_success");
                n nVar2 = nVar;
                if (nVar2 != null) {
                    j6.m(nVar2.ej());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("duration", obj);
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, nVar);
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "upie_img_play_success");
    }

    public void j(final n nVar, final int i6, final String str) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.28
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("upie_img_play_fail");
                n nVar2 = nVar;
                if (nVar2 != null) {
                    j6.m(nVar2.ej());
                }
                j6.xt(i6);
                j6.ae(str);
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, nVar);
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "upie_img_play_fail");
    }

    public void j(final n nVar, final String str) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.29
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("uttie_start");
                n nVar2 = nVar;
                if (nVar2 != null) {
                    j6.m(nVar2.ej());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                j6.xt(jSONObject.toString());
                return j6;
            }
        }, "uttie_start");
    }

    public void j(final n nVar, final String str, final long j6) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.30
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j7 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("uttie_played");
                n nVar2 = nVar;
                if (nVar2 != null) {
                    j7.m(nVar2.ej());
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uttie_url", str);
                jSONObject.put("duration", j6);
                j7.xt(jSONObject.toString());
                return j7;
            }
        }, "uttie_played");
    }

    public void j(final n nVar, final String str, final JSONObject jSONObject) {
        xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.32
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                com.bytedance.sdk.openadsdk.core.kt.j.xt j6 = com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(str);
                n nVar2 = nVar;
                if (nVar2 != null) {
                    j6.m(nVar2.ej()).tl(nVar.os());
                }
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null) {
                    j6.xt(jSONObject2.toString());
                }
                return j6;
            }
        }, str);
    }

    public static void j(final com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, final boolean z5, final long j6, final long j7, final long j8, final int i6) {
        j().ae(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.kt.ws.38
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                int i7 = z5 ? 2 : 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", Integer.valueOf(i7));
                jSONObject.putOpt("creative_check_duration", Long.valueOf(j7));
                jSONObject.putOpt("total_duration", Long.valueOf(j8));
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(i6));
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(i6).cw(xtVar.r()).xt((int) j6).xt(jSONObject.toString());
            }
        });
    }
}
