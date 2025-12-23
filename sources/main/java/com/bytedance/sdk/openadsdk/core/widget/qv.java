package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends AlertDialog {

    /* renamed from: j, reason: collision with root package name */
    protected static volatile AtomicInteger f31235j = new AtomicInteger(0);
    private String ae;
    private Context cw;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f31236g;

    /* renamed from: m, reason: collision with root package name */
    private j f31237m;
    private ImageView oq;
    private ImageView qv;

    /* renamed from: r, reason: collision with root package name */
    private TextView f31238r;
    private RelativeLayout tl;
    private String up;
    private SSWebView xt;

    public interface j {
        void j(Dialog dialog);
    }

    public qv(Context context, String str) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.ae = str;
        this.cw = context;
    }

    protected void j() {
        String tk = v.xt().tk();
        if (TextUtils.isEmpty(tk)) {
            this.up = "https://www.pangle.cn/privacy/partner";
        } else {
            this.up = tk;
        }
        if (TextUtils.isEmpty(this.ae)) {
            return;
        }
        if (this.up.contains("?")) {
            this.up += "&ad_info=" + this.ae;
            return;
        }
        this.up += "?ad_info=" + this.ae;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        f31235j.set(0);
        j jVar = this.f31237m;
        if (jVar != null) {
            jVar.j(this);
        }
    }

    protected void xt() {
        this.xt = (SSWebView) findViewById(2114387769);
        TextView textView = (TextView) findViewById(2114387658);
        this.f31238r = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.qv.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (qv.this.f31237m != null) {
                    qv.this.f31237m.j(qv.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.xt.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.j.r(this.cw, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.qv.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            protected boolean j(WebView webView, WebResourceRequest webResourceRequest) {
                this.tl = qv.f31235j;
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
                    String lowerCase = scheme.toLowerCase(Locale.US);
                    if (!lowerCase.contains(b.f50154a) && !lowerCase.contains(b.f50155b)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            public boolean j(WebView webView, String str) {
                this.tl = qv.f31235j;
                return super.j(webView, str);
            }
        });
        this.xt.setJavaScriptEnabled(true);
        this.xt.setDisplayZoomControls(false);
        this.xt.setCacheMode(2);
        this.xt.loadUrl(this.up);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387889);
        this.tl = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387900);
        this.f31236g = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.f31238r.setVisibility(8);
        this.oq = (ImageView) findViewById(2114387819);
        this.qv = (ImageView) findViewById(2114387842);
        this.oq.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.qv.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (qv.this.f31237m != null) {
                    qv.this.f31237m.j(qv.this);
                    qv.f31235j.set(0);
                }
            }
        });
        this.qv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.qv.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) qv.this.cw.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, qv.this.up));
                    a.j(qv.this.cw, "链接复制成功", 1);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.vl.j(th);
                    a.j(qv.this.cw, "链接复制失败", 1);
                }
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.up.gx(this.cw));
        xt();
        j();
    }

    public qv j(j jVar) {
        this.f31237m = jVar;
        return this;
    }
}
