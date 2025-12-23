package com.kwad.components.core.webview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bh;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.components.core.webview.tachikoma.b.j;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.components.core.webview.tachikoma.b.l;
import com.kwad.components.core.webview.tachikoma.b.s;
import com.kwad.components.core.webview.tachikoma.c.g;
import com.kwad.components.core.webview.tachikoma.c.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.download.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private KsAdWebView LZ;
    private KsAdWebView.c TL;
    private ViewGroup abL;
    private com.kwad.components.core.webview.a.a abM;
    private aw abN;
    private d abO;
    private boolean abP;
    private com.kwad.components.core.webview.jshandler.a.c abQ;
    private as.b abR = new as.b() { // from class: com.kwad.components.core.webview.b.13
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
            if (b.this.iQ != null) {
                b.this.iQ.a(aVar);
            }
        }
    };
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private c iQ;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mPageUrl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private KsAdWebView LZ;
        private KsAdWebView.c TL;
        private ViewGroup abL;
        private boolean abP;
        private com.kwad.components.core.webview.jshandler.a.c abQ;
        private c iQ;
        private AdTemplate mAdTemplate;
        private com.kwad.components.core.e.d.c mApkDownloadHelper;
        private String mPageUrl;
        private JSONObject mReportExtData;

        @Nullable
        public final a a(c cVar) {
            this.iQ = cVar;
            return this;
        }

        public final a a(com.kwad.components.core.webview.jshandler.a.c cVar) {
            this.abQ = cVar;
            return this;
        }

        @Nullable
        public final a aM(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        @NonNull
        public final a aP(String str) {
            this.mPageUrl = str;
            return this;
        }

        public final a aV(boolean z5) {
            this.abP = z5;
            return this;
        }

        @Nullable
        public final a b(KsAdWebView.c cVar) {
            this.TL = cVar;
            return this;
        }

        @NonNull
        public final a d(KsAdWebView ksAdWebView) {
            this.LZ = ksAdWebView;
            return this;
        }

        public final a e(JSONObject jSONObject) {
            this.mReportExtData = jSONObject;
            return this;
        }

        public final a f(com.kwad.components.core.e.d.c cVar) {
            this.mApkDownloadHelper = cVar;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final com.kwad.components.core.e.d.c ij() {
            return this.mApkDownloadHelper;
        }

        @NonNull
        public final a k(ViewGroup viewGroup) {
            this.abL = viewGroup;
            return this;
        }

        public final String qR() {
            return this.mPageUrl;
        }

        public final KsAdWebView.c rm() {
            return this.TL;
        }

        public final ViewGroup uu() {
            return this.abL;
        }

        public final KsAdWebView uv() {
            return this.LZ;
        }

        public final c uw() {
            return this.iQ;
        }

        public final boolean ux() {
            return this.abP;
        }

        public final com.kwad.components.core.webview.jshandler.a.c uy() {
            return this.abQ;
        }
    }

    private boolean uo() {
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        bf();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.eP = aVar;
        b(aVar, this.eQ);
        c cVar = this.iQ;
        if (cVar != null) {
            cVar.a(this.eP, this.eQ);
        }
        ksAdWebView.addJavascriptInterface(this.eP, "KwaiAd");
    }

    private void bc() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.eQ;
        bVar2.mScreenOrientation = 0;
        bVar2.Ta = this.LZ;
        bVar2.TG = this.abL;
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
        com.kwad.components.core.webview.a.a aVar2 = this.abM;
        if (aVar2 != null) {
            aVar2.destroy();
            this.abM = null;
        }
    }

    private void c(KsAdWebView ksAdWebView) {
        bf();
        com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.eQ);
        this.abM = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    private void ft() {
        this.LZ.setClientConfig(this.LZ.getClientConfig().eJ(this.mAdTemplate).dS(us()).b(ur()).a(uq()).c(this.TL));
    }

    @NonNull
    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.core.webview.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (b.this.iQ != null) {
                    b.this.iQ.a(aVar);
                }
            }
        };
    }

    private boolean un() {
        c cVar = this.iQ;
        if (cVar == null) {
            return false;
        }
        return cVar.ru();
    }

    private am.a up() {
        return new am.a() { // from class: com.kwad.components.core.webview.b.3
            @Override // com.kwad.components.core.webview.jshandler.am.a
            public final void onAdShow() {
                if (b.this.iQ != null) {
                    b.this.iQ.onAdShow();
                }
            }
        };
    }

    @NonNull
    private KsAdWebView.b uq() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.webview.b.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (b.this.abN != null) {
                    b.this.abN.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (b.this.abN != null) {
                    b.this.abN.onSuccess();
                }
            }
        };
    }

    private KsAdWebView.e ur() {
        return new KsAdWebView.e() { // from class: com.kwad.components.core.webview.b.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (b.this.iQ != null) {
                    b.this.iQ.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i6, String str, String str2) {
                if (b.this.iQ != null) {
                    b.this.iQ.h(i6, str);
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }
        };
    }

    private int us() {
        return com.kwad.sdk.core.response.b.a.S(e.el(this.mAdTemplate)) ? 5 : 1;
    }

    public final void a(a aVar) {
        this.mPageUrl = aVar.qR();
        this.mAdTemplate = aVar.getAdTemplate();
        this.abL = aVar.uu();
        this.LZ = aVar.uv();
        this.iQ = aVar.uw();
        this.mApkDownloadHelper = aVar.ij();
        this.abP = aVar.ux();
        this.TL = aVar.rm();
        this.abQ = aVar.uy();
        ft();
        a(this.iQ, this.LZ);
        bc();
        if (com.kwad.sdk.core.response.b.a.P(e.el(this.mAdTemplate))) {
            c(this.LZ);
        } else if (com.kwad.sdk.core.response.b.b.ey(this.mPageUrl)) {
            b(this.LZ);
        }
    }

    public final void kz() {
        bf();
        if (this.abO != null) {
            com.kwad.sdk.core.download.b.GR().a(this.abO);
        }
        this.abQ = null;
    }

    private void b(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
        az azVar = new az();
        aVar.a(azVar);
        a(azVar);
        aVar.a(new v());
        aVar.a(new com.kwad.components.core.webview.jshandler.d());
        aVar.a(new w());
        aVar.a(new q());
        aVar.a(new r());
        am amVar = new am(bVar);
        aVar.b(new o(bVar));
        aVar.b(new n(bVar));
        amVar.a(up());
        aVar.a(amVar);
        aVar.a(new af(bVar));
        aVar.a(new f());
        if (this.mApkDownloadHelper == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        if (!this.abP) {
            aVar.a(new ac(this.eQ, this.mApkDownloadHelper, getClickListener(), un(), false, true));
            aVar.a(new z(this.eQ, this.mApkDownloadHelper, getClickListener(), un(), 0, uo(), true));
        }
        aVar.a(new bc(this.eQ, this.mApkDownloadHelper));
        aVar.a(new au(this.eQ));
        aVar.a(new ar(this.eQ.Ta.getContext(), this.mAdTemplate));
        aVar.a(new bh(new bh.a() { // from class: com.kwad.components.core.webview.b.1
            @Override // com.kwad.components.core.webview.jshandler.bh.a
            public final void ut() {
                if (com.kwad.sdk.core.response.b.b.dp(b.this.mAdTemplate)) {
                    com.kwad.components.core.e.c.b.a(b.this.eQ.Ta.getContext(), new b.a().aA(b.this.mAdTemplate).ak(com.kwad.sdk.core.response.b.b.m122do(b.this.mAdTemplate)).oZ());
                }
            }
        }));
        aVar.a(new aj(this.eQ));
        aVar.a(new as(this.abR, this.mPageUrl));
        aw awVar = new aw();
        this.abN = awVar;
        aVar.a(awVar);
        aVar.a(new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.b.6
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                if (b.this.iQ != null) {
                    b.this.iQ.a(webCloseStatus);
                }
            }
        }));
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.b.7
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(t tVar) {
                if (TextUtils.isEmpty(tVar.message)) {
                    return;
                }
                com.kwad.sdk.utils.ac.d(b.this.eQ.Ta.getContext(), tVar.message, 0L);
            }
        });
        aVar.a(sVar);
        aVar.a(new k());
        aVar.a(new ai(bVar));
        if (com.kwad.sdk.core.response.b.a.aF(e.el(this.mAdTemplate))) {
            final l lVar = new l();
            aVar.a(lVar);
            this.abO = new d(this.mAdTemplate) { // from class: com.kwad.components.core.webview.b.8
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar2 = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar2.agU = 1;
                    lVar.a(bVar2);
                }
            };
            com.kwad.sdk.core.download.b.GR().a(this.abO, this.mAdTemplate);
        }
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.b.9
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(g gVar) {
                com.kwad.components.core.p.a.se().a(gVar.actionType, b.this.mAdTemplate, gVar.Pj);
            }
        });
        aVar.a(new j() { // from class: com.kwad.components.core.webview.b.10
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar) {
                super.a(oVar);
                AdWebViewActivityProxy.launch(b.this.eQ.Ta.getContext(), new AdWebViewActivityProxy.a.C0627a().az(oVar.title).aA(oVar.url).aF(true).aD(b.this.mAdTemplate).qW());
            }
        });
        aVar.a(new com.kwad.components.core.webview.jshandler.f());
        aVar.a(new i());
        aVar.a(new com.kwad.components.core.webview.jshandler.l());
        aVar.a(new com.kwad.components.core.webview.jshandler.e());
        ae aeVar = new ae(this.eQ);
        aeVar.a(new ae.b() { // from class: com.kwad.components.core.webview.b.11
            @Override // com.kwad.components.core.webview.jshandler.ae.b
            public final void c(ae.a aVar2) {
                if (b.this.iQ != null) {
                    b.this.iQ.b(aVar2);
                }
            }
        });
        aVar.a(aeVar);
        aVar.a(new m(this.eQ.Ta.getContext(), this.mAdTemplate));
        aVar.a(new al(this.eQ, new al.b() { // from class: com.kwad.components.core.webview.b.12
            @Override // com.kwad.components.core.webview.jshandler.al.b
            public final void a(al.a aVar2) {
                if (b.this.iQ != null) {
                    b.this.iQ.a(aVar2);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.k());
        aVar.a(new u());
        aVar.a(new com.kwad.components.core.webview.jshandler.t());
        aVar.a(new com.kwad.components.core.webview.jshandler.s());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.f(this.eQ.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.d(this.eQ.getContext()));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.b(this.abQ));
        aVar.a(new com.kwad.components.core.webview.jshandler.a.a());
        aVar.a(new com.kwad.components.core.webview.jshandler.a.e(this.eQ.getContext()));
    }

    private void a(az azVar) {
        c cVar = this.iQ;
        if (cVar == null) {
            return;
        }
        cVar.a(azVar);
    }

    private static void a(c cVar, WebView webView) {
        if (cVar == null || !cVar.rt()) {
            return;
        }
        webView.getSettings().setAllowFileAccess(true);
    }
}
