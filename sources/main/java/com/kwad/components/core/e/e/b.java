package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends Presenter {
    protected c PU;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        c cVar = (c) NN();
        this.PU = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(cVar.PT.getAdTemplate());
    }
}
