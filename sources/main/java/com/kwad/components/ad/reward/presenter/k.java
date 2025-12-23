package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k extends b {
    private final AdLiveCallerContextListener vI = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.tm);
        }
    };
    private final com.kwad.components.core.m.a.a vJ = new com.kwad.components.core.m.a.b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.m.a.b, com.kwad.components.core.m.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            super.c(fVar);
            if (k.this.tm.rE.kW()) {
                k.this.tm.rE.kX().onResume();
                if (com.kwad.components.core.t.a.aC(k.this.tm.mContext).sW()) {
                    k.this.tm.d(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.m.a.b, com.kwad.components.core.m.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            if (k.this.tm.rE.kW()) {
                k.this.tm.rE.kX().onPause();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.tm.rE.kW()) {
            this.tm.rE.kX().registerAdLiveCallerContextListener(this.vI);
            this.tm.Rt.add(this.vJ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.tm.rE.kW()) {
            this.tm.rE.kX().unRegisterAdLiveCallerContextListener(this.vI);
            this.tm.Rt.remove(this.vJ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
