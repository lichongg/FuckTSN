package com.beizi.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.beizi.ad.AdActivity;
import com.beizi.ad.internal.h.o;
import com.beizi.ad.internal.h.u;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.internal.j;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.video.AdVideoView;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.f;
import com.beizi.ad.lance.a.m;
import com.beizi.ad.model.f;
import com.beizi.fusion.R;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdWebView extends WebView implements com.beizi.ad.internal.view.c {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private long F;
    private float G;
    private float H;
    private boolean I;
    private HttpURLConnection J;
    private InputStream K;
    private final Runnable L;

    /* renamed from: a, reason: collision with root package name */
    boolean f12531a;
    public com.beizi.ad.internal.f.c ad;
    public AdViewImpl adViewImpl;

    /* renamed from: b, reason: collision with root package name */
    protected String f12532b;

    /* renamed from: c, reason: collision with root package name */
    boolean f12533c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12534d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12535e;

    /* renamed from: f, reason: collision with root package name */
    private f f12536f;

    /* renamed from: g, reason: collision with root package name */
    private int f12537g;
    public GestureDetector gestureDetector;

    /* renamed from: h, reason: collision with root package name */
    private int f12538h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12539i;

    /* renamed from: j, reason: collision with root package name */
    private int f12540j;

    /* renamed from: k, reason: collision with root package name */
    private int f12541k;

    /* renamed from: l, reason: collision with root package name */
    private int f12542l;

    /* renamed from: m, reason: collision with root package name */
    private int f12543m;
    public AdVideoView mAdVideoView;

    /* renamed from: n, reason: collision with root package name */
    private int f12544n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f12545o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f12546p;

    /* renamed from: q, reason: collision with root package name */
    private Handler f12547q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12548r;

    /* renamed from: s, reason: collision with root package name */
    private int f12549s;

    /* renamed from: t, reason: collision with root package name */
    private ProgressDialog f12550t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f12551u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f12552v;

    /* renamed from: w, reason: collision with root package name */
    private int f12553w;

    /* renamed from: x, reason: collision with root package name */
    private int f12554x;

    /* renamed from: y, reason: collision with root package name */
    private int f12555y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f12556z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                try {
                    WebView.HitTestResult hitTestResult = AdWebView.this.getHitTestResult();
                    if (hitTestResult == null || hitTestResult.getExtra() == null) {
                        return;
                    }
                    if (hitTestResult.getExtra().equals(str)) {
                        int type = hitTestResult.getType();
                        if (type == 1 || type == 6 || type == 7 || type == 8) {
                            AdWebView.this.b(str);
                            webView.stopLoading();
                            AdWebView.this.c();
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i6, String str, String str2) {
            AdViewImpl adViewImpl = AdWebView.this.adViewImpl;
            if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
                return;
            }
            AdWebView.this.adViewImpl.getAdDispatcher().a(2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AdWebView.this.h();
            AdViewImpl adViewImpl = AdWebView.this.adViewImpl;
            if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
                return;
            }
            AdWebView.this.adViewImpl.getAdDispatcher().a(2);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return AdWebView.this.a(webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AdViewImpl adViewImpl;
            m.a("lance", "Loading:::::::::::::::::::::::" + str);
            if (str.startsWith("javascript:")) {
                return false;
            }
            if (str.startsWith("mraid://")) {
                if (AdWebView.this.f12535e) {
                    AdWebView.this.f12536f.a(str, AdWebView.this.f12552v);
                } else {
                    String host = Uri.parse(str).getHost();
                    if (host != null && host.equals("enable")) {
                        AdWebView.this.fireMRAIDEnabled();
                    } else if (host != null && host.equals("open")) {
                        AdWebView.this.f12536f.a(str, AdWebView.this.f12552v);
                    }
                }
                return true;
            }
            if (!str.startsWith("BeiZi://")) {
                AdWebView.this.b(str);
                AdWebView.this.c();
                return true;
            }
            try {
                String host2 = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host2) && !"ClosePage".equals(host2)) {
                    AdWebView adWebView = AdWebView.this;
                    if (adWebView.ad != null && (adViewImpl = adWebView.adViewImpl) != null && adViewImpl.getAdParameters() != null) {
                        AdWebView adWebView2 = AdWebView.this;
                        adWebView2.ad.a(adWebView2, "", "", "", "", "", "", adWebView2.f12533c, adWebView2.adViewImpl.getAdParameters().a());
                        AdWebView.this.f12533c = true;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            com.beizi.ad.internal.view.b.a(AdWebView.this, str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AdWebView adWebView = AdWebView.this;
            if (adWebView.ad.f11907a == k.SPLASH) {
                adWebView.visible();
            }
            if (!AdWebView.this.f12539i) {
                webView.evaluateJavascript("javascript:window.mraid.util.pageFinished()", null);
                if (AdWebView.this.f12535e) {
                    f fVar = AdWebView.this.f12536f;
                    AdWebView adWebView2 = AdWebView.this;
                    fVar.a(adWebView2, adWebView2.f12532b);
                    AdWebView.this.i();
                }
                AdWebView.this.f12539i = true;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends WebView {
        @SuppressLint({"SetJavaScriptEnabled"})
        public c(Context context) {
            super(new MutableContextWrapper(context));
            x.a(this);
            setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.view.AdWebView.c.1

                /* renamed from: c, reason: collision with root package name */
                private boolean f12571c = false;

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    u.a(c.this);
                    if (AdWebView.this.f12550t != null && AdWebView.this.f12550t.isShowing()) {
                        AdWebView.this.f12550t.dismiss();
                    }
                    if (this.f12571c) {
                        this.f12571c = false;
                        c.this.destroy();
                        AdWebView.this.k();
                    } else {
                        c.this.setVisibility(0);
                        c cVar = c.this;
                        AdWebView.this.a(cVar);
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    boolean h6 = AdWebView.this.h(str);
                    this.f12571c = h6;
                    if (h6 && AdWebView.this.f12550t != null && AdWebView.this.f12550t.isShowing()) {
                        AdWebView.this.f12550t.dismiss();
                    }
                    return this.f12571c;
                }
            });
        }
    }

    @Override // android.webkit.WebView, com.beizi.ad.internal.view.c
    public void destroy() {
        setVisibility(4);
        u.a(this);
        super.destroy();
        removeAllViews();
        j();
    }

    public void handleClickView(MotionEvent motionEvent, long j6, long j7) {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null || this.adViewImpl.isRewardedVideo()) {
            return;
        }
        this.E++;
        this.adViewImpl.getAdDispatcher().d();
        this.ad.a(this.adViewImpl.getOpensNativeBrowser());
        this.ad.b(this.adViewImpl.isCloseMarketDialog());
        if (motionEvent == null) {
            this.ad.a(this, "100", "200", "105", "206", String.valueOf(j6), String.valueOf(j7), this.f12533c, this.adViewImpl.getAdParameters().a());
        } else {
            this.ad.a(this, motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "", String.valueOf(j6), String.valueOf(j7), this.f12533c, this.adViewImpl.getAdParameters().a());
        }
        this.f12533c = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        this.f12552v = true;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = this.F;
                if (currentTimeMillis - j6 < 1000 && this.I) {
                    motionEvent2 = motionEvent;
                    handleClickView(motionEvent2, j6, currentTimeMillis);
                }
            } else if (action == 2 && this.I && a(this.G, this.H, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                this.I = false;
            }
            motionEvent2 = motionEvent;
        } else {
            motionEvent2 = motionEvent;
            this.F = System.currentTimeMillis();
            this.G = motionEvent2.getX();
            this.H = motionEvent2.getY();
            this.I = true;
        }
        return super.onTouchEvent(motionEvent2);
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        super.scrollTo(0, 0);
    }

    @Override // com.beizi.ad.internal.view.c
    public void visible() {
        Handler handler;
        AdViewImpl adViewImpl;
        setVisibility(0);
        this.adViewImpl.showAdLogo(this);
        this.adViewImpl.addDownloadTextView(this);
        k kVar = k.BANNER;
        if (kVar.equals(this.adViewImpl.getMediaType())) {
            AdViewImpl adViewImpl2 = this.adViewImpl;
            adViewImpl2.showBannerCloseBtn(adViewImpl2);
        }
        if (shouldDisplayButton() && (adViewImpl = this.adViewImpl) != null) {
            if (adViewImpl.getMediaType() == k.INTERSTITIAL) {
                this.adViewImpl.addInterstitialCloseButton(getShowCloseBtnTime(), getAutoCloseTime(), this, this.ad.x() == f.a.ADP_IVIDEO);
            } else {
                this.adViewImpl.isLoadToShow(this);
            }
        }
        AdViewImpl adViewImpl3 = this.adViewImpl;
        if (adViewImpl3 == null || adViewImpl3.getAdDispatcher() == null || this.adViewImpl.getMediaType() != kVar || (handler = this.f12547q) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.beizi.ad.internal.view.AdWebView.3
            @Override // java.lang.Runnable
            public void run() {
                AdWebView.this.adViewImpl.getAdDispatcher().a();
                AdWebView adWebView = AdWebView.this;
                com.beizi.ad.internal.f.c cVar = adWebView.ad;
                if (cVar != null) {
                    cVar.a(adWebView, adWebView.adViewImpl.getAdParameters().a());
                }
            }
        }, 500L);
    }

    public AdWebView(AdViewImpl adViewImpl) {
        super(new MutableContextWrapper(adViewImpl.getContext()));
        this.f12534d = false;
        this.ad = null;
        this.mAdVideoView = null;
        this.f12531a = false;
        this.f12545o = false;
        this.f12546p = false;
        this.f12547q = new Handler();
        this.f12548r = false;
        this.f12551u = false;
        this.f12552v = false;
        this.f12555y = -1;
        this.f12556z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.f12533c = false;
        this.J = null;
        this.K = null;
        this.L = new Runnable() { // from class: com.beizi.ad.internal.view.AdWebView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AdWebView.this.f12548r) {
                    return;
                }
                AdWebView.this.f();
                AdWebView.this.f12547q.postDelayed(this, 1000L);
            }
        };
        setBackgroundColor(0);
        this.adViewImpl = adViewImpl;
        this.f12532b = f.f12667a[f.b.STARTING_DEFAULT.ordinal()];
        a();
        b();
        setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        if (o.a(str)) {
            return str;
        }
        Resources resources = getResources();
        StringBuilder sb = new StringBuilder("<html><head><script>");
        if (resources == null || !o.a(sb, o.f12115b) || !o.a(sb, o.f12114a) || !o.a(sb)) {
            return str;
        }
        sb.append("</script></head>");
        return str.replaceFirst("<html>", Matcher.quoteReplacement(sb.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        return !o.a(str) ? str.replaceFirst("<head>", Matcher.quoteReplacement(new StringBuilder("<head><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no\"/>").toString())) : str;
    }

    private boolean g(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            this.adViewImpl.getContext().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            if (this.f12535e) {
                Toast.makeText(this.adViewImpl.getContext(), R.string.beizi_action_cant_be_completed, 0).show();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(String str) {
        String b6 = com.beizi.ad.lance.a.b.b("aHR0cDovL2Fib3V0OmJsYW5r");
        if (str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) || str.startsWith(b6)) {
            return false;
        }
        return g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f12546p) {
            this.f12548r = false;
            this.f12547q.removeCallbacks(this.L);
            this.f12547q.post(this.L);
        }
    }

    private void j() {
        this.f12548r = true;
        this.f12547q.removeCallbacks(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl == null || !(adViewImpl instanceof InterstitialAdViewImpl)) {
            return;
        }
        ((InterstitialAdViewImpl) adViewImpl).g();
    }

    private void setCreativeHeight(int i6) {
        this.f12543m = i6;
    }

    private void setCreativeWidth(int i6) {
        this.f12542l = i6;
    }

    public boolean IsVideoWifiOnly() {
        return this.D;
    }

    public void closeWebResourceRequestConnection() {
        try {
            InputStream inputStream = this.K;
            if (inputStream != null) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.J;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.ad.internal.view.c
    public boolean failed() {
        return this.f12534d;
    }

    public void fireMRAIDEnabled() {
        if (this.f12535e) {
            return;
        }
        this.f12535e = true;
        if (this.f12539i) {
            this.f12536f.a(this, this.f12532b);
            i();
        }
    }

    public HashMap<String, Object> getAdExtras() {
        com.beizi.ad.internal.f.c cVar = this.ad;
        if (cVar == null) {
            return null;
        }
        return cVar.j();
    }

    public int getAutoCloseTime() {
        return this.f12554x;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeHeight() {
        return this.f12543m;
    }

    public int getCreativeLeft() {
        return this.f12540j;
    }

    public int getCreativeTop() {
        return this.f12541k;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getCreativeWidth() {
        return this.f12542l;
    }

    protected f getMRAIDImplementation() {
        return this.f12536f;
    }

    public int getOrientation() {
        return this.f12549s;
    }

    public com.beizi.ad.internal.view.c getRealDisplayable() {
        AdVideoView adVideoView;
        return (!this.C || (adVideoView = this.mAdVideoView) == null) ? this : adVideoView;
    }

    @Override // com.beizi.ad.internal.view.c
    public int getRefreshInterval() {
        return this.f12544n;
    }

    public int getShowCloseBtnTime() {
        return this.f12553w;
    }

    boolean getUserInteraction() {
        return this.f12552v;
    }

    public boolean isAutoPlay() {
        return this.f12556z;
    }

    public boolean isMRAIDUseCustomClose() {
        return this.f12551u;
    }

    public boolean isMuted() {
        return this.A;
    }

    public boolean isVideoFullScreen() {
        return this.B;
    }

    public void loadAd(com.beizi.ad.internal.f.c cVar) {
        int i6;
        if (cVar == null) {
            return;
        }
        this.ad = cVar;
        setCreativeHeight(cVar.c());
        setCreativeWidth(cVar.d());
        setCreativeLeft(cVar.u());
        setCreativeTop(cVar.t());
        setRefreshInterval(cVar.w());
        if (cVar.o()) {
            this.f12553w = cVar.r();
        } else {
            this.f12553w = -1;
        }
        if (!cVar.n() || cVar.s() == 0) {
            this.f12554x = -1;
        } else {
            this.f12554x = cVar.s();
        }
        if (this.f12553w == -1 && this.f12554x == -1 && cVar.x() != f.a.ADP_IVIDEO) {
            this.f12553w = 0;
        } else {
            int i7 = this.f12553w;
            if (i7 != -1 && (i6 = this.f12554x) != -1 && i7 > i6) {
                this.f12553w = i6;
            }
        }
        this.f12556z = cVar.p();
        this.A = cVar.m();
        this.B = cVar.k();
        this.f12549s = cVar.v();
        this.D = cVar.l();
        this.f12555y = -1;
        setInitialScale((int) ((com.beizi.ad.internal.h.a().i() * 100.0f) + 0.5f));
        loadAdAt(0);
    }

    public boolean loadAdAt(int i6) {
        int creativeHeight;
        int creativeWidth;
        AdWebView adWebView;
        com.beizi.ad.internal.f.c cVar = this.ad;
        if (cVar != null && this.f12555y != i6) {
            if (!cVar.b().isEmpty() && this.ad.b().size() > i6) {
                Pair<j, String> pair = this.ad.b().get(i6);
                if (o.a((String) pair.second)) {
                    h();
                    return false;
                }
                if (pair.first == j.VIDEO) {
                    if (this.mAdVideoView == null) {
                        this.mAdVideoView = new AdVideoView(this);
                    }
                    this.mAdVideoView.transferAd(this, (String) pair.second);
                    this.C = true;
                    String b6 = com.beizi.ad.lance.a.b.b("aHR0cDovL2Fib3V0OmJsYW5r");
                    if (!TextUtils.isEmpty(b6)) {
                        loadUrl(b6, com.beizi.ad.lance.a.j.a());
                    }
                    adWebView = this;
                } else {
                    a(this.ad.j());
                    String f6 = f(e(d((String) pair.second)));
                    float g6 = com.beizi.ad.internal.h.a().g();
                    float h6 = com.beizi.ad.internal.h.a().h();
                    float i7 = com.beizi.ad.internal.h.a().i();
                    if (getCreativeWidth() == -1 && getCreativeHeight() == -1) {
                        creativeWidth = -1;
                        creativeHeight = -1;
                    } else {
                        creativeHeight = (int) ((getCreativeHeight() * i7) + 0.5f);
                        creativeWidth = (int) ((getCreativeWidth() * i7) + 0.5f);
                    }
                    if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17);
                        k kVar = this.ad.f11907a;
                        if (kVar == k.SPLASH) {
                            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                        } else if (kVar == k.BANNER) {
                            a(new FrameLayout.LayoutParams(-2, -1, 17));
                        } else {
                            a(layoutParams);
                        }
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                        layoutParams2.setMargins((int) ((getCreativeLeft() * g6) + 0.5f), (int) ((getCreativeTop() * h6) + 0.5f), 0, 0);
                        if (this.ad.f11907a == k.SPLASH) {
                            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                        } else {
                            a(layoutParams2);
                        }
                    }
                    adWebView = this;
                    adWebView.loadDataWithBaseURL(null, f6, "text/html", "UTF-8", null);
                    adWebView.C = false;
                }
                adWebView.f12555y = i6;
                return true;
            }
            h();
        }
        return false;
    }

    public boolean loadAdBy(int i6) {
        return loadAdAt(this.f12555y + i6);
    }

    public void resize(int i6, int i7, int i8, int i9, f.a aVar, boolean z5) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        f fVar = this.f12536f;
        if (!fVar.f12670d) {
            this.f12537g = layoutParams.width;
            this.f12538h = layoutParams.height;
        }
        float f6 = displayMetrics.density;
        int i10 = (int) ((i7 * f6) + 0.5d);
        int i11 = (int) ((i6 * f6) + 0.5d);
        layoutParams.height = i10;
        layoutParams.width = i11;
        layoutParams.gravity = 17;
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.a(i11, i10, i8, i9, aVar, z5, fVar);
        }
        AdViewImpl adViewImpl2 = this.adViewImpl;
        if (adViewImpl2 != null) {
            adViewImpl2.f();
        }
        setLayoutParams(layoutParams);
    }

    public void setCreativeLeft(int i6) {
        this.f12540j = i6;
    }

    public void setCreativeTop(int i6) {
        this.f12541k = i6;
    }

    public void setMRAIDUseCustomClose(boolean z5) {
        this.f12551u = z5;
    }

    public void setRefreshInterval(int i6) {
        this.f12544n = i6;
    }

    public boolean shouldDisplayButton() {
        if (this.ad.x() == f.a.ADP_BANNER) {
            return false;
        }
        return this.ad.x() == f.a.ADP_IVIDEO ? this.ad.b().get(this.f12555y).first == j.VIDEO : this.f12555y == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if (o.a(str)) {
            return str;
        }
        str.getClass();
        if (str.startsWith("<html>")) {
            return str;
        }
        return "<html><body style='padding:0;margin:0;'>" + str + "</body></html>";
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void b() {
        this.f12536f = new f(this);
        try {
            if (getContextFromMutableContext() instanceof Activity) {
                setWebChromeClient(new h(this));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        setWebViewClient(new a());
    }

    void c() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.f();
        }
    }

    public Context getContextFromMutableContext() {
        if (getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) getContext()).getBaseContext();
        }
        return getContext();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f();
    }

    @Override // com.beizi.ad.internal.view.c
    public void onDestroy() {
        destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ProgressDialog progressDialog = this.f12550t;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f12550t.dismiss();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        a(getWindowVisibility(), i6);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        a(i6, getVisibility());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f12534d = true;
    }

    protected void c(String str) {
        evaluateJavascript(str, null);
    }

    protected void f() {
        if (getContextFromMutableContext() instanceof Activity) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            boolean z5 = false;
            int i6 = iArr[0];
            int width = getWidth() + i6;
            int i7 = iArr[1];
            int height = getHeight() + i7;
            int[] a6 = u.a((Activity) getContextFromMutableContext());
            if (width > 0 && i6 < a6[0] && height > 0 && i7 < a6[1]) {
                z5 = true;
            }
            this.f12545o = z5;
            f fVar = this.f12536f;
            if (fVar != null) {
                fVar.b();
                this.f12536f.a(i6, i7, getWidth(), getHeight());
                this.f12536f.a(getContext().getResources().getConfiguration().orientation);
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void a() {
        try {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            getSettings().setBuiltInZoomControls(false);
            getSettings().setEnableSmoothTransition(true);
            getSettings().setLightTouchEnabled(false);
            getSettings().setPluginState(WebSettings.PluginState.ON);
            getSettings().setLoadsImagesAutomatically(true);
            getSettings().setSavePassword(false);
            getSettings().setSupportZoom(false);
            getSettings().setUseWideViewPort(false);
            getSettings().setMediaPlaybackRequiresUserGesture(false);
            getSettings().setMixedContentMode(0);
            WebView.setWebContentsDebuggingEnabled(false);
            getSettings().setAllowFileAccess(false);
            getSettings().setAllowContentAccess(false);
            getSettings().setAllowFileAccessFromFileURLs(false);
            getSettings().setAllowUniversalAccessFromFileURLs(false);
            getSettings().setGeolocationEnabled(false);
            CookieManager cookieManager = CookieManager.getInstance();
            if (cookieManager != null) {
                cookieManager.setAcceptThirdPartyCookies(this, true);
            }
            setHorizontalScrollbarOverlay(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollbarOverlay(false);
            setVerticalScrollBarEnabled(false);
            if (this.B) {
                setBackgroundColor(0);
            }
            setScrollBarStyle(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void b(String str) {
        if (!this.adViewImpl.getOpensNativeBrowser()) {
            if (h(str)) {
                return;
            }
            try {
                if (this.adViewImpl.getLoadsInBackground()) {
                    final c cVar = new c(getContext());
                    cVar.loadUrl(str, com.beizi.ad.lance.a.j.a());
                    cVar.setVisibility(8);
                    this.adViewImpl.addView(cVar);
                    if (this.adViewImpl.getShowLoadingIndicator()) {
                        ProgressDialog progressDialog = new ProgressDialog(getContextFromMutableContext());
                        this.f12550t = progressDialog;
                        progressDialog.setCancelable(true);
                        this.f12550t.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.beizi.ad.internal.view.AdWebView.2
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                cVar.stopLoading();
                            }
                        });
                        this.f12550t.setMessage(getContext().getResources().getString(R.string.beizi_loading));
                        this.f12550t.setProgressStyle(0);
                        this.f12550t.show();
                        return;
                    }
                    return;
                }
                WebView webView = new WebView(new MutableContextWrapper(getContext()));
                x.a(webView);
                webView.loadUrl(str, com.beizi.ad.lance.a.j.a());
                a(webView);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        g(str);
        k();
    }

    void d() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.c();
        }
    }

    boolean g() {
        return this.f12545o && this.f12546p;
    }

    void e() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.a(this.f12537g, this.f12538h, this.f12536f);
        }
    }

    public void handleClickView(com.beizi.ad.model.d dVar, long j6, long j7, int i6) {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null || this.adViewImpl.isRewardedVideo()) {
            return;
        }
        this.E++;
        this.adViewImpl.getAdDispatcher().d();
        this.ad.a(this.adViewImpl.getOpensNativeBrowser());
        this.ad.b(this.adViewImpl.isCloseMarketDialog());
        this.ad.a(this, dVar, String.valueOf(j6), String.valueOf(j7), this.f12533c, this.adViewImpl.getAdParameters().a(), i6);
        this.f12533c = true;
    }

    @Override // com.beizi.ad.internal.view.c
    public View getView() {
        return this;
    }

    private void a(FrameLayout.LayoutParams layoutParams) {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl instanceof BannerAdViewImpl) {
            if (((BannerAdViewImpl) adViewImpl).getResizeAdToFitContainer()) {
                setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                return;
            } else {
                setLayoutParams(layoutParams);
                return;
            }
        }
        setLayoutParams(layoutParams);
    }

    private void a(HashMap hashMap) {
        if (!hashMap.isEmpty() && hashMap.containsKey("MRAID")) {
            this.f12535e = ((Boolean) hashMap.get("MRAID")).booleanValue();
        }
    }

    protected void a(final String str) {
        new com.beizi.ad.internal.h.d(false, true) { // from class: com.beizi.ad.internal.view.AdWebView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.beizi.ad.internal.h.d, android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(com.beizi.ad.internal.h.e eVar) {
                if (eVar.a()) {
                    AdWebView.this.loadDataWithBaseURL(null, AdWebView.this.f(AdWebView.this.e(AdWebView.this.d(eVar.c()))), "text/html", "UTF-8", null);
                    AdWebView.this.fireMRAIDEnabled();
                }
            }

            @Override // com.beizi.ad.internal.h.d
            protected String a() {
                return str;
            }
        }.execute(new Void[0]);
    }

    private static float a(float f6, float f7, float f8, float f9) {
        float f10 = f6 - f8;
        float f11 = f7 - f9;
        return a((float) Math.sqrt((f10 * f10) + (f11 * f11)));
    }

    private static float a(float f6) {
        return f6 / com.beizi.ad.internal.h.a().j().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        try {
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            String str = "*/*";
            if (requestHeaders != null && requestHeaders.size() > 0 && requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            }
            Uri url = webResourceRequest.getUrl();
            if (url == null) {
                return null;
            }
            String uri = url.toString();
            if (!uri.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            this.J = httpURLConnection;
            httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
            this.J.setRequestProperty("X-Requested-With", "");
            this.J.setRequestProperty("Accept", str);
            this.J.setRequestProperty("User-Agent", com.beizi.ad.internal.h.a().f12000e);
            this.K = this.J.getInputStream();
            return new WebResourceResponse(str, "UTF-8", this.K);
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WebView webView) {
        Intent intent = new Intent(this.adViewImpl.getContext(), (Class<?>) AdActivity.a());
        intent.setFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        com.beizi.ad.internal.activity.a.f11616a.add(webView);
        if (this.adViewImpl.getBrowserStyle() != null) {
            String str = "" + super.hashCode();
            intent.putExtra("bridgeid", str);
            AdViewImpl.c.f12530a.add(new Pair<>(str, this.adViewImpl.getBrowserStyle()));
        }
        try {
            this.adViewImpl.getContext().startActivity(intent);
            k();
        } catch (ActivityNotFoundException unused) {
            com.beizi.ad.internal.activity.a.f11616a.remove();
        }
    }

    private void a(int i6, int i7) {
        if (i6 == 0 && i7 == 0) {
            x.b(this);
            this.f12546p = true;
            if (this.f12535e && this.f12539i) {
                i();
            }
        } else {
            x.c(this);
            this.f12546p = false;
            j();
        }
        f fVar = this.f12536f;
        if (fVar != null) {
            fVar.b();
        }
    }

    void a(int i6, int i7, boolean z5, final f fVar, final boolean z6, final AdActivity.b bVar) {
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        if (!this.f12536f.f12670d) {
            this.f12537g = layoutParams.width;
            this.f12538h = layoutParams.height;
        }
        if (i7 == -1 && i6 == -1 && this.adViewImpl != null) {
            this.f12531a = true;
        }
        if (i7 != -1) {
            i7 = (int) ((i7 * r0.density) + 0.5d);
        }
        int i8 = i7;
        if (i6 != -1) {
            i6 = (int) ((i6 * r0.density) + 0.5d);
        }
        int i9 = i6;
        layoutParams.height = i8;
        layoutParams.width = i9;
        layoutParams.gravity = 17;
        b bVar2 = this.f12531a ? new b() { // from class: com.beizi.ad.internal.view.AdWebView.4
            @Override // com.beizi.ad.internal.view.AdWebView.b
            public void a() {
                f fVar2 = fVar;
                if (fVar2 == null || fVar2.c() == null) {
                    return;
                }
                AdWebView.this.a(fVar.c(), z6, bVar);
                AdViewImpl.setMRAIDFullscreenListener(null);
            }
        } : null;
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.a(i9, i8, z5, fVar, bVar2);
            this.adViewImpl.f();
        }
        setLayoutParams(layoutParams);
    }

    protected void a(Activity activity, boolean z5, AdActivity.b bVar) {
        AdActivity.b bVar2 = AdActivity.b.none;
        if (bVar != bVar2) {
            AdActivity.a(activity, bVar);
        }
        if (z5) {
            AdActivity.b(activity);
        } else if (bVar == bVar2) {
            AdActivity.a(activity);
        }
    }
}
