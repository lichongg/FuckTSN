package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.az;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e implements g.a {
    private az cX;
    private boolean zU;
    private boolean zV;

    @Override // com.kwad.components.ad.reward.g.a
    public final void hd() {
        this.zV = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void he() {
        this.zV = true;
        ki();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hf() {
        this.zV = false;
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uK();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hg() {
        this.zV = false;
    }

    private void ki() {
        az azVar = this.cX;
        if (azVar == null || !this.zV) {
            return;
        }
        if (this.zU) {
            azVar.uJ();
            return;
        }
        azVar.uF();
        this.cX.uG();
        this.zU = true;
    }

    public final void B(com.kwad.components.ad.reward.g gVar) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        gVar.b(this);
    }

    public final void b(az azVar) {
        this.cX = azVar;
    }

    public final void kj() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
    }

    public final void A(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void az() {
        ki();
    }
}
