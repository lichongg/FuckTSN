package com.kwad.components.ad.fullscreen.c;

import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.tachikoma.c.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private m jE = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.tm.gK();
        }
    };
    private final com.kwad.components.ad.reward.e.m jF = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.fullscreen.c.a.2
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            a.this.tm.rE.release();
            a.this.tm.gK();
        }
    };

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
