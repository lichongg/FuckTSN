package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.c;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends c {
        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iB() {
            return R.id.ksad_blur_end_cover;
        }

        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iC() {
            return 8;
        }

        public a(AdInfo adInfo) {
            super(adInfo);
        }
    }

    private void jE() {
        if (g.g(this.mAdInfo)) {
            a(new s());
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate)) {
            a(new com.kwad.components.ad.reward.presenter.d.a.c());
        }
        a(new a(this.mAdInfo));
        if (com.kwad.components.ad.reward.a.b.k(this.mAdInfo) || !com.kwad.sdk.core.response.b.a.as(this.mAdInfo)) {
            return;
        }
        a(new com.kwad.components.ad.reward.presenter.d.a.a());
    }

    private void jF() {
        a(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate)) {
            a(new com.kwad.components.ad.reward.presenter.d.a.c());
        }
    }

    public b(AdTemplate adTemplate, boolean z5) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.el(adTemplate);
        if (z5) {
            jE();
        } else {
            jF();
        }
    }
}
