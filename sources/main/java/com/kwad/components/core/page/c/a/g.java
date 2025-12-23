package com.kwad.components.core.page.c.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bg;
import com.kwad.components.core.webview.tachikoma.c.l;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends a implements com.kwad.components.core.webview.jshandler.a.c {
    private static final Handler iK = new Handler(Looper.getMainLooper());
    public AdWebViewActivityProxy.a Tu;
    private az Ul;
    private av Um;
    private String Un;
    private Runnable Uo;
    private com.kwad.components.core.webview.b iP;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean Uj = false;
    private boolean Uk = false;
    private final com.kwad.sdk.core.c.c An = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.g.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView != null && g.this.getActivity() != null && g.this.getActivity().equals(activity)) {
                g.this.mAdWebView.onActivityDestroy();
                g.a(g.this, (KsAdWebView) null);
            }
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }
    };
    private com.kwad.components.core.webview.jshandler.b TN = new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.core.page.c.a.g.3
        @Override // com.kwad.components.core.webview.jshandler.b
        public final void rs() {
            if (g.this.Um != null) {
                g.this.Um.uE();
            }
        }
    };
    private com.kwad.components.core.webview.c iQ = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.c.a.g.4
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bg(new bg.b() { // from class: com.kwad.components.core.page.c.a.g.4.1
                @Override // com.kwad.components.core.webview.jshandler.bg.b
                public final void a(bg.a aVar2) {
                    f.a aVar3 = g.this.TJ.TM;
                    if (aVar3 == null || aVar2 == null) {
                        return;
                    }
                    aVar3.aQ(aVar2.visibility);
                }
            }));
            g.this.Um = new av(new av.b() { // from class: com.kwad.components.core.page.c.a.g.4.2
                @Override // com.kwad.components.core.webview.jshandler.av.b
                public final void rv() {
                    g gVar = g.this;
                    gVar.TJ.a(gVar.TN);
                }
            });
            aVar.a(g.this.Um);
            aVar.a(new com.kwad.components.core.webview.tachikoma.b.b(bVar, g.this.TJ.mAdTemplate));
            l lVar = new l();
            lVar.ahe = g.this.TJ.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.b.g(lVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean rt() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean ru() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i6, String str) {
            g.this.Uj = false;
            g gVar = g.this;
            com.kwad.sdk.commercial.g.a.a(gVar.mAdTemplate, gVar.Tu.qS(), g.this.Tu.qR(), i6, str);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.Uj = true;
            if (!g.this.Uk) {
                g.b(g.this, true);
                g gVar = g.this;
                com.kwad.sdk.commercial.g.a.m(gVar.mAdTemplate, gVar.Tu.qS(), g.this.Tu.qR());
            }
            if (g.this.TJ.rf()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(az azVar) {
            g.this.Ul = azVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(as.a aVar) {
            g.this.TJ.TO = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.webview.d.a.b bVar = g.this.TJ.mWebCardCloseListener;
            if (bVar != null) {
                bVar.b(webCloseStatus);
            }
        }
    };

    static /* synthetic */ boolean b(g gVar, boolean z5) {
        gVar.Uk = true;
        return true;
    }

    private void ft() {
        this.iP = new com.kwad.components.core.webview.b();
        this.iP.a(new b.a().aM(this.TJ.mAdTemplate).aP(this.TJ.mPageUrl).d(this.mAdWebView).k(this.TJ.jI).a(this.iQ).b(this.TJ.TL).a(this));
        rp();
        com.kwad.sdk.commercial.g.a.l(this.mAdTemplate, this.Tu.qS(), this.Tu.qR());
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.components.core.page.c.a.g.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
                com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
                AdInfo el = com.kwad.sdk.core.response.b.e.el(g.this.mAdTemplate);
                g.this.Un = str;
                if (!com.kwad.sdk.core.response.b.a.bk(el) || !am.dd(g.this.TJ.mContext) || !am.gY(str)) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                final c.a clientConfig = g.this.mAdWebView.getClientConfig();
                final com.kwad.components.core.urlReplace.c cVar2 = new com.kwad.components.core.urlReplace.c();
                final Object obj = new Object();
                g.this.Uo = new Runnable() { // from class: com.kwad.components.core.page.c.a.g.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        synchronized (obj) {
                            try {
                                com.kwad.components.core.urlReplace.c cVar3 = cVar2;
                                if (cVar3 != null) {
                                    cVar3.sU();
                                }
                                c.a aVar = clientConfig;
                                if (aVar == null || !aVar.KQ() || !clientConfig.KM()) {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Un) == 1) {
                                    com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, false);
                                } else {
                                    com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, false);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                };
                g.iK.postDelayed(g.this.Uo, com.kwad.sdk.core.response.b.a.bl(el));
                cVar2.a(str, new com.kwad.components.core.urlReplace.a() { // from class: com.kwad.components.core.page.c.a.g.1.2
                    @Override // com.kwad.components.core.urlReplace.a
                    public final void onSuccess(String str2) {
                        synchronized (obj) {
                            try {
                                g.this.Un = str2;
                                if (g.this.Uo != null) {
                                    g.iK.removeCallbacks(g.this.Uo);
                                }
                                c.a aVar = clientConfig;
                                if (aVar == null || !aVar.KQ() || !clientConfig.KM()) {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                } else if (com.kwad.sdk.core.webview.a.c.a(clientConfig, g.this.Un) == 1) {
                                    com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, true);
                                } else {
                                    com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, true);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
                return true;
            }
        };
        cVar.setClientConfig(this.mAdWebView.getClientConfig());
        this.mAdWebView.setWebViewClient(cVar);
        this.mAdWebView.loadUrl(this.TJ.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void rp() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().bD(true).eJ(this.TJ.mAdTemplate).bB(false));
        if (com.kwad.sdk.core.response.b.a.bL(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate)) > 0) {
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.g.5
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().bB(true);
                    }
                }
            }, com.kwad.sdk.core.response.b.a.bL(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.b.a.bL(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().bB(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.c.a.g.6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    g.this.mAdWebView.getClientConfig().bB(true);
                    return false;
                }
                return false;
            }
        });
    }

    public final void hide() {
        az azVar = this.Ul;
        if (azVar != null) {
            azVar.uH();
        }
        KsAdWebView ksAdWebView = this.TJ.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        az azVar2 = this.Ul;
        if (azVar2 != null) {
            azVar2.uI();
        }
    }

    public final void show() {
        if (this.Uj) {
            az azVar = this.Ul;
            if (azVar != null) {
                azVar.uF();
            }
            try {
                KsAdWebView ksAdWebView = this.TJ.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(0);
                }
            } catch (Exception e6) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e6);
            }
            az azVar2 = this.Ul;
            if (azVar2 != null) {
                azVar2.uG();
            }
        }
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        b bVar = this.TJ;
        this.Tu = bVar.Tu;
        this.mAdTemplate = bVar.mAdTemplate;
        ft();
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(this.An);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.iP.kz();
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.b(this.An);
    }

    @Override // com.kwad.components.core.webview.jshandler.a.c
    public final void rq() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }
}
