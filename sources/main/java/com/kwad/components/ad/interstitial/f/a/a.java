package com.kwad.components.ad.interstitial.f.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.b.i;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a extends com.kwad.components.ad.interstitial.f.b implements j {
    private i fU;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(az azVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.mj.fV;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        this.fU.a(getActivity(), this.mj.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.fU = new i(-1L, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        i iVar = this.fU;
        if (iVar != null) {
            iVar.kz();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.i(new i.a() { // from class: com.kwad.components.ad.interstitial.f.a.a.1
            @Override // com.kwad.components.core.webview.tachikoma.b.i.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                com.kwad.components.ad.interstitial.report.a.eO().a(a.this.mj.mAdTemplate, 1L, 177L);
                a.this.a(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0637a c0637a) {
        c cVar = this.mj;
        if (cVar == null || cVar.kQ == null) {
            return;
        }
        String str = c0637a.acf;
        str.getClass();
        switch (str) {
            case "adSkipCallback":
                this.mj.kQ.onSkippedAd();
                break;
            case "adShowCallback":
                this.mj.kQ.onAdShow();
                break;
            case "adCloseCallback":
                this.mj.kQ.onAdClosed();
                break;
            case "adAutoCloseCallback":
                this.mj.kQ.onPageDismiss();
                break;
            case "adClickCallback":
                this.mj.kQ.onAdClicked();
                break;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        c cVar = this.mj;
        cVar.ml = true;
        cVar.c(aVar.aNP, aVar.mI);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        n nVar = new n();
        nVar.ahg = !this.mj.bU.isVideoSoundEnable();
        oVar.c(nVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }
}
