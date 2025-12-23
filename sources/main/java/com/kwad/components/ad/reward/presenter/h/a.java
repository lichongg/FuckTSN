package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.a.d;
import com.kwad.components.ad.reward.m.e;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.core.m.a.b;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.w;
import com.kwad.components.core.webview.tachikoma.f;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends g implements j {
    private boolean Ar;
    private f As;
    private long At;
    private AdInfo mAdInfo;
    private boolean xe;
    private boolean xf;
    private d zF;
    private g.b xg = new g.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.zX != null && a.this.zX.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.m.a.a vJ = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        @Override // com.kwad.components.core.m.a.b, com.kwad.components.core.m.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            a.this.Ar = false;
            if (a.this.As == null) {
                return;
            }
            w wVar = new w();
            if (com.kwad.components.core.r.a.sF().sL()) {
                com.kwad.components.core.r.a.sF().aP(false);
                if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                    wVar.ahl = 1;
                    a.this.As.b(wVar);
                    return;
                } else if (com.kwad.components.core.r.a.sF().sH()) {
                    wVar.ahl = 1;
                    a.this.As.b(wVar);
                    return;
                } else {
                    wVar.ahl = 0;
                    a.this.As.b(wVar);
                    return;
                }
            }
            if (com.kwad.components.core.r.a.sF().sJ() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.r.a.sF().sK() != 1) {
                    if (com.kwad.components.core.r.a.sF().sK() == 3) {
                        wVar.ahl = 1;
                        com.kwad.components.core.r.a.sF().aX(0);
                        a.this.As.b(wVar);
                        return;
                    }
                    return;
                }
                if (!as.ap(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                    wVar.ahl = 0;
                    a.this.As.b(wVar);
                } else {
                    wVar.ahl = 2;
                    com.kwad.components.core.r.a.sF().aX(2);
                    a.this.As.b(wVar);
                }
            }
        }

        @Override // com.kwad.components.core.m.a.b, com.kwad.components.core.m.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            a.this.Ar = true;
        }
    };
    private final m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            long a6 = com.kwad.components.ad.reward.g.a(j6, a.this.mAdInfo);
            long aM = com.kwad.sdk.core.response.b.a.aM(a.this.mAdInfo) * 1000;
            if (j7 > a.this.At && a6 - j7 > aM && !a.this.xe) {
                if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                    if (as.ap(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                        return;
                    }
                } else if (a.this.tm.iH) {
                    return;
                }
                a.b(a.this, true);
                a.this.zF.a(a.this.tm.getActivity(), a.this.tm.mAdResultData, a.this);
                a.this.ko();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    static /* synthetic */ boolean b(a aVar, boolean z5) {
        aVar.xe = true;
        return true;
    }

    private void iH() {
        boolean z5 = i.z(this.tm);
        c.d("jky", "onPlayCompleted: " + z5);
        if (z5) {
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.tm.rD != null) {
                        a.this.tm.rD.onRewardVerify();
                    }
                    a.this.tm.rE.pause();
                    a.this.tm.gK();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.e.b bVar = this.tm.rD;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.tm.rE.pause();
        this.tm.gK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko() {
        this.zX.setVisibility(0);
        e eVar = this.tm.rE;
        if (eVar != null) {
            eVar.pause();
        }
        this.xf = true;
    }

    private f kp() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dJ(this.tm.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.tm.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int iX() {
        return R.id.ksad_js_task;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        getContext();
        if (!aq.QW()) {
            return;
        }
        this.Ar = false;
        c.d("TkRewardVideoTaskPresenter", "onBind: ");
        if (this.zF == null) {
            this.zF = new d(this.tm, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.As == null) {
                        return;
                    }
                    w wVar = new w();
                    if (com.kwad.components.core.r.a.sF().sL()) {
                        com.kwad.components.core.r.a.sF().aP(false);
                        if (com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 0) {
                            wVar.ahl = 1;
                            a.this.As.b(wVar);
                            return;
                        } else if (com.kwad.components.core.r.a.sF().sH()) {
                            wVar.ahl = 1;
                            a.this.As.b(wVar);
                            return;
                        } else {
                            wVar.ahl = 0;
                            a.this.As.b(wVar);
                            return;
                        }
                    }
                    if (com.kwad.components.core.r.a.sF().sJ() && com.kwad.sdk.core.response.b.a.aN(a.this.mAdInfo) == 1) {
                        if (com.kwad.components.core.r.a.sF().sK() == 1) {
                            if (as.ap(a.this.getContext(), com.kwad.sdk.core.response.b.a.ay(a.this.mAdInfo))) {
                                return;
                            }
                            wVar.ahl = 0;
                            a.this.As.b(wVar);
                            return;
                        }
                        if (com.kwad.components.core.r.a.sF().sK() == 3) {
                            wVar.ahl = 1;
                            com.kwad.components.core.r.a.sF().aX(0);
                            a.this.As.b(wVar);
                        }
                    }
                }
            });
        }
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate);
        this.At = com.kwad.sdk.core.response.b.a.aL(r0) * 1000;
        e eVar = this.tm.rE;
        if (eVar != null) {
            eVar.a(this.jE);
        }
        this.tm.a(this.xg);
        this.tm.Rt.add(this.vJ);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        e eVar = this.tm.rE;
        if (eVar != null) {
            eVar.b(this.jE);
        }
        this.tm.b(this.xg);
        this.tm.Rt.remove(this.vJ);
        d dVar = this.zF;
        if (dVar != null) {
            dVar.kz();
            this.zF = null;
        }
        this.zX.setVisibility(8);
        com.kwad.components.core.r.a.sF().clear();
        this.xe = false;
        this.xf = false;
        this.Ar = false;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        c.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.zX.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        f kp = kp();
        this.As = kp;
        tVar.c(kp);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.tm.rD.cW();
        c.d("jky", "onAdClicked convertPageType: " + aVar.aNO);
        if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo)) {
            com.kwad.components.core.r.a.sF().aW(aVar.aNO);
            if (aVar.aNO == -1) {
                com.kwad.components.core.r.a.sF().aP(false);
                com.kwad.components.core.r.a.sF().aX(0);
            } else {
                if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                    if (com.kwad.components.core.r.a.sF().sK() == 2) {
                        com.kwad.components.core.r.a.sF().aX(3);
                        return;
                    } else {
                        com.kwad.components.core.r.a.sF().aX(1);
                        return;
                    }
                }
                com.kwad.components.core.r.a.sF().aP(true);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        aVar.width = (int) ((br.getScreenWidth(getContext()) / bj) + 0.5f);
        aVar.height = (int) ((br.getScreenHeight(getContext()) / bj) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z5 = false;
        this.tm.rV = webCloseStatus != null && webCloseStatus.interactSuccess;
        int sG = com.kwad.components.core.r.a.sF().sG();
        com.kwad.components.ad.reward.g gVar = this.tm;
        e eVar = gVar.rE;
        if (eVar != null) {
            if (gVar.rV) {
                eVar.kT();
                if (sG == 1) {
                    iH();
                    z5 = true;
                }
            }
            if (this.xf && !this.Ar && !z5) {
                this.tm.rE.resume();
            }
        }
        this.zX.setVisibility(8);
    }
}
