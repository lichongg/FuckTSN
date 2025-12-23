package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.a;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.addownload.o;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes6.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f37639a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f37640b;

    /* renamed from: c, reason: collision with root package name */
    private long f37641c;

    /* renamed from: d, reason: collision with root package name */
    private long f37642d;

    /* renamed from: e, reason: collision with root package name */
    private String f37643e;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f37642d);
            AppPrivacyPolicyActivity.this.finish();
        }
    }

    class b extends WebViewClient {
        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webResourceRequest.getUrl());
        }

        b() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean didCrash;
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            didCrash = renderProcessGoneDetail.didCrash();
            if (didCrash) {
                a.k.b("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }
            a.k.b("System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ((ViewGroup) webView.getParent()).removeView(webView);
                webView.destroy();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return a(Uri.parse(str));
        }

        private boolean a(Uri uri) {
            String scheme = uri.getScheme();
            if (!master.flame.danmaku.danmaku.parser.b.f50154a.equals(scheme) && !master.flame.danmaku.danmaku.parser.b.f50155b.equals(scheme)) {
                return true;
            }
            return false;
        }
    }

    static {
        StubApp.interface11(41141);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void b(Activity activity, long j6) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j6);
        activity.startActivity(intent);
    }

    private void c(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    private void e() {
        this.f37639a = (ImageView) findViewById(R.id.iv_privacy_back);
        this.f37640b = (WebView) findViewById(R.id.privacy_webview);
        this.f37639a.setOnClickListener(new a());
        WebSettings settings = this.f37640b.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.f37640b.setWebViewClient(new b());
        c(this.f37640b);
        this.f37640b.setScrollBarStyle(0);
        this.f37640b.loadUrl(this.f37643e);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_privacy_click_close", this.f37642d);
        super.onBackPressed();
    }

    private boolean d() {
        this.f37641c = getIntent().getLongExtra("app_info_id", 0L);
        o.j j6 = cw.j().j(this.f37641c);
        if (j6 == null) {
            return false;
        }
        this.f37642d = j6.f37966b;
        String str = j6.f37973i;
        this.f37643e = str;
        if (TextUtils.isEmpty(str)) {
            this.f37643e = m.f().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
            return true;
        }
        return true;
    }
}
