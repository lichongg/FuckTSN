package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g tm;

    protected final boolean iA() {
        return com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate));
    }

    protected final void iz() {
        this.tm.iz();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) NN();
        this.tm = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }
}
