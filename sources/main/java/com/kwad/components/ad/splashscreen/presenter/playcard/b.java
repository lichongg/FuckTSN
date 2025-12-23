package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.s;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends e {
    private com.kwad.components.core.o.a.e.b IH;
    private long II;
    private volatile boolean IJ = false;
    private g mq = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.1
        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j6, long j7, long j8) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.dK(b.this.Gf.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.a(b.this.Gf.mAdTemplate, b.this.Gf.Fr, b.this.Gf.FA, b.this.Gf.FC, b.this.Gf.FB, b.this.Gf.FD, j6, j7, j8, SystemClock.elapsedRealtime() - b.this.II);
            b.this.Gf.FE = j6;
            b.this.Gf.FF = j7;
            b.this.Gf.FG = j8;
            bw.c(b.this.IK);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void v(String str) {
            b.this.Gf.bO = true;
            if ("tk_splash".equals(str)) {
                b.this.na();
            }
        }
    };
    private final Runnable IK = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!b.this.IJ) {
                b.this.mZ();
                return;
            }
            b.this.Gf.bO = true;
            b.this.na();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.c(b.this.Gf.mAdTemplate, b.this.Gf.Fr);
        }
    };
    private com.kwad.components.core.o.a.e.a IL = new com.kwad.components.core.o.a.e.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.3
        @Override // com.kwad.components.core.o.a.e.a
        public final void a(int i6, int i7, long j6, long j7) {
            b.this.Gf.FA = i6;
            b.this.Gf.FB = i7;
            b.this.Gf.FC = j6;
            b.this.Gf.FD = j7;
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.g(b.this.Gf.mAdTemplate, SystemClock.elapsedRealtime() - b.this.II);
            b.this.mZ();
        }
    };

    private void mY() {
        com.kwad.components.core.o.a.e.b bVar = (com.kwad.components.core.o.a.e.b) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.e.b.class);
        this.IH = bVar;
        if (bVar != null) {
            bVar.a(this.IL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mZ() {
        if (this.IJ) {
            return;
        }
        this.IJ = true;
        if (nb()) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new d(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na() {
        if (com.kwad.sdk.core.response.b.b.dT(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            h hVar = this.Gf;
            if (hVar.Fx) {
                return;
            }
            hVar.Fx = true;
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new s(), true);
                }
            });
        }
    }

    private boolean nb() {
        if (!com.kwad.sdk.core.config.e.Fq()) {
            return false;
        }
        return com.kwad.sdk.core.response.b.b.dB(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate));
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.II = SystemClock.elapsedRealtime();
        if (nb()) {
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            h hVar = this.Gf;
            com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Fr);
            h hVar2 = this.Gf;
            hVar2.Fz = this.II;
            bw.runOnUiThreadDelay(this.IK, com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(hVar2.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.e.c.vO().a(this.mq);
        }
        if (com.kwad.sdk.core.config.e.Fq()) {
            mY();
        } else {
            na();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.o.a.e.b bVar = this.IH;
        if (bVar != null) {
            bVar.b(this.IL);
        }
        if (nb()) {
            bw.c(this.IK);
            com.kwad.components.core.webview.tachikoma.e.c.vO().b(this.mq);
        }
    }
}
