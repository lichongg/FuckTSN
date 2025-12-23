package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.o;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl rG;
    private m vR = new m() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            c.this.iF();
        }
    };

    @Nullable
    private o xn;

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iF() {
        this.rG.P(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        g gVar = this.tm;
        this.rG = gVar.rG;
        gVar.rE.a(this.vR);
        AdTemplate adTemplate = this.tm.mAdTemplate;
        AdInfo el = e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.cR(el)) {
            if (this.xn == null) {
                this.xn = new o(this.tm);
            }
            this.xn.b(this.tm.mRootContainer, com.kwad.sdk.core.response.b.a.bf(el));
            this.xn.b(r.aa(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.tm.rG.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.vR);
        this.tm.rG.b(this);
        o oVar = this.xn;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }
}
