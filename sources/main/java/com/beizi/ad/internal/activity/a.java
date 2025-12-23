package com.beizi.ad.internal.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.h;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements AdActivity.a {

    /* renamed from: a, reason: collision with root package name */
    public static LinkedList<WebView> f11616a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private Activity f11617b;

    /* renamed from: c, reason: collision with root package name */
    private WebView f11618c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f11619d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11620e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11621f;

    /* renamed from: g, reason: collision with root package name */
    private String f11622g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11623h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11624i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11625j;

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (this.f11625j && !this.f11623h && !TextUtils.isEmpty(this.f11622g)) {
                this.f11623h = true;
                Uri parse = Uri.parse(this.f11622g);
                if (parse.getScheme() == null || !parse.getScheme().equals("bzopen") || TextUtils.isEmpty(parse.getHost()) || parse.getPathSegments().size() <= 0) {
                    if (this.f11622g.startsWith("hwpps://landingpage")) {
                        Intent intent = new Intent();
                        intent.setData(parse);
                        intent.addFlags(268435456);
                        this.f11617b.startActivity(intent);
                        return;
                    }
                    if (this.f11622g.startsWith("intent")) {
                        Intent parseUri = Intent.parseUri(this.f11622g, 1);
                        parseUri.addFlags(268435456);
                        this.f11617b.startActivity(parseUri);
                        return;
                    } else {
                        Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                        intent2.addFlags(805339136);
                        this.f11617b.startActivity(intent2);
                        return;
                    }
                }
                Intent intent3 = new Intent();
                intent3.setAction("android.intent.action.MAIN");
                intent3.setFlags(268435456);
                intent3.addCategory("android.intent.category.LAUNCHER");
                String queryParameter = parse.getQueryParameter("flags");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                            intent3.setFlags(Integer.parseInt(queryParameter));
                        }
                        intent3.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                intent3.setComponent(new ComponentName(parse.getHost(), parse.getPathSegments().get(0)));
                String queryParameter2 = parse.getQueryParameter("rect");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    try {
                        String[] split = queryParameter2.split(":");
                        if (split.length == 4) {
                            Rect rect = new Rect();
                            rect.set(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                            intent3.setSourceBounds(rect);
                        }
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                this.f11617b.startActivity(intent3);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Activity activity = this.f11617b;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.beizi.ad.AdActivity.a
    public void c() {
        WebView webView = this.f11618c;
        if (webView == null) {
            return;
        }
        u.a(webView);
        this.f11618c.destroy();
    }

    @Override // com.beizi.ad.AdActivity.a
    public WebView f() {
        return this.f11618c;
    }

    public a(Activity activity, boolean z5, boolean z6, String str, int i6) {
        this.f11617b = activity;
        this.f11620e = z5;
        this.f11621f = z6;
        this.f11622g = str;
        this.f11625j = i6 == 1;
    }

    @Override // com.beizi.ad.AdActivity.a
    public void b() {
        m.a("lance", "...........................backPressed...........................");
        if (this.f11618c.canGoBack()) {
            this.f11618c.goBack();
            m.a("lance", " mWebView.goBack()");
        } else {
            h();
        }
    }

    @Override // com.beizi.ad.AdActivity.a
    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    @TargetApi(17)
    public void a() {
        this.f11617b.setTheme(R.style.BeiZiTheme);
        this.f11617b.setContentView(R.layout.activity_in_app_browser);
        WebView poll = f11616a.poll();
        this.f11618c = poll;
        if (poll != null && poll.getSettings() != null) {
            if (this.f11618c.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f11618c.getContext()).setBaseContext(this.f11617b);
            }
            WebView webView = (WebView) this.f11617b.findViewById(R.id.web_view);
            webView.getSettings().setSavePassword(false);
            ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            int indexOfChild = viewGroup.indexOfChild(webView);
            viewGroup.removeView(webView);
            u.a(this.f11618c);
            this.f11618c.setLayoutParams(layoutParams);
            this.f11618c.getSettings().setUseWideViewPort(true);
            this.f11618c.getSettings().setLoadWithOverviewMode(true);
            this.f11618c.getSettings().setJavaScriptEnabled(true);
            this.f11618c.getSettings().setGeolocationEnabled(false);
            WebView.setWebContentsDebuggingEnabled(false);
            viewGroup.addView(this.f11618c, indexOfChild);
            final ProgressBar progressBar = (ProgressBar) this.f11617b.findViewById(R.id.progress_bar);
            try {
                String stringExtra = this.f11617b.getIntent().getStringExtra("bridgeid");
                if (stringExtra != null) {
                    Iterator<Pair<String, AdViewImpl.c>> it = AdViewImpl.c.f12530a.iterator();
                    while (it.hasNext()) {
                        Pair<String, AdViewImpl.c> next = it.next();
                        if (((String) next.first).equals(stringExtra)) {
                            AdViewImpl.c.f12530a.remove(next);
                        }
                    }
                }
                if (this.f11625j) {
                    this.f11618c.setOnTouchListener(new View.OnTouchListener() { // from class: com.beizi.ad.internal.activity.a.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                a.this.f11624i = true;
                                return false;
                            }
                            return false;
                        }
                    });
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            this.f11618c.setDownloadListener(new DownloadListener() { // from class: com.beizi.ad.internal.activity.a.2
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j6) {
                }
            });
            this.f11618c.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.activity.a.3
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                    try {
                        Uri url = webResourceRequest.getUrl();
                        if (url == null) {
                            return false;
                        }
                        String uri = url.toString();
                        if (!uri.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                            if (a.this.b(uri)) {
                                a.this.a(uri);
                            }
                            return true;
                        }
                        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                        if (requestHeaders == null || requestHeaders.size() == 0) {
                            requestHeaders = new HashMap<>();
                        }
                        requestHeaders.put("X-Requested-With", "");
                        webView2.loadUrl(uri, requestHeaders);
                        return true;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        return true;
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str) {
                    CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
                    if (cookieSyncManager != null) {
                        cookieSyncManager.sync();
                    }
                    a.this.g();
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                    if (str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                        return false;
                    }
                    if (!a.this.b(str)) {
                        return true;
                    }
                    a.this.a(str);
                    return true;
                }
            });
            this.f11618c.setWebChromeClient(new h(this.f11617b) { // from class: com.beizi.ad.internal.activity.a.4
                @Override // com.beizi.ad.internal.view.a, android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    return true;
                }

                @Override // com.beizi.ad.internal.view.h, android.webkit.WebChromeClient
                public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                    if (callback != null) {
                        try {
                            callback.invoke(str, false, false);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView2, int i6) {
                    if (i6 < 100 && progressBar.getVisibility() == 8) {
                        progressBar.setVisibility(0);
                    }
                    progressBar.setProgress(i6);
                    if (i6 == 100) {
                        progressBar.setVisibility(8);
                    }
                }

                @Override // com.beizi.ad.internal.view.a, android.webkit.WebChromeClient
                public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                    jsResult.confirm();
                    return true;
                }

                @Override // com.beizi.ad.internal.view.h, android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, customViewCallback);
                    if (view instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        if (frameLayout.getFocusedChild() instanceof VideoView) {
                            VideoView videoView = (VideoView) frameLayout.getFocusedChild();
                            frameLayout.removeView(videoView);
                            if (a.this.f11618c.getContext() instanceof Activity) {
                                ((Activity) a.this.f11618c.getContext()).setContentView(videoView);
                            }
                            videoView.start();
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.f11617b.findViewById(R.id.close_iv);
            this.f11619d = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.h();
                }
            });
            return;
        }
        h();
    }

    private boolean c(String str) {
        List<String> n6 = com.beizi.ad.internal.h.a().n();
        if (n6 == null || n6.size() <= 0) {
            return false;
        }
        Iterator<String> it = n6.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        return !c(str) || this.f11620e;
    }

    @Override // com.beizi.ad.AdActivity.a
    public void d() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f11625j) {
            if (this.f11623h && !this.f11624i) {
                return;
            } else {
                this.f11623h = true;
            }
        }
        Uri parse = o.a(str) ? null : Uri.parse(str);
        if (parse == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setFlags(268435456);
        try {
            this.f11617b.startActivity(intent);
            c();
            h();
        } catch (Exception unused) {
        }
    }
}
