package cn.bluemobi.dylan.smartwebview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SmartWebView extends RelativeLayout {

    /* renamed from: f, reason: collision with root package name */
    private static ProgressBar f1364f;

    /* renamed from: g, reason: collision with root package name */
    private static RelativeLayout f1365g;

    /* renamed from: a, reason: collision with root package name */
    private WebView f1368a;

    /* renamed from: b, reason: collision with root package name */
    private int f1369b;

    /* renamed from: c, reason: collision with root package name */
    private int f1370c;

    /* renamed from: d, reason: collision with root package name */
    private c f1371d;

    /* renamed from: e, reason: collision with root package name */
    private View f1372e;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final d f1367i = new d(null);

    /* renamed from: h, reason: collision with root package name */
    private static int f1366h = ProgressStyle.Horizontal.ordinal();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ProgressStyle {
        Horizontal,
        Circle
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WebSettings f1374b;

        a(WebSettings webSettings) {
            this.f1374b = webSettings;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SmartWebView.this.l();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends WebChromeClient {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final a f1375a = new a();

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar progressBar = SmartWebView.f1364f;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$b$b, reason: collision with other inner class name */
        static final class RunnableC0018b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final RunnableC0018b f1376a = new RunnableC0018b();

            RunnableC0018b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RelativeLayout relativeLayout = SmartWebView.f1365g;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final c f1377a = new c();

            c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RelativeLayout relativeLayout = SmartWebView.f1365g;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(@NotNull String origin, @NotNull GeolocationPermissions.Callback callback) {
            g0.p(origin, "origin");
            g0.p(callback, "callback");
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            callback.invoke(origin, true, false);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(@NotNull WebView view, int i6) {
            ProgressBar progressBar;
            g0.p(view, "view");
            super.onProgressChanged(view, i6);
            if (i6 == 100) {
                ProgressBar progressBar2 = SmartWebView.f1364f;
                if (progressBar2 != null) {
                    progressBar2.postDelayed(a.f1375a, 10L);
                }
                RelativeLayout relativeLayout = SmartWebView.f1365g;
                if (relativeLayout != null) {
                    relativeLayout.postDelayed(RunnableC0018b.f1376a, 10L);
                    return;
                }
                return;
            }
            if (SmartWebView.f1366h == ProgressStyle.Horizontal.ordinal()) {
                ProgressBar progressBar3 = SmartWebView.f1364f;
                if (progressBar3 != null) {
                    progressBar3.setProgress(i6);
                    if (progressBar3.getVisibility() != 8) {
                        progressBar3 = null;
                    }
                    if (progressBar3 != null && (progressBar = SmartWebView.f1364f) != null) {
                        progressBar.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout2 = SmartWebView.f1365g;
            if (relativeLayout2 != null) {
                relativeLayout2.postDelayed(c.f1377a, 10L);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1378a;

        /* renamed from: b, reason: collision with root package name */
        private View f1379b;

        private final void b(WebView webView) {
            this.f1378a = true;
            if (webView != null) {
                webView.evaluateJavascript("javascript:document.open();document.write('');document.close();", null);
            }
            View view = this.f1379b;
            if (view != null) {
                if (view != null) {
                    view.setVisibility(0);
                }
                if (webView != null) {
                    webView.setVisibility(8);
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public static final a f1380a = new a();

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar progressBar = SmartWebView.f1364f;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
        }

        private final void c(WebView webView) {
            View view = this.f1379b;
            if (view != null) {
                if (view != null) {
                    view.setVisibility(8);
                }
                if (webView != null) {
                    webView.setVisibility(0);
                }
            }
        }

        public final void a(@NotNull View errorView) {
            g0.p(errorView, "errorView");
            this.f1379b = errorView;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@Nullable WebView webView, @Nullable SslErrorHandler sslErrorHandler, @Nullable SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            ProgressBar progressBar = SmartWebView.f1364f;
            if (progressBar != null) {
                progressBar.postDelayed(a.f1380a, 10L);
            }
            if (this.f1378a) {
                b(webView);
            } else {
                c(webView);
            }
            this.f1378a = false;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedError(@Nullable WebView webView, @NotNull WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
            g0.p(webResourceRequest, "webResourceRequest");
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                b(webView);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String url) {
            g0.p(webView, "webView");
            g0.p(url, "url");
            webView.loadUrl(url);
            if (u.H2(url, JPushConstants.HTTP_PRE, false, 2, null) || u.H2(url, JPushConstants.HTTPS_PRE, false, 2, null)) {
                return true;
            }
            Uri parse = Uri.parse(url);
            g0.o(parse, "Uri.parse(url)");
            if (!u.a2("bilibili", parse.getScheme(), true)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(v vVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartWebView(@NotNull Context context) {
        super(context);
        g0.p(context, "context");
        this.f1369b = 8;
        this.f1370c = 8;
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        f1364f = null;
        WebView webView = this.f1368a;
        if (webView == null) {
            g0.S("mWebView");
        }
        removeView(webView);
        WebView webView2 = this.f1368a;
        if (webView2 == null) {
            g0.S("mWebView");
        }
        webView2.stopLoading();
        WebView webView3 = this.f1368a;
        if (webView3 == null) {
            g0.S("mWebView");
        }
        WebSettings settings = webView3.getSettings();
        g0.o(settings, "mWebView.settings");
        settings.setJavaScriptEnabled(false);
        WebView webView4 = this.f1368a;
        if (webView4 == null) {
            g0.S("mWebView");
        }
        webView4.clearHistory();
        WebView webView5 = this.f1368a;
        if (webView5 == null) {
            g0.S("mWebView");
        }
        webView5.removeAllViews();
        WebView webView6 = this.f1368a;
        if (webView6 == null) {
            g0.S("mWebView");
        }
        webView6.destroy();
        super.onDetachedFromWindow();
    }

    private final void g() {
        this.f1368a = new WebView(getContext());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        WebView webView = this.f1368a;
        if (webView == null) {
            g0.S("mWebView");
        }
        setScale(webView);
        WebView webView2 = this.f1368a;
        if (webView2 == null) {
            g0.S("mWebView");
        }
        webView2.setInitialScale(3);
        View view = this.f1368a;
        if (view == null) {
            g0.S("mWebView");
        }
        addView(view, -1, -1);
        if (f1366h == ProgressStyle.Horizontal.ordinal()) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ac_progress_horizontal, (ViewGroup) null);
            if (inflate == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ProgressBar");
            }
            ProgressBar progressBar = (ProgressBar) inflate;
            f1364f = progressBar;
            progressBar.setMax(100);
            ProgressBar progressBar2 = f1364f;
            if (progressBar2 != null) {
                progressBar2.setProgress(0);
            }
            addView(f1364f, -1, this.f1370c);
        } else {
            View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.ac_progress_circle, (ViewGroup) null);
            if (inflate2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
            RelativeLayout relativeLayout = (RelativeLayout) inflate2;
            f1365g = relativeLayout;
            addView(relativeLayout, -1, -1);
        }
        this.f1371d = new c();
        WebView webView3 = this.f1368a;
        if (webView3 == null) {
            g0.S("mWebView");
        }
        webView3.setWebViewClient(this.f1371d);
        WebView webView4 = this.f1368a;
        if (webView4 == null) {
            g0.S("mWebView");
        }
        webView4.setWebChromeClient(new b());
        WebView webView5 = this.f1368a;
        if (webView5 == null) {
            g0.S("mWebView");
        }
        WebSettings webSettings = webView5.getSettings();
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setMixedContentMode(2);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSavePassword(false);
        webSettings.setBlockNetworkImage(false);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setAllowFileAccess(false);
        webSettings.setCacheMode(2);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDatabaseEnabled(true);
        String path = getContext().getDir("database", 0).getPath();
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setGeolocationDatabasePath(path);
        webSettings.setBuiltInZoomControls(false);
        g0.o(webSettings, "webSettings");
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setSupportZoom(false);
        View errorPageView = LayoutInflater.from(getContext()).inflate(R.layout.default_error_page, (ViewGroup) null);
        ((Button) errorPageView.findViewById(R.id.bt_error_retry)).setOnClickListener(new a(webSettings));
        g0.o(errorPageView, "errorPageView");
        setErrorPage(errorPageView);
    }

    @Nullable
    public final ProgressBar getProgressBar() {
        return f1364f;
    }

    @NotNull
    public final WebView getWebView() {
        WebView webView = this.f1368a;
        if (webView == null) {
            g0.S("mWebView");
        }
        return webView;
    }

    public final void h(@NotNull String data) {
        g0.p(data, "data");
        k(null, data, null);
    }

    public final void i(@NotNull String data, @NotNull String baseUrl) {
        g0.p(data, "data");
        g0.p(baseUrl, "baseUrl");
        k(null, data, baseUrl);
    }

    public final void j(@NotNull String url) {
        g0.p(url, "url");
        k(url, null, null);
    }

    public final void l() {
        WebView webView = this.f1368a;
        if (webView == null) {
            g0.S("mWebView");
        }
        webView.reload();
    }

    public final void m() {
        WebView webView = this.f1368a;
        if (webView == null) {
            g0.S("mWebView");
        }
        WebSettings settings = webView.getSettings();
        settings.setAppCacheEnabled(true);
        g0.o(settings, "settings");
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
    }

    public final void setErrorPage(@NotNull View errorView) {
        g0.p(errorView, "errorView");
        this.f1372e = errorView;
        errorView.setVisibility(8);
        if (errorView.getParent() != null) {
            ViewParent parent = errorView.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(errorView);
        }
        addView(errorView, -1, -1);
        c cVar = this.f1371d;
        if (cVar != null) {
            cVar.a(errorView);
        }
    }

    private final void k(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            WebView webView = this.f1368a;
            if (webView == null) {
                g0.S("mWebView");
            }
            webView.loadUrl(str);
            return;
        }
        if (!TextUtils.isEmpty(str3)) {
            WebView webView2 = this.f1368a;
            if (webView2 == null) {
                g0.S("mWebView");
            }
            webView2.loadDataWithBaseURL(str3, str2, "text/html", "UTF-8", str3);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            WebView webView3 = this.f1368a;
            if (webView3 == null) {
                g0.S("mWebView");
            }
            webView3.loadData(str2, "text/html", "UTF-8");
        }
    }

    private final void setScale(WebView webView) {
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            g0.o(defaultDisplay, "wm.defaultDisplay");
            int width = defaultDisplay.getWidth();
            if (width > 650) {
                webView.setInitialScale(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME);
                return;
            }
            if (width > 520) {
                webView.setInitialScale(160);
                return;
            }
            if (width > 450) {
                webView.setInitialScale(140);
                return;
            } else if (width > 300) {
                webView.setInitialScale(120);
                return;
            } else {
                webView.setInitialScale(100);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final void setWebChromeClient(@NotNull b webChromeClient) {
        g0.p(webChromeClient, "webChromeClient");
        WebView webView = this.f1368a;
        if (webView == null) {
            g0.S("mWebView");
        }
        webView.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(@NotNull c webViewClient) {
        g0.p(webViewClient, "webViewClient");
        this.f1371d = webViewClient;
        WebView webView = this.f1368a;
        if (webView == null) {
            g0.S("mWebView");
        }
        webView.setWebViewClient(webViewClient);
        View view = this.f1372e;
        if (view != null) {
            setErrorPage(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartWebView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        g0.p(context, "context");
        g0.p(attrs, "attrs");
        this.f1369b = 8;
        this.f1370c = 8;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.WebViewWithProgress);
        f1366h = obtainStyledAttributes.getInt(R.styleable.WebViewWithProgress_progressStyle, ProgressStyle.Horizontal.ordinal());
        this.f1370c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WebViewWithProgress_barHeight, this.f1369b);
        obtainStyledAttributes.recycle();
        g();
    }
}
