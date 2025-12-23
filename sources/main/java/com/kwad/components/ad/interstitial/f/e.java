package com.kwad.components.ad.interstitial.f;

import androidx.annotation.Nullable;
import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends b implements a.c {
    private static long nb = 1000;
    private AdTemplate mAdTemplate;
    private c mj;

    @Nullable
    private a nc;
    private int nd;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        private int ne;
        private boolean nf;
        private boolean ng;

        private a() {
            this.ne = Integer.MIN_VALUE;
            this.nf = false;
            this.ng = false;
        }

        public final void r(boolean z5) {
            this.ng = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.ng) {
                return;
            }
            if (this.nf) {
                bw.a(this, null, e.nb);
                return;
            }
            if (this.ne == Integer.MIN_VALUE) {
                this.ne = e.this.nd;
            }
            if (this.ne < 0) {
                return;
            }
            com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.ne);
            e.this.P(this.ne);
            this.ne = this.ne + (-1);
            bw.a(this, null, e.nb);
        }

        public final void s(boolean z5) {
            this.nf = z5;
        }

        /* synthetic */ a(e eVar, byte b6) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i6) {
        c cVar = this.mj;
        com.kwad.components.ad.interstitial.h.d dVar = cVar.mk;
        if (dVar == null) {
            return;
        }
        if (i6 != 0) {
            dVar.b(true, i6);
        } else {
            if (cVar.dV()) {
                return;
            }
            this.mj.c(getContext(), this.mAdTemplate);
            ev();
            c cVar2 = this.mj;
            cVar2.a(true, -1, cVar2.cq);
        }
    }

    private void ev() {
        com.kwad.sdk.core.video.videoview.a aVar = this.mj.cq;
        if (aVar != null) {
            aVar.release();
        }
        this.mj.kW.dismiss();
        this.mj.Y();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void ar() {
        if (this.mj.dV()) {
            return;
        }
        this.mj.c(getContext(), this.mAdTemplate);
        ev();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j6) {
        P(this.nd - ((int) (j6 / 1000)));
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) NN();
        this.mj = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        long j6 = el.adInsertScreenInfo.autoCloseTime;
        if (j6 > 0) {
            this.nd = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(el), j6);
        } else {
            this.nd = com.kwad.components.ad.interstitial.b.b.b(el);
        }
        com.kwad.components.ad.interstitial.h.d dVar = this.mj.mk;
        if (dVar != null) {
            dVar.b(true, this.nd);
        }
        if (com.kwad.sdk.core.response.b.a.bc(el)) {
            this.nc = null;
            this.mj.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.nc = aVar;
            bw.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dR() {
        super.dR();
        a aVar = this.nc;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dS() {
        super.dS();
        a aVar = this.nc;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.mj.b(this);
        a aVar = this.nc;
        if (aVar != null) {
            aVar.r(true);
            bw.c(this.nc);
            this.nc = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void aq() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }
}
