package com.bytedance.sdk.openadsdk.jy.j;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.component.xt.j.oq;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    protected String ae;
    protected String cw;

    /* renamed from: j, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.jy.j f31529j;

    /* renamed from: m, reason: collision with root package name */
    protected JSONObject f31530m;

    /* renamed from: r, reason: collision with root package name */
    public AtomicBoolean f31531r = new AtomicBoolean(false);
    public AtomicBoolean up = new AtomicBoolean(false);
    protected String xt;

    /* renamed from: com.bytedance.sdk.openadsdk.jy.j.j$j, reason: collision with other inner class name */
    public interface InterfaceC0502j {
        void j(boolean z5, Map<String, Object> map);
    }

    public abstract void cw();

    public abstract void j();

    public abstract void j(Context context, String str, com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, Map<String, Object> map);

    public abstract void j(com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, InterfaceC0502j interfaceC0502j);

    public abstract void j(String str);

    public abstract void j(String str, String str2);

    protected abstract void j(JSONObject jSONObject, String str, oq oqVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean j(WebView webView);

    public abstract boolean j(oq oqVar);

    public void xt() {
        j();
    }

    public abstract void xt(Context context, String str, com.bytedance.sdk.openadsdk.jy.xt xtVar, WebResourceResponse webResourceResponse, oq oqVar, Map<String, Object> map);

    public j(com.bytedance.sdk.openadsdk.jy.j jVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.f31529j = jVar;
        this.xt = str;
        this.ae = str4;
        this.cw = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.f31530m = jSONObject2;
        try {
            if (this instanceof xt) {
                jSONObject2.putOpt(MediationConstant.EXTRA_LOG_EXTRA, str3);
                this.f31530m.putOpt("resource_type", "union");
                this.f31530m.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof cw) {
                jSONObject2.putOpt("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                this.f31530m.putOpt(MediationConstant.EXTRA_ADID, jSONObject.optString(MediationConstant.EXTRA_ADID));
                this.f31530m.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.f31530m.putOpt("cid", str);
            this.f31530m.putOpt("ac", Integer.valueOf(ws.cw(v.getContext())));
            this.f31530m.putOpt("app_name", com.bytedance.sdk.openadsdk.core.oq.i().v());
            this.f31530m.putOpt("app_id", com.bytedance.sdk.openadsdk.core.oq.i().f());
            this.f31530m.putOpt("app_version", com.bytedance.sdk.openadsdk.core.tl.j.r());
            this.f31530m.putOpt("sdk_version", h.cw);
            this.f31530m.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            this.f31530m.putOpt("platform", "Android");
            this.f31530m.putOpt("device_id", kt.cw());
            this.f31530m.putOpt("web_url", str4);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        j(str, str2);
    }
}
