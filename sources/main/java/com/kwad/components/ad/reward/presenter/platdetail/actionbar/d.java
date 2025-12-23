package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.i;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aq;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.n.b {
    private ViewGroup jI;
    private KsLogoView vN;
    private i yo;

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i6, boolean z5) {
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = a(layoutParams3);
            if (z5) {
                ksLogoView.setVisibility(0);
            }
            boolean z6 = (!aq.QW() && (com.kwad.components.ad.reward.a.b.i(adInfo) || com.kwad.sdk.core.response.b.a.cL(adInfo))) || (aq.QW() && com.kwad.sdk.core.response.b.a.cK(adInfo));
            layoutParams3.gravity = 85;
            if (z6) {
                i6 = R.dimen.ksad_reward_follow_card_margin;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i6);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.ksad_reward_follow_card_margin);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    public d(ViewGroup viewGroup) {
        this.jI = viewGroup;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        i iVar = new i(this.tm, this.jI, this.vN);
        this.yo = iVar;
        iVar.b(r.aa(this.tm.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate), this.vN, R.dimen.ksad_reward_jinniu_logo_margin_bottom, false);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vN = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    private static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void hT() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void js() {
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void jt() {
    }
}
