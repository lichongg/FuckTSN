package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p extends b {
    private com.kwad.components.core.playable.a rF;
    private PlayableSource we;
    private final com.kwad.components.ad.reward.e.j wf = new com.kwad.components.ad.reward.e.k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
            p.this.we = playableSource;
            if (p.this.rF != null && p.this.rF.rS()) {
                p.this.rF.e(playableSource);
                com.kwad.components.ad.reward.g gVar = p.this.tm;
                if (gVar != null) {
                    gVar.d(playableSource);
                    p.this.tm.C(true);
                    if (p.this.tm.rE.kW()) {
                        p.this.tm.rE.kX().pause();
                    }
                }
                com.kwad.components.ad.reward.a.gg().b(playableSource);
                return;
            }
            if (p.this.rF != null) {
                p.this.rF.iK();
            }
            if (nVar != null) {
                nVar.id();
                com.kwad.sdk.core.d.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(p.this.tm.mAdTemplate))) {
                DownloadLandPageActivity.launch(p.this.getActivity(), p.this.tm.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void dk() {
            p.this.rF.iK();
            com.kwad.components.ad.reward.g gVar = p.this.tm;
            if (gVar != null) {
                gVar.d((PlayableSource) null);
                if (p.this.tm.rE.kW()) {
                    p.this.tm.rE.kX().resume();
                }
            }
        }
    };

    public final void e(@Nullable PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.rF;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.we);
            }
        }
    }

    public final void iK() {
        com.kwad.components.core.playable.a aVar = this.rF;
        if (aVar != null) {
            aVar.iK();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.reward.g gVar = this.tm;
        com.kwad.components.core.playable.a aVar = gVar.rF;
        this.rF = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(gVar.mAdTemplate, gVar.mRootContainer, gVar.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.c.a(this.tm.rS, "playable");
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        com.kwad.components.ad.reward.g gVar2 = this.tm;
        com.kwad.components.ad.reward.monitor.c.a(gVar2.mAdTemplate, gVar2.rS, "playable", com.kwad.sdk.core.response.b.a.bQ(el));
        this.rF.rR();
        this.rF.a(new as.b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                if (!aVar2.isSuccess()) {
                    AdInfo el2 = com.kwad.sdk.core.response.b.e.el(p.this.tm.mAdTemplate);
                    long loadTime = p.this.tm.rF.getLoadTime();
                    if (loadTime != -1) {
                        com.kwad.components.ad.reward.g gVar3 = p.this.tm;
                        com.kwad.components.ad.reward.monitor.c.a(gVar3.mAdTemplate, gVar3.rS, "playable", com.kwad.sdk.core.response.b.a.bQ(el2), System.currentTimeMillis() - loadTime, 3);
                    }
                }
            }
        });
        this.rF.a(new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                AdInfo el2 = com.kwad.sdk.core.response.b.e.el(p.this.tm.mAdTemplate);
                long loadTime = p.this.tm.rF.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.a(p.this.tm.rS, "playable", com.kwad.sdk.core.response.b.a.bQ(el2), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i6, String str, String str2) {
                com.kwad.components.ad.reward.g gVar3 = p.this.tm;
                AdTemplate adTemplate = gVar3.mAdTemplate;
                com.kwad.components.ad.reward.monitor.c.a(adTemplate, gVar3.rS, "playable", com.kwad.sdk.core.response.b.a.bQ(com.kwad.sdk.core.response.b.e.el(adTemplate)), System.currentTimeMillis() - p.this.tm.rF.getLoadTime(), 2);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }
        });
        com.kwad.components.ad.reward.a.gg().a(this.wf);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.rF;
        if (aVar == null) {
            return;
        }
        aVar.rQ();
        this.rF.iK();
        com.kwad.components.ad.reward.a.gg().b(this.wf);
    }
}
