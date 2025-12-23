package com.kwad.components.ad.c.c;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.c.b.a;
import com.kwad.components.ad.c.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.k;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends a {
    private com.kwad.components.ad.c.b.a cE;
    private com.kwad.components.ad.c.b.a cF;
    private FrameLayout cG;
    private boolean cH;
    private boolean cI;
    private boolean cJ;
    private long cK;
    private boolean cL;
    boolean cP;
    private long startTime;
    private Handler handler = new Handler();
    private boolean cM = true;
    private bg cN = new bg() { // from class: com.kwad.components.ad.c.c.c.1
        @Override // com.kwad.sdk.utils.bg
        public final void doTask() {
            if (c.this.cM) {
                c.this.cK = System.currentTimeMillis() - c.this.startTime;
                if (!c.this.cI || (c.this.cK >= e.Gi() && com.kwad.sdk.core.response.b.a.dt(com.kwad.sdk.core.response.b.e.el(c.this.cD.mAdTemplate)))) {
                    c.this.aw();
                    c.this.cJ = true;
                    c.b(c.this, true);
                    if (c.this.cK >= e.Gi()) {
                        c.this.startTime = System.currentTimeMillis();
                    }
                }
                if (com.kwad.sdk.core.response.b.a.dt(com.kwad.sdk.core.response.b.e.el(c.this.cD.mAdTemplate))) {
                    c.this.handler.postDelayed(this, 1000L);
                }
            }
        }
    };
    private int cO = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        this.handler.removeCallbacksAndMessages(this.cN);
        this.handler.post(this.cN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        this.handler.removeCallbacksAndMessages(this.cN);
    }

    static /* synthetic */ boolean d(c cVar, boolean z5) {
        cVar.cL = true;
        return true;
    }

    public final void aw() {
        if (this.cJ || this.cD.bK.isEmpty()) {
            return;
        }
        try {
            com.kwad.components.ad.c.b.a aVar = new com.kwad.components.ad.c.b.a(getContext(), this.cD.bK.get(this.cO), new a.InterfaceC0551a() { // from class: com.kwad.components.ad.c.c.c.3
                @Override // com.kwad.components.ad.c.b.a.InterfaceC0551a
                public final void e(AdTemplate adTemplate) {
                    com.kwad.sdk.core.adlog.c.h(adTemplate, (JSONObject) null);
                    c.this.cD.Y();
                    c.this.cD.bH.removeAllViews();
                    c.this.handler.removeCallbacksAndMessages(null);
                    c.this.onDestroy();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0551a
                public final void a(final int i6, int i7, final AdTemplate adTemplate) {
                    com.kwad.components.core.e.d.a.a(new a.C0616a(c.this.getContext()).aB(adTemplate).av(true).b(new com.kwad.components.core.e.d.c(adTemplate)).as(false).aB(i7).aA(i6).a(new a.b() { // from class: com.kwad.components.ad.c.c.c.3.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
                            a.C0675a c0675a = new a.C0675a();
                            aVar2.Pk = c0675a;
                            c0675a.templateId = "101";
                            aVar2.mI = i6;
                            com.kwad.sdk.core.adlog.c.a(adTemplate, aVar2, (JSONObject) null);
                        }
                    }));
                    c.this.cD.X();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0551a
                public final void as() {
                    c.this.cD.c(0, "onMediaPlayError");
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0551a
                public final void d(AdTemplate adTemplate) {
                    if (adTemplate.mPvReported) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0675a c0675a = new a.C0675a();
                    c0675a.templateId = "101";
                    c0675a.axh = com.kwad.sdk.core.response.b.a.dt(com.kwad.sdk.core.response.b.e.el(c.this.cD.mAdTemplate)) ? 1 : 2;
                    bVar.b(c0675a);
                    com.kwad.components.core.t.b.sY().a(adTemplate, null, bVar);
                    c.this.cD.W();
                }
            });
            aVar.a(this.cD.bJ);
            com.kwad.components.ad.c.b bVar = this.cD;
            bVar.b(bVar.bK.get(this.cO));
            if (this.cH) {
                this.cF = aVar;
                this.cG.addView(aVar);
                this.cF.ao();
                this.handler.postDelayed(new bg() { // from class: com.kwad.components.ad.c.c.c.5
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (c.this.cE != null) {
                            c.this.cG.removeView(c.this.cE);
                        }
                        c.this.cJ = false;
                    }
                }, 500L);
                this.cH = false;
            } else {
                this.cE = aVar;
                this.cG.addView(aVar);
                this.cE.ao();
                this.handler.postDelayed(new bg() { // from class: com.kwad.components.ad.c.c.c.4
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (c.this.cF != null) {
                            c.this.cG.removeView(c.this.cF);
                        }
                        c.this.cJ = false;
                    }
                }, 500L);
                this.cH = true;
            }
            int i6 = this.cO + 1;
            this.cO = i6;
            if (i6 == this.cD.bK.size()) {
                ax();
                this.cO = 0;
            }
            if (!this.cP) {
                this.cP = true;
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "translationX", this.cG.getWidth(), 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.start();
        } catch (Exception e6) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e6);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    public final void ax() {
        SceneImpl covert = SceneImpl.covert(g.bV);
        covert.setBidResponse(null);
        covert.setBidResponseV2(null);
        d.c(covert);
        boolean b6 = n.tn().b(covert, "loadBannerAd");
        covert.setAdStyle(5);
        KsAdLoadManager.M().a(new a.C0634a().e(new ImpInfo(covert)).aM(b6).a(new j() { // from class: com.kwad.components.ad.c.c.c.7
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ah() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.c.c.6
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z5) {
                c.this.cD.bK = adResultData.getAdTemplateList();
                if (c.this.cD.bK.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                    k.aq("bannerAd_", "数据为空");
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(int i6, String str) {
                c.this.handler.postDelayed(new bg() { // from class: com.kwad.components.ad.c.c.c.6.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (c.this.cL) {
                            c.this.cJ = true;
                        } else {
                            c.this.ax();
                            c.d(c.this, true);
                        }
                    }
                }, e.Gi());
            }
        }).sw());
    }

    static /* synthetic */ boolean b(c cVar, boolean z5) {
        cVar.cI = true;
        return true;
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.cG = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        this.startTime = System.currentTimeMillis();
        au();
        a(this.cG);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
    }

    private void a(ViewGroup viewGroup) {
        if (e.FK() || e.FJ() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0647a() { // from class: com.kwad.components.ad.c.c.c.2
            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void c(View view) {
                c.this.au();
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void onWindowFocusChanged(boolean z5) {
                if (!z5) {
                    c.this.cM = false;
                    c.this.av();
                } else {
                    c.this.cM = true;
                    c.this.startTime = System.currentTimeMillis() - c.this.cK;
                    c.this.au();
                }
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void aa() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void ab() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0647a
            public final void ay() {
            }
        });
        aVar.vU();
    }
}
