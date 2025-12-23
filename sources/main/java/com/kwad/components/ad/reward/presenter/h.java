package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends b implements com.kwad.sdk.app.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.app.a
    public final void U(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo), str)) {
            AdInfo el = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(el) && com.kwad.sdk.core.response.b.a.aN(el) == 1) {
                return;
            }
            com.kwad.components.ad.reward.e.b bVar = this.tm.rD;
            if (bVar != null) {
                bVar.onRewardVerify();
            }
            this.tm.rE.pause();
            this.tm.gK();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        com.kwad.sdk.app.b.Dw().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.app.b.Dw().b(this);
    }

    @Override // com.kwad.sdk.app.a
    public final void V(String str) {
    }
}
