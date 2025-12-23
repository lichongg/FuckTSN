package com.kwad.components.ad.reward.presenter.f;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.e;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.i;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.k;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bi;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.h;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.q;
import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.i;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d extends com.kwad.components.ad.reward.presenter.b implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.k.a.e, y.a {
    protected com.kwad.components.ad.reward.k.a.d zF;
    private p zG;
    private o zH;
    private i zI;
    private j zJ;
    private z zK;
    private boolean zL;
    private com.kwad.components.core.webview.tachikoma.b.h zM;

    @Nullable
    protected e zN;
    private bi.b zO = new bi.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        @Override // com.kwad.components.core.webview.jshandler.bi.b
        public final void ae(int i6) {
            com.kwad.sdk.core.adlog.c.b f6 = new com.kwad.sdk.core.adlog.c.b().dd(i6).f(d.this.tm.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new a.C0616a(d.this.getContext()).aB(d.this.tm.mAdTemplate).b(d.this.tm.mApkDownloadHelper).aq(false));
            com.kwad.components.ad.reward.j.b.a(d.this.tm.mAdTemplate, d.this.kf(), (String) null, f6, (JSONObject) null);
        }
    };
    private final i.a kf = new i.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.zH == null || com.kwad.components.ad.reward.a.b.hC()) {
                return;
            }
            n nVar = new n();
            nVar.ahg = true;
            d.this.zH.c(nVar);
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.zI != null) {
                com.kwad.components.core.webview.tachikoma.c.h hVar = new com.kwad.components.core.webview.tachikoma.c.h();
                hVar.agY = 1;
                d.this.zI.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            if (d.this.zJ != null) {
                bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.c.p pVar = new com.kwad.components.core.webview.tachikoma.c.p();
                        pVar.scene = 1;
                        d.this.zJ.a(pVar);
                        if (d.this.zM != null) {
                            d.this.zM.aY(d.this.tm.sw);
                        }
                    }
                }, 0L);
            }
        }
    };
    private final m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            d.this.iH();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i6, int i7) {
            d.this.kd();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            d.this.a(j6, j7);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            d.this.g(0.0d);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPreparing() {
            d.this.g(0.0d);
        }
    };

    public void a(WebCloseStatus webCloseStatus) {
    }

    public void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    protected boolean jW() {
        return false;
    }

    private void d(long j6, long j7) {
        if (j7 < Math.min(com.kwad.sdk.core.response.b.a.ag(this.tm.mAdTemplate.adInfoList.get(0)), j6) - 800) {
            this.tm.so = (int) (((r4 - j7) / 1000.0f) + 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(double d6) {
        z zVar = this.zK;
        zVar.aho = false;
        zVar.Wy = false;
        zVar.qz = (int) ((d6 / 1000.0d) + 0.5d);
        ke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iH() {
        if (this.tm.rX) {
            kd();
        } else {
            kc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX() {
        com.kwad.components.ad.reward.g gVar = this.tm;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY() {
        this.tm.D(kf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jZ() {
        com.kwad.components.ad.reward.j.b.a(this.tm.mAdTemplate, kf(), "endTopBar", new com.kwad.sdk.core.adlog.c.b().dd(39).f(this.tm.mRootContainer.getTouchCoords()), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        com.kwad.components.ad.reward.j.b.a(this.tm.mAdTemplate, kf(), (String) null, new com.kwad.sdk.core.adlog.c.b().dd(40).f(this.tm.mRootContainer.getTouchCoords()), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb() {
        com.kwad.components.ad.reward.j.b.a(this.tm.mAdTemplate, kf(), (String) null, new com.kwad.sdk.core.adlog.c.b().dd(41).f(this.tm.mRootContainer.getTouchCoords()), this.tm.mReportExtData);
        this.tm.rD.cW();
    }

    private void kc() {
        z zVar = this.zK;
        zVar.Wy = true;
        zVar.aho = false;
        zVar.qz = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.el(this.tm.mAdTemplate));
        ke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        z zVar = this.zK;
        zVar.aho = true;
        zVar.Wy = false;
        ke();
    }

    private void ke() {
        z zVar;
        p pVar = this.zG;
        if (pVar == null || (zVar = this.zK) == null) {
            return;
        }
        pVar.a(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kf() {
        com.kwad.components.ad.reward.k.a.d dVar = this.zF;
        if (dVar == null) {
            return null;
        }
        return dVar.getTkTemplateId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.tm.rD.onRewardVerify();
    }

    public void az() {
        e eVar = this.zN;
        if (eVar != null) {
            eVar.az();
        }
    }

    public com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.tm.mRootContainer;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.k.a.d dVar = this.zF;
        if (dVar == null || dVar.kx() == null) {
            return;
        }
        this.zF.kx().ia();
    }

    public d() {
        if (jW()) {
            this.zN = new e();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        this.zL = true;
        this.tm.a(this);
        if (this.zF == null) {
            this.zF = new com.kwad.components.ad.reward.k.a.d(this.tm, -1L, getContext());
        }
        if (this.zK == null) {
            this.zK = new z();
        }
        this.zF.a(this.tm.getActivity(), this.tm.mAdResultData, this);
        e eVar = this.zN;
        if (eVar != null) {
            eVar.A(this.tm);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (!this.zL) {
            return;
        }
        e eVar = this.zN;
        if (eVar != null) {
            eVar.B(this.tm);
        }
        this.tm.b(this);
        com.kwad.components.ad.reward.k.a.d dVar = this.zF;
        if (dVar != null) {
            dVar.kz();
        }
        com.kwad.components.ad.reward.m.e eVar2 = this.tm.rE;
        if (eVar2 != null) {
            eVar2.b(this.jE);
            this.tm.rE.b(this.kf);
        }
        com.kwad.components.ad.reward.b.gk().b(this.mRewardVerifyListener);
        this.tm.c(this.mPlayEndPageListener);
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            @Override // com.kwad.components.ad.reward.k.k.a
            public final void d(r rVar) {
                com.kwad.components.ad.reward.c.gn().c(rVar);
            }
        });
        tVar.c(kVar);
        long j6 = this.tm.sq;
        tVar.c(new com.kwad.components.ad.reward.k.g(j6 > 0 ? ((int) j6) / 1000 : 0));
        com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i();
        this.zI = iVar;
        tVar.c(iVar);
        j jVar = new j();
        this.zJ = jVar;
        tVar.c(jVar);
        com.kwad.components.ad.reward.b.gk().a(this.mRewardVerifyListener);
        this.tm.b(this.mPlayEndPageListener);
        tVar.c(new ak(new ak.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            @Override // com.kwad.components.core.webview.jshandler.ak.b
            public final void a(ak.a aVar) {
                d.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.k.d dVar = new com.kwad.components.ad.reward.k.d();
        dVar.a(new d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11
            @Override // com.kwad.components.ad.reward.k.d.a
            public final void a(final q qVar) {
                com.kwad.components.core.e.d.a.a(new a.C0616a(d.this.getContext()).aB(d.this.tm.mAdTemplate).b(d.this.tm.mApkDownloadHelper).aB(1).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (qVar.ahi) {
                            d.this.jZ();
                        } else {
                            d.this.ka();
                        }
                    }
                }));
            }
        });
        tVar.c(dVar);
        com.kwad.components.ad.reward.k.e eVar = new com.kwad.components.ad.reward.k.e();
        eVar.a(new e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12
            @Override // com.kwad.components.ad.reward.k.e.a
            public final void kg() {
                com.kwad.components.core.e.d.a.a(new a.C0616a(d.this.getContext()).aB(d.this.tm.mAdTemplate).b(d.this.tm.mApkDownloadHelper).aB(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        d.this.kb();
                    }
                }));
            }
        });
        tVar.c(eVar);
        tVar.c(new com.kwad.components.ad.reward.k.h(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            @Override // com.kwad.components.ad.reward.k.h.a
            public final void af(int i6) {
                if (com.kwad.components.ad.reward.g.P(d.this.tm.mAdTemplate)) {
                    if (!com.kwad.components.ad.reward.g.N(d.this.tm.mAdTemplate) || d.this.tm.sm == null) {
                        if (com.kwad.components.ad.reward.g.O(d.this.tm.mAdTemplate) && d.this.tm.sn != null && !d.this.tm.sn.kL()) {
                            d.this.tm.sn.kK();
                        }
                    } else if (!d.this.tm.sm.kL()) {
                        d.this.tm.sm.kK();
                    }
                }
                if (d.this.tm.gS() != RewardRenderResult.DEFAULT) {
                    d.this.tm.sc = i6;
                }
                d.this.notifyRewardVerify();
            }
        }));
        tVar.c(new com.kwad.components.ad.reward.k.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            @Override // com.kwad.components.ad.reward.k.c
            public final void kh() {
                super.kh();
                d.this.jY();
            }
        });
        tVar.c(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            @Override // com.kwad.components.ad.reward.k.f
            public final void V(boolean z5) {
                super.V(z5);
                com.kwad.components.ad.reward.presenter.f.v(d.this.tm);
            }
        });
        tVar.c(new com.kwad.components.ad.reward.k.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            @Override // com.kwad.components.ad.reward.k.b
            public final void kh() {
                super.kh();
                d.this.jX();
            }
        });
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.tachikoma.b.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.t.k.f(d.this.getContext(), d.this.tm.mAdTemplate);
            }
        });
        tVar.c(new com.kwad.components.ad.reward.i.b(getContext(), this.tm.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
        this.zM = hVar;
        hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // com.kwad.components.core.webview.tachikoma.b.h.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.h hVar2) {
                hVar2.aY(d.this.tm.sw);
            }
        });
        tVar.c(this.zM);
        tVar.c(new ah());
        tVar.c(new bi(bVar, this.tm.mApkDownloadHelper, this.zO));
        tVar.c(new y(this));
    }

    public void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aB() {
    }

    public void a(p pVar) {
        this.zG = pVar;
        com.kwad.components.ad.reward.m.e eVar = this.tm.rE;
        if (eVar != null) {
            eVar.a(this.jE);
        }
    }

    public void a(u uVar) {
        com.kwad.components.ad.reward.presenter.f.a(this.tm, false);
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.zN;
        if (eVar != null) {
            eVar.kj();
        }
    }

    public void a(az azVar) {
        e eVar = this.zN;
        if (eVar != null) {
            eVar.b(azVar);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0637a c0637a) {
        com.kwad.components.ad.reward.g gVar = this.tm;
        if (gVar == null || gVar.rD == null) {
            return;
        }
        try {
            a.c cVar = new a.c();
            cVar.parseJson(new JSONObject(c0637a.acg));
            String str = c0637a.acf;
            switch (str.hashCode()) {
                case -1552949011:
                    if (str.equals("rewardVerifyCallback")) {
                        this.tm.rD.onRewardVerify();
                        break;
                    }
                    break;
                case -1228923142:
                    if (str.equals("adCloseCallback")) {
                        this.tm.rD.i(cVar.acj);
                        break;
                    }
                    break;
                case -402746255:
                    if (str.equals("videoPlayEndCallback")) {
                        this.tm.rD.onVideoPlayEnd();
                        break;
                    }
                    break;
                case 601135198:
                    if (str.equals("videoPlayErrorCallback")) {
                        this.tm.rD.onVideoPlayError(cVar.errorCode, cVar.ach);
                        break;
                    }
                    break;
                case 1620545720:
                    if (str.equals("videoPlayStartCallback")) {
                        this.tm.rD.onVideoPlayStart();
                        break;
                    }
                    break;
                case 1852274314:
                    if (str.equals("adClickCallback")) {
                        this.tm.rD.cW();
                        break;
                    }
                    break;
                case 1917267918:
                    if (str.equals("adSkipWithPlayTimeCallback")) {
                        this.tm.rD.onVideoSkipToEnd(cVar.aci);
                        break;
                    }
                    break;
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("TKBasePresenter", "onOutCallback Error: " + th.getMessage());
        }
    }

    public void a(n nVar) {
        com.kwad.components.ad.reward.m.e eVar = this.tm.rE;
        if (eVar != null) {
            eVar.setAudioEnabled(!nVar.ahg, true);
        }
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.tm.rD.cW();
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.tm;
        if (gVar != null) {
            gVar.b(bVar);
        }
    }

    public void a(o oVar) {
        this.zH = oVar;
        com.kwad.components.ad.reward.m.e eVar = this.tm.rE;
        if (eVar != null) {
            eVar.a(this.kf);
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                boolean z5 = com.kwad.components.core.t.a.aC(d.this.getContext()).sW() || !d.this.tm.mVideoPlayConfig.isVideoSoundEnable();
                n nVar = new n();
                nVar.ahg = z5;
                d.this.zH.c(nVar);
                if (d.this.tm.rE != null) {
                    d.this.tm.rE.setAudioEnabled(!z5, false);
                }
            }
        });
    }

    public final void a(long j6, long j7) {
        d(j6, j7);
        g(j7);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.y.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.tm.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }
}
