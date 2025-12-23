package com.kwad.components.ad.splashscreen.presenter.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends c implements com.kwad.sdk.core.j.c {
    private m Jb;
    private FrameLayout cV;
    private az cX;
    private boolean Je = false;
    f Ix = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.4
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lC() {
            a.this.cV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.cV.setVisibility(8);
                }
            }, 500L);
            if (a.this.cX != null) {
                a.this.cX.uH();
                a.this.cX.uI();
            }
        }
    };

    @NonNull
    private m ng() {
        m mVar = new m();
        this.Jb = mVar;
        return mVar;
    }

    private void nh() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.Gf.Fq;
        if (aVar != null) {
            aVar.nk();
        }
    }

    @NonNull
    private u ni() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3
            @Override // com.kwad.components.core.webview.tachikoma.b.u.a
            public final void a(final u.b bVar) {
                int i6 = bVar.status;
                if (i6 == 1) {
                    a.this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            if (com.kwad.components.core.e.c.b.oW()) {
                                a.this.Gf.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                a.this.Gf.lQ();
                            }
                        }
                    });
                    return;
                }
                if (i6 == 2) {
                    a.this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.2
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.components.ad.splashscreen.monitor.a.lX().ah(a.this.Gf.mAdTemplate);
                            a.this.Gf.lS();
                        }
                    });
                } else if (i6 == 3) {
                    a.this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.3
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.this.Gf.lH();
                        }
                    });
                } else if (i6 == 4) {
                    a.this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.4
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            h hVar = a.this.Gf;
                            u.b bVar2 = bVar;
                            hVar.c(bVar2.errorCode, bVar2.errorMsg);
                        }
                    });
                }
            }
        });
        return uVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        this.cV.setVisibility(8);
        nh();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        az azVar;
        if (this.Gf.bO) {
            return;
        }
        az azVar2 = this.cX;
        if (azVar2 != null) {
            azVar2.uF();
            this.cX.uG();
        }
        if (this.Je && (azVar = this.cX) != null) {
            azVar.uJ();
        }
        this.cV.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        if (this.Gf.bO) {
            return;
        }
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uJ();
        } else {
            this.Je = true;
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        az azVar;
        if (this.Gf.bO || (azVar = this.cX) == null) {
            return;
        }
        azVar.uK();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.cV;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cr(this.Gf.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        super.onUnbind();
        this.Gf.Fs.b(this);
        this.Gf.b(this.Ix);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        h hVar = this.Gf;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.Fr);
        this.Gf.Fs.a(this);
        this.Gf.a(this.Ix);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    protected final int nf() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Gf;
        return (int) (com.kwad.sdk.core.response.b.b.dw(hVar.mAdTemplate) - (elapsedRealtime - hVar.Fz));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cV = (FrameLayout) findViewById(R.id.splash_full_tk_play_card_view);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Gf.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Gf.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.cX = azVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
        tVar.c(ng());
        tVar.c(ni());
        tVar.c(new j(new p() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(j jVar, String str) {
                if (TextUtils.equals(str, "getSplashShowStartTime")) {
                    jVar.P(a.this.Gf.mAdTemplate.showTime);
                }
            }
        }));
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.Gf.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.Gf.mRootContainer.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.this.Gf.X();
                        }
                    });
                }
            }
        });
    }
}
