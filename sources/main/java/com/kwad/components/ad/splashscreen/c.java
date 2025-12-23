package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.ad.splashscreen.presenter.k;
import com.kwad.components.ad.splashscreen.presenter.r;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bv;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends com.kwad.components.core.m.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener Fe;
    private com.kwad.components.ad.splashscreen.e.d Ff;
    private com.kwad.sdk.core.j.b dn;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:2|3)|(2:5|(8:7|8|9|(2:15|(1:17))|19|(1:21)|22|23))|27|8|9|(4:11|13|15|(0))|19|(0)|22|23) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void ab() {
        /*
            r5 = this;
            super.ab()
            r0 = 0
            android.view.View r1 = r5.getRootView()     // Catch: java.lang.Throwable -> L17
            r2 = 1
            if (r1 == 0) goto L19
            android.view.View r1 = r5.getRootView()     // Catch: java.lang.Throwable -> L17
            int r1 = r1.getVisibility()     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L19
            r1 = 1
            goto L1a
        L17:
            goto L4a
        L19:
            r1 = 0
        L1a:
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L4b
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L48
            android.view.ViewParent r3 = r3.getParent()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L4b
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L48
            android.view.ViewParent r3 = r3.getParent()     // Catch: java.lang.Throwable -> L48
            boolean r3 = r3 instanceof android.view.View     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L4b
            android.view.View r3 = r5.getRootView()     // Catch: java.lang.Throwable -> L48
            android.view.ViewParent r3 = r3.getParent()     // Catch: java.lang.Throwable -> L48
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Throwable -> L48
            int r3 = r3.getVisibility()     // Catch: java.lang.Throwable -> L48
            if (r3 != 0) goto L4b
            r0 = 1
            goto L4b
        L48:
            goto L4b
        L4a:
            r1 = 0
        L4b:
            com.kwad.components.ad.splashscreen.monitor.b.lZ()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r5.mAdTemplate
            com.kwad.sdk.l r3 = com.kwad.sdk.l.Cf()
            long r3 = r3.CH()
            com.kwad.components.ad.splashscreen.monitor.b.a(r2, r3, r1, r0)
            com.kwad.components.core.e.d.c r0 = r5.mApkDownloadHelper
            if (r0 == 0) goto L68
            r1 = 0
            r0.setOnDismissListener(r1)
            com.kwad.components.core.e.d.c r0 = r5.mApkDownloadHelper
            r0.setOnShowListener(r1)
        L68:
            com.kwad.components.ad.splashscreen.e.d r0 = r5.Ff
            r0.wj()
            r5.lz()
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            com.kwai.adclient.kscommerciallogger.model.BusinessType r0 = com.kwad.sdk.commercial.d.be(r0)
            com.kwad.components.core.g.a.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.c.ab():void");
    }

    @Override // com.kwad.components.core.m.c
    public final boolean ai() {
        return true;
    }

    public static c a(Context context, @NonNull AdResultData adResultData, boolean z5, com.kwad.sdk.core.j.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        c cVar = null;
        try {
            r5.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.ai(r5);
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.a(r5, l.Cf().CH(), z5);
            c cVar2 = new c(m.wrapContextIfNeed(context), adResultData);
            try {
                cVar2.setPageExitListener(bVar);
                cVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
                return cVar2;
            } catch (Throwable th) {
                th = th;
                cVar = cVar2;
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.a(r5, th.toString(), z5);
                if (!l.Cf().Bk()) {
                    throw th;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                return cVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k6 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dK(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k6 != null) {
            styleTemplate.templateId = k6.templateId;
            styleTemplate.templateMd5 = k6.templateMd5;
            styleTemplate.templateUrl = k6.templateUrl;
            styleTemplate.templateVersionCode = (int) k6.templateVersionCode;
        }
        return styleTemplate;
    }

    private int getSplashLayoutId() {
        return R.layout.ksad_splash_screen_layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.c
    /* renamed from: ly, reason: merged with bridge method [inline-methods] */
    public h al() {
        com.kwad.components.ad.splashscreen.e.d dVar = new com.kwad.components.ad.splashscreen.e.d(this.nY, com.kwad.sdk.core.response.b.a.cG(this.mAdInfo));
        this.Ff = dVar;
        dVar.a(this.dn);
        this.Ff.wi();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        h hVar = new h();
        hVar.a(this.mAdResultData);
        hVar.setSplashScreenAdListener(this.Fe);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.Fs = this.Ff;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.Fr = c(this.mAdTemplate);
        hVar.mTimerHelper = new bv();
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.d.a aVar = new com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.Fq = aVar;
            hVar.Fs.a(aVar);
        }
        hVar.Fs.a(a(hVar));
        return hVar;
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.core.m.c
    public final void ak() {
        this.mRootContainer = (AdBaseFrameLayout) this.nY.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.nY.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!com.kwad.sdk.c.a.a.DE() && c.n(c.this.mAdInfo) && c.this.Rv != null) {
                    ((h) c.this.Rv).c(1, view.getContext(), 53, 2);
                }
            }
        });
    }

    @Override // com.kwad.components.core.m.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = build;
        this.mAdTemplate.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean oY = dialogInterface instanceof com.kwad.components.core.e.c.b ? ((com.kwad.components.core.e.c.b) dialogInterface).oY() : false;
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
            if (splashScreenAdInteractionListener != null) {
                if (oY) {
                    splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
                } else {
                    splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dn = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Fe = splashScreenAdInteractionListener;
        T t5 = this.Rv;
        if (t5 != 0) {
            ((h) t5).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    private c(Context context, AdResultData adResultData) {
        super(context);
        this.mAdResultData = adResultData;
        AdTemplate r5 = com.kwad.sdk.core.response.b.c.r(adResultData);
        this.mAdTemplate = r5;
        this.mAdScene = r5.mAdScene;
        qs();
    }

    private void lz() {
        com.kwad.sdk.a.a.c.CU().CX();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        post(new bg() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdTemplate adTemplate = c.this.mAdTemplate;
                AdInfo unused = c.this.mAdInfo;
                if (h.ac(adTemplate) || ((h) c.this.Rv).Fq == null) {
                    return;
                }
                ((h) c.this.Rv).Fq.nk();
            }
        });
    }

    @Override // com.kwad.components.core.m.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.m.c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return ab(this.mAdTemplate);
    }

    @Override // android.view.View
    protected final void onVisibilityChanged(@NonNull View view, int i6) {
        super.onVisibilityChanged(view, i6);
    }

    private com.kwad.sdk.core.j.c a(final h hVar) {
        return new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.j.c
            public final void bt() {
                bv bvVar = hVar.mTimerHelper;
                if (bvVar != null) {
                    bvVar.Sl();
                }
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bu() {
                bv bvVar = hVar.mTimerHelper;
                if (bvVar != null) {
                    bvVar.Sm();
                }
            }
        };
    }

    private static Presenter ab(AdTemplate adTemplate) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Presenter presenter = new Presenter();
        a(presenter, el);
        if (h.ac(adTemplate)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.playcard.a());
            return presenter;
        }
        presenter.a(new j());
        return presenter;
    }

    private static void a(Presenter presenter, AdInfo adInfo) {
        presenter.a(new k());
        presenter.a(new r());
        if (h.r(adInfo)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.endcard.f());
        }
    }
}
