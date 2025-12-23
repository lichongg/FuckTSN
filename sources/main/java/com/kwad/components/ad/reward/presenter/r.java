package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, as.b {
    private com.kwad.components.core.webview.tachikoma.f.g jN;
    private float vY;
    private boolean wn;

    @Nullable
    private a wo;

    @Nullable
    private q wp;

    @Nullable
    private o wq;
    private p wr;
    private int ws;
    private boolean wt;
    private boolean wu;
    private boolean wv;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.kwad.components.core.video.m {
        private long videoDuration;
        private long wx;

        private a() {
        }

        /* synthetic */ a(r rVar, byte b6) {
            this();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            this.wx = j7;
            this.videoDuration = j6;
            if (!r.this.tm.gG()) {
                r.this.b(j6, j7, false);
            }
        }
    }

    public r(AdTemplate adTemplate, boolean z5, boolean z6) {
        this.ws = 0;
        this.wt = false;
        this.wu = z5;
        this.wv = z6;
        if (com.kwad.sdk.core.response.b.a.bK(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            p pVar = new p();
            this.wr = pVar;
            a(pVar);
        }
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    private com.kwad.components.core.webview.tachikoma.f.g dh() {
        if (this.jN == null) {
            this.jN = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void v(String str) {
                    r.this.iP();
                }
            };
        }
        return this.jN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iP() {
        if (this.wv) {
            q qVar = new q(this);
            this.wp = qVar;
            a((Presenter) qVar, true);
        }
        if (this.wu) {
            o oVar = new o(this);
            this.wq = oVar;
            a((Presenter) oVar, true);
        }
    }

    private boolean iQ() {
        return this.wn;
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void cX() {
        RewardActionBarControl.ShowActionBarResult jr = this.tm.rG.jr();
        if (jr != null) {
            jr.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.wr == null || this.tm.gQ()) {
            return;
        }
        if (iQ()) {
            this.wr.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.wr.iK();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dk() {
        this.tm.A(false);
        a aVar = this.wo;
        if (aVar == null || this.ws != 2) {
            return;
        }
        b(aVar.videoDuration, this.wo.wx, true);
    }

    public final boolean onBackPressed() {
        boolean gU = this.tm.gU();
        if (!this.tm.gG() || gU) {
            return false;
        }
        com.kwad.components.ad.reward.a.gg().gh();
        this.tm.A(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j6, long j7, boolean z5) {
        q qVar;
        if (iQ() && j7 >= 10000 && j7 >= j6 * this.vY) {
            if (com.kwad.components.ad.reward.a.b.hH()) {
                if (!this.wt && (qVar = this.wp) != null) {
                    qVar.iL();
                    this.ws = 1;
                    this.wt = true;
                    return;
                }
                return;
            }
            o oVar = this.wq;
            if (oVar != null) {
                oVar.I(true ^ z5);
                this.ws = 2;
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.wn = isSuccess;
        if (!isSuccess || (aVar2 = this.wo) == null) {
            return;
        }
        b(aVar2.videoDuration, this.wo.wx, false);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bK(el)) {
            if (!this.tm.rT) {
                bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        r.this.iP();
                    }
                }, 100L);
            } else {
                com.kwad.components.core.webview.tachikoma.e.c.vO().a(dh());
            }
        } else if (!com.kwad.sdk.core.response.b.a.bN(el)) {
            com.kwad.components.core.p.a.se().aJ(this.tm.mAdTemplate);
        }
        this.tm.b(this);
        com.kwad.components.core.playable.a aVar = this.tm.rF;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean hG = com.kwad.components.ad.reward.a.b.hG();
        this.vY = com.kwad.components.ad.reward.a.b.hF();
        if (hG) {
            a aVar2 = new a(this, (byte) 0);
            this.wo = aVar2;
            com.kwad.components.ad.reward.m.e eVar = this.tm.rE;
            if (eVar != null) {
                eVar.a(aVar2);
            }
        }
        com.kwad.components.ad.reward.a.gg().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ad.reward.m.e eVar;
        super.onUnbind();
        this.tm.c(this);
        com.kwad.components.core.playable.a aVar = this.tm.rF;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.wo;
        if (aVar2 != null && (eVar = this.tm.rE) != null) {
            eVar.b(aVar2);
        }
        com.kwad.components.ad.reward.a.gg().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.jN);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.tm.A(true);
        int i6 = this.ws;
        if (i6 == 1 && (qVar = this.wp) != null) {
            qVar.iM();
        } else {
            if (i6 != 2 || (oVar = this.wq) == null) {
                return;
            }
            oVar.hide();
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dl() {
    }
}
