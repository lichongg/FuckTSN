package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.jy.xt;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BaseWebView extends WebView {

    /* renamed from: a, reason: collision with root package name */
    protected Boolean f27126a;
    protected Boolean ae;
    protected String av;
    protected Integer az;
    protected Integer ch;
    protected WebChromeClient cw;

    /* renamed from: f, reason: collision with root package name */
    protected Boolean f27127f;

    /* renamed from: g, reason: collision with root package name */
    protected Boolean f27128g;

    /* renamed from: i, reason: collision with root package name */
    protected Boolean f27129i;

    /* renamed from: j, reason: collision with root package name */
    protected Map<String, j> f27130j;
    protected Boolean jy;
    protected Boolean kt;

    /* renamed from: l, reason: collision with root package name */
    protected Boolean f27131l;

    /* renamed from: m, reason: collision with root package name */
    protected View.OnScrollChangeListener f27132m;
    protected Boolean mi;
    protected Boolean oq;

    /* renamed from: p, reason: collision with root package name */
    protected xt.j f27133p;
    protected Boolean qv;

    /* renamed from: r, reason: collision with root package name */
    protected DownloadListener f27134r;

    /* renamed from: s, reason: collision with root package name */
    protected Boolean f27135s;
    protected Boolean tj;
    protected Boolean tl;
    protected Integer up;

    /* renamed from: v, reason: collision with root package name */
    protected Boolean f27136v;
    protected Boolean vl;

    /* renamed from: w, reason: collision with root package name */
    protected WebSettings.LayoutAlgorithm f27137w;
    protected Integer ws;

    /* renamed from: x, reason: collision with root package name */
    protected Boolean f27138x;
    protected com.bytedance.sdk.component.widget.xt xt;

    public BaseWebView(Context context) {
        super(context);
        this.f27132m = null;
    }

    protected void j(Runnable runnable) {
        if (j()) {
            runnable.run();
        } else {
            tl.xt().post(runnable);
        }
    }

    public void xt() {
        this.f27130j = null;
        this.xt = null;
        this.cw = null;
        this.f27134r = null;
        this.f27132m = null;
        this.up = null;
        this.ae = null;
        this.tl = null;
        this.f27128g = null;
        this.oq = null;
        this.qv = null;
        this.vl = null;
        this.jy = null;
        this.ws = null;
        this.az = null;
        this.av = null;
        this.f27129i = null;
        this.f27137w = null;
        this.mi = null;
        this.kt = null;
        this.tj = null;
        this.f27127f = null;
        this.f27136v = null;
        this.f27138x = null;
        this.ch = null;
        this.f27135s = null;
        this.f27126a = null;
        this.f27131l = null;
        this.f27133p = null;
    }

    public Boolean getAllowFileAccess() {
        return this.vl;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.oq;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.f27128g;
    }

    public Boolean getAppCacheEnabled() {
        return this.f27138x;
    }

    public Integer getBackgroundColor() {
        return this.up;
    }

    public Boolean getBlockNetworkImage() {
        return this.qv;
    }

    public Boolean getBuiltInZoomControls() {
        return this.mi;
    }

    public Integer getCacheMode() {
        return this.ch;
    }

    public WebChromeClient getChromeClient() {
        return this.cw;
    }

    public com.bytedance.sdk.component.widget.xt getClient() {
        return this.xt;
    }

    public Boolean getDatabaseEnabled() {
        return this.jy;
    }

    public Integer getDefaultFontSize() {
        return this.az;
    }

    public String getDefaultTextEncodingName() {
        return this.av;
    }

    public Boolean getDisplayZoomControls() {
        return this.f27135s;
    }

    public Boolean getDomStorageEnabled() {
        return this.kt;
    }

    public DownloadListener getDownloadListener() {
        return this.f27134r;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.tj;
    }

    public Boolean getJavaScriptEnabled() {
        return this.f27126a;
    }

    public Map<String, j> getJavascriptInterfaces() {
        return this.f27130j;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.f27137w;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.f27129i;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.ae;
    }

    public Integer getMixedContentMode() {
        return this.ws;
    }

    public Boolean getNetworkAvailable() {
        return this.f27131l;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.f27132m;
    }

    public xt.j getOnTouchEventListener() {
        return this.f27133p;
    }

    public Boolean getSavePassword() {
        return this.tl;
    }

    public Boolean getSupportZoom() {
        return this.f27127f;
    }

    public Boolean getUseWideViewPort() {
        return this.f27136v;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27132m = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        xt();
        super.destroy();
    }

    protected boolean j() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f27132m = null;
    }

    public void j(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "callback");
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            j(str, jSONObject2);
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    private void j(String str, JSONObject jSONObject) {
        evaluateJavascript("javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")", null);
    }

    public void xt(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", "event");
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            j(str, jSONObject2);
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
