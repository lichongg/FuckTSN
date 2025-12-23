package com.kwad.components.ad.interstitial.f.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.h.a.a.b;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.t.k;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bj;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.g;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.components.core.webview.tachikoma.c.l;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.webview.tachikoma.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.bz;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends a {
    private static long nA = 400;
    private FrameLayout cV;
    private d gX;
    private Vibrator gZ;
    private az iy;
    private boolean nC;
    private e nD;

    @Nullable
    private com.kwad.components.ad.h.a.a.b nz;
    private boolean nB = false;
    private final c.b mT = new c.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.1
        @Override // com.kwad.components.ad.interstitial.f.c.b
        public final void c(long j6, long j7) {
            com.kwad.components.ad.interstitial.report.a.eO().b(b.this.mj.mAdTemplate, j6, j7);
            if (b.this.nD != null) {
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.agT = b.this.mj.ml ? 1 : 0;
                b.this.nD.b(aVar);
            }
        }
    };
    private com.kwad.sdk.core.j.c fo = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ad.interstitial.f.a.b.9
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bt() {
            if (b.this.iy != null && !b.this.nB) {
                b.a(b.this, true);
                b.this.iy.uF();
                b.this.iy.uG();
            }
            if (b.this.iy != null) {
                b.this.iy.uJ();
            }
            if (b.this.nz != null) {
                b.this.nz.fQ();
            }
            if (!b.this.nC) {
                b.this.mj.kW.getTimerHelper().startTiming();
            }
            if (b.this.nC || b.this.mj.mn || b.this.mj.kQ == null) {
                return;
            }
            b.this.mj.kQ.onAdShow();
            com.kwad.components.ad.interstitial.report.c.eS().a(b.this.mj.mAdTemplate, 3);
            b.b(b.this, true);
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bu() {
            if (b.this.iy != null) {
                b.this.iy.uK();
            }
            if (b.this.nz != null) {
                b.this.nz.fP();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    static /* synthetic */ boolean b(b bVar, boolean z5) {
        bVar.nC = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d6) {
        this.mj.a(new c.C0567c(getContext()).m(true).c(d6).L(2).a(this.mj.fV.getTouchCoords()).M(157));
        bw.vibrate(getContext(), this.gZ, nA);
    }

    private com.kwad.components.core.webview.tachikoma.c eD() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.interstitial.f.a.b.14
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.agV = com.kwad.components.ad.interstitial.d.a.dQ();
                cVar.a(cVar2);
            }
        };
    }

    private e eE() {
        return new e() { // from class: com.kwad.components.ad.interstitial.f.a.b.15
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.agT = b.this.mj.ml ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private g eF() {
        l lVar = new l();
        lVar.ahd = this.mj.mx;
        return new g(lVar);
    }

    private com.kwad.components.ad.h.a.a.a eG() {
        final com.kwad.components.ad.h.a.a.a aVar = new com.kwad.components.ad.h.a.a.a();
        this.mj.f36337ms.add(new c.d() { // from class: com.kwad.components.ad.interstitial.f.a.b.16
            @Override // com.kwad.components.ad.interstitial.f.c.d
            public final void eb() {
                aVar.fO();
            }
        });
        return aVar;
    }

    private bj eH() {
        bj bjVar = new bj(getContext(), this.mj.mAdTemplate);
        bjVar.a(new bj.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.3
            @Override // com.kwad.components.core.webview.jshandler.bj.a
            public final boolean eM() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.mj.mAdTemplate);
                b.this.mj.a(true, -1, null);
                bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.f.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.ev();
                    }
                }, 0L);
                return false;
            }
        });
        return bjVar;
    }

    @NonNull
    private n eI() {
        return new n() { // from class: com.kwad.components.ad.interstitial.f.a.b.4
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.interstitial.f.a.b.4.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                        dVar.agW = ao.isWifiConnected(b.this.getContext()) || b.this.mj.bU.isDataFlowAutoStart() || b.u(b.this.mj.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    @NonNull
    private ak eJ() {
        return new ak(new ak.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.5
            @Override // com.kwad.components.core.webview.jshandler.ak.b
            public final void a(final ak.a aVar) {
                if (b.this.mj.kW != null) {
                    b.this.mj.fV.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.a.b.5.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (aVar.type == 0 && !b.this.mj.ml && !b.this.mj.mm && com.kwad.components.ad.interstitial.g.a.d(b.this.mj)) {
                                b.this.mj.mm = true;
                                com.kwad.components.ad.interstitial.c.b.K(b.this.getContext());
                                return;
                            }
                            b.this.eL();
                            c cVar = b.this.mj;
                            ak.a aVar2 = aVar;
                            cVar.a(aVar2.type == 3, aVar2.ady, null);
                            b.this.ev();
                        }
                    });
                }
            }
        });
    }

    private x eK() {
        return new x() { // from class: com.kwad.components.ad.interstitial.f.a.b.6
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                if (!b.this.mj.mn && b.this.mj.kQ != null) {
                    b.this.mj.kQ.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                if (!b.this.mj.mn && b.this.mj.kQ != null) {
                    b.this.mj.kQ.onVideoPlayEnd();
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                b.this.mj.mAdTemplate.setmCurPlayTime(yVar.qz);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL() {
        az azVar = this.iy;
        if (azVar != null) {
            azVar.uH();
            this.iy.uI();
        }
        com.kwad.components.ad.h.a.a.b bVar = this.nz;
        if (bVar != null) {
            bVar.fP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        c cVar = this.mj;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.kW;
        if (dVar != null && a(dVar)) {
            this.mj.kW.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.mj.kQ;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private aq.a getOpenNewPageListener() {
        return new aq.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.8
            @Override // com.kwad.components.core.webview.jshandler.aq.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0627a().az(bVar.title).aA(bVar.url).aF(true).q(b.this.mj.mAdResultData).qW());
            }
        };
    }

    public static boolean u(@NonNull AdTemplate adTemplate) {
        File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        return cf != null && cf.exists();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cV;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dN(this.mj.mAdTemplate);
    }

    static /* synthetic */ boolean a(b bVar, boolean z5) {
        bVar.nB = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF() {
        if (getContext() != null) {
            this.gZ = (Vibrator) getContext().getSystemService("vibrator");
        }
        float dh = com.kwad.sdk.core.response.b.b.dh(this.mj.mAdTemplate);
        if (this.gX == null) {
            d dVar = new d(dh);
            this.gX = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.7
                @Override // com.kwad.sdk.core.g.b
                public final void a(double d6) {
                    if (bz.o(b.this.getTKContainer(), 100)) {
                        b.this.d(d6);
                    }
                    bw.a(new bg() { // from class: com.kwad.components.ad.interstitial.f.a.b.7.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            b.this.gX.Jb();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.g.b
                public final void cd() {
                }
            });
        }
        this.gX.g(dh);
        this.gX.bG(getContext());
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        com.kwad.components.ad.interstitial.report.c.eS().B(this.mj.mAdTemplate);
        com.kwad.components.core.webview.tachikoma.f.g gVar = this.mj.mq;
        if (gVar != null) {
            gVar.a(getTkTemplateId(), 0L, 0L, 0L);
        }
        if (this.iy != null && this.mj.kO.ae()) {
            this.nB = true;
            this.iy.uF();
            this.iy.uG();
        }
        this.mj.kO.a(this.fo);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.cV = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nB = false;
        this.nC = false;
        bw.b(getContext(), this.gZ);
        d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
        com.kwad.components.ad.interstitial.g.b bVar = this.mj.kO;
        if (bVar != null) {
            bVar.b(this.fo);
        }
        this.mj.b(this.mT);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        this.cV.setVisibility(8);
        com.kwad.components.core.webview.tachikoma.f.g gVar = this.mj.mq;
        if (gVar != null) {
            getTkTemplateId();
            gVar.v(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        com.kwad.components.ad.h.a.a.b I = com.kwad.components.ad.h.a.a.b.I(this.mj.mAdTemplate);
        this.nz = I;
        if (I != null) {
            I.a(new b.InterfaceC0561b() { // from class: com.kwad.components.ad.interstitial.f.a.b.10
                @Override // com.kwad.components.ad.h.a.a.b.InterfaceC0561b
                public final void Q(int i6) {
                    if (i6 == com.kwad.components.ad.h.a.a.b.qp) {
                        b.this.mj.c(b.this.getContext(), b.this.mj.mAdTemplate);
                        b.this.mj.a(true, -1, null);
                    }
                    b.this.ev();
                }
            });
            tVar.c(this.nz);
            this.nz.au();
        }
        tVar.c(eJ());
        tVar.c(new aq(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.b.b.dJ(com.kwad.sdk.core.response.b.e.el(this.mj.mAdTemplate))) {
            tVar.c(new bb(new bb.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.11
                @Override // com.kwad.components.core.webview.jshandler.bb.a
                public final void cL() {
                    b.this.cF();
                }
            }));
        }
        tVar.c(eI());
        tVar.c(eH());
        tVar.c(eF());
        tVar.c(a(bVar));
        tVar.c(eK());
        tVar.c(eG());
        tVar.c(new q() { // from class: com.kwad.components.ad.interstitial.f.a.b.12
            @Override // com.kwad.components.core.webview.tachikoma.b.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                k.f(b.this.getContext(), b.this.mj.mAdTemplate);
            }
        });
        this.nD = eE();
        this.mj.a(this.mT);
        tVar.c(this.nD);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.13
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eN() {
                com.kwad.components.ad.interstitial.d.a.L(b.this.getContext());
            }
        }));
        tVar.c(eD());
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aB() {
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.iy = azVar;
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.mj.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    com.kwad.components.ad.interstitial.report.a.eO().a(b.this.mj.mAdTemplate, aVar.aNP, aVar.mI);
                    b.this.mj.ml = true;
                    b.this.mj.c(aVar.aNP, aVar.mI);
                    if (b.this.mj.kW == null || !com.kwad.components.ad.interstitial.d.b.t(b.this.mj.mAdTemplate)) {
                        return;
                    }
                    b.this.mj.a(false, -1, b.this.mj.cq);
                    b.this.mj.kW.dismiss();
                    b.this.mj.Y();
                }
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float f6;
        float f7;
        float bj = com.kwad.sdk.c.a.a.bj(getContext());
        FrameLayout frameLayout = this.cV;
        if (frameLayout != null) {
            f6 = frameLayout.getHeight();
            f7 = this.cV.getWidth();
        } else {
            f6 = 0.0f;
            f7 = 0.0f;
        }
        if (f6 != 0.0f && f7 != 0.0f) {
            aVar.width = (int) ((f7 / bj) + 0.5f);
            aVar.height = (int) ((f6 / bj) + 0.5f);
        } else {
            aVar.width = (int) ((br.getScreenWidth(getContext()) / bj) + 0.5f);
            aVar.height = (int) ((br.getScreenHeight(getContext()) / bj) + 0.5f);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        super.a(uVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.mj.kQ;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
        c.a aVar = this.mj.mo;
        if (aVar != null) {
            aVar.a(-1L, -1L, false);
        }
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.mj.a(webCloseStatus.closeType == 2, -1, null);
        ev();
    }
}
