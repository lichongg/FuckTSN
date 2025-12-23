package com.kwad.components.core.page.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends c {
    private int TF = -1;
    private ViewGroup TG;
    private final a TH;
    private WebView Ta;
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void aP(int i6);
    }

    private void bc() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.eQ;
        bVar2.TG = this.TG;
        bVar2.Ta = this.Ta;
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    private aq.a getOpenNewPageListener() {
        return new aq.a() { // from class: com.kwad.components.core.page.c.f.2
            @Override // com.kwad.components.core.webview.jshandler.aq.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(f.this.Ta.getContext(), new AdWebViewActivityProxy.a.C0627a().az(bVar.title).aA(bVar.url).aF(true).aD(f.this.mAdTemplate).qW());
            }
        };
    }

    private as.b rd() {
        return new as.b() { // from class: com.kwad.components.core.page.c.f.1
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar) {
                f.this.TF = aVar.status;
                if (f.this.TH != null) {
                    f.this.TH.aP(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.TG.setVisibility(0);
                } else {
                    f.this.Ta.setVisibility(8);
                }
            }
        };
    }

    public f(a aVar, boolean z5) {
        this.TH = aVar;
        this.mIsRewardLandPage = z5;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.c.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.TD.mAdTemplate);
        aVar.a(new af(this.eQ));
        aVar.a(new ai(this.eQ));
        aVar.a(new bc(this.eQ, cVar));
        aVar.a(new ae(this.eQ));
        aVar.a(new az());
        aVar.a(new as(rd(), com.kwad.sdk.core.response.b.b.cI(this.mAdTemplate)));
        aVar.a(new am(this.eQ));
        aVar.b(new o(this.eQ));
        aVar.b(new n(this.eQ));
        aVar.a(new aq(getOpenNewPageListener()));
        aVar.a(new ac(this.eQ, cVar, null, (byte) 0));
        aVar.a(new z(this.eQ, cVar, null, 2, this.mIsRewardLandPage));
    }

    private void aB(String str) {
        be();
        this.Ta.loadUrl(str);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void be() {
        bf();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Ta);
        this.eP = aVar;
        a(aVar);
        this.Ta.addJavascriptInterface(this.eP, "KwaiAd");
    }

    @Override // com.kwad.components.core.page.c.c, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdTemplate adTemplate = this.TD.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String cI = com.kwad.sdk.core.response.b.b.cI(adTemplate);
        if (!TextUtils.isEmpty(cI)) {
            bc();
            aB(cI);
        } else {
            a aVar = this.TH;
            if (aVar != null) {
                aVar.aP(this.TF);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Ta = (WebView) findViewById(R.id.ksad_landing_page_webview);
        this.TG = (ViewGroup) findViewById(R.id.ksad_web_card_container);
        this.Ta.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bf();
    }
}
