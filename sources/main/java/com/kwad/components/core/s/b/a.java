package com.kwad.components.core.s.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends Presenter implements j {
    private FrameLayout Yp;
    private az Yq;
    protected boolean Yr;
    protected com.kwad.components.core.s.a.b Ys;
    private com.kwad.components.core.m.a.a Yt = new com.kwad.components.core.m.a.a() { // from class: com.kwad.components.core.s.b.a.1
        @Override // com.kwad.components.core.m.a.a
        public final void c(f fVar) {
            a.this.sR();
        }

        @Override // com.kwad.components.core.m.a.a
        public final void d(f fVar) {
            a.this.sS();
        }

        @Override // com.kwad.components.core.m.a.a
        public final void gZ() {
            a.this.sT();
        }

        @Override // com.kwad.components.core.m.a.a
        public final void gY() {
        }
    };
    private i fU;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0637a c0637a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    private void sQ() {
        az azVar = this.Yq;
        if (azVar == null) {
            return;
        }
        if (this.Yr) {
            azVar.uJ();
            return;
        }
        azVar.uF();
        this.Yq.uG();
        this.Yr = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS() {
        az azVar = this.Yq;
        if (azVar == null || !this.Yr) {
            return;
        }
        azVar.uK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sT() {
        az azVar = this.Yq;
        if (azVar == null || !this.Yr) {
            return;
        }
        azVar.uH();
        this.Yq.uI();
        n nVar = this.Ys.Yi;
        if (nVar != null) {
            nVar.callbackDismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.Yp;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_activity";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return this.Ys.Yf.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final g getTouchCoordsView() {
        return this.Ys.mRootContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sR() {
        sQ();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Ys = (com.kwad.components.core.s.a.b) NN();
        this.Yp = (FrameLayout) findViewById(R.id.ksad_js_container);
        i iVar = new i(getContext(), 1000, 0);
        this.fU = iVar;
        iVar.a(this.Ys.Yf);
        n nVar = this.Ys.Yi;
        if (nVar != null) {
            nVar.a(this.fU);
            this.fU.a(new com.kwad.sdk.core.webview.c.g() { // from class: com.kwad.components.core.s.b.a.2
                @Override // com.kwad.sdk.core.webview.c.g
                public final void callTKBridge(String str) {
                    n nVar2 = a.this.Ys.Yi;
                    if (nVar2 != null) {
                        nVar2.callTKBridge(str);
                    }
                }
            });
            this.fU.a("hasTKBridge", Boolean.TRUE);
        }
        this.fU.a(getActivity(), this.Ys.mAdResultData, this);
        this.Ys.Rt.add(this.Yt);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        sQ();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        sT();
        this.fU.kz();
        this.Ys.Rt.remove(this.Yt);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.tachikoma.c.n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        aVar.width = (int) ((br.getScreenWidth(getContext()) / bj) + 0.5f);
        aVar.height = (int) ((br.getScreenHeight(getContext()) / bj) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.Yq = azVar;
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
