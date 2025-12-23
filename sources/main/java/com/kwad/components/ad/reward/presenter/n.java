package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n extends b {
    private com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.iH();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.m jF = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.c.r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            n.this.tm.rE.release();
            n.this.tm.gK();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iH() {
        com.kwad.components.ad.reward.g gVar = this.tm;
        if (com.kwad.components.core.t.k.d(gVar.mAdTemplate, gVar.rX)) {
            com.kwad.components.ad.reward.g gVar2 = this.tm;
            com.kwad.components.core.t.k.f(gVar2.mContext, gVar2.mAdTemplate);
        }
        if (!i.z(this.tm)) {
            com.kwad.components.ad.reward.g gVar3 = this.tm;
            if (!com.kwad.components.core.t.k.d(gVar3.mAdTemplate, gVar3.rX)) {
                this.tm.gK();
                return;
            }
        }
        bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.tm.gK();
            }
        }, 200L);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rE.a(this.jE);
        com.kwad.components.ad.reward.c.gn().a(this.jF);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        com.kwad.components.ad.reward.c.gn().b(this.jF);
    }
}
