package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.e.d.a;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bv;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends com.kwad.sdk.mvp.a {
    public int FA;
    public int FB;
    public long FC;
    public long FD;
    public long FE;
    public long FF;
    public long FG;
    public long FH;
    public long FI;
    private KsSplashScreenAd.SplashScreenAdInteractionListener Fe;

    @Nullable
    public com.kwad.components.ad.splashscreen.d.a Fq;
    public StyleTemplate Fr;
    public com.kwad.sdk.core.j.a Fs;
    public AdResultData mAdResultData;

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public bv mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    private List<g> Ft = new CopyOnWriteArrayList();
    private List<f> Fu = new CopyOnWriteArrayList();
    public boolean Fv = false;
    private boolean Fw = false;
    public boolean Fx = false;
    public boolean Fy = false;
    public boolean bO = false;
    public long Fz = SystemClock.elapsedRealtime();
    public boolean isWebTimeout = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar);
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    public final void c(int i6, Context context, int i7, int i8) {
        a(i6, context, i7, i8, null);
    }

    private void lU() {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        SplashMonitorInfo elementTypes = new SplashMonitorInfo().setLoadType(this.mAdTemplate.splashAdLoadType).setStatus(8).setElementTypes(com.kwad.components.core.webview.tachikoma.e.a.vI().vJ());
        bv bvVar = this.mTimerHelper;
        com.kwad.sdk.commercial.b.m(elementTypes.setShowEndTime(bvVar != null ? bvVar.getTime() : -1L).setRotateComposeTimeout(this.bO).setTkDefaultTimeout(ac(this.mAdTemplate) ? com.kwad.sdk.core.response.b.b.dw(this.mAdTemplate) : com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate))).setSoSource(this.FA).setSoLoadTime(this.FC).setOfflineSource(this.FB).setOfflineLoadTime(this.FD).setTkFileLoadTime(this.FE).setTkInitTime(this.FF).setTkRenderTime(this.FG).setNativeLoadTime(this.FH).setWebTimeout(this.isWebTimeout).setWebLoadTime(this.FI).setInteractiveStyle(com.kwad.sdk.core.response.b.b.dN(el)).setInteractivityDefaultStyle(com.kwad.sdk.core.response.b.b.dO(el)).setCreativeId(com.kwad.sdk.core.response.b.a.J(el)).setAdTemplate(this.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.e.a.vI().vK();
    }

    private void lV() {
        Iterator<f> it = this.Fu.iterator();
        while (it.hasNext()) {
            it.next().lC();
        }
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    public final void U(Context context) {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        com.kwad.components.ad.splashscreen.local.a.V(context);
        if (!com.kwad.sdk.core.config.e.Go()) {
            com.kwad.components.core.t.b.sY().a(this.mAdTemplate, null, null);
        }
        com.kwad.sdk.commercial.d.c.bL(this.mAdTemplate);
        af(true);
    }

    @MainThread
    public final void X() {
        this.mAdTemplate.converted = true;
        com.kwad.components.ad.splashscreen.monitor.a.lX().ag(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lX().ae(this.mAdTemplate);
    }

    @MainThread
    public final void af(boolean z5) {
        if (this.Fw) {
            return;
        }
        this.Fw = true;
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        if (z5 && com.kwad.sdk.core.config.e.Go()) {
            com.kwad.components.core.t.b.sY().a(this.mAdTemplate, null, null);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mAdTemplate.showTime = elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, elapsedRealtime - adTemplate.showStartTime, elapsedRealtime - adTemplate.addStartTime, elapsedRealtime - adTemplate.requestStartTime);
        com.kwad.components.ad.splashscreen.monitor.c.aq(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.a.lX().v(this.mAdTemplate);
        com.kwad.sdk.a.a.c.CU().bm(true);
        bv bvVar = this.mTimerHelper;
        if (bvVar != null) {
            bvVar.startTiming();
        }
    }

    public final void al(int i6) {
        Iterator<g> it = this.Ft.iterator();
        while (it.hasNext()) {
            it.next().ak(i6);
        }
    }

    public final void b(g gVar) {
        this.Ft.remove(gVar);
    }

    @MainThread
    public final void c(int i6, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(i6, str);
        }
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, i6, String.valueOf(str));
        lT();
    }

    public final void lI() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "onMediaPlayError");
        }
    }

    public final void lJ() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    public final void lK() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    public final void lL() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
    }

    public final void lM() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    public final void lN() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final void lO() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final void lP() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    @MainThread
    public final void lQ() {
        if (this.Fv) {
            return;
        }
        this.Fv = true;
        if (!r(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)) || this.mAdTemplate.converted) {
            a.C0675a c0675a = new a.C0675a();
            bv bvVar = this.mTimerHelper;
            if (bvVar != null) {
                c0675a.duration = bvVar.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().de(14).dm(22).b(c0675a), (JSONObject) null);
            com.kwad.components.ad.splashscreen.monitor.a.lX().ah(this.mAdTemplate);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            com.kwad.components.ad.splashscreen.monitor.a.lX().w(this.mAdTemplate);
        } else {
            lV();
        }
        lT();
    }

    @MainThread
    public final void lS() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lX().w(this.mAdTemplate);
        lT();
    }

    public final void lW() {
        this.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.h.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.oW()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.lR();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.Fq;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.j.a aVar2 = this.Fs;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.Fe = splashScreenAdInteractionListener;
    }

    public static boolean ac(AdTemplate adTemplate) {
        AdMatrixInfo.SplashPlayCardTKInfo dv;
        if (!com.kwad.sdk.core.config.e.Fq() || (dv = com.kwad.sdk.core.response.b.b.dv(adTemplate)) == null || TextUtils.isEmpty(dv.templateId) || dv.renderType != 1) {
            return false;
        }
        return true;
    }

    private void lT() {
        lU();
        Iterator<g> it = this.Ft.iterator();
        while (it.hasNext()) {
            it.next().lG();
        }
    }

    public static boolean r(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.b.dy(adInfo) && com.kwad.sdk.core.response.b.a.bd(adInfo)) {
            return true;
        }
        return false;
    }

    public final void a(final int i6, Context context, final int i7, int i8, final a aVar) {
        com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        com.kwad.components.core.e.d.a.a(new a.C0616a(context).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aB(i8).aq(i8 == 1).aA(i7).az(i6).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.components.ad.splashscreen.monitor.a.lX().ag(h.this.mAdTemplate);
                if (h.this.Fe != null) {
                    h.this.Fe.onAdClicked();
                }
                com.kwad.components.ad.splashscreen.monitor.a.lX().ae(h.this.mAdTemplate);
                JSONObject jSONObject = new JSONObject();
                try {
                    com.kwad.components.ad.splashscreen.d.a aVar2 = h.this.Fq;
                    if (aVar2 != null) {
                        jSONObject.put("duration", aVar2.getCurrentPosition());
                    }
                } catch (JSONException e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                }
                com.kwad.sdk.core.adlog.c.b f6 = new com.kwad.sdk.core.adlog.c.b().dd(i7).f(h.this.mRootContainer.getTouchCoords());
                if (i6 == 2) {
                    f6.dm(6);
                }
                com.kwad.sdk.core.adlog.c.a(h.this.mAdTemplate, f6, jSONObject);
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.b(f6);
                }
            }
        }));
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Fu.remove(fVar);
    }

    @MainThread
    public final void lH() {
        com.kwad.components.ad.splashscreen.monitor.a.lX().ah(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lX().w(this.mAdTemplate);
    }

    @MainThread
    public final void lR() {
        com.kwad.components.ad.splashscreen.monitor.a.lX().ah(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.Fe;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lX().w(this.mAdTemplate);
    }

    public final void a(g gVar) {
        this.Ft.add(gVar);
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.Fu.add(fVar);
    }
}
