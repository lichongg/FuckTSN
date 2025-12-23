package com.kwad.components.core.webview.tachikoma.d;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a extends Presenter implements j {
    protected b ahp;
    protected i fU;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.ahp.ahq;
    }

    protected i iY() {
        return new i(this.ahp.AO, getContext());
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        b bVar = (b) NN();
        this.ahp = bVar;
        a(bVar);
        if (this.fU == null) {
            this.fU = iY();
        }
        StyleTemplate styleTemplate = this.ahp.Yf;
        if (styleTemplate != null) {
            this.fU.a(styleTemplate);
        }
        i iVar = this.fU;
        b bVar2 = this.ahp;
        iVar.a(bVar2.mActivity, bVar2.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fU.kz();
        this.fU = null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(u uVar) {
    }

    protected void a(b bVar) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    public void a(WebCloseStatus webCloseStatus) {
        e eVar = this.ahp.afi;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }
}
