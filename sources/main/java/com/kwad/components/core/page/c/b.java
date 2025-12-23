package com.kwad.components.core.page.c;

import android.annotation.SuppressLint;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends Presenter {
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private as.b eW = new as.b() { // from class: com.kwad.components.core.page.c.b.1
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
        }
    };
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new af(this.eQ));
        aVar.a(new ai(this.eQ));
        aVar.a(new as(this.eW, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))));
        aVar.a(new am(this.eQ));
        aVar.b(new o(this.eQ));
        aVar.b(new n(this.eQ));
    }

    private void bc() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.eQ;
        bVar2.mScreenOrientation = 0;
        bVar2.Ta = this.mAdWebView;
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void be() {
        bf();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.eP = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.eP, "KwaiAd");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mAdTemplate = ((com.kwad.components.core.page.recycle.e) NN()).adTemplate;
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.ksad_video_webView);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().bD(true).eJ(this.mAdTemplate));
        bc();
        be();
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)));
        this.mAdWebView.onActivityCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        bf();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
    }
}
