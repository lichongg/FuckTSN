package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.e;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends g implements j, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private az cX;
    private boolean zU;
    private boolean zV;

    @Nullable
    private View zY;
    private boolean zZ = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            h.this.zX.setVisibility(8);
        }
    };
    private g.a Aa = new g.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.ad.reward.g.a
        public final void hd() {
            h.this.zV = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void he() {
            h.this.zV = true;
            h.this.ki();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hf() {
            h.this.zV = false;
            if (h.this.cX != null) {
                h.this.cX.uK();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hg() {
            h.this.zV = false;
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki() {
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

    private e.b kl() {
        return new e.b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.tachikoma.b.e.b
            public final int km() {
                if (h.this.tm.sk != null) {
                    return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), r0.dr());
                }
                if (h.this.zY == null) {
                    return 0;
                }
                return h.this.zY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.zY.getHeight() + ((ViewGroup.MarginLayoutParams) r0).bottomMargin) : com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.zY.getHeight());
            }
        };
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
        if (this.zZ) {
            this.zX.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
        if (this.zZ) {
            this.zX.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dE(this.tm.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    protected final int iX() {
        return R.id.ksad_js_topfloor;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        super.onUnbind();
        this.tm.b(this.Aa);
        this.tm.rG.b(this);
        this.tm.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gg().b(this);
        this.tm.a((com.kwad.components.core.webview.tachikoma.f.a) null);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.a(this.Aa);
        this.tm.rG.a(this);
        this.tm.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        super.az();
        ki();
        this.zZ = true;
        this.zX.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        this.zZ = false;
        this.zX.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / bj) + 0.5f);
        aVar.height = (int) ((screenHeight / bj) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.e(kl()));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.cX = azVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.zY = view;
    }
}
