package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g extends b implements a.InterfaceC0621a {
    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void e(@Nullable List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean cG = com.kwad.sdk.core.response.b.b.cG(adTemplate);
        List<a.InterfaceC0621a> gR = this.tm.gR();
        if (cG) {
            com.kwad.sdk.core.local.a.e(com.kwad.sdk.core.response.b.b.cD(adTemplate), com.kwad.sdk.core.response.b.b.cE(adTemplate));
            if (gR != null) {
                Iterator<a.InterfaceC0621a> it = gR.iterator();
                while (it.hasNext()) {
                    it.next().e(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void onError(int i6, String str) {
        List<a.InterfaceC0621a> gR = this.tm.gR();
        if (gR != null) {
            Iterator<a.InterfaceC0621a> it = gR.iterator();
            while (it.hasNext()) {
                it.next().onError(i6, str);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0621a
    public final void onRequestResult(int i6) {
        List<a.InterfaceC0621a> gR = this.tm.gR();
        if (gR != null) {
            Iterator<a.InterfaceC0621a> it = gR.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i6);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        boolean Hr = com.kwad.sdk.core.local.a.Hr();
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + Hr);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl != null && Hr) {
            com.kwad.components.core.j.a.a(sceneImpl, this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
