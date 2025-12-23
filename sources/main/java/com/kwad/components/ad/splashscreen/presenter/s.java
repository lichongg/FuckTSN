package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.j.c {
    private com.kwad.components.ad.splashscreen.e.b HH;
    private boolean HI;
    private long HK;
    private az HL;
    private ViewGroup HN;

    @Nullable
    private KsAdWebView eN;
    private com.kwad.components.core.webview.a eP;
    private com.kwad.sdk.core.webview.b eQ;
    private com.kwad.sdk.core.g.d gX;
    private Vibrator gZ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean HJ = false;
    private boolean HM = false;
    private final Runnable HO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.1
        @Override // java.lang.Runnable
        public final void run() {
            s.a(s.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cu(s.this.mAdTemplate), SystemClock.elapsedRealtime() - s.this.HK, 1, "");
            s.this.mA();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void mA() {
        this.HJ = true;
        KsAdWebView ksAdWebView = this.eN;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.HN;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        final Presenter y5 = y(this.mAdInfo);
        if (y5 != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.8
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.a(y5, true);
                }
            });
        } else {
            mB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    private void bc() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.eQ = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.eQ;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.Gf.mRootContainer;
        bVar2.aMN = adBaseFrameLayout;
        bVar2.TG = adBaseFrameLayout;
        bVar2.Ta = this.eN;
        bVar2.mReportExtData = null;
        bVar2.aMP = false;
        bVar2.aMQ = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    private void bf() {
        com.kwad.components.core.webview.a aVar = this.eP;
        if (aVar != null) {
            aVar.destroy();
            this.eP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF() {
        if (this.gX != null || this.HJ) {
            return;
        }
        com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(com.kwad.sdk.core.response.b.b.dj(this.Gf.mAdTemplate));
        this.gX = dVar;
        dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.6
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d6) {
                boolean oW = com.kwad.components.core.e.c.b.oW();
                if (s.this.Gf.Fs.wl() && !oW) {
                    s.this.h(d6);
                    if (s.this.gZ == null) {
                        s sVar = s.this;
                        sVar.gZ = sVar.F(sVar.getContext());
                    }
                    bw.a(s.this.getContext(), s.this.gZ);
                    s.this.gX.bH(s.this.getContext());
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void cd() {
            }
        });
        this.gX.bG(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d6) {
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null) {
            hVar.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.7
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.l(d6);
                }
            });
        }
    }

    private z mC() {
        return new z(this.eQ, this.Gf.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.9
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (!com.kwad.sdk.c.a.a.DE()) {
                    if (aVar.KY() || com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                        s.this.a(false, aVar.adN, aVar.mI, aVar.adO.Pj);
                    }
                }
            }
        });
    }

    private ac mD() {
        return new ac(this.eQ, this.Gf.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.10
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar.adL || !com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                    s.this.a(false, aVar.adL ? 1 : 3, aVar.mI, "");
                }
            }
        }, (byte) 0);
    }

    private Presenter y(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.dn(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            if (com.kwad.sdk.core.response.b.b.dR(adInfo)) {
                return new m();
            }
            return null;
        }
        if (com.kwad.sdk.core.response.b.b.dP(this.mAdInfo)) {
            return new o();
        }
        if (com.kwad.sdk.core.response.b.b.dR(this.mAdInfo)) {
            return new m();
        }
        if (com.kwad.sdk.core.response.b.b.dU(this.mAdInfo)) {
            return new q();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.dV(this.mAdInfo)) {
            return new l();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.dW(this.mAdInfo)) {
            return new n();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.dX(this.mAdInfo)) {
            return new p();
        }
        return null;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bG(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
    }

    @SuppressLint({"WrongConstant"})
    public final void mz() {
        if (this.HI) {
            return;
        }
        this.HI = true;
        a.C0675a c0675a = new a.C0675a();
        c0675a.awX = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.Gf.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().df(123).b(c0675a));
        com.kwad.components.core.webview.tachikoma.e.a.vI().bm(123);
    }

    private void mB() {
        mz();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate), this.Gf.mApkDownloadHelper);
        this.HH = bVar;
        bVar.as(this.mAdTemplate);
        this.HH.a(this);
        this.HH.mA();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.Gf.Fs.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.HN = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.eN = new KsAdWebView(getContext());
            this.eN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.HN.addView(this.eN);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.Gf.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.HI = false;
        this.HJ = false;
        String cu = com.kwad.sdk.core.response.b.b.cu(this.mAdTemplate);
        if (this.eN != null && !TextUtils.isEmpty(cu) && !this.Gf.Fx) {
            this.HK = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.ar(this.mAdTemplate);
            a(this.eN, cu);
            bw.a(this.HO, null, com.kwad.sdk.core.response.b.b.eb(this.mAdInfo));
        } else {
            mA();
        }
        this.Gf.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.j.a aVar;
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.HH;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.gX;
        if (dVar != null) {
            dVar.bH(getContext());
        }
        az azVar = this.HL;
        if (azVar != null) {
            azVar.uH();
            this.HL.uI();
        }
        com.kwad.components.ad.splashscreen.h hVar = this.Gf;
        if (hVar != null && (aVar = hVar.Fs) != null) {
            aVar.b(this);
        }
        bf();
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void h(boolean z5, boolean z6) {
        com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "isClick: " + z5 + ", isActionBar: " + z6);
        a(!z5, z6 ? 1 : 2, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, null);
    }

    static /* synthetic */ boolean a(s sVar, boolean z5) {
        sVar.HM = true;
        return true;
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        bc();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().eJ(this.Gf.mAdTemplate).b(new com.kwad.sdk.core.webview.f() { // from class: com.kwad.components.ad.splashscreen.presenter.s.3
            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.HK);
            }

            @Override // com.kwad.sdk.core.webview.f, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i6, String str2, String str3) {
                super.onReceivedHttpError(i6, str2, str3);
                bw.c(s.this.HO);
                s.this.mA();
                com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.HK, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            mA();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void a(WebView webView, String str) {
        bf();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.eP = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.eP, "KwaiAd");
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i6) {
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new bc(this.eQ, this.Gf.mApkDownloadHelper));
        aVar.a(mD());
        aVar.a(mC());
        aVar.a(new af(this.eQ));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new as(new as.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.4
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar2) {
                com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bw.c(s.this.HO);
                if (aVar2.status != 1) {
                    com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.HK, 3, "");
                    s.this.mA();
                    return;
                }
                s.this.Gf.FI = SystemClock.elapsedRealtime() - s.this.mStartTime;
                if (s.this.HM) {
                    s.this.Gf.isWebTimeout = true;
                } else if (s.this.HL != null) {
                    s.this.HL.uF();
                    s.this.HL.uG();
                }
                if (com.kwad.sdk.core.response.b.b.dZ(s.this.mAdInfo)) {
                    s.this.mz();
                }
            }
        }, str));
        aVar.a(new bb(new bb.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.5
            @Override // com.kwad.components.core.webview.jshandler.bb.a
            public final void cL() {
                s.this.cF();
            }
        }));
        aVar.a(new am(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.eQ));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.eQ));
        az azVar = new az();
        this.HL = azVar;
        aVar.a(azVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r11, int r12, int r13, java.lang.String r14) {
        /*
            r10 = this;
            com.kwad.components.ad.splashscreen.h r0 = r10.Gf
            r0.X()
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            r1 = r0 ^ 1
            r2 = 0
            r3 = 1
            if (r12 != r3) goto L11
            r4 = 1
            goto L12
        L11:
            r4 = 0
        L12:
            if (r0 == 0) goto L4d
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            com.kwad.components.ad.splashscreen.h r6 = r10.Gf     // Catch: org.json.JSONException -> L2b
            if (r6 == 0) goto L4d
            com.kwad.components.ad.splashscreen.d.a r6 = r6.Fq     // Catch: org.json.JSONException -> L2b
            if (r6 == 0) goto L2e
            java.lang.String r7 = "duration"
            long r8 = r6.getCurrentPosition()     // Catch: org.json.JSONException -> L2b
            r5.put(r7, r8)     // Catch: org.json.JSONException -> L2b
            goto L2e
        L2b:
            r11 = move-exception
            r2 = r13
            goto L49
        L2e:
            if (r11 == 0) goto L33
            r2 = 153(0x99, float:2.14E-43)
            goto L37
        L33:
            if (r4 == 0) goto L37
            r2 = 132(0x84, float:1.85E-43)
        L37:
            com.kwad.sdk.core.adlog.c.b r11 = new com.kwad.sdk.core.adlog.c.b     // Catch: org.json.JSONException -> L48
            r11.<init>()     // Catch: org.json.JSONException -> L48
            com.kwad.sdk.core.adlog.c.b r11 = r11.dd(r2)     // Catch: org.json.JSONException -> L48
            com.kwad.components.ad.splashscreen.h r6 = r10.Gf     // Catch: org.json.JSONException -> L48
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.mAdTemplate     // Catch: org.json.JSONException -> L48
            com.kwad.sdk.core.adlog.c.a(r6, r11, r5)     // Catch: org.json.JSONException -> L48
            goto L4e
        L48:
            r11 = move-exception
        L49:
            com.kwad.sdk.core.d.c.printStackTrace(r11)
            goto L4e
        L4d:
            r2 = r13
        L4e:
            com.kwad.components.core.e.d.a$a r11 = new com.kwad.components.core.e.d.a$a
            com.kwad.components.ad.splashscreen.h r5 = r10.Gf
            com.kwad.sdk.core.view.AdBaseFrameLayout r5 = r5.mRootContainer
            android.content.Context r5 = r5.getContext()
            r11.<init>(r5)
            com.kwad.components.ad.splashscreen.h r5 = r10.Gf
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r11 = r11.aB(r5)
            com.kwad.components.ad.splashscreen.h r5 = r10.Gf
            com.kwad.components.core.e.d.c r5 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r11 = r11.b(r5)
            com.kwad.components.core.e.d.a$a r11 = r11.aq(r4)
            com.kwad.components.core.e.d.a$a r11 = r11.aB(r12)
            if (r0 != 0) goto L76
            goto L77
        L76:
            r13 = r2
        L77:
            com.kwad.components.core.e.d.a$a r11 = r11.aA(r13)
            com.kwad.components.core.e.d.a$a r11 = r11.am(r14)
            com.kwad.components.core.e.d.a$a r11 = r11.az(r3)
            com.kwad.components.core.e.d.a$a r11 = r11.as(r1)
            com.kwad.components.ad.splashscreen.presenter.s$2 r12 = new com.kwad.components.ad.splashscreen.presenter.s$2
            r12.<init>()
            com.kwad.components.core.e.d.a$a r11 = r11.a(r12)
            com.kwad.components.core.e.d.a.a(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.presenter.s.a(boolean, int, int, java.lang.String):void");
    }
}
