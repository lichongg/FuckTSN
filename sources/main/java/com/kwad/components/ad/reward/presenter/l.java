package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.g;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl rG;

    @Nullable
    private com.kwad.components.ad.reward.n.g vL;
    private KsLogoView vN;

    @Nullable
    private com.kwad.components.ad.reward.n.l vO;
    private boolean vM = false;
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            l.this.iF();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iF() {
        if (this.vM) {
            return;
        }
        com.kwad.components.ad.reward.n.g gVar = this.vL;
        if (gVar == null) {
            this.rG.P(false);
        } else {
            gVar.a(new g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                @Override // com.kwad.components.ad.reward.n.g.a
                public final void iG() {
                    l.this.rG.P(true);
                }
            }, 500L);
        }
        this.vM = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.n.l lVar = this.vO;
        if (lVar != null) {
            lVar.lj();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.reward.g gVar = this.tm;
        this.rG = gVar.rG;
        gVar.rE.a(this.jE);
        AdTemplate adTemplate = this.tm.mAdTemplate;
        boolean z5 = com.kwad.sdk.core.response.b.b.dt(adTemplate).displayWeakCard;
        this.tm.B(z5);
        if (z5) {
            if (this.vL == null) {
                this.vL = new com.kwad.components.ad.reward.n.g(this.tm);
            }
            this.vL.f((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.vL.b(com.kwad.components.ad.reward.n.r.aa(adTemplate));
        }
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.co(adTemplate)) {
            if (this.vO == null) {
                this.vO = new com.kwad.components.ad.reward.n.l(this.tm);
            }
            this.vO.h(this.tm.mRootContainer);
            this.vO.b(com.kwad.components.ad.reward.n.r.aa(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), el, this.vN, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.tm.rG.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vN = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        this.tm.rG.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.vO;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }
}
