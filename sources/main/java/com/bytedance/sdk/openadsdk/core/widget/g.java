package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends AlertDialog {

    /* renamed from: r, reason: collision with root package name */
    protected static volatile AtomicInteger f31196r = new AtomicInteger(0);
    private ImageView ae;
    private FrameLayout av;
    private TTViewStub az;
    protected j cw;

    /* renamed from: g, reason: collision with root package name */
    private TextView f31197g;

    /* renamed from: i, reason: collision with root package name */
    private int f31198i;

    /* renamed from: j, reason: collision with root package name */
    protected SSWebView f31199j;
    private com.bytedance.sdk.openadsdk.core.dislike.cw.xt jy;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f31200m;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.j oq;
    private Intent qv;
    private TextView tl;
    private LinearLayout up;
    private String vl;
    private TTViewStub ws;
    protected Context xt;

    public interface j {
        void j(Dialog dialog);
    }

    static /* synthetic */ int cw(g gVar) {
        int i6 = gVar.f31198i;
        gVar.f31198i = i6 + 1;
        return i6;
    }

    static /* synthetic */ int xt(g gVar) {
        int i6 = gVar.f31198i;
        gVar.f31198i = i6 - 1;
        return i6;
    }

    public g(Context context, Intent intent) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.f31198i = 0;
        this.xt = context;
        this.qv = intent;
    }

    private void cw() {
        TTViewStub tTViewStub;
        this.av = (FrameLayout) findViewById(2114387640);
        this.ws = (TTViewStub) findViewById(2114387776);
        this.az = (TTViewStub) findViewById(2114387798);
        this.av.addView(this.f31199j, new LinearLayout.LayoutParams(-1, -1));
        int p5 = com.bytedance.sdk.openadsdk.core.oq.i().p();
        if (p5 == 0) {
            TTViewStub tTViewStub2 = this.ws;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (p5 == 1 && (tTViewStub = this.az) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387711);
        this.f31200m = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.f31196r.set(0);
                    SSWebView sSWebView = g.this.f31199j;
                    if (sSWebView != null && sSWebView.canGoBack() && g.this.f31198i > 1) {
                        g.this.f31199j.goBack();
                        g.xt(g.this);
                        return;
                    }
                    g.this.dismiss();
                    g gVar = g.this;
                    j jVar = gVar.cw;
                    if (jVar != null) {
                        jVar.j(gVar);
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.ae = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.f31196r.set(0);
                    g.this.dismiss();
                    g gVar = g.this;
                    j jVar = gVar.cw;
                    if (jVar != null) {
                        jVar.j(gVar);
                    }
                }
            });
        }
        this.tl = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387633);
        this.f31197g = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.this.j();
                }
            });
        }
    }

    protected void j() {
        com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar;
        Context context = this.xt;
        if (context == null || (xtVar = this.jy) == null) {
            return;
        }
        if (this.oq == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(context, xtVar, this.vl, true);
            this.oq = jVar;
            com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.xt, TTDelegateActivity.f27821j, jVar);
        }
        this.oq.j();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f31196r.set(0);
        j jVar = this.cw;
        if (jVar != null) {
            jVar.j(this);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void xt() {
        n nVar;
        cw();
        if (this.tl != null && (nVar = TTDelegateActivity.f27821j) != null && !TextUtils.isEmpty(nVar.hw())) {
            this.tl.setText(TTDelegateActivity.f27821j.hw());
        }
        com.bytedance.sdk.openadsdk.core.widget.j.xt.j(this.xt).j(false).xt(false).j(this.f31199j);
        this.f31199j.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.j.r(this.xt, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.g.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            protected boolean j(WebView webView, WebResourceRequest webResourceRequest) {
                this.tl = g.f31196r;
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
                    g.cw(g.this);
                    return true;
                } catch (Exception e6) {
                    com.bytedance.sdk.component.utils.vl.j(e6);
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            public boolean j(WebView webView, String str) {
                this.tl = g.f31196r;
                return super.j(webView, str);
            }
        });
        this.f31199j.setJavaScriptEnabled(true);
        this.f31199j.setDisplayZoomControls(false);
        this.f31199j.setCacheMode(2);
        this.f31199j.loadUrl("https://phoniex.toutiao.com");
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        n nVar;
        super.onCreate(bundle);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.xt);
        this.up = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.up.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.up.setOrientation(1);
        this.f31199j = new SSWebView(this.xt);
        if (this.qv != null && (nVar = TTDelegateActivity.f27821j) != null) {
            this.jy = nVar.gs();
            this.vl = this.qv.getStringExtra("event_tag");
        }
        setContentView(com.bytedance.sdk.openadsdk.res.up.uf(this.xt));
        xt();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        getWindow().getAttributes().height = ed.up(this.xt) - ed.cw(this.xt, 50.0f);
    }

    public g j(j jVar) {
        this.cw = jVar;
        return this;
    }
}
