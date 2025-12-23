package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.n;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.t.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements RewardActionBarControl.c {
    private ViewGroup jI;
    private KsLogoView vN;
    private n yp;
    private int yq;
    private FrameLayout.LayoutParams yr;
    private n.a ys;

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.jI.setVisibility(0);
        RewardActionBarControl.a(aVar, this.jI, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    public e(ViewGroup viewGroup, n.a aVar) {
        this.jI = viewGroup;
        this.ys = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rG.a(this);
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        this.yq = this.vN.getVisibility();
        this.yr = d.a(getContext(), el, this.vN, R.dimen.ksad_reward_order_logo_margin_bottom, !this.tm.rE.kW());
        n nVar = new n(this.jI, new com.kwad.components.ad.reward.n.a(getContext(), this.tm) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void js() {
                e.this.tm.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void jt() {
                e.this.tm.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.yp = nVar;
        nVar.a(this.ys);
        this.yp.b(r.aa(this.tm.mAdTemplate));
        j.a(new com.kwad.components.core.widget.e(), this.yp.hP());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vN = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vN.setVisibility(this.yq);
        FrameLayout.LayoutParams layoutParams = this.yr;
        if (layoutParams != null) {
            this.vN.setLayoutParams(layoutParams);
        }
    }
}
