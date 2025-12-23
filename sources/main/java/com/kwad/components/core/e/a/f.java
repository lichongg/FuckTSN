package com.kwad.components.core.e.a;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends Presenter implements j, com.kwad.sdk.core.j.c {
    private com.kwad.components.core.widget.a.b Ok;
    private a Ou;
    private az eS;
    private i fU;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0637a c0637a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    private void ak(boolean z5) {
        if (!z5) {
            this.Ou.Y();
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.e.a.f.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                f.this.Ou.Ol.oJ();
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadSuccess");
        this.Ou.W();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageVisible");
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uJ();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageInvisible");
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uK();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.Ou.Oj;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_installed_activate";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cr(this.mAdTemplate).installedActivateInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.Ou.Oj;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        a aVar = (a) NN();
        this.Ou = aVar;
        this.mAdTemplate = aVar.mAdTemplate;
        this.Ok = aVar.Ok;
        this.fU = new i(getContext()) { // from class: com.kwad.components.core.e.a.f.1
            @Override // com.kwad.components.core.webview.tachikoma.i
            public final boolean oP() {
                return true;
            }
        };
        this.fU.a((Activity) null, com.kwad.sdk.core.response.b.c.dW(this.mAdTemplate), this);
        this.Ok.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fU.kz();
        this.Ok.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadFailed");
        ak(true);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onAdClicked");
        ak(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / bj) + 0.5f);
        aVar.height = (int) ((screenHeight / bj) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        ak(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.eS = azVar;
        this.Ou.eS = azVar;
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
