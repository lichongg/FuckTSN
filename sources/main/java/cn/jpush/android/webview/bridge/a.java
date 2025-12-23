package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f3967a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f3968b;

    public a(String str, Class cls, ProgressBar progressBar, TextView textView) {
        super(str, cls);
        this.f3967a = progressBar;
        this.f3968b = textView;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        TextView textView2 = this.f3968b;
        if (textView2 != null) {
            textView2.setSingleLine(true);
            this.f3968b.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i6) {
        super.onProgressChanged(webView, i6);
        ProgressBar progressBar = this.f3967a;
        if (progressBar != null) {
            if (100 == i6) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                this.f3967a.setProgress(i6);
            }
        }
        if (this.f3968b != null && webView.getTitle() != null && !webView.getTitle().equals(this.f3968b.getText())) {
            String title = webView.getTitle();
            if (!title.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) && !title.startsWith("android-app://") && !title.startsWith("file://")) {
                this.f3968b.setText(webView.getTitle());
            }
        }
    }
}
