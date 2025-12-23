package com.bytedance.sdk.openadsdk.core.s.j;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.xt.r;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.up;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.f;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.bi;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends g {

    /* renamed from: com.bytedance.sdk.openadsdk.core.s.j.j$j, reason: collision with other inner class name */
    private static class C0474j {

        /* renamed from: j, reason: collision with root package name */
        private static final j f30188j = new j();
    }

    private j() {
        super("PluginSettingsFetchTask");
    }

    private JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", f.j(false));
            jSONObject.put("conn_type", ws.xt(v.getContext()));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", h.cw);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            jSONObject.put(bi.f40972o, uf.g());
            jSONObject.put("app_version", uf.qv());
            jSONObject.put("app_code", uf.oq());
            jSONObject.put("vendor", Build.MANUFACTURER);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String f6 = oq.i().f();
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("app_id", f6);
            jSONObject.put("req_sign", up.xt(f6 != null ? f6.concat(String.valueOf(currentTimeMillis)).concat(h.cw) : ""));
            jSONObject.put("channel", h.f29117m);
            jSONObject.put("applog_did", m.j().cw());
            jSONObject.put("imei", kt.ae());
            jSONObject.put(SocialConstants.PARAM_SOURCE, 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            jSONObject.put("plugins", r());
            jSONObject.put("csj_type", oq.i().nd() ? 1 : 0);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject r() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject rn = oq.i().rn();
        boolean qg = v.xt().qg();
        if (rn != null) {
            Iterator<String> keys = rn.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    JSONObject optJSONObject = rn.optJSONObject(next);
                    if (optJSONObject != null) {
                        optJSONObject.put("plugin_update_network", oq.i().s().j(next));
                    }
                    if (qg && next.equals("com.byted.live.lite")) {
                        jSONObject.putOpt(xt.xt(), optJSONObject);
                    } else {
                        jSONObject.putOpt(next, optJSONObject);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static j j() {
        return C0474j.f30188j;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bytedance.sdk.component.g.xt.up xt = com.bytedance.sdk.openadsdk.core.v.up.j().xt().xt();
        xt.j(uf.tl("/api/ad/union/sdk/settings/plugins"));
        xt.xt("User-Agent", uf.ae());
        xt.j(com.bytedance.sdk.component.utils.j.j(cw()));
        xt.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.core.s.j.j.1
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                if (xtVar == null || !xtVar.tl() || TextUtils.isEmpty(xtVar.r())) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(xtVar.r());
                    if (jSONObject.optInt("cypher") == 3) {
                        String cw = com.bytedance.sdk.component.utils.j.cw(jSONObject.optString(CrashHianalyticsData.MESSAGE));
                        if (TextUtils.isEmpty(cw)) {
                            return;
                        }
                        xt.j().j(new JSONObject(cw).optJSONArray("plugins"));
                    }
                } catch (JSONException unused) {
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(r rVar, IOException iOException) {
                try {
                    Iterator<String> keys = oq.i().rn().keys();
                    while (keys.hasNext()) {
                        xt.j().j(keys.next(), 1007);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void xt() {
        if (!ws.j(v.getContext())) {
            return;
        }
        ae.xt(this);
    }
}
