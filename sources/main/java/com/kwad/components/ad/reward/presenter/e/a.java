package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    private AdMatrixInfo.PreLandingPageTKInfo zt;
    private az zu;
    private boolean qS = false;
    private com.kwad.components.ad.reward.e.g zv = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.tm.rX);
            if (a.this.tm.rX) {
                return;
            }
            a.this.jS();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    private void T(final boolean z5) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z5);
        this.zX.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.zX.setVisibility(z5 ? 0 : 4);
                a.this.zX.setClickable(z5);
                if (a.this.zu != null) {
                    if (z5) {
                        a.this.zu.uF();
                        a.this.zu.uG();
                    } else {
                        a.this.zu.uH();
                        a.this.zu.uI();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS() {
        if (!this.qS || this.zt == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.zt.isPlayEndShow());
        if (this.zt.isPlayEndShow()) {
            T(true);
        }
    }

    private void jT() {
        if (!this.qS || this.zt == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.zt.isSkipShow());
        if (this.zt.isSkipShow()) {
            T(true);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dT(this.tm.mAdTemplate);
    }

    public final BackPressHandleResult hx() {
        KSFrameLayout kSFrameLayout;
        return (this.zF == null || (kSFrameLayout = this.zX) == null) ? BackPressHandleResult.NOT_HANDLED : kSFrameLayout.getVisibility() == 0 ? this.zF.hx() : BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int iX() {
        return R.id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jU() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        jS();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jV() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        jT();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.zt = b.dB(this.tm.mAdTemplate);
        this.tm.b(this.zv);
        this.tm.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        super.az();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.qS = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this.zv);
        this.tm.b((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        aVar.width = (int) ((br.getScreenWidth(getContext()) / bj) + 0.5f);
        aVar.height = (int) ((br.getScreenHeight(getContext()) / bj) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.zu = azVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.qS = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        T(false);
    }
}
