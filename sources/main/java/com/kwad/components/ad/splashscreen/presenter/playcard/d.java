package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.b.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.a.c implements g, com.kwad.sdk.core.j.c {
    f Ix = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.2
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lC() {
            d.this.cV.setVisibility(8);
            if (d.this.cX != null) {
                d.this.cX.uH();
                d.this.cX.uI();
            }
        }
    };
    private m Jb;
    private FrameLayout cV;
    private az cX;

    @NonNull
    private m ng() {
        m mVar = new m();
        this.Jb = mVar;
        return mVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        this.cV.setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i6) {
        m mVar = this.Jb;
        if (mVar != null) {
            mVar.bj(i6);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        if (this.Gf.bO) {
            return;
        }
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uF();
            this.cX.uG();
        }
        this.cV.setVisibility(0);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        az azVar;
        if (this.Gf.bO || (azVar = this.cX) == null) {
            return;
        }
        azVar.uJ();
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
        return com.kwad.sdk.core.response.b.b.dK(this.Gf.mAdTemplate);
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
        this.Gf.b(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        h hVar = this.Gf;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.Fr);
        this.Gf.Fs.a(this);
        this.Gf.a(this);
        this.Gf.a(this.Ix);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int nf() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Gf;
        return (int) (com.kwad.sdk.core.response.b.b.dG(e.el(hVar.mAdTemplate)) - (elapsedRealtime - hVar.Fz));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cV = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
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
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.Gf.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    d.this.Gf.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.this.Gf.X();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lG() {
    }
}
