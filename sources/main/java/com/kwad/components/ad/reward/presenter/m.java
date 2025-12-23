package com.kwad.components.ad.reward.presenter;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m extends b {
    private long jY;

    @NonNull
    private com.kwad.components.ad.reward.e.b rD;
    private com.kwad.components.core.video.m vQ;
    private com.kwad.components.core.video.m vR = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.tm;
            if (gVar.rS && gVar.rX) {
                mVar.rD.onVideoSkipToEnd(m.this.jY);
            } else {
                gVar.ss = true;
                mVar.rD.onVideoPlayEnd();
            }
            AdInfo el = com.kwad.sdk.core.response.b.e.el(m.this.tm.mAdTemplate);
            if (!com.kwad.sdk.core.response.b.a.aO(el) || com.kwad.sdk.core.response.b.a.aN(el) != 1) {
                f.u(m.this.tm);
                com.kwad.components.ad.reward.g gVar2 = m.this.tm;
                if (gVar2.ss) {
                    com.kwad.components.ad.reward.l.j(gVar2);
                }
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.tm;
            gVar.sr = j7;
            if (!gVar.rX) {
                mVar.jY = j7;
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            m.this.rD.onVideoPlayStart();
            m.this.tm.ss = false;
        }
    };
    private final com.kwad.components.core.video.m jE = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            m mVar = m.this;
            if (mVar.tm.rX) {
                mVar.rD.onVideoSkipToEnd(m.this.jY);
            } else {
                mVar.rD.onVideoPlayEnd();
            }
            AdInfo el = com.kwad.sdk.core.response.b.e.el(m.this.tm.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aO(el) && com.kwad.sdk.core.response.b.a.aN(el) == 1) {
                return;
            }
            f.u(m.this.tm);
            com.kwad.components.ad.reward.g gVar = m.this.tm;
            if (gVar.ss) {
                com.kwad.components.ad.reward.l.j(gVar);
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i6, int i7) {
            m.this.rD.onVideoPlayError(i6, i7);
            m.this.iz();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            m mVar = m.this;
            com.kwad.components.ad.reward.g gVar = mVar.tm;
            gVar.sr = j7;
            gVar.ss = j6 - j7 < 800;
            if (gVar.rX) {
                return;
            }
            mVar.jY = j7;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            m.this.rD.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.reward.g gVar = this.tm;
        gVar.sr = 0L;
        gVar.ss = false;
        this.rD = gVar.rD;
        if (gVar.rE.kW()) {
            this.vQ = this.vR;
        } else {
            this.vQ = this.jE;
        }
        this.tm.rE.a(this.vQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.vQ);
    }
}
