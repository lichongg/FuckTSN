package com.bytedance.sdk.openadsdk.core.la.xt;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.jy.cw;
import com.bytedance.sdk.openadsdk.core.la.r;
import com.bytedance.sdk.openadsdk.core.la.tl;
import com.bytedance.sdk.openadsdk.core.la.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.l.ae;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    n f29448j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f29449r;
    private SSWebView xt;

    @JavascriptInterface
    public String sendNetworkSwitch(final String str) {
        vl.j("transmit_TTWifiObject", "send_switch PhoneNumStatus:" + this.f29449r + "  params:" + str);
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.f29449r) {
            ae.j(new g("send_network_switch") { // from class: com.bytedance.sdk.openadsdk.core.la.xt.j.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.cw == null) {
                        j.this.j(-1, System.currentTimeMillis() - currentTimeMillis, false, "context is null");
                    } else {
                        new tl(j.this.cw, new xt()).j(str, new r() { // from class: com.bytedance.sdk.openadsdk.core.la.xt.j.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.la.r
                            public void j(boolean z5, int i6, int i7, String str2, Map<String, List<String>> map, String str3) {
                                vl.j("transmit_TTWifiObject", "TransmitBusiness_onResponse s : " + z5 + " code:" + i7 + " msg:" + str2 + "  body:" + str3);
                                if (TextUtils.isEmpty(str3)) {
                                    vl.j("transmit_TTWifiObject", "TransmitBusiness_onResponse body is null and code:".concat(String.valueOf(i7)));
                                }
                                if (z5) {
                                    str2 = "取号成功";
                                } else if (TextUtils.isEmpty(str2)) {
                                    str2 = "取号失败";
                                }
                                j.this.j(i6, System.currentTimeMillis() - currentTimeMillis, z5, str2);
                                JSONObject jSONObject = new JSONObject();
                                if (str3 == null) {
                                    str3 = "";
                                }
                                try {
                                    jSONObject.put("data", str3);
                                } catch (JSONException unused) {
                                }
                                if (j.this.xt != null) {
                                    qv.j(j.this.xt, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
                                }
                            }
                        });
                    }
                }
            });
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", "没有wifi网络下获取手机号权限");
        } catch (JSONException unused) {
        }
        SSWebView sSWebView = this.xt;
        if (sSWebView != null) {
            qv.j(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
        }
        j(-1, System.currentTimeMillis() - currentTimeMillis, false, "没有wifi网络下获取手机号权限");
        return "";
    }

    public j(SSWebView sSWebView, Context context, boolean z5, n nVar) {
        this.xt = sSWebView;
        this.cw = context;
        this.f29449r = z5;
        this.f29448j = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final int i6, final long j6, final boolean z5, final String str) {
        vl.j("transmit_TTWifiObject", "TTWifiObject sendWifiEvent duration:" + j6 + "  networkType:" + i6 + "   s:" + z5 + "  detailInfo:" + str);
        cw.j(this.f29448j, "wifi_auth", "click_other", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.la.xt.j.2
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j6);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("wifi_auth_referer", "huoshan_JSSDK");
                jSONObject2.putOpt("wifi_auth_network_type", Integer.valueOf(i6));
                jSONObject2.putOpt("wifi_auth_duration", Long.valueOf(j6));
                jSONObject2.putOpt("wifi_auth_status", z5 ? "success" : "failure");
                String str2 = str;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject2.putOpt("wifi_auth_detail_info", str2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }
}
