package cn.jpush.android.u;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.ad.k;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.webview.bridge.HostJsScope;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f extends b {

    /* renamed from: f, reason: collision with root package name */
    private WebView f3883f;

    /* renamed from: g, reason: collision with root package name */
    private cn.jpush.android.webview.bridge.d f3884g;

    private void a() {
        try {
            k.a(this.f3883f, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{this.f3884g, "JPushWeb"});
        } catch (Throwable th) {
            Logger.e("BaseInAppWrapper", "addJavascriptInterface failed:" + th.toString());
        }
    }

    @Override // cn.jpush.android.u.b
    public void c() {
        try {
            WebView webView = this.f3883f;
            if (webView != null) {
                ViewParent parent = webView.getParent();
                if (parent != null) {
                    try {
                        Logger.d("BaseInAppWrapper", "wb parent view " + parent);
                        ((ViewGroup) parent).removeView(this.f3883f);
                    } catch (Throwable unused) {
                        Logger.w("BaseInAppWrapper", "release - parent not viewGroup");
                    }
                }
                this.f3883f.getSettings().setJavaScriptEnabled(false);
                this.f3883f.clearCache(true);
                this.f3883f.clearHistory();
                this.f3883f.clearView();
                this.f3883f.removeAllViews();
                this.f3883f.clearSslPreferences();
                this.f3883f.destroy();
                this.f3883f = null;
            }
            i();
            Logger.d("BaseInAppWrapper", "wb release completed.");
        } catch (Throwable th) {
            Logger.w("BaseInAppWrapper", "wb destroy failed. error: " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.u.b
    public View e() {
        return this.f3883f;
    }

    @Override // cn.jpush.android.u.b
    public boolean f() {
        String str;
        cn.jpush.android.d.d dVar;
        if (this.f3845d == null || (dVar = this.f3843b) == null) {
            str = "unexpected error param is null";
        } else {
            try {
                String str2 = dVar.be;
                if (TextUtils.isEmpty(str2)) {
                    Logger.w("BaseInAppWrapper", "url is empty, wb inflate failed.");
                    return false;
                }
                if (this.f3883f == null) {
                    WebView webView = new WebView(this.f3845d);
                    this.f3883f = webView;
                    webView.setBackgroundColor(this.f3845d.getResources().getColor(R.color.transparent));
                }
                this.f3883f.setHorizontalScrollBarEnabled(false);
                this.f3883f.setVerticalScrollBarEnabled(false);
                this.f3883f.setScrollbarFadingEnabled(true);
                this.f3883f.setScrollBarStyle(CommonNetImpl.FLAG_SHARE_JUMP);
                WebSettings settings = this.f3883f.getSettings();
                cn.jpush.android.ad.a.c(settings);
                cn.jpush.android.ad.a.a(this.f3883f);
                cn.jpush.android.ad.a.a(settings);
                cn.jpush.android.webview.bridge.d dVar2 = new cn.jpush.android.webview.bridge.d(cn.jpush.android.s.a.a(this.f3845d), this.f3843b);
                this.f3884g = dVar2;
                HostJsScope.setWebViewHelper(dVar2);
                Logger.d("BaseInAppWrapper", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
                a();
                this.f3883f.setWebViewClient(new WebViewClient());
                this.f3883f.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                this.f3883f.loadUrl(str2);
                Logger.d("BaseInAppWrapper", "wb inflate completed, url: " + str2);
                return true;
            } catch (Throwable th) {
                str = "wb inflate failed, " + th.getMessage();
            }
        }
        Logger.w("BaseInAppWrapper", str);
        return false;
    }

    public f(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i6) {
        super(context, aVar, dVar, i6);
    }

    @Override // cn.jpush.android.u.b
    public void d() {
    }

    @Override // cn.jpush.android.u.b
    public void g() {
    }
}
