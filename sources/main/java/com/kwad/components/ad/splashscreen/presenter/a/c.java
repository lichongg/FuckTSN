package com.kwad.components.ad.splashscreen.presenter.a;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class c extends e implements j {
    private b Jk;

    public void a(az azVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.Gf.mRootContainer;
    }

    protected int nf() {
        return 1000;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        int nf = nf();
        b bVar = new b(getContext(), nf, nf);
        this.Jk = bVar;
        bVar.a((Activity) null, this.Gf.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Jk.kz();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0637a c0637a) {
        String str = c0637a.acf;
        str.getClass();
        switch (str) {
            case "adShowCallback":
                this.Gf.lJ();
                break;
            case "adDownloadConfirmTipCancel":
                this.Gf.lO();
                break;
            case "adCloseCallback":
                this.Gf.lL();
                break;
            case "adDownloadConfirmTipShow":
                this.Gf.lN();
                break;
            case "adDownloadConfirmTipDismiss":
                this.Gf.lP();
                break;
            case "adAutoCloseCallback":
                this.Gf.lK();
                break;
            case "adShowErrorCallback":
                this.Gf.lI();
                break;
            case "adClickCallback":
                this.Gf.lM();
                break;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aB() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }
}
