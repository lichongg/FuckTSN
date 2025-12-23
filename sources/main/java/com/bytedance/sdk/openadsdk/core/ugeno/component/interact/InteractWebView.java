package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.R;
import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.sdk.component.adexpress.r.oq;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class InteractWebView extends SSWebView {
    private Map<String, Object> ae;

    /* renamed from: g, reason: collision with root package name */
    private ws f30578g;

    /* renamed from: m, reason: collision with root package name */
    private rn f30579m;
    private n tl;
    private Context up;

    public void ae() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        j((SSWebView) this);
        if (this.tl != null) {
            Context context = this.up;
            rn rnVar = this.f30579m;
            n nVar = this.tl;
            setWebViewClient(new j(context, rnVar, nVar, nVar.fs()));
        } else {
            setWebViewClient(new SSWebView.j());
        }
        com.bytedance.sdk.component.adexpress.up.up.j().j(this, this.f30579m);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.j.cw(this.f30579m));
    }

    public static class j extends com.bytedance.sdk.openadsdk.core.widget.j.r {

        /* renamed from: j, reason: collision with root package name */
        private n f30580j;

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.j.xt.j j6 = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j.j(webView, this.f30580j, str, new j.InterfaceC0467j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.InteractWebView.j.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j.InterfaceC0467j
                    public boolean j() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xt.j.InterfaceC0467j
                    public com.bytedance.sdk.component.adexpress.j.xt.j j(String str2, oq.j jVar, String str3) {
                        com.bytedance.sdk.component.adexpress.j.xt.j jVar2 = new com.bytedance.sdk.component.adexpress.j.xt.j();
                        jVar2.j(5);
                        jVar2.j(com.bytedance.sdk.openadsdk.core.ugeno.up.j.xt().j(webView, jVar, str2));
                        return jVar2;
                    }
                });
                if (j6 != null && j6.j() != null) {
                    return j6.j();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public j(Context context, rn rnVar, n nVar, String str) {
            super(context, rnVar, str);
            this.f30580j = nVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.vl.cw("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    private void j(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.j.xt.j(this.up).j(false).j(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            kt.j(sSWebView, h.xt, n.r(this.tl));
            sSWebView.setMixedContentMode(0);
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.r("InteractWebView", e6.toString());
        }
    }

    public ws getUGenContext() {
        return this.f30578g;
    }

    public void m() {
        Map<String, Object> map = this.ae;
        if (map == null || map.size() <= 0 || !this.ae.containsKey("key_material")) {
            return;
        }
        Object obj = this.ae.get("key_material");
        if (obj instanceof n) {
            this.tl = (n) obj;
            this.f30579m = (rn) this.ae.get("key_js_object");
            if (this.ae.containsKey("key_data_list") && (this.ae.get("key_data_list") instanceof List)) {
                this.f30579m.xt((List<JSONObject>) this.ae.get("key_data_list"));
            }
            this.f30579m.xt(this).j(this.tl).j(uf.xt(this.tl)).xt(this.tl.fs()).cw(this.tl.os()).r(uf.av(this.tl)).j((SSWebView) this);
        }
    }

    public void setUGenContext(ws wsVar) {
        this.f30578g = wsVar;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.ae = map;
    }

    public InteractWebView(Context context) {
        super(context);
        this.up = context;
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.jy.cw
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
