package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends AlertDialog {

    /* renamed from: m, reason: collision with root package name */
    protected static volatile AtomicInteger f31243m = new AtomicInteger(0);
    private String ae;
    protected TextView cw;

    /* renamed from: j, reason: collision with root package name */
    protected SSWebView f31244j;

    /* renamed from: r, reason: collision with root package name */
    protected String f31245r;
    protected j up;
    protected Context xt;

    public interface j {
        void j(Dialog dialog);
    }

    protected void j() {
        this.f31244j = (SSWebView) findViewById(2114387845);
        this.cw = (TextView) findViewById(2114387918);
        ((TextView) findViewById(2114387702)).setText(this.ae);
        this.cw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.f31243m.set(0);
                r rVar = r.this;
                j jVar = rVar.up;
                if (jVar != null) {
                    jVar.j(rVar);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.f31244j.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.j.r(this.xt, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.r.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            protected boolean j(WebView webView, WebResourceRequest webResourceRequest) {
                this.tl = r.f31243m;
                return super.j(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains(b.f50154a) && !lowerCase.contains(b.f50155b)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            public boolean j(WebView webView, String str) {
                this.tl = r.f31243m;
                return super.j(webView, str);
            }
        });
        this.f31244j.setJavaScriptEnabled(true);
        this.f31244j.setDisplayZoomControls(false);
        this.f31244j.setCacheMode(2);
        this.f31244j.loadUrl(this.f31245r);
    }

    public r(Context context, String str, String str2) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.xt = context;
        this.ae = str2;
        this.f31245r = str;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f31243m.set(0);
        j jVar = this.up;
        if (jVar != null) {
            jVar.j(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.up.q(getContext()));
        j();
    }

    public r j(j jVar) {
        this.up = jVar;
        return this;
    }
}
