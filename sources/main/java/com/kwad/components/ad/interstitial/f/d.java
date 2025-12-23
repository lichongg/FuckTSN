package com.kwad.components.ad.interstitial.f;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends b {
    public static float mP = 1.3333334f;
    private static float mQ = 0.749f;
    private static float mR = 0.8f;
    private static float mS = 1.0f;
    private com.kwad.sdk.core.video.videoview.a cq;
    private com.kwad.components.core.widget.a.b fg;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean mN;
    private KSFrameLayout mO;
    private c.b mT;
    private com.kwad.sdk.core.j.d mU = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ad.interstitial.f.d.5
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bt() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.mj.mn && d.this.mj.kQ != null) {
                d.this.mj.kQ.onAdShow();
                d.this.mj.kW.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.eS().a(d.this.mj.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.b dp = new com.kwad.sdk.core.adlog.c.b().dp(d.this.mj.mx);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.eS().D(d.this.mAdTemplate);
            }
            com.kwad.components.core.t.b.sY().a(d.this.mAdTemplate, null, dp);
            d.this.mg.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bu() {
            d.this.mg.setCountDownPaused(true);
        }
    };
    private KsAutoCloseView mg;
    private c mj;

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams N(int i6) {
        int i7 = (int) (i6 * mQ);
        return new ViewGroup.LayoutParams((int) (i7 / 0.749f), i7);
    }

    private static boolean c(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.b.a.bK(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i6, int i7) {
        if (this.mj.a(new c.C0567c(getContext()).l(this.mN).a(this.mO.getTouchCoords()).L(i6).M(i7)) && com.kwad.components.ad.interstitial.d.b.t(this.mAdTemplate)) {
            c cVar = this.mj;
            if (cVar.kW != null) {
                cVar.a(false, -1, cVar.cq);
                this.mj.kW.dismiss();
                this.mj.Y();
            }
        }
    }

    private c.b ed() {
        c.b bVar = new c.b() { // from class: com.kwad.components.ad.interstitial.f.d.4
            @Override // com.kwad.components.ad.interstitial.f.c.b
            public final void c(long j6, long j7) {
                com.kwad.components.ad.interstitial.report.a.eO().b(d.this.mAdTemplate, j6, j7);
            }
        };
        this.mT = bVar;
        return bVar;
    }

    private void ee() {
        final com.kwad.components.ad.interstitial.h.d dVar = this.mj.mk;
        dVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            dVar.c(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl, this.mAdTemplate);
            dVar.c(true, true);
            dVar.u(false);
        } else {
            dVar.u(true);
            String url = com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                dVar.c(false, false);
            } else {
                dVar.c(url, this.mAdTemplate);
                dVar.c(true, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.mj.cq;
            this.cq = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.cq.getParent()).removeView(this.cq);
            }
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                dVar.a(com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).height / com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).width, this.cq);
            }
            dVar.v(this.mj.bU.isVideoSoundEnable());
            final int L = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
            this.mj.a(new a.c() { // from class: com.kwad.components.ad.interstitial.f.d.6
                @Override // com.kwad.components.core.video.a.c
                public final void aq() {
                    dVar.c(false, false);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void ar() {
                    d.this.cq.setVisibility(8);
                    if (d.this.mj.M(d.this.getContext())) {
                        return;
                    }
                    dVar.fh();
                }

                @Override // com.kwad.components.core.video.a.c
                @SuppressLint({"SetTextI18n"})
                public final void d(long j6) {
                    int i6 = L - ((int) (j6 / 1000));
                    if (i6 >= 0) {
                        dVar.A(String.valueOf(i6));
                    } else {
                        dVar.ff();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    dVar.u(true);
                }
            });
            dVar.a(this.mAdTemplate, this.mAdInfo);
            dVar.u(true);
            this.mj.f36337ms.add(new c.d() { // from class: com.kwad.components.ad.interstitial.f.d.7
                @Override // com.kwad.components.ad.interstitial.f.c.d
                public final void eb() {
                    dVar.fi();
                    d.this.cq.setVisibility(0);
                }
            });
        }
        this.mj.a(getContext(), this.mAdInfo, this.mAdTemplate, dVar.getBlurBgView());
        String O = com.kwad.sdk.core.response.b.a.O(this.mAdInfo);
        if (TextUtils.isEmpty(O)) {
            O = com.kwad.sdk.core.response.b.a.X(this.mAdInfo);
        }
        KSImageLoader.loadImage(dVar.getTailFrameView(), O, this.mAdTemplate);
        if (!c(this.mAdInfo)) {
            this.mg.bb(false);
        } else {
            this.mg.bb(true);
            ef();
        }
    }

    private void ef() {
        AdInfo adInfo = this.mAdInfo;
        int i6 = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            i6 = Math.min(i6, com.kwad.sdk.core.response.b.a.L(this.mAdInfo));
            this.mj.mk.ff();
            this.mj.mk.fg();
        }
        this.mg.ai(i6);
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 165, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z5) {
        c cVar = this.mj;
        if (!cVar.mn && !z5 && !cVar.ml && !cVar.mm && com.kwad.components.ad.interstitial.g.a.d(cVar)) {
            this.mj.mm = true;
            com.kwad.components.ad.interstitial.c.b.K(getContext());
            return;
        }
        this.mj.a(z5, -1, this.cq);
        this.mj.kW.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar != null) {
            aVar.release();
        }
        this.mj.Y();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        c cVar = (c) NN();
        this.mj = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        com.kwad.components.ad.interstitial.report.c.eS().C(this.mj.mAdTemplate);
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mj.mAdTemplate);
        this.mAdInfo = el;
        int i6 = com.kwad.sdk.core.response.b.a.aX(el).width;
        if (i6 > 0) {
            mP = r0.height / i6;
        }
        this.mj.fV.setBackgroundColor(Color.parseColor("#99000000"));
        this.mj.mk.setVisibility(0);
        this.mj.mk.H(this.mAdTemplate);
        this.mj.a(ed());
        ee();
        this.mj.mk.setViewListener(new com.kwad.components.ad.interstitial.h.e() { // from class: com.kwad.components.ad.interstitial.f.d.2
            @Override // com.kwad.components.ad.interstitial.h.e
            public final void a(KSFrameLayout kSFrameLayout) {
                d.this.mO = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eh() {
                d.this.o(false);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ei() {
                d.this.e(3, d.this.mj.mk.fj() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ej() {
                d.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ek() {
                d.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void el() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void em() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void en() {
                d.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eo() {
                d.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ep() {
                d.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eq() {
                d.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void er() {
                d.this.e(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void es() {
                d.this.e(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void et() {
                d.this.e(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eu() {
                d.this.e(2, 35);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void p(boolean z5) {
                if (d.this.cq != null) {
                    d.this.cq.setVideoSoundEnable(z5);
                }
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void q(boolean z5) {
                d.this.mN = z5;
            }
        });
        com.kwad.components.core.widget.a.b bVar = new com.kwad.components.core.widget.a.b(this.mj.mk, 100);
        this.fg = bVar;
        bVar.a(this.mU);
        this.fg.wi();
        final boolean aW = com.kwad.sdk.core.response.b.a.aW(this.mAdInfo);
        getContext();
        final boolean QW = aq.QW();
        this.mj.mk.setRatio(b(QW, aW));
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.d.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ViewGroup.LayoutParams a6 = QW ? d.a(d.this.getRootView().getWidth(), aW) : d.N(d.this.getRootView().getHeight());
                ViewParent parent = d.this.mj.mk.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.mj.mk);
                }
                viewGroup.addView(d.this.mj.mk);
                d.this.mj.mk.f(a6.width, a6.height);
                viewGroup.requestLayout();
                viewGroup.post(new bg() { // from class: com.kwad.components.ad.interstitial.f.d.3.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (d.this.cq != null) {
                            d.this.cq.requestLayout();
                        }
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.mg = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.f.d.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void eg() {
                d.this.o(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void eh() {
                d.this.o(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mj.b(this.mT);
        com.kwad.components.core.widget.a.b bVar = this.fg;
        if (bVar != null) {
            bVar.b(this.mU);
            this.fg.wj();
        }
    }

    private static float b(boolean z5, boolean z6) {
        if (z5 && z6) {
            return mP;
        }
        return 0.749f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams a(int i6, boolean z5) {
        float f6;
        if (z5) {
            f6 = mR;
        } else {
            f6 = mS;
        }
        int i7 = (int) (i6 * f6);
        return new ViewGroup.LayoutParams(i7, (int) (i7 * (z5 ? mP : 0.749f)));
    }
}
