package com.kwad.components.ad.reward.b;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.b.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private AdTemplate mAdTemplate;
    private boolean uc = false;

    static /* synthetic */ boolean a(c cVar, boolean z5) {
        cVar.uc = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.b.b.a
    public final void hT() {
        this.tm.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.uc);
        if (this.uc) {
            return;
        }
        AdInfo el = e.el(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.tm.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view = viewGroup;
        if (childCount > 0) {
            view = viewGroup.getChildAt(0);
        }
        final int[] I = com.kwad.sdk.c.a.a.I(view);
        if (!l(el) || I == null) {
            return;
        }
        view.post(new bg() { // from class: com.kwad.components.ad.reward.b.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "targetView x: " + I[0] + ", y: " + I[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, I);
                c.a(c.this, true);
            }
        });
    }

    private static boolean l(AdInfo adInfo) {
        AdProductInfo cV = com.kwad.sdk.core.response.b.a.cV(adInfo);
        if (com.kwad.components.ad.reward.a.b.i(adInfo) && cV != null && !cV.isCouponListEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mAdTemplate = this.tm.mAdTemplate;
    }
}
